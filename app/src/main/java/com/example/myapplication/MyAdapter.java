package com.example.myapplication;

import android.content.Context;
import android.util.Log;
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

        View viewHolder;
        //convertView = R.layout.myrow
        if (convertView ==null) {
            viewHolder = LayoutInflater.from(getContext()).inflate(R.layout.myrow, parent, false);
        }
        else {
            viewHolder = convertView;
        }

        TextView tvName     = viewHolder.findViewById(R.id.tvName);
        TextView tvDate     = viewHolder.findViewById(R.id.tvDate);
        TextView tvDesc     = viewHolder.findViewById(R.id.tvDesc);
        TextView tvStatus   = viewHolder.findViewById(R.id.tvStatus);
        ImageView iv        = viewHolder.findViewById(R.id.iv);

        viewHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Maksim","I clicked on row " + position);
            }
        });

        String date = getItem(position).getDate().toString().substring(0,19);

        tvName.setText(getItem(position).getName());
        tvDate.setText(date);
        tvStatus.setText(getItem(position).getStatus());
        tvDesc.setText(getItem(position).getDesc());


        return viewHolder;
    }
}
