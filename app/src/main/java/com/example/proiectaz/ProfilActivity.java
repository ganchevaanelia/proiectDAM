package com.example.proiectaz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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



Button loginOk=findViewById(R.id.loginOk);
        loginOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validationSuccess()) {

                    startActivity(new Intent(getApplicationContext(), PaginaPersonalaActivity.class));

                }
                else{
                     AlertDialog();
                }
            }
        });




        login = findViewById(R.id.btnCreareCont);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });
    }
    private Boolean validationSuccess(){
        if(et1.getText().toString().isEmpty()) {
            et1.setError("Introduceti numele de utilizator");
            return false;
        }
        if(et1.length()<4) {
            et1.setError("Numele de utilizator trebuie sa aiba cel putin 4 caractere");
            return false;
        }

        if(et2.getText().toString().isEmpty()) {
            et2.setError("Introduceti parola");
            return false;
        }
        return true;
    }

    private void AlertDialog()
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ProfilActivity.this);
        alertDialogBuilder.setMessage("Autentificare nereusita").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                dialog.cancel();
            }
        });

        AlertDialog alert = alertDialogBuilder.create();
        alert.show();

    }

}