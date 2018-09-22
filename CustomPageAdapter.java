package com.wallpapernote.plutopix.wallpaperorganizer;


import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.List;
public class CustomPageAdapter extends PagerAdapter {
    private Context context;
    private List<DataObject> dataObjectList;
    private LayoutInflater layoutInflater;
    public CustomPageAdapter(Context context, List<DataObject> dataObjectList){
        this.context = context;
        this.layoutInflater = (LayoutInflater)this.context.getSystemService(this.context.LAYOUT_INFLATER_SERVICE);
        this.dataObjectList = dataObjectList;
    }
    @Override
    public int getCount() {
        return dataObjectList.size();
    }
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((View)object);
    }
    @Override
    public Object instantiateItem(final ViewGroup container, int position) {
        View view = this.layoutInflater.inflate(R.layout.fragment_hour8, container, false);
        LinearLayout displayImage = (LinearLayout) view.findViewById(R.id.ll);
        LinearLayout displayImage2 = (LinearLayout) view.findViewById(R.id.ll2);
        LinearLayout displayImage3 = (LinearLayout) view.findViewById(R.id.ll3);
        LinearLayout displayImage4 = (LinearLayout) view.findViewById(R.id.ll4);
        LinearLayout base = (LinearLayout) view.findViewById(R.id.base_layout);

        displayImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(),Hour_activity.class);
                view.getContext().startActivity(i);
            }
        });

        TextView imageText = (TextView)view.findViewById(R.id.tv_fragment8);
        TextView imageText2 = (TextView)view.findViewById(R.id.tv_fragment2);
        TextView imageText3 = (TextView)view.findViewById(R.id.tv_fragment3);
        TextView imageText4 = (TextView)view.findViewById(R.id.tv_fragment4);
        displayImage2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(),Hour_activity.class);
                view.getContext().startActivity(i);
            }
        });
        displayImage3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(),Hour_activity.class);
                view.getContext().startActivity(i);
            }
        });
        displayImage4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(),Hour_activity.class);
                view.getContext().startActivity(i);
            }
        });

        displayImage.setBackgroundResource(this.dataObjectList.get(position).getImageId());
        displayImage2.setBackgroundResource(this.dataObjectList.get(position).getImageId2());
        displayImage3.setBackgroundResource(this.dataObjectList.get(position).getImageId3());
        displayImage4.setBackgroundResource(this.dataObjectList.get(position).getImageId4());
        imageText.setText(this.dataObjectList.get(position).getImageName());
        imageText2.setText(this.dataObjectList.get(position).getImageName2());
        imageText3.setText(this.dataObjectList.get(position).getImageName3());
        imageText4.setText(this.dataObjectList.get(position).getImageName4());
        container.addView(view);
        return view;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

}
