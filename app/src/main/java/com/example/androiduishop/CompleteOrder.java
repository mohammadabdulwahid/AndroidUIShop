package com.example.androiduishop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class CompleteOrder extends AppCompatActivity {

    private LinearLayout clickedBkash, clickedNagad;
    private ImageView bkashChecked, bkashUncheked, nagadChecked, nagadUnchecked;

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

        try {
            if (firebaseUser == null){
                startActivity(new Intent(CompleteOrder.this, LoginUser.class));
                finish();
            }
        }catch (Exception e){

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complete_order);

        workHere();

    }

    private void workHere() {
        clickedBkash = findViewById(R.id.clicked_bkash);
        clickedNagad = findViewById(R.id.clicked_nagad);
        bkashChecked = findViewById(R.id.bkash_checked);
        bkashUncheked = findViewById(R.id.bkash_Unchecked);
        nagadChecked = findViewById(R.id.nagad_checked);
        nagadUnchecked = findViewById(R.id.nagad_unchecked);


        clickedBkash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bkashChecked.setVisibility(View.VISIBLE);
                bkashUncheked.setVisibility(View.GONE);
                nagadChecked.setVisibility(View.GONE);
                nagadUnchecked.setVisibility(View.VISIBLE);
            }
        });

        clickedNagad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bkashChecked.setVisibility(View.GONE);
                bkashUncheked.setVisibility(View.VISIBLE);
                nagadChecked.setVisibility(View.VISIBLE);
                nagadUnchecked.setVisibility(View.GONE);
            }
        });

    }

    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(CompleteOrder.this, ProductDetails.class);
            startActivity(intent);
            finish();
        }catch (Exception e){

        }
        super.onBackPressed();
    }
}