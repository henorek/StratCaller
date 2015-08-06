package com.example.jarek.stratcaller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainMenuActivity extends Activity {

    TextView testText;
    DatabaseLoader databaseLoaderTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

//        databaseLoaderTask = new DatabaseLoader();
//        testText = (TextView) findViewById(R.id.textView);
//
//        databaseLoaderTask.execute("de_dust2");
//        databaseLoaderTask.delegate = this;

        /* Swapping screen after choosing New Match button */
        Button NewMatchButton = (Button) findViewById(R.id.new_match_button);
        NewMatchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainMenuActivity.this, ChooseMapActivity.class));
            }
        });

        /* Swapping screen after choosing Previous Match button */
        Button PrevMatchButton = (Button) findViewById(R.id.prev_match_button);
        PrevMatchButton.setEnabled(false);
        PrevMatchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainMenuActivity.this, PrevMatchesActivity.class));
            }
        });

        /* Swapping screen after choosing Training button */
        Button TrainingButton = (Button) findViewById(R.id.training_button);
        TrainingButton.setEnabled(false);
        TrainingButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainMenuActivity.this, SettingsActivity.class));
            }
        });

        /* Swapping screen after choosing Settings button */
        Button SettingsButton = (Button) findViewById(R.id.settings_button);
        SettingsButton.setEnabled(false);
        SettingsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainMenuActivity.this, SettingsActivity.class));
            }
        });


    }



//    @Override
//    public void processFinish(TacticsEntity[] output) {
//        Random random = new Random();
//        int n = random.nextInt(output.length);
//        testText.setText(output[n].getCategory());
//    }
}