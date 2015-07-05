package WojtekSasiela.DziennikSzkolny;

import WojtekSasiela.DziennikSzkolny.ORM.CRUD.READ.LoadDataFromDatabase;
import WojtekSasiela.DziennikSzkolny.ORM.configuration.DatabaseAccessObjects;
import WojtekSasiela.DziennikSzkolny.ORM.tables.Account;
import WojtekSasiela.DziennikSzkolny.ORM.tables.Student;
import WojtekSasiela.DziennikSzkolny.ORM.CRUD.DatabaseCRUDoperations;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.List;

import static WojtekSasiela.DziennikSzkolny.R.id.zaloguj_button_logowanie;

/**
 * Created by Wojtek on 2015-03-18.
 */
public class LogowanieActivity extends Activity {

    Button zaloguj, zamknij, przykladowa_baza_danych_button;
    TextView login_textview, password_textview;
    Intent intent;  Bundle koszyk;
    String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logowanie_layout);
        intent = new Intent(getApplicationContext(), MainActivity.class);
        koszyk = new Bundle();
        zaloguj = (Button) findViewById(zaloguj_button_logowanie);
        zamknij = (Button) findViewById(R.id.zamknij_button_logowanie);
        przykladowa_baza_danych_button = (Button) findViewById(R.id.przykladowabazaDanychButton);
        login_textview = (TextView) findViewById(R.id.loginTextView);
        password_textview = (TextView) findViewById(R.id.passwordTextView);


        zaloguj.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            LoadDataFromDatabase.load_all_Students_fromDatabase(getApplicationContext());

            username = login_textview.getText().toString();
            password = password_textview.getText().toString();

            //TODO sprawdzanie czy dane logowania sa poprawne
            List<Account> accounts = LoadDataFromDatabase.load_Account_fromDatabase(username);
           if (accounts.size() == 0)
           {
               Toast.makeText(getApplicationContext(),"Nie ma takiego uzytkownika",Toast.LENGTH_SHORT).show();
           }else {

               String imie = accounts.get(0).getName();
               String nazwisko = accounts.get(0).getSurname();

               koszyk.putString("Imie", imie);
               koszyk.putString("Nazwisko", nazwisko);
               intent.putExtras(koszyk);

               setResult(RESULT_OK, intent);
               startActivity(intent);
           }
        }
    });

        zamknij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("EXIT", true);
                startActivity(intent);

                finish();
                System.exit(0);

            }
        });

przykladowa_baza_danych_button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        try{
            DatabaseCRUDoperations.insert_sample_database();
            DatabaseCRUDoperations.load_sample_database();

        }catch(Exception ex){
            ex.getStackTrace();
        }
    }
});

    }

    public void Pokaz_Activity_z_klasy(int id, final Context context, final Class<?> klasa)
    {
        Button b = (Button)findViewById(id);
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
}
