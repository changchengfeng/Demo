//
// Created by Macbook Pro on 2020/10/28.
//

#ifndef INFORECORD_JNIENVHELPER_H
#define INFORECORD_JNIENVHELPER_H


#include <jni.h>
#include "Log.h"
#include "JniHelper.h"

class JniThreadEnvHelper {
public:

    JniThreadEnvHelper();
    ~JniThreadEnvHelper();
    JNIEnv * getEnv();
private:
    JNIEnv *env;
    bool needDetach ;
};
#endif //INFORECORD_JNIENVHELPER_H
