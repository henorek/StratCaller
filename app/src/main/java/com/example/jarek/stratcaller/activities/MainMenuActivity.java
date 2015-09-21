package com.example.jarek.stratcaller.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jarek.stratcaller.R;
import com.example.jarek.stratcaller.data.DatabaseUpdater;
import com.example.jarek.stratcaller.data.TacticsDAO;

import java.util.HashMap;
import java.util.Map;

public class MainMenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        DatabaseUpdater databaseUpdaterTask = new DatabaseUpdater(this);
        databaseUpdaterTask.execute();

        Map<Integer, Intent> menu = new HashMap<>();
        menu.put(R.id.new_match_button, new Intent(this, ChooseMapActivity.class));
        menu.put(R.id.prev_match_button, new Intent(this, PrevMatchesActivity.class));
        menu.put(R.id.training_button, new Intent(this, SettingsActivity.class));
        menu.put(R.id.settings_button, new Intent(this, SettingsActivity.class));

        for (int resource : menu.keySet()) {
            prepareButton(resource, menu.get(resource));
        }
    }

    //Create button
    private void prepareButton(final int resource, final Intent location) {
        Button button = (Button) findViewById(resource);
        button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            startActivity(location);
        }
    });
    }
}