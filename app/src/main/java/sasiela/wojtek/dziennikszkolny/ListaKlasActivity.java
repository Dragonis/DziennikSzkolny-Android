package sasiela.wojtek.dziennikszkolny;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import sasiela.wojtek.dziennikszkolny.ORM.CRUD.DELETE.DeleteDataFromDatabase;
import sasiela.wojtek.dziennikszkolny.ORM.configuration.DatabaseAccessObjects;
import sasiela.wojtek.dziennikszkolny.ORM.tables.new_version_database.Uczen;


/**
 * Created by Wojtek on 2014-12-09.
 */
public class ListaKlasActivity extends Activity {

    //region Zmienne
    Integer nr_kliknietego_elementu_z_listview_przedmioty;
    ArrayList<String> osoby, listaOsob, uzupelniony_danymi_listview_klasa4 = new ArrayList<String>();
    ArrayAdapter<String> adapter, adapterSubcjets;
    ListView listView_ImionaiNazwiska, ListView_NazwyPrzedmiotow;
    Button klasa1, klasa2, klasa3, klasa4, klasa5, klasa6,
            dodaj_ucznia, dodaj_ocene,
            edytuj_ucznia, edytuj_ocene,
            usun_ucznia, usun_ocene;
    String id, imie, nazwisko, klasa, przedmiot, kliknietaPozycja, imieiNazwiskoWybranejOsobyzListView;
    Bundle koszyk = new Bundle();
    Intent cel;

    //endregion

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_klas_layout);

        //region Inicjacja_zmiennych
        listView_ImionaiNazwiska = (ListView) findViewById(R.id.listView_ImieiNazwisko);
        ListView_NazwyPrzedmiotow = (ListView) findViewById(R.id.listView_NazwyPrzedmiotow);
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
        //endregion



        //region Button'y
        dodaj_ucznia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                setContentView(R.layout.dodajucznia_layout);
            }
        });
        WyswietlButton_i_PrzelaczNaActivityzKlasy(R.id.dodajucznia_button_listaklas, getApplicationContext(), DodajUczniaActivity.class);



//        WyswietlButton_i_PrzelaczNaActivityzKlasy(R.id.edytujucznia_buttonlistaklas, getApplicationContext(), EdytujUczniaActivity.class);
        edytuj_ucznia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                setContentView(R.layout.edytujucznia_layout);
                wyslijDaneDo_EdytujUczniaActivity(kliknietaPozycja,imie,nazwisko,klasa,"polski");
                cel.putExtras(koszyk);
                startActivity(cel);
            }
        });


        dodaj_ocene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.dodajocene_layout);
            }
        });
        WyswietlButton_i_PrzelaczNaActivityzKlasy(R.id.dodajocene_button_listaklas, getApplicationContext(), DodajOceneActivity.class);

        edytuj_ocene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.edytujocene_layout);
            }
        });
        WyswietlButton_i_PrzelaczNaActivityzKlasy(R.id.edytujocene_button_listaklas, getApplicationContext(), EdytujOceneActivity.class);

        usun_ucznia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UsunZaznaczonegoUczniazListView(view);
                DeleteDataFromDatabase.usunUcznia(imie, nazwisko);
            }
        });

        zamknijOkno(R.id.Wyjdz_button);

        klasa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //region Zmiana_kolorow_odpowiednich_buttonow
                klasa2.setBackgroundColor(Color.TRANSPARENT);
                klasa3.setBackgroundColor(Color.TRANSPARENT);
                klasa4.setBackgroundColor(Color.TRANSPARENT);
                klasa5.setBackgroundColor(Color.TRANSPARENT);
                klasa6.setBackgroundColor(Color.TRANSPARENT);
                view.setBackgroundColor(Color.BLUE);
                //endregion
                pokaz_Nev_Version_ListeOsobzKlasy(1);
                ListView_NazwyPrzedmiotow.setAdapter(null);
                klasa = "1";

            }

        });

        klasa2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //region Zmiana_kolorow_odpowiednich_buttonow
                klasa1.setBackgroundColor(Color.TRANSPARENT);
                klasa3.setBackgroundColor(Color.TRANSPARENT);
                klasa4.setBackgroundColor(Color.TRANSPARENT);
                klasa5.setBackgroundColor(Color.TRANSPARENT);
                klasa6.setBackgroundColor(Color.TRANSPARENT);
                view.setBackgroundColor(Color.BLUE);
                //endregion
                pokaz_Nev_Version_ListeOsobzKlasy(2);
                ListView_NazwyPrzedmiotow.setAdapter(null);
                klasa = "2";

            }
        });

        klasa3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //region Zmiana_kolorow_odpowiednich_buttonow
                klasa1.setBackgroundColor(Color.TRANSPARENT);
                klasa2.setBackgroundColor(Color.TRANSPARENT);
                klasa4.setBackgroundColor(Color.TRANSPARENT);
                klasa5.setBackgroundColor(Color.TRANSPARENT);
                klasa6.setBackgroundColor(Color.TRANSPARENT);

                view.setBackgroundColor(Color.BLUE);
                //endregion
                pokaz_Nev_Version_ListeOsobzKlasy(3);
                ListView_NazwyPrzedmiotow.setAdapter(null);
                klasa = "3";
            }
        });
        klasa4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //region Zmiana_kolorow_odpowiednich_buttonow
                klasa1.setBackgroundColor(Color.TRANSPARENT);
                klasa2.setBackgroundColor(Color.TRANSPARENT);
                klasa3.setBackgroundColor(Color.TRANSPARENT);
                klasa5.setBackgroundColor(Color.TRANSPARENT);
                klasa6.setBackgroundColor(Color.TRANSPARENT);

                view.setBackgroundColor(Color.BLUE);
                //endregion
                ListView_NazwyPrzedmiotow.setAdapter(null);
                pokaz_Nev_Version_ListeOsobzKlasy(4);

                klasa = "4";
            }
        });
        klasa5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //region Zmiana_kolorow_odpowiednich_buttonow
                klasa1.setBackgroundColor(Color.TRANSPARENT);
                klasa2.setBackgroundColor(Color.TRANSPARENT);
                klasa3.setBackgroundColor(Color.TRANSPARENT);
                klasa4.setBackgroundColor(Color.TRANSPARENT);
                klasa6.setBackgroundColor(Color.TRANSPARENT);

                view.setBackgroundColor(Color.BLUE);
                //endregion
                pokaz_Nev_Version_ListeOsobzKlasy(5);
                ListView_NazwyPrzedmiotow.setAdapter(null);
                klasa = "5";
            }
        });
        klasa6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //region Zmiana_kolorow_odpowiednich_buttonow
                klasa1.setBackgroundColor(Color.TRANSPARENT);
                klasa2.setBackgroundColor(Color.TRANSPARENT);
                klasa3.setBackgroundColor(Color.TRANSPARENT);
                klasa4.setBackgroundColor(Color.TRANSPARENT);
                klasa5.setBackgroundColor(Color.TRANSPARENT);

                view.setBackgroundColor(Color.BLUE);
                //endregion
                pokaz_Nev_Version_ListeOsobzKlasy(6);
                ListView_NazwyPrzedmiotow.setAdapter(null);
                klasa = "6";
            }
        });
        //endregion

        //region ListView'y
        listView_ImionaiNazwiska.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                WyswietlOsobywListView1(adapterView, view, position);
                WyswietlPrzedmiotywListView2(view, position);
            }
        });

        ListView_NazwyPrzedmiotow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                for (int j = 0; j < adapterView.getChildCount(); j++)
                    adapterView.getChildAt(j).setBackgroundColor(Color.TRANSPARENT);

                view.setBackgroundColor(Color.BLUE);

                przedmiot = ((TextView) view).getText().toString();
                wyslijDaneDo_DaneUczniaActivity();



            }
        });
        //endregion

        przetwarzajDanez_EdytujUczniaActivity_poCzymWyswietlw_ListViewUczniowie();

    }

    public void przetwarzajDanez_EdytujUczniaActivity_poCzymWyswietlw_ListViewUczniowie() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {


            if (bundle.getString("Id") != null) {
                pobierzDanezEdytujUczniaActivity();
            }
            // Zrob iteracje by sprawdzic W KTOREJ KLASIE (1,2,3 a moze6?) nalezy dodac nowego ucznia,
            for (Integer i = 1; i <= 6; i++) {
                if (bundle.getString("Klasa") == i.toString()) {
                    // jezeli z np. DodajUczniaButton pobranym id_klasy jest cyfra 4, to zapisuj wszystkie dane z DodajUczniaActivity do bazy danych dla klasy 4
                    DodajUczniaDoKonkretnejKlasywListViewUczniowie(i);
                }
            }
        }
    }

    public void WyswietlPrzedmiotywListView2(View view, int position) {
        String subjects[] = {"Polski", "Angielski", "Matematyka", "Przyroda", "Religia", "WF"};
        ArrayList<String> subjectsL = new ArrayList<String>();
        subjectsL.addAll(Arrays.asList(subjects));
        adapterSubcjets = new ArrayAdapter<String>(view.getContext(), R.layout.elementy_listy_glownej, subjectsL);
        ListView_NazwyPrzedmiotow.setAdapter(adapterSubcjets);
        nr_kliknietego_elementu_z_listview_przedmioty = position;
    }

    public void WyswietlOsobywListView1(AdapterView<?> adapterView, View view, int position) {
        for (int j = 0; j < adapterView.getChildCount(); j++)
            adapterView.getChildAt(j).setBackgroundColor(Color.TRANSPARENT);

        view.setBackgroundColor(Color.BLUE);

        imieiNazwiskoWybranejOsobyzListView = ((TextView) view).getText().toString();
        Toast.makeText(getApplicationContext(), imieiNazwiskoWybranejOsobyzListView,
                Toast.LENGTH_SHORT).show();

        String[] split = imieiNazwiskoWybranejOsobyzListView.split(" ");
        imie = split[0];
        nazwisko = split[1];
        kliknietaPozycja = String.valueOf(position);

        edytuj_ucznia.setEnabled(true);
        usun_ucznia.setEnabled(true);
        usun_ucznia.setTag(position);
    }

    public void UsunZaznaczonegoUczniazListView(View view) {
        Toast.makeText(getApplicationContext(), "Użytkownik został usunięty",
                Toast.LENGTH_SHORT).show();

        // TODO: DOKONCZYC - Narazie usuwa zaznaczony elelement z listview, ale z konca listy, i nie usuwa z bazy danych
//                osoby.remove(((TextView)view).getText().toString());

        //((TextView) view).getText().toString()
        int position = (Integer) view.getTag();
        listaOsob.remove(position);
        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.elementy_listy_glownej, listaOsob);
        listView_ImionaiNazwiska.setAdapter(adapter);
    }

    private void DodajUczniaDoKonkretnejKlasywListViewUczniowie(Integer nr_klasy) {
        ArrayList<String> dane_studenta = pobierzDanezDodajUczniaActivity();
        pokaz_Nev_Version_ListeOsobzKlasy(nr_klasy);
        uzupelniony_danymi_listview_klasa4 = pokaz_Nev_Version_ListeOsobzKlasy(nr_klasy);

        ArrayList<String> nowoutowrzona_listastudentow = new ArrayList<String>();

        // @DOWN dodajesz do listview imie + " " + nazwisko (jest jeszcze do dyspozycji zmienna nrKlasy czyli get(2)
        nowoutowrzona_listastudentow.add(dane_studenta.get(0) + " " + dane_studenta.get(1));

        nowoutowrzona_listastudentow.addAll(uzupelniony_danymi_listview_klasa4);
        adapter = new ArrayAdapter<String>(this, R.layout.elementy_listy_glownej, nowoutowrzona_listastudentow);
        listView_ImionaiNazwiska.setAdapter(adapter);
        //uzupelniony_danymi_listview_klasa4 = pokazListeOsobzKlasy(4);
        // dodajemy do powyzszego listview, stworzony przez nas teraz element
    }

    public ArrayList<String> pokaz_Nev_Version_ListeOsobzKlasy(int nr_klasy) {

        DatabaseAccessObjects dbHelper = OpenHelperManager.getHelper(this, DatabaseAccessObjects.class);
        RuntimeExceptionDao<Uczen, Integer> studentDao = dbHelper.getUczenRuntimeExceptionDao();
        List<Uczen> students = studentDao.queryForEq("klasa", nr_klasy);
        Integer max_liczba_studentow_w_klasie = students.size();
        osoby = new ArrayList<String>(max_liczba_studentow_w_klasie);
        try {
            for (int i = 0; i < max_liczba_studentow_w_klasie; i++) {
                String name_UTF8 = new String(students.get(i).getImie().getBytes("UTF-8"), "UTF-8");
                String surname_UTF8 = new String(students.get(i).getNazwisko().getBytes("UTF-8"), "UTF-8");
                osoby.add(name_UTF8 + " " + surname_UTF8);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

        listaOsob = new ArrayList<String>();
        listaOsob.addAll(osoby);
        adapter = new ArrayAdapter<String>(this, R.layout.elementy_listy_glownej, listaOsob);
        listView_ImionaiNazwiska.setAdapter(adapter);
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

    public void wyslijDaneDo_DaneUczniaActivity() {
        Bundle koszyk = new Bundle();

        koszyk.putString("Imie", imie);
        koszyk.putString("Nazwisko", nazwisko);
        koszyk.putString("Klasa", klasa);
        koszyk.putString("Przedmiot", przedmiot);
        Intent cel = new Intent(this, DaneUczniaActivity.class);
        cel.putExtras(koszyk);
        startActivity(cel);
    }


    public void wyslijDaneDo_EdytujUczniaActivity(String identity, String name, String surname, String classroom, String subcjet) {

        koszyk.putString("Id",identity);
        koszyk.putString("Imie", name);
        koszyk.putString("Nazwisko", surname);
        koszyk.putString("Klasa", classroom);
        koszyk.putString("Przedmiot", przedmiot);
        cel = new Intent(this, EdytujUczniaActivity.class);

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

        id = przekazanedane.getString("Id");
        imie = przekazanedane.getString("Imie");
        nazwisko = przekazanedane.getString("Nazwisko");
        klasa = przekazanedane.getString("Klasa");

        Toast.makeText(getApplicationContext(), "ID :" + id + " | Imie: " + imie + "Naziwsko: " + nazwisko + "Klasa: " + klasa,
                Toast.LENGTH_SHORT).show();

    }

    public void WyswietlButton_i_PrzelaczNaActivityzKlasy(int id, final Context context, final Class<?> klasa) {
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