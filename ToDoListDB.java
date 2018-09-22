package com.wallpapernote.plutopix.wallpaperorganizer;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;


public class ToDoListDB extends SQLiteOpenHelper {

    private static final int DATABASE_VERSIONOF = 1;

    // Database Name
    private static final String DATABASE_NAMEOF = "todolist";

    // Table Names
    public static final String TABLE_TODOLIST = "todoreminder";

    // Common column names
    public static final String _ID = "_id";
    public static final String TODO = "todo";





    // Table Create Statements

    private static final String CREATE_TABLE_TODOLIST = "CREATE TABLE "
            + TABLE_TODOLIST + "(" + _ID + " INTEGER PRIMARY KEY," + TODO + " TEXT"  + ")";


    private static ToDoListDB sToDoListDB;

//    public static synchronized ToDoListDB getMyTODOListDB(Context context) {
//        if (sToDoListDB == null) {
//            sToDoListDB = new ToDoListDB(context.getApplicationContext());
//        }
//        return sToDoListDB;
//    }



    public ToDoListDB(Context context) {
        super(context, DATABASE_NAMEOF, null, DATABASE_VERSIONOF);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_TODOLIST);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_TODOLIST);
    }
    public void deleteToDo(int id){
        SQLiteDatabase db = this.getWritableDatabase();

        String whereClause = _ID + " = ?";
        String[] whereArgs = new String[]{String.valueOf(id)};


        Log.d("TAG", "deleteToDo: " + id);
        db.delete(TABLE_TODOLIST, whereClause, whereArgs);
    }

    public void insertToDo( String text) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(TODO, text);

        db.insert(TABLE_TODOLIST, null, contentValues);

    }




    public void updateTodo( int id,String text){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(TODO, text);
        String whereClause = _ID  + " = ?";
        String[] whereArgs = new String[]{String.valueOf(id)};

        //Log.d("TAG", "updateNote: " + hour);

        db.update(TABLE_TODOLIST, contentValues, whereClause, whereArgs);

    }
    public ArrayList<ModelForAdapter>todolist(){
        ArrayList<ModelForAdapter>m = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_TODOLIST;

        Cursor c = db.rawQuery(selectQuery, null);


        if (c.moveToFirst()) {
            do {
                String s = c.getString(c.getColumnIndex(TODO));
                int sd = c.getInt(c.getColumnIndex(_ID));
                ModelForAdapter td = new ModelForAdapter();
                td.setText(s);
                td.setId(sd);



                // adding to todo list
                m.add(td);
            } while (c.moveToNext());
        }
        ///////////////
        if(c != null){
            c.close();
        }

        ///////////!!!!!!!!!!!!!!!!!


        return m;
    }
}
