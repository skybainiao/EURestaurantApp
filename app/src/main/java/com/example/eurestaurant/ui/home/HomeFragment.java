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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private LinearLayout linearLayout;
    private ImageView imageView;
    private TextView more;
    private TextView textView;
    private FirebaseStorage storage;
    private StorageReference ref;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private ArrayList<TextView> textViews;
    private ArrayList<String> arrayList1;
    private ArrayList<String> restName;
    private ArrayList<TextView> restNameText;
    private ArrayList<ImageView> imageViews;
    private ArrayList<String> referenceName;
    private Map<String,TextView> map = new HashMap<>();
    private int a=0;
    private ArrayList<StorageReference> storageReferences;

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
    private LinearLayout linearLayout4;
    private int num;
    private LinearLayout linearLayoutx;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        textViews=new ArrayList<>();
        arrayList1=new ArrayList<>();
        storageReferences=new ArrayList<>();
        restNameText=new ArrayList<>();
        restName=new ArrayList<>();
        imageViews=new ArrayList<>();
        referenceName=new ArrayList<>();
        storage = FirebaseStorage.getInstance();
        ref = storage.getReference();
        //StorageReference ref = storageReference.child("mmexport1663173155480.jpg");
        firebaseDatabase=FirebaseDatabase.getInstance("https://eufunapp-default-rtdb.europe-west1.firebasedatabase.app/");
        databaseReference=firebaseDatabase.getReference();

        Intent getIntent = getActivity().getIntent();
        username = getIntent.getStringExtra("username");
        num = getIntent.getIntExtra("num",2);
        System.out.println(num);

        linearLayout=root.findViewById(R.id.linearLayoutMax);
        imageView=root.findViewById(R.id.imageView1);
        //more=root.findViewById(R.id.more20);
        textView=root.findViewById(R.id.textView7);
        xicandian=root.findViewById(R.id.linearLayout1);
        xicandian1=root.findViewById(R.id.textView);
        fandian=root.findViewById(R.id.linearLayout2);
        fandian1=root.findViewById(R.id.textView6);
        linearLayout3=root.findViewById(R.id.linearLayout3);
        linearLayout4=root.findViewById(R.id.linearLayout4);

        final long ONE_MEGABYTE = 1024 * 1024 * 5;




        for (int i = 0; i < num; i++) {
            LinearLayout linearLayoutx = new LinearLayout(getContext());
            linearLayoutx.setOrientation(LinearLayout.VERTICAL);
            ImageView imageView = new ImageView(getContext());
            imageViews.add(imageView);
            TextView title = new TextView(getContext());
            textViews.add(title);
            title.setTextSize(20);
            LinearLayout linearLayout1 = new LinearLayout(getContext());
            TextView cantin = new TextView(getContext());
            restNameText.add(cantin);
            linearLayoutx.addView(imageView);
            linearLayoutx.addView(title);
            linearLayout1.addView(cantin);
            imageView.setAdjustViewBounds(true);

            if (isOdd(i)){
                linearLayout3.addView(linearLayoutx);
                linearLayout3.addView(linearLayout1);
            }
            else {
                linearLayout4.addView(linearLayoutx);
                linearLayout4.addView(linearLayout1);
            }

            linearLayoutx.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), RestaurantActivity.class);
                    intent.putExtra("restName", xicandian1.getText());
                    intent.putExtra("type", xicandian1.getText());
                    intent.putExtra("type", xicandian1.getText());
                    intent.putExtra("type", xicandian1.getText());
                    intent.putExtra("type", xicandian1.getText());
                    intent.putExtra("type", xicandian1.getText());
                    intent.putExtra("type", xicandian1.getText());
                    intent.putExtra("type", xicandian1.getText());
                    intent.putExtra("type", xicandian1.getText());
                    startActivity(intent);
                }
            });




            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for(DataSnapshot pair : snapshot.child("Restaurant").getChildren()){
                        arrayList1.add(pair.child("title").getValue().toString());
                        restName.add(pair.child("restaurantName").getValue().toString());
                    }
                    System.out.println(arrayList1.toString());
                    for (int i = 0; i < textViews.size(); i++) {
                        textViews.get(i).setText(arrayList1.get(i));
                        restNameText.get(i).setText(restName.get(i));
                        imageViews.get(i).setTag(restName.get(i));
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        }



        StorageReference listRef = storage.getReference();

        System.out.println("wwwwwwwwwwwwwwwwwwwww");
        listRef.listAll()
                .addOnSuccessListener(new OnSuccessListener<ListResult>() {
                    @Override
                    public void onSuccess(ListResult listResult) {
                        for (StorageReference prefix : listResult.getPrefixes()) {
                            System.out.println("text1////"+prefix.getPath());
                            for (int i = 0; i < imageViews.size(); i++) {
                                if (prefix.getPath().equals("/"+imageViews.get(i).getTag())){
                                    System.out.println("text3//////"+prefix.getPath());
                                    prefix.listAll().addOnSuccessListener(new OnSuccessListener<ListResult>() {
                                        @Override
                                        public void onSuccess(ListResult listResult) {
                                            for (StorageReference item : listResult.getItems()) {
                                                item.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                                                    @Override
                                                    public void onSuccess(byte[] bytes) {
                                                        for (int j = 0; j < imageViews.size(); j++) {
                                                            if (item.getPath().contains(imageViews.get(j).getTag().toString())){
                                                                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                                                                imageViews.get(j).setImageBitmap(bitmap);
                                                            }
                                                        }
                                                    }
                                                });
                                            }
                                        }
                                    });
                                }
                            }
                        }

                        for (StorageReference item : listResult.getItems()) {
                            if (item.getPath().contains("大中国")){
                                System.out.println("text2////"+item.getPath());
                            }
                            storageReferences.add(item);
                            referenceName.add(item.getPath());
                            //System.out.println(referenceName);
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        System.out.println(e);
                    }
                });





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



        return root;
    }

    public boolean isOdd(int a){
        if((a&1) != 1){
            return true;
        }
        return false;
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