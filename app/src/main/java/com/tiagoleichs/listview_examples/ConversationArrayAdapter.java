package com.tiagoleichs.listview_examples;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ConversationArrayAdapter extends ArrayAdapter<Conversation>{

    public ConversationArrayAdapter(Context context, ArrayList<Conversation> types) {
        super(context, 0, types);
    }
/*
    @Override
    public int getItemViewType(int position) {
        return getItem(position).typeC;
    }
    */

    // Total number of types is the number of enum values
    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        int a;
        a = 1;
        Conversation names = getItem(position);

        // Check if an existing SimpleListViewExample is being reused, otherwise inflate the SimpleListViewExample
        if (convertView == null) {
            int type = names.typeC;
            // Get the data item type for this position
           // int type = getItemViewType(position);
            // Inflate XML layout based on the type
            convertView = getInflatedLayoutForType(type);
        }
        // Lookup SimpleListViewExample for data population
        TextView tvLabel = (TextView) convertView.findViewById(R.id.tvLabel);
        if (tvLabel != null) {
            // Populate the data into the template SimpleListViewExample using the data object
           tvLabel.setText(names.name);
        }
        // Return the completed SimpleListViewExample to render on screen
        return convertView;
    }

    // Given the item type, responsible for returning the correct inflated XML layout file
    private View getInflatedLayoutForType(int type) {

        if (type == 1) {
            return LayoutInflater.from(getContext()).inflate(R.layout.layout1, null);
        } else if (type == 2) {
            return LayoutInflater.from(getContext()).inflate(R.layout.layout2, null);
        } else if (type == 3) {
            return LayoutInflater.from(getContext()).inflate(R.layout.layout3, null);
        } else {
            return null;
        }
    }
}
