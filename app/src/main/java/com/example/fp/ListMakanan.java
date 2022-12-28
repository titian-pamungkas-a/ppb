package com.example.fp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ListMakanan extends AppCompatActivity implements listInterface{

    private ListView lv;
    private ArrayAdapter<String> kontak;
    private makananAdapter mAdapter;
    private EditText inputnama, inputnohp;
    private FloatingActionButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_makanan);
        //back = (FloatingActionButton) findViewById(R.id.back);
        //back.setOnClickListener(op);
        lv = (ListView) findViewById(R.id.list);

        ArrayList<lauk> listnama = new ArrayList<lauk>();
        mAdapter = new makananAdapter(this, 0, listnama, this);

        lv.setAdapter(mAdapter);
        addKontak("Rendang", 20000, "Nikmati rendang dari daging sapi pilihan", R.drawable.rendang1,
                "Rendang adalah makanan khas dari Sumatera barat yang menggunakan daging sapi sebagai bahan dasar. Rendang yang kami buat menggunakan daging sapi pilihan dan dimasak tanpa menggunakan minyak dalam waktu yang lama, sehingga daging yang dihasilkan beraroma sedap dan tekstur yang lembut.");
        addKontak("Ayam Kare", 18000, "Ayam kare dengan bumbu turun temurun siap membuat anda ketagihan", R.drawable.ayamkare,
                "Ayam kare adalah pasangan terbaik untuk menikmati nasi padang. Rempah yang digunakan merupakan resep turun temurun sehingga racikannya tidak perlu diragukan. Ayam yang digunakan merupakan ayam pedaging berkualitas tinggi sehingga memberikan daging yang lembut.");
        addKontak("Perkedel", 15000, "Isi perutmu dengan olahan kentang yang lembut", R.drawable.bedel,
                "Perkedel adalah lauk yang menggunakan sebagai kentang sebagai bahan dasar. Kentang yang kami gunakan merupakan kentang terbaik yang diproduksi oleh kebun yang terpercaya. Kentang memiliki banyak mafaat seperti membuat kenyang.");
        addKontak("Telur dadar", 15000, "Lengkali gizimu dengan telur yang berkualitas", R.drawable.endog,
                "Telur Dadar yang dibuat menggunakan berbagai bumbu tambahan cocok dikonsumsi sebagai tambahan. Dengan bawang dan campuran cabai terpilih membuat telur yang dibuat memiliki rasa yang bervariasi.");
        addKontak("Ikan Balado", 24000, "Kelezatan ikan yang segar dengan bumbu Balado ayng menggoda", R.drawable.ikan,
                "Ikan Balado menggunakan Ikan tenggiri yang dibudidayakan secara alami dan dipanen dengan cara yang tepat sehingga didapat ikan yang segar. Dibumbui dengan bumbu balado hasil dari turun temurun, siap untuk menemani anda untuk menikmati nasi padang.");



    }

//    View.OnClickListener op = new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            switch (view.getId()){
//                case R.id.back:finish();break;
//            }
//        }
//    };

    public void addKontak(String nama, int i, String ket, int gambar, String asd){
        lauk baru = new lauk(nama, i, ket, gambar, asd);
        mAdapter.add(baru);
    }

    @Override
    public void tampilkanDetail(lauk p) {
        Intent newintent = new Intent(getBaseContext(), ingfoActivity.class);
        newintent.putExtra("name", p.getNamaLauk());
        newintent.putExtra("gambar", p.getGambar());
        newintent.putExtra("harga", p.getHarga());
        newintent.putExtra("deskripsi", p.getDetail());
        startActivity(newintent);
    }
}