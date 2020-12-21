package com.example.proiectaz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meniu_simplu);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null); //se coloreaza icoanele

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle
                (this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState(); //se roteste putin hamburger meniu-ul


        ParsareJSON parser = new ParsareJSON(){
            @Override
            protected void onPostExecute(List<Double> doubles) {
                TextView textView=findViewById(R.id.tvTemp);
                StringBuilder builder = new StringBuilder();
                builder.append("Temperatura minima: ").append(doubles.get(0)).append(", maxima: ").
                        append(doubles.get(1));
                textView.setText(builder.toString());
            }
        };

        parser.execute("http://dataservice.accuweather.com/forecasts/v1/daily/1day/287994?apikey=cS1Aj5oNy3uhp74BjKyVcwQOnDgGNlPA&metric=true");
    }

   public void openActivityProfil() {
      Intent intent = new Intent(this, ProfilActivity.class);
      startActivity(intent);
   }


    public void openNews(){
        Intent it=new Intent(this, AnunturiActivity.class);
        startActivity(it);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_profil:
                openActivityProfil();
                break;
            case R.id.nav_news:
//                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container2,
//                        new NewsFragment()).commit();
                openNews();
                break;
            case R.id.nav_info:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new InfoFragment()).commit();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
        public void onBackPressed() { //daca meniul e deschis si apasam back il deschide, daca e inchis iese din app
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }


    }
