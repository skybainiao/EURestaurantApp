package com.example.eurestaurant.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.eurestaurant.Model.Restaurant;
import com.example.eurestaurant.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class AddRestaurant extends AppCompatActivity {

    private int PICK_IMAGE_REQUEST = 111;
    private Uri filePath;
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
    private FirebaseStorage storage;
    private StorageReference storageRef;

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
        storage = FirebaseStorage.getInstance();
        storageRef = storage.getReference();

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


        chooseImg.setOnClickListener(new View.OnClickListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_PICK);
                startActivityForResult(Intent.createChooser(intent, "Select Image"), PICK_IMAGE_REQUEST);
            }
        });

        upload.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                uploadInfo();

                if(filePath != null) {
                    System.out.println("pppppppppppppp"+getEntryName(filePath.getPath()));
                    StorageReference childRef = storageRef.child(restaurantName.getText().toString()+"/"+getEntryName(filePath.getPath()));

                    UploadTask uploadTask = childRef.putFile(filePath);

                    uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            Toast.makeText(getApplicationContext(), "Upload successful", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                            Toast.makeText(getApplicationContext(), "Upload Failed -> " + e, Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else {
                    Toast.makeText(getApplicationContext(), "Select an image", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }



    public void uploadInfo(){
        Restaurant restaurant = new Restaurant(username,restaurantName.getText().toString(),addressDetail.getText().toString(),
                infoTitle.getText().toString(),content.getText().toString(),restaurantType.getText().toString(),
                cityName.getText().toString(),countryName.getText().toString(),"",0,0,0,0,0,null,0);


        databaseReference.child("Restaurant").child(restaurant.getRestaurantName()).setValue(restaurant);
    }


    @SuppressWarnings("deprecation")
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            filePath = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), filePath);

                uploadImg.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //get FileName
    public static String getEntryName(String picturePath) {
        if (!TextUtils.isEmpty(picturePath)) {
            int start = picturePath.lastIndexOf("/");
            String format = "";
            if (start < 0) {
                format = picturePath;
            } else {
                format = picturePath.substring(start + 1);
            }
            return format;
        }
        return "";
    }











}