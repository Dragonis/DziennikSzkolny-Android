package WojtekSasiela.DziennikSzkolny;

import WojtekSasiela.DziennikSzkolny.ORM.configuration.DatabaseDataObjects;
import WojtekSasiela.DziennikSzkolny.ORM.tables.Student;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Wojtek on 2014-12-09.
 */
public class ListaKlasActivity extends Activity {

    Integer nr_kliknietego_elementu_z_listview_przedmioty;
    ArrayList<String> osoby;
    ArrayList<String> listaOsob;
    private ArrayAdapter<String> adapter = null;
    private ArrayAdapter<String> adapterSubcjets = null;
    private ListView listaKompoment = null;
    private ListView listaKompoment2 = null;
    private Button klasa1 = null;
    private Button klasa2 = null;
    private Button klasa3 = null;
    private Button klasa4 = null;
    private Button klasa5 = null;
    private Button klasa6 = null;
    private Button dodaj_ucznia = null;
    private Button edytuj_ucznia = null;
    private Button usun_ucznia = null;
    private Button dodaj_ocene = null;
    private Button edytuj_ocene = null;
    private Button usun_ocene = null;
    String imie = "";
    String nazwisko = "";
    String klasa = "";
    String przedmiot = "";
    String imieiNazwiskoWybranejOsobyzListView = null;
    ArrayList<String> uzupelniony_danymi_listview_klasa4 = new ArrayList<String>();

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_lista_klas_layout);

        listaKompoment = (ListView) findViewById(R.id.listView);
        listaKompoment2 = (ListView) findViewById(R.id.listView0);
        klasa1 = (Button) findViewById(R.id.klasa1);
        klasa2 = (Button) findViewById(R.id.klasa2);
        klasa3 = (Button) findViewById(R.id.klasa3);
        klasa4 = (Button) findViewById(R.id.klasa4);
        klasa5 = (Button) findViewById(R.id.klasa5);
        klasa6 = (Button) findViewById(R.id.klasa6);
        dodaj_ucznia = (Button) findViewById(R.id.dodajucznia_button_listaklas);
        edytuj_ucznia = (Button) findViewById(R.id.edytujucznia_buttonlistaklas);
        usun_ucznia = (Button) findViewById(R.id.usunucznia_button_listaklas);
        dodaj_ocene = (Button) findViewById(R.id.dodajocene_button_listaklas);
        edytuj_ocene = (Button) findViewById(R.id.edytujocene_button_listaklas);
        usun_ocene = (Button) findViewById(R.id.usunocene_button_listaklas);


        dodaj_ucznia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.dodajucznia_layout);
            }
        });
        Pokaz_Activity_z_klasy(R.id.dodajucznia_button_listaklas, getApplicationContext(), DodajUczniaActivity.class);

        edytuj_ucznia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.edytujucznia_layout);
            }
        });
        Pokaz_Activity_z_klasy(R.id.edytujucznia_buttonlistaklas, getApplicationContext(), EdytujUczniaActivity.class);


        usun_ucznia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "Użytkownik został usunięty",
                        Toast.LENGTH_SHORT).show();

                // TODO: DOKONCZYC - Narazie usuwa zaznaczony elelement z listview, ale z konca listy, i nie usuwa z bazy danych
//                osoby.remove(((TextView)view).getText().toString());

                //((TextView) view).getText().toString()
                int position = (Integer) view.getTag();
                listaOsob.remove(position);
                adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.listview_elementy_listy_glownej, listaOsob);
                listaKompoment.setAdapter(adapter);
            }
        });


        dodaj_ocene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.dodajocene_layout);
            }
        });
        Pokaz_Activity_z_klasy(R.id.dodajocene_button_listaklas, getApplicationContext(), DodajOceneActivity.class);

        edytuj_ocene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.edytujocene_layout);
            }
        });
        Pokaz_Activity_z_klasy(R.id.edytujocene_button_listaklas, getApplicationContext(), EdytujOceneActivity.class);

        klasa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                klasa2.setBackgroundColor(Color.TRANSPARENT);
                klasa3.setBackgroundColor(Color.TRANSPARENT);
                klasa4.setBackgroundColor(Color.TRANSPARENT);
                klasa5.setBackgroundColor(Color.TRANSPARENT);
                klasa6.setBackgroundColor(Color.TRANSPARENT);
                view.setBackgroundColor(Color.BLUE);

                pokazListeOsobzKlasy(1);
                listaKompoment2.setAdapter(null);
                klasa = "1";

            }

        });

        klasa2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                klasa1.setBackgroundColor(Color.TRANSPARENT);
                klasa3.setBackgroundColor(Color.TRANSPARENT);
                klasa4.setBackgroundColor(Color.TRANSPARENT);
                klasa5.setBackgroundColor(Color.TRANSPARENT);
                klasa6.setBackgroundColor(Color.TRANSPARENT);

                view.setBackgroundColor(Color.BLUE);

                pokazListeOsobzKlasy(2);
                listaKompoment2.setAdapter(null);
                klasa = "2";

            }
        });

        klasa3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                klasa1.setBackgroundColor(Color.TRANSPARENT);
                klasa2.setBackgroundColor(Color.TRANSPARENT);
                klasa4.setBackgroundColor(Color.TRANSPARENT);
                klasa5.setBackgroundColor(Color.TRANSPARENT);
                klasa6.setBackgroundColor(Color.TRANSPARENT);

                view.setBackgroundColor(Color.BLUE);

                pokazListeOsobzKlasy(3);
                listaKompoment2.setAdapter(null);
                klasa = "3";
            }
        });
        klasa4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                klasa1.setBackgroundColor(Color.TRANSPARENT);
                klasa2.setBackgroundColor(Color.TRANSPARENT);
                klasa3.setBackgroundColor(Color.TRANSPARENT);
                klasa5.setBackgroundColor(Color.TRANSPARENT);
                klasa6.setBackgroundColor(Color.TRANSPARENT);

                view.setBackgroundColor(Color.BLUE);
                listaKompoment2.setAdapter(null);
                pokazListeOsobzKlasy(4);

                klasa = "4";
            }
        });
        klasa5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                klasa1.setBackgroundColor(Color.TRANSPARENT);
                klasa2.setBackgroundColor(Color.TRANSPARENT);
                klasa3.setBackgroundColor(Color.TRANSPARENT);
                klasa4.setBackgroundColor(Color.TRANSPARENT);
                klasa6.setBackgroundColor(Color.TRANSPARENT);

                view.setBackgroundColor(Color.BLUE);

                pokazListeOsobzKlasy(5);
                listaKompoment2.setAdapter(null);
                klasa = "5";
            }
        });
        klasa6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                klasa1.setBackgroundColor(Color.TRANSPARENT);
                klasa2.setBackgroundColor(Color.TRANSPARENT);
                klasa3.setBackgroundColor(Color.TRANSPARENT);
                klasa4.setBackgroundColor(Color.TRANSPARENT);
                klasa5.setBackgroundColor(Color.TRANSPARENT);

                view.setBackgroundColor(Color.BLUE);

                pokazListeOsobzKlasy(6);
                listaKompoment2.setAdapter(null);
                klasa = "6";
            }
        });

        // lista osob
        listaKompoment.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                for (int j = 0; j < adapterView.getChildCount(); j++)
                    adapterView.getChildAt(j).setBackgroundColor(Color.TRANSPARENT);

                // change the background color of the selected element
                view.setBackgroundColor(Color.BLUE);

                imieiNazwiskoWybranejOsobyzListView = ((TextView) view).getText().toString();
                Toast.makeText(getApplicationContext(), imieiNazwiskoWybranejOsobyzListView,
                        Toast.LENGTH_SHORT).show();

                String subjects[] = {"Polski", "Angielski", "Matematyka", "Przyroda", "Religia", "WF"};
                ArrayList<String> subjectsL = new ArrayList<String>();
                subjectsL.addAll(Arrays.asList(subjects));
                adapterSubcjets = new ArrayAdapter<String>(view.getContext(), R.layout.listview_elementy_listy_glownej, subjectsL);
                listaKompoment2.setAdapter(adapterSubcjets);

                String[] split = imieiNazwiskoWybranejOsobyzListView.split(" ");
                imie = split[0];
                nazwisko = split[1];

                edytuj_ucznia.setEnabled(true);
                usun_ucznia.setEnabled(true);

                nr_kliknietego_elementu_z_listview_przedmioty = position;
                usun_ucznia.setTag(position);
            }
        });


        //interakcja na klikniecie na nazwe przedmioty z listy przedmiotow
        listaKompoment2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                for (int j = 0; j < adapterView.getChildCount(); j++)
                    adapterView.getChildAt(j).setBackgroundColor(Color.TRANSPARENT);

                // change the background color of the selected element
                view.setBackgroundColor(Color.BLUE);

                przedmiot = ((TextView) view).getText().toString();
                wyslijDaneDoNastepnegoActivity();


            }
        });
        zamknijOkno(R.id.Wyjdz_button);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {


            if (bundle.getString("Id") != null) {
                pobierzDanezEdytujUczniaActivity();
            }
            // Zrob iteracje by sprawdzic W KTOREJ KLASIE (1,2,3 a moze6?) nalezy dodac nowego ucznia,
            for (Integer i = 1; i <= 6; i++) {
                if (bundle.getString("Klasa") == i.toString()) {
                    // jezeli z np. DodajUczniaButton pobranym id_klasy jest cyfra 4, to zapisuj wszystkie dane z DodajUczniaActivity do bazy danych dla klasy 4
                    DodajUczniaKlasy(i);
                }
            }
        }
    }

    private void DodajUczniaKlasy(Integer nr_klasy) {
        ArrayList<String> dane_studenta = pobierzDanezDodajUczniaActivity();
        pokazListeOsobzKlasy(nr_klasy);
        uzupelniony_danymi_listview_klasa4 = pokazListeOsobzKlasy(nr_klasy);

        ArrayList<String> nowoutowrzona_listastudentow = new ArrayList<String>();

        // @DOWN dodajesz do listview imie + " " + nazwisko (jest jeszcze do dyspozycji zmienna nrKlasy czyli get(2)
        nowoutowrzona_listastudentow.add(dane_studenta.get(0) + " " + dane_studenta.get(1));

        nowoutowrzona_listastudentow.addAll(uzupelniony_danymi_listview_klasa4);
        adapter = new ArrayAdapter<String>(this, R.layout.listview_elementy_listy_glownej, nowoutowrzona_listastudentow);
        listaKompoment.setAdapter(adapter);
        //uzupelniony_danymi_listview_klasa4 = pokazListeOsobzKlasy(4);
        // dodajemy do powyzszego listview, stworzony przez nas teraz element
    }

    public ArrayList<String> pokazListeOsobzKlasy(int nr_klasy) {

        // Connect with Database ORM
        DatabaseDataObjects dbHelper = OpenHelperManager.getHelper(this, DatabaseDataObjects.class);
        RuntimeExceptionDao<Student, Integer> studentDao = dbHelper.getStudentRuntimeExceptionDao();
        List<Student> students = studentDao.queryForEq("classrom", nr_klasy);
        Integer max_liczba_studentow_w_klasie = students.size();
        osoby = new ArrayList<String>(max_liczba_studentow_w_klasie);
        try{
        for (int i = 0; i < max_liczba_studentow_w_klasie; i++) {
            String name_UTF8 = new String(students.get(i).getName().getBytes("UTF-8"), "UTF-8");
            String surname_UTF8 = new String(students.get(i).getSurname().getBytes("UTF-8"), "UTF-8");
            osoby.add(name_UTF8 + " " + surname_UTF8);
        }}catch(Exception e)
        {
            e.getStackTrace();
        }

        //String osoby[] = {"Ania Kowalska", "Joasia Pyrzyńska", "Izabela Tarnowska", "Blanka Szept", "Paweł Paluch", "Piotrek Mały", "Karol Kopytko", "Arkadiusz Bąk", "Teresa Wawrzyniak"};
        listaOsob = new ArrayList<String>();
        listaOsob.addAll(osoby);
        adapter = new ArrayAdapter<String>(this, R.layout.listview_elementy_listy_glownej, listaOsob);
        listaKompoment.setAdapter(adapter);
        return osoby;
        //zwracam (uzupelniony_danymi_listview_klasa4) gdybym w przyszlosci chcial dodac/edytowac/usunac elementy do tej listy.

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

    public void wyslijDaneDoNastepnegoActivity() {
        Bundle koszyk = new Bundle();

        koszyk.putString("Imie", imie);
        koszyk.putString("Nazwisko", nazwisko);
        koszyk.putString("nrKlasy", klasa);
        koszyk.putString("przedmiot", przedmiot);
        // Definiujemy cel
        Intent cel = new Intent(this, DaneUczniaActivity.class);
        cel.putExtras(koszyk);
        // Wysyłamy
        startActivity(cel);
    }

    public ArrayList<String> pobierzDanezDodajUczniaActivity() {

        Bundle przekazanedane = getIntent().getExtras();

        // pobierasz dane z DodajUczniaActivity

        imie = przekazanedane.getString("Imie");
        nazwisko = przekazanedane.getString("Nazwisko");
        klasa = przekazanedane.getString("Klasa");
        ArrayList<String> student = new ArrayList<String>();
        try {
            byte[] imie_bytes = imie.getBytes("UTF-8");
            byte[] nazwisko_bytes = nazwisko.getBytes("UTF-8");

            String imie_UTF8 = new String(imie_bytes, "UTF-8");
            String nazwisko_UTF8 = new String(nazwisko_bytes, "UTF-8");

            Toast.makeText(getApplicationContext(), "Imie: " + imie_UTF8 + "Nazwisko: " + nazwisko_UTF8 + "Klasa: " + klasa,
                    Toast.LENGTH_SHORT).show();


            student.add(imie_UTF8);
            student.add(nazwisko_UTF8);
            student.add(klasa);
            return student;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return student;
    }

    public void pobierzDanezEdytujUczniaActivity() {

        Bundle przekazanedane = getIntent().getExtras();

        String id = przekazanedane.getString("Id");
        String imie = przekazanedane.getString("Imie");
        String nazwisko = przekazanedane.getString("Nazwisko");
        String klasa = przekazanedane.getString("Klasa");

        Toast.makeText(getApplicationContext(), "ID :" + id + " | Imie: " + imie + "Naziwsko: " + nazwisko + "Klasa: " + klasa,
                Toast.LENGTH_SHORT).show();

    }

    public void Pokaz_Activity_z_klasy(int id, final Context context, final Class<?> klasa) {
        Button b = (Button) findViewById(id);
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