package com.example.dowloadtask;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;

public class DownloadTask extends AsyncTask<String, Void, Bitmap> {

    private Context context;
    private ImageView imageView;
    private ProgressDialog progressDialog;

    public DownloadTask(Context context, ImageView imageView) {

        this.context = context;
        this.imageView = imageView;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        progressDialog = ProgressDialog.show(context, "por favor aguarde...", "Baixando imagen...");

    }

    @Override
    protected Bitmap doInBackground(String... strings) {

        Auxiliar auxiliar = new Auxiliar();
        Bitmap imageBitmap = null;

        try {
            imageBitmap = auxiliar.baixarImagem(strings[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return imageBitmap;

    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        imageView.setImageBitmap(bitmap);
        progressDialog.dismiss();

    }
}

