
package com.example.proiectaz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RaportUtilizatori extends AppCompatActivity {


    ArrayList<Plata> list;
    LinearLayout layout;

    Map<String, Integer> source;

    //Map<Enum<Gen>, Integer> source;

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

        list = (ArrayList<Plata>) intent.getSerializableExtra("list");

        source = getSource(list);

        layout = findViewById(R.id.layoutBar);
        layout.addView(new AfiseazaRaportUtilizatori(getApplicationContext(), source));
    }


    private Map<String, Integer> getSource(List<Plata> plati) {
        if (plati == null || plati.isEmpty())
            return new HashMap<>();
        else {
            Map<String, Integer> results = new HashMap<>();
            for (Plata plata : plati)
                if (results.containsKey(plata.getTaxaImpozit()))
                    results.put(plata.getTaxaImpozit(), results.get(plata.getTaxaImpozit()) + 1);
                else
                    results.put(plata.getTaxaImpozit(),1);
            return results;


        }
    }
}

