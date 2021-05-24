package com.example.nearby.utils;

import android.content.Context;
import android.content.res.Configuration;

import java.util.Locale;

import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.ProcessLifecycleOwner;
import androidx.multidex.MultiDexApplication;

public class MainApplication extends MultiDexApplication implements LifecycleObserver {

    private static Context appContext;
    private static MainApplication instance;
    public static synchronized MainApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);

      //  DroidNet.init(this);
        appContext = getApplicationContext();
    }
        @Override
        protected void attachBaseContext(Context base) {
            super.attachBaseContext(base);
            //MultiDex.install(this);
        }

        public static Context getAppContext() {
            return appContext;
        }



}
