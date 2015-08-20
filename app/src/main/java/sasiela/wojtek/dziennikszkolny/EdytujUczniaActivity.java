package sasiela.wojtek.dziennikszkolny;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Wojtek on 2015-03-08.
 */
public class EdytujUczniaActivity extends Activity {

    private String imie;
    private String nazwisko;
    private String klasa;
    private String przedmiot;

    EditText imie_editbox;
    EditText nazwisko_edittext;
    EditText klasa_edittext;
    Button zapisz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edytujucznia_layout);

        odbierzDanezPoprzedniegoActivity_iWyswietl();
        aktualizujUczniawBazieDanych();
        imie_editbox = (EditText) findViewById(R.id.imie_edittext_edytujucznia);
        nazwisko_edittext = (EditText) findViewById(R.id.nazwisko_edittext_edytujucznia);
        klasa_edittext = (EditText) findViewById(R.id.klasa_edittext_edytujucznia);
        zapisz = (Button) findViewById(R.id.zapisz_button_edytujucznia);

        imie_editbox.setText(imie);
        nazwisko_edittext.setText(nazwisko);
        klasa_edittext.setText(klasa);

        zapisz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(), "Dany zostały zmienione",
//                        Toast.LENGTH_SHORT).show();
                EditText id_edittext = (EditText) findViewById(R.id.id_edittext_edytujucznia);
                EditText imie_edittext = (EditText) findViewById(R.id.imie_edittext_edytujucznia);
                EditText nazwisko_edittext = (EditText) findViewById(R.id.nazwisko_edittext_edytujucznia);
                EditText klasa_edittext = (EditText) findViewById(R.id.klasa_edittext_edytujucznia);

                String id = id_edittext.getText().toString();
                String imie = imie_edittext.getText().toString();
                String nazwisko = nazwisko_edittext.getText().toString();
                String klasa = klasa_edittext.getText().toString();

                przeslijDaneDoWczesniejszegoActivity(id,imie,nazwisko,klasa);

//                Toast.makeText(getApplicationContext(), "ID: "+ id + " ZMIENIONO NA: Imie: "+ imie + " Naziwsko: "+ nazwisko + " Klasa: "+ klasa,
//                        Toast.LENGTH_SHORT).show();

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

    private void aktualizujUczniawBazieDanych() {
        
    }


    public void odbierzDanezPoprzedniegoActivity_iWyswietl() {
        Bundle przekazanedane = getIntent().getExtras();

        imie = przekazanedane.getString("Imie");
        nazwisko = przekazanedane.getString("Nazwisko");
        klasa = przekazanedane.getString("Klasa");
        przedmiot = przekazanedane.getString("Przedmiot");
    }

    public void przeslijDaneDoWczesniejszegoActivity(String id, String imie, String nazwisko, String klasa)
    {
        // Pobieramy tekst z pola

        // Pakujemy go w Bundle
        Bundle koszyk = new Bundle();
        koszyk.putString("Id", id);
        koszyk.putString("Imie", imie);
        koszyk.putString("Nazwisko", nazwisko);
        koszyk.putString("Klasa", klasa);
        // Definiujemy cel
        Intent cel = new Intent(this, ListaKlasActivity.class);
        cel.putExtras(koszyk);
        // Wysyłamy
        startActivity(cel);
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
