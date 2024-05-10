package com.example.prjctutsadmlyd;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prjctutsadmlyd.databinding.ActivityNewsPortalDashboardBinding;

import java.util.ArrayList;

public class NewsPortalDashboard extends AppCompatActivity {
    private TextView textViewUsername;

    //event log
    private static final String TAG = "NewsPortasDashboardActivity";

    ActivityNewsPortalDashboardBinding binding;
    ChemicalProductAdapter listAdapter;
    ArrayList<ChemicalProductList> dataArrayList = new ArrayList<>();
    ChemicalProductList listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_portal_dashboard);
        binding = ActivityNewsPortalDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        textViewUsername = findViewById(R.id.txtUsername);

//Menampikan username di kanan atas
        Intent intent = getIntent();
        if (intent.hasExtra("username")) {
            String username = intent.getStringExtra("username");
            textViewUsername.setText("User : " + username);
        } else {
            // Jika tidak ada data username, tampilkan pesan kesalahan
            Toast.makeText(this, "Username not found", Toast.LENGTH_SHORT).show();
        }

//menampilkan data yang diambil dari string.xml,dan dimasukan juga di DetailedActivityProd
//        Komposisi produk
        int[] komposisi = {R.string.tjiwikomp, R.string.karbonKomp, R.string.poliKomp, R.string.klorinKomp, R.string.zeolitKomp, R.string.aluKomp, R.string.ozonKomp};
//        deskripsi produk yang lebih ke kegunaannya
        int[] desc = {R.string.tjiwiDesc, R.string.karbonDesc, R.string.poliDesc, R.string.klorinDesc, R.string.zeolitDesc, R.string.aluDesc, R.string.ozonDesc};
//        Nama produk
        String[] nameList = {"Tjiwi 15kg", "Karbon Aktif", "Polielektrolit", "Klorin", "Zeolit", "Aluminium Sulfat (Alum)", "Ozon"};
        //        Harga produk
        String[] hargaList = {"Rp.300.000", "Rp.300.000", "Rp.300.000", "Rp.300.000", "Rp.300.000", "Rp.300.000", "Rp.300.000"};

//menambahkan data
        for (int i = 0; i < nameList.length; i++) {
            listData = new ChemicalProductList(nameList[i], hargaList[i], komposisi[i], desc[i]);
            dataArrayList.add(listData);
        }
        listAdapter = new ChemicalProductAdapter(NewsPortalDashboard.this, dataArrayList);
        binding.productListView.setAdapter(listAdapter);
        binding.productListView.setClickable(true);

        binding.productListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(NewsPortalDashboard.this, DetailedActivityProd.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("harga", hargaList[i]);
                intent.putExtra("komposisi", komposisi[i]);
                intent.putExtra("desc", desc[i]);
                startActivity(intent);

                //event log
                Log.d(TAG, "Melihat detail produk");
            }
        });

    }
}





