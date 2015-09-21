package com.example.jarek.stratcaller.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jarek.stratcaller.R;
import com.example.jarek.stratcaller.data.TacticsDAO;
import com.example.jarek.stratcaller.data.TacticsEntity;

import java.util.HashMap;
import java.util.Map;

public class TacticActivity extends Activity {

    private Bundle bundle;
    private Long currentTacticID;

    private TacticsDAO tacticsDAO;
    private TacticsEntity tacticsEntity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tactic);

        bundle = getIntent().getExtras();
        currentTacticID = bundle.getLong("current strat");

        tacticsDAO = new TacticsDAO(this);
        tacticsEntity = tacticsDAO.getDataById(currentTacticID);

        //Set of parameters for prepareButton method -> map buttons
        Map<Integer, String> tactic_items = new HashMap<>();

        TextView tactic_title = (TextView) findViewById(R.id.tactic_title);
        tactic_title.setText(String.valueOf(currentTacticID));

    }

    //Create button
    private void prepareTextViewPlus(final int resource, final String mapChoice) {
        Button button = (Button) findViewById(resource);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });
    }
}