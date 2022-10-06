package com.example.eurestaurant.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eurestaurant.Model.Account;
import com.example.eurestaurant.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
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
        if (!username.getText().toString().equals("") && !password1.getText().toString().equals("") && !password2.getText().toString().equals("")){
            if (password1.getText().toString().equals(password2.getText().toString())){
                databaseReference.child("Users").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DataSnapshot> task) {
                        System.out.println(task.getResult().hasChild("chen"));
                        if (!task.getResult().hasChild(username.getText().toString())){
                            databaseReference.child("Users").child(account.getUsername()).setValue(account);
                            Toast.makeText(getApplicationContext(),"注册成功", Toast.LENGTH_LONG).show();
                            finish();
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"用户名已存在", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
            else {
                Toast.makeText(getApplicationContext(),"请输入相同的密码", Toast.LENGTH_LONG).show();
            }

        }
        else {
            Toast.makeText(getApplicationContext(),"用户名或者密码为空", Toast.LENGTH_LONG).show();
        }

    }













}