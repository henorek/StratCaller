package com.example.jarek.stratcaller.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.jarek.stratcaller.data.DatabaseUpdater;
import com.example.jarek.stratcaller.R;
import com.example.jarek.stratcaller.data.TacticsDAO;
import com.example.jarek.stratcaller.data.TacticsEntity;
import com.example.jarek.stratcaller.widgets.ZoomableImageView;

import java.util.List;

public class WarumupActivity extends Activity {

    private Bitmap bitmap;
    private Intent intent;
    private Bundle bundle;
    private String mapChoice;
    private String sideChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warumup);

        DatabaseUpdater databaseUpdaterTask = new DatabaseUpdater(this);
        databaseUpdaterTask.execute();

        TacticsDAO tacticsDAO = new TacticsDAO(this);

        intent = new Intent(this, RoundActivity.class);

        bundle = getIntent().getExtras();
        mapChoice = bundle.getString("current map from ChooseMapActivity");
        sideChoice = bundle.getString("current side from ChooseSideActivity");

        switch(mapChoice) {
            case "de_dust2":
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dust2_minimap);
                break;
            case "de_cache":
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cache_minimap);
                break;
            case "de_mirage":
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.mirage_minimap);
                break;
            case "de_inferno":
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.inferno_minimap);
                break;
            case "de_nuke":
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.nuke_minimap);
                break;
            case "de_train":
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.train_minimap);
                break;
            case "de_cobblestone":
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cobblestone_minimap);
                break;
            case "de_overpass":
                bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.overpass_minimap);
                break;
        }

        List<TacticsEntity> sidestrat = tacticsDAO.getData(mapChoice, sideChoice);
        TacticsEntity test = sidestrat.get(0);
        Log.e("It's alive!", test.getName());

        ZoomableImageView mini_map = (ZoomableImageView) findViewById(R.id.minimap);
        mini_map.setImageBitmap(bitmap);

        Button startButton = (Button) findViewById(R.id.start_buton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
}