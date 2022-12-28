package com.example.fp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class order extends AppCompatActivity implements detailInterface{

    private ListView lv;
    private ArrayAdapter<String> kontak;
    private OrderAdapter oAdapter;
    private EditText inputnama, inputnohp;
    private ImageButton min, max;
    private int total;
    private TextView totalview;
    private Button beli;
    private ArrayList<OrderMakanan> listnama;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        total = 0;
        lv = (ListView) findViewById(R.id.listOrder);
        totalview = (TextView) findViewById(R.id.total);
        beli = (Button) findViewById(R.id.beli);


        listnama = new ArrayList<OrderMakanan>();
        oAdapter = new OrderAdapter(this, 0, listnama, this);
        lv.setAdapter(oAdapter);
        addKontak("Rendang", 20000, "0", 0, R.drawable.rendang1);
        addKontak("Ayam Kare", 18000, "0", 1, R.drawable.ayamkare);
        addKontak("Perkedel", 15000, "0", 2, R.drawable.bedel);
        addKontak("Telur Dadar", 15000, "0", 3, R.drawable.endog);
        addKontak("Ikan Balado", 24000, "0", 4, R.drawable.ikan);




        beli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (totalview.getText() == "Rp0"){
                    Toast.makeText(getBaseContext(), "Pilih makanan anda untuk dipesan", Toast.LENGTH_LONG).show();
                }
                else {
                    openMap();
                }
            }
        });


    }

    void openMap(){
        Intent pindahMap = new Intent(getBaseContext(), lokasiTerdekat.class);
        startActivityForResult(pindahMap, 0);
    }



    public void addKontak(String nama, int harga, String jumlah, int posisi, int gambar){
        OrderMakanan baru = new OrderMakanan(nama, harga, jumlah, posisi, gambar);
        oAdapter.add(baru);
    }

    @Override
    public void itemOnClick(int position) {

    }

    @Override
    public void Additem(OrderMakanan position, String pos){
        int val=0, total=0;
        while (listnama.size() > val){
            OrderMakanan mak1 = listnama.get(val);
            total += (Integer.parseInt(mak1.getJumlah()) * mak1.getHarga());
            val++;
        }
        totalview.setText("Rp"+total);

    }
}