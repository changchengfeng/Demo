package top.greatfeng.viewmodel


sealed class UiState {
    object Loading : UiState()
    data class Error(val message: String) : UiState()
    object Idle : UiState()
}
