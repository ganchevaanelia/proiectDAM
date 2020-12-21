package com.example.proiectaz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class AdaugaPlataActivity extends AppCompatActivity {

    private static final String TAG = "AdaugaPlata";


    private TextView afiseazaData;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    ProgressDialog progressDialog;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adauga_plata);
        button=findViewById(R.id.btnPlateste);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog=new ProgressDialog(AdaugaPlataActivity.this);

                progressDialog.show();
                progressDialog.setContentView(R.layout.progress_dialog);
                progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                Thread timer=new Thread(){
                    @Override
                    public void run() {
                        try {
                            sleep(3500);
                            Intent it=new Intent(getApplicationContext(), PlatiActivity.class);
                            startActivity(it);
                            progressDialog.dismiss();
                            finish();
                            super.run();


                        }
                        catch (InterruptedException e){
                            e.printStackTrace();
                        }

                    }
                };
                timer.start();
            }
        });


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
                //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));

                dialog.show();
            }

        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                afiseazaData.setText(date);
            }


        };
    }
}