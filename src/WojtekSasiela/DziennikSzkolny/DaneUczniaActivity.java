package WojtekSasiela.DziennikSzkolny;

import WojtekSasiela.DziennikSzkolny.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


/**
 * Created by Wojtek on 2015-01-28.
 */
public class DaneUczniaActivity extends Activity {

    private ArrayList<HashMap<String, String>> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dane_ucznia_layout);

        zamknijOkno(R.id.Wyjdzbttn_OcenyLayout);

        ListView listaKompoment = (ListView) findViewById(R.id.listView3);
        ListView listaKompoment2 = (ListView) findViewById(R.id.listView4);
        String daty[] = {"10.10", "05.03", "12.04", "15.01", "17.09", "16.02", "24.08", "15.08", "13.03"};
        String oceny[] = {"5", "4", "3", "2", "1", "6", "4", "5", "3"};
        ArrayList<String> ocenyL = new ArrayList<String>();
        ArrayList<String> datyL = new ArrayList<String>();
        ocenyL.addAll( Arrays.asList(oceny) );
        datyL.addAll( Arrays.asList(daty) );
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.edycja_danych_row, ocenyL);;
        ArrayAdapter adapter2 = new ArrayAdapter<String>(this, R.layout.edycja_danych_row, datyL);;
        listaKompoment.setAdapter(adapter2);
        listaKompoment2.setAdapter(adapter);

    }


    public void Pokaz_Activity_z_klasy(int id, final Context context, final Class<?> klasa)
    {
        Button b = (Button)findViewById(id);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, klasa);

                if (intent.resolveActivity(getPackageManager()) != null)
                    startActivity(intent);
                else {
                    Toast.makeText(getApplicationContext(), "Niestety, ale startActivityForResult wywala blad.",
                            Toast.LENGTH_LONG).show();
                }


            }
        });
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