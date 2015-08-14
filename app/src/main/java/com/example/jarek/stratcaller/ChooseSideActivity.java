package com.example.jarek.stratcaller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;
import java.util.Map;

public class ChooseSideActivity extends Activity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        intent = new Intent(this, WarumupActivity.class);

        Bundle b = getIntent().getExtras();
        String total = b.getString("current map from ChooseMapActivity");
        intent.putExtra("current map from ChooseMapActivity", total);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_side);

        //Settings of side buttons
        Map<Integer, String> sides = new HashMap<>();
        sides.put(R.id.ct_side, "CT");
        sides.put(R.id.tt_side, "TT");

        for (int resource : sides.keySet()) {
            prepareButton(resource, sides.get(resource));
        }

    }

    private void prepareButton(final int resource, final String currentSide) {
        Button button = (Button) findViewById(resource);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                intent.putExtra("current side from ChooseSideActivity", currentSide);
                startActivity(intent);
            }
        });
    }
}