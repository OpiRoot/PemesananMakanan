package com.example.acer.pemesananmakanan.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;

import com.example.acer.pemesananmakanan.entity.Note;

import java.util.ArrayList;

import static android.provider.MediaStore.Audio.Playlists.Members._ID;
import static com.example.acer.pemesananmakanan.db.DatabaseContract.NoteColumns.ALAMAT;
import static com.example.acer.pemesananmakanan.db.DatabaseContract.NoteColumns.TANGGAL;
import static com.example.acer.pemesananmakanan.db.DatabaseContract.NoteColumns.JUMLAH;
import static com.example.acer.pemesananmakanan.db.DatabaseContract.NoteColumns.PEMBELIAN;
import static com.example.acer.pemesananmakanan.db.DatabaseContract.NoteColumns.NAMA;
import static com.example.acer.pemesananmakanan.db.DatabaseContract.NoteColumns.TELEPON;
import static com.example.acer.pemesananmakanan.db.DatabaseContract.TABLE_NOTE;

public class NoteHelper {
    private static String DATABASE_TABLE = TABLE_NOTE;
    private Context context;
    private DatabaseHelper dataBaseHelper;

    private SQLiteDatabase database;

    public NoteHelper(Context context){
        this.context = context;
    }

    public NoteHelper open() throws SQLException {
        dataBaseHelper = new DatabaseHelper(context);
        database = dataBaseHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        dataBaseHelper.close();
    }

    public ArrayList<Note> query(){
        ArrayList<Note> arrayList = new ArrayList<Note>();
        Cursor cursor = database.query(DATABASE_TABLE,null,null,null,null,null,_ID +" DESC",null);
        cursor.moveToFirst();
        Note note;
        if (cursor.getCount()>0) {
            do {

                note = new Note();
                note.setId(cursor.getInt(cursor.getColumnIndexOrThrow(_ID)));
                note.setTelepon(cursor.getString(cursor.getColumnIndexOrThrow(TELEPON)));
                note.setNama(cursor.getString(cursor.getColumnIndexOrThrow(NAMA)));
                note.setAlamat(cursor.getString(cursor.getColumnIndexOrThrow(ALAMAT)));
                note.setPembelian(cursor.getString(cursor.getColumnIndexOrThrow(PEMBELIAN)));
                note.setJumlah(cursor.getString(cursor.getColumnIndexOrThrow(JUMLAH)));
                note.setTanggal(cursor.getString(cursor.getColumnIndexOrThrow(TANGGAL)));

                arrayList.add(note);
                cursor.moveToNext();

            } while (!cursor.isAfterLast());
        }
        cursor.close();
        return arrayList;
    }

    public long insert(Note note){
        ContentValues initialValues =  new ContentValues();
        initialValues.put(TELEPON, note.getTelepon());
        initialValues.put(NAMA, note.getNama());
        initialValues.put(ALAMAT, note.getAlamat());
        initialValues.put(PEMBELIAN, note.getPembelian());
        initialValues.put(JUMLAH, note.getJumlah());
        initialValues.put(TANGGAL, note.getTanggal());
        return database.insert(DATABASE_TABLE, null, initialValues);
    }

    public int update(Note note){
        ContentValues args = new ContentValues();
        args.put(TELEPON, note.getTelepon());
        args.put(NAMA, note.getNama());
        args.put(ALAMAT, note.getAlamat());
        args.put(PEMBELIAN, note.getPembelian());
        args.put(JUMLAH, note.getJumlah());
        args.put(TANGGAL, note.getTanggal());
        return database.update(DATABASE_TABLE, args, _ID + "= '" + note.getId() + "'", null);
    }

    public int delete(int id){
        return database.delete(TABLE_NOTE, _ID + " = '"+id+"'", null);
    }
}
