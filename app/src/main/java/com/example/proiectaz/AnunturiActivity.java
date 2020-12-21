package com.example.proiectaz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AnunturiActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anunturi);

        webView=(WebView)findViewById(R.id.webViewActivity);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://www.primaria-iasi.ro/portal-iasi/anunturi-pmi/");
    }
}