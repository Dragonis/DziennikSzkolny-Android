package WojtekSasiela.DziennikSzkolny;

import WojtekSasiela.DziennikSzkolny.ORM.CRUD.CREATE.InsertDataToDatabase;
import WojtekSasiela.DziennikSzkolny.ORM.configuration.DatabaseAccessObjects;
import WojtekSasiela.DziennikSzkolny.ORM.tables.Student;
import WojtekSasiela.DziennikSzkolny.ORM.tables.new_version_database.Uczen;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

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

                EditText imie_edittext = (EditText) findViewById(R.id.imie_edittext_dodajucznia);
                EditText nazwisko_edittext = (EditText) findViewById(R.id.nazwisko_edittext_dodajucznia);
                EditText klasa_edittext = (EditText) findViewById(R.id.klasa_edittext_dodajucznia);

                String imie = imie_edittext.getText().toString();
                String nazwisko = nazwisko_edittext.getText().toString();
                String klasa = klasa_edittext.getText().toString();

                wprowadzUzytkownikaDoBazyDanych(imie, nazwisko, Integer.parseInt(klasa));
                przeslijDaneDoWczesniejszegoActivity(imie, nazwisko, klasa);

            }
        });

        zamknijOkno(R.id.zamknij_button_dodajucznia);

    }

    public void wprowadzUzytkownikaDoBazyDanych(String imie, String nazwisko, Integer klasa) {
        DatabaseAccessObjects dbHelper = OpenHelperManager.getHelper(getApplicationContext(), DatabaseAccessObjects.class);
        RuntimeExceptionDao<Uczen, Integer> uczenDao = dbHelper.getUczenRuntimeExceptionDao();
        InsertDataToDatabase.insert_new_Uczen_IntoDatabase(uczenDao, imie, nazwisko, klasa);
    }

    public void przeslijDaneDoWczesniejszegoActivity(String imie, String nazwisko, String klasa) {

        Bundle koszyk = new Bundle();
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
