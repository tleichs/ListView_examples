package com.tiagoleichs.listview_examples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class HeterogenousListActivity extends AppCompatActivity {

    private ListView lvColors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heterogenous_list);

        lvColors = (ListView) findViewById(R.id.lvColors);
        ArrayList<SimpleColors> aColors = new ArrayList<SimpleColors>();
        // Populate colors into the array
        aColors.add(new SimpleColors("Bl", SimpleColors.ColorValues.BLUE));
        aColors.add(new SimpleColors("Red", SimpleColors.ColorValues.RED));
        aColors.add(new SimpleColors("Green", SimpleColors.ColorValues.GREEN));
        // Attach the adapter
        ColorArrayAdapter adapterColors = new ColorArrayAdapter(this, aColors);
        lvColors.setAdapter(adapterColors);
    }
}
