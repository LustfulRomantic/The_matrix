package com.example.myapplication;

import static com.example.myapplication.GlobalInfo.itemNum;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class AddToDb {
    public static void addItem(){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Items");
        Item it1 = new Item("maks", "pic1", "desc", "23.06.2024", "stat", "pic");
        ref.child("1").setValue(it1);
    }
    public static void addMat(Mat mat, Integer num){
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Mats");
        ref.child(num+"").setValue(mat);
    }

//    public static void addSolution(ArrayList<Cell> arr){
//        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("Solutions");
//        ref.child(itemNum+"").setValue(arr);
//    }
}
