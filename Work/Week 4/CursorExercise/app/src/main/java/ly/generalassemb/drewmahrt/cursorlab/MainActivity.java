package ly.generalassemb.drewmahrt.cursorlab;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase db;

        db = openOrCreateDatabase(
                "BooksData.db"
                , SQLiteDatabase.CREATE_IF_NECESSARY
                , null
        );
        db.setVersion(1);
        db.setLocale(Locale.getDefault());

        String[] titles = new String[]{"Harry Potter and the Sorcerers Stone","Harry Potter and the Chamber of Secrets","The Martian"};
        String[] authors = new String[]{"J. K. Rowling","J. K. Rowling","Andy Weir"};
        int[] years = new int[]{1997,1998,2011};
        db.execSQL("DROP TABLE tbl_books");
        db.execSQL("CREATE TABLE IF NOT EXISTS tbl_books (title VARCHAR, author VARCHAR, year VARCHAR);");
        for (int i=0; i<titles.length;i++) {
            db.execSQL("INSERT INTO tbl_books Values ('" + titles[i] + "', '"+ authors[i] + "', '" + years[i] +"');");
        }

        //Start your code here

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1);
        ListView listView = (ListView) findViewById(R.id.listView);
        Cursor cursor = db.rawQuery(
                        "SELECT * FROM tbl_books " +
                        "ORDER BY title"
                , null);
        ArrayList<String> arrayList = new ArrayList();

        cursor.moveToLast();
        do {
            arrayAdapter.add(
                            "Title: " + cursor.getString(cursor.getColumnIndex("title")) + "\n" +
                            "Author: " + cursor.getString(cursor.getColumnIndex("author")) + " \n" +
                            "year: " + cursor.getString(cursor.getColumnIndex("year"))
            );
        } while (cursor.moveToPrevious());

        listView.setAdapter(arrayAdapter);
    }
}
