package com.example.fp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ingfoActivity extends AppCompatActivity {

    private TextView judul, harga, deskripsi;
    private ImageView gambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingfo);
        judul = (TextView) findViewById(R.id.JudulText);
        harga = (TextView) findViewById(R.id.HargaText);
        deskripsi = (TextView) findViewById(R.id.DeskripsiText);
        gambar = (ImageView) findViewById(R.id.JudulGambar);
        judul.setText(getIntent().getStringExtra("name"));
        harga.setText("Harga : Rp" + String.valueOf(getIntent().getIntExtra("harga", 0)) );
        deskripsi.setText(getIntent().getStringExtra("deskripsi"));
        int gambarsrc = getIntent().getIntExtra("gambar", 0);
        gambar.setImageResource(gambarsrc);
    }
}