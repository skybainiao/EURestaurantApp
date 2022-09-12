package com.example.eurestaurant.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.eurestaurant.Model.Country;
import com.example.eurestaurant.R;

import java.util.ArrayList;

public class CountryActivity extends AppCompatActivity {

    private ImageView back;
    private Button BeiOu;
    private Button XiOu;
    private Button ZhongOu;
    private Button NanOu;
    private Button DongOu;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button10;
    private Button button11;
    private Button button12;
    private Button button13;
    private Button button14;
    private Button button15;
    private Button button16;



    private ArrayList<Country> countries = new ArrayList<>();
    private ArrayList<Country> beiou = new ArrayList();
    private ArrayList<Country> xiou = new ArrayList();
    private ArrayList<Country> zhongou = new ArrayList();
    private ArrayList<Country> nanou = new ArrayList();
    private ArrayList<Country> dongou = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        setCountry();

        BeiOu=findViewById(R.id.button8);
        XiOu=findViewById(R.id.button9);
        ZhongOu=findViewById(R.id.button10);
        NanOu=findViewById(R.id.button11);
        DongOu=findViewById(R.id.button12);
        back=findViewById(R.id.imageViewBack);
        button1=findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button7);
        button5=findViewById(R.id.button14);
        button6=findViewById(R.id.button4);
        button7=findViewById(R.id.button5);
        button8=findViewById(R.id.button6);
        button9=findViewById(R.id.button13);
        button10=findViewById(R.id.button15);

        button11=findViewById(R.id.button25);
        button12=findViewById(R.id.button27);
        button13=findViewById(R.id.button29);

        button14=findViewById(R.id.button24);
        button15=findViewById(R.id.button26);
        button16=findViewById(R.id.button28);



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        BeiOu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonVisibleOn();
                button1.setText(beiou.get(0).getName());
                button2.setText(beiou.get(1).getName());
                button3.setText(beiou.get(2).getName());
                button6.setText(beiou.get(3).getName());
                button7.setText(beiou.get(4).getName());
                button4.setVisibility(View.GONE);
                button5.setVisibility(View.GONE);
                button8.setVisibility(View.GONE);
                button9.setVisibility(View.GONE);
                button10.setVisibility(View.GONE);
                button11.setVisibility(View.GONE);
                button12.setVisibility(View.GONE);
                button13.setVisibility(View.GONE);
                button14.setVisibility(View.GONE);
                button15.setVisibility(View.GONE);
                button16.setVisibility(View.GONE);
            }
        });

        XiOu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonVisibleOn();
                button1.setText(xiou.get(0).getName());
                button2.setText(xiou.get(1).getName());
                button3.setText(xiou.get(2).getName());
                button4.setText(xiou.get(3).getName());
                button6.setText(xiou.get(4).getName());
                button7.setText(xiou.get(5).getName());
                button8.setText(xiou.get(6).getName());
                button5.setVisibility(View.GONE);
                button9.setVisibility(View.GONE);
                button10.setVisibility(View.GONE);
                button11.setVisibility(View.GONE);
                button12.setVisibility(View.GONE);
                button13.setVisibility(View.GONE);
                button14.setVisibility(View.GONE);
                button15.setVisibility(View.GONE);
                button16.setVisibility(View.GONE);
            }
        });

        ZhongOu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonVisibleOn();
                button1.setText(zhongou.get(0).getName());
                button2.setText(zhongou.get(1).getName());
                button3.setText(zhongou.get(2).getName());
                button4.setText(zhongou.get(3).getName());
                button6.setText(zhongou.get(4).getName());
                button7.setText(zhongou.get(5).getName());
                button8.setText(zhongou.get(6).getName());
                button5.setVisibility(View.GONE);
                button9.setVisibility(View.GONE);
                button10.setVisibility(View.GONE);
                button11.setVisibility(View.GONE);
                button12.setVisibility(View.GONE);
                button13.setVisibility(View.GONE);
                button14.setVisibility(View.GONE);
                button15.setVisibility(View.GONE);
                button16.setVisibility(View.GONE);
            }
        });

        NanOu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonVisibleOn();
                button1.setText(nanou.get(0).getName());
                button2.setText(nanou.get(1).getName());
                button3.setText(nanou.get(2).getName());
                button4.setText(nanou.get(3).getName());
                button5.setText(nanou.get(4).getName());
                button6.setText(nanou.get(5).getName());
                button7.setText(nanou.get(6).getName());
                button8.setText(nanou.get(7).getName());
                button9.setText(nanou.get(8).getName());
                button10.setText(nanou.get(9).getName());
                button11.setVisibility(View.GONE);
                button12.setVisibility(View.GONE);
                button13.setVisibility(View.GONE);
                button14.setVisibility(View.GONE);
                button15.setVisibility(View.GONE);
                button16.setVisibility(View.GONE);
            }
        });

        DongOu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonVisibleOn();
                button1.setText(dongou.get(0).getName());
                button2.setText(dongou.get(1).getName());
                button3.setText(dongou.get(2).getName());
                button6.setText(dongou.get(3).getName());
                button7.setText(dongou.get(4).getName());
                button4.setText(dongou.get(5).getName());
                button5.setText(dongou.get(6).getName());
                button8.setText(dongou.get(7).getName());
                button9.setText(dongou.get(8).getName());
                button10.setText(dongou.get(9).getName());
                button11.setText(dongou.get(10).getName());
                button14.setText(dongou.get(11).getName());
                button12.setText(dongou.get(12).getName());
                button15.setText(dongou.get(13).getName());
                button13.setVisibility(View.GONE);
                button16.setVisibility(View.GONE);
            }
        });



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CountryActivity.this,CityActivity.class);
                intent.putExtra("countryName", button1.getText());
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CountryActivity.this,CityActivity.class);
                intent.putExtra("countryName", button2.getText());
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CountryActivity.this,CityActivity.class);
                intent.putExtra("countryName", button3.getText());
                startActivity(intent);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CountryActivity.this,CityActivity.class);
                intent.putExtra("countryName", button4.getText());
                startActivity(intent);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CountryActivity.this,CityActivity.class);
                intent.putExtra("countryName", button5.getText());
                startActivity(intent);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CountryActivity.this,CityActivity.class);
                intent.putExtra("countryName", button6.getText());
                startActivity(intent);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CountryActivity.this,CityActivity.class);
                intent.putExtra("countryName", button7.getText());
                startActivity(intent);
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CountryActivity.this,CityActivity.class);
                intent.putExtra("countryName", button8.getText());
                startActivity(intent);
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CountryActivity.this,CityActivity.class);
                intent.putExtra("countryName", button9.getText());
                startActivity(intent);
            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CountryActivity.this,CityActivity.class);
                intent.putExtra("countryName", button10.getText());
                startActivity(intent);
            }
        });
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CountryActivity.this,CityActivity.class);
                intent.putExtra("countryName", button11.getText());
                startActivity(intent);
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CountryActivity.this,CityActivity.class);
                intent.putExtra("countryName", button12.getText());
                startActivity(intent);
            }
        });
        button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CountryActivity.this,CityActivity.class);
                intent.putExtra("countryName", button14.getText());
                startActivity(intent);
            }
        });
        button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CountryActivity.this,CityActivity.class);
                intent.putExtra("countryName", button15.getText());
                startActivity(intent);
            }
        });




    }


    public void buttonVisibleOn(){
        button1.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);
        button4.setVisibility(View.VISIBLE);
        button5.setVisibility(View.VISIBLE);
        button6.setVisibility(View.VISIBLE);
        button7.setVisibility(View.VISIBLE);
        button8.setVisibility(View.VISIBLE);
        button9.setVisibility(View.VISIBLE);
        button10.setVisibility(View.VISIBLE);
        button11.setVisibility(View.VISIBLE);
        button12.setVisibility(View.VISIBLE);
        button13.setVisibility(View.VISIBLE);
        button14.setVisibility(View.VISIBLE);
        button15.setVisibility(View.VISIBLE);
        button16.setVisibility(View.VISIBLE);
    }


    public void setCountry(){
        countries.add(new Country("芬兰","北欧"));
        countries.add(new Country("瑞典","北欧"));
        countries.add(new Country("挪威","北欧"));
        countries.add(new Country("冰岛","北欧"));
        countries.add(new Country("丹麦","北欧"));

        countries.add(new Country("爱沙尼亚","东欧"));
        countries.add(new Country("拉脱维亚","东欧"));
        countries.add(new Country("立陶宛","东欧"));
        countries.add(new Country("白俄罗斯","东欧"));
        countries.add(new Country("捷克","东欧"));
        countries.add(new Country("匈牙利","东欧"));
        countries.add(new Country("波兰","东欧"));
        countries.add(new Country("克罗地亚","东欧"));
        countries.add(new Country("斯洛文尼亚","东欧"));
        countries.add(new Country("保加利亚","东欧"));
        countries.add(new Country("俄罗斯","东欧"));
        countries.add(new Country("乌克兰","东欧"));
        countries.add(new Country("格鲁吉亚","东欧"));
        countries.add(new Country("阿塞拜疆","东欧"));

        countries.add(new Country("波兰","中欧"));
        countries.add(new Country("捷克","中欧"));
        countries.add(new Country("斯洛伐克","中欧"));
        countries.add(new Country("匈牙利","中欧"));
        countries.add(new Country("德国","中欧"));
        countries.add(new Country("奥地利","中欧"));
        countries.add(new Country("瑞士","中欧"));

        countries.add(new Country("英国","西欧"));
        countries.add(new Country("爱尔兰","西欧"));
        countries.add(new Country("荷兰","西欧"));
        countries.add(new Country("比利时","西欧"));
        countries.add(new Country("卢森堡","西欧"));
        countries.add(new Country("法国","西欧"));
        countries.add(new Country("摩纳哥","西欧"));

        countries.add(new Country("罗马尼亚","南欧"));
        countries.add(new Country("保加利亚","南欧"));
        countries.add(new Country("塞尔维亚","南欧"));
        countries.add(new Country("阿尔巴尼亚","南欧"));
        countries.add(new Country("希腊","南欧"));
        countries.add(new Country("克罗地亚","南欧"));
        countries.add(new Country("意大利","南欧"));
        countries.add(new Country("西班牙","南欧"));
        countries.add(new Country("葡萄牙","南欧"));
        countries.add(new Country("土耳其","南欧"));

        for (int i = 0; i < countries.size(); i++) {
            if (countries.get(i).getContinent().equals("西欧")){
                xiou.add(countries.get(i));
            }
            else if (countries.get(i).getContinent().equals("北欧")){
                beiou.add(countries.get(i));
            }
            else if (countries.get(i).getContinent().equals("中欧")){
                zhongou.add(countries.get(i));
            }
            else if (countries.get(i).getContinent().equals("南欧")){
                nanou.add(countries.get(i));
            }
            else if (countries.get(i).getContinent().equals("东欧")){
                dongou.add(countries.get(i));
            }
        }

    }



}