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

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<Item> {

    OnClickListener listener;
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
                if (listener != null){
                    listener.onClick(position);
                }
                Log.d("Maksim","I clicked on row " + position);
            }
        });

        String date = getItem(position).getDate();

        tvName.setText(getItem(position).getName());
        tvDate.setText(date);
        tvStatus.setText(getItem(position).getStatus());
        tvDesc.setText(getItem(position).getDesc());
        Picasso.get().load(getItem(position).getPic()).into(iv);

        return viewHolder;
    }

    public void setOnClickListener(OnClickListener context){
        this.listener = context;
    }
    public interface OnClickListener {
        public void onClick(int pos);
    }
}
