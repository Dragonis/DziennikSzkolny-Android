package WojtekSasiela.DziennikSzkolny;

import WojtekSasiela.DziennikSzkolny.ORM.configuration.DatabaseHelper;
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
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Wojtek on 2014-12-09.
 */
public class ListaKlasActivity extends Activity {

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
    private Button dodaj = null;
    private Button edytuj = null;
    private Button usun = null;
    String imieiNazwiskoWybranejOsobyzListView = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_lista_klas_layout);
        Pokaz_Activity_z_klasy(R.id.dodajucznia_button_listaklas, getApplicationContext(), DodajUczniaActivity.class);

        listaKompoment = (ListView) findViewById(R.id.listView);
        listaKompoment2 = (ListView) findViewById(R.id.listView0);
        klasa1 = (Button) findViewById(R.id.klasa1);
        klasa2 = (Button) findViewById(R.id.klasa2);
        klasa3 = (Button) findViewById(R.id.klasa3);
        klasa4 = (Button) findViewById(R.id.klasa4);
        klasa5 = (Button) findViewById(R.id.klasa5);
        klasa6 = (Button) findViewById(R.id.klasa6);

        dodaj = (Button) findViewById(R.id.dodajucznia_button_listaklas);
        edytuj = (Button) findViewById(R.id.edytujucznia_button_listaklas);
        usun = (Button) findViewById(R.id.usunucznia_button_listaklas);


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

                pokazListeOsobzKlasy(4);

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

            }
        });

        dodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setContentView(R.layout.fragment_dodajucznia_layout);
            }
        });

        edytuj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.fragment_edytujucznia_layout);
            }
        });

        usun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                setContentView(R.layout.fragmnt_usunucznia_layout);
            }
        });

        // lista osob
        listaKompoment.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                for (int j = 0; j < adapterView.getChildCount(); j++)
                    adapterView.getChildAt(j).setBackgroundColor(Color.TRANSPARENT);

                // change the background color of the selected element
                view.setBackgroundColor(Color.BLUE);

                imieiNazwiskoWybranejOsobyzListView = ((TextView)view).getText().toString();
                Toast.makeText(getApplicationContext(), imieiNazwiskoWybranejOsobyzListView,
                        Toast.LENGTH_SHORT).show();

                String subjects[] = {"Polski", "Angielski", "Matematyka", "Przyroda", "Religia", "WF"};
                ArrayList<String> subjectsL = new ArrayList<String>();
                subjectsL.addAll(Arrays.asList(subjects));
                adapterSubcjets = new ArrayAdapter<String>(view.getContext(), R.layout.listview_elementy_listy_glownej, subjectsL);
                listaKompoment2.setAdapter(adapterSubcjets);
            }
        });


        //interakcja na klikniecie na nazwe przedmioty z listy przedmiotow
        listaKompoment2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                for (int j = 0; j < adapterView.getChildCount(); j++)
                    adapterView.getChildAt(j).setBackgroundColor(Color.TRANSPARENT);

                // change the background color of the selected element
                view.setBackgroundColor(Color.BLUE);


                // Pakujemy go w Bundle
                Bundle koszyk = new Bundle();
                koszyk.putString("ImieiNazwisko", imieiNazwiskoWybranejOsobyzListView);
                // Definiujemy cel
                Intent cel = new Intent(view.getContext(), DaneUczniaActivity.class);
                cel.putExtras(koszyk);
                // Wysyłamy
                startActivity(cel);


            }
        });
        zamknijOkno(R.id.Wyjdz_button);
   }

    public void pokazListeOsobzKlasy(int nr_klasy) {

            // Connect with Database ORM
            DatabaseHelper dbHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
            RuntimeExceptionDao<Student, Integer> studentDao = dbHelper.getStudentRuntimeExceptionDao();
            List<Student> students = studentDao.queryForEq("classrom",nr_klasy);
            Integer max_liczba_studentow_w_klasie = students.size();
            String cars[] = new String[max_liczba_studentow_w_klasie];
            for(int i=0; i <max_liczba_studentow_w_klasie; i++){
                cars[i] =  students.get(i).getName() + " " + students.get(i).getSurname();
            }


                                                // TODO POPRAWIENIE BLEDU W LISTAKLAS
                                               // WYWALA BLEDY GDY:
                            // przekroczy sie minimalna liczbe osob, ktore zostalo wprowadzone do bazy danych
                            // przyklad:
                            // wprowadzono w klasie 1, 5 osob , a w innych klasach powyzej 5 osob.
                            // wtedy wywala blad przy 6 i wyzej (bo chcesz wyswietlic elementy ktorych nie ma)

            //String cars[] = {"Ania Kowalska", "Joasia Pyrzyńska", "Izabela Tarnowska", "Blanka Szept", "Paweł Paluch", "Piotrek Mały", "Karol Kopytko", "Arkadiusz Bąk", "Teresa Wawrzyniak"};
            ArrayList<String> carL = new ArrayList<String>();
            carL.addAll(Arrays.asList(cars));
            adapter = new ArrayAdapter<String>(this, R.layout.listview_elementy_listy_glownej, carL);
            listaKompoment.setAdapter(adapter);

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

    public void wyslijDaneDoNastepnegoActivity()
    {
        // Pobieramy tekst z pola
        String wpisanyTekst = "Witaj swiecie";
        // Pakujemy go w Bundle
        Bundle koszyk = new Bundle();
        koszyk.putString("ImieiNazwisko", imieiNazwiskoWybranejOsobyzListView);
        // Definiujemy cel
        Intent cel = new Intent(this, DaneUczniaActivity.class);
        cel.putExtras(koszyk);
        // Wysyłamy
        startActivity(cel);
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
}