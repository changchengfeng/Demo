package top.greatfeng.viewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import top.greatfeng.base.app.BaseFragment
import java.lang.reflect.ParameterizedType

abstract class ViewModelFragment<VM : BaseViewModel, VB : ViewBinding> : BaseFragment() {
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
        viewModel = ViewModelProvider(viewModelStore, defaultViewModelProviderFactory).get(
            getViewModelCls()
        ) as VM
        viewModel.initViewModel()
    }

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
}