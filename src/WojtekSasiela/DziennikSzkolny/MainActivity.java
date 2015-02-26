package WojtekSasiela.DziennikSzkolny;

import WojtekSasiela.DziennikSzkolny.ORM.tables.Account;
import WojtekSasiela.DziennikSzkolny.ORM.configuration.DatabaseHelper;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.sql.SQLException;
import java.util.List;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    public static String TAG = "DziennikSzkolny";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        try {
            doNoteDataStuff();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Database databaseInstance = new Database(this,"Student.db",2);
        databaseInstance.db = openOrCreateDatabase("StudentDB.db", MODE_PRIVATE, null);
        databaseInstance.getAllData();

        //Pokaz_Activity(R.id.O_Autorze_Button, Intent.ACTION_VIEW, "http://www.google.pl");
        Pokaz_Activity_z_klasy(R.id.O_Autorze_Button, getApplicationContext(), OpcjeAcitivity.class);


        // Buttony przekierowywujace na konkretne Activity
        // laczy Vidok z Controllerem
        Pokaz_Activity_z_klasy(R.id.OpcjeButton, getApplicationContext(),OpcjeAcitivity.class);
        Pokaz_Activity_z_klasy(R.id.UczniowieButton, getApplicationContext(),ListaUczniowActivity.class);
        Pokaz_Activity_z_klasy(R.id.ZobaczStatyButton, getApplicationContext(), StatystykiActivity.class);
        Pokaz_Activity_z_klasy(R.id.ListaKlas_Button, getApplicationContext(), ListaKlasActivity.class);
        //BaseSQLite baseSQLite = BaseSQLite.getInstance(getApplicationContext());

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

    DatabaseHelper dbHelper;
    private void doNoteDataStuff() throws SQLException{
        dbHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
        RuntimeExceptionDao<Account, Integer> noteDao = dbHelper.getAccountRuntimeExceptionDao();

        noteDao.create(new Account("admin login", "admin password"));
        noteDao.create(new Account("Uzytkownik", "Haslo"));
        noteDao.create(new Account("root", "testABCD"));

        List<Account> notes = noteDao.queryForAll();
        Log.d("Demo", notes.toString());
        notes = noteDao.queryForEq("id", 1);
        Log.d("Demo", notes.toString());

        OpenHelperManager.releaseHelper();
    }

}
