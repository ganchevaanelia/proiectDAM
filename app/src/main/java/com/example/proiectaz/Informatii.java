package com.example.proiectaz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class Informatii extends AppCompatActivity {

    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informatii);

        listview=findViewById(R.id.listview);
        try{
            JSONObject obj=new JSONObject(LoadJsonFromAsset());
            JSONArray array=obj.getJSONArray("Detalii");
            HashMap<String,String> list;
            ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();
            for( int i=0;i<array.length();i++){
                JSONObject o=array.getJSONObject(i);
                String city_j=o.getString("city");
                String lat_j=o.getString("lat");
                String lng_j=o.getString("lng");
                String country_j=o.getString("country");
                String iso_j=o.getString("iso2");
                String adminName_j=o.getString("admin_name");
                String capital_j=o.getString("capital");
                String population_j=o.getString("population");
                String populationProper_j=o.getString("population_proper");
                list=new HashMap<>();
                list.put("city",city_j);
                list.put("lat",lat_j);
                list.put("lng",lng_j);
                list.put("country",country_j);
                list.put("iso2",iso_j);
                list.put("admin_name",adminName_j);
                list.put("capital",capital_j);
                list.put("population",population_j);
                list.put("population_proper",populationProper_j);

                arrayList.add(list);
            }

            ListAdapter adapter=new SimpleAdapter(this,arrayList,R.layout.item_listviewinfo,new String[]{"city","lat", "lng","country", "iso2", "admin_name", "capital", "population", "population_proper"},new int[]{R.id.tvcity,R.id.tvLat, R.id.tvLng, R.id.tvCountry, R.id.tvISO2, R.id.tvAdminName, R.id.tvCapital, R.id.tvPopulation, R.id.tvPopulationproper});
            listview.setAdapter(adapter);
        }catch (JSONException e){
            e.printStackTrace();
        }

    }
    public String LoadJsonFromAsset(){
        String json=null;
        try{
            InputStream in=this.getAssets().open("iasi.json");
            int size=in.available();
            byte[] bbuffer=new byte[size];
            in.read(bbuffer);
            in.close();
            json=new String(bbuffer,"UTF-8");

        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
        return json;
    }
}