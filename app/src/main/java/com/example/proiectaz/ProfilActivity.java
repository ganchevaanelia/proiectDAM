package com.example.proiectaz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ProfilActivity extends AppCompatActivity
{

    EditText et1;
    EditText et2;
    String username;
    String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button login = findViewById(R.id.btnCreareCont);
        et1=findViewById(R.id.etUsername);
        et2=findViewById(R.id.etPassword);
        username= getIntent().getStringExtra("user"); //se extrage textul din edittexturile din register
        password=getIntent().getStringExtra("password");
        et1.setText(username);
        et2.setText(password);




        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), PaginaPersonalaActivity.class));

            }
        });

        login = findViewById(R.id.btnCreareCont);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent it = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });
    }


}