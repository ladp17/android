package com.example.asynctask;

import android.os.AsyncTask;
import android.widget.Button;
import android.widget.TextView;

public class Async extends AsyncTask<Integer ,Integer , Void> {

    private TextView textView;
    private Button button;

    public Async(TextView textView , Button button ) {

        this.textView = textView;
        this.button = button;

    }

    @Override
    protected Void doInBackground(Integer... integers) {

        int n = integers[0];
        int i = 0;

        while (i < n) {

            try {

                Thread.sleep(1000);

            } catch (InterruptedException e) {

                e.printStackTrace();

            }

            publishProgress(i);
            i++;

        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        textView.setText(String.valueOf(values[0]));

    }
}
