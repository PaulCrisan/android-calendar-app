package com.wallpapernote.plutopix.wallpaperorganizer;


import android.content.Intent;
import android.content.SharedPreferences;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;


public class Calendar_Activity extends AppCompatActivity implements View.OnTouchListener, SharedPreferences.OnSharedPreferenceChangeListener{

    TextView nr1;       TextView day1;
    TextView nr2;       TextView day2;
    TextView nr3;       TextView day3;
    TextView nr4;       TextView day4;
    TextView nr5;       TextView day5;
    TextView nr6;       TextView day6;
    TextView nr7;       TextView day7;
    TextView nr8;       TextView day8;
    TextView nr9;       TextView day9;
    TextView nr10;       TextView day10;
    TextView nr11;       TextView day11;
    TextView nr12;       TextView day12;
    TextView nr13;       TextView day13;
    TextView nr14;       TextView day14;
    TextView nr15;       TextView day15;
    TextView nr16;       TextView day16;
    TextView nr17;       TextView day17;
    TextView nr18;       TextView day18;
    TextView nr19;       TextView day19;
    TextView nr20;       TextView day20;
    TextView nr21;       TextView day21;
    TextView nr22;       TextView day22;
    TextView nr23;       TextView day23;
    TextView nr24;       TextView day24;
    TextView nr25;       TextView day25;
    TextView nr26;       TextView day26;
    TextView nr27;       TextView day27;
    TextView nr28;       TextView day28;
    TextView nr29;       TextView day29;
    TextView nr30;       TextView day30;
    TextView nr31;       TextView day31;

    ImageView i1;
    ImageView i2;
    ImageView i3;
    ImageView i4;
    ImageView i5;
    ImageView i6;
    ImageView i7;
    ImageView i8;
    ImageView i9;
    ImageView i10;
    ImageView i11;
    ImageView i12;
    ImageView i13;
    ImageView i14;
    ImageView i15;
    ImageView i16;
    ImageView i17;
    ImageView i18;
    ImageView i19;
    ImageView i20;
    ImageView i21;
    ImageView i22;
    ImageView i23;
    ImageView i24;
    ImageView i25;
    ImageView i26;
    ImageView i27;
    ImageView i28;
    ImageView i29;
    ImageView i30;
    ImageView i31;

    ImageView bd1;
    ImageView bd2;
    ImageView bd3;
    ImageView bd4;
    ImageView bd5;
    ImageView bd6;
    ImageView bd7;
    ImageView bd8;
    ImageView bd9;
    ImageView bd10;
    ImageView bd11;
    ImageView bd12;
    ImageView bd13;
    ImageView bd14;
    ImageView bd15;
    ImageView bd16;
    ImageView bd17;
    ImageView bd18;
    ImageView bd19;
    ImageView bd20;
    ImageView bd21;
    ImageView bd22;
    ImageView bd23;
    ImageView bd24;
    ImageView bd25;
    ImageView bd26;
    ImageView bd27;
    ImageView bd28;
    ImageView bd29;
    ImageView bd30;
    ImageView bd31;






    Button jan;
    Button feb;
    Button mar;
    Button apr;
    Button may;
    Button jun;
    Button jul;
    Button aug;
    Button sep;
    Button oct;
    Button nov;
    Button dec;

    RelativeLayout b1;
    RelativeLayout b2;
    RelativeLayout b3;
    RelativeLayout b4;
    RelativeLayout b5;
    RelativeLayout b6;
    RelativeLayout b7;
    RelativeLayout b8;
    RelativeLayout b9;
    RelativeLayout b10;
    RelativeLayout b11;
    RelativeLayout b12;
    RelativeLayout b13_;
    RelativeLayout b14;
    RelativeLayout b15;
    RelativeLayout b16;
    RelativeLayout b17;
    RelativeLayout b18;
    RelativeLayout b19;
    RelativeLayout b20;
    RelativeLayout b21;
    RelativeLayout b22;
    RelativeLayout b23;
    RelativeLayout b24;
    RelativeLayout b25;
    RelativeLayout b26;
    RelativeLayout b27;
    RelativeLayout b28;
    RelativeLayout b29;
    RelativeLayout b30;
    RelativeLayout b31;

    private int year;
    private int month;
    private int day;

    private int nowYear;
    private int nowMonth;
    private int nowDay;

    private MyDB mMyDB;



    private SharedPreferences mSharedPreferences;

    private ViewPager mPager;

    private String noteHour8;
    private String noteHour9;
    private String noteHour10;
    private String noteHour11;
    private String noteHour12;
    private String noteHour13;
    private String noteHour14;
    private String noteHour15;
    private String noteHour16;
    private String noteHour17;
    private String noteHour18;
    private String noteHour19;
    private String noteHour20;

    private NameDayHelper mNameDayHelper;

    private String aNameReturnedAsDay ="";

    public static final String TAG = "tag";

    private static final int MIN_CLICK_DURATION = 500;
    private long startClickTime;
    private boolean longClickActive = false;

    private ArrayList<RelativeLayout>mRelativeLayouts;
    private ArrayList<TextView>mDayNumbers;
    private ArrayList<Button>mMonthButtons;
    private ArrayList<TextView>mDayNames;
    private ArrayList<ImageView>mStarDays;
    private ArrayList<ImageView>mBirthdays;
    private ArrayList<TextView>mCustomTV;
//    List<ImageView>mImageViewList;
//    List<RelativeLayout>relLayouts;
    private TextView liveDateDisplay;
    private int onCreateBasicCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picker_dates);

        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
        window.addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
        window.addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);

        liveDateDisplay = (TextView)findViewById(R.id.date_display);

        jan = (Button) findViewById(R.id.jan);
        feb = (Button) findViewById(R.id.feb);
        mar = (Button) findViewById(R.id.mar);
        apr = (Button) findViewById(R.id.apr);
        may = (Button) findViewById(R.id.may);
        jun = (Button) findViewById(R.id.jun);
        jul = (Button) findViewById(R.id.jul);
        aug = (Button) findViewById(R.id.aug);
        sep = (Button) findViewById(R.id.sep);
        oct = (Button) findViewById(R.id.oct);
        nov = (Button) findViewById(R.id.nov);
        dec = (Button) findViewById(R.id.dec);

        nr1 = (TextView)findViewById(R.id.t1);
        nr2 = (TextView)findViewById(R.id.t2);
        nr3 = (TextView)findViewById(R.id.t3);
        nr4 = (TextView)findViewById(R.id.t4);
        nr5 = (TextView)findViewById(R.id.t5);
        nr6 = (TextView)findViewById(R.id.t6);
        nr7 = (TextView)findViewById(R.id.t7);
        nr8 = (TextView)findViewById(R.id.t8);
        nr9 = (TextView)findViewById(R.id.t9);
        nr10 = (TextView)findViewById(R.id.t10);
        nr11 = (TextView)findViewById(R.id.t11);
        nr12 = (TextView)findViewById(R.id.t12);
        nr13 = (TextView)findViewById(R.id.t13);
        nr14 = (TextView)findViewById(R.id.t14);
        nr15 = (TextView)findViewById(R.id.t15);
        nr16 = (TextView)findViewById(R.id.t16);
        nr17 = (TextView)findViewById(R.id.t17);
        nr18 = (TextView)findViewById(R.id.t18);
        nr19 = (TextView)findViewById(R.id.t19);
        nr20 = (TextView)findViewById(R.id.t20);
        nr21 = (TextView)findViewById(R.id.t21);
        nr22 = (TextView)findViewById(R.id.t22);
        nr23 = (TextView)findViewById(R.id.t23);
        nr24 = (TextView)findViewById(R.id.t24);
        nr25 = (TextView)findViewById(R.id.t25);
        nr26 = (TextView)findViewById(R.id.t26);
        nr27 = (TextView)findViewById(R.id.t27);
        nr28 = (TextView)findViewById(R.id.t28);
        nr29 = (TextView)findViewById(R.id.t29);
        nr30 = (TextView)findViewById(R.id.t30);
        nr31 = (TextView)findViewById(R.id.t31);

        day1 = (TextView)findViewById(R.id.oneB);
        day2 = (TextView)findViewById(R.id.twoB);
        day3 = (TextView)findViewById(R.id.threeB);
        day4 = (TextView)findViewById(R.id.fourB);
        day5 = (TextView)findViewById(R.id.fiveB);
        day6 = (TextView)findViewById(R.id.sixB);
        day7 = (TextView)findViewById(R.id.sevenB);
        day8 = (TextView)findViewById(R.id.eichtB);
        day9 = (TextView)findViewById(R.id.nineB);
        day10 = (TextView)findViewById(R.id.tenB);
        day11 = (TextView)findViewById(R.id.elevenB);
        day12 = (TextView)findViewById(R.id.twelveB);
        day13 = (TextView)findViewById(R.id.thirteen_13B);
        day14 = (TextView)findViewById(R.id.fourteenB);
        day15 = (TextView)findViewById(R.id.fifteenB);
        day16 = (TextView)findViewById(R.id.sixteenB);
        day17 = (TextView)findViewById(R.id.seventeenB);
        day18 = (TextView)findViewById(R.id.eighteenB);
        day19 = (TextView)findViewById(R.id.nineteenB);
        day20 = (TextView)findViewById(R.id.twentyB);
        day21 = (TextView)findViewById(R.id.twentyoneB);
        day22 = (TextView)findViewById(R.id.twentytwoB);
        day23 = (TextView)findViewById(R.id.twentythreeB);
        day24 = (TextView)findViewById(R.id.twentyfourB);
        day25 = (TextView)findViewById(R.id.twentyfiveB);
        day26 = (TextView)findViewById(R.id.twentysixB);
        day27 = (TextView)findViewById(R.id.twentysevenB);
        day28 = (TextView)findViewById(R.id.twentyeightB);
        day29 = (TextView)findViewById(R.id.twentynineB);
        day30 = (TextView)findViewById(R.id.thirtyB);
        day31 = (TextView)findViewById(R.id.thirtyoneB);




        b1 = (RelativeLayout) findViewById(R.id.one);
        b2 = (RelativeLayout) findViewById(R.id.two);
        b3 = (RelativeLayout) findViewById(R.id.three);
        b4 = (RelativeLayout) findViewById(R.id.four);
        b5 = (RelativeLayout) findViewById(R.id.five);
        b6 = (RelativeLayout) findViewById(R.id.six);
        b7 = (RelativeLayout) findViewById(R.id.seven);
        b8 = (RelativeLayout) findViewById(R.id.eicht);
        b9 = (RelativeLayout) findViewById(R.id.nine);
        b10 = (RelativeLayout) findViewById(R.id.ten);
        b11 = (RelativeLayout) findViewById(R.id.eleven);
        b12 = (RelativeLayout) findViewById(R.id.twelve);
        b13_ = (RelativeLayout) findViewById(R.id.thirteen_13) ;
        b14 = (RelativeLayout) findViewById(R.id.fourteen);
        b15 = (RelativeLayout) findViewById(R.id.fifteen);
        b16 = (RelativeLayout) findViewById(R.id.sixteen);
        b17 = (RelativeLayout) findViewById(R.id.seventeen);
        b18 = (RelativeLayout) findViewById(R.id.eighteen);
        b19 = (RelativeLayout) findViewById(R.id.nineteen);
        b20 = (RelativeLayout) findViewById(R.id.twenty);
        b21 = (RelativeLayout) findViewById(R.id.twentyone);
        b22 = (RelativeLayout) findViewById(R.id.twentytwo);
        b23 = (RelativeLayout) findViewById(R.id.twentythree);
        b24 = (RelativeLayout) findViewById(R.id.twentyfour);
        b25 = (RelativeLayout) findViewById(R.id.twentyfive);
        b26 = (RelativeLayout) findViewById(R.id.twentysix);
        b27 = (RelativeLayout) findViewById(R.id.twentyseven);
        b28 = (RelativeLayout) findViewById(R.id.twentyeight);
        b29 = (RelativeLayout) findViewById(R.id.twentynine);
        b30 = (RelativeLayout) findViewById(R.id.thirty);
        b31 = (RelativeLayout) findViewById(R.id.thirtyone);

        i1 = (ImageView)findViewById(R.id.im1) ;
        i2 = (ImageView)findViewById(R.id.im2);
        i3 = (ImageView)findViewById(R.id.im3);
        i4 = (ImageView)findViewById(R.id.im4);
        i5 = (ImageView)findViewById(R.id.im5);
        i6 = (ImageView)findViewById(R.id.im6);
        i7 = (ImageView)findViewById(R.id.im7);
        i8 = (ImageView)findViewById(R.id.im8);
        i9 = (ImageView)findViewById(R.id.im9);
        i10 = (ImageView)findViewById(R.id.im10);
        i11 = (ImageView)findViewById(R.id.im11);
        i12 = (ImageView)findViewById(R.id.im12);
        i13 = (ImageView)findViewById(R.id.im13);
        i14 = (ImageView)findViewById(R.id.im14);
        i15 = (ImageView)findViewById(R.id.im15);
        i16 = (ImageView)findViewById(R.id.im16);
        i17 = (ImageView)findViewById(R.id.im17);
        i18 = (ImageView)findViewById(R.id.im18);
        i19 = (ImageView)findViewById(R.id.im19);
        i20 = (ImageView)findViewById(R.id.im20);
        i21 = (ImageView)findViewById(R.id.im21);
        i22 = (ImageView)findViewById(R.id.im22);
        i23 = (ImageView)findViewById(R.id.im23);
        i24 = (ImageView)findViewById(R.id.im24);
        i25 = (ImageView)findViewById(R.id.im25);
        i26 = (ImageView)findViewById(R.id.im26);
        i27 = (ImageView)findViewById(R.id.im27);
        i28 = (ImageView)findViewById(R.id.im28);
        i29 = (ImageView)findViewById(R.id.im29);
        i30 = (ImageView)findViewById(R.id.im30);
        i31 = (ImageView)findViewById(R.id.im31);

        bd1 = (ImageView)findViewById(R.id.bi1);
        bd2 = (ImageView)findViewById(R.id.bi2);
        bd3 = (ImageView)findViewById(R.id.bi3);
        bd4 = (ImageView)findViewById(R.id.bi4);
        bd5 = (ImageView)findViewById(R.id.bi5);
        bd6 = (ImageView)findViewById(R.id.bi6);
        bd7 = (ImageView)findViewById(R.id.bi7);
        bd8 = (ImageView)findViewById(R.id.bi8);
        bd9 = (ImageView)findViewById(R.id.bi9);
        bd10 = (ImageView)findViewById(R.id.bi10);
        bd11 = (ImageView)findViewById(R.id.bi11);
        bd12 = (ImageView)findViewById(R.id.bi12);
        bd13 = (ImageView)findViewById(R.id.bi13);
        bd14 = (ImageView)findViewById(R.id.bi14);
        bd15 = (ImageView)findViewById(R.id.bi15);
        bd16 = (ImageView)findViewById(R.id.bi16);
        bd17 = (ImageView)findViewById(R.id.bi17);
        bd18 = (ImageView)findViewById(R.id.bi18);
        bd19 = (ImageView)findViewById(R.id.bi19);
        bd20 = (ImageView)findViewById(R.id.bi20);
        bd21 = (ImageView)findViewById(R.id.bi21);
        bd22 = (ImageView)findViewById(R.id.bi22);
        bd23 = (ImageView)findViewById(R.id.bi23);
        bd24 = (ImageView)findViewById(R.id.bi24);
        bd25 = (ImageView)findViewById(R.id.bi25);
        bd26 = (ImageView)findViewById(R.id.bi26);
        bd27 = (ImageView)findViewById(R.id.bi27);
        bd28 = (ImageView)findViewById(R.id.bi28);
        bd29 = (ImageView)findViewById(R.id.bi29);
        bd30 = (ImageView)findViewById(R.id.bi30);
        bd31 = (ImageView)findViewById(R.id.bi31);

        TextView cuRtv1 = (TextView)findViewById(R.id.cu1) ;
        TextView cuRtv2 = (TextView)findViewById(R.id.cu2) ;
        TextView cuRtv3 = (TextView)findViewById(R.id.cu3) ;
        TextView cuRtv4 = (TextView)findViewById(R.id.cu4) ;
        TextView cuRtv5 = (TextView)findViewById(R.id.cu5) ;
        TextView cuRtv6 = (TextView)findViewById(R.id.cu6) ;
        TextView cuRtv7 = (TextView)findViewById(R.id.cu7) ;
        TextView cuRtv8 = (TextView)findViewById(R.id.cu8) ;
        TextView cuRtv9 = (TextView)findViewById(R.id.cu9) ;
        TextView cuRtv10 = (TextView)findViewById(R.id.cu10) ;
        TextView cuRtv11 = (TextView)findViewById(R.id.cu11) ;
        TextView cuRtv12 = (TextView)findViewById(R.id.cu12) ;
        TextView cuRtv13 = (TextView)findViewById(R.id.cu13) ;
        TextView cuRtv14 = (TextView)findViewById(R.id.cu14) ;
        TextView cuRtv15 = (TextView)findViewById(R.id.cu15) ;
        TextView cuRtv16 = (TextView)findViewById(R.id.cu16) ;
        TextView cuRtv17 = (TextView)findViewById(R.id.cu17) ;
        TextView cuRtv18 = (TextView)findViewById(R.id.cu18) ;
        TextView cuRtv19 = (TextView)findViewById(R.id.cu19) ;
        TextView cuRtv20 = (TextView)findViewById(R.id.cu20) ;
        TextView cuRtv21 = (TextView)findViewById(R.id.cu21) ;
        TextView cuRtv22 = (TextView)findViewById(R.id.cu22) ;
        TextView cuRtv23 = (TextView)findViewById(R.id.cu23) ;
        TextView cuRtv24 = (TextView)findViewById(R.id.cu24) ;
        TextView cuRtv25 = (TextView)findViewById(R.id.cu25) ;
        TextView cuRtv26 = (TextView)findViewById(R.id.cu26) ;
        TextView cuRtv27 = (TextView)findViewById(R.id.cu27) ;
        TextView cuRtv28 = (TextView)findViewById(R.id.cu28) ;
        TextView cuRtv29 = (TextView)findViewById(R.id.cu29) ;
        TextView cuRtv30 = (TextView)findViewById(R.id.cu30) ;
        TextView cuRtv31 = (TextView)findViewById(R.id.cu31) ;









        mPager = (ViewPager)findViewById(R.id.viewPage);

        b1.setOnTouchListener(this);
        b2.setOnTouchListener(this);
        b3.setOnTouchListener(this);
        b4.setOnTouchListener(this);
        b5.setOnTouchListener(this);
        b6.setOnTouchListener(this);
        b7.setOnTouchListener(this);
        b8.setOnTouchListener(this);
        b9.setOnTouchListener(this);
        b10.setOnTouchListener(this);
        b11.setOnTouchListener(this);
        b12.setOnTouchListener(this);
        b13_.setOnTouchListener(this);
        b14.setOnTouchListener(this);
        b15.setOnTouchListener(this);
        b16.setOnTouchListener(this);
        b17.setOnTouchListener(this);
        b18.setOnTouchListener(this);
        b19.setOnTouchListener(this);
        b20.setOnTouchListener(this);
        b21.setOnTouchListener(this);
        b22.setOnTouchListener(this);
        b23.setOnTouchListener(this);
        b24.setOnTouchListener(this);
        b25.setOnTouchListener(this);
        b26.setOnTouchListener(this);
        b27.setOnTouchListener(this);
        b28.setOnTouchListener(this);
        b29.setOnTouchListener(this);
        b30.setOnTouchListener(this);
        b31.setOnTouchListener(this);



                ///

//        bon = new ArrayList<>();
//        bon.add(b1);bon.add(b2);
//
//        mImageViewList = new ArrayList<>();
//        mImageViewList.add(i1);
//        mImageViewList.add(i2);


        RelativeLayout[] dayButtons = {null, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13_, b14, b15, b16,
                b17, b18, b19, b20, b21, b22, b23, b24, b25, b26, b27, b28, b29, b30, b31};
        mRelativeLayouts = new ArrayList<>(Arrays.asList(dayButtons));

        TextView[] dayNumbers = {null, nr1, nr2, nr3, nr4, nr5, nr6, nr7, nr8, nr9, nr10, nr11, nr12, nr13, nr14, nr15, nr16,
                nr17, nr18, nr19, nr20, nr21, nr22, nr23, nr24, nr25, nr26, nr27, nr28, nr29, nr30, nr31};
        mDayNumbers = new ArrayList<>(Arrays.asList(dayNumbers));

        Button[] buttons = {jan, feb, mar, apr, may, jun, jul, aug, sep, oct, nov, dec};
        mMonthButtons = new ArrayList<>(Arrays.asList(buttons));

        TextView[] textViews = {day1,day2,day3,day4,day5,day6,day7,day8,day9,day10,day11,day12,day13,day14,
                day15,day16,day17,day18,day19,day20,day21,day22,day23,day24,day25,day26,day27,day28,day29,day30,day31};
        mDayNames = new ArrayList<>(Arrays.asList(textViews));

        ImageView[] imageviews ={null,i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12,i13,i14,i15,i16,i17,i18,i19,i20,i21,i22,i23,i24,i25,i26,i27,i28,
        i29,i30,i31};
        mStarDays = new ArrayList<>(Arrays.asList(imageviews));

        ImageView[] arraybirth = {null,bd1,bd2,bd3,bd4,bd5,bd6,bd7,bd8,bd9,bd10,bd11,bd12,bd13,bd14,bd15,bd16,
                bd17,bd18,bd19,bd20,bd21,bd22,bd23,bd24,bd25,bd26,bd27,bd28,bd29,bd30,bd31};
        mBirthdays = new ArrayList<>(Arrays.asList(arraybirth));

        TextView[] customArray = {null,cuRtv1,cuRtv2,cuRtv3,cuRtv4,cuRtv5,cuRtv6,cuRtv7,cuRtv8,cuRtv9,cuRtv10,cuRtv11,cuRtv12,cuRtv13,cuRtv14,
        cuRtv15,cuRtv16,cuRtv17,cuRtv18,cuRtv19,cuRtv20,cuRtv21,cuRtv22,cuRtv23,cuRtv24,cuRtv25,cuRtv26,cuRtv27,cuRtv28,cuRtv29,cuRtv30,cuRtv31};
        mCustomTV = new ArrayList<>(Arrays.asList(customArray));

        //day5.setText("THU");

            ////
        Calendar checking = Calendar.getInstance();
        onCreateBasicCheck = checking.get(Calendar.DAY_OF_MONTH);
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        mSharedPreferences.registerOnSharedPreferenceChangeListener(this);
        //mSharedPreferences = getSharedPreferences(MainActivity.PREFNAME, MODE_PRIVATE);
        year = mSharedPreferences.getInt(MainActivity.NOWYEAR, 0);
        month = mSharedPreferences.getInt(MainActivity.NOWMONTH, 0);
        day = mSharedPreferences.getInt(MainActivity.NOWDAY, 0);
        nowYear = year;
        nowMonth = month;
        nowDay = day;


        monthColorChange(null);


        //mMyDB = new MyDB(getApplicationContext());
        mMyDB = MyDB.getMyDB(getApplicationContext());

        populatingDayBackgrounds(null);



        mPager.setAdapter(new CustomPageAdapter(Calendar_Activity.this,dataSource()));

        getAllNotesToStrings();
        setTextToPageViewer();


        setDayNames(mNameDayHelper.setDayNamesFromCalendar(year,month,1));
        starMangement();
        birthMangement();
        refreshLiveDate();
        customManage();




    }
    public void refreshLiveDate(){
        boolean check = mSharedPreferences.getBoolean(Settings.DATESET,false);
        String date = "";
      if(mSharedPreferences.contains(Settings.DATESET)) {
          if (check) {
              date = (month + 1) + "/" + day + "/" + year;
              Log.d(TAG, "refreshLiveDate: " + check + date);
          } else {
              date = day + "/" + (month + 1) + "/" + year;
              Log.d(TAG, "refreshLiveDate should be false: " + check + date);
          }
      }else date = day + "/" + (month + 1) + "/" + year;
        liveDateDisplay.setText(date);
    }



    // MONTHS -------->
    public void monthColorChange(View v) {
       // Button[] buttons = {jan, feb, mar, apr, may, jun, jul, aug, sep, oct, nov, dec};

        for (int i = 0; i < mMonthButtons.size(); i++) {

            if ((i == month) && (v == null)) {
                //GOING ONLY ONCE IN ONCREATE
                mMonthButtons.get(i).setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.soft_red));
                daysInMonth(year,i);
            }
            if (v != null) {
                if (v.equals(mMonthButtons.get(i))) {
                    mMonthButtons.get(i).setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.soft_red));

                    month = i;
                    daysInMonth(year,i);

                     aNameReturnedAsDay = mNameDayHelper.setDayNamesFromCalendar(year,month,1);


                    Log.d(TAG, "returned string: " + mNameDayHelper.setDayNamesFromCalendar(year,month,1));
                } else {

                    Log.d(TAG, "monthColorChange: "+ nowMonth);
                    mMonthButtons.get(i).setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.soft_white));
                    mMonthButtons.get(nowMonth).setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.stronger_blue));
                    if(v.equals(mMonthButtons.get(nowMonth))){  mMonthButtons.get(nowMonth).setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.soft_red));   }
                }
            }
        }


    }

    public void clickMonths(View v) {

        monthColorChange(v);
        populatingDayBackgrounds(null);
        setDayNames(aNameReturnedAsDay);
        setTextToPageViewer();
        //
        updatePreferencesToJumpToHour();
        //
        starMangement();
        birthMangement();
        refreshLiveDate();
        customManage();

    }


    // <----------- MONTHS
    // DAYS ---------->

    public void populatingDayBackgrounds(View v) {

        //RelativeLayout[] dayButtons = {null, b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13_, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24, b25, b26, b27, b28, b29, b30, b31};
        //TextView[] dayNumbers = {null, nr1, nr2, nr3, nr4, nr5, nr6, nr7, nr8, nr9, nr10, nr11, nr12, nr13, nr14, nr15, nr16, nr17, nr18, nr19, nr20, nr21, nr22, nr23, nr24, nr25, nr26, nr27, nr28, nr29, nr30, nr31};

        for (int i = 1; i < mRelativeLayouts.size(); i++) {

            if (i == day) {
                //GOING ONLY ONCE IN ONCREATE
                mDayNumbers.get(i).setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.soft_red));
            }
            if (v != null) {
                if (v.getId() == mRelativeLayouts.get(i).getId()) {

                    day = i;
                    mDayNumbers.get(i).setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.soft_red));



                }else {
                    mDayNumbers.get(i).setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.soft_black));
                    mDayNumbers.get(nowDay).setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.stronger_blue));
                    if(v.equals(mRelativeLayouts.get(nowDay))){   mDayNumbers.get(nowDay).setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.soft_red));   }
                }

            }

            int number = mMyDB.getNumberOfDailyNotes(year, month, i);


//            if(i <mStarDays.size()) {
//                if (mMyDB.checkForStar(nowYear, nowMonth, nowDay)) {
//                    mStarDays.get(i).setVisibility(View.VISIBLE);
//                } else mStarDays.get(i).setVisibility(View.INVISIBLE);
//            }
            Log.d(TAG, "populatingDayBackgrounds: " + " number is " + number);
            if (number == 0 ) {
                mRelativeLayouts.get(i).setBackgroundResource(R.drawable.day);
            } else if (number > 0 && number <= 2) {
                mRelativeLayouts.get(i).setBackgroundResource(R.drawable.day_20);
            } else if (number > 2 && number <= 4) {
                mRelativeLayouts.get(i).setBackgroundResource(R.drawable.day_40);
            } else if (number > 4 && number <= 6) {
                mRelativeLayouts.get(i).setBackgroundResource(R.drawable.day_60);
            } else if (number > 6 && number <= 8) {
                mRelativeLayouts.get(i).setBackgroundResource(R.drawable.day_80);
            } else if (number > 8 && number <= 10) {
                mRelativeLayouts.get(i).setBackgroundResource(R.drawable.day_100);
            } else if (number > 10 && number <= 13) {
                mRelativeLayouts.get(i).setBackgroundResource(R.drawable.day_120);
            }
        }

    }


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                view.setBackgroundResource(R.drawable.day_pressed);

                if (longClickActive == false) {
                    longClickActive = true;
                    startClickTime = Calendar.getInstance().getTimeInMillis();
                }
                break;
            case MotionEvent.ACTION_UP:
                populatingDayBackgrounds(view);
                getAllNotesToStrings();
                setTextToPageViewer();
                updatePreferencesToJumpToHour();
                refreshLiveDate();
                //
                longClickActive = false;
                //
                Log.d(TAG, "onTouch: " + month + " " + day);

                break;
            case MotionEvent.ACTION_MOVE:
                if (longClickActive == true) {
                    long clickDuration = Calendar.getInstance().getTimeInMillis() - startClickTime;
                    if (clickDuration >= MIN_CLICK_DURATION) {

                        longClickActive = false;
                        populatingDayBackgrounds(view);
                        updatePreferencesToJumpToHour();
                        Intent d = new Intent(Calendar_Activity.this,Hour_activity.class);
                        startActivity(d);
                    }
                }
                break;

        }
        return true;
    }

    public void getAllNotesToStrings(){
        mNameDayHelper = new NameDayHelper();
        String name = mNameDayHelper.getNameOfDay(year,month,day,"");
        noteHour8 =mMyDB.getNoteByHour(year,month,day,8);
        noteHour9 =mMyDB.getNoteByHour(year,month,day,9);
        noteHour10 =mMyDB.getNoteByHour(year,month,day,10);
        noteHour11 =mMyDB.getNoteByHour(year,month,day,11);
        noteHour12 = mMyDB.getNoteByHour(year,month,day,12);
        noteHour13 =mMyDB.getNoteByHour(year,month,day,13);
        noteHour14 =mMyDB.getNoteByHour(year,month,day,14);
        noteHour15 =mMyDB.getNoteByHour(year,month,day,15);
        noteHour16 =mMyDB.getNoteByHour(year,month,day,16);
        noteHour17 = mMyDB.getNoteByHour(year,month,day,17);
        noteHour18 =mMyDB.getNoteByHour(year,month,day,18);
        noteHour19 = mMyDB.getNoteByHour(year,month,day,19);
        noteHour20 =mMyDB.getNoteByHour(year,month,day,20);

    }
    public void setTextToPageViewer(){
        mPager.setAdapter(null);
        //
        getAllNotesToStrings();
        //
        dataSource();
        mPager.setAdapter(new CustomPageAdapter(Calendar_Activity.this,dataSource()));
        Log.e(TAG, "setTextToPageViewer: ");



    }
    private List<DataObject> dataSource(){
        List<DataObject> data = new ArrayList<DataObject>();
        data.add(new DataObject(R.drawable.thehour08,noteHour8,R.drawable.thehour09,noteHour9,R.drawable.thehour10,noteHour10,R.drawable.thehour11,noteHour11));
        data.add(new DataObject(R.drawable.thehour12,noteHour12,R.drawable.thehour13,noteHour13,R.drawable.thehour14,noteHour14,R.drawable.thehour15,noteHour15));
        data.add(new DataObject(R.drawable.thehour16,noteHour16,R.drawable.thehour17,noteHour17,R.drawable.thehour18,noteHour18,R.drawable.thehour19,noteHour19));
        data.add(new DataObject(R.drawable.thehour20,noteHour20,R.drawable.thehour_empty,"",R.drawable.thehour_empty,"",R.drawable.thehour_empty,""));


        return data;
    }


    public void updatePreferencesToJumpToHour(){
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        //mSharedPreferences = getSharedPreferences(MainActivity.PREFNAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        //editor.putInt(MainActivity.NOWYEAR, year);
        editor.putInt(MainActivity.NOWMONTH, month);
        editor.putInt(MainActivity.NOWDAY, day);
        editor.commit();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mMyDB != null) {
            Log.d(TAG, "onPause: paused db calendar");
            mMyDB.close();
        }


    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        Calendar postREsumeCheck = Calendar.getInstance();
        if(onCreateBasicCheck != postREsumeCheck.get(Calendar.DAY_OF_MONTH)){
           Calendar_Activity.this.recreate();
        }else {
            populatingDayBackgrounds(null);
            getAllNotesToStrings();
            setTextToPageViewer();
            starMangement();
            birthMangement();
            customManage();
        }




    }

    public  int daysInMonth(int year, int month){
        Calendar cal = Calendar.getInstance();
        int aDay = 1;
        cal.set(year,month,aDay);
        int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        switch (days){
            case 30:
                b31.setVisibility(View.INVISIBLE);
                break;
            case 29:
                     b31.setVisibility(View.INVISIBLE);
                     b30.setVisibility(View.INVISIBLE);
                break;
            case 28:
                    b31.setVisibility(View.INVISIBLE);
                    b30.setVisibility(View.INVISIBLE);
                    b29.setVisibility(View.INVISIBLE);
                break;
            default: b31.setVisibility(View.VISIBLE);
                     b30.setVisibility(View.VISIBLE);
                    b29.setVisibility(View.VISIBLE);
                break;

        }
//        if (days <31){
//
//
//        }else b31.setVisibility(View.VISIBLE);
//
//        Log.d(TAG, "daysInMonth: " + days);
        return days;

    }
    public void setDayNames(String name){

        //TextView[] textViews = {day1,day2,day3,day4,day5,day6,day7,day8,day9,day10,day11,day12,day13,day14,day15,day16,day17,day18,day19,day20,day21,day22,day23,day24,day25,day26,day27,day28,day29,day30,day31};
        String[] daysInWeek = {"MO","TU","WE","TH","FR","SA","SU","MO","TU","WE","TH","FR","SA","SU","MO","TU","WE","TH","FR","SA","SU","MO","TU","WE","TH","FR","SA","SU","MO","TU","WE","TH","FR","SA","SU","MO","TU","WE","TH","FR","SA","SU"};


        switch (name){
            case "MON":
                for(int i = 0; i<mDayNames.size(); i++){
                    mDayNames.get(i).setText(daysInWeek[i]);
                    if((i>6 && i<14)||(i>20 && i<28)){
                       // mDayNames.get(i).setTextColor(Color.BLACK);

                    }else {
                       // mDayNames.get(i).setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.soft_black));
                        mDayNames.get(i).setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.shade_blue));
                    }
//                    mDayNames.get(i).setText(daysInWeek[i]);
//                    if(daysInWeek[i].equalsIgnoreCase("mo")){
//                        mDayNames.get(i).setAlpha(0.5f);
//                    }else mDayNames.get(i).setAlpha(1f);

                }
                break;
            case "TUE":
                for(int i = 0; i<mDayNames.size(); i++){
                    mDayNames.get(i).setText(daysInWeek[i+1]);
                    if((i>5 && i<13)||(i>19 && i<27)){
                        mDayNames.get(i).setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.nice_blue));
                    }else {
                        mDayNames.get(i).setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.shade_blue));
                    }



//                    if(daysInWeek[i+1].equalsIgnoreCase("SA")){
//                        mDayNames.get(i).setAlpha(0.5f);
//                    }else mDayNames.get(i).setAlpha(1f);
                }
                break;
            case "WED":
                for(int i = 0; i<mDayNames.size(); i++){
                    mDayNames.get(i).setText(daysInWeek[i+2]);
                    if((i>4 && i<12)||(i>18 && i<26)){
                        mDayNames.get(i).setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.nice_blue));
                    }else {
                        mDayNames.get(i).setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.shade_blue));
                    }
                }
                break;
            case "THU":
                for(int i = 0; i<mDayNames.size(); i++){
                    mDayNames.get(i).setText(daysInWeek[i+3]);
                    if((i>3 && i<11)||(i>17 && i<25)){
                        mDayNames.get(i).setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.nice_blue));
                    }else {
                        mDayNames.get(i).setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.shade_blue));
                    }
                }
                break;
            case "FRI":
                for(int i = 0; i<mDayNames.size(); i++){
                    mDayNames.get(i).setText(daysInWeek[i+4]);
                    if((i>2 && i<10)||(i>16 && i<24)){
                        mDayNames.get(i).setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.nice_blue));
                    }else {
                        mDayNames.get(i).setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.shade_blue));
                    }
                }
                break;
            case "SAT":
                for(int i = 0; i<mDayNames.size(); i++){
                    mDayNames.get(i).setText(daysInWeek[i+5]);
                    if((i>1 && i<9)||(i>15 && i<23) || (i>29 && i<mDayNames.size())){
                        mDayNames.get(i).setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.nice_blue));
                    }else {
                        mDayNames.get(i).setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.shade_blue));
                    }
                }
                break;
            case "SUN":
                for(int i = 0; i<mDayNames.size(); i++){
                    mDayNames.get(i).setText(daysInWeek[i+6]);
                    if((i>0 && i<8)||(i>14 && i<22) || (i>28 && i<mDayNames.size())){
                        mDayNames.get(i).setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.nice_blue));
                    }else {
                        mDayNames.get(i).setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.shade_blue));
                    }
//                    if(daysInWeek[i+6].equalsIgnoreCase("SA")){
//
//                        mDayNames.get(i).setTypeface(null,Typeface.BOLD);
//                    } else mDayNames.get(i).setTypeface(null,Typeface.NORMAL);
                }
                break;

        }


    }


    public void starMangement() {

        for (int i = 1; i<mStarDays.size(); i++){
            boolean check = mMyDB.checkForStar(year,month,i,Hour_activity.STARIDENTIFIER);

            if (check){
                mStarDays.get(i).setVisibility(View.VISIBLE);
            }else mStarDays.get(i).setVisibility(View.INVISIBLE);
        }
    }

    public void birthMangement() {

        for (int i = 1; i<mBirthdays.size(); i++){
            boolean check = mMyDB.birthCheck(month,i);
            if (check){
                mBirthdays.get(i).setVisibility(View.VISIBLE);
            }else mBirthdays.get(i).setVisibility(View.INVISIBLE);
        }
    }
    public void customManage(){
        for(int i = 1 ; i<mCustomTV.size(); i++){
            boolean checkC = mMyDB.customRCheck(year,month,i);
            if(checkC){
                mCustomTV.get(i).setVisibility(View.VISIBLE);
                mCustomTV.get(i).setText(mMyDB.getCustomRByDay(year,month,i));
            }else mCustomTV.get(i).setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        switch (s){
            case MainActivity.NOWYEAR:{
                year = sharedPreferences.getInt(MainActivity.NOWYEAR,0);
                refreshLiveDate();
                break;
            }
            case Settings.DATESET:{
                refreshLiveDate();
                break;
            }
        }


    }
}
