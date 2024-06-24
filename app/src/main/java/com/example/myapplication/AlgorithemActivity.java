package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AlgorithemActivity extends AppCompatActivity {

    Button confbtn;
    Button appBtn;
    Mat m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algorithem);

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


        confbtn = (Button) findViewById(R.id.confbtn);

        confbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog conf_dialog = new Dialog(AlgorithemActivity.this);
                conf_dialog.setContentView(R.layout.conf_dialog);

                Button disbtn;
                disbtn = (Button) conf_dialog.findViewById(R.id.disbtn);
                disbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        conf_dialog.dismiss();
                    }
                });

                conf_dialog.show();
            }
        });

        appBtn = (Button) findViewById(R.id.appbtn);
        appBtn.setEnabled(false);
        appBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("Maksim","Apply button clicked");
            }

        });

        //Solve the puzzle
        /*
         * Maksim - do your magic here
         */

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