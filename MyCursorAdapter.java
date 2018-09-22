package com.wallpapernote.plutopix.wallpaperorganizer;

import android.content.Context;
import android.database.Cursor;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MyCursorAdapter extends CursorAdapter {

    private LayoutInflater cursorInflater;




    static class MYviewHolder {
        protected ImageView deleteIV;
        protected EditText et;
        protected TextView tv;


        protected LinearLayout ll;

    }

    public MyCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        this.cursorInflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {



            View view = cursorInflater.inflate(R.layout.todo_adapter_layout, viewGroup, false);
             final MYviewHolder holder = new MYviewHolder();

            holder.deleteIV = (ImageView) view.findViewById(R.id.adapter_delete_ball);
            holder.tv = (TextView) view.findViewById(R.id.textview_todo);
            holder.et = (EditText) view.findViewById(R.id.todo_edittext);
            holder.ll = (LinearLayout)view.findViewById(R.id.linearadaptor);
            String title = cursor.getString( cursor.getColumnIndex(ToDoListDB.TODO ) );



            holder.deleteIV.setVisibility(View.INVISIBLE);

            holder.et.setVisibility(View.INVISIBLE);
            holder.tv.setText(title);

            holder.et.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View view, boolean b) {

                    if(b){
                        holder.ll.setBackgroundResource(R.drawable.yellow_square_shadowed_touched);





                    }else {
                        holder.ll.setBackgroundResource(R.drawable.yellow_square_shadowed);




                    }
                }
            });

            view.setTag(holder);

            //




        return view;

    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {


        MYviewHolder holder = (MYviewHolder)view.getTag();
        String title = cursor.getString( cursor.getColumnIndex(ToDoListDB.TODO ) );
        holder.tv.setText(title);
        if(holder.et.getVisibility() == View.VISIBLE){
            holder.et.setVisibility(View.INVISIBLE);
        }










    }
}
