package com.example.jarek.stratcaller;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import org.springframework.web.client.RestTemplate;

public class MainMenuActivity extends Activity {

    private class  DatabaseLoaderTask extends AsyncTask<String, Void, String> {

        TextView testText;
        String content;

        @Override
        protected void onPreExecute() {
            testText = (TextView) findViewById(R.id.textView);
        }

        @Override
        protected String doInBackground(String... urls) {
            RestTemplate restTemplate = new RestTemplate();
            final String content = restTemplate.getForObject("http://192.168.0.102:8080/SpringMVCApp/api/tactics", String.class);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    testText.setText(content);
                }
            });
            return content;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_menu);

        DatabaseLoaderTask databaseLoaderTask = new DatabaseLoaderTask();
        databaseLoaderTask.execute();

        /* Swapping screen after choosing New Match button */
        Button NewMatchButton = (Button) findViewById(R.id.newmatch_button);
        NewMatchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainMenuActivity.this, ChooseMapActivity.class));
            }
        });

        /* Swapping screen after choosing Previous Match button */
        Button PrevMatchButton = (Button) findViewById(R.id.prevmatch_button);
        PrevMatchButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(MainMenuActivity.this, PrevMatchesActivity.class));
            }
        });

        /* Swapping screen after choosing Settings button */
        Button SettingsButton = (Button) findViewById(R.id.settings_button);
        SettingsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainMenuActivity.this, SettingsActivity.class));
            }
        });
    }
}