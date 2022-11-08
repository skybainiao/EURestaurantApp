package com.example.eurestaurant.ui.home;

import android.content.Context;
import android.content.Intent;
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
import com.example.eurestaurant.Model.Pic;
import com.example.eurestaurant.R;
import com.example.eurestaurant.databinding.FragmentHomeBinding;
import com.example.eurestaurant.ui.AddRestaurant;
import com.example.eurestaurant.ui.ChooseUploadType;
import com.example.eurestaurant.ui.CountryActivity;
import com.example.eurestaurant.ui.RestaurantActivity;
import com.example.eurestaurant.ui.TypesActivity;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private LinearLayout linearLayout;
    private ImageView imageView;
    private TextView more;
    private TextView textView;
    private Context mContext;
    private GridView grid_photo;
    private BaseAdapter mAdapter = null;
    private ArrayList<Pic> mData = null;

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

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mContext = getContext();
        grid_photo = (GridView) root.findViewById(R.id.grid_photo);

        mData = new ArrayList<Pic>();
        mData.add(new Pic(R.mipmap.b, "大中国餐馆"));
        mData.add(new Pic(R.mipmap.iv_icon_2, "图标2"));
        mData.add(new Pic(R.mipmap.iv_icon_3, "图标3"));
        mData.add(new Pic(R.mipmap.iv_icon_4, "图标4"));
        mData.add(new Pic(R.mipmap.iv_icon_5, "图标5"));
        mData.add(new Pic(R.mipmap.iv_icon_6, "图标6"));
        mData.add(new Pic(R.mipmap.iv_icon_7, "图标7"));
        mData.add(new Pic(R.mipmap.iv_icon_7, "图标7"));
        mData.add(new Pic(R.mipmap.iv_icon_7, "图标7"));
        mData.add(new Pic(R.mipmap.iv_icon_7, "图标7"));
        mData.add(new Pic(R.mipmap.iv_icon_7, "图标7"));
        mData.add(new Pic(R.mipmap.iv_icon_7, "图标7"));
        mData.add(new Pic(R.mipmap.iv_icon_7, "图标7"));

        mAdapter = new MyAdapter<Pic>(mData, R.layout.item_grid_icon) {
            @Override
            public void bindView(ViewHolder holder, Pic obj) {
                holder.setImageResource(R.id.img_icon, obj.getId());
                holder.setText(R.id.txt_icon, obj.getName());
            }
        };

        grid_photo.setAdapter(mAdapter);

        grid_photo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mContext, "你点击了~" + position + "~项", Toast.LENGTH_SHORT).show();
            }
        });


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


    public void getMoreCities(){

    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}