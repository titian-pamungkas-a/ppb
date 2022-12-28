package com.example.fp;

public class lauk {
    private String namaLauk, keterangan, detail;
    private int harga, gambar;
    public lauk(String namaLauk, int harga, String keterangan, int gambar, String detail){
        this.harga = harga;
        this.namaLauk = namaLauk;
        this.keterangan = keterangan;
        this.gambar = gambar;
        this.detail = detail;
    }

    public  lauk(String namaLauk, String keterangan, int gambar){
        this.namaLauk = namaLauk;
        this.keterangan = keterangan;
        this.gambar = gambar;
    }

    public String getNamaLauk() {
        return namaLauk;
    }

    public void setNamaLauk(String namaLauk) {
        this.namaLauk = namaLauk;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
