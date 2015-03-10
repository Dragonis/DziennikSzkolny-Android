package WojtekSasiela.DziennikSzkolny;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Wojtek on 2015-03-08.
 */
public class DodajUczniaActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dodajucznia_layout);

        Button zapisz = (Button) findViewById(R.id.zapisz_button_dodajucznia);
        zapisz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO DOdanie uzytkownika do bazy danych

                EditText imie_edittext = (EditText) findViewById(R.id.imie_edittext_dodajucznia);
                EditText nazwisko_edittext = (EditText) findViewById(R.id.nazwisko_edittext_dodajucznia);
                EditText klasa_edittext = (EditText) findViewById(R.id.klasa_edittext_dodajucznia);

                String imie = imie_edittext.getText().toString();
                String nazwisko = nazwisko_edittext.getText().toString();
                String klasa = klasa_edittext.getText().toString();

                przeslijDaneDoWczesniejszegoActivity(imie, nazwisko, klasa);
//
//                Toast.makeText(getApplicationContext(), "Użytkownik został zapisany",
//                        Toast.LENGTH_SHORT).show();

                Toast.makeText(getApplicationContext(), "Imie: "+ imie + "Naziwsko: "+ nazwisko + "Klasa: "+ klasa,
                        Toast.LENGTH_SHORT).show();
            finish();
            }
        });

    zamknijOkno(R.id.zamknij_button_dodajucznia);


//        Button zamknij = (Button) findViewById(R.id.zamknij_button_dodajucznia);
//        zamknij.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//            }
//        });
}
    public void przeslijDaneDoWczesniejszegoActivity(String imie, String nazwisko, String klasa)
    {

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
