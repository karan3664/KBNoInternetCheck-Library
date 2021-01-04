package com.karan_brahmaxatriya.kbnetwork;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.net.InetAddress;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Karan Brahmaxatriya on 04,Jan,2021
 */
public class KBNetworkCheck  extends BroadcastReceiver {
    private static final String TAG = "ConnectivityReceiver";
    private boolean accessible;
    private static OnChangeConnectivityListener onChangeConnectivity;

    public static void setConnectivityListener(OnChangeConnectivityListener connectivity) {
        onChangeConnectivity = connectivity;
    }

    @Override
    public void onReceive(final Context context, final Intent intent) {
        //Log.v(TAG, "onReceiveAction = " + intent.getAction());
        if (intent.getExtras() != null) {
            ConnectivityManager cm =
                    (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            assert cm != null;
            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            boolean isConnected = activeNetwork != null &&
                    activeNetwork.isConnectedOrConnecting();

            if (onChangeConnectivity != null) {
                onChangeConnectivity.onChanged(isConnected);
            }

        }
    }


}