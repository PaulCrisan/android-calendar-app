package com.wallpapernote.plutopix.wallpaperorganizer;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;


public class ServiceOfIntent extends IntentService {

    WindowManager wm1;
    ImageView im;
    public ServiceOfIntent(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }

    @Override
    public void onCreate() {
        super.onCreate();

        wm1 = (WindowManager)getSystemService(Context.WINDOW_SERVICE);
        WindowManager.LayoutParams lpar = new WindowManager.LayoutParams();
        lpar.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lpar.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lpar.gravity = Gravity.TOP|Gravity.END;
        lpar.type = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
        lpar.format = PixelFormat.TRANSLUCENT;
        lpar.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        im = new ImageView(this);
        im.setImageResource(R.drawable.ic_icon_marron);
        wm1.addView(im,lpar);
        Log.d("TAG", "service 3 added view: ");

        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(ServiceOfIntent.this,MainActivity.class);
                Log.d("TAG", "Broadcaster2 on: ");
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        wm1.removeView(im);
        Log.d("TAG", "onDestroy: service stopped");
    }
}
