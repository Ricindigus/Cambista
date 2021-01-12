package com.ricindigus.cambista.datasource.remote.service

import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

/**
 * Checks the Internet connection and performs an action if it's active.
 */
class NetworkStatusChecker(private val connectivityManager: ConnectivityManager?) {

  inline fun performIfConnectedToInternet(action: () -> Unit) {
    if (hasInternetConnection()) {
      action()
    }
  }

  fun hasInternetConnection(): Boolean {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      val network =  connectivityManager?.activeNetwork ?: return false
      val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
      return capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
              || capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
              || capabilities.hasTransport(NetworkCapabilities.TRANSPORT_VPN)
    } else {
      val network = connectivityManager?.activeNetworkInfo ?: return false
      return network.type == ConnectivityManager.TYPE_WIFI
              || network.type == ConnectivityManager.TYPE_MOBILE
              || network.type == ConnectivityManager.TYPE_VPN
    }
  }
}
