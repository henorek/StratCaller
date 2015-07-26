package com.example.jarek.stratcaller;

import com.example.jarek.stratcaller.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class ChooseSideActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    this.requestWindowFeature(Window.FEATURE_NO_TITLE);

    setContentView(R.layout.activity_choose_side);

    /* TODO: Commentary to map settings */
    Button CT_Button = (Button) findViewById(R.id.ct_side);
        Typeface tfFutura = Typeface.createFromAsset(getAssets(), "coolvetica.ttf");
        CT_Button.setTypeface(tfFutura);
        CT_Button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            startActivity(new Intent(ChooseSideActivity.this, WarumupActivity.class));
        }
    });
}
}