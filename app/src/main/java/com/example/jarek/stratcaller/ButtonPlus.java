package com.example.jarek.stratcaller;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

public class ButtonPlus extends Button {
    public ButtonPlus(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public ButtonPlus(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ButtonPlus(Context context) {
        super(context);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "coolvetica.ttf");
        setTypeface(tf);
    }
}