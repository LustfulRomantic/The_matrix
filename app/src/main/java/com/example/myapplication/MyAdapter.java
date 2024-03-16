package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends ArrayAdapter<Item> {
    public MyAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Item> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //convertView = R.layout.myrow
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.myrow, parent, false);

        TextView tvName     = convertView.findViewById(R.id.tvName);
        TextView tvDate     = convertView.findViewById(R.id.tvDate);
        TextView tvDesc     = convertView.findViewById(R.id.tvDesc);
        TextView tvStatus   = convertView.findViewById(R.id.tvStatus);
        ImageView iv        = convertView.findViewById(R.id.iv);

        String date = getItem(position).getDate().toString().substring(0,19);

        tvName.setText(getItem(position).getName());
        tvDate.setText(date);
        tvStatus.setText(getItem(position).getStatus());
        tvDesc.setText(getItem(position).getDesc());


        return convertView;
    }
}
