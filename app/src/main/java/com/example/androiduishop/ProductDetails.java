package com.example.androiduishop;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

public class ProductDetails extends AppCompatActivity {

    private TextView appPrice, appBeforePrice, appName, appSale, appDesc, loginUser;
    private ImageView appThumb, imageOne, imageTwo, imageThree, imageFour, imageFive, imageSix, imageSeven, imageEight, imageNine;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_details);

        workMethod();

    }

    private void workMethod() {

        appThumb = findViewById(R.id.app_thumb);
        appPrice = findViewById(R.id.app_price);
        appBeforePrice = findViewById(R.id.app_before_price);
        appName = findViewById(R.id.app_name);
        appSale = findViewById(R.id.app_sale);
        appDesc = findViewById(R.id.app_desc);
        imageOne = findViewById(R.id.image_one);
        imageTwo = findViewById(R.id.image_two);
        imageThree = findViewById(R.id.image_three);
        imageFour = findViewById(R.id.image_four);
        imageFive = findViewById(R.id.image_five);
        imageSix = findViewById(R.id.image_six);
        imageSeven = findViewById(R.id.image_seven);
        imageEight = findViewById(R.id.image_eight);
        imageNine = findViewById(R.id.image_nine);
        loginUser = findViewById(R.id.buy_product);


        //Glide.with(context).load(defaultLink + imageUrl).into(holder.appImage);
        String appIdST = getIntent().getStringExtra("id").toString();
        String price = getIntent().getStringExtra("app_price").toString();
        String oldPrice = getIntent().getStringExtra("app_before_price").toString();
        String appNameST = getIntent().getStringExtra("app_name").toString();
        String appSaleST = getIntent().getStringExtra("app_sale").toString();
        String appDescST = getIntent().getStringExtra("app_desc").toString();

        appPrice.setText(price);
        appBeforePrice.setPaintFlags(appBeforePrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        appBeforePrice.setText(oldPrice);
        appName.setText(appNameST);
        appSale.setText("Sale: "+appSaleST);
        appDesc.setText(appDescST);

        String thumbView = getIntent().getStringExtra("app_thumb").toString();
        String imageOneView = getIntent().getStringExtra("image_one").toString();
        String imageTwoView = getIntent().getStringExtra("image_two").toString();
        String imageThreeView = getIntent().getStringExtra("image_three").toString();
        String imageFourView = getIntent().getStringExtra("image_four").toString();
        String imageFiveView = getIntent().getStringExtra("image_five").toString();
        String imageSixView = getIntent().getStringExtra("image_six").toString();
        String imageSevenView = getIntent().getStringExtra("image_seven").toString();
        String imageEightView = getIntent().getStringExtra("image_eight").toString();
        String imageNineView = getIntent().getStringExtra("image_nine").toString();

        String defaultLink = "https://drive.google.com/uc?export=view&id=";
        Glide.with(this).load(defaultLink + thumbView).into(appThumb);
        Glide.with(this).load(defaultLink + imageOneView).into(imageOne);
        Glide.with(this).load(defaultLink + imageTwoView).into(imageTwo);
        Glide.with(this).load(defaultLink + imageThreeView).into(imageThree);
        Glide.with(this).load(defaultLink + imageFourView).into(imageFour);
        Glide.with(this).load(defaultLink + imageFiveView).into(imageFive);
        Glide.with(this).load(defaultLink + imageSixView).into(imageSix);
        Glide.with(this).load(defaultLink + imageSevenView).into(imageSeven);
        Glide.with(this).load(defaultLink + imageEightView).into(imageEight);
        Glide.with(this).load(defaultLink + imageNineView).into(imageNine);

        loginUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(ProductDetails.this, LoginUser.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
            }
        });

    }
}