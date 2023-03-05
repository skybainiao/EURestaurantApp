package com.example.eurestaurant.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.eurestaurant.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class RestaurantActivity extends AppCompatActivity {

    private ImageView back;
    private TextView restName;
    private TextView title;
    private TextView content;
    private TextView location;
    private int postNum;
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

    private ArrayList<ImageView> imageViews;
    private FirebaseStorage storage;
    private StorageReference ref;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        Intent getIntent = getIntent();
        postNum = getIntent.getIntExtra("postNum",10);
        System.out.println(postNum);
        imageViews=new ArrayList<>();
        storage = FirebaseStorage.getInstance();
        ref = storage.getReference();
        //StorageReference ref = storageReference.child("mmexport1663173155480.jpg");
        firebaseDatabase=FirebaseDatabase.getInstance("https://eufunapp-default-rtdb.europe-west1.firebasedatabase.app/");
        databaseReference=firebaseDatabase.getReference();
        final long ONE_MEGABYTE = 1024 * 1024 * 10;

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

        imageViews.add(imageView1);
        imageViews.add(imageView2);
        imageViews.add(imageView3);
        imageViews.add(imageView4);
        imageViews.add(imageView5);
        imageViews.add(imageView6);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        if (ratingBar1.callOnClick())

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot pair : snapshot.child("Post").getChildren()){
                    if (pair.getKey().contains(String.valueOf(postNum))){
                        restName.setText(pair.child("restaurantName").getValue().toString());
                        title.setText(pair.child("title").getValue().toString());
                        content.setText(pair.child("content").getValue().toString());
                        location.setText(pair.child("location").getValue().toString());

                        StorageReference listRef = ref.child(restName.getText().toString());
                        listRef.listAll()
                                .addOnSuccessListener(new OnSuccessListener<ListResult>() {
                                    @Override
                                    public void onSuccess(ListResult listResult) {
                                        for (StorageReference prefix : listResult.getPrefixes()) {
                                            // All the prefixes under listRef.
                                            // You may call listAll() recursively on them.
                                        }

                                        for (int i = 0; i < listResult.getItems().size(); i++) {
                                            if (i<5){
                                                int finalI = i;
                                                listResult.getItems().get(i).getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                                                    @Override
                                                    public void onSuccess(byte[] bytes) {
                                                        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                                                        imageViews.get(finalI).setImageBitmap(bitmap);

                                                    }
                                                });
                                            }
                                        }
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        // Uh-oh, an error occurred!
                                    }
                                });


                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
















    }
}