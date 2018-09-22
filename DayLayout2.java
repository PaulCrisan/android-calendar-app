package com.wallpapernote.plutopix.wallpaperorganizer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class DayLayout2 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {


        // Defines the xml file for the fragment
        return inflater.inflate(R.layout.month_days_till_sat, parent, false);
    }


}

