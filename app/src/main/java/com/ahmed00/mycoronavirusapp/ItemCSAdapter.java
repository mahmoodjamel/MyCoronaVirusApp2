package com.ahmed00.mycoronavirusapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ItemCSAdapter extends ArrayAdapter<ItemC> {


    private Context context;
    private List<ItemC> itemCList;


    public ItemCSAdapter(@NonNull Context context, List<ItemC> itemCList) {
        super(context, R.layout.list_itemc,itemCList);
        this.context = context;
        this.itemCList = itemCList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        @SuppressLint("ViewHolder") View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_itemc,null,true);
        TextView countryName = view.findViewById(R.id.countryNameTv);
        ImageView countryImage = view.findViewById(R.id.countryImage);

        countryName.setText(itemCList.get(position).getCountry());
        Picasso.get().load(itemCList.get(position).getFlag()).into(countryImage);


        return view;
    }

    @Override
    public int getCount() {
        return itemCList.size();
    }

    @Nullable
    @Override
    public ItemC getItem(int position) {
        return itemCList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
}
