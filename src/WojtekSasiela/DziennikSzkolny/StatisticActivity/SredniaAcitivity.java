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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statystyka_srednia_layout);

        MiaryStatystyczne statystyka = new MiaryStatystyczne();

        // dane pochodza z DaneUczniaActivity badz StatystykaActivity
        Bundle przekazanedane = getIntent().getExtras();

            imie = przekazanedane.getString("imie");
            nazwisko = przekazanedane.getString("nazwisko");
            klasa = przekazanedane.getString("klasa");
            przedmiot = przekazanedane.getString("przedmiot");
            oceny = przekazanedane.getStringArrayList("ocenyArray");
            if(oceny == null)
            {
                obliczona_srednia = "0.0";
            }else {
                obliczona_srednia = Float.toString((float) statystyka.Srednia(oceny));
            }

        TextView textView12 = (TextView) findViewById(R.id.textView10);
        TextView obliczsrednia_textview = (TextView) findViewById(R.id.oblicz_srednia_textview);
        tabelka_z_ocenami = (ListView) findViewById(R.id.tabelka_z_ocenami);
        textView12.setText(imie + " " + nazwisko);
        obliczsrednia_textview.setText(obliczona_srednia);
        zamknijOkno(R.id.zamknij_srednia);

        // Defined Array values to show in ListView
        String[] values = new String[] { "Android List View",
                "Adapter implementation",
                "Simple List View In Android",
                "Create List View Android",
                "Android Example",
                "List View Source Code",
                "List View Array Adapter",
                "Android Example List View"
        };

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);

        // Assign adapter to ListView
        tabelka_z_ocenami.setAdapter(adapter);

        tabelka_z_ocenami.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                String  itemValue    = (String) tabelka_z_ocenami.getItemAtPosition(position);

                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                        .show();
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