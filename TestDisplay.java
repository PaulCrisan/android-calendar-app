package com.wallpapernote.plutopix.wallpaperorganizer;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class TestDisplay extends AppCompatActivity  {
    File dir;
    File text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_display);

        TextView t = (TextView)findViewById(R.id.tv_testDisplay);
        Button fill =(Button)findViewById(R.id.fill_db);

        fill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                FillYearTest fillYearTest = new FillYearTest();
//                fillYearTest.fillYear(getApplicationContext());
            }
        });

        ArrayList<Model> savedArrayList = null;
        t.setText("caca");


        try {
             dir = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + getString(R.string.app_name));
             text = new File(dir.getPath() + "/" + "App_backup" + ".txt");

            FileInputStream inputStream = new FileInputStream(text);
            ObjectInputStream in = new ObjectInputStream(inputStream);

            savedArrayList = (ArrayList<Model>) in.readObject();
            in.close();
            inputStream.close();
            StringBuilder b = new StringBuilder();
            for(Model l :savedArrayList){
                b.append(l.getNote()+"\n" );
            }
            t.setText(b.toString());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();

        }

    }
}
