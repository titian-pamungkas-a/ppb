package com.example.fp;

import android.widget.ImageButton;
import android.widget.ImageView;

public class OrderMakanan {
    private String jumlah;
    private int harga, posisi;
    private String nama;
    private ImageButton min, max;
    private int gambar;
    public OrderMakanan(String nama, int harga, String jumlah, int posisi, int gambar){
        this.nama = nama;
        this.harga = harga;
        this.jumlah = jumlah;
        this.posisi = posisi;
        this.gambar = gambar;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public ImageButton getMin() {
        return min;
    }

    public void setMin(ImageButton min) {
        this.min = min;
    }

    public ImageButton getMax() {
        return max;
    }

    public void setMax(ImageButton max) {
        this.max = max;
    }

    public int getPosisi() {
        return posisi;
    }

    public void setPosisi(int posisi) {
        this.posisi = posisi;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }
}
