package top.greatfeng.viewmodel

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import top.greatfeng.base.app.BaseActivity
import java.lang.reflect.ParameterizedType

abstract class ViewModelActivity<VM : BaseViewModel, VB : ViewBinding> : BaseActivity() {
    protected lateinit var viewModel: VM
    protected lateinit var binding: VB
    abstract fun getViewBinding(): VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(
            getViewModelCls()
        )
        viewModel.onCreate()
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

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDestroy()
    }
}