package com.example.proiectaz;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ParsareJSON  extends AsyncTask< String,Void, List<Double>> {

    @Override
    protected List<Double> doInBackground(String... strings) {

        List<Double> lista= new ArrayList<>();
        try {
            URL url=new URL(strings[0]);
            HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
            InputStream inputStream=httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            String linie="";
            StringBuilder builder=new StringBuilder();

            while ((linie=bufferedReader.readLine())!=null)
            {
                builder.append(linie);
            }

            String textFull=builder.toString();
            JSONObject jsonObject=new JSONObject(textFull);
            JSONArray colectie=jsonObject.getJSONArray("DailyForecasts");
            JSONObject primulObiect=colectie.getJSONObject(0);
            JSONObject temperatura=primulObiect.getJSONObject("Temperature");
            JSONObject minimum=temperatura.getJSONObject("Minimum");
            JSONObject maximum=temperatura.getJSONObject("Maximum");
            double minim=minimum.getDouble("Value");
            double maxim=maximum.getDouble("Value");
            lista.add(minim);lista.add(maxim);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
