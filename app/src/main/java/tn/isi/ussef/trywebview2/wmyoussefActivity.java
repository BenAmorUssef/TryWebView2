package tn.isi.ussef.trywebview2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;

public class wmyoussefActivity extends AppCompatActivity {
    String [] data = {"Dimanche","Lundi","Mardi","Mercredi","Jeudi","Vendredi","Samedi" };
    TextView selection;
    GridView grid;
    private AutoCompleteTextView autocomplete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wmyoussef);
        selection = (TextView) findViewById(R.id.selectiontxt);
        grid = (GridView) findViewById(R.id.gridv);
        autocomplete = (AutoCompleteTextView) findViewById(R.id.autocompletetxt);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(myItemSelectedClickListener);

        autocomplete.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, data));

        grid.setAdapter(adapter);
        grid.setOnItemClickListener(myItemClickListener);
    }
    private AdapterView.OnItemClickListener myItemClickListener =  new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selection.setText("grid" + (position+1) + ":" + ((TextView)view).getText() );
        }
    };
    private AdapterView.OnItemSelectedListener myItemSelectedClickListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            selection.setText("spinner" + (position+1) + ":" + ((TextView)view).getText() );
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            selection.setText("Choisir un jour" );

        }
    };
}
