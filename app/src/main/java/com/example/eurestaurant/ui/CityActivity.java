package com.example.eurestaurant.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.eurestaurant.Model.City;
import com.example.eurestaurant.R;

import java.util.ArrayList;

public class CityActivity extends AppCompatActivity {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private String countryName;
    private TextView textView;

    private ArrayList<Button> buttons = new ArrayList<>();
    private ArrayList<City> cities = new ArrayList<>();
    private ArrayList<String> citiesKind = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        Intent getIntent = getIntent();
        countryName = getIntent.getStringExtra("countryName");
        setCities();
        System.out.println(countryName);
        for (int i = 0; i < citiesKind.size(); i++) {
            System.out.println(citiesKind.get(i));
        }

        textView=findViewById(R.id.textView13);
        textView.setText(countryName+"热门城市");
        button1=findViewById(R.id.button16);
        button2=findViewById(R.id.button18);
        button3=findViewById(R.id.button20);
        button4=findViewById(R.id.button22);
        button5=findViewById(R.id.button17);
        button6=findViewById(R.id.button19);
        button7=findViewById(R.id.button21);
        button8=findViewById(R.id.button23);

        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        buttons.add(button4);
        buttons.add(button5);
        buttons.add(button6);
        buttons.add(button7);
        buttons.add(button8);


        int size = citiesKind.size();
        getButtons(size);






    }


    public void getButtons(int number){
        if (number==0){
            //
        }
        else if (number==1){
            button1.setText(citiesKind.get(0));
        }
        else if (number==2){
            button1.setText(citiesKind.get(0));
            button5.setText(citiesKind.get(1));
        }
        else if (number==3){
            button1.setText(citiesKind.get(0));
            button5.setText(citiesKind.get(1));
            button2.setText(citiesKind.get(2));
        }
        else if (number==4){
            button1.setText(citiesKind.get(0));
            button5.setText(citiesKind.get(1));
            button2.setText(citiesKind.get(2));
            button6.setText(citiesKind.get(3));
        }
        else if (number==5){
            button1.setText(citiesKind.get(0));
            button5.setText(citiesKind.get(1));
            button2.setText(citiesKind.get(2));
            button6.setText(citiesKind.get(3));
            button3.setText(citiesKind.get(4));
        }
        else if (number==6){
            button1.setText(citiesKind.get(0));
            button5.setText(citiesKind.get(1));
            button2.setText(citiesKind.get(2));
            button6.setText(citiesKind.get(3));
            button3.setText(citiesKind.get(4));
            button7.setText(citiesKind.get(5));
        }
        else if (number==7){
            button1.setText(citiesKind.get(0));
            button5.setText(citiesKind.get(1));
            button2.setText(citiesKind.get(2));
            button6.setText(citiesKind.get(3));
            button3.setText(citiesKind.get(4));
            button7.setText(citiesKind.get(5));
            button4.setText(citiesKind.get(6));
        }
        else if (number==8){
            button1.setText(citiesKind.get(0));
            button5.setText(citiesKind.get(1));
            button2.setText(citiesKind.get(2));
            button6.setText(citiesKind.get(3));
            button3.setText(citiesKind.get(4));
            button7.setText(citiesKind.get(5));
            button4.setText(citiesKind.get(6));
            button8.setText(citiesKind.get(7));
        }

        for (int i = 0; i < buttons.size(); i++) {
            if (buttons.get(i).getText().equals("Button")){
                buttons.get(i).setVisibility(View.GONE);
            }
        }


    }



    public void setCities(){
        cities.add(new City("伦敦","英国"));
        cities.add(new City("爱丁堡","英国"));
        cities.add(new City("伯明翰","英国"));
        cities.add(new City("利物浦","英国"));
        cities.add(new City("牛津","英国"));
        cities.add(new City("剑桥","英国"));
        cities.add(new City("曼彻斯特","英国"));

        cities.add(new City("戛纳","法国"));
        cities.add(new City("马赛","法国"));
        cities.add(new City("里昂","法国"));
        cities.add(new City("波尔多","法国"));
        cities.add(new City("普罗旺斯","法国"));
        cities.add(new City("尼斯","法国"));

        cities.add(new City("巴塞罗那","西班牙"));
        cities.add(new City("马德里","西班牙"));
        cities.add(new City("格拉纳达","西班牙"));
        cities.add(new City("塞尔维亚","西班牙"));
        cities.add(new City("瓦伦西亚","西班牙"));

        cities.add(new City("罗马","意大利"));
        cities.add(new City("威尼斯","意大利"));
        cities.add(new City("米兰","意大利"));
        cities.add(new City("佛罗伦萨","意大利"));
        cities.add(new City("那不勒斯","意大利"));

        cities.add(new City("慕尼黑","德国"));
        cities.add(new City("法兰克福","德国"));
        cities.add(new City("斯图加特","德国"));
        cities.add(new City("海德堡","德国"));
        cities.add(new City("科隆","德国"));
        cities.add(new City("杜塞尔多夫","德国"));
        cities.add(new City("柏林","德国"));
        cities.add(new City("不来梅","德国"));

        cities.add(new City("阿姆斯特丹","荷兰"));
        cities.add(new City("海牙","荷兰"));
        cities.add(new City("鹿特丹","荷兰"));

        cities.add(new City("哥本哈根","丹麦"));
        cities.add(new City("奥胡斯","丹麦"));
        cities.add(new City("欧登塞","丹麦"));

        cities.add(new City("维也纳","奥地利"));
        cities.add(new City("萨尔斯堡","奥地利"));
        cities.add(new City("因斯布鲁克","奥地利"));

        cities.add(new City("苏黎世","瑞士"));
        cities.add(new City("日内瓦","瑞士"));
        cities.add(new City("洛桑","瑞士"));
        cities.add(new City("琉森","瑞士"));


        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i).getCountry().equals(countryName)){
                citiesKind.add(cities.get(i).getName());
            }
        }


    }















}