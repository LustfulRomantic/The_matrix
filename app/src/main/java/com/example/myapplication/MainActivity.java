package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity /*implements View.OnClickListener*/ {

    private Button btn;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Dialog my_dialog = new Dialog(MainActivity.this);
                //my_dialog.setContentView(R.layout.dialog1);

                //my_dialog.show();

                Intent toHs = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(toHs);
            }
        });
        /*
///////////Anonymous listener
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

///////////////////////////////A new View.OnClickListener object
        View.OnClickListener ocl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        };

/////////////////////////I am the listener
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    public void onClick(View v) {
        //shared function
        switch(v.getId()) {
            case R.id.btn1:
                ///////
                break;
            case R.id.btn2:
                ///////
                break;
        }
    }

         */
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.item_main) {

        }

        if (item.getItemId() == R.id.item_hs) {
            Intent toHs = new Intent(MainActivity.this, HistoryActivity.class);
            startActivity(toHs);
        }

        if (item.getItemId() == R.id.item_algo) {
            Intent toAlgo = new Intent(MainActivity.this, AlgorithemActivity.class);
            startActivity(toAlgo);
        }

        return super.onOptionsItemSelected(item);

    }
}