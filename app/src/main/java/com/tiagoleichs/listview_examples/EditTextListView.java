package com.tiagoleichs.listview_examples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class EditTextListView extends AppCompatActivity {

    private EditText edt;
    public ListView listview2;
    private Button btnEdt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittest);

         listview2 = (ListView) findViewById(R.id.lv);
        listview2.setItemsCanFocus(true);

        edt= findViewById(R.id.editText);

        btnEdt = findViewById(R.id.btnEdt);

        String[] value = new String[] { "Android", "iPhone", "WindowsMobile",
                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
                "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
                "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
                "Android", "iPhone", "WindowsMobile" };


        final HolderEditAdapter adapter = new HolderEditAdapter(this, value);
        listview2.setAdapter(adapter);

        btnEdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // final EditText Caption = (EditText) viewHolder2.edt;
               // edits.set(position2, Caption.getText().toString());

            }
        });

    }


}
