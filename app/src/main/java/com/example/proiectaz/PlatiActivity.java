package com.example.proiectaz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PlatiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plati);

        Button adaugaPlata= findViewById(R.id.efectueaza_plata);
        adaugaPlata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent it = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(new Intent(getApplicationContext(), AdaugaPlataActivity.class));
            }
        });



        BottomNavigationView btnNavView=findViewById(R.id.bottom_navigation);
        btnNavView.setSelectedItemId(R.id.activ_plati);

        btnNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.activ_plati:
                    return true;
                    case R.id.drawer_layout:
                        startActivity(new Intent(getApplicationContext(), PaginaPersonalaActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.activ_sesizari:
                        startActivity(new Intent(getApplicationContext(), AdaugaSesizareActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                }
                return false;
            }
        });
    }

    public void arataListaPlati(View view) {
//se va afisa lista cu platile efectuate
    }

}
