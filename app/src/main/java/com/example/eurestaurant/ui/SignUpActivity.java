package com.example.eurestaurant.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eurestaurant.Model.Account;
import com.example.eurestaurant.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    private ImageView back;
    private Button signUp;
    private EditText username;
    private EditText password1;
    private EditText password2;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        firebaseDatabase=FirebaseDatabase.getInstance("https://eufunapp-default-rtdb.europe-west1.firebasedatabase.app/");
        databaseReference=firebaseDatabase.getReference();


        signUp=findViewById(R.id.button60);
        back=findViewById(R.id.imageView14);
        username=findViewById(R.id.editTextTextPersonName3);
        password1=findViewById(R.id.editTextTextPassword2);
        password2=findViewById(R.id.editTextTextPassword3);


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignUp(new Account(username.getText().toString(),password1.getText().toString(),"login"));
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }




    public void SignUp(Account account){
        databaseReference.child("Users").child(account.getUsername()).setValue(account);
    }













}