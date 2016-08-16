package com.example.lmont.weatherforecast;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by lmont on 8/16/2016.
 */
public class WeatherAdapter extends BaseAdapter {

    Context context;
    ArrayList<Forecast> forecasts;

    public WeatherAdapter(Context context, ArrayList<Forecast> forecasts) {
        this.context = context;
        this.forecasts = forecasts;
    }

    @Override
    public int getCount() {
        return forecasts.size();
    }

    @Override
    public Object getItem(int i) {
        return forecasts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;
        Forecast current = forecasts.get(i);

        if(view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.custom_list_item_weather, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(view);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.day.setText(current.day);
        viewHolder.high.setText(current.high);
        viewHolder.low.setText(current.low);
        viewHolder.image.setImageResource(current.image);

        return view;
    }

    public class ViewHolder {
        public TextView day, high, low;
        public ImageView image;

        public ViewHolder(View view) {
            this.day = (TextView) view.findViewById(R.id.day);
            this.high = (TextView) view.findViewById(R.id.high);
            this.low = (TextView) view.findViewById(R.id.low);
            this.image = (ImageView) view.findViewById(R.id.imageView);
        }
    }
}
