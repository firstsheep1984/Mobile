package com.example.a20190626spinnerrating;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button button;
    WebView webView;
    String url = "https://www.yahoo.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
    button = findViewById(R.id.button);
    button.setOnClickListener(this);
    webView= findViewById(R.id.webView);
    }

    @Override
    public void onClick(View view) {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
        //
        webView.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
        }else{
            super.onBackPressed();
        }
    }
}
