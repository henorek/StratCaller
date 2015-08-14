package com.example.jarek.stratcaller;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RoundActivity extends Activity {

    int counterL = 0;
    int counterR = 0;
    int roundNumber = 1;

    TextView score;
    TextViewPlus roundCount;

    Button ctButton;
    Button ttButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_round);

        roundCount = (TextViewPlus) findViewById(R.id.round_text);
        score = (TextView) findViewById(R.id.score_text);
        ctButton = (Button) findViewById(R.id.ct);
        ttButton = (Button) findViewById(R.id.tt);

        ctButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counterL < 16) {
                    counterL++;
                    roundNumber++;
                    score.setText(counterL + " - " + counterR);
                } else if (counterL == 16) {
                    Toast.makeText(RoundActivity.this, "Counter Terrorist Win!", Toast.LENGTH_LONG).show();
                    ctButton.setEnabled(false);
                    ttButton.setEnabled(false);
                }

                roundCount.setText("#" + roundNumber + " Round");
            }
        });

        ttButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counterR < 16) {
                    counterR++;
                    roundNumber++;
                    score.setText(counterL + " - " + counterR);
                } else if (counterR == 16) {
                    Toast.makeText(RoundActivity.this, "Terrorist Win!", Toast.LENGTH_LONG).show();
                    ctButton.setEnabled(false);
                    ttButton.setEnabled(false);
                }

                roundCount.setText("#" + roundNumber + " Round");
            }
        });


    }

    public void showMessage(String message){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage(message);
    }
}
