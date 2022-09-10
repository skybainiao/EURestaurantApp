package com.example.eurestaurant.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.eurestaurant.R;
import com.example.eurestaurant.databinding.FragmentHomeBinding;
import com.example.eurestaurant.ui.CountryActivity;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private LinearLayout linearLayout;
    private ImageView imageView;
    private TextView more;
    private TextView textView;

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