package com.wallpapernote.plutopix.wallpaperorganizer;

import android.app.Activity;
import android.content.Context;


public class FillYearTest {

    private MyDB tDB;

    public void fillYear(Context context){
        tDB = MyDB.getMyDB(context);
        for(int i = 1; i<12; i++){


           for(int j = 1; j<28 ; j++){
               for(int k= 8 ; k<20; k++){
                   Model  model = new Model(2017,i,j, k, "Toate acestea sunte pentru un test de 25") ;
                   tDB.insertNote(model);
               }
           }


        }
        tDB.close();
    }
}
