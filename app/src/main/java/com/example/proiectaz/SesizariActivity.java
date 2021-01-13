package com.example.proiectaz;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class SesizariActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 200;
    public static final int REQUEST_CODE_EDIT = 300;
    public static final String EDIT_SESIZARE= "editSesizare";
    public int poz;
    private ListView listView1;
    List<Sesizare> sesizareList = new ArrayList<Sesizare>();
    Button stergeSesizare;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesizari);
        listView1=findViewById(R.id.listViewSesizari);

        Button adaugaSesizare = findViewById(R.id.adauga_sesizare);
        adaugaSesizare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                intent = new Intent(getApplicationContext(), AdaugaSesizareActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                poz=position;
                intent=new Intent(getApplicationContext(), AdaugaSesizareActivity.class);
                intent.putExtra(EDIT_SESIZARE, sesizareList.get(position));
                startActivityForResult(intent, REQUEST_CODE_EDIT);


            }
        });
        listView1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                final Sesizare sesizare = sesizareList.get(position);
                final SesizareAdapter adapter = (SesizareAdapter) listView1.getAdapter();

                AlertDialog dialog = new AlertDialog.Builder(SesizariActivity.this)
                        .setTitle("Confirmare stergere")
                        .setMessage("Sigur doriti stergerea?")
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Toast.makeText(getApplicationContext(), "Nu s-a sters nimic!",
                                                Toast.LENGTH_LONG).show();
                                        dialogInterface.cancel();
                                    }
                        }).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                sesizareList.remove(sesizare);
                                adapter.notifyDataSetChanged();
                                Toast.makeText(getApplicationContext(), "S-a sters filmul: "+sesizare.toString(),
                                        Toast.LENGTH_LONG).show();
                                dialogInterface.cancel();
                            }
                        }).create();

                dialog.show();

                return true;
            }
        });




        BottomNavigationView btnNavView = findViewById(R.id.bottom_navigation);
        btnNavView.setSelectedItemId(R.id.activ_sesizari);

        btnNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.activ_sesizari:
                        return true;
                    case R.id.activ_plati:
                        startActivity(new Intent(getApplicationContext(),PlatiActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.drawer_layout:
                        startActivity(new Intent(getApplicationContext(), PaginaPersonalaActivity.class));
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
            Sesizare sesizare = (Sesizare) data.getSerializableExtra(AdaugaSesizareActivity.ADD_SESIZARE);

            if (sesizare != null) {
                sesizareList.add(sesizare);


                SesizareAdapter adapter = new SesizareAdapter(getApplicationContext(), R.layout.item_sesizari, sesizareList, getLayoutInflater()) {
                    @NonNull
                    @Override
                    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                        View view = super.getView(position, convertView, parent);

                        Sesizare sesizare = sesizareList.get(position);

                        return view;
                    }
                };
                listView1.setAdapter(adapter);
            }
        }
        else
        if (requestCode == REQUEST_CODE_EDIT && resultCode == RESULT_OK && data != null) {
            Sesizare sesizare = (Sesizare) data.getSerializableExtra(AdaugaSesizareActivity.ADD_SESIZARE);
            {
                if (sesizare != null) {
                    sesizareList.get(poz).setCategorie(sesizare.getCategorie());
                    sesizareList.get(poz).setSubcategorie(sesizare.getSubcategorie());
                    sesizareList.get(poz).setDetaliiSesizare(sesizare.getDetaliiSesizare());
                    sesizareList.get(poz).setParereRating(sesizare.getParereRating());
                    sesizareList.get(poz).setParereDetalii(sesizare.getParereDetalii());



                    SesizareAdapter adapter = new SesizareAdapter(getApplicationContext(), R.layout.item_sesizari, sesizareList, getLayoutInflater()) {

                        @Override
                        public View getView(int position, View convertView, ViewGroup parent) {

                            View view = super.getView(position, convertView, parent);

                            Sesizare sesizare = sesizareList.get(position);
                            return view;
                        }

                    };
                    listView1.setAdapter(adapter);
                }
            }
        }
    }
}





