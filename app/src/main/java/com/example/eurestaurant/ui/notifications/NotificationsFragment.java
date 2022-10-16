package com.example.eurestaurant.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.eurestaurant.R;
import com.example.eurestaurant.databinding.FragmentNotificationsBinding;
import com.example.eurestaurant.ui.AddRestaurant;
import com.example.eurestaurant.ui.LoginActivity1;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;
    private String username;
    private TextView username1;
    private TextView username2;
    private Button esc;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Intent getIntent = getActivity().getIntent();
        username = getIntent.getStringExtra("username");

        username1=root.findViewById(R.id.textView58);
        username2=root.findViewById(R.id.textView59);
        esc=root.findViewById(R.id.button61);
        username1.setText("您已登录为:");
        username2.setText(username);

        esc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onDestroyView();
                Intent intent = new Intent(getActivity(), LoginActivity1.class);
                startActivity(intent);
            }
        });


        //final TextView textView = binding.textNotifications;
        //notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}