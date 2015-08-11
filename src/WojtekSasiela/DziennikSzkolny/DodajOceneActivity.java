package WojtekSasiela.DziennikSzkolny;

import WojtekSasiela.DziennikSzkolny.ORM.CRUD.CREATE.InsertDataToDatabase;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Wojtek on 2015-03-10.
 */
public class DodajOceneActivity extends Activity {

    String imie, nazwisko, klasa, przedmiot, ocena, data;

    String imie_UTF8, nazwisko_UTF8;

    EditText data_edittext_dodajocene, ocena_edittext_dodajocene;
    TextView imie_nazwisko_textview_dodajocene, przedmiot_textview_dodajocene, klasa_textview_dodajocene;
    Button zamknij_dodajocene_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dodajocene_layout);
        zamknijOkno(R.id.zamknij_dodajocene_button);

        imicjalizujFormatke();

        pobierzzDaneUczniaActivity();

        zamknij_dodajocene_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ocena = ocena_edittext_dodajocene.getText().toString();
                data = data_edittext_dodajocene.getText().toString();

                InsertDataToDatabase.dodajOceneIDateUczniowioDanymImieniuiNazwisku(imie, nazwisko, przedmiot, Integer.parseInt(ocena), data);

                Toast.makeText(getApplicationContext(),"Dodano ocenê.", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void imicjalizujFormatke() {
        data_edittext_dodajocene = (EditText) findViewById(R.id.data_edittext_dodajocene);
        ocena_edittext_dodajocene = (EditText) findViewById(R.id.ocena_edittext_dodajocene);
        imie_nazwisko_textview_dodajocene = (TextView) findViewById(R.id.imieNazwisko_textview_dodajocene);
        klasa_textview_dodajocene = (TextView) findViewById(R.id.klasa_textview_dodajocene);
        przedmiot_textview_dodajocene = (TextView) findViewById(R.id.przedmiot_textview_dodajocene);
        zamknij_dodajocene_button = (Button) findViewById(R.id.zamknij_dodajocene_button);

        imie_nazwisko_textview_dodajocene.setText(imie_UTF8 + " " + nazwisko_UTF8);
        klasa_textview_dodajocene.setText(klasa);
        przedmiot_textview_dodajocene.setText(przedmiot);
    }

    public void pobierzzDaneUczniaActivity() {

        Bundle przekazanedane = getIntent().getExtras();

        data = przekazanedane.getString("Data");
        ocena = przekazanedane.getString("Ocena");
        imie = przekazanedane.getString("Imie");
        nazwisko = przekazanedane.getString("Nazwisko");
        klasa = przekazanedane.getString("Klasa");
        przedmiot = przekazanedane.getString("Przedmiot");
        try {
            byte[] imie_bytes = imie.getBytes("UTF-8");
            byte[] nazwisko_bytes = nazwisko.getBytes("UTF-8");

            imie_UTF8 = new String(imie_bytes, "UTF-8");
            nazwisko_UTF8 = new String(nazwisko_bytes, "UTF-8");

            Toast.makeText(getApplicationContext(), "Imie: " + imie_UTF8 + "Nazwisko: " + nazwisko_UTF8 + "Klasa: " + klasa,
                    Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.getStackTrace();
        }

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
