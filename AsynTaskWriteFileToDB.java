package com.wallpapernote.plutopix.wallpaperorganizer;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class AsynTaskWriteFileToDB extends AsyncTask<Void, Void, Boolean> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mProgressDialog.setMessage("Please wait. Loading...");
        mProgressDialog.setIndeterminate(false);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        mProgressDialog.dismiss();
        if(aBoolean){
            Toast.makeText(settings.getApplicationContext(), "Back-up loaded successfully", Toast.LENGTH_SHORT).show();
        }else Toast.makeText(settings.getApplicationContext(), "Loading aborted. Check back-up file and try again", Toast.LENGTH_SHORT).show();
        if(mMyDB != null){
            mMyDB.close();
        }
    }

    private File text;
    private MyDB mMyDB;
    private ProgressDialog mProgressDialog;
    private Activity settings;

    public AsynTaskWriteFileToDB(File text, Activity settings) {
        this.text = text;
        this.settings = settings;
        this.mProgressDialog = new ProgressDialog(settings);
    }


    @Override
    protected Boolean doInBackground(Void... voids) {


        ArrayList<Model> savedArrayList = null;

        try {
            FileInputStream inputStream = new FileInputStream(text);
            ObjectInputStream in = new ObjectInputStream(inputStream);
            savedArrayList = (ArrayList<Model>) in.readObject();
            in.close();
            inputStream.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        mMyDB = MyDB.getMyDB(settings.getApplicationContext());
        mMyDB.deleteAll();
        mMyDB.insertArrayListData(savedArrayList);
        return true;
    }
}
