package com.example.lmont.projectone;

import android.content.Context;
import android.content.Intent;
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
public class TodoListAdapter extends BaseAdapter {

    Context context;
    ArrayList<TodoList> lists;

    public TodoListAdapter(Context context, ArrayList<TodoList> lists) {
        this.context = context;
        this.lists = lists;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int i) {
        return lists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.list_list_item, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }

        final TodoList list = lists.get(i);

        viewHolder.listName.setText(list.getName());
        viewHolder.listDetail.setText(list.getAbout());
        viewHolder.listDate.setText(String.format("%1$tA %1$tb %1$td %1$tY at %1$tI:%1$tM %1$Tp", list.getmCalendar()));

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra("listNum", i);
                context.startActivity(intent);
            }
        });

        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                lists.remove(i);
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
