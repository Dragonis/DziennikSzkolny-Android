package WojtekSasiela.DziennikSzkolny;

import WojtekSasiela.DziennikSzkolny.ORM.configuration.DatabaseHelper;
import WojtekSasiela.DziennikSzkolny.ORM.tables.Account;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.List;

/**
 * Created by Wojtek on 2014-11-23.
 */
public class OpcjeAcitivity extends Activity {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_opcje_layout);
        doORMAccountDatabaseStuff();

        // Laczy operacje zamkniecia z konkrentym buttonem
        zamknijOkno(R.id.BackOptionsButton);
    }

    public void doORMAccountDatabaseStuff() {

        // POBIERASZ REKORDY Z BAZY DANYCH PO CZYM WYSWIETLASZ
        DatabaseHelper dh = OpenHelperManager.getHelper(this,DatabaseHelper.class);
        RuntimeExceptionDao<Account, Integer> userDao = dh.getAccountRuntimeExceptionDao();

        //pobieranie i wyswietlanei danych

        List<Account> uzytkownicy = userDao.queryForEq("id", 1);
        Log.d("demo", "Login: " + uzytkownicy.get(0).getUsername().toString() + " Password: " + uzytkownicy.get(0).getPassword().toString());

        // wyswietlanei danych w widoku
        EditText login = (EditText)findViewById(R.id.editText_Login_Opcje);
        EditText password = (EditText)findViewById(R.id.editText2_Password_Opcje);

        login.setText(uzytkownicy.get(0).getUsername().toString());
        password.setText(uzytkownicy.get(0).getPassword().toString());

        OpenHelperManager.releaseHelper();

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