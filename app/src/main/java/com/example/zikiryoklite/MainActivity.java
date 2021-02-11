package com.example.zikiryoklite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String[] Zikir= {
        "Istigfar",
        "Tasbih",
        "Tahmid",
        "Tahlil",
        "Takbir"
    };
    Button btStart;
    ViewPager viewPager;
    Adapter adapter;
    List<Model> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        models = new ArrayList<>();
        models.add((new Model(" [Al-Insân: 25]", "Dan berdzikirlah (dengan menyebut) nama Rabb-mu pada pagi dan petang")));
        models.add((new Model(" [Al-Anfâl: 45]", "Wahai orang-orang yang beriman, apabila kalian memerangi pasukan (musuh), berteguhhatilah kalian dan berdzikirlah kepada Allah sebanyak-banyaknya agar kalian beruntung")));
        models.add((new Model(" [An-Najm: 29]", "Maka berpalinglah engkau dari orang yang berpaling dari dzikir kepada Kami dan tidak menginginkan (apa-apa), kecuali kehidupan duniawi")));
        models.add((new Model(" [Ali Imrân: 41]", "Dan berdzikirlah kepada Rabb-mu sebanyak-banyaknya serta bertasbihlah pada petang dan pagi hari.")));

        adapter = new Adapter(models, this);

        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130, 0, 130, 0);

        btStart = findViewById(R.id.bt_start);

        btStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialogbox = new AlertDialog.Builder(MainActivity.this);
                dialogbox.setTitle("Pilihan Zikir");
                dialogbox.setItems(Zikir,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent;
                                switch (id){
                                    case 0:
                                        intent = new Intent(MainActivity.this, ZikirActivity.class);
                                        intent.putExtra("title", "Istigfar");
                                        startActivity(intent);
                                    break;
                                    case 1:
                                        intent = new Intent(MainActivity.this, ZikirActivity.class);
                                        intent.putExtra("title", "Tasbih");
                                        startActivity(intent);
                                        break;
                                    case 2:
                                        intent = new Intent(MainActivity.this, ZikirActivity.class);
                                        intent.putExtra("title", "Tahmid");
                                        startActivity(intent);
                                        break;
                                    case 3:
                                        intent = new Intent(MainActivity.this, ZikirActivity.class);
                                        intent.putExtra("title", "Tahlil");
                                        startActivity(intent);
                                        break;
                                    case 4:
                                        intent = new Intent(MainActivity.this, ZikirActivity.class);
                                        intent.putExtra("title", "Takbir");
                                        startActivity(intent);
                                        break;
                                }
                            }
                        });
                dialogbox.create().show();
            }
        });
//        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                if(position < (adapter.getCount() - 1) && position < (colors.length - 1)){
//                    viewPager.setBackgroundColor(
//
//                            (Integer) argbEvaluator.evaluate(
//                                    positionOffset,
//                                    colors[position],
//                                    colors[position + 1]
//                            )
//                    );
//                }else{
//                    viewPager.setBackgroundColor((colors[colors.length - 1]));
//                }
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
    }
}