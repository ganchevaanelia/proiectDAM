package com.example.proiectaz;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class PlatiActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 200;

    private ListView listView;
    List<Plata> plataList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plati);

        Button adaugaPlata= findViewById(R.id.efectueaza_plata);
        adaugaPlata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AdaugaPlataActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

listView=findViewById(R.id.listViewPlati);

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null) {
          Plata plata = (Plata) data.getSerializableExtra(AdaugaPlataActivity.ADD_PLATA);

          if (plata !=null){
              plataList.add(plata);

              PlataAdapter adapter=new PlataAdapter(getApplicationContext(), R.layout.item_plati,plataList,getLayoutInflater(), R.drawable.payment_method){
//getApplicationContext(), R.layout.item_plati,plataList,getLayoutInflater()
                  @NonNull
                  @Override
                  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                      View view = super.getView(position, convertView, parent);

                      Plata plata =  plataList.get(position);

                      return view;
                  }
              };
//              ArrayAdapter<Plata> adapter = new ArrayAdapter<Plata>(PlatiActivity.this,
//                      android.R.layout.simple_list_item_1, plataList);


              listView.setAdapter(adapter);
          }
          }


    }
}
