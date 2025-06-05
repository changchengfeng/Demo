package top.greatfeng.base.app

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import top.greatfeng.base.utils.LogUtil

open class BaseFragment : Fragment() {

    private val TAG = this::class.java.name

    override fun onAttach(context: Context) {
        super.onAttach(context)
        LogUtil.i(TAG, "onAttach: ")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogUtil.i(TAG, "onCreate() called with: savedInstanceState = $savedInstanceState")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        LogUtil.i(TAG, "onCreateView: ")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        LogUtil.i(TAG, "onViewCreated: ")
    }

    override fun onStart() {
        super.onStart()
        LogUtil.i(TAG, "onStart() called")
    }


    override fun onResume() {
        super.onResume()
        LogUtil.i(TAG, "onResume() called")
    }

    override fun onPause() {
        super.onPause()
        LogUtil.i(TAG, "onPause() called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        LogUtil.i(TAG, "onSaveInstanceState() called with: outState = $outState")
    }


    override fun onStop() {
        super.onStop()
        LogUtil.i(TAG, "onStop() called")
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
        LogUtil.i(TAG, "onDestroy() called")
    }

    override fun onDetach() {
        super.onDetach()
        LogUtil.i(TAG, "onDetach: ")
    }


}