package com.example.proiectaz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class AdaugaSesizareActivity extends AppCompatActivity {
    public static final String ADD_SESIZARE = "AdaugaSesizare";

    public static UtilizatorDB userDB;


    Spinner spinnercategorieParent, spinnercategorieChild;
    ArrayList<String> arrayList_parent;
    ArrayAdapter<String> arrayAdapter_parent;

    ArrayList<String> arrayList_spatii, arrayList_strazi, arrayList_parcari,
            arrayList_iluminat, arrayList_alte;
    ArrayAdapter<String> arrayAdapter_child;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adauga_sesizare);
        final RatingBar ratingBar = findViewById(R.id.ratingBar);
        Button btnRating = findViewById(R.id.btnAdaugaRating);
        final TextView tvDispayRating = findViewById(R.id.rateCount);

        btnRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvDispayRating.setText("Recenzia ta : " + ratingBar.getRating());
            }
        });

        spinnercategorieParent = (Spinner) findViewById(R.id.spinnercategorieParent);
        spinnercategorieChild = (Spinner) findViewById(R.id.spinnercategorieChild);

        arrayList_parent = new ArrayList<>();
        arrayList_parent.add("Alege categoria potrivita");
        arrayList_parent.add("Spatii verzi/Parcuri");
        arrayList_parent.add("Strazi/Alei/Trotuare/Poduri");
        arrayList_parent.add("Parcari");
        arrayList_parent.add("Iluminat public");
        arrayList_parent.add("Altele");

        arrayAdapter_parent = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_item, arrayList_parent);
        spinnercategorieParent.setAdapter(arrayAdapter_parent);


        arrayList_spatii = new ArrayList<>();
        arrayList_spatii.add("Toaletare arbori");
        arrayList_spatii.add("Salubritate");
        arrayList_spatii.add("Copac periculos");

        arrayList_strazi = new ArrayList<>();
        arrayList_strazi.add("Surbare carusabil");
        arrayList_strazi.add("Denivelari");
        arrayList_strazi.add("Murdarie");
        arrayList_strazi.add("Semnalizare rutiera");
        arrayList_strazi.add("Hidrante");

        arrayList_parcari = new ArrayList<>();
        arrayList_parcari.add("Parcare neregulamentara");
        arrayList_parcari.add("Abonamente");

        arrayList_iluminat = new ArrayList<>();
        arrayList_iluminat.add("Bec ars");
        arrayList_iluminat.add("Lipsa iluminarii");
        arrayList_iluminat.add("Cabluri taiate");

        arrayList_alte = new ArrayList<>();
        arrayList_alte.add("");

        spinnercategorieParent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    spinnercategorieChild.setEnabled(false);
                    arrayAdapter_child = new ArrayAdapter<>(getApplicationContext(),
                            android.R.layout.simple_spinner_item, arrayList_alte);
                }

                if (position == 1) {
                    spinnercategorieChild.setEnabled(true);
                    arrayAdapter_child = new ArrayAdapter<>(getApplicationContext(),
                            android.R.layout.simple_spinner_item, arrayList_spatii);
                }

                if (position == 2) {
                    spinnercategorieChild.setEnabled(true);
                    arrayAdapter_child = new ArrayAdapter<>(getApplicationContext(),
                            android.R.layout.simple_spinner_item, arrayList_strazi);
                }

                if (position == 3) {
                    spinnercategorieChild.setEnabled(true);
                    arrayAdapter_child = new ArrayAdapter<>(getApplicationContext(),
                            android.R.layout.simple_spinner_item, arrayList_parcari);
                }

                if (position == 4) {
                    spinnercategorieChild.setEnabled(true);
                    arrayAdapter_child = new ArrayAdapter<>(getApplicationContext(),
                            android.R.layout.simple_spinner_item, arrayList_iluminat);
                }

                if (position == 5) {
                    spinnercategorieChild.setEnabled(false);
                    arrayAdapter_child = new ArrayAdapter<>(getApplicationContext(),
                            android.R.layout.simple_spinner_item, arrayList_alte);
                }

                spinnercategorieChild.setAdapter(arrayAdapter_child);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final EditText etDetaliiSesizare = findViewById(R.id.et_sesizari);
        final TextView tvValueRating = findViewById(R.id.rateCount);
        final EditText parereRating = findViewById(R.id.RatingBarDetalii);

        final Intent intent = getIntent();

        if (intent.hasExtra(SesizariActivity.EDIT_SESIZARE)) {
            Sesizare sesizare = (Sesizare) intent.getSerializableExtra(SesizariActivity.EDIT_SESIZARE);

            ArrayAdapter<String> adaptor = (ArrayAdapter<String>) spinnercategorieParent.getAdapter();
            for (int i = 0; i < adaptor.getCount(); i++)
                if (adaptor.getItem(i).equals(sesizare.getCategorie())) {
                    spinnercategorieParent.setSelection(i);
                    break;
                }

            ArrayAdapter<String> adaptor2 = (ArrayAdapter<String>) spinnercategorieChild.getAdapter();
            for (int i = 0; i < adaptor.getCount(); i++)
                if (adaptor2.getItem(i).equals(sesizare.getSubcategorie())) {
                    spinnercategorieChild.setSelection(i);
                    break;
                }

            etDetaliiSesizare.setText(sesizare.getDetaliiSesizare());
            parereRating.setText(sesizare.getParereDetalii());
        }



                   Button button= findViewById(R.id.btnSesizare);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (etDetaliiSesizare.getText().toString().isEmpty())
                        etDetaliiSesizare.setError("Introduceti detalii!");

                    try {
                        String categorie = String.valueOf(spinnercategorieParent.getSelectedItem().toString().toUpperCase());
                        String subcategorie = String.valueOf(spinnercategorieChild.getSelectedItem().toString().toUpperCase());
                        String detaliiSesizare = etDetaliiSesizare.getText().toString();
                        String tvDispayRating = tvValueRating.getText().toString();
                        String detaliiRating = parereRating.getText().toString();

                        Sesizare sesizare = new Sesizare(categorie, subcategorie, detaliiSesizare, tvDispayRating, detaliiRating);
                        userDB = Room.databaseBuilder(AdaugaSesizareActivity.this, UtilizatorDB.class, "UtilizatorDB").allowMainThreadQueries().build();
                        sesizare.setCategorie(spinnercategorieParent.getSelectedItem().toString());
                        sesizare.setSubcategorie(spinnercategorieChild.getSelectedItem().toString());
                        sesizare.setDetaliiSesizare(etDetaliiSesizare.getText().toString());

                        userDB.getUtilizatorDao().insertSesizare(sesizare);

                        intent.putExtra(ADD_SESIZARE, sesizare);
                        setResult(RESULT_OK, intent);
                        finish();

                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }



