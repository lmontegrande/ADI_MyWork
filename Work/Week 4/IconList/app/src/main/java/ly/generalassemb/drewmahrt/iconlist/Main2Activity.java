package ly.generalassemb.drewmahrt.iconlist;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import static ly.generalassemb.drewmahrt.iconlist.R.mipmap.ic_launcher;

public class Main2Activity extends AppCompatActivity {

    public static String whatICallId = "ID";
    Cursor cursor;
    TextView textView;
    IconSQLiteOpenHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        fab.setImageResource(android.R.drawable.presence_away);

        helper = IconSQLiteOpenHelper.getInstance(this);
        textView = (TextView) findViewById(R.id.textView);
        textView.setText(helper.getDetail(getIntent().getIntExtra(whatICallId, -1)));



    }

}
