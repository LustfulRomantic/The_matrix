package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class AlgorithemActivity extends AppCompatActivity {
    Button appBtn;
    Mat m;
    ImageView img_org, img_vac, img_eng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algorithem);

        img_org = findViewById(R.id.image_original);
        img_eng = findViewById(R.id.image_engaged);
        img_vac = findViewById(R.id.image_vacant);

        Picasso.get().load(getIntent().getStringExtra("picurl")).into(img_org);


        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Mats");
        ref.child(GlobalInfo.itemNum+"").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                m = snapshot.getValue(Mat.class);
                appBtn.setEnabled(true);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        appBtn = (Button) findViewById(R.id.appbtn);
        appBtn.setEnabled(false);
        appBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("Maksim","Apply button clicked");

                Dialog d = new Dialog(AlgorithemActivity.this);
                d.setContentView(R.layout.conf_dialog);
                ImageView ivu = d.findViewById(R.id.imageView2);
                ImageView ivs = d.findViewById(R.id.imageView3);

                img_org.buildDrawingCache();
                Bitmap bmap = img_org.getDrawingCache();

                int w = bmap.getWidth(), h = bmap.getHeight();

                Bitmap.Config conf = Bitmap.Config.ARGB_8888; // see other conf types
                Bitmap bmp = Bitmap.createBitmap(w, h, conf); // this creates a MUTABLE bitmap


                for(int i =0; i < bmp.getHeight(); i ++) {
                    bmp.setPixel(bmp.getWidth()/2 -3 , i, Color.RED);
                    bmp.setPixel(bmp.getWidth()/2 -2 , i, Color.RED);
                    bmp.setPixel(bmp.getWidth()/2 -1 , i, Color.RED);
                    bmp.setPixel(bmp.getWidth()/2 -0 , i, Color.RED);


                }
                ivs.setImageBitmap(bmp);

                d.show();
            }

        });

    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.item_main) {
            finish();
        }

        if (item.getItemId() == R.id.item_hs) {
            Intent toHs = new Intent(AlgorithemActivity.this, HistoryActivity.class);
            startActivity(toHs);
            finish();
        }

        if (item.getItemId() == R.id.item_algo) {

        }

        return super.onOptionsItemSelected(item);

    }
}