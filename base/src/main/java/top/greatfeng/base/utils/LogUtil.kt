package top.greatfeng.base.utils

import android.util.Log

object LogUtil {

    var isPrint = true
        get() = field
        set(value) {
            field = value
        }

    fun v(tag: String, msg: String) {
        if (isPrint) {
            Log.v(tag, msg)
        }
    }

    fun i(tag: String, msg: String) {
        if (isPrint) {
            Log.i(tag, msg)
        }
    }

    fun w(tag: String, msg: String) {
        if (isPrint) {
            Log.w(tag, msg)
        }
    }

    fun d(tag: String, msg: String) {
        if (isPrint) {
            Log.d(tag, msg)
        }
    }

    fun e(tag: String, msg: String, e: Throwable) {
        if (isPrint) {
            Log.e(tag, msg, e)
        }
    }

    fun file(tag: String, msg: String) {

    }

    fun json(tag: String, msg: Any) {

    }
}