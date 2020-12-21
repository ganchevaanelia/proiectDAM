package com.example.proiectaz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

public class ProfilOperatiuniActivity extends AppCompatActivity {
    GridLayout mainGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_operatiuni);



        mainGrid=(GridLayout)findViewById(R.id.mainGrid);
        setSingleEvent(mainGrid);
    }


    private void setSingleEvent(GridLayout mainGrid)
    {
        for (int i=0; i<mainGrid.getChildCount(); i++){
            CardView cd= (CardView) mainGrid.getChildAt(i);
            final int finalI=i;
            cd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (finalI==0){
                        Intent it=new Intent(ProfilOperatiuniActivity.this, PlatiActivity.class );
                        startActivity(it);

                    }
                    else  if (finalI==1){
                        Intent it=new Intent(ProfilOperatiuniActivity.this, SesizariActivity.class );
                        startActivity(it);

                    }
                    else{
                        Toast.makeText(ProfilOperatiuniActivity.this, "Nu exista activitate pentru acest item", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }


    }

}