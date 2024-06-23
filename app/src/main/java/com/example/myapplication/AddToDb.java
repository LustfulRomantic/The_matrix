package com.example.myapplication;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddToDb {
    public static void Additem(){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Items");
        Item it1 = new Item("maks", "pic1", "desc", "23.06.2024", "stat", "pic");
        ref.child("1").setValue(it1);
    }
}
