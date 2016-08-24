package com.example.lmont.sqlliteopenhelperdemo;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    public static MainActivity instance = new MainActivity();

    DatabaseHelper db;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
        textView = (TextView) findViewById(R.id.textView);

        int marioID = db.insert("Super Mario", "1985");
        int zeldaID = db.insert("Legend of Zelda", "1986");
        int metroidID = db.insert("Metroid", "1990");

        Cursor cursor = db.getExampleList();

        CursorAdapter cursorAdapter = new CursorAdapter(this, cursor, 0) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return LayoutInflater.from(context).inflate(R.layout.list_item_layout, viewGroup, false);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {

                ViewHolder viewHolder;

                if (view.getTag(0) == null) {
                    viewHolder = new ViewHolder(view);
                    view.setTag(0, viewHolder);
                } else {
                    viewHolder = (ViewHolder) view.getTag(0);
                }
                TextView textView = viewHolder.textView;
                TextView textView2 = viewHolder.textView2;
                textView.setText(cursor.getString(cursor.getColumnIndex("name")));
                textView2.setText(cursor.getString(cursor.getColumnIndex("year")));
            }

            class ViewHolder {
                TextView textView;
                TextView textView2;

                public ViewHolder(View view) {
                    textView = (TextView) view.findViewById(R.id.textView);
                    textView2 = (TextView) view.findViewById(R.id.textView2);
                }
            }
        };

        ((ListView) findViewById(R.id.listView)).setAdapter(cursorAdapter);

    }
}
