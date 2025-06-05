//
// Created by Macbook Pro on 2020/9/23.
//


#include <jni.h>

extern JavaVM *globalVM;
extern jobject classLoader;

#ifdef __cplusplus
extern "C" {
#endif

 inline int jniRegisterNativeMethods(JNIEnv *env, const char *className,
                             const JNINativeMethod *gMethods, int numMethods);
 inline jclass findClass(const char *className, JNIEnv *env);

 inline void printClass(jclass, JNIEnv *);

 inline void printObjClass(jobject, JNIEnv *);

#ifdef __cplusplus
}
#endif


