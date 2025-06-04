package top.greatfeng.base.app

import android.app.Application
import android.content.Context

open class BaseApplication : Application() {
    companion object {
        private lateinit var instance: Context

        fun getContext(): Context {
            return instance
        }
    }
    override fun onCreate() {
        super.onCreate()
        instance = this.applicationContext
    }
}