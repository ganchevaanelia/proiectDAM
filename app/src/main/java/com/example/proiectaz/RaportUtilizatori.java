package com.example.proiectaz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.TypeConverters;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.XYSeries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RaportUtilizatori extends AppCompatActivity {


    ArrayList<Utilizator> list;
    LinearLayout layout;
    Map<Enum, Integer> source;
//    RadioGroup gen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raport_utilizatori);
//
//
//        gen=findViewById(R.id.radioGroup2);
//
//        Intent intent = getIntent();
//        ArrayList<UtilizatorDB> listaUtilizatoriF = (ArrayList<UtilizatorDB>)intent.getSerializableExtra("listaUtilizatoriF");
//        ArrayList<UtilizatorDB> listaUtilizatoriB = (ArrayList<UtilizatorDB>)intent.getSerializableExtra("listaUtilizatoriB");
//
//        List<Integer> listaFemei = new ArrayList<>();
//        List<Integer> listaBarbati = new ArrayList<>();
//
//        for(UtilizatorDB gn: listaUtilizatoriF)
//        listaFemei.add(GenConvertor.toGen(gn.toString().toUpperCase()));
//
//        for(UtilizatorDB gn: listaUtilizatoriB)
//            listaBarbati.add(GenConvertor.toGen(gn.toString().toUpperCase()));
//
//
//        XYPlot plot = findViewById(R.id.graficPlot);
//
//        plot.setTitle("----------");
//
//        XYSeries series1 = new SimpleXYSeries(listaFemei, SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "HBOGO");
//        plot.addSeries(series1, new LineAndPointFormatter(getApplicationContext(), R.layout.p1));
//
//        XYSeries series2 = new SimpleXYSeries(listaBarbati, SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "NetFlix");
//        plot.addSeries(series2, new LineAndPointFormatter(getApplicationContext(), R.layout.p2));



        Intent intent = getIntent();

        list = (ArrayList<Utilizator>) intent.getSerializableExtra("list");

        source = getSource(list);

        layout = findViewById(R.id.layoutBar);
        layout.addView(new AfiseazaRaportUtilizatori(getApplicationContext(), source));
    }

    private Map<Enum, Integer> getSource(List<Utilizator> movies)
    {
        if(movies==null || movies.isEmpty())
            return new HashMap<>();
        else
        {
            Map<Enum, Integer> results = new HashMap<>();
            for(Utilizator movie: movies)
                if(results.containsKey(movie.getGen()))
                    results.put(movie.getGen(), results.get(movie.getGen())+1);
                else
                    results.put(movie.getGen(), 1);
            return results;
        }
    }

}