package com.example.lmont.projectone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by lmont on 8/18/2016.
 */
public class TasksListAdapter extends BaseAdapter {

    public Context context;
    public ArrayList<Task> tasks;

    public TasksListAdapter(Context context, ArrayList<Task> tasks) {
        this.context = context;
        this.tasks = tasks;
    }

    @Override
    public int getCount() {
        return tasks.size();
    }

    @Override
    public Object getItem(int i) {
        return tasks.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;
        final Task thisTask = tasks.get(i);

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.list_list_item, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.listName.setText(thisTask.getName());
        viewHolder.listDetail.setText(thisTask.getAbout());
        viewHolder.listDate.setText(String.format("%1$tA %1$tb %1$td %1$tY at %1$tI:%1$tM %1$Tp", thisTask.getmCalendar()));

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = thisTask.getName() + "\n" +
                                thisTask.getAbout() + "\n" +
                        String.format("Created On: %1$tA %1$tb %1$td %1$tY at %1$tI:%1$tM %1$Tp", thisTask.getmCalendar()) + "\n";
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
            }
        });

        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(context, thisTask.getName() + " Deleted", Toast.LENGTH_SHORT).show();
                tasks.remove(i);
                notifyDataSetChanged();
                return false;
            }
        });

        return view;
    }

    private class ViewHolder {

        public TextView listName, listDetail, listDate;

        public ViewHolder(View view) {
            listName = (TextView) view.findViewById(R.id.listName);
            listDetail = (TextView) view.findViewById(R.id.listAbout);
            listDate = (TextView) view.findViewById(R.id.listDate);
        }
    }
}
