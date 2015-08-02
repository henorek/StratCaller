package com.example.jarek.stratcaller;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class PrevMatchesActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_prev_matches);
    }
}
