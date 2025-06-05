package top.greatfeng.base.app

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import top.greatfeng.base.utils.LogUtil

open class BaseActivity : AppCompatActivity() {

    private val TAG = this::class.java.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogUtil.i(TAG, "onCreate() called with: savedInstanceState = $savedInstanceState")
    }

    override fun onStart() {
        super.onStart()
        LogUtil.i(TAG, "onStart() called")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        LogUtil.i(
            TAG,
            "onRestoreInstanceState() called with: savedInstanceState = $savedInstanceState"
        )
    }


    override fun onResume() {
        super.onResume()
        LogUtil.i(TAG, "onResume() called")
    }

    override fun onPause() {
        super.onPause()
        LogUtil.i(TAG, "onPause() called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        LogUtil.i(TAG, "onSaveInstanceState() called with: outState = $outState")
    }


    override fun onStop() {
        super.onStop()
        LogUtil.i(TAG, "onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        LogUtil.i(TAG, "onDestroy() called")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        LogUtil.i(TAG, "onConfigurationChanged() called with: newConfig = $newConfig")
    }

}