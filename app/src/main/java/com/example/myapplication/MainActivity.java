package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity /*implements View.OnClickListener*/ {

    private Button btn;
    private EditText et;
    private SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = getSharedPreferences("User", MODE_PRIVATE);
        String u = sp.getString("User","");
        if (!u.equals("")){
            Intent toHs = new Intent(MainActivity.this, HistoryActivity.class);
            startActivity(toHs);
            finish();
        }
        else{
            btn = findViewById(R.id.btn);
            et = findViewById(R.id.ed_name);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(et.getText().toString().equals("")){
                        Toast.makeText(MainActivity.this, "Enter your name",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        SharedPreferences.Editor edit = sp.edit();
                        edit.putString("User", et.getText().toString());
                        edit.apply();
                        Intent toHs = new Intent(MainActivity.this, HistoryActivity.class);
                        startActivity(toHs);
                    }
                }
            });
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.item_hs || item.getItemId() == R.id.item_algo) {
            Toast.makeText(MainActivity.this, "Enter your name first!", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);

    }
}