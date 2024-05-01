package com.example.androiduishop;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegisterUsers extends AppCompatActivity {

    private EditText name, email, password, address, city, country;
    private TextView proOrder;

    private FirebaseAuth auth;
    private DatabaseReference ref;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_users);

        workHere();

    }

    private void workHere() {
        name = findViewById(R.id.full_name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        address = findViewById(R.id.address);
        city = findViewById(R.id.city);
        country = findViewById(R.id.country);
        proOrder = findViewById(R.id.order);


        auth = FirebaseAuth.getInstance();
        proOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nameST = name.getText().toString();
                String emailST = email.getText().toString();
                String passwordST = password.getText().toString();
                String addressST = address.getText().toString();
                String cityST = city.getText().toString();
                String countryST = country.getText().toString();

                String id = auth.getUid();

                auth.createUserWithEmailAndPassword(emailST,passwordST)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){

                                    ref = FirebaseDatabase.getInstance().getReference().child("Users");

                                    HashMap<String, Object> hashMap = new HashMap<>();
                                    hashMap.put("id", id);
                                    hashMap.put("name", nameST);
                                    hashMap.put("email", emailST);
                                    hashMap.put("password", passwordST);
                                    hashMap.put("address", addressST);
                                    hashMap.put("city", cityST);
                                    hashMap.put("country", countryST);
                                    ref.child(id).setValue(hashMap);

                                    Toast.makeText(RegisterUsers.this, "Success", Toast.LENGTH_SHORT).show();

                                    name.setText("");
                                    email.setText("");
                                    password.setText("");
                                    address.setText("");
                                    city.setText("");
                                    country.setText("");
                                }
                            }
                        });
            }
        });
    }

    @Override
    public void onBackPressed() {
        try {
            Intent intent = new Intent(RegisterUsers.this, ProductDetails.class);
            startActivity(intent);
            finish();
        }catch (Exception e){

        }
        super.onBackPressed();
    }
}