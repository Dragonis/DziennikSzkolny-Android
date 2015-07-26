package WojtekSasiela.DziennikSzkolny;

import WojtekSasiela.DziennikSzkolny.ORM.CRUD.READ.LoadDataFromDatabase;
import WojtekSasiela.DziennikSzkolny.ORM.configuration.DatabaseAccessObjects;
import WojtekSasiela.DziennikSzkolny.ORM.tables.Account;
import WojtekSasiela.DziennikSzkolny.ORM.CRUD.DatabaseCRUDoperations;
import WojtekSasiela.DziennikSzkolny.ORM.tables.Student;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.j256.ormlite.android.apptools.OpenHelperManager;

import java.util.List;

import static WojtekSasiela.DziennikSzkolny.R.id.zaloguj_button_logowanie;

/**
 * Created by Wojtek on 2015-03-18.
 */
public class LogowanieActivity extends Activity {

    //region Zmienne
    Button zaloguj, zamknij, przykladowa_baza_danych_button;
    TextView login_textview, password_textview;
    Intent login_intent, exit_intent;
    Bundle paczka;
    String textview_username, textview_password;
    List<Account> accounts; // Pobrana lista osob z bazy danych
    String db_imie, db_nazwisko; // z accounts pobrano imie,nazwisko
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logowanie_layout);

        //region Inicjalizacja_zmiennych
        login_intent = new Intent(getApplicationContext(), MainLobbyActivity.class);
        paczka = new Bundle();
        zaloguj = (Button) findViewById(zaloguj_button_logowanie);
        zamknij = (Button) findViewById(R.id.zamknij_button_logowanie);
        przykladowa_baza_danych_button = (Button) findViewById(R.id.przykladowabazaDanychButton);
        login_textview = (TextView) findViewById(R.id.loginTextView);
        password_textview = (TextView) findViewById(R.id.passwordTextView);
        //endregion

        wczytajWszystkichStudentowzDB();

        zaloguj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textview_username = login_textview.getText().toString();
                textview_password = password_textview.getText().toString();

                SprawdzPoprawnoscDanychLogowania_PoCzymZalogujSie(textview_username, textview_password);
            }
        });

        zamknij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });

        przykladowa_baza_danych_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatabaseAccessObjects dbHelper = OpenHelperManager.getHelper(getApplicationContext(), DatabaseAccessObjects.class);
                try {

                    DatabaseCRUDoperations crud = new DatabaseCRUDoperations(dbHelper);
                    try {
                        crud.insert_sample_database();
                        Toast.makeText(getApplicationContext(), "Zaladowano przykladowa baze danych.", Toast.LENGTH_SHORT).show();
                    }catch(Exception ex0) {
                        Log.e("NoDatabaseError","Nie moznna wprowadzic przykladowej bazydanych");
                        Toast.makeText(getApplicationContext(), "Nie moznna wprowadzic przykladowej bazydanych.", Toast.LENGTH_SHORT).show();
                    }


                } catch (Exception ex) {
                    ex.getStackTrace();
                }
            }
        });

    }

    public List<Student> wczytajWszystkichStudentowzDB() {
        List<Student> students = LoadDataFromDatabase.load_all_Students_fromDatabase(getApplicationContext());
        return students;
    }

    public void SprawdzPoprawnoscDanychLogowania_PoCzymZalogujSie(String username, String password) {
        accounts = LoadDataFromDatabase.load_Account_fromDatabase(username);
        if (accounts.size() == 0) {
            Toast.makeText(getApplicationContext(), "Nie ma takiego uzytkownika", Toast.LENGTH_SHORT).show();
        } else {
            db_imie = accounts.get(0).getName();
            db_nazwisko = accounts.get(0).getSurname();
            login_intent.putExtras(paczka);

            setResult(RESULT_OK, login_intent);
            startActivity(login_intent);
        }
    }


}
