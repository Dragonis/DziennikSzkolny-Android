package WojtekSasiela.DziennikSzkolny;

import WojtekSasiela.DziennikSzkolny.Fragments.*;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


/**
 * Created by Wojtek on 2015-01-28.
 */
public class DaneUczniaActivity extends Activity {

    private ArrayList<HashMap<String, String>> list;
    String ImieiNazwisko = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_dane_ucznia_layout);

        pobierzImieiNazwiskozPoprzedniegoActivity();
        zamknijOkno(R.id.Wyjdzbttn_OcenyLayout);

        ListView listaKompoment = (ListView) findViewById(R.id.listView3);
        ListView listaKompoment2 = (ListView) findViewById(R.id.listView4);
        String daty[] = {"10.10", "05.03", "12.04", "15.01", "17.09", "16.02", "24.08", "15.08", "13.03"};
        String oceny[] = {"5", "4", "3", "2", "1", "6", "4", "5", "3"};
        ArrayList<String> ocenyL = new ArrayList<String>();
        ArrayList<String> datyL = new ArrayList<String>();
        ocenyL.addAll( Arrays.asList(oceny) );
        datyL.addAll( Arrays.asList(daty) );
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.listview_edycjadanych_row, ocenyL);;
        ArrayAdapter adapter2 = new ArrayAdapter<String>(this, R.layout.listview_edycjadanych_row, datyL);;
        listaKompoment.setAdapter(adapter2);
        listaKompoment2.setAdapter(adapter);

        // wyswitlanie odpowiednich activity statystycznych
        Pokaz_Activity_z_klasy(R.id.srednia_button_daneucznia, getApplicationContext(), SredniaAcitivity.class);
        Pokaz_Activity_z_klasy(R.id.mediana_button_daneucznia,getApplicationContext(),MedianaAcitivity.class);
        Pokaz_Activity_z_klasy(R.id.wariancja_button_daneucznia,getApplicationContext(),WariancjaAcitivity.class);
        Pokaz_Activity_z_klasy(R.id.dominanta_button_daneucznia,getApplicationContext(),DominantaAcitivity.class);
        Pokaz_Activity_z_klasy(R.id.odchylenie_button_daneucznia,getApplicationContext(),OdchylenieAcitivity.class);
        Pokaz_Activity_z_klasy(R.id.kwartyle_button_daneucznia,getApplicationContext(),KwartyleAcitivity.class);


        Button srednia_button_dane_ucznia = (Button) findViewById(R.id.srednia_button_daneucznia);
        srednia_button_dane_ucznia.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Pobieramy tekst z pola
                String wpisanyTekst = ImieiNazwisko;
                // Pakujemy go w Bundle
                Bundle koszyk = new Bundle();
                koszyk.putString("dane", wpisanyTekst);
                // Definiujemy cel
                Intent cel = new Intent(view.getContext(), SredniaAcitivity.class);
                cel.putExtras(koszyk);
                // Wysyłamy
                startActivity(cel);
            }
        });



    }

    public void pobierzImieiNazwiskozPoprzedniegoActivity()
    {
        // dane pochodza z ListaKlasActivity
        Bundle przekazanedane = getIntent().getExtras();
        ImieiNazwisko = przekazanedane.getString("ImieiNazwisko");

        TextView pokaz_imie_nazwisko_textview = (TextView) findViewById(R.id.pokazImieiNaziwsko);
        pokaz_imie_nazwisko_textview.setText(ImieiNazwisko);
    }

    /**
     *
     *
     * @param button_id R.id.button_name
     * @param context insert 'getApplicationContext()'
     * @param klasa example: StatystykaActivity.class
     */
    public void Pokaz_Activity_z_klasy(int button_id, final Context context, final Class<?> klasa)
    {
        Button b = (Button)findViewById(button_id);
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
