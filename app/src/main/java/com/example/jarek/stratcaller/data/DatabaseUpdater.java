package com.example.jarek.stratcaller.data;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.springframework.web.client.RestTemplate;

public class DatabaseUpdater extends AsyncTask<Void, Void, TacticsEntity[]> {

    private final Context mContext;
    public DatabaseUpdater(Context context) {
        mContext = context;
    }

    private TacticsEntity[] output;
    private TacticsDAO tacticsDAO;

    @Override
    protected TacticsEntity[] doInBackground(Void... urls) {
        RestTemplate restTemplate = new RestTemplate();
        tacticsDAO = new TacticsDAO(mContext);
        output = restTemplate.getForObject("http://192.168.0.104:8080/SpringMVCApp/api/tactics/de_dust2", TacticsEntity[].class);
        Log.e("Saved...", output[0].getName());
        return output;
    }

    @Override
    protected void onPostExecute(TacticsEntity[] output) {
        for (TacticsEntity data : output) {
            tacticsDAO.insertData(data.getIcon(), data.getName(), data.getDescription(), data.getCategory(), data.getMinimap(), data.getLevel(), data.getSide(), data.getDifficulty(), data.getGranades(), data.getFlashes(), data.getSmokes(), data.getMolotovs(), data.getDecoys(), data.getAuthor());
            Log.e("Saved...", data.toString());
        }
    }
}