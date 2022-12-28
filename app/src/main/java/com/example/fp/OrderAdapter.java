package com.example.fp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderAdapter extends ArrayAdapter<OrderMakanan> {

    private int total;
    private final detailInterface detail;


    public OrderAdapter(Context context, int resource, ArrayList<OrderMakanan> listnama, detailInterface detail) {
        super(context, resource, listnama);
        this.detail = detail;


        total = 0;
        //detail = null;
    }

    public View getView(int position, View ConvertView, ViewGroup parent) {
        OrderMakanan dtkontak = getItem(position);
        if (ConvertView == null) {
            ConvertView = LayoutInflater.from(getContext()).inflate(R.layout.orderlayout, parent, false);
        }
        TextView tNama = (TextView) ConvertView.findViewById(R.id.tnamaorder);
        TextView tHarga = (TextView) ConvertView.findViewById(R.id.tharga);
        ImageButton min = (ImageButton) ConvertView.findViewById((R.id.min));
        ImageButton max = (ImageButton) ConvertView.findViewById((R.id.max));
        ImageView gambar = (ImageView) ConvertView.findViewById(R.id.tgambarorder);
        TextView jumlah = (TextView) ConvertView.findViewById(R.id.jumlahView);
        min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number = Integer.parseInt(dtkontak.getJumlah()) - 1;
                if (number<=0) number=0;

                dtkontak.setJumlah(String.valueOf(number));
                jumlah.setText(String.valueOf(number));
                //Toast.makeText(getContext(), "Harga " + number * dtkontak.getHarga(), Toast.LENGTH_SHORT).show();
                detail.Additem(dtkontak, "Kurang");
            }
        });
        max.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number = Integer.parseInt(dtkontak.getJumlah()) + 1;
                total+=number;
                dtkontak.setJumlah(String.valueOf(number));
                jumlah.setText(String.valueOf(number));
                //Toast.makeText(getContext(), "Harga " + number * dtkontak.getHarga(), Toast.LENGTH_SHORT).show();
                detail.Additem(dtkontak, "Tambah");

            }
        });
//        ConvertView.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                if (detail != null){
//                    detail.itemOnClick(position);
//                }
//            }
//        });
        //TextView tJumlah = (ImageView) ConvertView.findViewById(R.id.);
        tNama.setText(dtkontak.getNama());
        tHarga.setText(String.valueOf(dtkontak.getHarga()));
        gambar.setImageResource(dtkontak.getGambar());


        //tGambar.setImageURI(Uri.parse(dtkontak.getJumlah());
        //tGambar.setImageResource(100);



        return ConvertView;
    }



}
