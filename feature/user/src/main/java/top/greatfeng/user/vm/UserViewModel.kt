package top.greatfeng.user.vm

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import top.greatfeng.network.annotations.Impl
import top.greatfeng.user.data.UserRepository
import top.greatfeng.user.intent.UiIntent
import top.greatfeng.user.uistatus.UserUiStatus
import top.greatfeng.viewmodel.BaseViewModel
import top.greatfeng.viewmodel.UiState
import javax.inject.Inject


@HiltViewModel
class UserViewModel @Inject constructor(
   @Impl val userRepository: UserRepository
) : BaseViewModel() {


    private val _userUiStatus = MutableStateFlow<UserUiStatus>(UserUiStatus.Idle)

    val userUiStatus: StateFlow<UserUiStatus> = _userUiStatus
        get() = field


    fun processIntent(intent: UiIntent) {
        when (intent) {
            is UiIntent.LoadUserData -> loadUserData(intent.username)
        }
    }

    private fun loadUserData(username: String) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            val result = runCatching { userRepository.getUser(username) }
            _userUiStatus.value = result.fold(
                onSuccess = { UserUiStatus.Success(it) },
                onFailure = { UserUiStatus.Error(it.message ?: "Unknown error") }
            )
        }
    }
}