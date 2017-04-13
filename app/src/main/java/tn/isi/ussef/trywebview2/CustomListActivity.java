package tn.isi.ussef.trywebview2;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class CustomListActivity extends ListActivity {
    TextView selection;
    String [] items = {"12.5", "1.5", "13.5", "18","1.5", "13.5", "18", "6.3"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);
        selection = (TextView) findViewById(R.id.selectiontxt);
        setListAdapter(new IconicAdapter(this));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        selection.setText(items[position]);
    }

    class IconicAdapter extends ArrayAdapter<String> {
        Activity context;
        public IconicAdapter(Activity context) {
            super(context, R.layout.ma_ligne, items);
            this.context = context;
        }

        @Override
        public View getView(int position,  View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View ligne = inflater.inflate(R.layout.ma_ligne, null);
            TextView label = (TextView) ligne.findViewById(R.id.valuetxt);
            ImageView image = (ImageView) ligne.findViewById(R.id.imageView);
            label.setText(items[position]);
            if (Float.valueOf(items[position]) >= 10){
                image.setImageResource(android.R.color.holo_green_light);
            }else{
                image.setImageResource(android.R.color.holo_red_light);
            }
            return ligne;
        }
    }
}
