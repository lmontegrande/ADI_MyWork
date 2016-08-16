package ly.generalassemb.customadapters;

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
 * Custom Adapter for our two TextViews and single Button.
 *
 * It holds a list of Animals and binds the animal name to
 * firstTextView, animal sound to secondTextView.
 *
 * When button is clicked a toast is made with animal name saying
 * animal sound ( i.e. cow says moo ).
 */
public class CustomBaseAdapter extends BaseAdapter {

    Context context;
    ArrayList<Animal> animals;

    public CustomBaseAdapter(Context context, ArrayList<Animal> animals) {
        this.context = context;
        this.animals = animals;
    }

    @Override
    public int getCount() {
        return animals.size();
    }

    @Override
    public Object getItem(int position) {
        return animals.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder viewholder;

        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
            viewholder = new ViewHolder(convertView);
            convertView.setTag(viewholder);
        } else {
            viewholder = (ViewHolder) convertView.getTag();
        }


        viewholder.textView1.setText(animals.get(position).getName());
        viewholder.textView2.setText(animals.get(position).getSound());
        
        viewholder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, animals.get(position).getName() + " goes " + animals.get(position).getSound(), Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    private class ViewHolder {
        TextView textView1;
        TextView textView2;
        Button button;

        public ViewHolder(View view) {
            this.textView1 = (TextView) view.findViewById(R.id.list_item_tv_first);
            this.textView2 = (TextView) view.findViewById(R.id.list_item_tv_second);
            this.button = (Button) view.findViewById(R.id.list_item_button);
        }
    }
}
