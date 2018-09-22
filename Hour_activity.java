package com.wallpapernote.plutopix.wallpaperorganizer;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Hour_activity extends AppCompatActivity implements View.OnClickListener, SharedPreferences.OnSharedPreferenceChangeListener{



    private int year;
    private int month;
    private int day;
    public static final int STARIDENTIFIER = 99;
    private boolean dateDisplay;

    private static final int DELAYRUN = 1500;

    private ImageView starIM;

    private boolean starboolCheck;

    private EditText enterBirth;
    private TextView infoBirth;
     private TextWatcher mTextEditorWatcher;
    private int birthNameChrNr;


    private ImageView birthday;
    private ImageView delete;
    private ImageView add;
    private ImageView accept;

    LinearLayout lL8; LinearLayout lL9; LinearLayout lL10;LinearLayout lL11;LinearLayout lL12;LinearLayout lL13;
    LinearLayout lL14;LinearLayout lL15;LinearLayout lL16;LinearLayout lL17;LinearLayout lL18;
    LinearLayout lL19;LinearLayout lL20;

    TextView tv8;TextView tv9;TextView tv10;TextView tv11;TextView tv12;TextView tv13;TextView tv14;
    TextView tv15;TextView tv16;TextView tv17;TextView tv18;TextView tv19;TextView tv20;

    TextView tvFloater;
    private RelativeLayout pinRel;
    private TextView customRTV;
    private ImageView customRDelete;
    private ImageView customRAdd;
    private EditText customREdit;
    private int customEditWathcer;
    private ImageView customPin;

    private SharedPreferences mSharedPreferences;

    private MyDB db;

    private NameDayHelper mNameDayHelper;

    private boolean returnIfYearChanged;
   private Window window;

   Runnable r = new Runnable() {
       @Override
       public void run() {
           hideButtons();
       }
   };
    Runnable customRDel = new Runnable() {
        @Override
        public void run() {
            hideCustomRDelete();
        }
    };
    Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hour_activity_second);


         window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
        window.addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
        window.addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        mSharedPreferences.registerOnSharedPreferenceChangeListener(this);
        //mSharedPreferences = getSharedPreferences(MainActivity.PREFNAME, MODE_PRIVATE);
        year = mSharedPreferences.getInt(MainActivity.NOWYEAR,0);
        month = mSharedPreferences.getInt(MainActivity.NOWMONTH, 0);
        day = mSharedPreferences.getInt(MainActivity.NOWDAY, 0);

        pinRel = (RelativeLayout)findViewById(R.id.rel_layout_custom);
        customRTV = (TextView)findViewById(R.id.custom_r_tv) ;
        customRDelete = (ImageView)findViewById(R.id.custom_r_delete_ball);
        customRAdd = (ImageView)findViewById(R.id.custom_r_add_ball);
        customREdit = (EditText)findViewById(R.id.custom_r_edit) ;
        customPin = (ImageView)findViewById(R.id.custom_pin);


        tv8 = (TextView)findViewById(R.id.tv_8) ;tv9 = (TextView)findViewById(R.id.tv_9) ;tv10 = (TextView)findViewById(R.id.tv_10) ;
        tv11 = (TextView)findViewById(R.id.tv_11) ;tv12 = (TextView)findViewById(R.id.tv_12) ;tv13 = (TextView)findViewById(R.id.tv_13) ;
        tv14 = (TextView)findViewById(R.id.tv_14) ;tv15 = (TextView)findViewById(R.id.tv_15) ;tv16 = (TextView)findViewById(R.id.tv_16) ;
        tv17 = (TextView)findViewById(R.id.tv_17) ;tv18 = (TextView)findViewById(R.id.tv_18) ;tv19 = (TextView)findViewById(R.id.tv_19) ;
        tv20 = (TextView)findViewById(R.id.tv_20) ;

        tvFloater = (TextView)findViewById(R.id.floater_time);

        lL8 = (LinearLayout) findViewById(R.id.layout_8) ;lL9 = (LinearLayout) findViewById(R.id.layout_9) ;lL10 = (LinearLayout) findViewById(R.id.layout_10) ;
        lL11 = (LinearLayout) findViewById(R.id.layout_11) ;lL12 = (LinearLayout) findViewById(R.id.layout_12) ;lL13 = (LinearLayout) findViewById(R.id.layout_13) ;
        lL14 = (LinearLayout) findViewById(R.id.layout_14) ;lL15 = (LinearLayout) findViewById(R.id.layout_15) ;lL16 = (LinearLayout) findViewById(R.id.layout_16) ;
        lL17 = (LinearLayout) findViewById(R.id.layout_17) ;lL18 = (LinearLayout) findViewById(R.id.layout_18) ;lL19 = (LinearLayout) findViewById(R.id.layout_19) ;
        lL20 = (LinearLayout) findViewById(R.id.layout_20) ;

        //
        starIM = (ImageView)findViewById(R.id.starT);
        birthday = (ImageView)findViewById(R.id.birthdayIM);
        add = (ImageView)findViewById(R.id.add_birth);
        delete = (ImageView)findViewById(R.id.delete_birth);
        accept = (ImageView)findViewById(R.id.accept_);
        enterBirth = (EditText)findViewById(R.id.birthday_enter);
        infoBirth = (TextView)findViewById(R.id.birthday_info);


///////////////////////////

        //

//        lL8.setOnLongClickListener(this);lL9.setOnLongClickListener(this);lL10.setOnLongClickListener(this);lL11.setOnLongClickListener(this);
//        lL12.setOnLongClickListener(this);lL13.setOnLongClickListener(this);lL14.setOnLongClickListener(this);lL15.setOnLongClickListener(this);
//        lL16.setOnLongClickListener(this);lL17.setOnLongClickListener(this);lL18.setOnLongClickListener(this);lL19.setOnLongClickListener(this);
//        lL20.setOnLongClickListener(this);

        lL8.setOnClickListener(this);lL9.setOnClickListener(this);lL10.setOnClickListener(this);lL11.setOnClickListener(this);
        lL12.setOnClickListener(this);lL13.setOnClickListener(this);lL14.setOnClickListener(this);lL15.setOnClickListener(this);
        lL16.setOnClickListener(this);lL17.setOnClickListener(this);lL18.setOnClickListener(this);lL19.setOnClickListener(this);
        lL20.setOnClickListener(this);


        db = MyDB.getMyDB(getApplicationContext());

        populateTv();

        mNameDayHelper = new NameDayHelper();
        //TO REPLACE FROM SETTINGS

        floaterDateModeSet();

        customRAdd.setVisibility(View.INVISIBLE);
        customRDelete.setVisibility(View.INVISIBLE);
        customREdit.setVisibility(View.INVISIBLE);


        add.setVisibility(View.INVISIBLE);
        delete.setVisibility(View.INVISIBLE);
        infoBirth.setVisibility(View.VISIBLE);
        enterBirth.setVisibility(View.INVISIBLE);
        accept.setVisibility(View.INVISIBLE);
        checkBirthday();
        refreshBirthdayNames();
        setTextToCustomTv();
        mHandler = new Handler();

        pinRel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!db.customRCheck(year,month,day)){
                    customRAdd.setVisibility(View.VISIBLE);
                    customREdit.setVisibility(View.VISIBLE);
                    customRTV.setVisibility(View.INVISIBLE);
                    customRDelete.setVisibility(View.INVISIBLE);
                }else {
                    customRDelete.setVisibility(View.VISIBLE);
                    mHandler.postDelayed(customRDel,DELAYRUN);
                }
            }
        });

        customREdit.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    customRAdd.performClick();
                    return true;
                }
                return false;
            }
        });
        customRAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(customEditWathcer >0){
                    Model model = new Model(customREdit.getText().toString(),year,month,day);
                    Log.d("TAG", "onClick: " + customEditWathcer + " " + customREdit.getText().toString());
                   // String temp = customREdit.getText().toString();
                    db.insertCustomR(model);
                    Log.d("TAG", "onClick: "+ db.customRCheck(year,month,day));
                    setTextToCustomTv();
                    customREdit.setText(null);
                    customREdit.setVisibility(View.INVISIBLE);
                    customRAdd.setVisibility(View.INVISIBLE);
                    customRTV.setVisibility(View.VISIBLE);

                }else {
                    Toast.makeText(Hour_activity.this, "No text input. Pinning text reminder cancelled", Toast.LENGTH_SHORT).show();
                    customREdit.setVisibility(View.INVISIBLE);
                    customRAdd.setVisibility(View.INVISIBLE);
                    customRTV.setVisibility(View.VISIBLE);
                }
            }
        });
        customRDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(db.customRCheck(year,month,day)){
                    String customR = db.getCustomRByDay(year,month,day);
                    if(customR !=null){
                        db.deleteCustomR(year,month,day,customR);
                    }
                    setTextToCustomTv();
                    customRDelete.setVisibility(View.INVISIBLE);
                }
            }
        });

        customREdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int count) {
                        customEditWathcer = charSequence.length();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        customREdit.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b) {
                    InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputManager.hideSoftInputFromWindow(view.getWindowToken(),
                            InputMethodManager.RESULT_UNCHANGED_SHOWN);

                }
            }
        });

        birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!db.birthCheck( month, day)){

                    add.setVisibility(View.VISIBLE);
                }else{

                    add.setVisibility(View.VISIBLE);
                    delete.setVisibility(View.VISIBLE);
                }
                mHandler.postDelayed(r,DELAYRUN);

            }
        });



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                enterBirth.setVisibility(View.VISIBLE);
                add.setVisibility(View.INVISIBLE);
                delete.setVisibility(View.INVISIBLE);
                accept.setVisibility(View.VISIBLE);
                infoBirth.setVisibility(View.INVISIBLE);



            }
        });

        enterBirth.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    accept.performClick();
                    return true;
                }
                return false;
            }
        });

        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = null;
                if(birthNameChrNr > 0){
                    name = enterBirth.getText().toString();
                    Model m = new Model(month,day,name);
                    db.insertBirthday(m);

                }else {
                    Toast.makeText(Hour_activity.this, "No name input. Birthday not saved", Toast.LENGTH_SHORT).show();
                }

                enterBirth.setText(null);
                enterBirth.setVisibility(View.INVISIBLE);
                accept.setVisibility(View.INVISIBLE);

                infoBirth.setVisibility(View.VISIBLE);
                checkBirthday();
                refreshBirthdayNames();
            }
        });

        mTextEditorWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int count) {


                    birthNameChrNr = charSequence.length();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };
        enterBirth.addTextChangedListener(mTextEditorWatcher);
        enterBirth.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(!b) {
                    InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputManager.hideSoftInputFromWindow(view.getWindowToken(),
                            InputMethodManager.RESULT_UNCHANGED_SHOWN);

                }
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                birthDeleteDialog(Hour_activity.this);
                delete.setVisibility(View.INVISIBLE);
                add.setVisibility(View.INVISIBLE);
                //checkBirthday();
            }
        });


        starboolCheck = db.checkForStar(year,month,day,STARIDENTIFIER);
        if(starboolCheck){
            starIM.setImageAlpha(255);
        }else {
            starIM.setImageAlpha(100);

        }

        starIM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(db.checkForStar(year,month,day,STARIDENTIFIER))
                {

                    db.deleteStar(year, month, day, STARIDENTIFIER);
                    starIM.setImageAlpha(100);
                }else {
                   Model m = new Model(year,month,day,STARIDENTIFIER);

                    db.insertStar(m);
                    starIM.setImageAlpha(255);
                }


            }
        });
    }



    public void refreshBirthdayNames(){
        StringBuilder builder = new StringBuilder();
        ArrayList<String> names = db.getBirthdays(month,day);
        for(String s : names){
            builder.append(s + "\n");
        }
        infoBirth.setText(builder.toString());
    }



    public void checkBirthday(){
        boolean check = db.birthCheck(month, day);
        if(check){
            birthday.setImageAlpha(255);
        }else {
            birthday.setImageAlpha(100);

        }
    }





    public void showTheDialog(Activity activity, final int anHour, final TextView tv){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);


        dialog.setContentView(R.layout.enter_note_dialog);
        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);

        TextView title = (TextView)dialog.findViewById(R.id.title_dialog_hour) ;
       Button save = (Button)dialog.findViewById(R.id.save_dialog);
        Button cancel = (Button)dialog.findViewById(R.id.cancel_dialog);
        Button delete = (Button)dialog.findViewById(R.id.delete_dialog);
        final EditText et = (EditText)dialog.findViewById(R.id.et_dialog) ;
        //et.setText(" "+tv.getText());
        et.setText(tv.getText());

        //adaugat
        if(et.getText().toString().contains("123456789xyz")){
            Intent i = new Intent(Hour_activity.this,TestDisplay.class);
            startActivity(i);
        }

        //
        title.setText("" + anHour + ":00");
        final boolean entrycheck = db.checkForNote(year,month,day,anHour);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //adaugat
                if(et.getText().toString().contains("123456789xyz")){
                    Intent i = new Intent(Hour_activity.this,TestDisplay.class);
                    startActivity(i);
                }

                //

                Model m = new Model(year,month,day,anHour,et.getText().toString());
                if(!entrycheck){

                    db.insertNote(m);
                }else {db.updateNote(m);}


                populateTv();
                dialog.dismiss();

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.show();



        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(entrycheck){
                    Model m = new Model(year,month,day,anHour,et.getText().toString());
                    db.deleteNote(m);

                }

                populateTv();
                dialog.dismiss();
            }
        });

    }
    public void floaterDateModeSet(){
        dateDisplay = mSharedPreferences.getBoolean(Settings.DATESET,false);
        String floaterText ="";
        if(mSharedPreferences.contains(Settings.DATESET)){
            if(dateDisplay){
                floaterText = mNameDayHelper.getNameOfDay(year,month,day,NameDayHelper.MONTHDAY);
            }else {floaterText = mNameDayHelper.getNameOfDay(year,month,day,NameDayHelper.DAYMONTH);}
        }else{floaterText = mNameDayHelper.getNameOfDay(year,month,day,NameDayHelper.DAYMONTH);}

        tvFloater.setText(floaterText);
    }

    public void hideButtons(){
        if(add.getVisibility() != View.INVISIBLE){
            add.setVisibility(View.INVISIBLE);
        } if(delete.getVisibility() != View.INVISIBLE){
            delete.setVisibility(View.INVISIBLE);
        }
    }
    public void hideCustomRDelete(){
        if(customRDelete.getVisibility() != View.INVISIBLE){
            customRDelete.setVisibility(View.INVISIBLE);
        }
    }

    public void birthDeleteDialog(Activity a){
        final Dialog dialog = new Dialog(a);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);

        dialog.setContentView(R.layout.birthday_dialog);
        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
        ListView list = (ListView)dialog.findViewById(R.id.birth_list);
        Button cancelB = (Button)dialog.findViewById(R.id.cancel_birth_delete);
        final ArrayList<String>allBirthdays = db.getBirthdays(month,day);

        cancelB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                checkBirthday();
                infoBirth.setVisibility(View.VISIBLE);
                refreshBirthdayNames();
            }
        });


       final ArrayAdapter<String>adapter = new ArrayAdapter<>(a,android.R.layout.simple_list_item_1,android.R.id.text1,allBirthdays);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    db.deleteBirth(month,day,allBirthdays.get(i));
                    allBirthdays.remove(i);
                //checkBirthday();
                    if(!db.birthCheck(month,day)){
                        dialog.dismiss();
                        refreshBirthdayNames();
                        checkBirthday();
                    }
                adapter.notifyDataSetChanged();
            }
        });

        dialog.show();
    }



    public void populateTv(){
        //db = MyDB.getMyDB(getApplicationContext());
        tv8.setText(db.getNoteByHour(year,month,day,8));
        tv9.setText(db.getNoteByHour(year,month,day,9));
        tv10.setText(db.getNoteByHour(year,month,day,10));
        tv11.setText(db.getNoteByHour(year,month,day,11));
        tv12.setText(db.getNoteByHour(year,month,day,12));
        tv13.setText(db.getNoteByHour(year,month,day,13));
        tv14.setText(db.getNoteByHour(year,month,day,14));
        tv15.setText(db.getNoteByHour(year,month,day,15));
        tv16.setText(db.getNoteByHour(year,month,day,16));
        tv17.setText(db.getNoteByHour(year,month,day,17));
        tv18.setText(db.getNoteByHour(year,month,day,18));
        tv19.setText(db.getNoteByHour(year,month,day,19));
        tv20.setText(db.getNoteByHour(year,month,day,20));


    }
    public void toast(View v){
        Toast.makeText(Hour_activity.this, "Press long to edit or insert notes", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        if(returnIfYearChanged){
            returnIfYearChanged = false;
            finish();
        }



        starboolCheck = db.checkForStar(year,month,day,STARIDENTIFIER);
        if(starboolCheck){
            starIM.setImageAlpha(255);
        }else {
            starIM.setImageAlpha(100);

        }
        checkBirthday();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (db != null)
            db.close();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (db != null) {
            db.close();
        }

        /// delete
//        ArrayList<Model>c = new ArrayList<>();
//
//        c = db.getAllToDos();
//        for(Model m:c){
//            Log.d("DB", " id is "+ m.getId() + " year is: "+ m.getYear()+ " month is: " + m.getMonth() + " day is: "+ m.getDay() + " hour is: "+
//            m.getHour() + " note is "+ m.getNote() + " star is: " + m.getStar()+ " birth is: " + m.getBirthday() + " custom r is: " + m.getCustomr());
//        }
    }
    public void setTextToCustomTv(){
        if(db.customRCheck(year,month,day)){
            String text = db.getCustomRByDay(year,month,day);
            Log.d("TAG", "setTextToCustomTv: getting result string " + text);
            customPin.setImageAlpha(255);
            if(text != null){
                customRTV.setText(text);
            }
        }else {
            customRTV.setText("");
            customPin.setImageAlpha(100);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.layout_8:
                showTheDialog(Hour_activity.this,8,tv8);
                break;

            case R.id.layout_9:
                showTheDialog(Hour_activity.this,9,tv9);

                break;

            case R.id.layout_10:
                showTheDialog(Hour_activity.this,10,tv10);
                break;

            case R.id.layout_11:
                showTheDialog(Hour_activity.this,11,tv11);
                break;
            case R.id.layout_12:
                showTheDialog(Hour_activity.this,12,tv12);
                break;
            case R.id.layout_13:
                showTheDialog(Hour_activity.this,13,tv13);
                break;
            case R.id.layout_14:
                showTheDialog(Hour_activity.this,14,tv14);
                break;
            case R.id.layout_15:
                showTheDialog(Hour_activity.this,15,tv15);
                break;
            case R.id.layout_16:
                showTheDialog(Hour_activity.this,16,tv16);
                break;
            case R.id.layout_17:
                showTheDialog(Hour_activity.this,17,tv17);
                break;
            case R.id.layout_18:
                showTheDialog(Hour_activity.this,18,tv18);
                break;
            case R.id.layout_19:
                showTheDialog(Hour_activity.this,19,tv19);
                break;
            case R.id.layout_20:
                showTheDialog(Hour_activity.this,20,tv20);
                break;
        }

    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {

        switch (s){
            case MainActivity.NOWYEAR:{
                year = sharedPreferences.getInt(MainActivity.NOWYEAR,0);
                returnIfYearChanged = true;
            }
            case Settings.DATESET:{
                floaterDateModeSet();
            }
        }


    }
}



