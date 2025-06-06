package top.greatfeng.demo

import dagger.hilt.android.HiltAndroidApp
import top.greatfeng.base.app.BaseApplication

@HiltAndroidApp
class App : BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        JniHelper.initJni()
    }
}