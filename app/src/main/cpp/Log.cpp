#include "Log.h"


 void setLogEnable(bool enable) {
    ENABLE = enable;
}

 void v(const char *tag, const char *fmt, ...) {
    if (ENABLE) {
        va_list args;
        va_start(args, fmt);
        __android_log_vprint(ANDROID_LOG_VERBOSE, tag, fmt, args);
        va_end(args);
    }
}

 void d(const char *tag, const char *fmt, ...) {
    if (ENABLE) {
        va_list args;
        va_start(args, fmt);
        __android_log_vprint(ANDROID_LOG_DEBUG, tag, fmt, args);
        va_end(args);
    }
}


 void i(const char *tag, const char *fmt, ...) {
    if (ENABLE) {
        va_list args;
        va_start(args, fmt);
        __android_log_vprint(ANDROID_LOG_INFO, tag, fmt, args);
        va_end(args);
    }
}

 void w(const char *tag, const char *fmt, ...) {
    if (ENABLE) {
        va_list args;
        va_start(args, fmt);
        __android_log_vprint(ANDROID_LOG_WARN, tag, fmt, args);
        va_end(args);
    }
}

 void e(const char *tag, const char *fmt, ...) {
    if (ENABLE) {
        va_list args;
        va_start(args, fmt);
        __android_log_vprint(ANDROID_LOG_ERROR, tag, fmt, args);
        va_end(args);
    }
}


