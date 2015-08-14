package com.example.jarek.stratcaller;

import android.os.AsyncTask;

import org.springframework.web.client.RestTemplate;

class DatabaseLoader extends AsyncTask<LocalTacticsEntity, Void, TacticsEntity[]> {

    private final DatabaseLoaderResponse delegate=null;

    LocalTacticsEntity db;
    private TacticsEntity[] output;

    @Override
    protected TacticsEntity[] doInBackground(LocalTacticsEntity... urls) {
        RestTemplate restTemplate = new RestTemplate();
        output = restTemplate.getForObject("http://192.168.0.106:8080/SpringMVCApp/api/tactics/"+urls[0], TacticsEntity[].class);
        for (TacticsEntity data : output) {
            db.insertData(data.getName(), data.getDescription(), data.getCategory(), data.getMinimap(), data.getLevel(), data.getSide(), data.getDifficulty(), data.getAuthor());
        }
        return output;
    }

    @Override
    protected void onPostExecute(TacticsEntity[] output) {
        delegate.processFinish(output);
    }
}
