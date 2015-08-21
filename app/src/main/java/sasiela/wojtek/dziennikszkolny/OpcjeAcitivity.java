package sasiela.wojtek.dziennikszkolny;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import sasiela.wojtek.dziennikszkolny.ORM.CRUD.READ.LoadDataFromDatabase;
import sasiela.wojtek.dziennikszkolny.ORM.CRUD.UPDATE.UpdateDataInDatabase;
import sasiela.wojtek.dziennikszkolny.ORM.tables.new_version_database.Konto;

/**
 * Created by Wojtek on 2014-11-23.
 */
public class OpcjeAcitivity extends Activity {

    private Button update_button;
    private String stary_login;
    private String stare_haslo;
    private EditText login_edittext;
    private EditText password_edittext;
    private String nowyLogin;
    private String noweHaslo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opcje_layout);

        wybierzUzytkownikaZBazyDamych_i_wyswietlWTextEditach(1);

        update_button = (Button) findViewById(R.id.update_password_button);
        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

           nowyLogin = login_edittext.getText().toString();
           noweHaslo =  password_edittext.getText().toString();

           UpdateDataInDatabase.aktualizujDaneKontaUzytkownika(stary_login,stare_haslo,nowyLogin,noweHaslo);
                Toast.makeText(OpcjeAcitivity.this, "Zmieniono dane.", Toast.LENGTH_SHORT).show();
           }
        });

        // Laczy operacje zamkniecia z konkrentym buttonem
        zamknijOkno(R.id.BackOptionsButton);
    }


    public void wybierzUzytkownikaZBazyDamych_i_wyswietlWTextEditach(int uzytkownik_o_id) {

        List<Konto> uzytkownicy = LoadDataFromDatabase.load_Konto_Nev_Version_fromDatabase(uzytkownik_o_id);
        Log.d("demo", "Login: " + uzytkownicy.get(0).getUsername().toString() + " Password: " + uzytkownicy.get(0).getPassword().toString());

        // wyswietlanei danych w widoku
        login_edittext = (EditText) findViewById(R.id.editText_Login_Opcje);
        password_edittext = (EditText) findViewById(R.id.editText2_Password_Opcje);
        stary_login = uzytkownicy.get(0).getUsername().toString();
        stare_haslo = uzytkownicy.get(0).getPassword().toString();
        login_edittext.setText(stary_login);
        password_edittext.setText(stare_haslo);

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