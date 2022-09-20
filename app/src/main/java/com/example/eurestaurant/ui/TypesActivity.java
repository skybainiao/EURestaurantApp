package com.example.eurestaurant.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.eurestaurant.R;

public class TypesActivity extends AppCompatActivity {

    private ImageView back;
    private TextView title;
    private TextView title1;
    private String types;
    private LinearLayout linearLayout2;
    private LinearLayout linearLayout3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_types);

        types=getIntent().getStringExtra("type");

        back=findViewById(R.id.imageView33);
        linearLayout2=findViewById(R.id.linearLayout2);
        linearLayout3=findViewById(R.id.linearLayout3);
        title=findViewById(R.id.textView30);
        title1=findViewById(R.id.textView43);

        title.setText(types);
        title1.setText("丹麦热门"+types);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TypesActivity.this, RestaurantActivity.class);
                startActivity(intent);
            }
        });

        linearLayout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TypesActivity.this, RestaurantActivity.class);
                startActivity(intent);
            }
        });
    }
}