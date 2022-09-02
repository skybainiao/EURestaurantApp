package com.example.eurestaurant.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.eurestaurant.R;
import com.example.eurestaurant.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private LinearLayout linearLayout;
    private ImageView imageView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);


        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        linearLayout=root.findViewById(R.id.linearLayoutMax);
        imageView=root.findViewById(R.id.imageView1);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView textView = new TextView(getContext());
                LinearLayout linearLayout2 = new LinearLayout(getContext());
                linearLayout2.addView(textView);
                linearLayout.addView(linearLayout2);


                textView.setText("I/AdrenoGLES-0: QUALCOMM build                   : 42297a4, I9e9b240040\n" +
                        "    Build Date                       : 03/19/21\n" +
                        "    OpenGL ES Shader Compiler Version: EV031.32.02.07\n" +
                        "    Local Branch                     : \n" +
                        "    Remote Branch                    : refs/tags/AU_LINUX_ANDROID_LA.UM.9.1.R1.11.00.00.604.070\n" +
                        "    Remote Branch                    : NONE\n" +
                        "    Reconstruct Branch               : NOTHING\n" +
                        "I/AdrenoGLES-0: Build Config                     : S P 10.0.6 AArch64\n" +
                        "I/AdrenoGLES-0: Driver Path                      : /vendor/lib64/egl/libGLESv2_adreno.so\n" +
                        "I/AdrenoGLES-0: PFP: 0x016ee190, ME: 0x00000000\n" +
                        "V/MiuiFrameworkFactory: get AllImpl object = android.common.MiuiFrameworkFactoryImpl@98bc3ee\n" +
                        "W/MirrorManager: this model don't Support\n" +
                        "I/le.eurestauran: ProcessProfilingInfo new_methods=2250 is saved saved_to_disk=1 resolve_classes_delay=8000\n");
            }
        });



        return root;
    }






    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}