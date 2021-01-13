package com.example.proiectaz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class AdaugaPlataActivity extends AppCompatActivity {


    public static final String ADD_PLATA = "AdaugaPlata";


    private TextView afiseazaData;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    ProgressDialog progressDialog;
    private FirebaseDatabase database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adauga_plata);
        database=FirebaseDatabase.getInstance();


        final Spinner spinnerPers=findViewById(R.id.spinner_TipulPersonei);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.add_plata_pers, R.layout.support_simple_spinner_dropdown_item);
        spinnerPers.setAdapter(adapter);


        afiseazaData = findViewById(R.id.tvDate);
        afiseazaData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

              DatePickerDialog dialog = new DatePickerDialog(
                        AdaugaPlataActivity.this,
                        mDateSetListener,
                        year, month, day);

                dialog.show();
            }

        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(ADD_PLATA, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                afiseazaData.setText(date);
            }


        };

        final EditText etNume=findViewById(R.id.etNumeSiPrenume);
        final RadioGroup radioGroup = findViewById(R.id.radioGroup);
        final EditText etDetalii=findViewById(R.id.etDetaliiTaxaImpozit);
        final EditText etSuma=findViewById(R.id.editTextNumberDecimal);
        final EditText  etNrCard=findViewById(R.id.etNumarCard);
        final Intent intent=new Intent(AdaugaPlataActivity.this, PlatiActivity.class);


        final EditText codCvv=findViewById(R.id.etCodCVV);
        final  String DATE_FORMAT = "dd/MM/yyyy";
        Button button=findViewById(R.id.btnPlateste);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(etNume.getText().toString().isEmpty())
                    etNume.setError("Introduceti numele si prenumele");
                else
                if(etDetalii.getText().toString().isEmpty())
                    etDetalii.setError("Introduceti denumirea taxei/impozitului");
                else
                    if(etSuma.getText().toString().isEmpty())
                        etSuma.setError("Introduceti suma");
                    else
                        if(etNrCard.getText().toString().isEmpty())
                            etNrCard.setError("Introduceti numarul cardului!");
                                if(etNrCard.length()<16 && etNrCard.length()>16)
                                     etNrCard.setError("Numar card INVALID!");

                        else
                            if(codCvv.getText().toString().isEmpty())
                                codCvv.setError("Introduceti codul cvv");
                            else {
                                SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT, Locale.US);

                                try {
                                    sdf.parse(afiseazaData.getText().toString());
                                    String nume = etNume.getText().toString();

                                    TipPersoana tipPersoana = TipPersoana.valueOf(spinnerPers.getSelectedItem().toString().toUpperCase());


                                    String detalii = etDetalii.getText().toString();
                                    Float suma = Float.parseFloat(etSuma.getText().toString());
                                    String nrCard=etNrCard.getText().toString();
                                    Date data = new Date(afiseazaData.getText().toString());
                                    int codCVV = Integer.parseInt(codCvv.getText().toString());

                                    RadioButton radioButton = findViewById(radioGroup.getCheckedRadioButtonId());
                                    String taxaImpozit = radioButton.getText().toString().toUpperCase();



                                    Plata plata = new Plata(nume, tipPersoana, taxaImpozit, detalii, suma, nrCard, data, codCVV);
                                    writePlataInFirebase(plata);
                                    intent.putExtra(ADD_PLATA, plata);
                                    setResult(RESULT_OK, intent);

                                    finish();

                                } catch (IllegalArgumentException | ParseException e) {
                                    e.printStackTrace();
                                }
                            }

            }
        });

    }

    private void writePlataInFirebase(final Plata plata)
    {
        final DatabaseReference myRef = database.getReference("proiect-android-2560b-default-rtdb");
        myRef.keepSynced(true); //sa se modifice automat daca schimb ceva in aplicatie

        myRef.child("proiect-android-2560b-default-rtdb").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

               plata.setUid(myRef.child("proiect-android-2560b-default-rtdb").push().getKey()); //creaza nod caruia ii genereaza un id
                myRef.child("Plata cu id-ul unic - " + plata.getUid()).child(plata.getUid()).setValue(plata); ///valori

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    }