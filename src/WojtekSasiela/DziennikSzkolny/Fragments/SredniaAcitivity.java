package WojtekSasiela.DziennikSzkolny.Fragments;

import WojtekSasiela.DziennikSzkolny.MiaryStatystyczne;
import WojtekSasiela.DziennikSzkolny.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Array;
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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_srednia_layout);

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
        textView12.setText(imie + " " + nazwisko);
        obliczsrednia_textview.setText(obliczona_srednia);
        zamknijOkno(R.id.zamknij_srednia);
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