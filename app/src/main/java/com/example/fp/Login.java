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

public class Login extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Button login;
    private EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        login = (Button) findViewById(R.id.loginButton);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signInWithEmailAndPassword(username .getText().toString().trim(), password.getText().toString().trim())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    PindahMenu();
                                }else{
                                    Log.w("Gagal Login ", "signInWithEmail:failure", task.getException());
                                    Toast.makeText(getBaseContext(), "Email atau password yang anda masukkan salah", Toast.LENGTH_LONG).show();
//                                    Toast.makeText(getBaseContext(), username.getText().toString(), Toast.LENGTH_LONG).show();
//                                    Toast.makeText(getBaseContext(), password.getText().toString(), Toast.LENGTH_LONG).show();
                                }
                            }
                        });

            }
        });
    }

    public void PindahMenu(){
        Intent pindahMenu = new Intent(getBaseContext(), MainActivity.class);
        startActivity(pindahMenu);
    }

    public void PindahRegister(View view) {
        Intent pindahReg = new Intent(getBaseContext(), Register.class);
        startActivity(pindahReg);
    }
}