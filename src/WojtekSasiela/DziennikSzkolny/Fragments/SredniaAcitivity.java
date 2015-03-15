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


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_srednia_layout);

        MiaryStatystyczne statystyka = new MiaryStatystyczne();

        // dane pochodza z DaneUczniaActivity badz StatystykaActivity
        Bundle przekazanedane = getIntent().getExtras();
        String imie = przekazanedane.getString("imie");
        String nazwisko = przekazanedane.getString("nazwisko");
        String klasa = przekazanedane.getString("klasa");
        String przedmiot = przekazanedane.getString("przedmiot");
        ArrayList<String> oceny = przekazanedane.getStringArrayList("ocenyArray");

        String obliczona_srednia = Float.toString((float) statystyka.Srednia(oceny));

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