package com.example.prjctutsadmlyd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ChemicalProductAdapter extends ArrayAdapter<ChemicalProductList> {

    public ChemicalProductAdapter(@NonNull Context context, ArrayList<ChemicalProductList> products) {
        super(context, R.layout.list_item_product, products);
    }
//adpter produk agar tampilam lebih clean dan tertata,produk akan ditampikan per cardview
    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        ChemicalProductList listData = getItem(position);
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_item_product, parent, false);
        }
        TextView listName = view.findViewById(R.id.listName);
        TextView listHarga = view.findViewById(R.id.listHarga);
        listName.setText(listData.name);
        listHarga.setText(listData.harga);
        return view;
    }
}

