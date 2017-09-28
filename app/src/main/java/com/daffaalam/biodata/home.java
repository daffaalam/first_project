package com.daffaalam.biodata;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class home extends AppCompatActivity {

    EditText urlx;
    double nmr = 1.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView mybio = (TextView) findViewById(R.id.mybio);
        Typeface style = Typeface.createFromAsset(getAssets(), "UbuntuMono-R.ttf");
        TextView versi = (TextView) findViewById(R.id.vers);
        urlx = (EditText) findViewById(R.id.urls);

        mybio.setTypeface(style);

        versi.setText("ver " + nmr);
    }

    public void bios(View view) {
        Intent biox = new Intent(getApplicationContext(), browser.class);
        biox.putExtra("datas", "daffaalam.wordpress.com");
        startActivity(biox);
    }

    public void gits(View view) {
        Intent sdweb = new Intent(getApplicationContext(), browser.class);
        sdweb.putExtra("datas", "github.com/daffaalam");
        startActivity(sdweb);
    }

    public void browsers(View view) {

        String urlck = urlx.getText().toString();

        if (urlck.isEmpty()) {
            urlx.setError("Masukan URL yang benar!");
            urlx.requestFocus();
        } else if (!Patterns.WEB_URL.matcher(urlck).matches()) {
            urlx.setError("Masukan URL yang benar!\ncontoh : example.com");
            urlx.requestFocus();
        } else {
            Intent brws = new Intent(getApplicationContext(), browser.class);
            startActivity(brws);
            send();
        }
    }

    public void abt(View view) {
        Intent abts = new Intent(this, browser.class);
        startActivity(abts);
    }

    public void edit(View view) {
        Intent eidts = new Intent(this, edit.class);
        startActivity(eidts);
    }

    public void send() {
        Intent snd = new Intent(home.this, browser.class);
        snd.putExtra("datas", urlx.getText().toString());
        startActivity(snd);
    }
}