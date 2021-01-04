package com.hfad.myfirstapp;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

public class FractionView extends LinearLayout {

    public FractionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.fraction_view, this);
    }

    public void setFraction(String fraction) {
        final String[] arr = fraction.split("[/]");
        ((TextView) findViewById(R.id.nominatorTv)).setText(arr[0]);
        ((TextView) findViewById(R.id.denominatorTv)).setText(arr[1]);
    }

}
