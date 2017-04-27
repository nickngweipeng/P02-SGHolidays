package com.example.nickng.p02_sgholidays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by 15056201 on 27/4/2017.
 */

public class HolidaysAdapter extends ArrayAdapter<Holidays>{
    private Context context;
    private ArrayList<Holidays> holiday;
    private TextView tvName;
    private TextView tvDate;
    private ImageView ivSecular;

    public HolidaysAdapter(Context context, int resource, ArrayList<Holidays> objects){
        super(context, resource, objects);
        holiday = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvName = (TextView) rowView.findViewById(R.id.tvCode);
        tvDate = (TextView) rowView.findViewById(R.id.tvDate);
        // Get the ImageView object
        ivSecular = (ImageView) rowView.findViewById(R.id.ivProg);

        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Holidays currentModule = holiday.get(position);
        // Set the TextView to show the food

        tvName.setText(currentModule.getName());
        tvDate.setText(currentModule.getDate());
        ivSecular.setImageResource(currentModule.getSym());

        // Return the nicely done up View to the ListView
        return rowView;
    }
}
