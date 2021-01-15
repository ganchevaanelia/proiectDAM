package com.example.proiectaz;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class PlataAdapter extends BaseAdapter {


    private Context context;
    private int resource;
    private List<Plata> plataList;
    private LayoutInflater layoutInflater;
    private int image;


    public PlataAdapter(Context context, int resource, List<Plata> plataList, LayoutInflater layoutInflater, int image) {

        this.context = context;
        this.resource = resource;
        this.plataList= plataList;
        this.layoutInflater = layoutInflater;
        this.image=image;
    }



    @Override
    public int getCount() {
        return this.plataList.size();
    }

    @Override
    public Object getItem(int position) {
        return plataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(context);
        final View view=inflater.inflate(R.layout.item_plati, parent, false);
        final Plata plata = plataList.get(position);


        ImageView imageView= view.findViewById(R.id.imageViewPlata);
        imageView.setImageResource(plata.getImagine());

        TextView tvNume=view.findViewById(R.id.numePrenume);
        tvNume.setText(plata.getNume());

        TextView tvPers=view.findViewById(R.id.tipPersoana);
        tvPers.setText(plata.getTipPersoana().toString());

        TextView tvTipPers=view.findViewById(R.id.tipPlata);
        tvTipPers.setText(plata.getTaxaImpozit().toString());

        TextView tvDetalii=view.findViewById(R.id.tvDetaliii);
        tvDetalii.setText(plata.getDetalii());

        final TextView nrSuma=view.findViewById(R.id.suma);
        nrSuma.setText( String.valueOf(plata.getSuma()));

        TextView nrCard=view.findViewById(R.id.nrCard);
        nrCard.setText(String.valueOf(plata.getNrCard()));

        TextView tvDate=view.findViewById(R.id.dataExpirarii);
        tvDate.setText(plata.getDataExpirarii().toString());

        TextView codCVV=view.findViewById(R.id.codCVV);
        codCVV.setText(String.valueOf(plata.getCodCvv()));

        Button btnMoreInfo=view.findViewById(R.id.btnMoreInfo);
        btnMoreInfo.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if(plata.getTaxaImpozit().equals("TAXA"))
                    view.setBackgroundColor(Color.GRAY);

                else
                    view.setBackgroundColor(Color.LTGRAY);
            }
        });

       return view;
    }



}
