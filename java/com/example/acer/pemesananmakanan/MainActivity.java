package com.example.acer.pemesananmakanan;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.BaseBundle;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toolbar;

import com.example.acer.pemesananmakanan.Adapter.CustomListAdapter;

public class MainActivity extends AppCompatActivity{

    //declarasi Variable
    ImageButton call;
    Button order, map;
    ListView listmakanan;

    //membuat Array
    String nama_makanan[] = {"Ayam Bakar", "Bakso", "Gado-Gado", "Ikan Bakar", "Kepiting Bakar", "Mie Aceh", "Opor Ayam", "Rendang", "Sate", "Soto", "Udang Asam Manis"};

    String harga_makanan[] = {"Rp. 25.000", "Rp. 10.000", "15.000", "Rp. 30.000", "Rp. 40.000", "Rp. 15.000", "Rp. 18.000", "Rp. 35.000", "Rp. 20.000", "Rp. 15.000", "Rp. 17.000"};

    int gambar_makanan[] = {R.drawable.ayambakar, R.drawable.bakso, R.drawable.gadogado, R.drawable.ikanbakar, R.drawable.kepitingbakar, R.drawable.mieaceh, R.drawable.oporayam, R.drawable.rendang, R.drawable.sate, R.drawable.soto, R.drawable.udangasammanis};

    int detail_makanan[] = {R.string.ayambakar, R.string.bakso, R.string.gadogado, R.string.ikanbakar, R.string.kepitingbakar, R.string.mieaceh, R.string.oporayam, R.string.rendang, R.string.sate, R.string.soto, R.string.udangasammanis};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button order = (Button) findViewById(R.id.order);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent orderIntent = new Intent(MainActivity.this, Order.class);
                startActivity(orderIntent);
            }
        });

        call = (ImageButton) findViewById(R.id.call);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:089689696474"));
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    String toDial = "tel:089689696474";

                    startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(toDial)));
                }
            }
        });
        map = (Button) findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double latitude = -8.1761024;
                double longitude = 113.7216313;
                String label = "Location";
                String uriBegin = "geo:" + latitude + "," + longitude;
                String query = latitude + "," + longitude + "(" + label + ")";
                String encodedQuery = Uri.encode(query);
                String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
                Uri uri = Uri.parse(uriString);
                Intent mapIntent = new Intent(android.content.Intent.ACTION_VIEW, uri);
                startActivity(mapIntent);
            }
        });

        //inisialisasi
        listmakanan = (ListView) findViewById(R.id.listmakanan);

        CustomListAdapter adapter = new CustomListAdapter(this, nama_makanan, gambar_makanan, harga_makanan);

        //untuk mengisi data ke widget list view
        listmakanan.setAdapter(adapter);

        //aksi atau event listener dari widget list view

        listmakanan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent kirimdata = new Intent(MainActivity.this, DetailMakanan.class);
                kirimdata.putExtra("gbrM", gambar_makanan[i]);
                kirimdata.putExtra("namaM", nama_makanan[i]);
                kirimdata.putExtra("hargaM", harga_makanan[i]);
                kirimdata.putExtra("detailM", detail_makanan[i]);

                startActivity(kirimdata);
            }
        });
    }
}
