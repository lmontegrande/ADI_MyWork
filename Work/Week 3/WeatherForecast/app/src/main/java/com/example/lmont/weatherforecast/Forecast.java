package com.example.lmont.weatherforecast;

import android.media.Image;

/**
 * Created by lmont on 8/16/2016.
 */
public class Forecast {
    public String day, high, low;
    public int image;

    public Forecast(String day, String high, String low, int image) {
        this.day = day;
        this.high = high;
        this.low = low;
        this.image = image;
    }

}
