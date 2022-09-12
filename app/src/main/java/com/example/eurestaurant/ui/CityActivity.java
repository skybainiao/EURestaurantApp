package com.example.eurestaurant.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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
    private Button button9;
    private Button button10;
    private Button button11;
    private Button button12;
    private Button button13;
    private Button button14;
    private Button button15;
    private Button button16;
    private Button button17;
    private Button button18;
    private Button button19;
    private Button button20;
    private Button button21;
    private Button button22;
    private Button button23;
    private Button button24;
    private Button button25;
    private Button button26;
    private Button button27;
    private Button button28;
    private Button button29;
    private Button button30;
    private Button button31;
    private Button button32;
    private Button button33;
    private Button button34;
    private Button button35;
    private Button button36;


    private String countryName;
    private TextView textView;
    private ImageView back1;

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
        back1=findViewById(R.id.imageViewBack1);
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

        button9=findViewById(R.id.button30);
        button10=findViewById(R.id.button32);
        button11=findViewById(R.id.button34);
        button12=findViewById(R.id.button36);
        button13=findViewById(R.id.button38);
        button14=findViewById(R.id.button40);
        button15=findViewById(R.id.button42);
        button16=findViewById(R.id.button44);
        button17=findViewById(R.id.button46);
        button18=findViewById(R.id.button48);
        button19=findViewById(R.id.button50);
        button20=findViewById(R.id.button52);
        button21=findViewById(R.id.button54);
        button22=findViewById(R.id.button56);

        button23=findViewById(R.id.button31);
        button24=findViewById(R.id.button33);
        button25=findViewById(R.id.button35);
        button26=findViewById(R.id.button37);
        button27=findViewById(R.id.button39);
        button28=findViewById(R.id.button41);
        button29=findViewById(R.id.button43);
        button30=findViewById(R.id.button45);
        button31=findViewById(R.id.button47);
        button32=findViewById(R.id.button49);
        button33=findViewById(R.id.button51);
        button34=findViewById(R.id.button53);
        button35=findViewById(R.id.button55);
        button36=findViewById(R.id.button57);


        buttons.add(button1);
        buttons.add(button2);
        buttons.add(button3);
        buttons.add(button4);
        buttons.add(button5);
        buttons.add(button6);
        buttons.add(button7);
        buttons.add(button8);
        buttons.add(button9);
        buttons.add(button10);
        buttons.add(button11);
        buttons.add(button12);
        buttons.add(button13);
        buttons.add(button14);
        buttons.add(button15);
        buttons.add(button16);
        buttons.add(button17);
        buttons.add(button18);
        buttons.add(button19);
        buttons.add(button20);
        buttons.add(button21);
        buttons.add(button22);
        buttons.add(button23);
        buttons.add(button24);
        buttons.add(button25);
        buttons.add(button26);
        buttons.add(button27);
        buttons.add(button28);
        buttons.add(button29);
        buttons.add(button30);
        buttons.add(button31);
        buttons.add(button32);
        buttons.add(button33);
        buttons.add(button34);
        buttons.add(button35);
        buttons.add(button36);


        int size = citiesKind.size();
        getButtons(size);

        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



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
        else if (number==13){
            button1.setText(citiesKind.get(0));
            button5.setText(citiesKind.get(1));
            button2.setText(citiesKind.get(2));
            button6.setText(citiesKind.get(3));
            button3.setText(citiesKind.get(4));
            button7.setText(citiesKind.get(5));
            button4.setText(citiesKind.get(6));
            button8.setText(citiesKind.get(7));
            button9.setText(citiesKind.get(8));
            button23.setText(citiesKind.get(9));
            button10.setText(citiesKind.get(10));
            button24.setText(citiesKind.get(11));
            button11.setText(citiesKind.get(12));
        }
        else if (number==33){
            button1.setText(citiesKind.get(0));
            button5.setText(citiesKind.get(1));
            button2.setText(citiesKind.get(2));
            button6.setText(citiesKind.get(3));
            button3.setText(citiesKind.get(4));
            button7.setText(citiesKind.get(5));
            button4.setText(citiesKind.get(6));
            button8.setText(citiesKind.get(7));
            button9.setText(citiesKind.get(8));
            button23.setText(citiesKind.get(9));
            button10.setText(citiesKind.get(10));
            button24.setText(citiesKind.get(11));
            button11.setText(citiesKind.get(12));
            button25.setText(citiesKind.get(13));
            button12.setText(citiesKind.get(14));
            button26.setText(citiesKind.get(15));
            button13.setText(citiesKind.get(16));
            button27.setText(citiesKind.get(17));
            button14.setText(citiesKind.get(18));
            button28.setText(citiesKind.get(19));
            button15.setText(citiesKind.get(20));
            button29.setText(citiesKind.get(21));
            button16.setText(citiesKind.get(22));
            button30.setText(citiesKind.get(23));
            button17.setText(citiesKind.get(24));
            button31.setText(citiesKind.get(25));
            button18.setText(citiesKind.get(26));
            button32.setText(citiesKind.get(27));
            button19.setText(citiesKind.get(28));
            button33.setText(citiesKind.get(29));
            button20.setText(citiesKind.get(30));
            button34.setText(citiesKind.get(31));
            button21.setText(citiesKind.get(32));

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
        cities.add(new City("诺丁汉","英国"));
        cities.add(new City("纽卡斯尔","英国"));
        cities.add(new City("利兹","英国"));
        cities.add(new City("格拉斯哥","英国"));
        cities.add(new City("布里斯托","英国"));
        cities.add(new City("谢菲尔德","英国"));


        cities.add(new City("戛纳","法国"));
        cities.add(new City("马赛","法国"));
        cities.add(new City("里昂","法国"));
        cities.add(new City("波尔多","法国"));
        cities.add(new City("普罗旺斯","法国"));
        cities.add(new City("巴黎","法国"));
        cities.add(new City("图卢兹","法国"));
        cities.add(new City("尼斯","法国"));

        cities.add(new City("巴塞罗那","西班牙"));
        cities.add(new City("马德里","西班牙"));
        cities.add(new City("格拉纳达","西班牙"));
        cities.add(new City("塞维利亚","西班牙"));
        cities.add(new City("瓦伦西亚","西班牙"));
        cities.add(new City("马拉加","西班牙"));

        cities.add(new City("罗马","意大利"));
        cities.add(new City("威尼斯","意大利"));
        cities.add(new City("米兰","意大利"));
        cities.add(new City("佛罗伦萨","意大利"));
        cities.add(new City("那不勒斯","意大利"));
        cities.add(new City("都灵","意大利"));
        cities.add(new City("热那亚","意大利"));
        cities.add(new City("维罗纳","意大利"));

        cities.add(new City("慕尼黑","德国"));
        cities.add(new City("法兰克福","德国"));
        cities.add(new City("斯图加特","德国"));
        cities.add(new City("海德堡","德国"));
        cities.add(new City("科隆","德国"));
        cities.add(new City("杜塞尔多夫","德国"));
        cities.add(new City("柏林","德国"));
        cities.add(new City("不来梅","德国"));
        cities.add(new City("雷根斯堡","德国"));
        cities.add(new City("罗斯托克","德国"));
        cities.add(new City("富来斯堡","德国"));
        cities.add(new City("吕别克","德国"));
        cities.add(new City("弗赖堡","德国"));
        cities.add(new City("马格德堡","德国"));
        cities.add(new City("亚琛","德国"));
        cities.add(new City("基尔","德国"));
        cities.add(new City("开姆尼茨","德国"));
        cities.add(new City("不伦瑞克","德国"));
        cities.add(new City("奥格斯堡","德国"));
        cities.add(new City("曼海姆","德国"));
        cities.add(new City("卡尔斯鲁厄","德国"));
        cities.add(new City("明斯特","德国"));
        cities.add(new City("波恩","德国"));
        cities.add(new City("比费尔德","德国"));
        cities.add(new City("伍珀塔尔","德国"));
        cities.add(new City("波鸿","德国"));
        cities.add(new City("杜伊斯堡","德国"));
        cities.add(new City("纽伦堡","德国"));
        cities.add(new City("汉诺威","德国"));
        cities.add(new City("德累斯顿 ","德国"));
        cities.add(new City("莱比锡","德国"));
        cities.add(new City("埃森","德国"));
        cities.add(new City("多特蒙德","德国"));


        cities.add(new City("阿姆斯特丹","荷兰"));
        cities.add(new City("海牙","荷兰"));
        cities.add(new City("鹿特丹","荷兰"));
        cities.add(new City("格罗宁根","荷兰"));
        cities.add(new City("乌特勒支","荷兰"));

        cities.add(new City("哥本哈根","丹麦"));
        cities.add(new City("奥胡斯","丹麦"));
        cities.add(new City("欧登塞","丹麦"));

        cities.add(new City("斯德哥尔摩","瑞典"));
        cities.add(new City("哥德堡","瑞典"));
        cities.add(new City("马尔默","瑞典"));
        cities.add(new City("乌普萨拉","瑞典"));

        cities.add(new City("赫尔辛基","芬兰"));

        cities.add(new City("奥斯陆","挪威"));
        cities.add(new City("卑尔根","瑞典"));
        cities.add(new City("斯塔万格","瑞典"));

        cities.add(new City("雷克雅未克","冰岛"));

        cities.add(new City("维也纳","奥地利"));
        cities.add(new City("萨尔斯堡","奥地利"));
        cities.add(new City("因斯布鲁克","奥地利"));

        cities.add(new City("布鲁塞尔","比利时"));
        cities.add(new City("根特","比利时"));
        cities.add(new City("安特卫普","比利时"));

        cities.add(new City("苏黎世","瑞士"));
        cities.add(new City("日内瓦","瑞士"));
        cities.add(new City("洛桑","瑞士"));
        cities.add(new City("琉森","瑞士"));

        cities.add(new City("伊斯坦布尔","土耳其"));

        cities.add(new City("雅典","希腊"));

        cities.add(new City("布拉格","捷克"));
        cities.add(new City("布达佩斯","匈牙利"));
        cities.add(new City("华沙","波兰"));
        cities.add(new City("波兹南","波兰"));
        cities.add(new City("格但斯克","波兰"));
        cities.add(new City("斯布雷特","克罗地亚"));
        cities.add(new City("布拉迪斯拉发","斯洛伐克"));
        cities.add(new City("卢布尔雅那","斯洛文尼亚"));
        cities.add(new City("贝尔格莱德","塞尔维亚"));
        cities.add(new City("布加勒斯特","罗马尼亚"));
        cities.add(new City("布拉迪斯拉发","克罗地亚"));
        cities.add(new City("索菲亚","保加利亚"));
        cities.add(new City("塔林","爱沙尼亚"));
        cities.add(new City("里加","拉脱维亚"));
        cities.add(new City("维尔纽斯","立陶宛"));
        cities.add(new City("莫斯科","俄罗斯"));
        cities.add(new City("圣彼得堡","俄罗斯"));
        cities.add(new City("明斯克","白俄罗斯"));
        cities.add(new City("基辅","乌克兰"));
        cities.add(new City("第比利斯","格鲁吉亚"));
        cities.add(new City("巴库","阿塞拜疆"));
        cities.add(new City("都柏林","爱尔兰"));
        cities.add(new City("卢森堡","卢森堡"));
        cities.add(new City("摩纳哥","摩纳哥"));
        cities.add(new City("地拉那","阿尔巴尼亚"));
        cities.add(new City("里斯本","葡萄牙"));




        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i).getCountry().equals(countryName)){
                citiesKind.add(cities.get(i).getName());
            }
        }


    }















}