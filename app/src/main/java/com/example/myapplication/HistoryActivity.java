package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class HistoryActivity extends AppCompatActivity {

    private ListView lv;
    ArrayList<Item> arrayOfItem = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        lv = findViewById(R.id.lv);

        add10TestItems();
        refresh_lv();
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

        }

        if (item.getItemId() == R.id.item_algo) {
            Intent toAlgo = new Intent(HistoryActivity.this, AlgorithemActivity.class);
            startActivity(toAlgo);
            finish();
        }

        return super.onOptionsItemSelected(item);

    }

    private void refresh_lv() {

        //lv <= arrayOfStrings

        MyAdapter adp = new MyAdapter(this, android.R.layout.simple_list_item_1, arrayOfItem);
        lv.setAdapter(adp);

    }

    private void add10TestItems() {

        for(int i =0; i < 10; i++) {

            Date date = Calendar.getInstance().getTime();
            Item item = new Item("Itamar","Picture: "+i,"This is a test item", date, "a1" );

            arrayOfItem.add(item);
        }
    }
}