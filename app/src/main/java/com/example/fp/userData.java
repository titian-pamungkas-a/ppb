package com.example.fp;

public class userData {
    private String nama;
    private String email;
    private String alamat;
    private String noHP;
    public userData(){

    }
    public userData(String nama, String email, String alamat, String noHP){
        this.nama = nama;
        this.email = email;
        this.alamat = alamat;
        this.noHP = noHP;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoHP() {
        return noHP;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }
}
