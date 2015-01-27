package WojtekSasiela.DziennikSzkolny;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Wojtek on 2014-12-09.
 */
public class ListaKlasActivity extends Activity {

    private ArrayAdapter<String> adapter = null;
    private ArrayAdapter<String> adapterSubcjets = null;
    private ListView listaKompoment = null;
    private ListView listaKompoment2 = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_klas_layout);

        listaKompoment = (ListView) findViewById(R.id.listView);
        listaKompoment2 = (ListView) findViewById(R.id.listView0);
        String cars[] = {"Mercedes", "Fiat", "Ferrari", "Aston Martin", "Lamborghini", "Skoda", "Volkswagen", "Audi", "Citroen"};
        String subjects[] = {"Polski", "Angielski", "Matematyka", "Przyroda", "Religia", "WF"};
        ArrayList<String> carL = new ArrayList<String>();
        ArrayList<String> subjectsL = new ArrayList<String>();
        carL.addAll( Arrays.asList(cars) );
        subjectsL.addAll( Arrays.asList(subjects) );
        adapter = new ArrayAdapter<String>(this, R.layout.elementy_listy_glownej, carL);
        adapterSubcjets = new ArrayAdapter<String>(this, R.layout.elementy_listy_glownej, subjectsL );
        listaKompoment.setAdapter(adapter);
        listaKompoment2.setAdapter(adapterSubcjets);


        Toast.makeText(getApplicationContext(), "Pokaz liste klas", Toast.LENGTH_LONG).show();
    }
}