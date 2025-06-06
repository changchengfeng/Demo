package top.greatfeng.base.ext

import android.os.Looper
import android.widget.Toast
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import top.greatfeng.base.app.BaseApplication


fun String.toast() {
    if (Looper.myLooper() === Looper.getMainLooper()) {
        Toast.makeText(BaseApplication.getContext(), this@toast, Toast.LENGTH_SHORT).show()
    } else {
        GlobalScope.launch {
            withContext(Dispatchers.Main) {
                Toast.makeText(BaseApplication.getContext(), this@toast, Toast.LENGTH_SHORT).show()
            }
        }
    }
}