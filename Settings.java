package com.wallpapernote.plutopix.wallpaperorganizer;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.media.MediaScannerConnection;
import android.media.audiofx.BassBoost;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityCompat;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Settings extends AppCompatActivity {

    private SharedPreferences mSharedPreferences;
    private int pickedYear;
    private Spinner pickYear;
    private Button saving;
    private TextView theLastSaveText;
    private TextView important;

    private Button backup;
    private ArrayList<Model> mModelList;
    private MyDB mMyDB;
    private File dir;
    private static final String LASTSAVE = "last_save";
    private static final String BACKUPFILE234 = "App_backup";
    private SwitchCompat overSwitch;
    private SwitchCompat dateSwitch;
    private SwitchCompat skinSwitch;
    public static final String TOBROADCAST = "broadcasting";
    public static final String DATESET = "dateset";
    public static final String SKINSET = "skinset";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(Settings.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                String s = getResources().getString(R.string.permission_for_file_dialog);
                String policy = getResources().getString(R.string.privacy_policy);
                final MyCustomDialog d = new MyCustomDialog(Settings.this, s,policy);
                d.setTheOkButton(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ActivityCompat.requestPermissions(Settings.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2909);
                        d.dismiss();
                    }
                });
                d.setCancelButton(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        d.dismiss();
                    }
                });

                d.show();

            } else {

                dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + getString(R.string.app_name));
                if (!dir.exists() && !dir.isDirectory()) {
                    dir.mkdir();
                    Toast.makeText(Settings.this, "Backup directory " + getString(R.string.app_name) + " was created", Toast.LENGTH_SHORT).show();
                }

            }
        } else {
            dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + getString(R.string.app_name));
            if (!dir.exists() && !dir.isDirectory()) {
                dir.mkdir();
                Toast.makeText(Settings.this, "Backup directory " + getString(R.string.app_name) + " was created", Toast.LENGTH_SHORT).show();
            }

        }


        mMyDB = MyDB.getMyDB(getApplicationContext());
        pickYear = (Spinner) findViewById(R.id.numberPicker);
        overSwitch = (SwitchCompat) findViewById(R.id.switch_over);
        initialBroadcastSwitchCheck();
        dateSwitch = (SwitchCompat)findViewById(R.id.switch_date_pres);
        initialDateSwitchCheck();
        skinSwitch = (SwitchCompat)findViewById(R.id.switch_skin);
        initialSkinSwitchCheck();
        important = (TextView)findViewById(R.id.important_info_layout);
        saving = (Button) findViewById(R.id.save_db);
        backup = (Button) findViewById(R.id.back_up);
        theLastSaveText = (TextView)findViewById(R.id.lastsave_date);
        setSaveTExt();

        LinearLayout layout = (LinearLayout) findViewById(R.id.linlay);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        checkifTextFileExists();

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.year_list, R.layout.spinner_text);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        important.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String description =getResources().getString(R.string.important);
                final MyCustomDialog d = new MyCustomDialog(Settings.this,description,"");
                d.setCancelButton(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        d.dismiss();
                    }
                });
                d.setCancelButton(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        d.dismiss();
                    }
                });
                d.show();
            }
        });


        pickYear.setAdapter(adapter);
        pickYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                if (i > 0) {
                    mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    int numberYearSelected = Integer.parseInt(adapterView.getItemAtPosition(i).toString());
                    SharedPreferences.Editor editor = mSharedPreferences.edit();
                    editor.putInt(MainActivity.NOWYEAR, numberYearSelected);
                    editor.commit();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //eat dust
            }
        });

        saving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (ContextCompat.checkSelfPermission(Settings.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                        //
                        String s = getResources().getString(R.string.permission_saving);
                        String policy = getResources().getString(R.string.privacy_policy);
                        final MyCustomDialog d = new MyCustomDialog(Settings.this, s,policy);
                        d.setTheOkButton(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                ActivityCompat.requestPermissions(Settings.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                        Manifest.permission.READ_EXTERNAL_STORAGE}, 2888);
                                d.dismiss();
                            }
                        });
                        d.setCancelButton(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                d.dismiss();
                            }
                        });

                        d.show();
                        //


//                        requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
//                                Manifest.permission.READ_EXTERNAL_STORAGE}, 2909);
                    } else {
                        mModelList = new ArrayList<Model>();
                        mModelList = mMyDB.getAllToDos();

                        dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + getString(R.string.app_name));
                        if (isExternalStorageWritable()) {
                            if (!dir.exists() && !dir.isDirectory()) {
                                dir.mkdir();
                                if (mMyDB != null) {
                                    WriteToFileDATAB write = new WriteToFileDATAB(fileName(BACKUPFILE234));
                                    write.saveArrayList(mModelList);
                                    saveDateLastSave();
                                    Toast.makeText(Settings.this, "Directory " + getString(R.string.app_name) + " and txt file " + BACKUPFILE234 + " created ", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                if (mMyDB != null) {
                                    WriteToFileDATAB write = new WriteToFileDATAB(fileName(BACKUPFILE234));
                                    write.saveArrayList(mModelList);
                                    saveDateLastSave();
                                    Toast.makeText(Settings.this, "Txt file " + BACKUPFILE234 + " created ", Toast.LENGTH_SHORT).show();
                                }
                            }

                        } else
                            Toast.makeText(Settings.this, "External storage is not currently available ", Toast.LENGTH_SHORT).show();

                    }
                } else {
                    mModelList = new ArrayList<Model>();
                    mModelList = mMyDB.getAllToDos();
                    dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + getString(R.string.app_name));
                    if (isExternalStorageWritable()) {
                        if (!dir.exists() && !dir.isDirectory()) {
                            dir.mkdir();
                            if (mMyDB != null) {
                                WriteToFileDATAB write = new WriteToFileDATAB(fileName(BACKUPFILE234));
                                write.saveArrayList(mModelList);
                                saveDateLastSave();
                                Toast.makeText(Settings.this, "Directory " + getString(R.string.app_name) + " and txt file " + BACKUPFILE234 + " created ", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            if (mMyDB != null) {
                                WriteToFileDATAB write = new WriteToFileDATAB(fileName(BACKUPFILE234));
                                write.saveArrayList(mModelList);
                                saveDateLastSave();
                                Toast.makeText(Settings.this, "Txt file " + BACKUPFILE234 + " created ", Toast.LENGTH_SHORT).show();
                            }
                        }
                    } else
                        Toast.makeText(Settings.this, "External storage is not currently available ", Toast.LENGTH_SHORT).show();

                }

            }
        });

        dateSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor = mSharedPreferences.edit();
                boolean check;
                if(b){
                    check = true;
                    editor.putBoolean(DATESET,check);
                    editor.commit();
                    Log.d("TAG", "onCheckedChanged: " + check);
                }else{
                    check = false;
                    editor.putBoolean(DATESET,check);
                    editor.commit();
                    Log.d("TAG", "onCheckedChanged: "+ check);
                }
            }
        });
        skinSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor = mSharedPreferences.edit();
                boolean check;
                if(b){
                    check = true;
                    editor.putBoolean(SKINSET,check);
                    editor.commit();
                }else{
                    check = false;
                    editor.putBoolean(SKINSET,check);
                    editor.commit();
                }
            }
        });

        overSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (!android.provider.Settings.canDrawOverlays(getApplicationContext())) {


                        String s = getResources().getString(R.string.permission_drawover_dialog);
                        String policy = getResources().getString(R.string.privacy_policy);
                        final MyCustomDialog over = new MyCustomDialog(Settings.this, s,policy);
                        over.setTheOkButton(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent intent = new Intent(android.provider.Settings.ACTION_MANAGE_OVERLAY_PERMISSION,Uri.parse("package:" + getPackageName()));
                                /** request permission via start activity for result */
                                startActivityForResult(intent, 2910);
                                over.dismiss();
                            }
                        });
                        over.setCancelButton(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                over.dismiss();
                            }
                        });

                        over.show();

                        if (b) {
                            setBroadcastPreference(true);

                        } else {
                            setBroadcastPreference(false);
                        }
                    } else {
                        if (b) {
                            setBroadcastPreference(true);

                        } else {
                            setBroadcastPreference(false);
                        }

                    }
                } else {
                    if (b) {
                        setBroadcastPreference(true);

                    } else {
                        setBroadcastPreference(false);
                    }

                }


            }


        });

        backup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (ContextCompat.checkSelfPermission(Settings.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                        String s = getResources().getString(R.string.permission_load);
                        String policy = getResources().getString(R.string.privacy_policy);
                        final MyCustomDialog d = new MyCustomDialog(Settings.this, s,policy);
                        d.setTheOkButton(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2888);
                                d.dismiss();
                            }
                        });
                        d.setCancelButton(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                d.dismiss();
                            }
                        });

                        d.show();
                        //requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 2888);
                    } else {

                        if (isExternalStorageReadable()) {
                            dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + getString(R.string.app_name));
                             //final WriteToFileDATAB read = new WriteToFileDATAB(dir);
                            if (dir.exists() && dir.isDirectory()) {
                                 final File textPath = new File(dir.getPath() + "/" + BACKUPFILE234 + ".txt");
                                if (textPath.exists()) {
                                    if (mMyDB != null) {
                                        String s = getResources().getString(R.string.backup_confirmation_dialog);
                                        final AsynTaskWriteFileToDB asynk = new AsynTaskWriteFileToDB(textPath,Settings.this);
                                        final MyCustomDialog my = new MyCustomDialog(Settings.this,s,"");
                                        my.setTheOkButton(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {

                                                   asynk.execute();
                                                //
//                                                mMyDB.deleteAll();
//                                                mMyDB.insertArrayListData(read.getSavedArrayList(textPath));
//                                                Toast.makeText(Settings.this, "Backup loaded successfully", Toast.LENGTH_SHORT).show();
                                                //
                                                my.dismiss();
                                            }
                                        });
                                        my.setCancelButton(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                Toast.makeText(Settings.this, "Cancelled", Toast.LENGTH_SHORT).show();
                                                my.dismiss();
                                            }
                                        });
                                        my.show();
//                                        mMyDB.insertArrayListData(read.getSavedArrayList(textPath));
//                                        Toast.makeText(Settings.this, "Backup loaded successfully", Toast.LENGTH_SHORT).show();
                                    }

                                } else
                                    Toast.makeText(Settings.this, "Could not find backup file. Make sure you copy pasted from previous device, or it wasn't deleted", Toast.LENGTH_SHORT).show();
                            }

                        } else
                            Toast.makeText(Settings.this, "External storage is not currently available ", Toast.LENGTH_SHORT).show();

                    }
                } else {

                    if (isExternalStorageReadable()) {
                        dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + getString(R.string.app_name));
                        //final WriteToFileDATAB read = new WriteToFileDATAB(dir);
                        if (dir.exists() && dir.isDirectory()) {
                            final File textPath = new File(dir.getPath() + "/" + BACKUPFILE234 + ".txt");
                            if (textPath.exists()) {
                                if (mMyDB != null) {
                                    String s = getResources().getString(R.string.backup_confirmation_dialog);
                                    final MyCustomDialog my = new MyCustomDialog(Settings.this,s,"");
                                    final AsynTaskWriteFileToDB asynk = new AsynTaskWriteFileToDB(textPath,Settings.this);
                                    my.setTheOkButton(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {

                                            asynk.execute();
                                            //
//                                            mMyDB.deleteAll();
//                                            mMyDB.insertArrayListData(read.getSavedArrayList(textPath));
//                                            Toast.makeText(Settings.this, "Backup loaded successfully", Toast.LENGTH_SHORT).show();
                                            //
                                            my.dismiss();
                                        }
                                    });
                                    my.setCancelButton(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            Toast.makeText(Settings.this, "Cancelled", Toast.LENGTH_SHORT).show();
                                            my.dismiss();
                                        }
                                    });
                                    my.show();
//                                    mMyDB.insertArrayListData(read.getSavedArrayList(textPath));
//                                    Toast.makeText(Settings.this, "Backup loaded successfully", Toast.LENGTH_SHORT).show();
                                }

                            } else
                                Toast.makeText(Settings.this, "Could not find backup file", Toast.LENGTH_SHORT).show();
                        }

                    } else
                        Toast.makeText(Settings.this, "External storage is not currently available ", Toast.LENGTH_SHORT).show();

                }


            }
        });

    }

    public void setBroadcastPreference(boolean b) {
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(TOBROADCAST, b);
        Log.d("TAG", "setBroadcastPreference: " + b);
        editor.commit();
    }
    public void initialBroadcastSwitchCheck(){
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        if(!mSharedPreferences.contains(TOBROADCAST)){
            overSwitch.setChecked(false);
        }else {
            boolean switchState = mSharedPreferences.getBoolean(TOBROADCAST,false);
            if(switchState){
                overSwitch.setChecked(true);
            }else overSwitch.setChecked(false);
        }
    }
    public void initialDateSwitchCheck(){
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        if(!mSharedPreferences.contains(DATESET)){
            dateSwitch.setChecked(false);
        }else{
            boolean switchState = mSharedPreferences.getBoolean(DATESET,false);
            if(switchState){
                dateSwitch.setChecked(true);
            }else dateSwitch.setChecked(false);
        }
    }
    public void initialSkinSwitchCheck(){
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        if(!mSharedPreferences.contains(SKINSET)){
            skinSwitch.setChecked(false);
        }else{
            boolean switchState = mSharedPreferences.getBoolean(SKINSET,false);
            if(switchState){
                skinSwitch.setChecked(true);
            }else skinSwitch.setChecked(false);
        }
    }
    public boolean checkifTextFileExists(){
        File check = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + getString(R.string.app_name) + "/" + BACKUPFILE234 + ".txt");
        if(check.exists()){
            saving.setBackgroundResource(R.drawable.folder_state_full);
            backup.setBackgroundResource(R.drawable.folder_backup_full);
            return true;
        }else{
            saving.setBackgroundResource(R.drawable.folder_state);
            backup.setBackgroundResource(R.drawable.folder_backup_emptystate);
            return false;
        }
    }

    public File fileName(String name) {

        dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + getString(R.string.app_name));

        if (!dir.exists() && !dir.isDirectory()) {
            dir.mkdir();
        }
        String nameOfFile = name + ".txt";
        File textFile = new File(dir, nameOfFile);
        return textFile;
    }

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }
    private void setSaveTExt(){
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        if(mSharedPreferences.contains(LASTSAVE)){
            theLastSaveText.setText(mSharedPreferences.getString(LASTSAVE,""));
        }else{
            theLastSaveText.setText("Last save was on: NEVER");
        }
    }
    private void saveDateLastSave(){
        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss ");
        String date = "Last save was on: " + "\n" + df.format(Calendar.getInstance().getTime());
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(LASTSAVE,date);
        editor.commit();
        theLastSaveText.setText(date);


    }

    private void askForPermission(String permission, Integer requestCode) {
        if (ContextCompat.checkSelfPermission(Settings.this, permission) != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(Settings.this, permission)) {

                //This is called if user has denied the permission before
                //In this case I am just asking the permission again
                ActivityCompat.requestPermissions(Settings.this, new String[]{permission}, requestCode);

            } else {

                ActivityCompat.requestPermissions(Settings.this, new String[]{permission}, requestCode);
            }
        } else {
            Toast.makeText(this, "" + permission + " is already granted.", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        if(mMyDB != null){
            mMyDB.close();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 2910){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if(!android.provider.Settings.canDrawOverlays(getApplicationContext()) ){
                    Toast.makeText(Settings.this, "Permission denied. Launch icon on locked screen not available", Toast.LENGTH_SHORT).show();
                }else Toast.makeText(Settings.this, "Permission granted", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void createDirectory(){
        dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + getString(R.string.app_name));
        if (!dir.exists() && !dir.isDirectory()) {
            dir.mkdir();


        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 2909: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    createDirectory();
                    Toast.makeText(Settings.this, "Folder created", Toast.LENGTH_SHORT).show();
                } else {
                    Log.e("Permission", "Denied");
                    Toast.makeText(Settings.this, "Permission denied. Creating folder or back-up file is not possible", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            case 2888: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    createDirectory();
                    Log.e("Permission", "Granted");
                    Toast.makeText(Settings.this, "Permission granted. You can create or load back-up", Toast.LENGTH_SHORT).show();
                } else {
                    Log.e("Permission", "Denied");
                    Toast.makeText(Settings.this, "Permission denied. Reading backup file not possible", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }
}
