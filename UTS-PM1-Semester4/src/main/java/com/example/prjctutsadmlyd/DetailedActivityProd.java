package com.example.prjctutsadmlyd;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.prjctutsadmlyd.databinding.ActivityDetailedProdBinding;

public class DetailedActivityProd extends AppCompatActivity {

    ActivityDetailedProdBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailedProdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = this.getIntent();
        if (intent != null){
            String name = intent.getStringExtra("name");
            int komposisi = intent.getIntExtra("komposisi", R.string.tjiwikomp);
            int desc = intent.getIntExtra("desc", R.string.tjiwiDesc);
            binding.detailName.setText(name);
            binding.detailKomp.setText(komposisi);
            binding.detailDesc.setText(desc);
        }
    }
}