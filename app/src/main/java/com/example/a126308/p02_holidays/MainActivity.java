package com.example.a126308.p02_holidays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lvTypes;

    ArrayList<String> types;
    ArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvTypes = (ListView)findViewById(R.id.listViewTypes);

        types = new ArrayList<String>();
        types.add("Secular");
        types.add("Ethnics & religion");

        aa = new ArrayAdapter(this, android.R.layout.simple_list_item_1, types);
        lvTypes.setAdapter(aa);

        lvTypes.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedType = types.get(position);

                Intent i = new Intent (MainActivity.this,
                        SecondActivity.class);

                i.putExtra("type", selectedType);

                Toast.makeText(MainActivity.this, selectedType,
                        Toast.LENGTH_LONG).show();

                startActivity(i);
            }
        });
    }
}
