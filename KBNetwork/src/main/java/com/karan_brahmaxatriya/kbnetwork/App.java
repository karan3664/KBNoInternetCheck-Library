package com.karan_brahmaxatriya.kbnetwork;

import android.app.Application;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.util.Log;

import java.util.Objects;

public class App extends Application {

    private static final String TAG = "KBNetworkCheckApplication";
    private KBNetworkCheck kbNetworkCheck;

    private KBNetworkCheck getEagleEyeObserver() {
        if (kbNetworkCheck == null)
            kbNetworkCheck = new KBNetworkCheck();
        return kbNetworkCheck;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        registerConnectivityReceiver();
    }

    // register here your filter
    private void registerConnectivityReceiver() {
        try {
            IntentFilter filter = new IntentFilter();
            filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
            registerReceiver(getEagleEyeObserver(), filter);
        } catch (Exception e) {
            Log.e(TAG, Objects.requireNonNull(e.getMessage()));
        }
    }

}