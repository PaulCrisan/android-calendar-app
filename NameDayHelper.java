package com.wallpapernote.plutopix.wallpaperorganizer;

import android.content.Context;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class NameDayHelper {

    private  Calendar c;
    public static final String DAYMONTH = "daymonth";
    public static final String MONTHDAY = "monthday";



    public String getNameOfDay(int year, int month, int day, String displayWay){

        c = Calendar.getInstance();
        c.set(year, month, day);
        c.get(Calendar.DAY_OF_WEEK);

        String name = "";
        SimpleDateFormat dayFormat = new SimpleDateFormat("E");
        if(displayWay.equals(DAYMONTH)){
            name = dayFormat.format(c.getTime()).toUpperCase()+ "\n" + day + "/" + (month+1) + "\n" + year;
        }else if(displayWay.equals(MONTHDAY)){
            name = dayFormat.format(c.getTime()).toUpperCase()+ "\n" + (month+1) + "/" + day + "\n" + year;
        }else{name = dayFormat.format(c.getTime()).toUpperCase();}

        return name;
    }

    public String setDayNamesFromCalendar(int year, int month, int day){
        c = Calendar.getInstance();
        c.set(year, month, day);
        c.get(Calendar.DAY_OF_WEEK);
        String name;
        SimpleDateFormat dayFormat = new SimpleDateFormat("E");
        name = dayFormat.format(c.getTime()).toUpperCase();
        return name;

    }
}
