package top.greatfeng.viewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import top.greatfeng.base.app.BaseFragment
import java.lang.reflect.ParameterizedType


const val VARIABLE_ID = 1

abstract class ViewModelFragment<VM : BaseViewModel, VB : ViewDataBinding> : BaseFragment() {
    protected lateinit var viewModel: VM
    protected lateinit var binding: VB

    abstract fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = getViewBinding(inflater, container, savedInstanceState)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(
            getViewModelCls()
        )
        viewModel.onCreateView()
        binding.setLifecycleOwner(getViewLifecycleOwner())
        binding.setVariable(VARIABLE_ID, this)
        lifecycleScope.launch {
            viewModel.uiState.collect { status ->
                when (status) {
                    UiState.Idle -> {}
                    UiState.Loading -> {

                    }
                }
            }
        }
        initView()
    }

    abstract fun initView()

    fun getViewModelCls(): Class<VM> {
        var currentClass: Class<*>? = this::class.java
        while (currentClass != null) {
            val genericSuper = currentClass.genericSuperclass
            if (genericSuper is ParameterizedType) {
                val vmType = genericSuper.actualTypeArguments[0]
                if (vmType is Class<*> && BaseViewModel::class.java.isAssignableFrom(vmType)) {
                    return vmType as Class<VM>
                }
            }
            currentClass = currentClass.superclass
        }
        throw IllegalArgumentException("No BaseViewModel subclass found in generic parameters")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.unbind()
        viewModel.onDestroyView()
    }
}