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

import java.util.ArrayList;

public class AddRestaurant extends AppCompatActivity {

    private int PICK_IMAGE_REQUEST = 111;
    private Uri filePath;
    private ArrayList<Uri> uris;
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
    private ImageView uploadImg1;
    private ImageView uploadImg2;
    private ImageView uploadImg3;
    private ImageView uploadImg4;
    private ImageView uploadImg5;
    private ImageView uploadImg6;
    private ImageView uploadImg7;
    private ImageView uploadImg8;
    private ImageView uploadImg9;
    private ArrayList<ImageView> imageViews;
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

        imageViews=new ArrayList<>();
        uris=new ArrayList<>();
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
        uploadImg1=findViewById(R.id.imageView28);
        uploadImg2=findViewById(R.id.imageView23);
        uploadImg3=findViewById(R.id.imageView22);
        uploadImg4=findViewById(R.id.imageView21);
        uploadImg5=findViewById(R.id.imageView18);
        uploadImg6=findViewById(R.id.imageView17);
        uploadImg7=findViewById(R.id.imageView10);
        uploadImg8=findViewById(R.id.imageView9);
        uploadImg9=findViewById(R.id.imageView8);
        imageViews.add(uploadImg);
        imageViews.add(uploadImg1);
        imageViews.add(uploadImg2);
        imageViews.add(uploadImg3);
        imageViews.add(uploadImg4);
        imageViews.add(uploadImg5);
        imageViews.add(uploadImg6);
        imageViews.add(uploadImg7);
        imageViews.add(uploadImg8);
        imageViews.add(uploadImg9);
        //chooseImg=findViewById(R.id.button62);
        upload=findViewById(R.id.button63);



        for (int i = 0; i < imageViews.size(); i++) {
            imageViews.get(i).setTag("n");
            imageViews.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_PICK);
                    startActivityForResult(Intent.createChooser(intent, "Select Image"), PICK_IMAGE_REQUEST);
                }
            });
        }


        upload.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                uploadInfo();
                for (int i = 0; i < uris.size(); i++) {
                    if (uris.get(i)!=null){
                        System.out.println("pppppppppppppp"+getEntryName(uris.get(i).getPath()));
                        StorageReference childRef = storageRef.child(restaurantName.getText().toString()+"/"+getEntryName(uris.get(i).getPath()));

                        UploadTask uploadTask = childRef.putFile(uris.get(i));

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
            uris.add(filePath);

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), filePath);

                for (int i = 0; i < imageViews.size(); i++) {
                    if (imageViews.get(i).getTag().equals("n")){
                        imageViews.get(i).setImageBitmap(bitmap);
                        imageViews.get(i).setTag("y");
                        break;
                    }

                }
                //uploadImg.setImageBitmap(bitmap);
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