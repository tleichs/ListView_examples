package com.tiagoleichs.listview_examples;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void go(View v){
        Intent intent = new Intent(MainActivity.this, ThreeLayouts.class);
        startActivity(intent);
    }
    public void go2(View v){
        Intent intent = new Intent(MainActivity.this, TwoViews.class);
        startActivity(intent);
    }

    public void go3(View v){
        Intent intent = new Intent(MainActivity.this, SimpleListViewExample.class);
        startActivity(intent);
    }

    public void go4(View v){
        Intent intent = new Intent(MainActivity.this, Multiple.class);
        startActivity(intent);
    }

    public void go5(View v){
        Intent intent = new Intent(MainActivity.this, EditTextListView.class);
        startActivity(intent);
    }

    public void go6(View v){
        Intent intent = new Intent(MainActivity.this, HeterogenousListActivity.class);
        startActivity(intent);
    }
}
