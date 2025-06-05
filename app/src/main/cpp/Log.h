
#include <android/log.h>

#ifndef _LOG_H_
#define _LOG_H_


#define LOG_TAG "JNI-LOG"

//LOG控制开关 1-打开，0-关闭
static bool ENABLE = 1;

 void setLogEnable(bool enable);

 void v(const char *tag , const char *fmt , ...);
 void d(const char *tag , const char *fmt , ...);
 void i(const char *tag , const char *fmt , ...);
 void w(const char *tag , const char *fmt , ...);
 void e(const char *tag , const char *fmt , ...);

#define LOGV(fmt, ...) v(LOG_TAG, fmt, ##__VA_ARGS__)
#define LOGD(fmt, ...) d(LOG_TAG, fmt, ##__VA_ARGS__)
#define LOGI(fmt, ...) i(LOG_TAG, fmt, ##__VA_ARGS__)
#define LOGW(fmt, ...) w(LOG_TAG, fmt, ##__VA_ARGS__)
#define LOGE(fmt, ...) e(LOG_TAG, fmt, ##__VA_ARGS__)

#endif /* _LOG_H_ */