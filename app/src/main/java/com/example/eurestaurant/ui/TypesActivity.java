package com.example.eurestaurant.ui;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eurestaurant.MainActivity;
import com.example.eurestaurant.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class TypesActivity extends AppCompatActivity {

    private ImageView back;
    private TextView title;
    private TextView title1;
    private String types;
    private LinearLayout linearLayout2;
    private LinearLayout linearLayout3;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private FirebaseStorage storage;
    private StorageReference storageRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_types);


        firebaseDatabase=FirebaseDatabase.getInstance("https://eufunapp-default-rtdb.europe-west1.firebasedatabase.app/");
        databaseReference=firebaseDatabase.getReference();
        storage = FirebaseStorage.getInstance();
        storageRef = storage.getReference();


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (int i = 0; i < snapshot.child("Restaurant").getChildrenCount(); i++) {
                    System.out.println("numberrrrrrrrrrrrrrrrrr: "+i);
                }

                System.out.println(snapshot.child("Restaurant").getChildrenCount());
                System.out.println(snapshot.child("Restaurant").toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("Errorrrrrrrrrrrrrrrrrrrrrrrrrrrr");
            }
        });


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