package com.example.eurestaurant.ui.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Options;
import com.example.eurestaurant.Adapter.MyAdapter;
import com.example.eurestaurant.MainActivity;
import com.example.eurestaurant.Model.Pic;
import com.example.eurestaurant.R;
import com.example.eurestaurant.databinding.FragmentHomeBinding;
import com.example.eurestaurant.ui.AddRestaurant;
import com.example.eurestaurant.ui.ChooseUploadType;
import com.example.eurestaurant.ui.CountryActivity;
import com.example.eurestaurant.ui.RestaurantActivity;
import com.example.eurestaurant.ui.TypesActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private LinearLayout linearLayout;
    private ImageView imageView;
    private TextView more;
    private TextView textView;
    private FirebaseStorage storage;
    private StorageReference storageReference;


    private String username;
    private LinearLayout xicandian;
    private TextView xicandian1;
    private LinearLayout fandian;
    private TextView fandian1;
    private LinearLayout shangdian;
    private TextView shangdian1;
    private LinearLayout jingdian;
    private TextView jingdian1;
    private LinearLayout lvdian;
    private TextView lvdian1;
    private LinearLayout bowuguan;
    private TextView bowuguan1;
    private LinearLayout jiaotong;
    private TextView jiaotong1;
    private LinearLayout gengduofenlei;
    private TextView gengduofenlei1;
    private LinearLayout linearLayout3;
    private int num;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        num=3;
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        StorageReference ref = storageReference.child("mmexport1663173155480.jpg");

        Intent getIntent = getActivity().getIntent();
        username = getIntent.getStringExtra("username");

        linearLayout=root.findViewById(R.id.linearLayoutMax);
        imageView=root.findViewById(R.id.imageView1);
        //more=root.findViewById(R.id.more20);
        textView=root.findViewById(R.id.textView7);
        xicandian=root.findViewById(R.id.linearLayout1);
        xicandian1=root.findViewById(R.id.textView);
        fandian=root.findViewById(R.id.linearLayout2);
        fandian1=root.findViewById(R.id.textView6);
        linearLayout3=root.findViewById(R.id.linearLayout3);



        final long ONE_MEGABYTE = 1024 * 1024 * 5;




        for (int i = 0; i < num; i++) {
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(LinearLayout.VERTICAL);
            ImageView imageView = new ImageView(getContext());
            //set img
            //imageView.setImageResource(R.mipmap.d);
            ref.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                @Override
                public void onSuccess(byte[] bytes) {
                    Bitmap bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                    imageView.setImageBitmap(bitmap);
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    // Handle any errors
                }
            });

            TextView title = new TextView(getContext());
            title.setText("Hello Denmark");
            title.setTextSize(20);
            LinearLayout linearLayout1 = new LinearLayout(getContext());
            TextView username = new TextView(getContext());
            username.setText("Chen");
            TextView like = new TextView(getContext());
            like.setText("❤2.5");
            like.setWidth(400);
            like.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            linearLayout1.setPadding(0,0,0,0);
            like.setPadding(0,0,-265,0);

            linearLayout.addView(imageView);
            linearLayout.addView(title);
            linearLayout3.addView(linearLayout);
            linearLayout1.addView(username);
            linearLayout1.addView(like);
            linearLayout3.addView(linearLayout1);

            linearLayout3.setPadding(0,0,0,0);
            linearLayout.setPadding(0,-270,0,0);
            title.setPadding(0,0,0,0);
            imageView.setPadding(0,0,0,-300);
        }







        xicandian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TypesActivity.class);
                intent.putExtra("type", xicandian1.getText());
                startActivity(intent);
            }
        });

        fandian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TypesActivity.class);
                intent.putExtra("type", fandian1.getText());
                startActivity(intent);
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ChooseUploadType.class);
                intent.putExtra("username", username);
                startActivity(intent);



            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CountryActivity.class);
                startActivity(intent);
            }
        });

        //more.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        Intent intent = new Intent(getActivity(), CountryActivity.class);
        //        startActivity(intent);
        //    }
        //});


        return root;
    }


    public void margin(View v, int l, int t, int r, int b) {
        if (v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            p.setMargins(l, t, r, b);
            v.requestLayout();
        }
    }

    public static Bitmap getPicFromBytes(byte[] bytes,BitmapFactory.Options opts) {
        if (bytes != null)
            if (opts != null)
                return BitmapFactory.decodeByteArray(bytes, 0, bytes.length,opts);
            else
                return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        return null;
    }

    public void getMoreCities(){

    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}