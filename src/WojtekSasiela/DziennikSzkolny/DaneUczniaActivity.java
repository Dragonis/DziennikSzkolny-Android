package WojtekSasiela.DziennikSzkolny;

import WojtekSasiela.DziennikSzkolny.Fragments.*;
import WojtekSasiela.DziennikSzkolny.ORM.configuration.DatabaseHelper;
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
    ListView listaKompoment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_dane_ucznia_layout);

        listaKompoment2 = (ListView) findViewById(R.id.listView4);
        pobierzDanezPoprzedniegoActivity();
        zamknijOkno(R.id.Wyjdzbttn_OcenyLayout);

        ListView listaKompoment = (ListView) findViewById(R.id.listView3);

        // wyswitlanie odpowiednich activity statystycznych
        Pokaz_Activity_z_klasy(R.id.srednia_button_daneucznia, getApplicationContext(), SredniaAcitivity.class);
        Pokaz_Activity_z_klasy(R.id.mediana_button_daneucznia, getApplicationContext(), MedianaAcitivity.class);
        Pokaz_Activity_z_klasy(R.id.wariancja_button_daneucznia, getApplicationContext(), WariancjaAcitivity.class);
        Pokaz_Activity_z_klasy(R.id.dominanta_button_daneucznia, getApplicationContext(), DominantaAcitivity.class);
        Pokaz_Activity_z_klasy(R.id.odchylenie_button_daneucznia, getApplicationContext(), OdchylenieAcitivity.class);
        Pokaz_Activity_z_klasy(R.id.kwartyle_button_daneucznia, getApplicationContext(), KwartyleAcitivity.class);


        Button srednia_button_dane_ucznia = (Button) findViewById(R.id.srednia_button_daneucznia);
        srednia_button_dane_ucznia.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                wyslijDaneDoNastepnegoActivity(view);
            }
        });


    }

    private void wyslijDaneDoNastepnegoActivity(View view) {
        Bundle koszyk = new Bundle();
        koszyk.putString("imie", Imie);
        koszyk.putString("nazwisko", Nazwisko);
        koszyk.putString("klasa", nrKlasy);
        koszyk.putString("przedmiot", przedmiot);
        koszyk.putStringArrayList("ocenyArray", oceny_z_przyrody);
        // Definiujemy cel
        Intent cel = new Intent(view.getContext(), SredniaAcitivity.class);
        cel.putExtras(koszyk);
        // Wysyłamy
        startActivity(cel);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ;
    }

    public void pobierzDanezPoprzedniegoActivity() {
        // dane pochodza z ListaKlasActivity
        Bundle przekazanedane = getIntent().getExtras();

        Imie = przekazanedane.getString("Imie");
        Nazwisko = przekazanedane.getString("Nazwisko");
        nrKlasy = przekazanedane.getString("nrKlasy");
        przedmiot = przekazanedane.getString("przedmiot");

        Biology DanePobranezBazyDanych_Przyroda = pobierzOcenyzDB(Imie,Nazwisko,nrKlasy,"Przyroda");
        //oceny_z_przyrody = DanePobranezBazyDanych_Przyroda.

        String grade1 = DanePobranezBazyDanych_Przyroda.getGrade1().toString();
        String grade2 = DanePobranezBazyDanych_Przyroda.getGrade2().toString();
        String grade3 = DanePobranezBazyDanych_Przyroda.getGrade3().toString();

        String date1 = DanePobranezBazyDanych_Przyroda.getDate1().toString();
        String date2 = DanePobranezBazyDanych_Przyroda.getDate2().toString();
        String date3 = DanePobranezBazyDanych_Przyroda.getDate3().toString();

        oceny_z_przyrody.add(grade1);
        oceny_z_przyrody.add(grade2);
        oceny_z_przyrody.add(grade3);
        daty_z_przyrody.add(date1);
        daty_z_przyrody.add(date2);
        daty_z_przyrody.add(date3);

        TextView pokaz_imie_nazwisko_textview = (TextView) findViewById(R.id.pokazImieiNaziwsko);
        TextView nrKlasy_textview = (TextView) findViewById(R.id.nrKlasy);
        TextView przedmiot_textview = (TextView) findViewById(R.id.przedmiot);

        pokaz_imie_nazwisko_textview.setText(Imie + " " + Nazwisko);
        nrKlasy_textview.setText(nrKlasy);
        przedmiot_textview.setText(przedmiot);

        ArrayList<String> data_z_ocena = new ArrayList<String>();
        for(Integer i=0; i< daty_z_przyrody.size(); i++) {

                data_z_ocena.add(daty_z_przyrody.get(i) + " - " + oceny_z_przyrody.get(i));
        }
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.listview_edycjadanych_row, data_z_ocena);
        listaKompoment2.setAdapter(adapter);
    }

    public Biology pobierzOcenyzDB(String imie, String nazwisko, String nrKlasy, String nazwaPrzedmiotu) {
        // TODO Pobieranie ocen z bazy danych i wyswietlenie w tabelach
        DatabaseHelper dbHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
        RuntimeExceptionDao<Student, Integer> StudentDao = dbHelper.getStudentRuntimeExceptionDao();
        RuntimeExceptionDao<Biology, Integer> BiologyDao = dbHelper.getBiologyRuntimeExceptionDao();
        List<Student> students = StudentDao.queryForEq("surname",nazwisko);
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
        if(przedmiot_biologia.size() == 0)
        {
            oceny_z_biologi = new Biology(0,555,555,555,"555","555","555"); // kod informujacy ze pobierasz dane z pustej tablicy
            Toast.makeText(getApplicationContext(), "Dodaj pierwszego ucznia.",
                    Toast.LENGTH_LONG).show();
        }else{
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
