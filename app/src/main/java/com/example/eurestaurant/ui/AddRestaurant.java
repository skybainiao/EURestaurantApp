package com.example.eurestaurant.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.eurestaurant.Model.Restaurant;
import com.example.eurestaurant.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddRestaurant extends AppCompatActivity {

    private String username;
    private ImageView imageView;
    private EditText restaurantName;
    private EditText infoTitle;
    private EditText restaurantType;
    private EditText cityName;
    private EditText countryName;
    private EditText addressDetail;
    private EditText content;
    private ImageView uploadImg;
    private Button chooseImg;
    private Button upload;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_restaurant);

        Intent getIntent = getIntent();
        username = getIntent.getStringExtra("username");
        System.out.println(username);
        System.out.println("///////////////////////"+username);

        firebaseDatabase=FirebaseDatabase.getInstance("https://eufunapp-default-rtdb.europe-west1.firebasedatabase.app/");
        databaseReference=firebaseDatabase.getReference();

        imageView=findViewById(R.id.imageView37);
        restaurantName=findViewById(R.id.editTextTextPersonName4);
        infoTitle=findViewById(R.id.editTextTextPersonName5);
        restaurantType=findViewById(R.id.editTextTextPersonName6);
        cityName=findViewById(R.id.editTextTextPersonName7);
        countryName=findViewById(R.id.editTextTextPersonName8);
        addressDetail=findViewById(R.id.editTextTextPersonName9);
        content=findViewById(R.id.editTextTextPersonName10);
        uploadImg=findViewById(R.id.imageView42);
        chooseImg=findViewById(R.id.button62);
        upload=findViewById(R.id.button63);

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadInfo();
            }
        });

    }



    public void uploadInfo(){
        Restaurant restaurant = new Restaurant(username,restaurantName.getText().toString(),addressDetail.getText().toString(),
                infoTitle.getText().toString(),content.getText().toString(),restaurantType.getText().toString(),
                cityName.getText().toString(),countryName.getText().toString(),"",0,0,0,0,0,null,0);


        databaseReference.child("Restaurant").child(restaurant.getRestaurantName()).setValue(restaurant);
    }

















}