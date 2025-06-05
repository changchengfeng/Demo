package top.greatfeng.network

import android.net.ConnectivityManager
import android.net.ConnectivityManager.NetworkCallback
import android.net.Network
import android.net.NetworkCapabilities
import android.util.Log
import androidx.annotation.NonNull
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import top.greatfeng.base.app.BaseApplication
import top.greatfeng.base.utils.LogUtil


object NetworkStatusUtil {

    private const val TAG = "NetworkStatusUtil"

    const val AVAILABLE: Int = 0
    const val UNAVAILABLE: Int = 1

    init {
        val connectivityManager: ConnectivityManager =
            BaseApplication.getContext().getSystemService(ConnectivityManager::class.java)
        connectivityManager.registerDefaultNetworkCallback(object : NetworkCallback() {
            override fun onLost(@NonNull network: Network) {
                LogUtil.d(TAG, "onLost() called with: network = [$network]")
                GlobalScope.launch {
                    notifyNetworkState()
                }
            }

            override fun onCapabilitiesChanged(
                @NonNull network: Network,
                @NonNull networkCapabilities: NetworkCapabilities
            ) {
                Log.d(
                    TAG, ("onCapabilitiesChanged() called with: network = ["
                            + network + "], networkCapabilities = [" + networkCapabilities + "]")
                )
                GlobalScope.launch {
                    notifyNetworkState()
                }
            }
        })
    }

    fun isNetworkAvailable(): Boolean {
        val connectivityManager =
            BaseApplication.getContext().getSystemService(ConnectivityManager::class.java)
        val network = connectivityManager.activeNetwork
        val capabilities = connectivityManager.getNetworkCapabilities(network)
        return capabilities != null
                && capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }


     private suspend fun notifyNetworkState(){
        _networkState.emit(if (isNetworkAvailable()) AVAILABLE else UNAVAILABLE)
    }

   private val _networkState = MutableSharedFlow<Int>()

    val networkState: SharedFlow<Int> = _networkState
        get() = field



}