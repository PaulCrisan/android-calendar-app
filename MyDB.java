package com.wallpapernote.plutopix.wallpaperorganizer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MyDB extends SQLiteOpenHelper {

    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "organizer";

    // Table Names
    private static final String TABLE_TODO = "todos";

    // Common column names
    private static final String KEY_ID = "_id";
    private static final String YEAR = "year";
    private static final String MONTH = "month";
    private static final String DAY = "day";
    private static final String HOUR = "hour";
    private static final String NOTE = "note";

    private static final String STAR = "star";
    private static final String BIRTH = "birth";
    private static final String CUSTOMR = "customr";


    // Table Create Statements

    private static final String CREATE_TABLE_TODO = "CREATE TABLE "
            + TABLE_TODO + "(" + KEY_ID + " INTEGER PRIMARY KEY," + YEAR + " INTEGER," + MONTH
            + " INTEGER," + DAY + " INTEGER," + HOUR
            + " INTEGER," + NOTE + " TEXT," + STAR + " TEXT," + BIRTH + " TEXT," + CUSTOMR + " TEXT" + ")";


    private static MyDB sMyDB;

    public static synchronized MyDB getMyDB(Context context) {
        if (sMyDB == null) {
            sMyDB = new MyDB(context.getApplicationContext());
        }
        return sMyDB;
    }


    private MyDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_TODO);
        Log.d(Calendar_Activity.TAG, "onCreate: ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_TODO);
        onCreate(sqLiteDatabase);
    }

    public void insertNote(Model model) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(YEAR, model.getYear());
        contentValues.put(MONTH, model.getMonth());
        contentValues.put(DAY, model.getDay());
        contentValues.put(HOUR, model.getHour());
        contentValues.put(NOTE, model.getNote());
        db.insert(TABLE_TODO, null, contentValues);

    }
    public void insertCustomR2(int cyear, int cmonth, int cday, String cstring){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(YEAR, cyear);
        contentValues.put(MONTH, cmonth);
        contentValues.put(DAY, cday);
        contentValues.put(CUSTOMR, cstring);
        db.insert(TABLE_TODO, null, contentValues);
    }
    public void insertCustomR(Model model){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(YEAR, model.getYear());
        contentValues.put(MONTH, model.getMonth());
        contentValues.put(DAY, model.getDay());
        contentValues.put(CUSTOMR, model.getCustomr());
        db.insert(TABLE_TODO, null, contentValues);
    }

    public boolean customRCheck(int year, int month, int day) {


        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT *" + " FROM " + TABLE_TODO + " WHERE " + YEAR + " = " + year + " AND " + MONTH + " = " + month + " AND " + DAY +
                " = " + day + " AND " + CUSTOMR + " IS NOT NULL";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.getCount() > 0) {
            c.moveToFirst();
            if (c.getString(c.getColumnIndex(CUSTOMR)) != null) {
                if (c != null) {
                    c.close();
                }
                return true;
            } else {
                if (c != null) {
                    c.close();
                }
                return false;
            }
        }
        if (c != null) {
            c.close();
        }
        return false;

    }
    public void deleteCustomR(int year, int month, int day, String customRem){

        SQLiteDatabase db = this.getWritableDatabase();
        String whereClause = YEAR + " = " + year + " AND " +  MONTH + " = " + month +" AND " + DAY +
                " = " + day + " AND " + CUSTOMR + " = " + "'" + customRem + "'";
        db.delete(TABLE_TODO, whereClause, null);

    }

    public String getCustomRByDay(int year, int month, int day) {
        String customRString = null;
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT *"+ " FROM " + TABLE_TODO + " WHERE " + YEAR + " = " + year + " AND " + MONTH + " = " + month + " AND "
                + DAY + " = " + day + " AND " + CUSTOMR + " IS NOT NULL";
        Cursor c = db.rawQuery(selectQuery, null);
        Log.d("TAGo", "getCustomRByDay: count cursor is" + c.getCount());
        if (c.getCount() > 0) {
            Model td = new Model();
            if (c != null) {
                c.moveToFirst();
                Log.d("TAGo", "getCustomRByDay string custom r is : " +c.getString(c.getColumnIndex(CUSTOMR)) );
                td.setCustomr(c.getString(c.getColumnIndex(CUSTOMR)));
            }
            if (td.getCustomr() != null) {
                customRString = td.getCustomr();
            }
        }
        if (c != null) {
            c.close();
        }


        return customRString;
    }

    public void insertBirthday(Model model){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MONTH, model.getMonth());
        contentValues.put(DAY, model.getDay());
        contentValues.put(BIRTH, model.getBirthday());
        db.insert(TABLE_TODO, null, contentValues);

    }

    public boolean birthCheck(int month, int day){


        SQLiteDatabase db = this.getReadableDatabase();


        String selectQuery = "SELECT *" + " FROM " + TABLE_TODO + " WHERE " +MONTH + " = " + month + " AND " + DAY +
                " = " + day + " AND " + BIRTH + " IS NOT NULL";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.getCount() > 0) {
            c.moveToFirst();
            if(c.getString(c.getColumnIndex(BIRTH)) != null){
                if (c != null) {
                    c.close();
                }
                return true;
            }else {
                if (c != null) {
                    c.close();
                }
                return false;
            }


        }
        if (c != null) {
            c.close();
        }
        return false;

    }

    public void deleteBirth(int month, int day, String birthName){

        SQLiteDatabase db = this.getWritableDatabase();
        String whereClause = MONTH + " = " + month +" AND " + DAY +
                " = " + day + " AND " + BIRTH + " = " + "'" + birthName + "'";
        db.delete(TABLE_TODO, whereClause, null);

    }

    public void deleteStar(int year, int month, int day, int isStar){

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = null;
        String selectQuery = "SELECT " + KEY_ID + " FROM " + TABLE_TODO + " WHERE " +
                YEAR + " = " + year + " AND " + MONTH + " = " + month + " AND " + DAY +
                " = " + day + " AND " + STAR + " = " + isStar;
        cursor = db.rawQuery(selectQuery,null);
        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            int id = cursor.getInt(cursor.getColumnIndex(KEY_ID));
            String whereClause = KEY_ID + " = ?";
            String[] whereArgs = new String[]{String.valueOf(id)};
            db.delete(TABLE_TODO, whereClause, whereArgs);

            if(cursor != null){cursor.close();}
        }
        if(cursor != null){cursor.close();}
    }


    public void insertStar(Model model) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
            contentValues.put(YEAR, model.getYear());
            contentValues.put(MONTH, model.getMonth());
            contentValues.put(DAY, model.getDay());
            contentValues.put(STAR, model.getStar());
            db.insert(TABLE_TODO, null, contentValues);

    }

    public boolean checkForStar(int year, int month, int day, int isStar) {

        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT *"+" FROM " + TABLE_TODO + " WHERE " +
                YEAR + " = " + year + " AND " + MONTH + " = " + month + " AND " + DAY +
                " = " + day + " AND " + STAR + " = " + isStar;
        Cursor c = db.rawQuery(selectQuery, null);

        if (c.getCount() > 0) {
            c.moveToFirst();
            if(c.getInt(c.getColumnIndex(STAR)) != 0){
                if (c != null) {
                    c.close();
                }
                return true;
            }else {
                if (c != null) {
                    c.close();
                }
                return false;
            }


        }
        if (c != null) {
            c.close();
        }
        return false;
    }

    public boolean checkForNote(int year, int month, int day, int hour) {

        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT *"+" FROM " + TABLE_TODO + " WHERE " +
                YEAR + " = " + year + " AND " + MONTH + " = " + month + " AND " + DAY +
                " = " + day + " AND " + HOUR + " = " + hour + " AND " + NOTE + " IS NOT NULL";
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.getCount() > 0) {
            c.moveToFirst();
            if(c.getString(c.getColumnIndex(NOTE)) != null){
                if (c != null) {
                    c.close();
                }
                return true;
            }else {
                if (c != null) {
                    c.close();
                }
                return false;
            }


        }
        if (c != null) {
            c.close();
        }
        return false;
    }


    public void updateNote(Model model) {


        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NOTE, model.getNote());
        String whereClause = YEAR + " = ? AND " + MONTH + " = ? AND "+ DAY + " = ? AND " + HOUR + " = ?";
        String[] whereArgs = new String[]{String.valueOf(model.getYear()),String.valueOf(model.getMonth()),
                String.valueOf(model.getDay()),String.valueOf(model.getHour())};

        //Log.d("TAG", "updateNote: " + hour);

        db.update(TABLE_TODO, contentValues, whereClause, whereArgs);

    }

    public void deleteNote(Model model) {


        SQLiteDatabase db = this.getWritableDatabase();

        String whereClause = YEAR + " = ? AND " + MONTH + " = ? AND "+ DAY + " = ? AND " + HOUR + " = ?";
        String[] whereArgs = new String[]{String.valueOf(model.getYear()),String.valueOf(model.getMonth()),
                String.valueOf(model.getDay()),String.valueOf(model.getHour())};



        db.delete(TABLE_TODO, whereClause, whereArgs);

    }
    public boolean deleteAll(){

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TODO,null,null);
        db.execSQL("VACUUM");


        return true;
    }


    public Model getNote(int day, int hour) {

        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_TODO + " WHERE "
                + DAY + " = " + day + " AND " + HOUR + " = " + hour;
        Cursor c = db.rawQuery(selectQuery, null);
        Model td = new Model();
        if (c != null) {
            c.moveToNext();


            td.setId(c.getInt(c.getColumnIndex(KEY_ID)));
            td.setYear(c.getInt(c.getColumnIndex(YEAR)));
            td.setMonth(c.getInt(c.getColumnIndex(MONTH)));
            td.setDay((c.getInt(c.getColumnIndex(DAY))));
            td.setHour(c.getInt(c.getColumnIndex(HOUR)));
            td.setNote(c.getString(c.getColumnIndex(NOTE)));
        }

        if (c != null) {
            c.close();
        }
        return td;

    }

    public int getNumberOfDailyNotes(int year, int month, int day) {

        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT " + NOTE + " FROM " + TABLE_TODO + " WHERE " + YEAR + " = " + year + " AND " + MONTH + " = " + month + " AND "
                + DAY + " = " + day;
        Cursor c = db.rawQuery(selectQuery, null);
        int count = c.getCount();
        if(count >0) {
            c.moveToFirst();
            do {

                String s = c.getString(c.getColumnIndex(NOTE));
                if (s == null) {
                    count = count - 1;
                }

            } while (c.moveToNext());
        }


        if (c != null) {
            c.close();
        }
        return count;
    }


    public String getNoteByHour(int year, int month, int day, int hour) {
        String note = "";
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT " + NOTE + " FROM " + TABLE_TODO + " WHERE " + YEAR + " = " + year + " AND " + MONTH + " = " + month + " AND "
                + DAY + " = " + day + " AND " + HOUR + " = " + hour;
        Cursor c = db.rawQuery(selectQuery, null);
        if (c.getCount() > 0) {
            Model td = new Model();
            if (c != null) {
                c.moveToFirst();



                td.setNote(c.getString(c.getColumnIndex(NOTE)));
            }

//           if (c != null) {
//               c.close();
//           }

            if (td.getNote() != null) {
                note = td.getNote();
            }

        }

        if (c != null) {
            c.close();
        }


        return note;
    }
    public ArrayList<String> getBirthdays(int month, int day){
        ArrayList<String>birthdays = new ArrayList<>();

        String selectQuery = "SELECT " + BIRTH +" FROM " + TABLE_TODO + " WHERE "  + MONTH + " = " + month + " AND "
                + DAY + " = " + day;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        if (c.moveToFirst()) {
            do {

                String s = c.getString(c.getColumnIndex(BIRTH));


                if(s != null){
                    birthdays.add(s);
                }

            } while (c.moveToNext());
        }
      //  String[] store = (String[]) birthdays.toArray();
       // String[] arrayOfStrings = birthdays.toArray(new String[birthdays.size()]);
        if(c != null){
            c.close();
        }

        return birthdays;
    }

    public ArrayList<Model> getAllToDos() {
        ArrayList<Model> todos = new ArrayList<Model>();
        String selectQuery = "SELECT  * FROM " + TABLE_TODO;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                Model td = new Model();
                td.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                td.setYear(c.getInt(c.getColumnIndex(YEAR)));
                td.setMonth(c.getInt(c.getColumnIndex(MONTH)));
                td.setDay((c.getInt(c.getColumnIndex(DAY))));
                td.setHour(c.getInt(c.getColumnIndex(HOUR)));
                td.setNote(c.getString(c.getColumnIndex(NOTE)));
                td.setStar(c.getInt(c.getColumnIndex(STAR)));
                td.setBirthday(c.getString(c.getColumnIndex(BIRTH)));
                td.setCustomr(c.getString(c.getColumnIndex(CUSTOMR)));

                // adding to todo list
                todos.add(td);
            } while (c.moveToNext());
        }
        ///////////////
        if(c != null){
            c.close();
        }

        ///////////!!!!!!!!!!!!!!!!!

        return todos;
    }

    public void insertArrayListData(ArrayList<Model> list) {

        SQLiteDatabase db = this.getWritableDatabase();
        for (Model model : list) {
            ContentValues contentValues = new ContentValues();

            contentValues.put(YEAR, model.getYear());
            contentValues.put(MONTH, model.getMonth());
            contentValues.put(DAY, model.getDay());
            contentValues.put(HOUR, model.getHour());
            contentValues.put(NOTE, model.getNote());
            contentValues.put(STAR, model.getStar());
            contentValues.put(BIRTH, model.getBirthday());
            contentValues.put(CUSTOMR, model.getCustomr());
            db.insert(TABLE_TODO, null, contentValues);
        }


    }


}
