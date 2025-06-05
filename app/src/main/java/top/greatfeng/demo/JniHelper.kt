package top.greatfeng.demo

import top.greatfeng.base.utils.LogUtil
import kotlin.jvm.java


object JniHelper {

    init {
        System.loadLibrary("demo")
    }

    fun initJni() {
        jniSetupClassloader(JniHelper::class.java)
        setLogEnable(LogUtil.isPrint)
    }

    private external fun jniSetupClassloader(clz: Class<*>)
    private external fun setLogEnable(boolean: Boolean)
}