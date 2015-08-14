package com.example.jarek.stratcaller;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WarumupActivity extends Activity {

    private Bitmap bitmap;
    DatabaseLoader databaseLoaderTask;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warumup);

        LocalTacticsEntity localTacticsEntity = new LocalTacticsEntity(this);
        localTacticsEntity.insertData("TEST", "TEST", "TEST", "TEST", "TEST", "TEST", 1, "TEST");

//        databaseLoaderTask = new DatabaseLoader();
//        databaseLoaderTask.execute("de_dust2");

        intent = new Intent(this, RoundActivity.class);

        Bundle b = getIntent().getExtras();
        String map = b.getString("current map from ChooseMapActivity");
        String side = b.getString("current side from ChooseSideActivity");

        switch(map) {
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

//        TextView testowo = (TextView) findViewById(R.id.textView2);
//        Cursor res = db.getData(map);
//
//        testowo.setText(res.getString(0));

        ZoomableImageView  mini_map = (ZoomableImageView) findViewById(R.id.minimap);
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
