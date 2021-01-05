package com.example.proiectaz;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;



public class SesizareAdapter extends BaseAdapter {
    private Context context;
    private int resource;
    private List<Sesizare> sesizareList;
    private LayoutInflater layoutInflater;


    public SesizareAdapter(Context context, int resource, List<Sesizare> sesizareList, LayoutInflater layoutInflater) {
        this.context = context;
        this.resource = resource;
        this.sesizareList = sesizareList;
        this.layoutInflater = layoutInflater;
    }

    @Override
    public int getCount() {
        return this.sesizareList.size();
    }

    @Override
    public Object getItem(int position) {
        return sesizareList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(context);
        final View view=inflater.inflate(R.layout.item_sesizari, parent, false);
        final Sesizare sesizare = sesizareList.get(position);

        final TextView tvCategorie=view.findViewById(R.id.tvCategorie);
        tvCategorie.setText(sesizare.getCategorie());

        final TextView tvSubcategorie=view.findViewById(R.id.tvSubcategorie);
        tvSubcategorie.setText(sesizare.getSubcategorie());

        final TextView tvDetaliiSesizare=view.findViewById(R.id.tvDetaliiSesizare);
        tvDetaliiSesizare.setText(sesizare.getDetaliiSesizare());

        final TextView tvRatingBarValue=view.findViewById(R.id.tvRatingBarValue);
        tvRatingBarValue.setText(sesizare.getParereRating());

        final TextView tvParereDetalii=view.findViewById(R.id.tvParereDetalii);
        tvParereDetalii.setText(sesizare.getParereDetalii());

        ImageView imageView=view.findViewById(R.id.imageViewSesizare);

        if(tvRatingBarValue.getText().toString().equals("Recenzia ta : 1.0") || tvRatingBarValue.getText().toString().equals("Recenzia ta : 2.0"))
        {
           imageView.setBackgroundResource(R.drawable.sad);
        }

        else if (tvRatingBarValue.getText().toString().equals("Recenzia ta : 3.0")){
            imageView.setBackgroundResource(R.drawable.neutral);

        }
        else {
            imageView.setBackgroundResource(R.drawable.smile);
        }


        return view;
    }
}
