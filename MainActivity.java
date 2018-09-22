package com.wallpapernote.plutopix.wallpaperorganizer;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;


import java.util.Calendar;


public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {


    private SharedPreferences mSharedPreferences;

    public static final String NOWYEAR = "year";
    public static final String NOWMONTH = "month";
    public static final String NOWDAY = "day";
    private int prefYear;

    private Calendar mCalendar;
    private int year;
    private int month;
    private int day;
    private Toolbar mToolbar;


    // !! YEAR MONTHS START FROM 1
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(mToolbar);
        setTitle("Settings");

        Log.d("TAG", "main : " + year);


        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
        window.addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
        window.addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
        getDate();
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        if (mSharedPreferences.contains(NOWYEAR)) {
            prefYear = mSharedPreferences.getInt(NOWYEAR, 1);
        }
        getDate();



        mSharedPreferences.registerOnSharedPreferenceChangeListener(this);


        LinearLayout today = (LinearLayout) findViewById(R.id.linear_today);
        LinearLayout calendar = (LinearLayout) findViewById(R.id.calendar_button);
        ImageView todo = (ImageView) findViewById(R.id.plane);
        todo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ToToWithCursor.class);
                startActivity(i);

            }
        });


        today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                SharedPreferences.Editor editor = mSharedPreferences.edit();
                editor.putInt(NOWYEAR, year);
                editor.putInt(NOWMONTH, month);
                editor.putInt(NOWDAY, day);
                editor.commit();

                Intent i = new Intent(MainActivity.this, Hour_activity.class);
                startActivity(i);
            }
        });

        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = mSharedPreferences.edit();
                editor.putInt(NOWYEAR, year);
                editor.putInt(NOWMONTH, month);
                editor.putInt(NOWDAY, day);
                editor.commit();
                //to change from settings
//                Intent ii = new Intent(MainActivity.this, MonthDayDisplaySecond.class);
//                startActivity(ii);
                chooseSkinToJump();
            }
        });
    }
    public void chooseSkinToJump(){
        if(mSharedPreferences.contains(Settings.SKINSET)){
            boolean choice = mSharedPreferences.getBoolean(Settings.SKINSET,false);
            if(choice){
                Intent ii = new Intent(MainActivity.this, Calendar_Activity.class);
                startActivity(ii);
            }else {
                Intent iS2 = new Intent(MainActivity.this, MonthDayDisplaySecond.class);
                startActivity(iS2);
            }
        }else {
            Intent iS3 = new Intent(MainActivity.this, MonthDayDisplaySecond.class);
            startActivity(iS3);
        }
    }

    public void getDate() {

        mCalendar = Calendar.getInstance();
        int tempyear = mCalendar.get(Calendar.YEAR);
        if (prefYear != 0) {
            if (prefYear == tempyear) {
                year = tempyear;
            } else {
                year = prefYear;
            }
        }else year = tempyear;
        month = mCalendar.get(Calendar.MONTH);
        day = mCalendar.get(Calendar.DAY_OF_MONTH);


        /// REMEBER MONTH STARTS FROM 0


    }

    @Override
    protected void onPause() {
        super.onPause();
//        Intent serv = new Intent(this,Servicethree.class);
//        Log.d("TAG", "onPause: service started from activity");
//        getApplicationContext().startService(serv);
        Log.d("TAG", "onPause: ");

    }

    @Override
    protected void onResume() {
        super.onResume();
        getDate();
        Log.d("TAG", "onResume: ");
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        Intent serv2 = new Intent(this, Servicetwo.class);
        Intent serv3 = new Intent(this, Servicethree.class);
        Log.d("TAG", "onPause: service started from activity");

        getApplicationContext().stopService(serv3);
        getApplicationContext().startService(serv2);

        Log.d("TAG", "onWindowFocusedchnaged: ");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_settings:
                Intent action = new Intent(MainActivity.this, Settings.class);
                startActivity(action);

                break;
            default:
                break;
        }

        return true;
    }


    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        if(s.equals(NOWYEAR)){
            prefYear = sharedPreferences.getInt(NOWYEAR,0);
            year = sharedPreferences.getInt(NOWYEAR,0);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
