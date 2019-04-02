package com.tiagoleichs.listview_examples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class ThreeLayouts extends AppCompatActivity {

    public ArrayList<Conversation> conList;
    public ListView list3;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_threelayouts);

        list3 = findViewById(R.id.list3Layouts);
        conList = new ArrayList<>();


        beginjsonparsing();


    }

    private void beginjsonparsing() {
        try {

            JSONObject reader = new JSONObject(loadJSONFromAsset());

            JSONArray jsonArray =  reader.
                    getJSONArray("rootmode");

            for (int i = 0; i < jsonArray.length(); i++) {
                try {
                    JSONObject object = jsonArray.getJSONObject(i);
                    int id = object.getInt("id");
                    String nameO = object.getString("name");
                        int typeO = object.getInt("type");
                        if(id == 1) {
                            conList.add(new Conversation(nameO, typeO));
                            ConversationArrayAdapter conversationAdapter = new ConversationArrayAdapter(this, conList);
                            list3.setAdapter(conversationAdapter);
                        }



                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }


        } catch (JSONException e1) {
            e1.printStackTrace();
        }

    }

    private String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = this.getAssets().open("data");
            int size = is.available();
            byte[] bytes = new byte[size];
            is.read(bytes);
            is.close();
            json = new String(bytes, "UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
        return json;
    }
}
