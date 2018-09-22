package com.wallpapernote.plutopix.wallpaperorganizer;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.PixelFormat;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;


public class Servicethree extends Service {
    private BroadcasterTwo mBroadcasterTwo;
    private WindowManager wm;
    private ImageView image;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mBroadcasterTwo = new BroadcasterTwo();
        IntentFilter i=new IntentFilter(Intent.ACTION_SCREEN_ON);
        registerReceiver(mBroadcasterTwo,i);


         wm = (WindowManager)getSystemService(Context.WINDOW_SERVICE);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.TOP|Gravity.START;
        lp.type = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
        lp.format = PixelFormat.TRANSLUCENT;
        lp.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
          image = new ImageView(this);
        image.setImageResource(R.drawable.ic_icon_marron2);
        wm.addView(image,lp);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Servicethree.this,MainActivity.class);
                Log.d("TAG", "Broadcaster2 on: ");
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        });
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        wm.removeView(image);
        unregisterReceiver(mBroadcasterTwo);
        Log.d("TAG", "onDestroy: service stopped");
    }
}
