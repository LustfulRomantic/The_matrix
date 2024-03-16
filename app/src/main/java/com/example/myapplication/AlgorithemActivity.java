package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class AlgorithemActivity extends AppCompatActivity {

    Button confbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algorithem);

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