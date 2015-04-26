package sasiela.wojtek.dziennikszkolny;

import sasiela.wojtek.dziennikszkolny.ORM.configuration.DatabaseHelper;
import sasiela.wojtek.dziennikszkolny.ORM.tables.Student;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;


/**
 * Created by Wojtek on 2015-03-08.
 */
public class DodajUczniaActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dodajucznia_layout);

        Button zapisz = (Button) findViewById(R.id.zapisz_button_dodajucznia);
        zapisz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO DOdanie uzytkownika do bazy danych

                EditText imie_edittext = (EditText) findViewById(R.id.imie_edittext_dodajucznia);
                EditText nazwisko_edittext = (EditText) findViewById(R.id.nazwisko_edittext_dodajucznia);
                EditText klasa_edittext = (EditText) findViewById(R.id.klasa_edittext_dodajucznia);

                String imie = imie_edittext.getText().toString();
                String nazwisko = nazwisko_edittext.getText().toString();
                String klasa = klasa_edittext.getText().toString();

                DatabaseHelper dbHelper = OpenHelperManager.getHelper(getApplicationContext(), DatabaseHelper.class);

                RuntimeExceptionDao<Student, Integer> StudentDao = dbHelper.getStudentRuntimeExceptionDao();

                wprowadzStudentadoBazyDanych(StudentDao,imie,nazwisko,klasa);
                przeslijDaneDoWczesniejszegoActivity(imie, nazwisko, klasa);
//
//                Toast.makeText(getApplicationContext(), "Użytkownik został zapisany",
//                        Toast.LENGTH_SHORT).show();

//                Toast.makeText(getApplicationContext(), "Imie: "+ imie + "Naziwsko: "+ nazwisko + "Klasa: "+ klasa,
//                        Toast.LENGTH_SHORT).show();
            }
        });

    zamknijOkno(R.id.zamknij_button_dodajucznia);


//        Button zamknij = (Button) findViewById(R.id.zamknij_button_dodajucznia);
//        zamknij.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//            }
//        });
}
    public void przeslijDaneDoWczesniejszegoActivity(String imie, String nazwisko, String klasa)
    {
        // Pobieramy tekst z pola

        // Pakujemy go w Bundle
        Bundle koszyk = new Bundle();
        koszyk.putString("Imie", imie);
        koszyk.putString("Nazwisko", nazwisko);
        koszyk.putString("Klasa", klasa);
        // Definiujemy cel
        Intent cel = new Intent(this, ListaKlasActivity.class);
        cel.putExtras(koszyk);
        // Wysyłamy
        startActivity(cel);
    }

    public void wprowadzStudentadoBazyDanych(RuntimeExceptionDao<Student, Integer> studentDao,String imie, String nazwisko,String nr_klasy){
        studentDao.create(new Student(imie,nazwisko,Integer.parseInt(nr_klasy)));
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
