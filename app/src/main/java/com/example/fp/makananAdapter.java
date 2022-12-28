package com.example.fp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class makananAdapter extends ArrayAdapter<lauk> {

    private final listInterface inter;

    public makananAdapter(Context context, int resource, ArrayList<lauk> listnama, listInterface inter) {
        super(context, resource, listnama);
        this.inter = inter;
    }

    public View getView(int position, View ConvertView, ViewGroup parent) {
        lauk dtkontak = getItem(position);
        if (ConvertView == null) {
            ConvertView = LayoutInflater.from(getContext()).inflate(R.layout.makananlayout, parent, false);
        }
        TextView tNama = (TextView) ConvertView.findViewById(R.id.tnama);
        TextView tDes = (TextView) ConvertView.findViewById(R.id.tdeskripsi);
        ImageView tGambar = (ImageView) ConvertView.findViewById(R.id.tgambar);
        tNama.setText(dtkontak.getNamaLauk());
        tDes.setText(dtkontak.getKeterangan());
        tGambar.setImageResource(dtkontak.getGambar());
        ConvertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inter.tampilkanDetail(dtkontak);
            }
        });
        //tGambar.setImageResource(100);

        return ConvertView;
    }
}
