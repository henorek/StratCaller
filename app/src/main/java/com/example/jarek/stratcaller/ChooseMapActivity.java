package com.example.jarek.stratcaller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class ChooseMapActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_choose_map);

        /* TODO: Commentary to map settings */
        Button Dust2_Button = (Button) findViewById(R.id.dust2_button);
        Dust2_Button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(ChooseMapActivity.this, ChooseSideActivity.class));
            }
        });
    }
}
