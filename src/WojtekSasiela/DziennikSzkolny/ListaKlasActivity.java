package WojtekSasiela.DziennikSzkolny;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

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
        String cars[] = {"Ania Kowalska", "Joasia Pyrzyńska", "Izabela Tarnowska", "Blanka Szept", "Paweł Paluch", "Piotrek Mały", "Karol Kopytko", "Arkadiusz Bąk", "Teresa Wawrzyniak"};
        String subjects[] = {"Polski", "Angielski", "Matematyka", "Przyroda", "Religia", "WF"};
        ArrayList<String> carL = new ArrayList<String>();
        ArrayList<String> subjectsL = new ArrayList<String>();
        carL.addAll( Arrays.asList(cars) );
        subjectsL.addAll( Arrays.asList(subjects) );
        adapter = new ArrayAdapter<String>(this, R.layout.elementy_listy_glownej, carL);
        adapterSubcjets = new ArrayAdapter<String>(this, R.layout.elementy_listy_glownej, subjectsL );
        listaKompoment.setAdapter(adapter);
        listaKompoment2.setAdapter(adapterSubcjets);

        listaKompoment.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                for (int j = 0; j < adapterView.getChildCount(); j++)
                    adapterView.getChildAt(j).setBackgroundColor(Color.TRANSPARENT);

                // change the background color of the selected element
                view.setBackgroundColor(Color.BLUE);
            }
        });

        listaKompoment2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                for (int j = 0; j < adapterView.getChildCount(); j++)
                    adapterView.getChildAt(j).setBackgroundColor(Color.TRANSPARENT);

                // change the background color of the selected element
                view.setBackgroundColor(Color.BLUE);

                        Intent intent = new Intent(getApplicationContext(), DaneUczniaActivity.class);

                        if (intent.resolveActivity(getPackageManager()) != null)
                            startActivity(intent);
                        else {
                            Toast.makeText(getApplicationContext(), "Niestety, ale startActivityForResult wywala blad.",
                                    Toast.LENGTH_LONG).show();
                        }


            }
        });
        zamknijOkno(R.id.Wyjdz_button);

        Toast.makeText(getApplicationContext(), "Pokaz liste klas", Toast.LENGTH_LONG).show();
    }

    public void zamknijOkno(int id)
    {
        Button b = (Button)findViewById(id);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }



}