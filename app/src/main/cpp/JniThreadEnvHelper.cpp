

#include <cstdlib>
#include "JniThreadEnvHelper.h"

JniThreadEnvHelper::JniThreadEnvHelper() {
    needDetach = false;
    if (globalVM != nullptr) {
        jint status = globalVM->GetEnv((void **) &env, JNI_VERSION_1_2);
        if (status == JNI_EDETACHED && globalVM->AttachCurrentThread(&env, NULL) == JNI_OK) {
            LOGD("JniThreadEnvHelper AttachCurrentThread");
            needDetach = true;
        }
    } else {
        LOGE("globalVM == nullptr Error");
        exit(-1);
    }

}

JniThreadEnvHelper::~JniThreadEnvHelper() {
    if (needDetach) {
        LOGD("JniThreadEnvHelperHelper DetachCurrentThread");
        if (globalVM->DetachCurrentThread() != JNI_OK) {
            LOGE("JniThreadEnvHelper AttachCurrentThread Error");
            exit(-1);
        }
    }

}

JNIEnv *JniThreadEnvHelper::getEnv() {
    return env;
}
