package sasiela.wojtek.dziennikszkolny;


import android.accounts.Account;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.j256.ormlite.android.apptools.OpenHelperManager;

import java.util.List;

import sasiela.wojtek.dziennikszkolny.ORM.CRUD.CREATE.InsertDataToDatabase;
import sasiela.wojtek.dziennikszkolny.ORM.CRUD.DatabaseCRUDoperations;
import sasiela.wojtek.dziennikszkolny.ORM.CRUD.READ.LoadDataFromDatabase;
import sasiela.wojtek.dziennikszkolny.ORM.configuration.DatabaseAccessObjects;
import sasiela.wojtek.dziennikszkolny.ORM.tables.Student;
import sasiela.wojtek.dziennikszkolny.ORM.tables.new_version_database.Uczen;


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
    List<Uczen> accounts; // Pobrana lista osob z bazy danych
    String db_imie, db_nazwisko; // z accounts pobrano imie,nazwisko

    private TextView facebook_info;
    private LoginButton facebook_loginButton;
    private CallbackManager callbackManager;

    //endregion


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.logowanie_layout);

        callbackManager = CallbackManager.Factory.create();
        facebook_info = (TextView)findViewById(R.id.facebook_info);
        facebook_loginButton = (LoginButton)findViewById(R.id.facebook_login_button);

        //region Inicjalizacja_zmiennych
        login_intent = new Intent(getApplicationContext(), MainLobbyActivity.class);
        paczka = new Bundle();

        zaloguj = (Button) findViewById(R.id.zaloguj_button_logowanie);
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
                        Log.e("NoDatabaseError", "Nie moznna wprowadzic przykladowej bazydanych");
                        Toast.makeText(getApplicationContext(), "Nie moznna wprowadzic przykladowej bazydanych.", Toast.LENGTH_SHORT).show();
                    }


                } catch (Exception ex) {
                    ex.getStackTrace();
                }
            }
        });


        facebook_loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                facebook_info.setText(
                        "User ID: "
                                + loginResult.getAccessToken().getUserId()
                                + "\n" +
                                "Auth Token: "
                                + loginResult.getAccessToken().getToken()
                );
                Intent cel = new Intent(getApplicationContext(), FacebookActivity.class);
                startActivity(cel);
            }

            @Override
            public void onCancel() {
                facebook_info.setText("Login attempt canceled.");
            }

            @Override
            public void onError(FacebookException e) {
                facebook_info.setText("Login attempt failed.");
            }

        });
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Logs 'install' and 'app activate' App Events.
        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Logs 'app deactivate' App Event.
        AppEventsLogger.deactivateApp(this);
    }

    public List<Student> wczytajWszystkichStudentowzDB() {
        List<Student> students = LoadDataFromDatabase.load_all_Students_fromDatabase(getApplicationContext());
        return students;
    }

    public void SprawdzPoprawnoscDanychLogowania_PoCzymZalogujSie(String username, String password) {
        accounts = LoadDataFromDatabase.load_Konto_NewVersion_fromDatabase(username,password);
        if (accounts.size() == 0) {
            Toast.makeText(getApplicationContext(), "Nie ma takiego uzytkownika", Toast.LENGTH_SHORT).show();
        } else {
            przeslijDaneDoNastepnegoActivity(accounts.get(0));
        }
    }

    public void przeslijDaneDoNastepnegoActivity(Uczen account) {
        db_imie = account.getImie();
        db_nazwisko = account.getNazwisko();

        Bundle koszyk = new Bundle();
        koszyk.putString("Imie", db_imie);
        koszyk.putString("Nazwisko", db_nazwisko);
        Intent cel = new Intent(this, MainLobbyActivity.class);
        cel.putExtras(koszyk);

        setResult(RESULT_OK, login_intent);
        startActivity(cel);
    }


}