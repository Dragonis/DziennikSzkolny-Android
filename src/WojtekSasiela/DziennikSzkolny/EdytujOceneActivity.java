package WojtekSasiela.DziennikSzkolny;

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
public class EdytujOceneActivity extends Activity {

    String imie;
    String nazwisko;
    String klasa;
    String przedmiot;
    String data;
    String ocena;

    String imie_UTF8;
    String nazwisko_UTF8;

    EditText data_edittext;
    EditText ocena_edittext;
    TextView imie_nazwisko_textview;
    TextView przedmiot_textview;
    TextView klasa_textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edytujocene_layout);

        pobierzzDaneUczniaCtivity();

        zamknijOkno(R.id.zamknij_edytujocene_button);

        data_edittext = (EditText) findViewById(R.id.editText);
        ocena_edittext = (EditText) findViewById(R.id.editText2);
        imie_nazwisko_textview = (TextView) findViewById(R.id.imieNazwisko_textview_edytujocene);
        klasa_textview = (TextView) findViewById(R.id.klasa_textview_edytujocene);
        przedmiot_textview = (TextView) findViewById(R.id.przedmiot_textview_edytujocene);

        data_edittext.setText(data);
        ocena_edittext.setText(ocena);
        imie_nazwisko_textview.setText(imie_UTF8 + " " + nazwisko_UTF8);
        klasa_textview.setText(klasa);
        przedmiot_textview.setText(przedmiot);

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

    public void pobierzzDaneUczniaCtivity() {

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
}
