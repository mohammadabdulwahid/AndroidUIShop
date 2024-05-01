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

import java.util.HashMap;

public class AddProduct extends AppCompatActivity {

    private ImageView back;
    private Button publish;
    private DatabaseReference ref;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        appWorks();


    }

    private void appWorks() {
        back = findViewById(R.id.back);
        EditText appName = findViewById(R.id.app_name);
        EditText appPrice = findViewById(R.id.app_price);
        EditText appBeforePrice = findViewById(R.id.app_before_price);
        EditText appDesc = findViewById(R.id.app_desc);
        EditText appDownloadLink = findViewById(R.id.app_download_link);
        EditText appThumbLink = findViewById(R.id.app_thumbnail_link);
        EditText screenshotOne = findViewById(R.id.screenshot_one);
        EditText screenshotTwo = findViewById(R.id.screenshot_two);
        EditText screenshotThree = findViewById(R.id.screenshot_three);
        EditText screenshotFour = findViewById(R.id.screenshot_four);
        EditText screenshotFive = findViewById(R.id.screenshot_five);
        EditText screenshotSix = findViewById(R.id.screenshot_six);
        EditText screenshotSeven = findViewById(R.id.screenshot_seven);
        EditText screenshotEight = findViewById(R.id.screenshot_eight);
        EditText screenshotNine = findViewById(R.id.screenshot_nine);
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
                String id = ref.push().getKey();

                String appNameST = appName.getText().toString();
                String appPriceST = appPrice.getText().toString();
                String appBeforePriceST = appBeforePrice.getText().toString();
                String appDescSt = appDesc.getText().toString();
                String appDownloadSt = appDownloadLink.getText().toString();
                String appThumbSt = appThumbLink.getText().toString();
                String imageOneSt = screenshotOne.getText().toString();
                String imageTwoSt = screenshotTwo.getText().toString();
                String imageThreeSt = screenshotThree.getText().toString();
                String imageFourSt = screenshotFour.getText().toString();
                String imageFiveSt = screenshotFive.getText().toString();
                String imageSixSt = screenshotSix.getText().toString();
                String imageSevenSt = screenshotSeven.getText().toString();
                String imageEightSt = screenshotEight.getText().toString();
                String imageNineSt = screenshotNine.getText().toString();

                String removeLinkFirst = "https://drive.google.com/file/d/";
                String removeLinkSecond = "/view";

                if (
                        appDownloadSt.contains(removeLinkFirst) ||
                        appThumbSt.contains(removeLinkFirst) ||
                        imageOneSt.contains(removeLinkFirst) ||
                        imageTwoSt.contains(removeLinkFirst) ||
                        imageThreeSt.contains(removeLinkFirst) ||
                        imageFourSt.contains(removeLinkFirst) ||
                        imageFiveSt.contains(removeLinkFirst) ||
                        imageSixSt.contains(removeLinkFirst) ||
                        imageSevenSt.contains(removeLinkFirst) ||
                        imageEightSt.contains(removeLinkFirst) ||
                        imageNineSt.contains(removeLinkFirst)
                ){
                    String splitsDownApp = appDownloadSt.split(removeLinkFirst)[1];
                    String splitsThumb = appThumbSt.split(removeLinkFirst)[1];
                    String splitsImageOne = imageOneSt.split(removeLinkFirst)[1];
                    String splitsImageTwo = imageTwoSt.split(removeLinkFirst)[1];
                    String splitsImageThree = imageThreeSt.split(removeLinkFirst)[1];
                    String splitsImageFour = imageFourSt.split(removeLinkFirst)[1];
                    String splitsImageFive = imageFiveSt.split(removeLinkFirst)[1];
                    String splitsImageSix = imageSixSt.split(removeLinkFirst)[1];
                    String splitsImageSeven = imageSevenSt.split(removeLinkFirst)[1];
                    String splitsImageEight = imageEightSt.split(removeLinkFirst)[1];
                    String splitsImageNine = imageNineSt.split(removeLinkFirst)[1];

                    if (
                            splitsDownApp.contains(removeLinkSecond) ||
                            splitsThumb.contains(removeLinkSecond) ||
                            splitsImageOne.contains(removeLinkSecond) ||
                            splitsImageTwo.contains(removeLinkSecond) ||
                            splitsImageThree.contains(removeLinkSecond) ||
                            splitsImageFour.contains(removeLinkSecond) ||
                            splitsImageFive.contains(removeLinkSecond) ||
                            splitsImageSix.contains(removeLinkSecond) ||
                            splitsImageSeven.contains(removeLinkSecond) ||
                            splitsImageEight.contains(removeLinkSecond) ||
                            splitsImageNine.contains(removeLinkSecond)
                    ){
                        String download = splitsDownApp.split(removeLinkSecond)[0];
                        String thumb = splitsThumb.split(removeLinkSecond)[0];
                        String imageOne = splitsImageOne.split(removeLinkSecond)[0];
                        String imageTwo = splitsImageTwo.split(removeLinkSecond)[0];
                        String imageThree = splitsImageThree.split(removeLinkSecond)[0];
                        String imageFour = splitsImageFour.split(removeLinkSecond)[0];
                        String imageFive = splitsImageFive.split(removeLinkSecond)[0];
                        String imageSix = splitsImageSix.split(removeLinkSecond)[0];
                        String imageSeven = splitsImageSeven.split(removeLinkSecond)[0];
                        String imageEight = splitsImageEight.split(removeLinkSecond)[0];
                        String imageNine = splitsImageNine.split(removeLinkSecond)[0];

                        HashMap<String, Object> hashMap = new HashMap<>();
                        hashMap.put("id", id);
                        hashMap.put("appName", appNameST);
                        hashMap.put("appPrice", appPriceST);
                        hashMap.put("appOldPrice", appBeforePriceST);
                        hashMap.put("appDesc", appDescSt);
                        hashMap.put("download", download);
                        hashMap.put("appThumb", thumb);
                        hashMap.put("imageOne", imageOne);
                        hashMap.put("imageTwo", imageTwo);
                        hashMap.put("imageThree", imageThree);
                        hashMap.put("imageFour", imageFour);
                        hashMap.put("imageFive", imageFive);
                        hashMap.put("imageSix", imageSix);
                        hashMap.put("imageSeven", imageSeven);
                        hashMap.put("imageEight", imageEight);
                        hashMap.put("imageNine", imageNine);
                        hashMap.put("sale", "0");
                        hashMap.put("status", "pending");
                        ref.child(id).setValue(hashMap);

                        Toast.makeText(AddProduct.this, "Success", Toast.LENGTH_SHORT).show();

                        appName.setText("");
                        appPrice.setText("");
                        appBeforePrice.setText("");
                        appDesc.setText("");
                        appDownloadLink.setText("");
                        appThumbLink.setText("");
                        screenshotOne.setText("");
                        screenshotTwo.setText("");
                        screenshotThree.setText("");
                        screenshotFour.setText("");
                        screenshotFive.setText("");
                        screenshotSix.setText("");
                        screenshotSeven.setText("");
                        screenshotEight.setText("");
                        screenshotNine.setText("");
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