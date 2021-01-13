
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raport_utilizatori);



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

