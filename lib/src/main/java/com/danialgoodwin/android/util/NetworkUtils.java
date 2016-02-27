/**
 * Created by Danial Goodwin on 2015-07-01.
 */
package com.danialgoodwin.android.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.v4.net.ConnectivityManagerCompat;

/** Helper methods related to network.
 *
 * Use of this class requires the following permission:
 * - {@link android.Manifest.permission#ACCESS_NETWORK_STATE}
 */
public class NetworkUtils {

    private static NetworkUtils mNetworkUtils;
    private ConnectivityManager mConnectivityManager;

    /** Use `getInstance()` to instantiate this class. */
    private NetworkUtils(@NonNull Context appContext) {
        mConnectivityManager = (ConnectivityManager) appContext.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    /** Return an instance of this class.
     * @param context the application context will be used */
    public static NetworkUtils getInstance(@NonNull Context context) {
        if (mNetworkUtils == null) {
            mNetworkUtils = new NetworkUtils(context.getApplicationContext());
        }
        return mNetworkUtils;
    }

    /** Return true if device is connected to Internet, otherwise false. */
    public boolean isConnectedToInternet() {
        NetworkInfo networkInfo = mConnectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    /** Return true if device is connected to mobile network, otherwise false. */
    public boolean isConnectedToMobile() {
        return mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnected();
    }

    /** Return true if device is connected to Wi-Fi network, otherwise false. */
    public boolean isConnectedToWifi() {
        return mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnected();
    }

    /**
     * Return true if the currently active data network is metered, otherwise false. A network is
     * classified as metered when the user is sensitive to heavy data usage on
     * that connection. You should check this before doing large data transfers,
     * and warn the user or delay the operation until another network is
     * available.
     */
    public boolean isActiveNetworkMetered() {
//        if (AndroidVersionUtils.IS_API_16_OR_ABOVE) {
//            return mConnectivityManager.isActiveNetworkMetered();
//        } else {
            return ConnectivityManagerCompat.isActiveNetworkMetered(mConnectivityManager);
//        }
    }

}
