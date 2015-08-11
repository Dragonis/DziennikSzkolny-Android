package sasiela.wojtek.dziennikszkolny;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.List;

import sasiela.wojtek.dziennikszkolny.ORM.CRUD.READ.LoadDataFromDatabase;
import sasiela.wojtek.dziennikszkolny.ORM.CRUD.UPDATE.UpdateDataInDatabase;
import sasiela.wojtek.dziennikszkolny.ORM.tables.new_version_database.Konto;

/**
 * Created by Wojtek on 2014-11-23.
 */
public class OpcjeAcitivity extends Activity {

    private Button update_button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opcje_layout);

        wybierzUzytkownikaZBazyDamych_i_wyswietlWTextEditach(1);

        update_button = (Button) findViewById(R.id.update_password_button);
        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int ID_Account_toModyfy = 3;
                String nowy_login = "z";
                String nowe_haslo = "z";

                UpdateDataInDatabase.aktualizujDaneUzytkownika(ID_Account_toModyfy, nowy_login, nowe_haslo);
                // UWAGA:
                // Po uzyciu ponizszej instrukcji, rekord zostanie usuniety w bazie danych,
                // tylko ze problemem jest to ze program korzysta z pierwotnie stworzonej bazy,
                // a nie tej zaaktualizowanej bazy, z usunietymi rekordami, ponizsza instrukcja
                //DeleteDataFromDatabase.usunDaneUzytkownika(ID_Account_toModyfy);
            }
        });

        // Laczy operacje zamkniecia z konkrentym buttonem
        zamknijOkno(R.id.BackOptionsButton);
    }

    public void wybierzUzytkownikaZBazyDamych_i_wyswietlWTextEditach(int uzytkownik_o_id) {

        List<Konto> uzytkownicy = LoadDataFromDatabase.load_Konto_Nev_Version_fromDatabase(uzytkownik_o_id);
        Log.d("demo", "Login: " + uzytkownicy.get(0).getUsername().toString() + " Password: " + uzytkownicy.get(0).getPassword().toString());

        // wyswietlanei danych w widoku
        EditText login = (EditText) findViewById(R.id.editText_Login_Opcje);
        EditText password = (EditText) findViewById(R.id.editText2_Password_Opcje);

        login.setText(uzytkownicy.get(0).getUsername().toString());
        password.setText(uzytkownicy.get(0).getPassword().toString());

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