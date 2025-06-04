package top.greatfeng.base.app

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import top.greatfeng.base.utils.LogUtl

open class BaseFragment : Fragment() {

    private val TAG = this::class.java.name

    override fun onAttach(context: Context) {
        super.onAttach(context)
        LogUtl.i(TAG, "onAttach: ")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogUtl.i(TAG, "onCreate() called with: savedInstanceState = $savedInstanceState")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        LogUtl.i(TAG, "onCreateView: ")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        LogUtl.i(TAG, "onViewCreated: ")
    }

    override fun onStart() {
        super.onStart()
        LogUtl.i(TAG, "onStart() called")
    }


    override fun onResume() {
        super.onResume()
        LogUtl.i(TAG, "onResume() called")
    }

    override fun onPause() {
        super.onPause()
        LogUtl.i(TAG, "onPause() called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        LogUtl.i(TAG, "onSaveInstanceState() called with: outState = $outState")
    }


    override fun onStop() {
        super.onStop()
        LogUtl.i(TAG, "onStop() called")
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
        LogUtl.i(TAG, "onDestroy() called")
    }

    override fun onDetach() {
        super.onDetach()
        LogUtl.i(TAG, "onDetach: ")
    }


}