package WojtekSasiela.DziennikSzkolny.Fragments;

import WojtekSasiela.DziennikSzkolny.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Wojtek on 2014-11-23.
 */
public class SredniaAcitivity extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_srednia_layout);

        // dane pochodza z DaneUczniaActivity badz StatystykaActivity
        Bundle przekazanedane = getIntent().getExtras();
        String imie = przekazanedane.getString("imie");
        String nazwisko = przekazanedane.getString("nazwisko");
        String klasa = przekazanedane.getString("klasa");
        String przedmiot = przekazanedane.getString("przedmiot");

        TextView textView12 = (TextView) findViewById(R.id.textView10);
        textView12.setText(imie + " " + nazwisko);

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