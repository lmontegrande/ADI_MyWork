package ly.generalassemb.drewmahrt.cursordemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getCanonicalName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase db;

        db = openOrCreateDatabase(
                "TestingData.db"
                , SQLiteDatabase.CREATE_IF_NECESSARY
                , null
        );
        db.setVersion(1);
        db.setLocale(Locale.getDefault());

        String[] countryNames = new String[]{"Cananda","USA","Mexico"};
        int[] populations = new int[]{35,318,125};
        db.execSQL("CREATE TABLE IF NOT EXISTS tbl_countries (country_name VARCHAR, population VARCHAR);");
        for (int i=0; i<countryNames.length;i++) {
            db.execSQL("INSERT INTO tbl_countries Values ('" + countryNames[i] + "', '"+ populations[i] + "');");
        }

        TextView textView = (TextView) findViewById(R.id.textView);
        Cursor cursor = db.query("tbl_countries", null, null, null, null, null, null);

        while(cursor.moveToNext()) {
            textView.setText(textView.getText() +
                    cursor.getString(cursor.getColumnIndex("country_name")) + " " +
                    cursor.getString(cursor.getColumnIndex("population")) + "\n");
        }

        cursor.close();
    }
}