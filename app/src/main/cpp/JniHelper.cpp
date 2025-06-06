
#include "JniHelper.h"

#include <cstring>
#include "Log.h"
#include <string>
#include <pthread.h>
#include <unistd.h>

JavaVM *globalVM = nullptr;
jobject classLoader = nullptr;

JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM *vm, void *reserved) {
    LOGD("JNI_OnLoad ... ");
    JNIEnv *env = NULL;
    globalVM = vm;
    if (vm->GetEnv((void **) &env, JNI_VERSION_1_2) != JNI_OK) {
        LOGE("JNI_OnLoad GetEnv Error");
        return JNI_ERR;
    }
    return JNI_VERSION_1_2;
}


JNIEXPORT void JNI_OnUnload(JavaVM *vm, void *reserved) {
    LOGD("JNI_OnUnload ... ");
    globalVM = nullptr;
}

 inline int jniRegisterNativeMethods(JNIEnv *env, const char *className,
                                           const JNINativeMethod *gMethods, int numMethods) {
    jclass c = env->FindClass(className);

    if (env->RegisterNatives(c, gMethods, numMethods) < 0) {
        char *tmp;
        const char *msg;
        if (asprintf(&tmp, "RegisterNatives failed for '%s'; aborting...", className) == -1) {
            // Allocation failed, print default warning.
            msg = "RegisterNatives failed; aborting...";
        } else {
            msg = tmp;
        }
        env->FatalError(msg);
    }

    return 0;
}

jclass findClass(const char * className,JNIEnv *env){
    if (classLoader != nullptr && env!= nullptr){
        jclass cls = env->GetObjectClass(classLoader);
        if (cls == nullptr){
            return nullptr;
        }
        jmethodID loadClassMID = env->GetMethodID(cls,"loadClass","(Ljava/lang/String;)Ljava/lang/Class;");
        LOGD("findClass : className %s",className);
        jstring jName = env->NewStringUTF(className);
        jobject jobj = env->CallObjectMethod(classLoader, loadClassMID,jName);
        if (env->ExceptionCheck()) {
            env->ExceptionDescribe();
            env->ExceptionClear();
            return nullptr;
        }
        return static_cast<jclass>(jobj);
    }
    return nullptr;
}

void printClass(jclass clz ,JNIEnv * env){
    if (clz == nullptr){
        return;
    }
    jmethodID getNameMID = env->GetMethodID(env->GetObjectClass(clz),"getName","()Ljava/lang/String;");
    jstring jobj = static_cast<jstring>(env->CallObjectMethod(clz, getNameMID));
    if (jobj == nullptr){
        return;
    }
    jboolean isCopy;
    const char* name = env->GetStringUTFChars(jobj,&isCopy);
    LOGD("printClass jclass name %s",name);
    env->ReleaseStringUTFChars(jobj,name);
}

void printObjClass(jobject jobj,JNIEnv * env){
    jclass  clz = env->GetObjectClass(jobj);
    printClass(clz,env);
}

extern "C"
JNIEXPORT void JNICALL
Java_top_greatfeng_demo_JniHelper_jniSetupClassloader(JNIEnv *env, jobject thiz, jclass jcls) {

    jclass  clz = env->GetObjectClass(jcls);
    jmethodID  classLoaderMid = env->GetMethodID(clz, "getClassLoader", "()Ljava/lang/ClassLoader;");
    classLoader = env->NewGlobalRef(env->CallObjectMethod(clz, classLoaderMid));
}
extern "C"
JNIEXPORT void JNICALL
Java_top_greatfeng_demo_JniHelper_setLogEnable(JNIEnv *env, jobject thiz, jboolean enable) {
    setLogEnable(enable);
}