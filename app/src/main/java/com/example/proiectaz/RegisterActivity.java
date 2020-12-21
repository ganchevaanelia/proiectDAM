package com.example.proiectaz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    Button btn3;
    EditText editText1;
    EditText editText2;
    String username;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btn3=findViewById(R.id.btnRegister);
        editText1=findViewById(R.id.etUsernameRegister);
        editText2=findViewById(R.id.etPasswordRegister);


        btn3.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       Intent it=new Intent(RegisterActivity.this, ProfilActivity.class);
                                       username=editText1.getText().toString();
                                       password=editText2.getText().toString();
                                       it.putExtra("user", username);
                                       it.putExtra("password", password);
                                       startActivity(it);
                                       finish();

                                   }
        });
    }

}
