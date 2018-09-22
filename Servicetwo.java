package com.wallpapernote.plutopix.wallpaperorganizer;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;


public class Servicetwo extends Service {

    private BroadcasterTwo launcher;
    private Servicethree mServicethree;


    //<uses-permission android:name="android.permission.SYSTEM_ALERT_WINDOW"/>

    @Override
    public void onCreate() {
        super.onCreate();

        launcher = new BroadcasterTwo();
        IntentFilter i=new IntentFilter(Intent.ACTION_SCREEN_OFF);
        //i.addAction(Intent.ACTION_SCREEN_ON);
        registerReceiver(launcher,i);


    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(launcher);
    }
}
