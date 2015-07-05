package WojtekSasiela.DziennikSzkolny;

import WojtekSasiela.DziennikSzkolny.ORM.CRUD.READ.LoadDataFromDatabase;
import WojtekSasiela.DziennikSzkolny.ORM.CRUD.UPDATE.UpdateDataInDatabase;
import WojtekSasiela.DziennikSzkolny.ORM.tables.Account;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

/**
 * Created by Wojtek on 2014-11-23.
 */
public class OpcjeAcitivity extends Activity {

    Button update_button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_opcje_layout);

        wybierzUzytkownikaZBazyDamych_i_wyswietlWTextEditach(3);

        update_button = (Button) findViewById(R.id.update_password_button);
        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateDataInDatabase.aktualizujDaneUzytkownika(3, "z", "z");
            }
        });

        // Laczy operacje zamkniecia z konkrentym buttonem
        zamknijOkno(R.id.BackOptionsButton);
    }

    public void wybierzUzytkownikaZBazyDamych_i_wyswietlWTextEditach(int uzytkownik_o_id) {

        List<Account> uzytkownicy = LoadDataFromDatabase.load_Account_fromDatabase(uzytkownik_o_id);
        Log.d("demo", "Login: " + uzytkownicy.get(0).getUsername().toString() + " Password: " + uzytkownicy.get(0).getPassword().toString());

        // wyswietlanei danych w widoku
        EditText login = (EditText)findViewById(R.id.editText_Login_Opcje);
        EditText password = (EditText)findViewById(R.id.editText2_Password_Opcje);

        login.setText(uzytkownicy.get(0).getUsername().toString());
        password.setText(uzytkownicy.get(0).getPassword().toString());

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