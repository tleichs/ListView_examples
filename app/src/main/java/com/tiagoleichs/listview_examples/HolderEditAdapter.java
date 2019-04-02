package com.tiagoleichs.listview_examples;

import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class HolderEditAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] value;
    private final List<String> edits = new ArrayList<>();

    static class ViewHolder2 {
        public TextView text2;
        public EditText edt;
    }

    public HolderEditAdapter(Activity context, String[] value) {
        super(context, R.layout.editlayout, value);
        this.context = context;
        this.value = value;
        for (String s : value) {
            edits.add("");
        }
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        // reuse views
        final ViewHolder2 viewHolder2;
       // if (rowView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.editlayout, null);
            // configure SimpleListViewExample holder
            viewHolder2 = new ViewHolder2();
            viewHolder2.text2 =  rowView.findViewById(R.id.tvLabel);
            viewHolder2.edt = rowView.findViewById(R.id.editText);
            viewHolder2.edt.setTag(position);
            rowView.setTag(viewHolder2);
       // } else {
       //     viewHolder2 = (ViewHolder2) convertView.getTag();
     //   }
        final int tag_position = (Integer) viewHolder2.edt.getTag();
        viewHolder2.edt.setId(tag_position);

        // fill data
        //final HolderEditAdapter.ViewHolder2 holder2 = (HolderEditAdapter.ViewHolder2) rowView.getTag();
        String s2 = value[position];
        viewHolder2.text2.setText(s2);
        viewHolder2.edt.setId(position);
        viewHolder2.edt.setText(edits.get(position) == null ? "" : edits.get(position));

        viewHolder2.edt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                final int position2 = viewHolder2.edt.getId();
                final EditText Caption = (EditText) viewHolder2.edt;
                edits.set(position2, Caption.getText().toString());
                if (Caption.getText().toString().length() > 0) {
                    // do nothing
                } else {
                    Toast.makeText(context, "Please enter some value", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
                final int position2 = viewHolder2.edt.getId();
                final EditText Caption = (EditText) viewHolder2.edt;
                edits.set(position2, Caption.getText().toString());
                ArrayList<EditText> arrayList1 = new ArrayList<>();
                //create class?
                int a = Integer.valueOf(Caption.getText().toString());





            }
        });


        return rowView;
    }



}
