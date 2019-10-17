package com.example.sleepthread;

import android.os.AsyncTask;
import android.os.Handler;
import android.widget.TextView;

public class Freezer extends AsyncTask <String, String, String> {

    private String resp;
    private TextView finalResult;

    public Freezer(TextView finalResult) {

        this.finalResult = finalResult;

    }


    @Override
    protected String doInBackground(String... params) {

        publishProgress("Dormindo...");

        try {

            int time = Integer.parseInt(params[0]);
            Thread.sleep(time);
            resp = "Dormiu por " + time / 1000 + " segundos";

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }

        return resp;

    }


    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        finalResult.setText(values[0]);

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        finalResult.setText(s);

    }
}
