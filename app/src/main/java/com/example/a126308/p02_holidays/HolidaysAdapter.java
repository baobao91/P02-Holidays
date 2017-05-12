package com.example.a126308.p02_holidays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.type;

/**
 * Created by 126308 on 11/5/2017.
 */

public class HolidaysAdapter extends ArrayAdapter<Holidays> {

    private ArrayList<Holidays> types;
    private TextView tvDay;
    private TextView tvDate;
    private ImageView ivHoli;
    private Context context;

    public HolidaysAdapter(Context context, int resource, ArrayList<Holidays> objects) {
        super(context, resource, objects);

        types = objects;

        this.context = context;

    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvDay = (TextView) rowView.findViewById(R.id.textViewDay);
        tvDate = (TextView) rowView.findViewById(R.id.textViewDate);
        ivHoli = (ImageView) rowView.findViewById(R.id.imageViewHolidays);

        Holidays currentHolidays = types.get(position);

        if (currentHolidays.getDay().equalsIgnoreCase("New Year's Day")) {
            ivHoli.setImageResource(R.drawable.newyear);
            Toast.makeText(getContext(), currentHolidays.getDay() + " " + currentHolidays.getDate() , Toast.LENGTH_LONG).show();
        } else if (currentHolidays.getDay().equalsIgnoreCase("Labour Day")) {
            ivHoli.setImageResource(R.drawable.labour);
            Toast.makeText(getContext(), currentHolidays.getDay() + " " + currentHolidays.getDate() , Toast.LENGTH_LONG).show();
        } else if (currentHolidays.getDay().equalsIgnoreCase("Chinese New Year")) {
            ivHoli.setImageResource(R.drawable.cny);
            Toast.makeText(getContext(), currentHolidays.getDay() + " " + currentHolidays.getDate() , Toast.LENGTH_LONG).show();
        } else {
            ivHoli.setImageResource(R.drawable.friday);
            Toast.makeText(getContext(), currentHolidays.getDay() + " " + currentHolidays.getDate() , Toast.LENGTH_LONG).show();
        }

        // Set the TextView to show the food
        tvDay.setText(currentHolidays.getDay());
        tvDate.setText(currentHolidays.getDate());


        return rowView;
    }


}
