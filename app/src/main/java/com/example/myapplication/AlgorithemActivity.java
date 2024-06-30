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

import java.util.ArrayList;

public class AlgorithemActivity extends AppCompatActivity {
    Button solve_btn;
    Mat m;
    MazeMatrix mm;
    BFSMatrixSolver mms;

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
                mm = m.getMaze();
                Log.d("algo",mm.toString());
                Log.d("algo","Start point: "+mm.getStartPoint().toString());
                Log.d("algo","End point: "+mm.getEndPoint().toString());
                mms = new BFSMatrixSolver(mm);

                solve_btn.setEnabled(true);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        solve_btn = findViewById(R.id.solve_btn);
        solve_btn.setEnabled(false);
        solve_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog d = new Dialog(AlgorithemActivity.this);
                d.setContentView(R.layout.conf_dialog);
                ImageView ivo = d.findViewById(R.id.conf_org_iv);
                Picasso.get().load(getIntent().getStringExtra("picurl")).into(ivo);
                ImageView ivs = d.findViewById(R.id.conf_sol_iv);

                Bitmap bmp = buildMat(mm.getRows(), mm.getCols());
                Log.d("bmp", ""+bmp.getWidth()+", "+bmp.getHeight());

                for(int row = 0; row<mm.getRows(); row++){ //coloring all the engaged cells in red
                    for(int col = 0; col<mm.getCols(); col++){
                        if(!mm.isCellClear(row,col))
                            colorSq2(bmp, col, row, Color.RED);
                    }
                }

                ArrayList<Cell> solution = mms.solve();
                for (Cell cell: solution) {
                    colorSq2(bmp, cell.getColumn(), cell.getRow(), Color.GREEN);
                }
                colorSq2(bmp, mm.getStartPoint().getColumn(), mm.getStartPoint().getRow() ,Color.YELLOW);//Coloring the start cell in yellow

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

    private Bitmap colorSq2(Bitmap bmp, int col_ind, int row_ind, int color) {
        int w = bmp.getWidth();
        int h = bmp.getHeight();
        return colorSq(bmp, w/mm.getCols()*col_ind, w/mm.getCols()*(col_ind+1), h/mm.getRows()*row_ind, h/mm.getRows()*(row_ind+1), color);
    }

    private Bitmap colorSq(Bitmap bmp, int row_start, int row_end, int col_start, int col_end, int color) {
        for(int i = row_start; i < row_end; i ++) {
            for(int j = col_start; j < col_end; j++ ) {
                bmp.setPixel(i,j,color);
            }
        }
        return bmp;
    }
    private Bitmap buildMat(int rows, int cols){
        img_org.buildDrawingCache();
        Bitmap bmp0 = img_org.getDrawingCache();

        int w = bmp0.getWidth(), h = bmp0.getHeight();

        Bitmap.Config conf = Bitmap.Config.ARGB_8888; // see other conf types
        Bitmap bmp = Bitmap.createBitmap(w, h, conf); // this creates a MUTABLE bitmap

        for(int j =bmp.getWidth()/cols; j < bmp.getWidth()-4; j = j +  bmp.getWidth()/cols  ) {

            for (int i = 0; i < bmp.getHeight(); i++) {
                bmp.setPixel(j, i, Color.BLACK);
                bmp.setPixel(j+1, i, Color.BLACK);
                bmp.setPixel(j+2, i, Color.BLACK);
                bmp.setPixel(j+3, i, Color.BLACK);
            }
        }
        for(int i = bmp.getHeight()/rows; i < bmp.getHeight()-6; i = i +  bmp.getHeight()/rows  ) {

            for (int j = 0; j < bmp.getWidth(); j++) {
                bmp.setPixel(j, i, Color.BLACK);
                bmp.setPixel(j, i+1, Color.BLACK);
                bmp.setPixel(j, i+2, Color.BLACK);
                bmp.setPixel(j, i+3, Color.BLACK);
            }
        }
        return bmp;
    }
}