package com.wallpapernote.plutopix.wallpaperorganizer;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;


public class MyCustomDialog extends Dialog {
        private String description;
        private String policyText;
        private View.OnClickListener okButton = null;
        private View.OnClickListener cancelButton = null;

    public MyCustomDialog(Activity a, String description, String policyText) {
        super(a);
        this.description = description;
        this.policyText = policyText;

    }

//    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.my_custom_dialog_layout);
        TextView t = (TextView)findViewById(R.id.custom_dialog_tv);
        TextView policy = (TextView)findViewById(R.id.the_policy);
        policy.setText(policyText);
        t.setText(description);
        Button ok = (Button)findViewById(R.id.custom_dialog_ok);
        ok.setOnClickListener(okButton);
        Button cancel = (Button)findViewById(R.id.custom_dialog_cancel);
        cancel.setOnClickListener(cancelButton);
        setCancelable(true);
    }

    public void setTheOkButton( View.OnClickListener onClickListener) {
        dismiss();
        this.okButton = onClickListener;
    }
    public void setCancelButton( View.OnClickListener onClickListener) {
        dismiss();
        this.cancelButton = onClickListener;
    }
}
