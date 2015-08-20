package com.example.jarek.stratcaller.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jarek.stratcaller.R;
import com.example.jarek.stratcaller.logic.CounterLogic;
import com.example.jarek.stratcaller.widgets.TextViewPlus;

import java.util.HashMap;
import java.util.Map;

public class RoundActivity extends Activity {

    private TextView score;
    private TextViewPlus roundCount;
    private CounterLogic ctCounter;
    private CounterLogic ttCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_round);

        roundCount = (TextViewPlus) findViewById(R.id.round_text);
        score = (TextView) findViewById(R.id.score_text);

        Map<Integer, CounterLogic> points = new HashMap<>();
        points.put(R.id.ct, new CounterLogic());
        points.put(R.id.tt, new CounterLogic());

        for (int resource : points.keySet()) {
            prepareButton(resource, points.get(resource));
        }
    }

    //Create button
    private void prepareButton(final int resource, final CounterLogic sideCounter) {
        final Button button = (Button) findViewById(resource);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch (resource) {
                    case R.id.ct:
                        ctCounter = sideCounter;
                        if (!ctCounter.checkForWin()) { ctCounter.increment(); }
                        else { button.setEnabled(false); }
                        break;

                    case R.id.tt:
                        ttCounter = sideCounter;
                        if (!ttCounter.checkForWin()) { ttCounter.increment(); }
                        else { button.setEnabled(false); }
                        break;
                    }
                score.setText(ctCounter + " - " + ttCounter);
            }
        });
    }
}
