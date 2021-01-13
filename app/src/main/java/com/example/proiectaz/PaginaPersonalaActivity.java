package com.example.proiectaz;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class PaginaPersonalaActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {
    private DrawerLayout drawer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meniu_login);


        Toolbar toolbar2 = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar2);

        drawer2 = findViewById(R.id.drawer_layout2);
        NavigationView navigationView2 = findViewById(R.id.nav_view2);
        navigationView2.setNavigationItemSelectedListener(this);
        navigationView2.setItemIconTintList(null); //se coloreaza icoanele


        ActionBarDrawerToggle toggle2 = new ActionBarDrawerToggle
                (this, drawer2, toolbar2, R.string.navigation_drawer_open2, R.string.navigation_drawer_close2);
        drawer2.addDrawerListener(toggle2);
        toggle2.syncState();

        BottomNavigationView btnNavView=findViewById(R.id.bottom_navigation);
        btnNavView.setSelectedItemId(R.id.drawer_layout);

        btnNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.activ_plati:
                        startActivity(new Intent(getApplicationContext(), PlatiActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                    case R.id.drawer_layout:
                        return true;

                    case R.id.activ_sesizari:
                        startActivity(new Intent(getApplicationContext(), SesizariActivity.class));
                        overridePendingTransition(0, 0);
                        return true;


                }
                return false;
            }
        });

    }

    public void openProfilOperatiuni() {
        Intent intent = new Intent(this, ProfilOperatiuniActivity.class);
        startActivity(intent);
    }

    public void openNews(){
        Intent it=new Intent(this, AnunturiActivity.class);
        startActivity(it);
    }
    public void openMainActivity(){
        Intent it=new Intent(getApplicationContext(), MainActivity.class);
        startActivity(it);
    }

    public void openInfo(){
        Intent it=new Intent(this, Informatii.class);
        startActivity(it);
    }




    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_profil:
                openProfilOperatiuni();
                break;
            case R.id.nav_news:
                openNews();
                break;
            case R.id.nav_info:
                openInfo();

                break;
            case R.id.nav_deconectare:
                openMainActivity();

        }
        drawer2.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() { //daca meniul e deschis si apasam back il deschide, daca e inchis iese din app
        if (drawer2.isDrawerOpen(GravityCompat.START)) {
            drawer2.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}

