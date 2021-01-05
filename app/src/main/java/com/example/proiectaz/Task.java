package com.example.proiectaz;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

public class Task extends AsyncTask<Void, Void, Boolean> {
    private Activity activity;
    private ProgressDialog progressDialog;

    public Task(Activity activity){
        this.activity = activity;

    }
    @Override
    protected void onPreExecute() {
                progressDialog=new ProgressDialog(activity);
                progressDialog.show();
                progressDialog.setContentView(R.layout.progress_dialog);
                progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
        }
        progressDialog.dismiss();
        return true;
    }


    @Override
    protected void onPostExecute(Boolean rez) {
        activity.startActivity(new Intent(activity,AdaugaPlataActivity.class));
    }
}
