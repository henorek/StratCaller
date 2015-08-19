package com.example.jarek.stratcaller;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.springframework.web.client.RestTemplate;

class DatabaseUpdater extends AsyncTask<Void, Void, TacticsEntity[]> {

    private Context mContext;

    public DatabaseUpdater(Context context) {
        mContext = context;
    }

    private TacticsDAO tacticsDAO;
    private TacticsEntity[] output;
    private RestTemplate restTemplate;

    @Override
    protected TacticsEntity[] doInBackground(Void... urls) {
        restTemplate = new RestTemplate();
        tacticsDAO = new TacticsDAO(mContext);

        output = restTemplate.getForObject("http://192.168.0.100:8080/SpringMVCApp/api/tactics/de_dust2", TacticsEntity[].class);
        return output;
    }

    @Override
    protected void onPostExecute(TacticsEntity[] output) {
        for (TacticsEntity data : output) {
            tacticsDAO.insertData(data.getName(), data.getDescription(), data.getCategory(), data.getMinimap(), data.getLevel(), data.getSide(), data.getDifficulty(), data.getAuthor());
            Log.e("Saved...", tacticsDAO.toString());
        }
    }
}