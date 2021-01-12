package com.example.proiectaz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Informatii extends AppCompatActivity {

    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informatii);
    }

    public void loadInfo(View view) throws IOException {
        Resources res= getResources();

        InputStream is= this.getAssets().open("iasi.json");
        Scanner scanner=new Scanner(is);
        StringBuilder builder=new StringBuilder();
        while(scanner.hasNextLine())
        {
            builder.append(scanner.nextLine());
        }
        parseJson(builder.toString());

    }

    private void parseJson(String s) {
        TextView tv=findViewById(R.id.tvInfo);
        StringBuilder builder=new StringBuilder();
        try {
            JSONObject root = new JSONObject(s);
            JSONObject info=root.getJSONObject("Informatii");
            builder.append("Judet: ").append(info.getString("judet")).append("\n\n");


            JSONArray orase=info.getJSONArray("orase");
            JSONObject coordonate=orase.getJSONObject(1);
            for(int i =0; i<orase.length(); i++){
                JSONObject oras= orase.getJSONObject(i);
                JSONObject lat= coordonate.getJSONObject("coordonate");
                JSONObject lng= coordonate.getJSONObject("coordonate");

                builder.append("City: ").append(oras.getString("city")).append("\n")
                        .append("Lat: ").append(lat.getString("lat")).append("\n")
                        .append("Lng: ").append(lng.getString("lng")).append("\n")
                        .append("Country: ").append(oras.getString("country")).append("\n")
                        .append("Capital: ").append(oras.getString("capital")).append("\n")
                        .append("Population: ").append(oras.getString("population")).append("\n")
                        .append("\n");
            }

        }catch(JSONException e){
            e.printStackTrace();
        }

        tv.setText(builder.toString());


    }
}


