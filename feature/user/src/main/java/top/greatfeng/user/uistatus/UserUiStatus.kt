package top.greatfeng.user.uistatus

import top.greatfeng.user.model.User

sealed class UserUiStatus {
    data class Success(val user: User) : UserUiStatus()
    data class Error(val message: String) : UserUiStatus()
    object Idle : UserUiStatus()
}