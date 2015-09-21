package com.example.jarek.stratcaller.activities;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.jarek.stratcaller.R;
import com.example.jarek.stratcaller.data.TacticsDAO;
import com.example.jarek.stratcaller.data.TacticsEntity;
import com.example.jarek.stratcaller.logic.CounterLogic;
import com.example.jarek.stratcaller.logic.EconomyLogic;
import com.example.jarek.stratcaller.logic.TacticsMatchingLogic;
import com.example.jarek.stratcaller.widgets.TacticsListView;

public class RoundActivity extends Activity {

    private TextView score;
    private CounterLogic ctCounter = new CounterLogic();
    private CounterLogic ttCounter = new CounterLogic();
    private CounterLogic winStreak = new CounterLogic();
    private CounterLogic loseStreak = new CounterLogic();
    private EconomyLogic ctEconomy = new EconomyLogic();
    private CounterLogic round = new CounterLogic();
    private TacticsMatchingLogic matching = new TacticsMatchingLogic();

    private String mapChoice;
    private String sideChoice;

    private int ctMoney;

    public void setCtMoney(int ctMoney) {
        this.ctMoney = ctMoney;
    }

    private Bundle bundle;
    private Intent intent;

    private SimpleCursorAdapter dataAdapter;

    private TacticsEntity currentTactic = new TacticsEntity();

    TacticsDAO tacticsDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round);

        intent = new Intent(this, TacticActivity.class);

        TacticsDAO tacticsDAO = new TacticsDAO(this);

        bundle = getIntent().getExtras();
        mapChoice = bundle.getString("current map from WarumupActivity");
        sideChoice = bundle.getString("current side from WarumupActivity");

        Cursor cursor = tacticsDAO.getAllDataCursor();

        // create the adapter using the cursor pointing to the desired data
        //as well as the layout information
        dataAdapter = new SimpleCursorAdapter(this, R.layout.tactic_row, cursor, TacticsDAO.getCOLUMNS_SHORT(), TacticsListView.getColumnsShort(), 0);

        ListView listView = (ListView) findViewById(R.id.listView);
        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent.putExtra("current strat", id);
                startActivity(intent);
            }
        });
//        ListAdapter listAdapter = new TacticsListView(this, tacticsDAO.getAllData());
//
//        ListView tacticsList = (ListView) findViewById(R.id.listView);
//        tacticsList.setAdapter(listAdapter);
//
//        tacticsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Cursor cursor = (Cursor) parent.getItemAtPosition(position);
//                cursor.getString(0);
//                Log.e("POSITION", cursor.getString(0));
//                intent.putExtra("current strat", cursor.getString(0));
//                startActivity(intent);
//            }
//        });



//
//
//
//        List<TacticsEntity> sidestrat = tacticsDAO.getData(mapChoice, sideChoice);
//        TacticsEntity test = sidestrat.get(0);
//        Log.e("It's alive!", test.getName());
//
//        score = (TextView) findViewById(R.id.score_text);
//        TextView title = (TextView) findViewById(R.id.tactic_title_text);
//        title.setText(test.getName());
//
//        final Button ct = (Button) findViewById(R.id.ct);
//        final Button tt = (Button) findViewById(R.id.tt);
//
//        final TextViewPlus roundCount = (TextViewPlus) findViewById(R.id.round_text);
//
//        ct.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                if (!ctCounter.checkForWin() && !ctCounter.checkForDraw(ctCounter, ttCounter)) {
//                    ctCounter.increment();
//                    round.increment();
//                    if(matching.sideSwapCheck(round)) sideChoice =  matching.sideSwap(sideChoice);
//                    if(sideChoice == "CT"){
//                        winStreak.increment();
//                        loseStreak.clear();
//                        setCtMoney(ctEconomy.getWinMoney());
//                    }
//                    else{
//                        winStreak.clear();
//                        loseStreak.increment();
//                        setCtMoney(ctEconomy.moneyOnLoseStreak(loseStreak, true));
//                    }
//
//                } else {
//                    tt.setEnabled(false);
//                    ct.setEnabled(false);
//                }
//                score.setText(ctCounter + " - " + ttCounter);
//                roundCount.setText("#" + round.toString() + " Round");
//            }
//        });
//
//        tt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (!ttCounter.checkForWin() && !ctCounter.checkForDraw(ctCounter, ttCounter)) {
//                    ttCounter.increment();
//
//                } else {
//                    tt.setEnabled(false);
//                    ct.setEnabled(false);
//                }
//                score.setText(ctCounter + " - " + ttCounter);
//            }
//        });


//        Map<Integer, CounterLogic> points = new HashMap<>();
//        points.put(R.id.ct, new CounterLogic());
//        points.put(R.id.tt, new CounterLogic());
//
//        for (int resource : points.keySet()) {
//            prepareButton(resource, points.get(resource));
//        }
//    }
//    //Create button
//    private void prepareButton(final int resource, final CounterLogic sideCounter) {
//        final CounterLogic roundCounter = new CounterLogic(1);
//        final TextViewPlus roundCount = (TextViewPlus) findViewById(R.id.round_text);
//        final Button button = (Button) findViewById(resource);
//        button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                switch (resource) {
//                    case R.id.ct:
//                        ctCounter = sideCounter;
//                        if (!ctCounter.checkForWin()) { ctCounter.increment(); }
//                        else { button.setEnabled(false); }
//                        break;
//
//                    case R.id.tt:
//                        ttCounter = sideCounter;
//                        if (!ttCounter.checkForWin()) { ttCounter.increment(); }
//                        else { button.setEnabled(false); }
//                        break;
//                    }
//                roundCounter.increment();
//                roundCount.setText("#" + roundCounter.toString() + " Round");
//                score.setText(ctCounter + " - " + ttCounter);
//            }
//        });
//    }

    }
}