package ly.generalassemb.drewmahrt.shoppinglistwithsearch;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import ly.generalassemb.drewmahrt.shoppinglistwithsearch.setup.DBAssetHelper;

public class MainActivity extends AppCompatActivity {
    private ListView mShoppingListView;
    private CursorAdapter mCursorAdapter;
    private ShoppingSQLiteOpenHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Ignore the two lines below, they are for setup
        DBAssetHelper dbSetup = new DBAssetHelper(MainActivity.this);
        dbSetup.getReadableDatabase();

        mShoppingListView = (ListView)findViewById(R.id.shopping_list_view);

        helper = new ShoppingSQLiteOpenHelper(MainActivity.this);
        Cursor cursor = helper.getShoppingList();

        //mCursorAdapter = new SimpleCursorAdapter(this,android.R.layout.simple_list_item_1,cursor,new String[]{ShoppingSQLiteOpenHelper.COL_ITEM_NAME},new int[]{android.R.id.text1},0);

        mCursorAdapter = new CursorAdapter(this, cursor, 0){
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return LayoutInflater.from(context).inflate(R.layout.shopping_list_item, parent, false);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {

                //ViewHolder viewHolder = new ViewHolder(view);
                ViewHolder viewHolder;

                if (view.getTag() == null) {
                    viewHolder = new ViewHolder(view);
                    view.setTag(viewHolder);
                } else {
                    viewHolder = (ViewHolder) view.getTag();
                }

                viewHolder.nameView.setText(cursor.getString(cursor.getColumnIndex(ShoppingSQLiteOpenHelper.COL_ITEM_NAME)));
                viewHolder.descriptionView.setText(cursor.getString(cursor.getColumnIndex(ShoppingSQLiteOpenHelper.COL_ITEM_DESCRIPTION)));
                viewHolder.typeView.setText(cursor.getString(cursor.getColumnIndex(ShoppingSQLiteOpenHelper.COL_ITEM_TYPE)));
                viewHolder.priceView.setText("$" + cursor.getString(cursor.getColumnIndex(ShoppingSQLiteOpenHelper.COL_ITEM_PRICE)));
            }

            class ViewHolder {
                TextView nameView, descriptionView, priceView, typeView;

                public ViewHolder(View view) {
                    nameView = (TextView) view.findViewById(R.id.nameText);
                    descriptionView = (TextView) view.findViewById(R.id.descriptionText);
                    priceView = (TextView) view.findViewById(R.id.priceText);
                    typeView = (TextView) view.findViewById(R.id.typeText);
                }
            }
        };
        mShoppingListView.setAdapter(mCursorAdapter);

        handleIntent(getIntent());
    }

    protected void handleIntent(Intent intent) {
        if (!intent.ACTION_SEARCH.equals(intent.getAction())) return;


        mCursorAdapter.changeCursor(helper.read(intent.getStringExtra(SearchManager.QUERY)));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.main_menu, menu);

        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        return true;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        //super.onNewIntent(intent);

        handleIntent(intent);
    }
}
