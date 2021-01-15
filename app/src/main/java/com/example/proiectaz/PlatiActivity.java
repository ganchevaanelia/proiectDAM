package com.example.proiectaz;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PlatiActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 200;

    private DatabaseReference databaseReference;
    private ListView listView;
    List<Plata> plataList;
    final List<String> plati = new ArrayList<>();
    FirebaseDatabase database;
    PlataAdapter adapter;
    Button btnGrafic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plati);
        plataList = new ArrayList<>();
        adapter = new PlataAdapter(getApplicationContext(), R.layout.item_plati, plataList, getLayoutInflater(), R.drawable.payment_method);

        listView = findViewById(R.id.listViewPlati);
        database = FirebaseDatabase.getInstance();
        listView.setAdapter(adapter);
        btnGrafic = findViewById(R.id.Grafic);
        btnGrafic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Plata> list = new ArrayList<>(); //punem toate filmele
                for (Plata plata : plataList)
                    list.add(plata);
                Intent raportUtilizatori = new Intent(getApplicationContext(), RaportUtilizatori.class);
                raportUtilizatori.putExtra("list", list);
                startActivity(raportUtilizatori);
            }
        });
        //restaurare();
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference myRef = database.getReference("proiect-android-2560b-default-rtdb");
        myRef.keepSynced(true);

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                if (dataSnapshot == null) return;
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Plata plata = ds.getValue(Plata.class);
                    plataList.add(plata);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        Button adaugaPlata = findViewById(R.id.efectueaza_plata);
        adaugaPlata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Task(PlatiActivity.this).execute();

            }
        });


        BottomNavigationView btnNavView = findViewById(R.id.bottom_navigation);
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
                        startActivity(new Intent(getApplicationContext(), SesizariActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                }
                return false;
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            Plata plata = (Plata) data.getSerializableExtra(AdaugaPlataActivity.ADD_PLATA);

            if (plata != null) {
                plataList.add(plata);

                PlataAdapter adapter = new PlataAdapter(getApplicationContext(), R.layout.item_plati, plataList, getLayoutInflater(), R.drawable.payment_method) {

                    @NonNull
                    @Override
                    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                        View view = super.getView(position, convertView, parent);

                        Plata plata = plataList.get(position);

                        return view;
                    }
                };


                listView.setAdapter(adapter);
            }
        }


    }

}