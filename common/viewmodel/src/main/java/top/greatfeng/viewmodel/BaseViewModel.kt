package top.greatfeng.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class BaseViewModel : ViewModel() {

    protected val _uiState = MutableStateFlow<UiState>(UiState.Idle)

    val uiState: StateFlow<UiState> = _uiState
        get() = field

    fun onCreateView() {

    }

    fun onDestroyView() {

    }


    fun onCreate() {

    }

    fun onDestroy() {

    }


}