package com.example.jarek.stratcaller.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jarek.stratcaller.R;

import java.util.HashMap;
import java.util.Map;

public class ChooseSideActivity extends Activity {

    private Intent intent;
    private Bundle bundle;
    private String currentMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        intent = new Intent(this, WarumupActivity.class);

        //Get intent from previous activity (chosen map) and send it further
        bundle = getIntent().getExtras();
        currentMap = bundle.getString("current map from ChooseMapActivity");
        intent.putExtra("current map from ChooseMapActivity", currentMap);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_side);

        //Set of parameters for prepareButton method -> side buttons
        Map<Integer, String> sides = new HashMap<>();
        sides.put(R.id.ct_side, "CT");
        sides.put(R.id.tt_side, "TT");

        for (int resource : sides.keySet()) {
            prepareButton(resource, sides.get(resource));
        }
    }

    //Create button
    private void prepareButton(final int resource, final String currentSide) {
        Button button = (Button) findViewById(resource);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Add chosen side to intent to send it for future use
                intent.putExtra("current side from ChooseSideActivity", currentSide);
                startActivity(intent);
            }
        });
    }
}