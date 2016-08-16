package com.example.lmont.weatherforecast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    WeatherAdapter weatherAdapter;
    ArrayList<Forecast> forecasts;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup
        setup();
    }

    private void setup() {
        forecasts = getWeather();
        listView = (ListView) findViewById(R.id.listView);
        weatherAdapter = new WeatherAdapter(this, forecasts);
        listView.setAdapter(weatherAdapter);

    }

    private ArrayList<Forecast> getWeather() {
        ArrayList<Forecast> temp = new ArrayList<>();
        temp.add(new Forecast("Sunday", "100", "20", R.drawable.weather));
        temp.add(new Forecast("Monday", "100", "20", R.drawable.weather));
        temp.add(new Forecast("Tuesday", "100", "20", R.drawable.weather));
        temp.add(new Forecast("Wednesday", "100", "20", R.drawable.weather));
        temp.add(new Forecast("Thursday", "100", "20", R.drawable.weather));
        temp.add(new Forecast("Friday", "100", "20", R.drawable.weather));
        temp.add(new Forecast("Saturday", "100", "20", R.drawable.weather));

        return temp;
    }
}
