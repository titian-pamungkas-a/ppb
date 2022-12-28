package com.example.fp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.rpc.context.AttributeContext;

public class MainActivity extends AppCompatActivity {

    private ImageButton bReview;
    private ImageButton bLokasi;
    private ImageButton bFood;
    private ImageButton bOrder;
    private ImageButton bLog;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bReview = (ImageButton) findViewById(R.id.bReview);
        bLokasi = (ImageButton) findViewById(R.id.bLokasi);
        bFood = (ImageButton) findViewById(R.id.bFood);
        bOrder = (ImageButton) findViewById(R.id.bDelivery);
        bLog = (ImageButton) findViewById(R.id.bLogout);
        mAuth = FirebaseAuth.getInstance();
        bReview.setOnClickListener(operasi);
        bLokasi.setOnClickListener(operasi);
        bFood.setOnClickListener(operasi);
        bOrder.setOnClickListener(operasi);
        bLog.setOnClickListener(operasi);
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser == null){
            pindahLogin();
        }

    }

    void pindahLogin(){
        Intent pLogin = new Intent(getBaseContext(), Login.class);
        startActivity(pLogin);
    }

    View.OnClickListener operasi = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.bReview: openReview(); break;
                case R.id.bLokasi: openLokasi(); break;
                case R.id.bFood: openFood(); break;
                case R.id.bDelivery: openOrder(); break;
                case R.id.bLogout: openLogout(); break;
            }
        }
    };

    void openReview(){
        Intent pindahReview = new Intent(getBaseContext(), Review.class);
        startActivityForResult(pindahReview, 0);
    }

    void openLokasi(){
        Intent pindahLokasi = new Intent(getBaseContext(), QA.class);
        startActivityForResult(pindahLokasi, 0);
    }

    void openFood(){
        Intent pindahMakanan = new Intent(getBaseContext(), ListMakanan.class);
        startActivityForResult(pindahMakanan, 0);
    }

    void openOrder(){
        Intent pindahOrder = new Intent(getBaseContext(), order.class);
        startActivityForResult(pindahOrder, 0);
    }

    void openLogout(){
        LayoutInflater li = LayoutInflater.from(this);
        View input = li.inflate(R.layout.logoutkonfirmasi, null);
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setView(input);
        dialog.setCancelable(false);
        dialog.setPositiveButton("ok", doLogout);
        dialog.setNegativeButton("batal", doLogout);
        dialog.show();
    }

    DialogInterface.OnClickListener doLogout = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            if (i==-1){
                mAuth.signOut();
                Intent pindahLogin = new Intent(getBaseContext(), Login.class);
                startActivity(pindahLogin);
            }
        }
    };

}