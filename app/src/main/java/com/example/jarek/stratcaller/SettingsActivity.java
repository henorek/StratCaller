package com.example.jarek.stratcaller;

import com.example.jarek.stratcaller.util.SystemUiHider;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 *
 * @see SystemUiHider
 */
public class SettingsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_settings);


    }
}
