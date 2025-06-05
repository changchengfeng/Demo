package top.greatfeng.base.app

import android.app.Application
import android.content.Context
import top.greatfeng.base.utils.LogUtil

open class BaseApplication : Application() {
    private val TAG = this::class.java.name

    companion object {
        private lateinit var instance: Context

        fun getContext(): Context {
            return instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        LogUtil.d(TAG, "onCreate() called")
        instance = this.applicationContext
    }
}