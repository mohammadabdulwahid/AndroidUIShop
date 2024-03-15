package com.example.androiduishop;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddProduct extends AppCompatActivity {

    private ImageView back;
    private EditText appName, appPrice, appImgLink;
    private Button publish;
    private DatabaseReference ref;
    private FirebaseDatabase db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_product);

        appWorks();


    }

    private void appWorks() {
        back = findViewById(R.id.back);
        appName = findViewById(R.id.app_name);
        appPrice = findViewById(R.id.app_price);
        appImgLink = findViewById(R.id.app_img_link);
        publish = findViewById(R.id.publish);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddProduct.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ref = FirebaseDatabase.getInstance().getReference().child("products");

                String appNameST = appName.getText().toString();
                String appPriceST = appPrice.getText().toString();
                String appImgLinkST = appImgLink.getText().toString();

                //https://drive.google.com/file/d/1_lbdfXR3tTutTUMeQvBImj59d_EsI3nV/view?usp=drive_link
                //Main link convert to file id
                String removeLinkFirst = "https://drive.google.com/file/d/";
                String removeLinkSecond = "/view";

                if (appImgLinkST.contains(removeLinkFirst)){
                    String splitsOne = appImgLinkST.split(removeLinkFirst)[1];

                    if (splitsOne.contains(removeLinkSecond)){
                        String splitsTwo = splitsOne.split(removeLinkSecond)[0];

                        ProductModel model = new ProductModel(appNameST, appPriceST, splitsTwo);
                        ref.push().setValue(model);

                        Toast.makeText(AddProduct.this, "Success", Toast.LENGTH_SHORT).show();

                        appName.setText("");
                        appPrice.setText("");
                        appImgLink.setText("");
                    }
                }

            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(AddProduct.this, MainActivity.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }
}