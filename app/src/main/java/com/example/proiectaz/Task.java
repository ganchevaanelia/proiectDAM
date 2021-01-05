package com.example.proiectaz;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public class Task extends AsyncTask<Void, Void, Void> {
    private Context mycontext;

    public Task(Context c) {
        this.mycontext = c;


    }
    Dialog dialog;
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog = ProgressDialog.show(mycontext, "Updating ..", "Please wait......");
    }

    @Override
    protected Void doInBackground(Void... voids) {
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        if (dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
