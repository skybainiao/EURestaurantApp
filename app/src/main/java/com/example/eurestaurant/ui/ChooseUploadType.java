package com.example.eurestaurant.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.eurestaurant.R;

public class ChooseUploadType extends AppCompatActivity {


    private Button upload;
    private Button add;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chosse_uplad_type);

        Intent getIntent = getIntent();
        username = getIntent.getStringExtra("username");
        upload=findViewById(R.id.button64);
        add=findViewById(R.id.button65);

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseUploadType.this, AddRestaurant.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChooseUploadType.this, AddPics.class);
                intent.putExtra("username", username);
                startActivity(intent);
            }
        });
    }
}