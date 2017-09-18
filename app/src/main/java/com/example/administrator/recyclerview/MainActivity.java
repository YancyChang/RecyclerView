package com.example.administrator.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Fruit> fruits=new ArrayList<Fruit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruit();
        Class test=FruitAdaptor.class;
        /*try {
            RecyclerView recyclerView2=(RecyclerView)findViewById(R.id.recycler_view);
            Class test1=Class.forName("FruitAdapter");
            Package p=test1.getPackage();
            try {
                try {
                    test1.getField("iname");

                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
                Method method=test1.getDeclaredMethod("setHeader",View.class);
                try {
                    method.invoke(test1.newInstance(),recyclerView2);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        //Class test2=recyclerView.getClass();
        FruitAdaptor fruitAdaptor=new FruitAdaptor(fruits);

        final LinearLayoutManager linearLayoutManager=new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(fruitAdaptor);
        recyclerView.scrollToPosition(fruits.size()-1);
        recyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });
        /*recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                //super.onScrollStateChanged(recyclerView, newState);
                switch (newState){
                    case RecyclerView.SCROLL_STATE_IDLE
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });*/
        //实例化header.xml并传入fruitAdapter
        //fruitAdaptor.setHeader(LayoutInflater.from(this).inflate(R.layout.header,null));
    }

    private void initFruit(){
        for(int i=0;i<3;i++){
            Fruit apple=new Fruit("apple",R.drawable.apple_pic);
            fruits.add(apple);
            Fruit banana=new Fruit("banana",R.drawable.banana_pic);
            fruits.add(banana);
            Fruit orange=new Fruit("orange",R.drawable.orange_pic);
            fruits.add(orange);
            Fruit pear=new Fruit("pear",R.drawable.pear_pic);
            fruits.add(pear);
            Fruit cherry=new Fruit("cherry",R.drawable.cherry_pic);
            fruits.add(cherry);
            Fruit grape=new Fruit("grape",R.drawable.grape_pic);
            fruits.add(grape);
            Fruit watermelon=new Fruit("watermelon",R.drawable.watermelon_pic);
            fruits.add(watermelon);
            Fruit pineapple=new Fruit("pineapple",R.drawable.pineapple_pic);
            fruits.add(pineapple);
            Fruit mango=new Fruit("mango",R.drawable.mango_pic);
            fruits.add(mango);
            Fruit strawberry=new Fruit("strawberry",R.drawable.strawberry_pic);
            fruits.add(strawberry);
        }
    }
}
