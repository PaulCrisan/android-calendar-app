package com.wallpapernote.plutopix.wallpaperorganizer;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class ToToWithCursor extends AppCompatActivity implements AdapterView.OnItemLongClickListener {


    ModelForCheckingtwoStrings modelCheck = new ModelForCheckingtwoStrings();


    private static final String TAG = "tag";
    private boolean textChanged = false;
    private ImageButton addingTodo;
    private MyCursorAdapter customAdapter;
    private Cursor mCursor;
    private ListView todoList;
    private ToDoListDB db;

    private int counter = 1;


    private Handler h;


    private Runnable r = new Runnable() {
        @Override
        public void run() {
            manageDataBase();

            customAdapter = new MyCursorAdapter(
                    ToToWithCursor.this,
                    mCursor,
                    0);


            todoList.setAdapter(customAdapter);

        }
    };

    private LinearLayout info;
    private SharedPreferences mshared;
    private TextWatcher tw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);




        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
        window.addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
        window.addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);


        info = (LinearLayout) findViewById(R.id.info_layout);
        CheckBox check_info = (CheckBox) findViewById(R.id.checkbox_info);

        check_info.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    Log.d(TAG, "onCheckedChanged: " + "checked is true");
                    info.setVisibility(View.INVISIBLE);
                    SharedPreferences.Editor editor = mshared.edit();
                    editor.putBoolean("todoinfo", true);
                    editor.commit();

                }
            }
        });


        mshared = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        if (mshared.contains("todoinfo")) {

            boolean check = mshared.getBoolean("todoinfo", false);
            if (check) {
                info.setVisibility(View.INVISIBLE);
            } else info.setVisibility(View.VISIBLE);


        } else {
            SharedPreferences.Editor editor = mshared.edit();
            editor.putBoolean("todoinfo", false);
            editor.commit();
        }


        h = new Handler();
        addingTodo = (ImageButton) findViewById(R.id.add_todo);
        todoList = (ListView) findViewById(R.id.todo_listview);

        final RelativeLayout rl = (RelativeLayout) findViewById(R.id.rel_list_todo);
        db = new ToDoListDB(getApplicationContext());

        rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textChanged) {
                    savinginDB();
                    //h.post(r);
                }

            }
        });


        todoList.setAdapter(customAdapter);


        addingTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.insertToDo("");
                h.post(r);


            }
        });

        tw = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                textChanged = true;


            }

            @Override
            public void afterTextChanged(Editable editable) {
                modelCheck.setEditText(editable.toString());
            }
        };


        todoList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                int ll = (int) l;

                Log.d(TAG, "onItemClick: ");

                if (textChanged) {
                    savinginDB();
                    counter = 1;


                } else {

                    final MyCursorAdapter.MYviewHolder holder = (MyCursorAdapter.MYviewHolder) view.getTag();
                    if (holder != null) {
                        holder.et.setText(holder.tv.getText());
                        holder.tv.setVisibility(View.INVISIBLE);
                        holder.et.setVisibility(View.VISIBLE);
                        holder.et.addTextChangedListener(tw);



                    }
                    modelCheck.setCursorID(ll);

                    Log.d(TAG, "initial: " + counter + textChanged);
                    if (counter == 2) {



                        holder.et.setVisibility(View.INVISIBLE);
                        holder.tv.setVisibility(View.VISIBLE);
                        hideSoftKeyboard();
                        counter = 0;
                        h.post(r);

                        Log.d(TAG, "reset: " + counter + textChanged);
                    }
                    counter++;
                    Log.d(TAG, "increment: " + counter + textChanged);


                }

            }
        });
        manageDataBase();
        h.post(r);


        todoList.setOnItemLongClickListener(this);

        //


    }

    public void hideSoftKeyboard() {
        if (getCurrentFocus() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

        Log.d(TAG, "onItemLongClick: ");
        final MyCursorAdapter.MYviewHolder holder = (MyCursorAdapter.MYviewHolder) view.getTag();
        if (holder != null) {
            holder.deleteIV.setVisibility(View.VISIBLE);

            final int test = (int) l;
            holder.deleteIV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    db.deleteToDo(test);


                    // to delete
                    teste();
                    h.post(r);
                    //
                }
            });
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    holder.deleteIV.setVisibility(View.INVISIBLE);
                }
            }, 2000);
        }
        ///
        return true;
    }

    public void savinginDB() {
        String s = modelCheck.getEditText();
        int id = modelCheck.getCursorID();
        Log.d(TAG, "savinginDB: " + s + " id " + id);
        db.updateTodo(id, s);
        textChanged = false;
        hideSoftKeyboard();
        h.post(r);

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (textChanged) {
            savinginDB();
        }


    }

    @Override
    protected void onPostResume() {


        super.onPostResume();

    }

    public void manageDataBase() {
        String[] mProjection = {
                ToDoListDB._ID,
                ToDoListDB.TODO,
        };
        SQLiteDatabase d = db.getReadableDatabase();
        mCursor = d.query(ToDoListDB.TABLE_TODOLIST, mProjection, null, null, null, null, null);
        Log.d(TAG, "manageDataBase: ");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCursor != null) {
            mCursor.close();
            Log.d(TAG, "onDestroy: ");
        }
        if (db != null) {
            db.close();
        }
    }

    public void teste() {
        ArrayList<ModelForAdapter> s = new ArrayList<>();
        s = db.todolist();
        StringBuilder sb = new StringBuilder();
        for (ModelForAdapter m : s) {
            sb.append("\n" + m.getText() + " " + m.getId() + "\n");
        }
        Log.d("TAG", "data base is " + sb.toString());
    }

}
