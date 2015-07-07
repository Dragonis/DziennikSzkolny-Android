package WojtekSasiela.DziennikSzkolny;

import WojtekSasiela.DziennikSzkolny.StatisticActivity.*;
import WojtekSasiela.DziennikSzkolny.ORM.configuration.DatabaseAccessObjects;
import WojtekSasiela.DziennikSzkolny.ORM.tables.Student;
import WojtekSasiela.DziennikSzkolny.ORM.tables.subjects.Biology;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by Wojtek on 2015-01-28.
 */
public class DaneUczniaActivity extends Activity {

    private ArrayList<HashMap<String, String>> list;
    String Imie = "";
    String Nazwisko = "";
    String nrKlasy = "";
    String przedmiot = "";
    ArrayList<String> oceny_z_przyrody = new ArrayList<String>();
    ArrayList<String> daty_z_przyrody = new ArrayList<String>();
    //    ListView data_z_ocena_listview;
    Intent cel;
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;

    Button edytujocene;
    Button usunocene;
    Button dodajocene;

    // daty wpisu i oceny ucznia
    String grade1;
    String grade2;
    String grade3;
    String date1;
    String date2;
    String date3;

    boolean zaznaczony_jakikolwiek_checkbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dane_ucznia_layout);

        radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        edytujocene = (Button) findViewById(R.id.edytuj_ocene_button_daneucznia);
        usunocene = (Button) findViewById(R.id.usun_ocene_button_daneucznia);
        dodajocene = (Button) findViewById(R.id.dodaj_ocene_button_daneucznia);
        zaznaczony_jakikolwiek_checkbox = false;

//        data_z_ocena_listview = (ListView) findViewById(R.id.data_z_ocena_listview);
        pobierzDanezPoprzedniegoActivity();
        zamknijOkno(R.id.Wyjdzbttn_OcenyLayout);


        // wyswitlanie odpowiednich activity statystycznych
        Pokaz_Activity_z_klasy(R.id.dodaj_ocene_button_daneucznia, getApplicationContext(), DodajOceneActivity.class);
        Pokaz_Activity_z_klasy(R.id.edytuj_ocene_button_daneucznia, getApplicationContext(), EdytujOceneActivity.class);
        Pokaz_Activity_z_klasy(R.id.srednia_button_daneucznia, getApplicationContext(), SredniaAcitivity.class);
        Pokaz_Activity_z_klasy(R.id.mediana_button_daneucznia, getApplicationContext(), MedianaAcitivity.class);
        Pokaz_Activity_z_klasy(R.id.wariancja_button_daneucznia, getApplicationContext(), WariancjaAcitivity.class);
        Pokaz_Activity_z_klasy(R.id.dominanta_button_daneucznia, getApplicationContext(), DominantaAcitivity.class);
        Pokaz_Activity_z_klasy(R.id.odchylenie_button_daneucznia, getApplicationContext(), OdchylenieAcitivity.class);
        Pokaz_Activity_z_klasy(R.id.kwartyle_button_daneucznia, getApplicationContext(), KwartyleAcitivity.class);

        Button srednia_button_dane_ucznia = (Button) findViewById(R.id.srednia_button_daneucznia);
        Button dominanta_button_dane_ucznia = (Button) findViewById(R.id.dominanta_button_daneucznia);
        Button kwartyle_button_dane_ucznia = (Button) findViewById(R.id.kwartyle_button_daneucznia);
        Button mediana_button_dane_ucznia = (Button) findViewById(R.id.mediana_button_daneucznia);
        Button odchylenie_button_dane_ucznia = (Button) findViewById(R.id.odchylenie_button_daneucznia);
        Button wariancja_button_dane_ucznia = (Button) findViewById(R.id.wariancja_button_daneucznia);

        dodajocene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cel = new Intent(view.getContext(), DodajOceneActivity.class);

                Bundle koszyk = new Bundle();
                koszyk.putString("Imie", Imie);
                koszyk.putString("Nazwisko", Nazwisko);
                koszyk.putString("Klasa", nrKlasy);
                koszyk.putString("Przedmiot", przedmiot);
                koszyk.putString("Data", date1);
                koszyk.putString("Ocena", grade1);
                // Definiujemy cel
                cel.putExtras(koszyk);
                // Wysyłamy
                startActivity(cel);
            }
        });

        edytujocene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cel = new Intent(view.getContext(), EdytujOceneActivity.class);

                Bundle koszyk = new Bundle();
                koszyk.putString("Imie", Imie);
                koszyk.putString("Nazwisko", Nazwisko);
                koszyk.putString("Klasa", nrKlasy);
                koszyk.putString("Przedmiot", przedmiot);
                koszyk.putString("Data", date1);
                koszyk.putString("Ocena", grade1);
                // Definiujemy cel
                cel.putExtras(koszyk);
                // Wysyłamy
                startActivity(cel);
            }
        });

        srednia_button_dane_ucznia.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                cel = new Intent(view.getContext(), SredniaAcitivity.class);
                wyslijDaneDoNastepnegoActivity(view);
            }
        });

        dominanta_button_dane_ucznia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cel = new Intent(view.getContext(), DominantaAcitivity.class);
                wyslijDaneDoNastepnegoActivity(view);
            }
        });

        kwartyle_button_dane_ucznia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cel = new Intent(view.getContext(), KwartyleAcitivity.class);
                wyslijDaneDoNastepnegoActivity(view);
            }
        });

        mediana_button_dane_ucznia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cel = new Intent(view.getContext(), MedianaAcitivity.class);
                wyslijDaneDoNastepnegoActivity(view);
            }
        });

        odchylenie_button_dane_ucznia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cel = new Intent(view.getContext(), OdchylenieAcitivity.class);
                wyslijDaneDoNastepnegoActivity(view);
            }
        });

        wariancja_button_dane_ucznia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cel = new Intent(view.getContext(), WariancjaAcitivity.class);
                wyslijDaneDoNastepnegoActivity(view);
            }
        });

        jesliCheckBoxZaznaczonyToWlaczButtony();
    }

    private void wyslijDaneDoNastepnegoActivity(View view) {
        Bundle koszyk = new Bundle();
        koszyk.putString("imie", Imie);
        koszyk.putString("nazwisko", Nazwisko);
        koszyk.putString("klasa", nrKlasy);
        koszyk.putString("przedmiot", przedmiot);
        koszyk.putStringArrayList("ocenyArray", oceny_z_przyrody);
        // Definiujemy cel
        cel.putExtras(koszyk);
        // Wysyłamy
        startActivity(cel);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void pobierzDanezPoprzedniegoActivity() {
        // dane pochodza z ListaKlasActivity
        Bundle przekazanedane = getIntent().getExtras();

        Imie = przekazanedane.getString("Imie");
        Nazwisko = przekazanedane.getString("Nazwisko");
        nrKlasy = przekazanedane.getString("nrKlasy");
        przedmiot = przekazanedane.getString("przedmiot");

        Biology DanePobranezBazyDanych_Przyroda = pobierzOcenyzDB(Imie, Nazwisko, nrKlasy, "Przyroda");
        //oceny_z_przyrody = DanePobranezBazyDanych_Przyroda.

        grade1 = DanePobranezBazyDanych_Przyroda.getGrade1().toString();
        grade2 = DanePobranezBazyDanych_Przyroda.getGrade2().toString();
        grade3 = DanePobranezBazyDanych_Przyroda.getGrade3().toString();

        date1 = DanePobranezBazyDanych_Przyroda.getDate1().toString();
        date2 = DanePobranezBazyDanych_Przyroda.getDate2().toString();
        date3 = DanePobranezBazyDanych_Przyroda.getDate3().toString();

        oceny_z_przyrody.add(grade1);
        oceny_z_przyrody.add(grade2);
        oceny_z_przyrody.add(grade3);
        daty_z_przyrody.add(date1);
        daty_z_przyrody.add(date2);
        daty_z_przyrody.add(date3);

        TextView pokaz_imie_nazwisko_textview = (TextView) findViewById(R.id.pokazImieiNaziwsko);
        TextView nrKlasy_textview = (TextView) findViewById(R.id.nrKlasy);
        TextView przedmiot_textview = (TextView) findViewById(R.id.przedmiot);

        // ponizsze textviewy znajduja sie w tabeli tzw checkbox, data_textview i ocena_textview
        TextView data_textview = (TextView) findViewById(R.id.data_textview);
        TextView ocena_textview = (TextView) findViewById(R.id.ocena_textview);
        TextView data_textview2 = (TextView) findViewById(R.id.data_textview2);
        TextView ocena_textview2 = (TextView) findViewById(R.id.ocena_textview2);
        TextView data_textview3 = (TextView) findViewById(R.id.data_textview3);
        TextView ocena_textview3 = (TextView) findViewById(R.id.ocena_textview3);


        pokaz_imie_nazwisko_textview.setText(Imie + " " + Nazwisko);
        nrKlasy_textview.setText(nrKlasy);
        przedmiot_textview.setText(przedmiot);

        ArrayList<String> data_z_ocena = new ArrayList<String>();
        for (Integer i = 0; i < daty_z_przyrody.size(); i++) {

            data_z_ocena.add(daty_z_przyrody.get(i) + " - " + oceny_z_przyrody.get(i));
        }
        data_textview.setText(date1);
        ocena_textview.setText(grade1);
        data_textview2.setText(date2);
        ocena_textview2.setText(grade2);
        data_textview3.setText(date3);
        ocena_textview3.setText(grade3);
//        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.listview_edycjadanych_row, data_z_ocena);
//        data_z_ocena_listview.setAdapter(adapter);
    }

    public Biology pobierzOcenyzDB(String imie, String nazwisko, String nrKlasy, String nazwaPrzedmiotu) {
        // TODO Pobieranie ocen z bazy danych i wyswietlenie w tabelach
        DatabaseAccessObjects dbHelper = OpenHelperManager.getHelper(this, DatabaseAccessObjects.class);
        RuntimeExceptionDao<Student, Integer> StudentDao = dbHelper.getStudentRuntimeExceptionDao();
        RuntimeExceptionDao<Biology, Integer> BiologyDao = dbHelper.getBiologyRuntimeExceptionDao();
        List<Student> students = StudentDao.queryForEq("surname", nazwisko);
        // id kliknietej osoby (nizej)
        Student student = students.get(0);

        // nauczyciel przypisal id uczniowi nr id dzienniczka z ocenami
        student.setId_Biology(1);
        student.setId_English(1);
        student.setId_Math(1);
        student.setId_Polish(1);
        student.setId_Religion(1);
        student.setId_WF(1);

        List<Biology> przedmiot_biologia = BiologyDao.queryForEq("id", student.getId());
        // id przypisanemu tej osobie dziennika z ocenami
        Biology oceny_z_biologi;
        if (przedmiot_biologia.size() == 0) {
            oceny_z_biologi = new Biology(0, 555, 555, 555, "555", "555", "555"); // kod informujacy ze pobierasz dane z pustej tablicy
            Toast.makeText(getApplicationContext(), "Dodaj pierwszego ucznia.",
                    Toast.LENGTH_LONG).show();
        } else {
            oceny_z_biologi = przedmiot_biologia.get(0);
        }

        return oceny_z_biologi;

    }

    /**
     * @param button_id R.id.button_name
     * @param context   insert 'getApplicationContext()'
     * @param klasa     example: StatystykaActivity.class
     */
    public void Pokaz_Activity_z_klasy(int button_id, final Context context, final Class<?> klasa) {
        Button b = (Button) findViewById(button_id);
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

    public void jesliCheckBoxZaznaczonyToWlaczButtony() {


        radioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioButton1.isChecked()) {
                    edytujocene.setEnabled(true);
                    usunocene.setEnabled(true);
                    dodajocene.setEnabled(false);
                    zaznaczony_jakikolwiek_checkbox = true;
                    radioButton2.setChecked(false);
                    radioButton3.setChecked(false);
                    Toast.makeText(getApplicationContext(), "Data: " + date1 + " Ocena: " + grade1, Toast.LENGTH_SHORT).show();
                } else {
                    edytujocene.setEnabled(false);
                    usunocene.setEnabled(false);
                    dodajocene.setEnabled(true);
                }
            }
        });

        radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (radioButton2.isChecked()) {
                    edytujocene.setEnabled(true);
                    usunocene.setEnabled(true);
                    dodajocene.setEnabled(false);
                    zaznaczony_jakikolwiek_checkbox = true;
                    radioButton1.setChecked(false);
                    radioButton3.setChecked(false);
                    Toast.makeText(getApplicationContext(), "Data: " + date2 + " Ocena: " + grade2, Toast.LENGTH_SHORT).show();

                } else {
                    edytujocene.setEnabled(false);
                    usunocene.setEnabled(false);
                    dodajocene.setEnabled(true);
                }
            }
        });

        radioButton3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (radioButton3.isChecked()) {
                    edytujocene.setEnabled(true);
                    usunocene.setEnabled(true);
                    dodajocene.setEnabled(false);
                    zaznaczony_jakikolwiek_checkbox = true;
                    radioButton1.setChecked(false);
                    radioButton2.setChecked(false);
                    Toast.makeText(getApplicationContext(), "Data: " + date3 + " Ocena: " + grade3, Toast.LENGTH_SHORT).show();

                } else {
                    edytujocene.setEnabled(false);
                    usunocene.setEnabled(false);
                    dodajocene.setEnabled(true);

                }
            }
        });

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
