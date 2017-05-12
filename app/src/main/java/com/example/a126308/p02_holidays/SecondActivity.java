package com.example.a126308.p02_holidays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lvShow;
    TextView tvDay;
    ArrayList<Holidays> types;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        types = new ArrayList<Holidays>();

        Intent i = getIntent();
        String type = i.getStringExtra("type");

        if (type.equalsIgnoreCase("Secular")) {
            types.add(new Holidays("New Year's Day", "1 Jan 2017"));
            types.add(new Holidays("Labour Day", "1 May 2017"));
        } else {
            types.add(new Holidays("Chinese New Year", "28-29 Jan 2017"));
            types.add(new Holidays("Good Friday", "14 April 2017"));
        }

        HolidaysAdapter adapter = new HolidaysAdapter(this, R.layout.row, types);

        lvShow = (ListView) this.findViewById(R.id.ListViewShow);
        tvDay = (TextView) findViewById(R.id.textViewHolidaysTypes);

        lvShow.setAdapter(adapter);


        tvDay.setText(type);
    }
}
