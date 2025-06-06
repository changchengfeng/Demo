package top.greatfeng.user.intent


sealed class UiIntent {
    data class LoadUserData(val username: String) : UiIntent()
}