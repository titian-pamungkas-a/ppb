package com.example.fp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Review extends AppCompatActivity {

    private Button bKembali;
    private Button bKirim;
    private EditText tulisReview;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        db = FirebaseFirestore.getInstance();

        bKembali = (Button) findViewById(R.id.kembali);
        bKirim = (Button) findViewById(R.id.kirimReview);
        tulisReview = (EditText) findViewById(R.id.fillReview);
        bKembali.setOnClickListener(op);
        bKirim.setOnClickListener(op);
    }

    View.OnClickListener op = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.kembali:finish();break;
                case R.id.kirimReview:
                    if(tulisReview.getText().toString().matches("")){
                        Toast.makeText(getBaseContext(), "Masukkan data", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Map<String, Object> user = new HashMap<>();
                        String teks = tulisReview.getText().toString();
                        user.put("review", teks);
//                        user.put("na", 123);
//                        user.put("nam", "asda");
                        Toast.makeText(getBaseContext(), "Terima kasih atas feedback anda.", Toast.LENGTH_LONG).show();
                        db.collection("users").add(user).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Log.d("menu", "berhasil");
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.d("menu", "gagal");
                            }
                        });
                    }
                    break;
            }
        }
    };
}