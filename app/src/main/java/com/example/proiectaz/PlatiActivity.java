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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plati);
        plataList=new ArrayList<>();
       adapter=new PlataAdapter(getApplicationContext(), R.layout.item_plati, plataList, getLayoutInflater(), R.drawable.payment_method);

        listView = findViewById(R.id.listViewPlati);
        database = FirebaseDatabase.getInstance();
        listView.setAdapter(adapter);
        //restaurare();
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference myRef = database.getReference("proiect-android-2560b-default-rtdb");
        myRef.keepSynced(true);

        myRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                if (dataSnapshot == null) return;
                for( DataSnapshot ds :dataSnapshot.getChildren()) {
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
//
//        final DatabaseReference myRef = database.getReference("proiect-android-2560b-default-rtdb");
//        myRef.keepSynced(true);
//
//        ValueEventListener messageListener = new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if (snapshot.exists()) {
//                    plataList.clear();
//                    for (DataSnapshot dn : snapshot.getChildren()) {
//                        Plata plata = dn.getValue(Plata.class);
//                        plataList.add(plata);
//                    }
//                }
//
//
//                plati.clear();
//                for (Plata pl : plataList)
//                    plati.add(pl.toString());
//
//
//                PlataAdapter adapter = new PlataAdapter(getApplicationContext(), R.layout.item_plati, plataList, getLayoutInflater(), R.drawable.payment_method) {
//                    //getApplicationContext(), R.layout.item_plati,plataList,getLayoutInflater()
//                    @NonNull
//                    @Override
//                    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//                        View view = super.getView(position, convertView, parent);
//
//                        Plata plata = plataList.get(position);
//
//                        return view;
//                    }
//                };
//                listView.setAdapter(adapter);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        };
//        myRef.child("proiect-android-2560b-default-rtdb").addValueEventListener(messageListener);
//

            Button adaugaPlata= findViewById(R.id.efectueaza_plata);
        adaugaPlata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                new Task(PlatiActivity.this).execute();

                Intent intent = new Intent(getApplicationContext(), AdaugaPlataActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
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
                        startActivity(new Intent(getApplicationContext(), SesizariActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                }
                return false;
            }
        });
    }
//    @Override
//    protected void onStart() {
//        super.onStart();
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//
//        DatabaseReference myRef = database.getReference("proiect-android-2560b-default-rtdb");
//        myRef.keepSynced(true);
//
//        myRef.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                if (dataSnapshot == null) return;
//                for( DataSnapshot ds :dataSnapshot.getChildren()) {
//                   Plata plata = ds.getValue(Plata.class); //here 'Bazar' model class
//                    plataList.add(plata);
//                }
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

//
//        ValueEventListener listener = new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//                if(snapshot.exists())
//                {
//                    plataList.clear();
//                    for(DataSnapshot dn: snapshot.getChildren())
//                    {
//
//
//                        Plata plata = dn.getValue(Plata.class);
//                        plataList.add(plata);
//                    }
//                }
//
//                PlataAdapter adapter = new PlataAdapter(getApplicationContext(), R.layout.item_plati,
//                        plataList, getLayoutInflater(), R.drawable.payment_method){
//                    @NonNull
//                    @Override
//                    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//                        View view = super.getView(position, convertView, parent);
//
//                        Plata plata =  plataList.get(position);
//
//
//                        return view;
//                    }
//                };
//                listView.setAdapter(adapter);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        };
//
//        myRef.child("proiect-android-2560b-default-rtdb").addValueEventListener(listener);
  //  }



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




    //    public ArrayList<Plata> restaurare() {
//
//        final DatabaseReference myRef = database.getReference("proiect-android-2560b-default-rtdb");
//        myRef.child("proiect-android-2560b-default-rtdb").addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                plataList.clear();
//                if (dataSnapshot.exists() && dataSnapshot.getChildrenCount() > 0) {
//                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
//                        Plata plata = ds.getValue(Plata.class);
//                        plataList.add(plata);
//                    }
//                    PlataAdapter adapter = new PlataAdapter(getApplicationContext(), R.layout.item_plati, plataList, getLayoutInflater(), R.drawable.payment_method) {
//                        @NonNull
//                        @Override
//                        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//
//                            View view = super.getView(position, convertView, parent);
//
//                            Plata plata = plataList.get(position);
//
//                            return view;
//                        }
//                    };
//                    listView.setAdapter(adapter);
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//        return (ArrayList<Plata>) plataList;
//    }
}


