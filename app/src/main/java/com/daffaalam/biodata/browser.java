package com.daffaalam.biodata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class browser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);

        Intent dtx = getIntent();
        TextView wrng = (TextView)findViewById(R.id.alrt);

        final String almt = dtx.getStringExtra("datas");

        WebView brwsr = (WebView)findViewById(R.id.brwsrxml);
        WebSettings brsrset = brwsr.getSettings();
        brsrset.setJavaScriptEnabled(true);
        brwsr.setWebViewClient(new WebViewClient());

        if (almt != null){
            brwsr.loadUrl("http://" + almt);
        }
        else {
            wrng.setText("Alamat URL tidak Valid...!!!");
            Intent bck = new Intent(this, home.class);
            startActivity(bck);
        }
    }
}
