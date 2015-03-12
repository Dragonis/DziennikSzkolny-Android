package WojtekSasiela.DziennikSzkolny;

import WojtekSasiela.DziennikSzkolny.ORM.configuration.DatabaseHelper;
import WojtekSasiela.DziennikSzkolny.ORM.tables.Student;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
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
               // insert_Students_IntoDatabase(StudentDao);

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


    public void insert_Students_IntoDatabase(RuntimeExceptionDao<Student, Integer> studentDao) {
        studentDao.create(new Student("Wojtek", "Sasiela",1));
        studentDao.create(new Student("Anna", "Kowalska",1));
        studentDao.create(new Student("Joanna", "Pyrzyńska",1));
        studentDao.create(new Student("Izabela", "Tarnowska",1));
        studentDao.create(new Student("Blanka", "Szept",1));
        studentDao.create(new Student("Paweł", "Paluch",1));
        studentDao.create(new Student("Piotr", "Mały",1));
        studentDao.create(new Student("Karol", "Kopytko",1));
        studentDao.create(new Student("Arkadiusz", "Bąk",1));
        studentDao.create(new Student("Teresa", "Wawrzyniak",1));
        studentDao.create(new Student("Katarzyna", "Jagiełło",1));

        studentDao.create(new Student("111", "111",2));
        studentDao.create(new Student("222", "222",2));
        studentDao.create(new Student("333", "333",2));
//        studentDao.create(new Student("333", "333",2));
//        studentDao.create(new Student("4444", "444",2));
//        studentDao.create(new Student("555", "555",2));
//        studentDao.create(new Student("666", "666",2));
//        studentDao.create(new Student("777", "777",2));
//        studentDao.create(new Student("888", "888",2));
//        studentDao.create(new Student("999", "999",2));

        studentDao.create(new Student("AAA", "AAA",3));
        studentDao.create(new Student("BBB", "BBB",3));
        studentDao.create(new Student("CCC", "CCC",3));
        studentDao.create(new Student("DDD", "DDD",3));
        studentDao.create(new Student("EEE", "EEE",3));
//        studentDao.create(new Student("FFF", "FFF",3));
//        studentDao.create(new Student("GGG", "GGG",3));
//        studentDao.create(new Student("HHH", "HHH",3));
//        studentDao.create(new Student("III", "III",3));
//        studentDao.create(new Student("JJJ", "JJJ",3));

        studentDao.create(new Student("4", "klasa",4));
//        studentDao.create(new Student("czwarta", "test",4));
//        studentDao.create(new Student("IV", "test2",4));
//        studentDao.create(new Student("qqq", "qqq",4));
//        studentDao.create(new Student("www", "www",4));
//        studentDao.create(new Student("eee", "eee",4));

        studentDao.create(new Student("V", "abc",5));
        studentDao.create(new Student("5", "z",5));
//        studentDao.create(new Student("piata", "y",5));
//        studentDao.create(new Student("aaa", "aaa",5));
//        studentDao.create(new Student("sss", "sss",5));
//        studentDao.create(new Student("dddd", "ddd",5));

        studentDao.create(new Student("VI", "numera",6));
        studentDao.create(new Student("6", "dzwiek",6));
        studentDao.create(new Student("szosta", "woda",6));
        studentDao.create(new Student("ppp", "ppp",6));
        studentDao.create(new Student("ccc", "ccc",6));
        studentDao.create(new Student("nnn", "nnn",6));
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
