package top.greatfeng.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import top.greatfeng.base.ext.toast
import top.greatfeng.user.databinding.FragmentUserBinding
import top.greatfeng.user.intent.UiIntent
import top.greatfeng.user.uistatus.UserUiStatus
import top.greatfeng.user.vm.UserViewModel
import top.greatfeng.viewmodel.ViewModelFragment


@AndroidEntryPoint
class UserFragment : ViewModelFragment<UserViewModel, FragmentUserBinding>() {

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentUserBinding {
        return FragmentUserBinding.inflate(inflater, container, false)
    }

    override fun initView() {
        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.userUiStatus.collect { status ->
                    when (status) {
                        is UserUiStatus.Success -> {
                            binding.sampleText.text = Json.encodeToString(status.user)
                        }

                        is UserUiStatus.Error -> status.message.toast()
                        is UserUiStatus.Idle -> {

                        }
                    }
                }
            }
        }
    }

    fun onClick(view: View) {
        val username = binding.editTextText.text.toString()
        viewModel.processIntent(UiIntent.LoadUserData(username))
    }
}