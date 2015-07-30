package com.example.jarek.stratcaller;

import android.os.AsyncTask;

import org.springframework.web.client.RestTemplate;

public class DatabaseLoader extends AsyncTask<String, Void, TacticsEntity[]> {
    public DatabaseLoaderResponse delegate=null;

        TacticsEntity[] output;

        @Override
        protected TacticsEntity[] doInBackground(String... urls) {
            RestTemplate restTemplate = new RestTemplate();
            output = restTemplate.getForObject("http://192.168.0.106:8080/SpringMVCApp/api/tactics", TacticsEntity[].class);
            return output;
        }

        @Override
        protected void onPostExecute(TacticsEntity[] output) {
            delegate.processFinish(output);
        }
    }
