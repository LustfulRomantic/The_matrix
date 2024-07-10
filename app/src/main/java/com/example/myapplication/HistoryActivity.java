package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;

public class HistoryActivity extends AppCompatActivity implements MyAdapter.OnClickListener {

    private DatabaseReference ref;
    private ListView lv;
    ArrayList<Item> arrayOfItem = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        ref = FirebaseDatabase.getInstance().getReference("Items");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               for(DataSnapshot snap: snapshot.getChildren()){
                   Item it = snap.getValue(Item.class);
                   arrayOfItem.add(it);
               }
               refresh_lv();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        lv = findViewById(R.id.lv);
        refresh_lv();
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.item_hs) {
            Toast.makeText(HistoryActivity.this, "You are in the already in!", Toast.LENGTH_SHORT).show();
        }

        if (item.getItemId() == R.id.item_algo) {
            Intent toAlgo = new Intent(HistoryActivity.this, AlgorithemActivity.class);
            startActivity(toAlgo);
            finish();
        }

        if (item.getItemId() == R.id.item_name) {
            SharedPreferences sp;
            sp = getSharedPreferences("User", MODE_PRIVATE);
            SharedPreferences.Editor edit = sp.edit();
            edit.putString("User", "");
            edit.apply();
            Intent toMain = new Intent(HistoryActivity.this, MainActivity.class);
            startActivity(toMain);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    private void refresh_lv() {
        //lv <= arrayOfStrings
        MyAdapter adp = new MyAdapter(this, android.R.layout.simple_list_item_1, arrayOfItem);
        lv.setAdapter(adp);
        adp.setOnClickListener(this);
    }

    @Override
    public void onClick(int pos) {

        Toast.makeText(this, "Item no."+(pos+1), Toast.LENGTH_LONG).show();
        GlobalInfo.itemNum = pos+1;
        Intent toAlgo = new Intent(HistoryActivity.this, AlgorithemActivity.class);
        toAlgo.putExtra("picurl", arrayOfItem.get(pos).getPic());
        startActivity(toAlgo);
    }
}