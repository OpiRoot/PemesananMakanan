package com.example.acer.pemesananmakanan.db;

import android.provider.BaseColumns;

public class DatabaseContract {

    static String TABLE_NOTE = "note";
    static final class NoteColumns implements BaseColumns {
        //Note telp
        static String TELEPON = "telepon";
        //Note nama
        static String NAMA = "nama";
        //Note alamat
        static String ALAMAT = "alamat";
        //Note pembelian
        static String PEMBELIAN = "pembelian";
        //Note jumlah
        static String JUMLAH = "jumlah";
        //Note date
        static String TANGGAL = "tanggal";
    }
}
