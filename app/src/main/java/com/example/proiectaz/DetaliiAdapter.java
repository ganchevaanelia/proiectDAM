package com.example.proiectaz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.fragment.app.ListFragment;

import java.util.List;

public class DetaliiAdapter extends BaseAdapter {

    private Context context;
    private List <DetaliiOrase> detalii;

    public DetaliiAdapter(Context context, List<DetaliiOrase> detalii) {
        this.context = context;
        this.detalii = detalii;
    }

    @Override
    public int getCount() {
        return this.detalii.size();
    }

    @Override
    public Object getItem(int position) {
     return this.detalii.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.item_detalii_orase, parent,false);
        TextView tv1 = v.findViewById(R.id.tvcity);
        TextView tv2 = v.findViewById(R.id.tvLat);
        TextView tv3 = v.findViewById(R.id.tvLng);
        TextView tv4 = v.findViewById(R.id.tvCountry);
        TextView tv5 = v.findViewById(R.id.tvISO2);
        TextView tv6 = v.findViewById(R.id.tvAdminName);
        TextView tv7 = v.findViewById(R.id.tvCapital);
        TextView tv8 = v.findViewById(R.id.tvPopulation);
        TextView tv9 = v.findViewById(R.id.tvPopulationproper);

        DetaliiOrase o = (DetaliiOrase) getItem(position);
        tv1.setText(o.getCity());
        tv2.setText("" + o.getLat());
        tv3.setText("" + o.getLng());
        tv4.setText("" + o.getCountry());
        tv5.setText("" + o.getIso2());
        tv6.setText("" + o.getAdminName());
        tv7.setText("" + o.getCapital());
        tv8.setText("" + o.getPopulation());
        tv9.setText("" + o.getPopulationProper());
        return v;

    }
}
