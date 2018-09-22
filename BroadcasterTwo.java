package com.wallpapernote.plutopix.wallpaperorganizer;



import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;


import java.util.Calendar;


public class BroadcasterTwo extends BroadcastReceiver {
    private SharedPreferences mSharedPreferences;


    @Override
    public void onReceive(final Context context, Intent intent) {

        final Intent service2 = new Intent(context, Servicetwo.class);
        final Intent servicethree = new Intent(context, Servicethree.class);
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        boolean toOrNot = mSharedPreferences.getBoolean(Settings.TOBROADCAST, false);
        switch (intent.getAction()){
            case Intent.ACTION_SCREEN_OFF:
                rebootYear();
                context.stopService(service2);
                if(toOrNot){
                    context.startService(servicethree);
                }

                break;
            case Intent.ACTION_SCREEN_ON:

                KeyguardManager mKeyguardManager = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);
                boolean isLocked = mKeyguardManager.isKeyguardLocked();
                if(!isLocked){
                    context.stopService(servicethree);
                    context.startService(service2);
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        context.stopService(servicethree);
                        context.startService(service2);
                    }
                },3000);

                break;
            case Intent.ACTION_USER_PRESENT:

                context.stopService(servicethree);
                context.startService(service2);
                break;
        }



    }

    public void rebootYear(){
        Calendar mCalendar = Calendar.getInstance();
        int year = mCalendar.get(Calendar.YEAR);
        int month = mCalendar.get(Calendar.MONTH);
        int day = mCalendar.get(Calendar.DAY_OF_MONTH);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putInt(MainActivity.NOWYEAR,year);
        editor.putInt(MainActivity.NOWMONTH,month);
        editor.putInt(MainActivity.NOWDAY,day);
        editor.commit();

    }
}
