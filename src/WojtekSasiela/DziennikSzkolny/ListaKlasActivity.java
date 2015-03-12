package WojtekSasiela.DziennikSzkolny;

import WojtekSasiela.DziennikSzkolny.ORM.configuration.DatabaseHelper;
import WojtekSasiela.DziennikSzkolny.ORM.tables.Student;
import WojtekSasiela.DziennikSzkolny.ORM.tables.subjects.Biology;
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

            }
        });

        dodaj_ocene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.dodajocene_layout);
            }
        });
        Pokaz_Activity_z_klasy(R.id.dodajocene_button_listaklas,getApplicationContext(),DodajOceneActivity.class);

        edytuj_ocene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.edytujocene_layout);
            }
        });
        Pokaz_Activity_z_klasy(R.id.edytujocene_button_listaklas,getApplicationContext(),EdytujOceneActivity.class);

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

                edytuj_ucznia.setEnabled(true);
                usun_ucznia.setEnabled(true);
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


                wyslijDaneDoNastepnegoActivity();


            }
        });
        zamknijOkno(R.id.Wyjdz_button);
        Bundle bundle = getIntent().getExtras();
        if(bundle == null)
        {

        }else if (bundle.getString("Id") != null){
            pobierzDanezEdytujUczniaActivity();
        }else{
            ArrayList<String> dane_studenta = pobierzDanezDodajUczniaActivity();

            adapter = new ArrayAdapter<String>(this, R.layout.listview_elementy_listy_glownej, dane_studenta);
            listaKompoment.setAdapter(adapter);

        }
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
         Bundle koszyk = new Bundle();
        String[] split = imieiNazwiskoWybranejOsobyzListView.split(" ");
         imie = split[0] ;
         nazwisko = split[1];
        klasa = "1";
        przedmiot = "Przyroda";
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
           nazwisko  = przekazanedane.getString("Nazwisko");
           klasa = przekazanedane.getString("Klasa");

            Toast.makeText(getApplicationContext(), "Imie: " + imie + "Naziwsko: " + nazwisko + "Klasa: " + klasa,
                    Toast.LENGTH_SHORT).show();

        ArrayList<String> student = new ArrayList<String>();
        student.add(imie);
        student.add(nazwisko);
        student.add(klasa);

        return student;

    }

    public void pobierzDanezEdytujUczniaActivity() {

        Bundle przekazanedane = getIntent().getExtras();

            String id = przekazanedane.getString("Id");
            String imie = przekazanedane.getString("Imie");
            String nazwisko = przekazanedane.getString("Nazwisko");
            String klasa = przekazanedane.getString("Klasa");

            Toast.makeText(getApplicationContext(), "ID :" + id+ " | Imie: " + imie + "Naziwsko: " + nazwisko + "Klasa: " + klasa,
                    Toast.LENGTH_SHORT).show();

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