package com.example.eurestaurant.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.eurestaurant.R;
import com.example.eurestaurant.databinding.FragmentHomeBinding;
import com.example.eurestaurant.ui.CountryActivity;
import com.example.eurestaurant.ui.RestaurantActivity;
import com.example.eurestaurant.ui.TypesActivity;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private LinearLayout linearLayout;
    private ImageView imageView;
    private TextView more;
    private TextView textView;

    private LinearLayout xicandian;
    private LinearLayout fandian;
    private LinearLayout shangdian;
    private LinearLayout jingdian;
    private LinearLayout lvdian;
    private LinearLayout bowuguan;
    private LinearLayout jiaotong;
    private LinearLayout gengduofenlei;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        linearLayout=root.findViewById(R.id.linearLayoutMax);
        imageView=root.findViewById(R.id.imageView1);
        more=root.findViewById(R.id.more20);
        textView=root.findViewById(R.id.textView7);
        xicandian=root.findViewById(R.id.linearLayout1);

        xicandian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TypesActivity.class);
                startActivity(intent);
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RestaurantActivity.class);
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

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CountryActivity.class);
                startActivity(intent);
            }
        });


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