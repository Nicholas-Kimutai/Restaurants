package com.moringaschool.myrestaurants;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class RestaurantsActivity extends AppCompatActivity {
    private String[] restaurants=new String[]{"Mi Mero Mole", "Mother's Bistro","Life of a pie",
    "Luc Lac","Life of pie","Screen door", "sweet Basil","subway","Dragons Fly","Sleepy Joe","Nic the Oligarch",
            "Trump the hero","pastor from hell","Liverpool"};
    private TextView mLocationTextView;
    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);

        mListView=(ListView)findViewById(R.id.listview);
        mLocationTextView=(TextView)findViewById(R.id.locationTextView);
        ArrayAdapter adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,restaurants);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String restaurant =((TextView)view).getText().toString();
                Toast.makeText(RestaurantsActivity.this, restaurant,Toast.LENGTH_LONG).show();

            }
        });

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        mLocationTextView.setText("Here are all the restaurants near:" + location);
    }
}