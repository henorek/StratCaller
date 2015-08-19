package com.example.jarek.stratcaller.widgets;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class TextViewPlus extends TextView{
    public TextViewPlus(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public TextViewPlus(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextViewPlus(Context context) {
        super(context);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                "coolvetica.ttf");
        setTypeface(tf);
    }

}
