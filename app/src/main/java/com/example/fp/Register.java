package com.example.fp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Collection;
import java.util.Collections;

public class Register extends AppCompatActivity {

    private EditText name, user, pass, hp;
    private String snama, suser, spass, shp;
    private Button daftar;
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    private userData data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name = (EditText) findViewById(R.id.namauser);
        user = (EditText) findViewById(R.id.usernameuser);
        pass = (EditText) findViewById(R.id.passworduser);
        hp = (EditText) findViewById(R.id.nohpuser);
        daftar = (Button) findViewById(R.id.daftarButton);
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.createUserWithEmailAndPassword(user.getText().toString(), pass.getText().toString())
                        .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Log.d("User", "createUserWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    pindahMain();

                                }else {
                                    Toast.makeText(getBaseContext(), "Gagal", Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }
        });
    }

    private void pindahMain(){
        snama = name.getText().toString();
        data = new userData(name.getText().toString(), user.getText().toString(), "Lumajang", hp.getText().toString());
        db.collection("Users").document(snama).set(data);
        Intent menu = new Intent(getBaseContext(), MainActivity.class);
        startActivity(menu);
    }



//    void updateUI(FirebaseUser user){
//        
//    }
    
}