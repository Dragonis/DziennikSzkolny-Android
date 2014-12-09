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
    private ListView listaKompoment = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_klas_layout);

        listaKompoment = (ListView) findViewById(R.id.listView);
        String cars[] = {"Mercedes", "Fiat", "Ferrari", "Aston Martin", "Lamborghini", "Skoda", "Volkswagen", "Audi", "Citroen"};
        ArrayList<String> carL = new ArrayList<String>();
        carL.addAll( Arrays.asList(cars) );
        adapter = new ArrayAdapter<String>(this, R.layout.elementy_listy_glownej, carL);
        listaKompoment.setAdapter(adapter);


        Toast.makeText(getApplicationContext(), "Pokaz liste klas", Toast.LENGTH_LONG).show();
    }
}