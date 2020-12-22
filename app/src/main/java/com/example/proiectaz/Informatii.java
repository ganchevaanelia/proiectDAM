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

//        listview=findViewById(R.id.listview);
//        try{
//            JSONObject obj=new JSONObject("Informatii");
//            JSONArray array=obj.getJSONArray("orase");
//            HashMap<String,String> list;
//            ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();
//            for( int i=0;i<array.length();i++){
//                JSONObject primulObiect=array.getJSONObject(0);
//                String city_j=primulObiect.getString("city");
//
//                JSONObject alDoileaObiect=array.getJSONObject(1);
//                String lat_j=alDoileaObiect.getString("lat");
//                String lng_j=alDoileaObiect.getString("lng");
//
//                String country_j=primulObiect.getString("country");
//
//                String capital_j=primulObiect.getString("capital");
//                String population_j=primulObiect.getString("population");
//
//                list=new HashMap<>();
//                list.put("city",city_j);
//                list.put("lat",lat_j);
//                list.put("lng",lng_j);
//                list.put("country",country_j);
//
//                list.put("capital",capital_j);
//                list.put("population",population_j);
//
//
//                arrayList.add(list);
//            }
//
//            ListAdapter adapter=new SimpleAdapter(this,arrayList,R.layout.item_listviewinfo,new String[]{"city","lat", "lng","country",  "capital", "population"},new int[]{R.id.tvcity,R.id.tvLat, R.id.tvLng, R.id.tvCountry,  R.id.tvCapital, R.id.tvPopulation});
//            listview.setAdapter(adapter);
//        }catch (JSONException e){
//            e.printStackTrace();
//        }

    }
//    public String LoadJsonFromAsset(){
//        String json=null;
//        try{
//            InputStream in=this.getAssets().open("iasi.json");
//            int size=in.available();
//            byte[] bbuffer=new byte[size];
//            in.read(bbuffer);
//            in.close();
//            json=new String(bbuffer,"UTF-8");
//
//        }catch (IOException e){
//            e.printStackTrace();
//            return null;
//        }
//        return json;
//    }

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
            //builder.append("Oras: ").append(info.getString("orase")).append("\n");
            //builder.append("Coordonate").append(info.getString("coordonate")).append("\n");

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


