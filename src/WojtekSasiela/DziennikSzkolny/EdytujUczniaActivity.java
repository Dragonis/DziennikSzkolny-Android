package WojtekSasiela.DziennikSzkolny;

import android.app.Activity;
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
//                Toast.makeText(getApplicationContext(), "Dany zostały zmienione",
//                        Toast.LENGTH_SHORT).show();
                EditText id_edittext = (EditText) findViewById(R.id.id_edittext_edytujucznia);
                EditText imie_edittext = (EditText) findViewById(R.id.imie_edittext_edytujucznia);
                EditText nazwisko_edittext = (EditText) findViewById(R.id.nazwisko_edittext_edytujucznia);
                EditText klasa_edittext = (EditText) findViewById(R.id.klasa_edittext_edytujucznia);

                String id = imie_edittext.getText().toString();
                String imie = imie_edittext.getText().toString();
                String nazwisko = nazwisko_edittext.getText().toString();
                String klasa = klasa_edittext.getText().toString();

                przeslijDaneDoWczesniejszegoActivity(imie,nazwisko,klasa);

                Toast.makeText(getApplicationContext(), "ID: "+ id + " ZMIENIONO NA: Imie: "+ imie + " Naziwsko: "+ nazwisko + " Klasa: "+ klasa,
                        Toast.LENGTH_SHORT).show();

                finish();
            }
        });


        zamknijOkno(R.id.zamknij_button_edytujucznia);

//        Button zamknij = (Button) findViewById(R.id.zamknij_button_edytujucznia);
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
