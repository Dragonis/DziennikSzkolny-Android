package WojtekSasiela.DziennikSzkolny;

import WojtekSasiela.DziennikSzkolny.ORM.configuration.DatabaseHelper;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.j256.ormlite.android.apptools.OpenHelperManager;

import java.sql.SQLException;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    public static String TAG = "DziennikSzkolny";

    Button zamknij_aplikacje;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        odbierzDanezPoprzedniegoActivity_iWyswietl();

        zamknij_aplikacje = (Button) findViewById(R.id.zamknijaplikacje_button);

        try {
            DatabaseCRUDoperations dbo = new DatabaseCRUDoperations();
            DatabaseHelper dbHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
            dbo.doAccountDataStuff(dbHelper);
        } catch (SQLException e) {
            Toast.makeText(getApplicationContext(), "Nie mozna wprowadzic danych do BazyDanych",
                    Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

        zamknij_aplikacje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
//        Pokaz_Activity(R.id.O_Autorze_Button, Intent.ACTION_VIEW, "http://www.google.pl");
        Pokaz_Activity_z_klasy(R.id.Wyloguj_button, getApplicationContext(), LogowanieActivity.class);


        // Buttony przekierowywujace na konkretne Activity
        // laczy Vidok z Controllerem
        Pokaz_Activity_z_klasy(R.id.OpcjeButton, getApplicationContext(), OpcjeAcitivity.class);
        Pokaz_Activity_z_klasy(R.id.UczniowieButton, getApplicationContext(), OAutorzeActivity.class);
        Pokaz_Activity_z_klasy(R.id.ZobaczStatyButton, getApplicationContext(), StatystykiActivity.class);
        Pokaz_Activity_z_klasy(R.id.ListaKlas_Button, getApplicationContext(), ListaKlasActivity.class);
        //BaseSQLite baseSQLite = BaseSQLite.getInstance(getApplicationContext());

        // Zamkniecie aplikacji po kliknieicu na Zakoncz aplikacje w LogowanieActivity
        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }
    }

    public void Pokaz_Activity_z_klasy(int id, final Context context, final Class<?> klasa) {
        Button b = (Button) findViewById(id);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, klasa);

                if (intent.resolveActivity(getPackageManager()) != null)
                    startActivity(intent);
                else {
                    Toast.makeText(getApplicationContext(), "Niestety, ale startActivityForResult wywala blad.",
                            Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    public void odbierzDanezPoprzedniegoActivity_iWyswietl() {
        Bundle przekazanedane = getIntent().getExtras();

        String login = przekazanedane.getString("Imie");
        String password = przekazanedane.getString("Nazwisko");
        TextView imieinazwisko = (TextView) findViewById(R.id.textviewImieiNazwisko);
        imieinazwisko.setText(login + " " + password);
    }

}
