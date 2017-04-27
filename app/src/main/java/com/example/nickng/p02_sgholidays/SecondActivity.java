package com.example.nickng.p02_sgholidays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    ListView lv;
    ArrayAdapter aa;
    ArrayList<Holidays> al;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv = (ListView)findViewById(R.id.lvHolidays);
        tv = (TextView)findViewById(R.id.tvHols);

        Intent i = getIntent();
        String type = i.getStringExtra("type");
        tv.setText(type);

        al = new ArrayList<Holidays>();

        if (type.equalsIgnoreCase("Secular")){
            al.add(new Holidays("New Year's Day", "1 Jan 2017", true, R.drawable.newyear));
            al.add(new Holidays("Labour Day", "1 May 2017", true, R.drawable.labourday));
        } else {
            al.add(new Holidays("Chinese New Year", "28-29 Jan 2017", false, R.drawable.cny));
            al.add(new Holidays("Good Friday", "14 April 2017", false, R.drawable.goodfriday));
        }

        aa = new HolidaysAdapter(this, R.layout.row, al);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Holidays selectedHoli = al.get(position);
                Toast.makeText(SecondActivity.this, selectedHoli.getName()
                                + ": " + selectedHoli.getDate(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
