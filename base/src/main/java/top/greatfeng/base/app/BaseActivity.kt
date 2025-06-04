package top.greatfeng.base.app

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import top.greatfeng.base.utils.LogUtl

open class BaseActivity : AppCompatActivity() {

    private val TAG = this::class.java.name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogUtl.i(TAG, "onCreate() called with: savedInstanceState = $savedInstanceState")
    }

    override fun onStart() {
        super.onStart()
        LogUtl.i(TAG, "onStart() called")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        LogUtl.i(
            TAG,
            "onRestoreInstanceState() called with: savedInstanceState = $savedInstanceState"
        )
    }


    override fun onResume() {
        super.onResume()
        LogUtl.i(TAG, "onResume() called")
    }

    override fun onPause() {
        super.onPause()
        LogUtl.i(TAG, "onPause() called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        LogUtl.i(TAG, "onSaveInstanceState() called with: outState = $outState")
    }


    override fun onStop() {
        super.onStop()
        LogUtl.i(TAG, "onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        LogUtl.i(TAG, "onDestroy() called")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        LogUtl.i(TAG, "onConfigurationChanged() called with: newConfig = $newConfig")
    }

}