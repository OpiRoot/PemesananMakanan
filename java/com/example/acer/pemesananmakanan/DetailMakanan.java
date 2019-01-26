package com.example.acer.pemesananmakanan;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatRatingBar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class DetailMakanan extends AppCompatActivity{

    ImageView imgdetailmakanan;
    TextView txtdetailnamamakanan;
    TextView txtdetailmakanan;
    TextView txthargamakanan;

    private TextView getRating;
    private Button Vote;
    private AppCompatRatingBar RatingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_makanan);

        getRating = findViewById(R.id.rate);
        Vote = findViewById(R.id.vote);
        RatingBar = findViewById(R.id.penilaian);

        // Menambahkan Listener Pada RatingBar
        RatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float nilai, boolean fromUser) {
                // Nilai pada TextView Akan Berupa/Terupdate Saat Nilai Ratingnya Berubah
                getRating.setText("Rating: " + nilai);
            }
        });
        Vote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Menampilkan Pesan Berupa Nilai Yang Di inputkan User Pada RatingBar
                Toast.makeText(getApplicationContext(), "Nilai Yang Anda Kirimkan: " + RatingBar.getRating(), Toast.LENGTH_SHORT).show();
            }
        });

        imgdetailmakanan = (ImageView) findViewById(R.id.imgdetailmakanan);
        txtdetailnamamakanan = (TextView) findViewById(R.id.txtdetailnamamakanan);
        txtdetailmakanan = (TextView) findViewById(R.id.txtdetailmakanan);
        txthargamakanan = (TextView) findViewById(R.id.txtdetailhargamakanan);


        Intent terimadata = getIntent();

        txtdetailnamamakanan.setText(terimadata.getStringExtra("namaM"));
        txthargamakanan.setText(terimadata.getStringExtra("hargaM"));
        txtdetailmakanan.setText(terimadata.getIntExtra("detailM", 0));
        imgdetailmakanan.setImageResource(terimadata.getIntExtra("gbrM", 0));

    }
}


