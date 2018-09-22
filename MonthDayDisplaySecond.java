package com.wallpapernote.plutopix.wallpaperorganizer;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class MonthDayDisplaySecond extends AppCompatActivity implements View.OnLongClickListener,Animation.AnimationListener, SharedPreferences.OnSharedPreferenceChangeListener {

    //months<
    private ImageView janim;
    private ImageView febim;
    private ImageView marim;
    private ImageView aprim;
    private ImageView mayim;
    private ImageView junim;
    private ImageView julim;
    private ImageView augim;
    private ImageView sepim;
    private ImageView octim;
    private ImageView novim;
    private ImageView decim;

    //>months

    //days

    private ImageView circle1;
    private TextView tvDay1;
    private ImageView circle2;
    private TextView tvDay2;
    private ImageView circle3;
    private TextView tvDay3;
    private ImageView circle4;
    private TextView tvDay4;
    private ImageView circle5;
    private TextView tvDay5;
    private ImageView circle6;
    private TextView tvDay6;
    private ImageView circle7;
    private TextView tvDay7;
    private ImageView circle8;
    private TextView tvDay8;
    private ImageView circle9;
    private TextView tvDay9;
    private ImageView circle10;
    private TextView tvDay10;
    private ImageView circle11;
    private TextView tvDay11;
    private ImageView circle12;
    private TextView tvDay12;
    private ImageView circle13;
    private TextView tvDay13;
    private ImageView circle14;
    private TextView tvDay14;
    private ImageView circle15;
    private TextView tvDay15;
    private ImageView circle16;
    private TextView tvDay16;
    private ImageView circle17;
    private TextView tvDay17;
    private ImageView circle18;
    private TextView tvDay18;
    private ImageView circle19;
    private TextView tvDay19;
    private ImageView circle20;
    private TextView tvDay20;
    private ImageView circle21;
    private TextView tvDay21;
    private ImageView circle22;
    private TextView tvDay22;
    private ImageView circle23;
    private TextView tvDay23;
    private ImageView circle24;
    private TextView tvDay24;
    private ImageView circle25;
    private TextView tvDay25;
    private ImageView circle26;
    private TextView tvDay26;
    private ImageView circle27;
    private TextView tvDay27;
    private ImageView circle28;
    private TextView tvDay28;
    private ImageView circle29;
    private TextView tvDay29;
    private ImageView circle30;
    private TextView tvDay30;
    private ImageView circle31;
    private TextView tvDay31;
    private ImageView circle32;
    private TextView tvDay32;
    private ImageView circle33;
    private TextView tvDay33;
    private ImageView circle34;
    private TextView tvDay34;
    private ImageView circle35;
    private TextView tvDay35;
    private ImageView circle36;
    private TextView tvDay36;
    private ImageView circle37;
    private TextView tvDay37;

    private ArrayList<ImageView> dayCircles;
    private ArrayList<RelativeLayout> dayRelatives;
    private ArrayList<TextView> dayTexts;
    private ArrayList<ImageView> busyNotesIndicators;
    private ArrayList<ImageView> stars;
    private ArrayList<ImageView> birthdays;
    private ArrayList<RelativeLayout> monthRelatives;
    private ArrayList<TextView> customRTExt;

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

    private RelativeLayout relCurD;
    private RelativeLayout relCurD2;
    private RelativeLayout relCurD3;
    private RelativeLayout relCurD4;
    private TextView tvCurD;
    private TextView tvCurD2;
    private TextView tvCurD3;
    private TextView tvCurD4;

    private static final String TAG = "tag";
    private MonthManageClick monthManageClick;
    private ViewPager mPager;
    private int year;
    private int month;
    private int day;
    private Animation a2;
    private Animation a3;
    private Animation a4;
    private Animation a6;
    private Animation a7;
    private Animation a8;
    private SharedPreferences mSharedPreferences;
    private MyDB mMyDB;
    private boolean recreatingOnResume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.picker_dates2);

        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
        window.addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
        window.addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);


        monthManageClick = new MonthManageClick();
        Calendar checking = Calendar.getInstance();
        monthManageClick.setOnCreateDay(checking.get(Calendar.DAY_OF_MONTH));
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        //mSharedPreferences.registerOnSharedPreferenceChangeListener(this);
        mSharedPreferences.registerOnSharedPreferenceChangeListener(this);
        getSavedDate();
        mMyDB = MyDB.getMyDB(getApplicationContext());

        mPager = (ViewPager) findViewById(R.id.viewPage);
        RelativeLayout jan = (RelativeLayout) findViewById(R.id.mjan);
        janim = (ImageView) findViewById(R.id.mjanim);
        RelativeLayout feb = (RelativeLayout) findViewById(R.id.mfeb);
        febim = (ImageView) findViewById(R.id.mfebim);
        RelativeLayout mar = (RelativeLayout) findViewById(R.id.mmar);
        marim = (ImageView) findViewById(R.id.mmarim);
        RelativeLayout apr = (RelativeLayout) findViewById(R.id.mapr);
        aprim = (ImageView) findViewById(R.id.maprim);
        RelativeLayout may = (RelativeLayout) findViewById(R.id.mmay);
        mayim = (ImageView) findViewById(R.id.mmayim);
        RelativeLayout jun = (RelativeLayout) findViewById(R.id.mjun);
        junim = (ImageView) findViewById(R.id.mjunim);
        RelativeLayout jul = (RelativeLayout) findViewById(R.id.mjul);
        julim = (ImageView) findViewById(R.id.mjulim);
        RelativeLayout aug = (RelativeLayout) findViewById(R.id.maug);
        augim = (ImageView) findViewById(R.id.maugim);
        RelativeLayout sep = (RelativeLayout) findViewById(R.id.msep);
        sepim = (ImageView) findViewById(R.id.msepim);
        RelativeLayout oct = (RelativeLayout) findViewById(R.id.moct);
        octim = (ImageView) findViewById(R.id.moctim);
        RelativeLayout nov = (RelativeLayout) findViewById(R.id.mnov);
        novim = (ImageView) findViewById(R.id.mnovim);
        RelativeLayout dec = (RelativeLayout) findViewById(R.id.mdec);
        decim = (ImageView) findViewById(R.id.mdecim);

        circle1 = (ImageView) findViewById(R.id.imcirc1);
        circle2 = (ImageView) findViewById(R.id.imcirc2);
        circle3 = (ImageView) findViewById(R.id.imcirc3);
        circle4 = (ImageView) findViewById(R.id.imcirc4);
        circle5 = (ImageView) findViewById(R.id.imcirc5);
        circle6 = (ImageView) findViewById(R.id.imcirc6);
        circle7 = (ImageView) findViewById(R.id.imcirc7);
        circle8 = (ImageView) findViewById(R.id.imcirc8);
        circle9 = (ImageView) findViewById(R.id.imcirc9);
        circle10 = (ImageView) findViewById(R.id.imcirc10);
        circle11 = (ImageView) findViewById(R.id.imcirc11);
        circle12 = (ImageView) findViewById(R.id.imcirc12);
        circle13 = (ImageView) findViewById(R.id.imcirc13);
        circle14 = (ImageView) findViewById(R.id.imcirc14);
        circle15 = (ImageView) findViewById(R.id.imcirc15);
        circle16 = (ImageView) findViewById(R.id.imcirc16);
        circle17 = (ImageView) findViewById(R.id.imcirc17);
        circle18 = (ImageView) findViewById(R.id.imcirc18);
        circle19 = (ImageView) findViewById(R.id.imcirc19);
        circle20 = (ImageView) findViewById(R.id.imcirc20);
        circle21 = (ImageView) findViewById(R.id.imcirc21);
        circle22 = (ImageView) findViewById(R.id.imcirc22);
        circle23 = (ImageView) findViewById(R.id.imcirc23);
        circle24 = (ImageView) findViewById(R.id.imcirc24);
        circle25 = (ImageView) findViewById(R.id.imcirc25);
        circle26 = (ImageView) findViewById(R.id.imcirc26);
        circle27 = (ImageView) findViewById(R.id.imcirc27);
        circle28 = (ImageView) findViewById(R.id.imcirc28);
        circle29 = (ImageView) findViewById(R.id.imcirc29);
        circle30 = (ImageView) findViewById(R.id.imcirc30);
        circle31 = (ImageView) findViewById(R.id.imcirc31);
        circle32 = (ImageView) findViewById(R.id.imcirc32);
        circle33 = (ImageView) findViewById(R.id.imcirc33);
        circle34 = (ImageView) findViewById(R.id.imcirc34);
        circle35 = (ImageView) findViewById(R.id.imcirc35);
        circle36 = (ImageView) findViewById(R.id.imcirc36);
        circle37 = (ImageView) findViewById(R.id.imcirc37);

        ImageView busy1 = (ImageView) findViewById(R.id.ims1);
        ImageView busy2 = (ImageView) findViewById(R.id.ims2);
        ImageView busy3 = (ImageView) findViewById(R.id.ims3);
        ImageView busy4 = (ImageView) findViewById(R.id.ims4);
        ImageView busy5 = (ImageView) findViewById(R.id.ims5);
        ImageView busy6 = (ImageView) findViewById(R.id.ims6);
        ImageView busy7 = (ImageView) findViewById(R.id.ims7);
        ImageView busy8 = (ImageView) findViewById(R.id.ims8);
        ImageView busy9 = (ImageView) findViewById(R.id.ims9);
        ImageView busy10 = (ImageView) findViewById(R.id.ims10);
        ImageView busy11 = (ImageView) findViewById(R.id.ims11);
        ImageView busy12 = (ImageView) findViewById(R.id.ims12);
        ImageView busy13 = (ImageView) findViewById(R.id.ims13);
        ImageView busy14 = (ImageView) findViewById(R.id.ims14);
        ImageView busy15 = (ImageView) findViewById(R.id.ims15);
        ImageView busy16 = (ImageView) findViewById(R.id.ims16);
        ImageView busy17 = (ImageView) findViewById(R.id.ims17);
        ImageView busy18 = (ImageView) findViewById(R.id.ims18);
        ImageView busy19 = (ImageView) findViewById(R.id.ims19);
        ImageView busy20 = (ImageView) findViewById(R.id.ims20);
        ImageView busy21 = (ImageView) findViewById(R.id.ims21);
        ImageView busy22 = (ImageView) findViewById(R.id.ims22);
        ImageView busy23 = (ImageView) findViewById(R.id.ims23);
        ImageView busy24 = (ImageView) findViewById(R.id.ims24);
        ImageView busy25 = (ImageView) findViewById(R.id.ims25);
        ImageView busy26 = (ImageView) findViewById(R.id.ims26);
        ImageView busy27 = (ImageView) findViewById(R.id.ims27);
        ImageView busy28 = (ImageView) findViewById(R.id.ims28);
        ImageView busy29 = (ImageView) findViewById(R.id.ims29);
        ImageView busy30 = (ImageView) findViewById(R.id.ims30);
        ImageView busy31 = (ImageView) findViewById(R.id.ims31);
        ImageView busy32 = (ImageView) findViewById(R.id.ims32);
        ImageView busy33 = (ImageView) findViewById(R.id.ims33);
        ImageView busy35 = (ImageView) findViewById(R.id.ims35);
        ImageView busy36 = (ImageView) findViewById(R.id.ims36);
        ImageView busy37 = (ImageView) findViewById(R.id.ims37);
        ImageView busy34 = (ImageView) findViewById(R.id.ims34);

        RelativeLayout rel1 = (RelativeLayout) findViewById(R.id.rel_day1);
        RelativeLayout rel2 = (RelativeLayout) findViewById(R.id.rel_day2);
        RelativeLayout rel3 = (RelativeLayout) findViewById(R.id.rel_day3);
        RelativeLayout rel4 = (RelativeLayout) findViewById(R.id.rel_day4);
        RelativeLayout rel5 = (RelativeLayout) findViewById(R.id.rel_day5);
        RelativeLayout rel6 = (RelativeLayout) findViewById(R.id.rel_day6);
        RelativeLayout rel7 = (RelativeLayout) findViewById(R.id.rel_day7);
        RelativeLayout rel8 = (RelativeLayout) findViewById(R.id.rel_day8);
        RelativeLayout rel9 = (RelativeLayout) findViewById(R.id.rel_day9);
        RelativeLayout rel10 = (RelativeLayout) findViewById(R.id.rel_day10);
        RelativeLayout rel11 = (RelativeLayout) findViewById(R.id.rel_day11);
        RelativeLayout rel12 = (RelativeLayout) findViewById(R.id.rel_day12);
        RelativeLayout rel13 = (RelativeLayout) findViewById(R.id.rel_day13);
        RelativeLayout rel14 = (RelativeLayout) findViewById(R.id.rel_day14);
        RelativeLayout rel15 = (RelativeLayout) findViewById(R.id.rel_day15);
        RelativeLayout rel16 = (RelativeLayout) findViewById(R.id.rel_day16);
        RelativeLayout rel17 = (RelativeLayout) findViewById(R.id.rel_day17);
        RelativeLayout rel18 = (RelativeLayout) findViewById(R.id.rel_day18);
        RelativeLayout rel19 = (RelativeLayout) findViewById(R.id.rel_day19);
        RelativeLayout rel20 = (RelativeLayout) findViewById(R.id.rel_day20);
        RelativeLayout rel21 = (RelativeLayout) findViewById(R.id.rel_day21);
        RelativeLayout rel22 = (RelativeLayout) findViewById(R.id.rel_day22);
        RelativeLayout rel23 = (RelativeLayout) findViewById(R.id.rel_day23);
        RelativeLayout rel24 = (RelativeLayout) findViewById(R.id.rel_day24);
        RelativeLayout rel25 = (RelativeLayout) findViewById(R.id.rel_day25);
        RelativeLayout rel26 = (RelativeLayout) findViewById(R.id.rel_day26);
        RelativeLayout rel27 = (RelativeLayout) findViewById(R.id.rel_day27);
        RelativeLayout rel28 = (RelativeLayout) findViewById(R.id.rel_day28);
        RelativeLayout rel29 = (RelativeLayout) findViewById(R.id.rel_day29);
        RelativeLayout rel30 = (RelativeLayout) findViewById(R.id.rel_day30);
        RelativeLayout rel31 = (RelativeLayout) findViewById(R.id.rel_day31);
        RelativeLayout rel32 = (RelativeLayout) findViewById(R.id.rel_day32);
        RelativeLayout rel33 = (RelativeLayout) findViewById(R.id.rel_day33);
        RelativeLayout rel34 = (RelativeLayout) findViewById(R.id.rel_day34);
        RelativeLayout rel35 = (RelativeLayout) findViewById(R.id.rel_day35);
        RelativeLayout rel36 = (RelativeLayout) findViewById(R.id.rel_day36);
        RelativeLayout rel37 = (RelativeLayout) findViewById(R.id.rel_day37);

        tvDay1 = (TextView) findViewById(R.id.tvday1);
        tvDay2 = (TextView) findViewById(R.id.tvday2);
        tvDay3 = (TextView) findViewById(R.id.tvday3);
        tvDay4 = (TextView) findViewById(R.id.tvday4);
        tvDay5 = (TextView) findViewById(R.id.tvday5);
        tvDay6 = (TextView) findViewById(R.id.tvday6);
        tvDay7 = (TextView) findViewById(R.id.tvday7);
        tvDay8 = (TextView) findViewById(R.id.tvday8);
        tvDay9 = (TextView) findViewById(R.id.tvday9);
        tvDay10 = (TextView) findViewById(R.id.tvday10);
        tvDay11 = (TextView) findViewById(R.id.tvday11);
        tvDay12 = (TextView) findViewById(R.id.tvday12);
        tvDay13 = (TextView) findViewById(R.id.tvday13);
        tvDay14 = (TextView) findViewById(R.id.tvday14);
        tvDay15 = (TextView) findViewById(R.id.tvday15);
        tvDay16 = (TextView) findViewById(R.id.tvday16);
        tvDay17 = (TextView) findViewById(R.id.tvday17);
        tvDay18 = (TextView) findViewById(R.id.tvday18);
        tvDay19 = (TextView) findViewById(R.id.tvday19);
        tvDay20 = (TextView) findViewById(R.id.tvday20);
        tvDay21 = (TextView) findViewById(R.id.tvday21);
        tvDay23 = (TextView) findViewById(R.id.tvday23);
        tvDay24 = (TextView) findViewById(R.id.tvday24);
        tvDay25 = (TextView) findViewById(R.id.tvday25);
        tvDay26 = (TextView) findViewById(R.id.tvday26);
        tvDay27 = (TextView) findViewById(R.id.tvday27);
        tvDay28 = (TextView) findViewById(R.id.tvday28);
        tvDay29 = (TextView) findViewById(R.id.tvday29);
        tvDay30 = (TextView) findViewById(R.id.tvday30);
        tvDay31 = (TextView) findViewById(R.id.tvday31);
        tvDay32 = (TextView) findViewById(R.id.tvday32);
        tvDay33 = (TextView) findViewById(R.id.tvday33);
        tvDay34 = (TextView) findViewById(R.id.tvday34);
        tvDay35 = (TextView) findViewById(R.id.tvday35);
        tvDay36 = (TextView) findViewById(R.id.tvday36);
        tvDay37 = (TextView) findViewById(R.id.tvday37);
        tvDay22 = (TextView) findViewById(R.id.tvday22);


        ImageView star1 = (ImageView) findViewById(R.id.im1);
        ImageView star2 = (ImageView) findViewById(R.id.im2);
        ImageView star3 = (ImageView) findViewById(R.id.im3);
        ImageView star4 = (ImageView) findViewById(R.id.im4);
        ImageView star5 = (ImageView) findViewById(R.id.im5);
        ImageView star6 = (ImageView) findViewById(R.id.im6);
        ImageView star7 = (ImageView) findViewById(R.id.im7);
        ImageView star8 = (ImageView) findViewById(R.id.im8);
        ImageView star9 = (ImageView) findViewById(R.id.im9);
        ImageView star10 = (ImageView) findViewById(R.id.im10);
        ImageView star11 = (ImageView) findViewById(R.id.im11);
        ImageView star12 = (ImageView) findViewById(R.id.im12);
        ImageView star13 = (ImageView) findViewById(R.id.im13);
        ImageView star14 = (ImageView) findViewById(R.id.im14);
        ImageView star15 = (ImageView) findViewById(R.id.im15);
        ImageView star16 = (ImageView) findViewById(R.id.im16);
        ImageView star17 = (ImageView) findViewById(R.id.im17);
        ImageView star18 = (ImageView) findViewById(R.id.im18);
        ImageView star19 = (ImageView) findViewById(R.id.im19);
        ImageView star20 = (ImageView) findViewById(R.id.im20);
        ImageView star21 = (ImageView) findViewById(R.id.im21);
        ImageView star22 = (ImageView) findViewById(R.id.im22);
        ImageView star23 = (ImageView) findViewById(R.id.im23);
        ImageView star24 = (ImageView) findViewById(R.id.im24);
        ImageView star25 = (ImageView) findViewById(R.id.im25);
        ImageView star26 = (ImageView) findViewById(R.id.im26);
        ImageView star27 = (ImageView) findViewById(R.id.im27);
        ImageView star28 = (ImageView) findViewById(R.id.im28);
        ImageView star29 = (ImageView) findViewById(R.id.im29);
        ImageView star30 = (ImageView) findViewById(R.id.im30);
        ImageView star31 = (ImageView) findViewById(R.id.im31);
        ImageView star32 = (ImageView) findViewById(R.id.im32);
        ImageView star33 = (ImageView) findViewById(R.id.im33);
        ImageView star34 = (ImageView) findViewById(R.id.im34);
        ImageView star35 = (ImageView) findViewById(R.id.im35);
        ImageView star36 = (ImageView) findViewById(R.id.im36);
        ImageView star37 = (ImageView) findViewById(R.id.im37);

        ImageView birth1 = (ImageView) findViewById(R.id.bi1);
        ImageView birth2 = (ImageView) findViewById(R.id.bi2);
        ImageView birth3 = (ImageView) findViewById(R.id.bi3);
        ImageView birth4 = (ImageView) findViewById(R.id.bi4);
        ImageView birth5 = (ImageView) findViewById(R.id.bi5);
        ImageView birth6 = (ImageView) findViewById(R.id.bi6);
        ImageView birth7 = (ImageView) findViewById(R.id.bi7);
        ImageView birth8 = (ImageView) findViewById(R.id.bi8);
        ImageView birth9 = (ImageView) findViewById(R.id.bi9);
        ImageView birth10 = (ImageView) findViewById(R.id.bi10);
        ImageView birth11 = (ImageView) findViewById(R.id.bi11);
        ImageView birth12 = (ImageView) findViewById(R.id.bi12);
        ImageView birth13 = (ImageView) findViewById(R.id.bi13);
        ImageView birth14 = (ImageView) findViewById(R.id.bi14);
        ImageView birth15 = (ImageView) findViewById(R.id.bi15);
        ImageView birth16 = (ImageView) findViewById(R.id.bi16);
        ImageView birth17 = (ImageView) findViewById(R.id.bi17);
        ImageView birth18 = (ImageView) findViewById(R.id.bi18);
        ImageView birth20 = (ImageView) findViewById(R.id.bi20);
        ImageView birth21 = (ImageView) findViewById(R.id.bi21);
        ImageView birth22 = (ImageView) findViewById(R.id.bi22);
        ImageView birth23 = (ImageView) findViewById(R.id.bi23);
        ImageView birth24 = (ImageView) findViewById(R.id.bi24);
        ImageView birth25 = (ImageView) findViewById(R.id.bi25);
        ImageView birth26 = (ImageView) findViewById(R.id.bi26);
        ImageView birth27 = (ImageView) findViewById(R.id.bi27);
        ImageView birth28 = (ImageView) findViewById(R.id.bi28);
        ImageView birth29 = (ImageView) findViewById(R.id.bi29);
        ImageView birth30 = (ImageView) findViewById(R.id.bi30);
        ImageView birth31 = (ImageView) findViewById(R.id.bi31);
        ImageView birth32 = (ImageView) findViewById(R.id.bi32);
        ImageView birth33 = (ImageView) findViewById(R.id.bi33);
        ImageView birth34 = (ImageView) findViewById(R.id.bi34);
        ImageView birth35 = (ImageView) findViewById(R.id.bi35);
        ImageView birth36 = (ImageView) findViewById(R.id.bi36);
        ImageView birth37 = (ImageView) findViewById(R.id.bi37);
        ImageView birth19 = (ImageView) findViewById(R.id.bi19);

        TextView cust1 = (TextView)findViewById(R.id.custom_tv1);
        TextView cust2 = (TextView)findViewById(R.id.custom_tv2);
        TextView cust3 = (TextView)findViewById(R.id.custom_tv3);
        TextView cust4 = (TextView)findViewById(R.id.custom_tv4);
        TextView cust5 = (TextView)findViewById(R.id.custom_tv5);
        TextView cust6 = (TextView)findViewById(R.id.custom_tv6);
        TextView cust7 = (TextView)findViewById(R.id.custom_tv7);
        TextView cust8 = (TextView)findViewById(R.id.custom_tv8);
        TextView cust9 = (TextView)findViewById(R.id.custom_tv9);
        TextView cust10 = (TextView)findViewById(R.id.custom_tv10);
        TextView cust11 = (TextView)findViewById(R.id.custom_tv11);
        TextView cust12 = (TextView)findViewById(R.id.custom_tv12);
        TextView cust13 = (TextView)findViewById(R.id.custom_tv13);
        TextView cust14 = (TextView)findViewById(R.id.custom_tv14);
        TextView cust15 = (TextView)findViewById(R.id.custom_tv15);
        TextView cust16 = (TextView)findViewById(R.id.custom_tv16);
        TextView cust17 = (TextView)findViewById(R.id.custom_tv17);
        TextView cust18 = (TextView)findViewById(R.id.custom_tv18);
        TextView cust19 = (TextView)findViewById(R.id.custom_tv19);
        TextView cust20 = (TextView)findViewById(R.id.custom_tv20);
        TextView cust21 = (TextView)findViewById(R.id.custom_tv21);
        TextView cust22 = (TextView)findViewById(R.id.custom_tv22);
        TextView cust23 = (TextView)findViewById(R.id.custom_tv23);
        TextView cust24 = (TextView)findViewById(R.id.custom_tv24);
        TextView cust25 = (TextView)findViewById(R.id.custom_tv25);
        TextView cust26 = (TextView)findViewById(R.id.custom_tv26);
        TextView cust27 = (TextView)findViewById(R.id.custom_tv27);
        TextView cust28 = (TextView)findViewById(R.id.custom_tv28);
        TextView cust29 = (TextView)findViewById(R.id.custom_tv29);
        TextView cust30 = (TextView)findViewById(R.id.custom_tv30);
        TextView cust31 = (TextView)findViewById(R.id.custom_tv31);
        TextView cust32 = (TextView)findViewById(R.id.custom_tv32);
        TextView cust33 = (TextView)findViewById(R.id.custom_tv33);
        TextView cust34 = (TextView)findViewById(R.id.custom_tv34);
        TextView cust35 = (TextView)findViewById(R.id.custom_tv35);
        TextView cust36 = (TextView)findViewById(R.id.custom_tv36);
        TextView cust37 = (TextView)findViewById(R.id.custom_tv37);


        relCurD = (RelativeLayout) findViewById(R.id.rellayout_currentdate);
        relCurD2 = (RelativeLayout) findViewById(R.id.rel_layoutcurrent2);
        relCurD3 = (RelativeLayout) findViewById(R.id.rel_layoutcurrent3);
        relCurD4 = (RelativeLayout) findViewById(R.id.rel_layoutcurrent4);
        tvCurD = (TextView) findViewById(R.id.tv_current_date);
        tvCurD2 = (TextView) findViewById(R.id.tv_layoutcurrent2);
        tvCurD3 = (TextView) findViewById(R.id.tv_layoutcurrent3);
        tvCurD4 = (TextView) findViewById(R.id.tv_layoutcurrent4);


        ImageView[] arrayCircle = {circle1, circle2, circle3, circle4, circle5, circle6, circle7, circle8, circle9, circle10, circle11, circle12,
                circle13, circle14, circle15, circle16, circle17, circle18, circle19, circle20, circle21, circle22, circle23, circle24, circle25, circle26, circle27, circle28,
                circle29, circle30, circle31, circle32, circle33, circle34, circle35, circle36, circle37};
        dayCircles = new ArrayList<>(Arrays.asList(arrayCircle));

        RelativeLayout[] dayrelativeArray = {rel1, rel2, rel3, rel4, rel5, rel6, rel7, rel8, rel9, rel10, rel11, rel12, rel13, rel14,
                rel15, rel16, rel17, rel18, rel19, rel20, rel21, rel22, rel23, rel24, rel25, rel26, rel27, rel28, rel29, rel30, rel31, rel32, rel33, rel34, rel35, rel36, rel37};
        dayRelatives = new ArrayList<>(Arrays.asList(dayrelativeArray));

        TextView[] textArray = {tvDay1, tvDay2, tvDay3, tvDay4, tvDay5, tvDay6, tvDay7, tvDay8, tvDay9, tvDay10, tvDay11, tvDay12, tvDay13, tvDay14, tvDay15,
                tvDay16, tvDay17, tvDay18, tvDay19, tvDay20, tvDay21, tvDay22, tvDay23, tvDay24, tvDay25, tvDay26, tvDay27, tvDay28, tvDay29, tvDay30,
                tvDay31, tvDay32, tvDay33, tvDay34, tvDay35, tvDay36, tvDay37};
        dayTexts = new ArrayList<>(Arrays.asList(textArray));

        ImageView[] busyDaysArray = {busy1, busy2, busy3, busy4, busy5, busy6, busy7, busy8, busy9, busy10, busy11, busy12, busy13, busy14, busy15, busy16, busy17,
                busy18, busy19, busy20, busy21, busy22, busy23, busy24, busy25, busy26, busy27, busy28, busy29, busy30, busy31, busy32, busy33, busy34, busy35, busy36, busy37};
        busyNotesIndicators = new ArrayList<>(Arrays.asList(busyDaysArray));

        ImageView[] starArray = {star1, star2, star3, star4, star5, star6, star7, star8, star9, star10, star11, star12, star13, star14, star15, star16, star17,
                star18, star19, star20, star21, star22, star23, star24, star25, star26, star27, star28, star29, star30, star31, star32, star33, star34, star35, star36, star37};
        stars = new ArrayList<>(Arrays.asList(starArray));

        ImageView[] birtdaysArray = {birth1, birth2, birth3, birth4, birth5, birth6, birth7, birth8, birth9, birth10, birth11, birth12, birth13, birth14, birth15,
                birth16, birth17, birth18, birth19, birth20, birth21, birth22, birth23, birth24, birth25, birth26, birth27, birth28, birth29, birth30, birth31, birth32, birth33,
                birth34, birth35, birth36, birth37};
        birthdays = new ArrayList<>(Arrays.asList(birtdaysArray));
        RelativeLayout[] monthRelArray = {jan, feb, mar, apr, may, jun, jul, aug, sep, oct, nov, dec};
        monthRelatives = new ArrayList<>(Arrays.asList(monthRelArray));
        TextView[] customTArray = {cust1,cust2,cust3,cust4,cust5,cust6,cust7,cust8,cust9,cust10,cust11,cust12,cust13,cust14,cust15,
        cust16,cust17,cust18,cust19,cust20,cust21,cust22,cust23,cust24,cust25,cust26,cust27,cust28,cust29,cust30,cust31,cust32,cust33,cust34,cust35,cust36,cust37};
        customRTExt = new ArrayList<>(Arrays.asList(customTArray));

        a2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.date_arrival);
        a3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.date_arrival);
        a4 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.date_arrival);
        a6 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.going_date);
        a7 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.going_date);
        a8 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.going_date);

        mPager.setAdapter(new CustomPageAdapter(MonthDayDisplaySecond.this, dataSource()));
        getAllNotesToStrings();
        setTextToPageViewer();
        colorPresentMonth(month);
        //de schimbat
        colorPresentDay();
        //
        setUpDayUI(year, month);
        Log.d(TAG, "onCreate:  index is " + monthManageClick.getAnIndex());
        for (int i = 0; i < dayRelatives.size(); i++) {
            dayRelatives.get(i).setOnLongClickListener(this);
        }
        colorTheDate(true);
        relCurD2.setVisibility(View.INVISIBLE);
        relCurD3.setVisibility(View.INVISIBLE);
        relCurD4.setVisibility(View.INVISIBLE);
        setTextToDate();
        a2.setAnimationListener(this);
        a3.setAnimationListener(this);
        a4.setAnimationListener(this);
        a6.setAnimationListener(this);
        a7.setAnimationListener(this);
        a8.setAnimationListener(this);
    }

    public void setTextToPageViewer() {
        mPager.setAdapter(null);
        //
        getAllNotesToStrings();
        //
        dataSource();
        mPager.setAdapter(new CustomPageAdapter(MonthDayDisplaySecond.this, dataSource()));
        Log.e(TAG, "setTextToPageViewer: ");


    }

    public void colorTheDate(boolean red) {
        if (red) {
            relCurD.setBackgroundResource(R.drawable.date_circle_red);
            tvCurD.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.selcted_red));

        } else {
            relCurD.setBackgroundResource(R.drawable.date_circle);
            tvCurD.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.stronger_blue));
        }
    }

    public void dateBaloonAnim() {
        Random r = new Random();
        a3.setStartOffset(r.nextInt(100));
        a4.setStartOffset(r.nextInt(100));
        relCurD2.startAnimation(a2);
        relCurD3.startAnimation(a3);
        relCurD4.startAnimation(a4);
    }

    public void goingAnimation() {
        a7.setStartOffset(100);
        a8.setStartOffset(200);
        relCurD4.startAnimation(a6);
        relCurD3.startAnimation(a7);
        relCurD2.startAnimation(a8);
    }

    public void setTextToDate() {
        Calendar cal = Calendar.getInstance();
        if (year != cal.get(Calendar.YEAR)) {
            tvCurD.setText("ATTENTION!");
            tvCurD2.setText("YEAR");
            tvCurD3.setText("IS");
            tvCurD4.setText(""+year);
            relCurD2.setVisibility(View.VISIBLE);
            relCurD3.setVisibility(View.VISIBLE);
            relCurD4.setVisibility(View.VISIBLE);
        } else {

            String monthName = "";
            switch (month) {
                case 0:
                    monthName = "Jan";
                    break;
                case 1:
                    monthName = "Feb";
                    break;
                case 2:
                    monthName = "Mar";
                    break;
                case 3:
                    monthName = "Apr";
                    break;
                case 4:
                    monthName = "May";
                    break;
                case 5:
                    monthName = "June";
                    break;
                case 6:
                    monthName = "July";
                    break;
                case 7:
                    monthName = "Aug";
                    break;
                case 8:
                    monthName = "Sep";
                    break;
                case 9:
                    monthName = "Oct";
                    break;
                case 10:
                    monthName = "Nov";
                    break;
                case 11:
                    monthName = "Dec";
                    break;
            }

            boolean check = mSharedPreferences.getBoolean(Settings.DATESET, false);
            if (mSharedPreferences.contains(Settings.DATESET)) {
                if (check) {
                    tvCurD2.setText(monthName);
                    tvCurD3.setText(" " + day);
                    ;
                } else {
                    tvCurD2.setText(" " + day);
                    tvCurD3.setText(monthName);
                }
            } else {
                tvCurD2.setText(" " + day);
                tvCurD3.setText(monthName);
            }
            tvCurD4.setText(" " + year);
        }
    }
    public void getSavedDate(){

        year = mSharedPreferences.getInt(MainActivity.NOWYEAR, 0);
        month = mSharedPreferences.getInt(MainActivity.NOWMONTH, 0);
        day = mSharedPreferences.getInt(MainActivity.NOWDAY, 0);



    }
    public void getAllNotesToStrings(){

        if(monthManageClick.getNowMonth() == -1 && monthManageClick.getNowDay() ==0){
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
        }else if(monthManageClick.getNowMonth() != -1 && monthManageClick.getNowDay() ==0) {
            noteHour8 = mMyDB.getNoteByHour(year, monthManageClick.getNowMonth(), day, 8);
            noteHour9 = mMyDB.getNoteByHour(year, monthManageClick.getNowMonth(), day, 9);
            noteHour10 = mMyDB.getNoteByHour(year, monthManageClick.getNowMonth(), day, 10);
            noteHour11 = mMyDB.getNoteByHour(year, monthManageClick.getNowMonth(), day, 11);
            noteHour12 = mMyDB.getNoteByHour(year, monthManageClick.getNowMonth(), day, 12);
            noteHour13 = mMyDB.getNoteByHour(year, monthManageClick.getNowMonth(), day, 13);
            noteHour14 = mMyDB.getNoteByHour(year, monthManageClick.getNowMonth(), day, 14);
            noteHour15 = mMyDB.getNoteByHour(year, monthManageClick.getNowMonth(), day, 15);
            noteHour16 = mMyDB.getNoteByHour(year, monthManageClick.getNowMonth(), day, 16);
            noteHour17 = mMyDB.getNoteByHour(year, monthManageClick.getNowMonth(), day, 17);
            noteHour18 = mMyDB.getNoteByHour(year, monthManageClick.getNowMonth(), day, 18);
            noteHour19 = mMyDB.getNoteByHour(year, monthManageClick.getNowMonth(), day, 19);
            noteHour20 = mMyDB.getNoteByHour(year, monthManageClick.getNowMonth(), day, 20);
        }else if(monthManageClick.getNowMonth() == -1 && monthManageClick.getNowDay() !=0) {
            noteHour8 =mMyDB.getNoteByHour(year,month,monthManageClick.getNowDay(),8);
            noteHour9 =mMyDB.getNoteByHour(year,month,monthManageClick.getNowDay(),9);
            noteHour10 =mMyDB.getNoteByHour(year,month,monthManageClick.getNowDay(),10);
            noteHour11 =mMyDB.getNoteByHour(year,month,monthManageClick.getNowDay(),11);
            noteHour12 = mMyDB.getNoteByHour(year,month,monthManageClick.getNowDay(),12);
            noteHour13 =mMyDB.getNoteByHour(year,month,monthManageClick.getNowDay(),13);
            noteHour14 =mMyDB.getNoteByHour(year,month,monthManageClick.getNowDay(),14);
            noteHour15 =mMyDB.getNoteByHour(year,month,monthManageClick.getNowDay(),15);
            noteHour16 =mMyDB.getNoteByHour(year,month,monthManageClick.getNowDay(),16);
            noteHour17 = mMyDB.getNoteByHour(year,month,monthManageClick.getNowDay(),17);
            noteHour18 =mMyDB.getNoteByHour(year,month,monthManageClick.getNowDay(),18);
            noteHour19 = mMyDB.getNoteByHour(year,month,monthManageClick.getNowDay(),19);
            noteHour20 =mMyDB.getNoteByHour(year,month,monthManageClick.getNowDay(),20);
        }else{
            noteHour8 =mMyDB.getNoteByHour(year,monthManageClick.getNowMonth(),monthManageClick.getNowDay(),8);
            noteHour9 =mMyDB.getNoteByHour(year,monthManageClick.getNowMonth(),monthManageClick.getNowDay(),9);
            noteHour10 =mMyDB.getNoteByHour(year,monthManageClick.getNowMonth(),monthManageClick.getNowDay(),10);
            noteHour11 =mMyDB.getNoteByHour(year,monthManageClick.getNowMonth(),monthManageClick.getNowDay(),11);
            noteHour12 = mMyDB.getNoteByHour(year,monthManageClick.getNowMonth(),monthManageClick.getNowDay(),12);
            noteHour13 =mMyDB.getNoteByHour(year,monthManageClick.getNowMonth(),monthManageClick.getNowDay(),13);
            noteHour14 =mMyDB.getNoteByHour(year,monthManageClick.getNowMonth(),monthManageClick.getNowDay(),14);
            noteHour15 =mMyDB.getNoteByHour(year,monthManageClick.getNowMonth(),monthManageClick.getNowDay(),15);
            noteHour16 =mMyDB.getNoteByHour(year,monthManageClick.getNowMonth(),monthManageClick.getNowDay(),16);
            noteHour17 = mMyDB.getNoteByHour(year,monthManageClick.getNowMonth(),monthManageClick.getNowDay(),17);
            noteHour18 =mMyDB.getNoteByHour(year,monthManageClick.getNowMonth(),monthManageClick.getNowDay(),18);
            noteHour19 = mMyDB.getNoteByHour(year,monthManageClick.getNowMonth(),monthManageClick.getNowDay(),19);
            noteHour20 =mMyDB.getNoteByHour(year,monthManageClick.getNowMonth(),monthManageClick.getNowDay(),20);

        }

    }

    private List<DataObject> dataSource(){
        List<DataObject> data = new ArrayList<DataObject>();
        data.add(new DataObject(R.drawable.thehour08,noteHour8,R.drawable.thehour09,noteHour9,R.drawable.thehour10,noteHour10,R.drawable.thehour11,noteHour11));
        data.add(new DataObject(R.drawable.thehour12,noteHour12,R.drawable.thehour13,noteHour13,R.drawable.thehour14,noteHour14,R.drawable.thehour15,noteHour15));
        data.add(new DataObject(R.drawable.thehour16,noteHour16,R.drawable.thehour17,noteHour17,R.drawable.thehour18,noteHour18,R.drawable.thehour19,noteHour19));
        data.add(new DataObject(R.drawable.thehour20,noteHour20,R.drawable.thehour_empty,"",R.drawable.thehour_empty,"",R.drawable.thehour_empty,""));


        return data;
    }
    public void setNonClickableButtons(RelativeLayout clickll, TextView clickTV, ImageView clickBusy, ImageView clickStars,
                                       ImageView clickBirth, TextView customtext, int monthToSelect, int generalYear, int dayFromMonth){
        clickll.setAlpha(0.4f);
        clickll.setEnabled(false);
        clickTV.setText(""+dayFromMonth);
        manageBusyDays(clickBusy,generalYear,monthToSelect,dayFromMonth);
        manageStars(clickStars,generalYear,monthToSelect,dayFromMonth);
        manageBirthdays(clickBirth,monthToSelect,dayFromMonth);
        manageCustomText(customtext,generalYear,monthToSelect,dayFromMonth);

    }

    public void setUpDayUI(int ayear, int amonth) {
        Calendar c = Calendar.getInstance();
        c.set(ayear, amonth, 1);
        int counter = 0;
        int aDay = c.get(Calendar.DAY_OF_WEEK);
        int monthLenght = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        int beforeMonthLenght = 0;
        if(amonth != 0){
            c.set(ayear,amonth-1,1);
            beforeMonthLenght = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        }else {
            c.set(ayear-1,12,1);
            beforeMonthLenght = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        }


        switch (aDay) {
            case 1:
                for (int i = 0; i < dayRelatives.size(); i++) {
                    dayRelatives.get(i).setEnabled(true);
                    dayRelatives.get(i).setAlpha(1);
                    dayRelatives.get(i).setVisibility(View.VISIBLE);
                    if (i < 6 || i>(monthLenght+5)) {
                        if(i == 5) {
                            setNonClickableButtons(dayRelatives.get(5), dayTexts.get(5), busyNotesIndicators.get(5), stars.get(5), birthdays.get(5),customRTExt.get(5), amonth - 1, ayear, beforeMonthLenght);
                        }else dayRelatives.get(i).setVisibility(View.INVISIBLE);
                    } else {
                        counter++;
                        dayRelatives.get(i).setAlpha(1);
                        dayRelatives.get(i).setVisibility(View.VISIBLE);
                        dayTexts.get(i).setText(""+counter);
                        manageBusyDays(busyNotesIndicators.get(i),ayear,amonth,counter);
                        manageStars(stars.get(i),ayear,amonth,counter);
                        manageBirthdays(birthdays.get(i),amonth,counter);
                        manageCustomText(customRTExt.get(i),ayear,amonth,counter);
                        colorCurrentDaysAndOnCreate(counter,i);
                    }
                }

                break;
            case 2:
                for (int i = 0; i < dayRelatives.size(); i++) {
                    dayRelatives.get(i).setEnabled(true);
                    dayRelatives.get(i).setAlpha(1);
                    dayRelatives.get(i).setVisibility(View.VISIBLE);
                    if ( i>(monthLenght-1)) {
                        dayRelatives.get(i).setVisibility(View.INVISIBLE);
                    } else {
                        counter++;
                        dayRelatives.get(i).setVisibility(View.VISIBLE);
                        dayTexts.get(i).setText(""+counter);
                        manageBusyDays(busyNotesIndicators.get(i),ayear,amonth,counter);
                        manageStars(stars.get(i),ayear,amonth,counter);
                        manageBirthdays(birthdays.get(i),amonth,counter);
                        manageCustomText(customRTExt.get(i),ayear,amonth,counter);
                        colorCurrentDaysAndOnCreate(counter,i);
                    }
                }
                break;
            case 3:
                for (int i = 0; i < dayRelatives.size(); i++) {
                    dayRelatives.get(i).setEnabled(true);
                    dayRelatives.get(i).setAlpha(1);
                    dayRelatives.get(i).setVisibility(View.VISIBLE);
                    if (i < 1 || i>(monthLenght)) {
                        if(i == 0) {
                            setNonClickableButtons(dayRelatives.get(0), dayTexts.get(0), busyNotesIndicators.get(0),  stars.get(0), birthdays.get(0),customRTExt.get(0), amonth - 1, ayear, beforeMonthLenght);
                        }else dayRelatives.get(i).setVisibility(View.INVISIBLE);
                    } else {
                        counter++;
                        dayRelatives.get(i).setVisibility(View.VISIBLE);
                        dayTexts.get(i).setText(""+counter);
                        manageBusyDays(busyNotesIndicators.get(i),ayear,amonth,counter);
                        manageStars(stars.get(i),ayear,amonth,counter);
                        manageBirthdays(birthdays.get(i),amonth,counter);
                        manageCustomText(customRTExt.get(i),ayear,amonth,counter);
                        colorCurrentDaysAndOnCreate(counter,i);
                    }
                }
                break;
            case 4:
                for (int i = 0; i < dayRelatives.size(); i++) {
                    dayRelatives.get(i).setEnabled(true);
                    dayRelatives.get(i).setAlpha(1);
                    dayRelatives.get(i).setVisibility(View.VISIBLE);
                    if (i < 2 || i>(monthLenght+1)) {
                        if(i == 1) {
                            setNonClickableButtons(dayRelatives.get(1), dayTexts.get(1), busyNotesIndicators.get(1),  stars.get(1), birthdays.get(1), customRTExt.get(1), amonth - 1, ayear, beforeMonthLenght);
                        }else dayRelatives.get(i).setVisibility(View.INVISIBLE);
                    } else {
                        counter++;
                        dayRelatives.get(i).setVisibility(View.VISIBLE);
                        dayTexts.get(i).setText(""+counter);
                        manageBusyDays(busyNotesIndicators.get(i),ayear,amonth,counter);
                        manageStars(stars.get(i),ayear,amonth,counter);
                        manageBirthdays(birthdays.get(i),amonth,counter);
                        manageCustomText(customRTExt.get(i),ayear,amonth,counter);
                        colorCurrentDaysAndOnCreate(counter,i);

                    }
                }
                break;
            case 5:
                for (int i = 0; i < dayRelatives.size(); i++) {
                    dayRelatives.get(i).setEnabled(true);
                    dayRelatives.get(i).setAlpha(1);
                    dayRelatives.get(i).setVisibility(View.VISIBLE);
                    if (i < 3 || i>(monthLenght+2)) {
                        if(i == 2) {
                            setNonClickableButtons(dayRelatives.get(2), dayTexts.get(2), busyNotesIndicators.get(2), stars.get(2), birthdays.get(2),customRTExt.get(2), amonth - 1, ayear, beforeMonthLenght);
                        }else dayRelatives.get(i).setVisibility(View.INVISIBLE);
                    } else {
                        counter++;
                        dayRelatives.get(i).setVisibility(View.VISIBLE);
                        dayTexts.get(i).setText(""+counter);
                        manageBusyDays(busyNotesIndicators.get(i),ayear,amonth,counter);
                        manageStars(stars.get(i),ayear,amonth,counter);
                        manageBirthdays(birthdays.get(i),amonth,counter);
                        manageCustomText(customRTExt.get(i),ayear,amonth,counter);
                        colorCurrentDaysAndOnCreate(counter,i);
                    }
                }
                break;
            case 6:
                for (int i = 0; i < dayRelatives.size(); i++) {
                    dayRelatives.get(i).setEnabled(true);
                    dayRelatives.get(i).setAlpha(1);
                    dayRelatives.get(i).setVisibility(View.VISIBLE);
                    if (i < 4 || i>(monthLenght+3)) {
                        if(i == 3) {
                            setNonClickableButtons(dayRelatives.get(3), dayTexts.get(3), busyNotesIndicators.get(3),  stars.get(3), birthdays.get(3),customRTExt.get(3), amonth - 1, ayear, beforeMonthLenght);
                        }else dayRelatives.get(i).setVisibility(View.INVISIBLE);
                    } else {
                        counter++;
                        dayRelatives.get(i).setVisibility(View.VISIBLE);
                        dayTexts.get(i).setText(""+counter);
                        manageBusyDays(busyNotesIndicators.get(i),ayear,amonth,counter);
                        manageStars(stars.get(i),ayear,amonth,counter);
                        manageBirthdays(birthdays.get(i),amonth,counter);
                        manageCustomText(customRTExt.get(i),ayear,amonth,counter);
                        colorCurrentDaysAndOnCreate(counter,i);
                    }
                }
                break;
            case 7:
                for (int i = 0; i < dayRelatives.size(); i++) {
                    dayRelatives.get(i).setEnabled(true);
                    dayRelatives.get(i).setAlpha(1);
                    dayRelatives.get(i).setVisibility(View.VISIBLE);
                    if (i < 5 || i>(monthLenght+4)) {
                        if(i == 4) {
                            setNonClickableButtons(dayRelatives.get(4), dayTexts.get(4), busyNotesIndicators.get(4), stars.get(4), birthdays.get(4),customRTExt.get(4), amonth - 1, ayear, beforeMonthLenght);
                        }else dayRelatives.get(i).setVisibility(View.INVISIBLE);
                    } else {
                        counter++;
                        dayRelatives.get(i).setVisibility(View.VISIBLE);
                        dayTexts.get(i).setText(""+counter);
                        manageBusyDays(busyNotesIndicators.get(i),ayear,amonth,counter);
                        manageStars(stars.get(i),ayear,amonth,counter);
                        manageBirthdays(birthdays.get(i),amonth,counter);
                        manageCustomText(customRTExt.get(i),ayear,amonth,counter);
                        colorCurrentDaysAndOnCreate(counter,i);
                    }
                }
                break;
        }

    }

    public void colorCurrentDaysAndOnCreate(int aCounter, int index) {

        switch (monthManageClick.getNowMonth()) {
            case -1:
                if (aCounter == day) {
                    dayCircles.get(index).setImageResource(R.drawable.soft_red_circle_selected);
                    monthManageClick.setAnIndex(index);
                }
                break;
            default:
                if ((aCounter == day) && (monthManageClick.getNowMonth() == month)) {
                    dayCircles.get(index).setImageResource(R.drawable.soft_red_circle_selected);
                    monthManageClick.setAnIndex(index);
                }else if((aCounter == monthManageClick.getNowDay()) && (monthManageClick.getNowMonth() != month)){
                    dayCircles.get(index).setImageResource(R.drawable.soft_red_circle_selected);
                    monthManageClick.setAnIndex(index);
                }
                break;
        }

    }

    public void manageBusyDays(ImageView im, int currYear, int currMonth, int currDay ){
        int number = mMyDB.getNumberOfDailyNotes(currYear, currMonth, currDay);
        switch (number){
            case 0: im.setImageResource(R.drawable.circle_busy0sec2);
                break;
            case 1: im.setImageResource(R.drawable.circle_busy1);
                break;
            case 2: im.setImageResource(R.drawable.circle_busy2);
                break;
            case 3: im.setImageResource(R.drawable.circle_busy3);
                break;
            case 4: im.setImageResource(R.drawable.circle_busy4);
                break;
            case 5: im.setImageResource(R.drawable.circle_busy5);
                break;
            case 6: im.setImageResource(R.drawable.circle_busy6);
                break;
            case 7: im.setImageResource(R.drawable.circle_busy7);
                break;
            case 8: im.setImageResource(R.drawable.circle_busy8);
                break;
            case 9: im.setImageResource(R.drawable.circle_busy9);
                break;
            case 10: im.setImageResource(R.drawable.circle_busy10);
                break;
            case 11: im.setImageResource(R.drawable.circle_busy11);
                break;
            case 12: im.setImageResource(R.drawable.circle_busy12);
                break;
            case 13: im.setImageResource(R.drawable.circle_busy13);
                break;
        }
    }

    public void manageStars(ImageView sIm, int syear, int smonth, int sday) {

        boolean check = mMyDB.checkForStar(syear, smonth, sday, Hour_activity.STARIDENTIFIER);

        if (check) {

            sIm.setVisibility(View.VISIBLE);
        } else sIm.setVisibility(View.INVISIBLE);


    }
    public void manageBirthdays(ImageView bIm,  int bmonth, int bday) {

        boolean checkb = mMyDB.birthCheck(bmonth,bday);

        if (checkb) {
            bIm.setVisibility(View.VISIBLE);
        } else bIm.setVisibility(View.INVISIBLE);


    }
    public void manageCustomText(TextView cus, int cusyear, int cusmonth, int cusday){
        boolean checkCus = mMyDB.customRCheck(cusyear,cusmonth,cusday);
        if(checkCus){
            cus.setVisibility(View.VISIBLE);
            cus.setText( mMyDB.getCustomRByDay(cusyear,cusmonth,cusday));
        }else{
            cus.setVisibility(View.INVISIBLE);
        }
    }

    public void clickDays(View v){

        if((monthManageClick.getNowMonth() == month) ||  (monthManageClick.getNowMonth() == -1)){
            animationManagement(v,dayRelatives.get(monthManageClick.getAnIndex()));
            for(int i = 0 ; i<dayRelatives.size(); i++){
                if(i == monthManageClick.getAnIndex()){
                    dayCircles.get(i).setImageResource(R.drawable.dark_blue_circle_currentday);
                }else {
                    dayCircles.get(i).setImageResource(R.drawable.soft_blue_circle_normal);
                }
            }
        }else {
            for(int i = 0 ; i<dayRelatives.size(); i++){
                    dayCircles.get(i).setImageResource(R.drawable.soft_blue_circle_normal);
            }
        }



        switch (v.getId()){
            case R.id.rel_day1:
                circle1.setImageResource(R.drawable.soft_red_circle_selected);
                 monthManageClick.setNowDay(Integer.parseInt(tvDay1.getText().toString()));
                monthManageClick.setIndexForPostResume(0);
                break;
            case R.id.rel_day2:
                circle2.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowDay(Integer.parseInt(tvDay2.getText().toString()));
                monthManageClick.setIndexForPostResume(1);
                break;
            case R.id.rel_day3:
                circle3.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowDay(Integer.parseInt(tvDay3.getText().toString()));
                monthManageClick.setIndexForPostResume(2);
                break;
            case R.id.rel_day4:
                circle4.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowDay(Integer.parseInt(tvDay4.getText().toString()));
                monthManageClick.setIndexForPostResume(3);
                break;
            case R.id.rel_day5:
                circle5.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowDay(Integer.parseInt(tvDay5.getText().toString()));
                monthManageClick.setIndexForPostResume(4);
                break;
            case R.id.rel_day6:
                circle6.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowDay(Integer.parseInt(tvDay6.getText().toString()));
                monthManageClick.setIndexForPostResume(5);
                break;
            case R.id.rel_day7:
                circle7.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowDay(Integer.parseInt(tvDay7.getText().toString()));
                monthManageClick.setIndexForPostResume(6);
                break;
            case R.id.rel_day8:
                circle8.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowDay(Integer.parseInt(tvDay8.getText().toString()));
                monthManageClick.setIndexForPostResume(7);
                break;
            case R.id.rel_day9:
                circle9.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowDay(Integer.parseInt(tvDay9.getText().toString()));
                monthManageClick.setIndexForPostResume(8);
                break;
            case R.id.rel_day10:
                circle10.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowDay(Integer.parseInt(tvDay10.getText().toString()));
                monthManageClick.setIndexForPostResume(9);
                break;
            case R.id.rel_day11:
                circle11.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowDay(Integer.parseInt(tvDay11.getText().toString()));
                monthManageClick.setIndexForPostResume(10);
                break;
            case R.id.rel_day12:
                circle12.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowDay(Integer.parseInt(tvDay12.getText().toString()));
                monthManageClick.setIndexForPostResume(11);
                break;
            case R.id.rel_day13:
                circle13.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowDay(Integer.parseInt(tvDay13.getText().toString()));
                monthManageClick.setIndexForPostResume(12);
                break;
            case R.id.rel_day14:
                circle14.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowDay(Integer.parseInt(tvDay14.getText().toString()));
                monthManageClick.setIndexForPostResume(13);
                break;
            case R.id.rel_day15:
                circle15.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowDay(Integer.parseInt(tvDay15.getText().toString()));
                monthManageClick.setIndexForPostResume(14);
                break;
            case R.id.rel_day16:
                circle16.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowDay(Integer.parseInt(tvDay16.getText().toString()));
                monthManageClick.setIndexForPostResume(15);
                break;
            case R.id.rel_day17:
                circle17.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowDay(Integer.parseInt(tvDay17.getText().toString()));
                monthManageClick.setIndexForPostResume(16);
                break;
            case R.id.rel_day18:
                circle18.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowDay(Integer.parseInt(tvDay18.getText().toString()));
                monthManageClick.setIndexForPostResume(17);
                break;
            case R.id.rel_day19:
                circle19.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowDay(Integer.parseInt(tvDay19.getText().toString()));
                monthManageClick.setIndexForPostResume(18);
                break;
            case R.id.rel_day20:
                circle20.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowDay(Integer.parseInt(tvDay20.getText().toString()));
                monthManageClick.setIndexForPostResume(19);
                break;
            case R.id.rel_day21:
                circle21.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowDay(Integer.parseInt(tvDay21.getText().toString()));
                monthManageClick.setIndexForPostResume(20);
                break;
            case R.id.rel_day22:
                circle22.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowDay(Integer.parseInt(tvDay22.getText().toString()));
                monthManageClick.setIndexForPostResume(21);
                break;
            case R.id.rel_day23:
                circle23.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowDay(Integer.parseInt(tvDay23.getText().toString()));
                monthManageClick.setIndexForPostResume(22);
                break;
            case R.id.rel_day24:
                circle24.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowDay(Integer.parseInt(tvDay24.getText().toString()));
                monthManageClick.setIndexForPostResume(23);
                break;
            case R.id.rel_day25:
                circle25.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowDay(Integer.parseInt(tvDay25.getText().toString()));
                monthManageClick.setIndexForPostResume(24);
                break;
            case R.id.rel_day26:
                circle26.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowDay(Integer.parseInt(tvDay26.getText().toString()));
                monthManageClick.setIndexForPostResume(25);
                break;
            case R.id.rel_day27:
                circle27.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowDay(Integer.parseInt(tvDay27.getText().toString()));
                monthManageClick.setIndexForPostResume(26);
                break;
            case R.id.rel_day28:
                circle28.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowDay(Integer.parseInt(tvDay28.getText().toString()));
                monthManageClick.setIndexForPostResume(27);
                break;
            case R.id.rel_day29:
                circle29.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowDay(Integer.parseInt(tvDay29.getText().toString()));
                monthManageClick.setIndexForPostResume(28);
                break;
            case R.id.rel_day30:
                circle30.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowDay(Integer.parseInt(tvDay30.getText().toString()));
                monthManageClick.setIndexForPostResume(29);
                break;
            case R.id.rel_day31:
                circle31.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowDay(Integer.parseInt(tvDay31.getText().toString()));
                monthManageClick.setIndexForPostResume(30);
                break;
            case R.id.rel_day32:
                circle32.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowDay(Integer.parseInt(tvDay32.getText().toString()));
                monthManageClick.setIndexForPostResume(31);
                break;
            case R.id.rel_day33:
                circle33.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowDay(Integer.parseInt(tvDay33.getText().toString()));
                monthManageClick.setIndexForPostResume(32);
                break;
            case R.id.rel_day34:
                circle34.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowDay(Integer.parseInt(tvDay34.getText().toString()));
                monthManageClick.setIndexForPostResume(33);
                break;
            case R.id.rel_day35:
                circle35.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowDay(Integer.parseInt(tvDay35.getText().toString()));
                monthManageClick.setIndexForPostResume(34);
                break;
            case R.id.rel_day36:
                circle36.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowDay(Integer.parseInt(tvDay36.getText().toString()));
                monthManageClick.setIndexForPostResume(35);
                break;
            case R.id.rel_day37:
                circle37.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowDay(Integer.parseInt(tvDay37.getText().toString()));
                monthManageClick.setIndexForPostResume(36);
                break;
        }


        getAllNotesToStrings();
        setTextToPageViewer();
        //monthManageClick.setDayClick((RelativeLayout)v);
        updatePreferences();

    }
    public void animationManagement(View vClicked, View vCurrentMonthDay){

        if(vClicked.getId() == vCurrentMonthDay.getId()){
            if(monthManageClick.isOnceFlag()){
                Log.d(TAG, "trueeeee: " + monthManageClick.isOnceFlag());
                goingAnimation();
                monthManageClick.setOnceFlag(false);
            }

        }else{
            if(!monthManageClick.isOnceFlag()){
                Log.d(TAG, "falseeeee: " + monthManageClick.isOnceFlag());
                dateBaloonAnim();
                monthManageClick.setOnceFlag(true);
            }
        }

    }
    public void clickMonthsRel(View v) {

        colorPresentDay();
        monthManageClick.setDayClick(null);



        if (monthManageClick.getNowMonth() == -1) {
            colorPresentMonthOnFirstiClick(month);

        }
        if(v.getId() != monthRelatives.get(month).getId()){
            monthManageClick.setNowDay(1);
        }else monthManageClick.setNowDay(day);
        animationManagement(v,monthRelatives.get(month));


        switch (v.getId()) {
            case R.id.mjan:
                janim.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowMonth(0);
                break;
            case R.id.mfeb:
                febim.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowMonth(1);
                break;
            case R.id.mmar:
                marim.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowMonth(2);
                break;
            case R.id.mapr:
                aprim.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowMonth(3);
                break;
            case R.id.mmay:
                mayim.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowMonth(4);
                break;
            case R.id.mjun:
                junim.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowMonth(5);
                break;
            case R.id.mjul:
                julim.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowMonth(6);
                break;
            case R.id.maug:
                augim.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowMonth(7);
                break;
            case R.id.msep:
                sepim.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowMonth(8);
                break;
            case R.id.moct:
                octim.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowMonth(9);
                break;
            case R.id.mnov:
                novim.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowMonth(10);
                break;
            case R.id.mdec:
                decim.setImageResource(R.drawable.soft_red_circle_selected);
                monthManageClick.setNowMonth(11);
                break;
        }

        if (monthManageClick.getClicked() != null) {
            if (monthManageClick.getClicked().getId() != v.getId()) {
                Log.d(TAG, "clickMonthsRel: " + monthManageClick.getFlagAnimation());

                switch (monthManageClick.getClicked().getId()) {
                    case R.id.mjan:
                        if (month == 0) {
                            janim.setImageResource(R.drawable.dark_blue_circle_currentday);
                        } else {
                            janim.setImageResource(R.drawable.soft_blue_circle_normal);
                        }
                        break;
                    case R.id.mfeb:
                        if (month == 1) {
                            febim.setImageResource(R.drawable.dark_blue_circle_currentday);
                        } else {
                            febim.setImageResource(R.drawable.soft_blue_circle_normal);
                        }
                        break;
                    case R.id.mmar:
                        if (month == 2) {
                            marim.setImageResource(R.drawable.dark_blue_circle_currentday);
                        } else {
                            marim.setImageResource(R.drawable.soft_blue_circle_normal);
                        }
                        break;
                    case R.id.mapr:
                        if (month == 3) {
                            aprim.setImageResource(R.drawable.dark_blue_circle_currentday);
                        } else {
                            aprim.setImageResource(R.drawable.soft_blue_circle_normal);
                        }
                        break;
                    case R.id.mmay:
                        if (month == 4) {
                            mayim.setImageResource(R.drawable.dark_blue_circle_currentday);
                        } else {
                            mayim.setImageResource(R.drawable.soft_blue_circle_normal);
                        }
                        break;
                    case R.id.mjun:
                        if (month == 5) {
                            junim.setImageResource(R.drawable.dark_blue_circle_currentday);
                        } else {
                            junim.setImageResource(R.drawable.soft_blue_circle_normal);
                        }
                        break;
                    case R.id.mjul:
                        if (month == 6) {
                            julim.setImageResource(R.drawable.dark_blue_circle_currentday);
                        } else {
                            julim.setImageResource(R.drawable.soft_blue_circle_normal);
                        }
                        break;
                    case R.id.maug:
                        if (month == 7) {
                            augim.setImageResource(R.drawable.dark_blue_circle_currentday);
                        } else {
                            augim.setImageResource(R.drawable.soft_blue_circle_normal);
                        }
                        break;
                    case R.id.msep:
                        if (month == 8) {
                            sepim.setImageResource(R.drawable.dark_blue_circle_currentday);
                        } else {
                            sepim.setImageResource(R.drawable.soft_blue_circle_normal);
                        }
                        break;
                    case R.id.moct:
                        if (month == 9) {
                            octim.setImageResource(R.drawable.dark_blue_circle_currentday);
                        } else {
                            octim.setImageResource(R.drawable.soft_blue_circle_normal);
                        }
                        break;
                    case R.id.mnov:
                        if (month == 10) {
                            novim.setImageResource(R.drawable.dark_blue_circle_currentday);
                        } else {
                            novim.setImageResource(R.drawable.soft_blue_circle_normal);
                        }
                        break;
                    case R.id.mdec:
                        if (month == 11) {
                            decim.setImageResource(R.drawable.dark_blue_circle_currentday);
                        } else {
                            decim.setImageResource(R.drawable.soft_blue_circle_normal);
                        }
                        break;

                }


            }
        }

        monthManageClick.setClicked((RelativeLayout) v);


        setTextToPageViewer();
        setUpDayUI(year, monthManageClick.getNowMonth());

        //
        updatePreferences();




    }
    public void colorPresentMonth(int present){
       switch (present){
           case 0: janim.setImageResource(R.drawable.soft_red_circle_selected);
               break;
           case 1: febim.setImageResource(R.drawable.soft_red_circle_selected);
               break;
           case 2: marim.setImageResource(R.drawable.soft_red_circle_selected);
               break;
           case 3: aprim.setImageResource(R.drawable.soft_red_circle_selected);
               break;
           case 4: mayim.setImageResource(R.drawable.soft_red_circle_selected);
               break;
           case 5: junim.setImageResource(R.drawable.soft_red_circle_selected);
               break;
           case 6: julim.setImageResource(R.drawable.soft_red_circle_selected);
               break;
           case 7: augim.setImageResource(R.drawable.soft_red_circle_selected);
               break;
           case 8: sepim.setImageResource(R.drawable.soft_red_circle_selected);
               break;
           case 9: octim.setImageResource(R.drawable.soft_red_circle_selected);
               break;
           case 10: novim.setImageResource(R.drawable.soft_red_circle_selected);
               break;
           case 11: decim.setImageResource(R.drawable.soft_red_circle_selected);
               break;
       }
    }

    public void colorPresentMonthOnFirstiClick(int present){
        switch (present){
            case 0: janim.setImageResource(R.drawable.dark_blue_circle_currentday);
                break;
            case 1: febim.setImageResource(R.drawable.dark_blue_circle_currentday);
                break;
            case 2: marim.setImageResource(R.drawable.dark_blue_circle_currentday);
                break;
            case 3: aprim.setImageResource(R.drawable.dark_blue_circle_currentday);
                break;
            case 4: mayim.setImageResource(R.drawable.dark_blue_circle_currentday);
                break;
            case 5: junim.setImageResource(R.drawable.dark_blue_circle_currentday);
                break;
            case 6: julim.setImageResource(R.drawable.dark_blue_circle_currentday);
                break;
            case 7: augim.setImageResource(R.drawable.dark_blue_circle_currentday);
                break;
            case 8: sepim.setImageResource(R.drawable.dark_blue_circle_currentday);
                break;
            case 9: octim.setImageResource(R.drawable.dark_blue_circle_currentday);
                break;
            case 10: novim.setImageResource(R.drawable.dark_blue_circle_currentday);
                break;
            case 11: decim.setImageResource(R.drawable.dark_blue_circle_currentday);
                break;
        }
    }

    public void colorPresentDay(){
        for(int i = 0; i< dayCircles.size() ; i++ ){

            dayCircles.get(i).setImageResource(R.drawable.soft_blue_circle_normal);
        }

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        Calendar postCheck = Calendar.getInstance();
        if(monthManageClick.getOnCreateDay() != postCheck.get(Calendar.DAY_OF_MONTH)){
            MonthDayDisplaySecond.this.recreate();
        }
        if(recreatingOnResume){
            recreatingOnResume = false;
            recreate();
        }


        //colorPresentDay();
        int checkMonth;
        if(monthManageClick.getNowMonth() !=-1){
            checkMonth = monthManageClick.getNowMonth();
        }else checkMonth = month;
        if (monthManageClick.getNowDay() != 0) {
            if (monthManageClick.getIndexForPostResume() != -1) {
                manageBusyDays(busyNotesIndicators.get(monthManageClick.getIndexForPostResume()), year, checkMonth, monthManageClick.getNowDay());
                manageStars(stars.get(monthManageClick.getIndexForPostResume()), year, checkMonth, monthManageClick.getNowDay());
                manageBirthdays(birthdays.get(monthManageClick.getIndexForPostResume()), checkMonth, monthManageClick.getNowDay());
                manageCustomText(customRTExt.get(monthManageClick.getIndexForPostResume()),year,checkMonth,monthManageClick.getNowDay());
            }else{
                manageBusyDays(busyNotesIndicators.get(monthManageClick.getAnIndex()), year, checkMonth, monthManageClick.getNowDay());
                manageStars(stars.get(monthManageClick.getAnIndex()), year, checkMonth, monthManageClick.getNowDay());
                manageBirthdays(birthdays.get(monthManageClick.getAnIndex()), checkMonth, monthManageClick.getNowDay());
                manageCustomText(customRTExt.get(monthManageClick.getAnIndex()),year,checkMonth,monthManageClick.getNowDay());
            }
        }else {
            manageBusyDays(busyNotesIndicators.get(monthManageClick.getAnIndex()), year, checkMonth, day);
            manageStars(stars.get(monthManageClick.getAnIndex()), year, checkMonth, day);
            manageBirthdays(birthdays.get(monthManageClick.getAnIndex()), checkMonth,day);
            manageCustomText(customRTExt.get(monthManageClick.getAnIndex()),year,checkMonth,day);
        }
        setTextToPageViewer();

    }
    @Override
    protected void onPause() {
        super.onPause();
        if (mMyDB != null) {
            mMyDB.close();
        }


    }

    public void updatePreferences(){
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        if(monthManageClick.getNowMonth() != -1){
            editor.putInt(MainActivity.NOWMONTH, monthManageClick.getNowMonth());
        }else editor.putInt(MainActivity.NOWMONTH, month);
        if(monthManageClick.getNowDay() != 0){
            editor.putInt(MainActivity.NOWDAY, monthManageClick.getNowDay());
        }else editor.putInt(MainActivity.NOWDAY, day);
        editor.commit();
    }

    @Override
    public boolean onLongClick(View view) {
        clickDays(view);
        updatePreferences();
        Intent i = new Intent(MonthDayDisplaySecond.this,Hour_activity.class);
        startActivity(i);
        return true;
    }

    @Override
    public void onAnimationStart(Animation animation) {
        if(animation == a2){
            relCurD2.setVisibility(View.VISIBLE);
        }else if(animation == a3){
            relCurD3.setVisibility(View.VISIBLE);
        }else if(animation == a4){
            relCurD4.setVisibility(View.VISIBLE);
        }else if(animation == a6){
            colorTheDate(true);
        }
    }

    @Override
    public void onAnimationEnd(Animation animation) {
            if(animation == a6){
                relCurD4.setVisibility(View.INVISIBLE);
            }else if(animation == a7){
                relCurD3.setVisibility(View.INVISIBLE);
            }else if(animation == a8){
                relCurD2.setVisibility(View.INVISIBLE);
            }else if(animation == a2){
                colorTheDate(false);
            }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {

        switch (s){
            case MainActivity.NOWYEAR:{
                year = sharedPreferences.getInt(MainActivity.NOWYEAR,0);
                recreatingOnResume = true;
                break;
            }
            case Settings.DATESET:{
                setTextToDate();
                break;
            }
        }
    }


    public class MonthManageClick{
        private RelativeLayout clicked;
        private RelativeLayout dayClick;
        private int onCreateDay;
        private int onPostResumeDay;
        private int nowMonth= -1;
        private int nowDay;
        private int anIndex= -1;
        private boolean flagAnimation;
        private boolean onceFlag;
        private boolean flagAnimationDay;
        private boolean onceFlagDay;
        private int indexForPostResume=-1;

        public int getOnCreateDay() {
            return onCreateDay;
        }

        public void setOnCreateDay(int onCreateDay) {
            this.onCreateDay = onCreateDay;
        }


        public int getIndexForPostResume() {
            return indexForPostResume;
        }

        public void setIndexForPostResume(int indexForPostResume) {
            this.indexForPostResume = indexForPostResume;
        }

        public boolean isOnceFlagDay() {
            return onceFlagDay;
        }

        public void setOnceFlagDay(boolean onceFlagDay) {
            this.onceFlagDay = onceFlagDay;
        }

        public boolean isFlagAnimationDay() {
            return flagAnimationDay;
        }

        public void setFlagAnimationDay(boolean flagAnimationDay) {
            this.flagAnimationDay = flagAnimationDay;
        }

        public boolean isOnceFlag() {
            return onceFlag;
        }

        public void setOnceFlag(boolean onceFlag) {
            this.onceFlag = onceFlag;
        }

        public boolean getFlagAnimation() {
            return flagAnimation;
        }

        public void setFlagAnimation(boolean flagAnimation) {
            this.flagAnimation = flagAnimation;
        }

        public int getAnIndex() {
            return anIndex;
        }

        public void setAnIndex(int anIndex) {
            this.anIndex = anIndex;
        }

        public RelativeLayout getDayClick() {
            return dayClick;
        }

        public void setDayClick(RelativeLayout dayClick) {
            this.dayClick = dayClick;
        }

        public RelativeLayout getClicked() {
            return clicked;
        }

        public void setClicked(RelativeLayout clicked) {
            this.clicked = clicked;
        }

        public int getNowMonth() {
            return nowMonth;
        }

        public void setNowMonth(int nowMonth) {
            this.nowMonth = nowMonth;
        }

        public int getNowDay() {
            return nowDay;
        }

        public void setNowDay(int nowDay) {
            this.nowDay = nowDay;
        }
    }
}
