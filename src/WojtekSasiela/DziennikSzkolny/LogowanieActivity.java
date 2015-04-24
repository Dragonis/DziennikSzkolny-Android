package WojtekSasiela.DziennikSzkolny;

import WojtekSasiela.DziennikSzkolny.ORM.configuration.DatabaseHelper;
import WojtekSasiela.DziennikSzkolny.ORM.tables.Account;
import WojtekSasiela.DziennikSzkolny.ORM.tables.Student;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.sql.SQLException;
import java.util.List;

import static WojtekSasiela.DziennikSzkolny.R.id.zaloguj_button_logowanie;

/**
 * Created by Wojtek on 2015-03-18.
 */
public class LogowanieActivity extends Activity {

    Button zaloguj;
    Button zamknij;
    Button przykladowa_baza_danych_button;
    DatabaseHelper dbHelper;
    RuntimeExceptionDao<Account, Integer> AccountDao;
    RuntimeExceptionDao<Student, Integer> StudentDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logowanie_layout);


        zaloguj = (Button) findViewById(zaloguj_button_logowanie);
        zamknij = (Button) findViewById(R.id.zamknij_button_logowanie);
        przykladowa_baza_danych_button = (Button) findViewById(R.id.przykladowabazaDanychButton);

        dbHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);

    zaloguj.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            AccountDao = dbHelper.getAccountRuntimeExceptionDao();
            StudentDao = dbHelper.getStudentRuntimeExceptionDao();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            Bundle koszyk = new Bundle();

            TextView login_textview = (TextView) findViewById(R.id.loginTextView);
            TextView password_textview = (TextView) findViewById(R.id.passwordTextView);

            String username = login_textview.getText().toString();
            String password = password_textview.getText().toString();

            //TODO sprawdzanie czy dane logowania sa poprawne
            List<Account> accounts = AccountDao.queryForEq("username", username);

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
        DatabaseCRUDoperations crud = new DatabaseCRUDoperations();
        try{
            crud.insert_Accounts_IntoDatabase(AccountDao);
            crud.insert_Students_IntoDatabase(StudentDao);
            crud.insert_sample_database();
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
