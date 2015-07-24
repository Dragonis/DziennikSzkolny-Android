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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edytujucznia_layout);

        Button zapisz = (Button) findViewById(R.id.zapisz_button_edytujucznia);


        zapisz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText id_edittext = (EditText) findViewById(R.id.id_edittext_edytujucznia);
                EditText imie_edittext = (EditText) findViewById(R.id.imie_edittext_edytujucznia);
                EditText nazwisko_edittext = (EditText) findViewById(R.id.nazwisko_edittext_edytujucznia);
                EditText klasa_edittext = (EditText) findViewById(R.id.klasa_edittext_edytujucznia);

                String id = id_edittext.getText().toString();
                String imie = imie_edittext.getText().toString();
                String nazwisko = nazwisko_edittext.getText().toString();
                String klasa = klasa_edittext.getText().toString();

                przeslijDaneDoWczesniejszegoActivity(id, imie, nazwisko, klasa);

            }
        });


        zamknijOkno(R.id.zamknij_button_edytujucznia);

    }

    public void przeslijDaneDoWczesniejszegoActivity(String id, String imie, String nazwisko, String klasa) {
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
