package com.example.acer.pemesananmakanan.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Note implements Parcelable {
    private int id;
    private String telepon;
    private String nama;
    private String alamat;
    private String pembelian;
    private String jumlah;
    private String tanggal;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getPembelian() {
        return pembelian;
    }

    public void setPembelian(String pembelian) {
        this.pembelian = pembelian;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.telepon);
        dest.writeString(this.nama);
        dest.writeString(this.alamat);
        dest.writeString(this.pembelian);
        dest.writeString(this.jumlah);
        dest.writeString(this.tanggal);
    }

    public Note() {
    }

    protected Note(Parcel in) {
        this.id = in.readInt();
        this.telepon = in.readString();
        this.nama = in.readString();
        this.alamat = in.readString();
        this.pembelian = in.readString();
        this.jumlah = in.readString();
        this.tanggal = in.readString();
    }

    public static final Parcelable.Creator<Note>CREATOR = new Parcelable.Creator<Note>() {

        @Override
        public Note createFromParcel(Parcel source) {
            return new Note(source);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };
}
