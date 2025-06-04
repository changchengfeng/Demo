package top.greatfeng.permission

import android.app.Activity
import com.hjq.permissions.OnPermissionCallback
import com.hjq.permissions.Permission
import com.hjq.permissions.XXPermissions

object PermissionHelper {

    fun requestRecordPermission(activity: Activity, callback: OnPermissionCallback) {
        requestPermission(activity, callback, Permission.RECORD_AUDIO)
    }

    private fun requestPermission(
        activity: Activity,
        callback: OnPermissionCallback,
        vararg permissions: String
    ) {
        XXPermissions.with(activity)
            // 申请单个权限
            .permission(permissions.toList())
            .request(callback)
    }
}