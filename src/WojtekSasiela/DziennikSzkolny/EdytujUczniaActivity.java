package WojtekSasiela.DziennikSzkolny;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Wojtek on 2015-03-08.
 */
public class EdytujUczniaActivity extends Activity {

    Button zapisz;
    EditText id_edittext;
    EditText imie_edittext;
    EditText nazwisko_edittext;
    EditText klasa_edittext;

    String id,imie,nazwisko,klasa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edytujucznia_layout);

        inicjalizujKomponentyInterfejsu();
        pobierzDanezListaKlasActivity();
        ustawWartosciKomponentomInterfejsu(id_edittext, imie_edittext, nazwisko_edittext, klasa_edittext);

        zapisz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                przypisWartosciZmiennymLokalnymZKomponentowGraficznych(id_edittext, imie_edittext, nazwisko_edittext, klasa_edittext);
                przeslijDaneDoWczesniejszegoActivity();
            }
        });
        zamknijOkno(R.id.zamknij_button_edytujucznia);
    }

    public void inicjalizujKomponentyInterfejsu() {
        id_edittext = (EditText) findViewById(R.id.id_edittext_edytujucznia);
        imie_edittext = (EditText) findViewById(R.id.imie_edittext_edytujucznia);
        nazwisko_edittext = (EditText) findViewById(R.id.nazwisko_edittext_edytujucznia);
        klasa_edittext = (EditText) findViewById(R.id.klasa_edittext_edytujucznia);
        zapisz = (Button) findViewById(R.id.zapisz_button_edytujucznia);
    }

    public void przypisWartosciZmiennymLokalnymZKomponentowGraficznych(EditText id_edittext, EditText imie_edittext, EditText nazwisko_edittext, EditText klasa_edittext) {
        id = id_edittext.getText().toString();
        imie = imie_edittext.getText().toString();
        nazwisko = nazwisko_edittext.getText().toString();
        klasa = klasa_edittext.getText().toString();
    }

    public void ustawWartosciKomponentomInterfejsu(EditText id_edittext, EditText imie_edittext, EditText nazwisko_edittext, EditText klasa_edittext) {
        id_edittext.setText(id);
        imie_edittext.setText(imie);
        nazwisko_edittext.setText(nazwisko);
        klasa_edittext.setText(klasa);
    }

    public void pobierzDanezListaKlasActivity() {

        Bundle przekazanedane = getIntent().getExtras();

        id = przekazanedane.getString("Id");
        imie = przekazanedane.getString("Imie");
        nazwisko = przekazanedane.getString("Nazwisko");
        klasa = przekazanedane.getString("nrKlasy");

        Toast.makeText(getApplicationContext(),
                "Imie: " + imie + "Nazwisko: " + nazwisko + "Klasa: " + klasa ,
                Toast.LENGTH_SHORT).show();

    }

    public void przeslijDaneDoWczesniejszegoActivity() {
        Bundle koszyk = new Bundle();
        koszyk.putString("Id", id);
        koszyk.putString("Imie", imie);
        koszyk.putString("Nazwisko", nazwisko);
        koszyk.putString("Klasa", klasa);
        Intent cel = new Intent(this, ListaKlasActivity.class);
        cel.putExtras(koszyk);
        startActivity(cel);
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
