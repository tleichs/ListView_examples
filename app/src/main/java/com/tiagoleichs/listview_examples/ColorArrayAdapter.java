package com.tiagoleichs.listview_examples;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ColorArrayAdapter extends ArrayAdapter<SimpleColors> {

    public ColorArrayAdapter(Context context, ArrayList<SimpleColors> colors) {
        super(context, 0, colors);
    }

    // Return an integer representing the type by fetching the enum type ordinal
    @Override
    public int getItemViewType(int position) {
        return getItem(position).color.ordinal();
    }

    // Total number of types is the number of enum values
    @Override
    public int getViewTypeCount() {
        return SimpleColors.ColorValues.values().length;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        SimpleColors color = getItem(position);
        // Check if an existing SimpleListViewExample is being reused, otherwise inflate the SimpleListViewExample
        if (convertView == null) {
            // Get the data item type for this position
            int type = getItemViewType(position);
            // Inflate XML layout based on the type
            convertView = getInflatedLayoutForType(type);
        }
        // Lookup SimpleListViewExample for data population
        TextView tvLabel = (TextView) convertView.findViewById(R.id.tvLabel);
        if (tvLabel != null) {
            // Populate the data into the template SimpleListViewExample using the data object
            tvLabel.setText(color.label);
        }
        // Return the completed SimpleListViewExample to render on screen
        return convertView;
    }

    // Given the item type, responsible for returning the correct inflated XML layout file
    private View getInflatedLayoutForType(int type) {
        if (type == SimpleColors.ColorValues.BLUE.ordinal()) {
            return LayoutInflater.from(getContext()).inflate(R.layout.layout1, null);
        } else if (type == SimpleColors.ColorValues.RED.ordinal()) {
            return LayoutInflater.from(getContext()).inflate(R.layout.layout2, null);
        } else if (type == SimpleColors.ColorValues.GREEN.ordinal()) {
            return LayoutInflater.from(getContext()).inflate(R.layout.layout3, null);
        } else {
            return null;
        }
    }
}
