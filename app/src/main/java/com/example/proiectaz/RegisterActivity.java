package com.example.proiectaz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static com.example.proiectaz.Gen.MASCULIN;

public class RegisterActivity extends AppCompatActivity {

    Button btn3;
    EditText etUsername;
    EditText etPassword;
    EditText etPrenume;
    EditText etNume;
    EditText etEmail;
    EditText etTelefon;

    String username;
    String password;
    RadioGroup  gen;

    public static UtilizatorDB userDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userDB = Room.databaseBuilder(RegisterActivity.this, UtilizatorDB.class, "UtilizatorDB").allowMainThreadQueries().fallbackToDestructiveMigration().build();

        btn3=findViewById(R.id.btnRegister);
        etUsername=findViewById(R.id.etUsernameRegister);
        etPassword=findViewById(R.id.etPasswordRegister);
        etPrenume=findViewById(R.id.etFirstNameRegister);
        etNume=findViewById(R.id.etLastNameRegister);
        etEmail=findViewById(R.id.etEmailRegister);
        etTelefon=findViewById(R.id.etTelefonRegister);
        gen=findViewById(R.id.radioGroup2);

        btn3.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {

                                       if (validationSuccess()) {

                                           Utilizator user = new Utilizator();
                                           user.setNume(etNume.getText().toString());
                                           user.setPrenume(etPrenume.getText().toString());
                                           user.setUsername(etUsername.getText().toString());
                                           user.setPassword(etPassword.getText().toString());
                                           user.setEmail(etEmail.getText().toString());
                                           user.setTelefon(etTelefon.getText().toString());

//                                           try {
//                                               user.setGen(Gen.valueOf(gen.toString().toUpperCase()));
//                                           } catch(Exception ex) {
//                                               ex.printStackTrace();
//                                           }

                                          RadioButton radioButton = findViewById(gen.getCheckedRadioButtonId());
                                          String genPers=radioButton.getText().toString().toUpperCase();
                                          user.setGenPersoana(genPers);

                                           userDB.getUtilizatorDao().insertUtilizator(user);

                                           Intent it=new Intent(getApplicationContext(), ProfilActivity.class);
                                           username=etUsername.getText().toString();
                                           password=etPassword.getText().toString();
                                           it.putExtra("user", username);
                                           it.putExtra("password", password);
                                           startActivity(it);
                                           finish();

                                       }
                                       else{
                                           AlertDialog();
                                       }

                                   }
        });
    }
    private Boolean validationSuccess(){
        final String EmailInput=etEmail.getText().toString().trim();
        final String PhoneInput=etTelefon.getText().toString().trim();
        if(etPrenume.getText().toString().isEmpty()){
            etPrenume.setError("Introduceti prenumele !");
            return false;
        }
        if(etPrenume.length()<4) {
            etPrenume.setError("Prenumele trebuie sa aiba cel putin 4 caractere");
            return false;
        }

        if(etNume.getText().toString().isEmpty()) {
            etNume.setError("Introduceti numele !");
            return false;
        }
        if(etNume.length()<4) {
            etNume.setError("Numele trebuie sa aiba cel putin 4 caractere");
            return false;
        }
        if(etUsername.getText().toString().isEmpty()){
            etUsername.setError("Introduceti un nume de utilizator !");
            return false;
        }
        if(etUsername.length()<4){
            etUsername.setError("Numele de utilizator trebuie sa aiba cel putin 4 caractere");;
            return false;
        }
        if(etEmail.getText().toString().isEmpty()){
            etEmail.setError("Introduceti email-ul dumneavoastra!");
        }
        if(!EmailInput.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")){
            etEmail.setError("Email invalid");
            return false;
        }
        if(etTelefon.getText().toString().isEmpty()){
            etTelefon.setError("Introduceti numarul dumneavoastra de telefon!");
        }

        if(!PhoneInput.matches("^[0-9]$") && etTelefon.length()>10){
            etTelefon.setError("Numar de telefon invalid");
            return false;
        }

//        if(gen.getCheckedRadioButtonId()==-1){
//            Toast.makeText(getApplicationContext(), "Selectati genul!", Toast.LENGTH_LONG).show();
//            return false;
//        }




        return true;
    }

    private void AlertDialog()
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(RegisterActivity.this);
        alertDialogBuilder.setMessage("Inregistrare nereusita").setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener()
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
