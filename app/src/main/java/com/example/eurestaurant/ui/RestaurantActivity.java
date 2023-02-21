package com.example.eurestaurant.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.eurestaurant.R;

public class RestaurantActivity extends AppCompatActivity {

    private ImageView back;
    private TextView restName;
    private TextView title;
    private TextView content;
    private TextView location;
    private String postNum;
    private RatingBar ratingBar1;
    private RatingBar ratingBar2;
    private RatingBar ratingBar3;
    private RatingBar ratingBar4;
    private RatingBar ratingBar5;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private ImageView imageView5;
    private ImageView imageView6;
    private ImageView imageView7;
    private ImageView imageView8;
    private ImageView imageView9;
    private ImageView imageView10;
    private ImageView imageView11;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        Intent getIntent = getIntent();
        postNum = getIntent.getStringExtra("postNum");
        System.out.println(postNum);

        back=findViewById(R.id.imageView12);
        restName=findViewById(R.id.textView22);
        title=findViewById(R.id.textView25);
        content=findViewById(R.id.textView26);
        location=findViewById(R.id.textView27);
        ratingBar1=findViewById(R.id.ratingBar7);
        ratingBar2=findViewById(R.id.ratingBar8);
        ratingBar3=findViewById(R.id.ratingBar9);
        ratingBar4=findViewById(R.id.ratingBar10);
        ratingBar5=findViewById(R.id.ratingBar11);
        imageView1=findViewById(R.id.imageView36);
        imageView2=findViewById(R.id.imageView32);
        imageView3=findViewById(R.id.imageView31);
        imageView4=findViewById(R.id.imageView24);
        imageView5=findViewById(R.id.imageView16);
        imageView6=findViewById(R.id.imageView17);
        imageView7=findViewById(R.id.imageView18);
        imageView8=findViewById(R.id.imageView19);
        imageView9=findViewById(R.id.imageView20);
        imageView10=findViewById(R.id.imageView21);
        imageView11=findViewById(R.id.imageView22);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}