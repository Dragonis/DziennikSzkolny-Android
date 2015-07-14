package WojtekSasiela.DziennikSzkolny.StatisticActivity;

import WojtekSasiela.DziennikSzkolny.MiaryStatystyczne;
import WojtekSasiela.DziennikSzkolny.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import WojtekSasiela.DziennikSzkolny.Country;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;

/**
 * Created by Wojtek on 2014-11-23.
 */
public class SredniaAcitivity extends Activity {

    String imie;
    String nazwisko;
    String klasa;
    String przedmiot;
    ArrayList<String> oceny;
    String obliczona_srednia;
    ListView tabelka_z_ocenami;

    MyCustomAdapter dataAdapter = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statystyka_srednia_layout);

        //Generate list View from ArrayList
        displayListView();
        checkButtonClick();
//
//        MiaryStatystyczne statystyka = new MiaryStatystyczne();
//
//        // dane pochodza z DaneUczniaActivity badz StatystykaActivity
//        Bundle przekazanedane = getIntent().getExtras();
//
//            imie = przekazanedane.getString("imie");
//            nazwisko = przekazanedane.getString("nazwisko");
//            klasa = przekazanedane.getString("klasa");
//            przedmiot = przekazanedane.getString("przedmiot");
//            oceny = przekazanedane.getStringArrayList("ocenyArray");
//            if(oceny == null)
//            {
//                obliczona_srednia = "0.0";
//            }else {
//                obliczona_srednia = Float.toString((float) statystyka.Srednia(oceny));
//            }
//
//        TextView textView12 = (TextView) findViewById(R.id.textView10);
//        TextView obliczsrednia_textview = (TextView) findViewById(R.id.oblicz_srednia_textview);
//        tabelka_z_ocenami = (ListView) findViewById(R.id.tabelka_z_ocenami);
//        textView12.setText(imie + " " + nazwisko);
//        obliczsrednia_textview.setText(obliczona_srednia);
//        zamknijOkno(R.id.zamknij_srednia);
//
//        // Defined Array values to show in ListView
//        String[] values = new String[] { "Android List View",
//                "Adapter implementation",
//                "Simple List View In Android",
//                "Create List View Android",
//                "Android Example",
//                "List View Source Code",
//                "List View Array Adapter",
//                "Android Example List View"
//        };
//
//        // Define a new Adapter
//        // First parameter - Context
//        // Second parameter - Layout for the row
//        // Third parameter - ID of the TextView to which the data is written
//        // Forth - the Array of data
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_list_item_1, android.R.id.text1, values);
//
//        // Assign adapter to ListView
//        tabelka_z_ocenami.setAdapter(adapter);
//
//        tabelka_z_ocenami.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//                // ListView Clicked item index
//                int itemPosition     = position;
//
//                // ListView Clicked item value
//                String  itemValue    = (String) tabelka_z_ocenami.getItemAtPosition(position);
//
//                // Show Alert
//                Toast.makeText(getApplicationContext(),
//                        "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
//                        .show();
//            }
//
//        });

    }

    private class MyCustomAdapter extends ArrayAdapter<Country> {

        private ArrayList<Country> countryList;

        public MyCustomAdapter(Context context, int textViewResourceId,
                               ArrayList<Country> countryList) {
            super(context, textViewResourceId, countryList);
            this.countryList = new ArrayList<Country>();
            this.countryList.addAll(countryList);
        }

        private class ViewHolder {
            TextView code;
            CheckBox name;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;
            Log.v("ConvertView", String.valueOf(position));

            if (convertView == null) {
                LayoutInflater vi = (LayoutInflater)getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
                convertView = vi.inflate(R.layout.country_info, null);

                holder = new ViewHolder();
                holder.code = (TextView) convertView.findViewById(R.id.code);
                holder.name = (CheckBox) convertView.findViewById(R.id.checkBox1);
                convertView.setTag(holder);

                holder.name.setOnClickListener( new View.OnClickListener() {
                    public void onClick(View v) {
                        CheckBox cb = (CheckBox) v ;
                        Country country = (Country) cb.getTag();
                        Toast.makeText(getApplicationContext(),
                                "Clicked on Checkbox: " + cb.getText() +
                                        " is " + cb.isChecked(),
                                Toast.LENGTH_LONG).show();
                        country.setSelected(cb.isChecked());
                    }
                });
            }
            else {
                holder = (ViewHolder) convertView.getTag();
            }

            Country country = countryList.get(position);
            holder.code.setText(" (" +  country.getCode() + ")");
            holder.name.setText(country.getName());
            holder.name.setChecked(country.isSelected());
            holder.name.setTag(country);

            return convertView;

        }

    }

    private void checkButtonClick() {


        Button myButton = (Button) findViewById(R.id.findSelected);
        myButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                StringBuffer responseText = new StringBuffer();
                responseText.append("The following were selected...\n");

                ArrayList<Country> countryList = dataAdapter.countryList;
                for(int i=0;i<countryList.size();i++){
                    Country country = countryList.get(i);
                    if(country.isSelected()){
                        responseText.append("\n" + country.getName());
                    }
                }

                Toast.makeText(getApplicationContext(),
                        responseText, Toast.LENGTH_LONG).show();

            }
        });

    }

    private void displayListView() {

        //Array list of countries
        ArrayList<Country> countryList = new ArrayList<Country>();
        Country country = new Country("AFG","Afghanistan",false);
        countryList.add(country);
        country = new Country("ALB","Albania",true);
        countryList.add(country);
        country = new Country("DZA","Algeria",false);
        countryList.add(country);
        country = new Country("ASM","American Samoa",true);
        countryList.add(country);
        country = new Country("AND","Andorra",true);
        countryList.add(country);
        country = new Country("AGO","Angola",false);
        countryList.add(country);
        country = new Country("AIA","Anguilla",false);
        countryList.add(country);

        //create an ArrayAdaptar from the String Array
        dataAdapter = new MyCustomAdapter(this,
                R.layout.country_info, countryList);
        ListView listView = (ListView) findViewById(R.id.listView1);
        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);


        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                Country country = (Country) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),
                        "Clicked on Row: " + country.getName(),
                        Toast.LENGTH_LONG).show();
            }
        });

    }

    public void zamknijOkno(int id) {
        Button b = (Button) findViewById(id);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}