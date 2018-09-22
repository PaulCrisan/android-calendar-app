package com.wallpapernote.plutopix.wallpaperorganizer;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class WriteToFileDATAB {


    private File mFile;
    public WriteToFileDATAB(File file){
        this.mFile = file;
    }


    public void saveArrayList(ArrayList<Model> arrayList) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(mFile);
            ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
            out.writeObject(arrayList);
            out.close();
            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Model> getSavedArrayList(File text) {
        ArrayList<Model> savedArrayList = null;

        try {
            FileInputStream inputStream = new FileInputStream(text);
            ObjectInputStream in = new ObjectInputStream(inputStream);
            savedArrayList = (ArrayList<Model>) in.readObject();
            in.close();
            inputStream.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return savedArrayList;
    }
}