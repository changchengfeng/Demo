package top.greatfeng.viewmodel


sealed class UiState {
    object Loading : UiState()
    object Idle : UiState()
}
