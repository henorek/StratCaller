package com.example.jarek.stratcaller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class ChooseSideActivity extends Activity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        intent = new Intent(this, WarumupActivity.class);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_side);

        //Settings of side buttons
        ArrayList<Integer> sides = new ArrayList<>();
        sides.add(R.id.ct_side);
        sides.add(R.id.tt_side);

        for (int resource : sides) {
            prepareButton(resource);
        }

    }

    private void prepareButton(final int resource) {
        Button button = (Button) findViewById(resource);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
}