package WojtekSasiela.DziennikSzkolny;

import WojtekSasiela.DziennikSzkolny.ORM.CRUD.READ.LoadDataFromDatabase;
import WojtekSasiela.DziennikSzkolny.ORM.configuration.DatabaseAccessObjects;
import WojtekSasiela.DziennikSzkolny.ORM.tables.Student;
import WojtekSasiela.DziennikSzkolny.ORM.tables.subjects.Biology;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Wojtek on 2015-01-28.
 */
public class DaneUczniaActivity extends Activity {

    String Imie = "Wojtek";
    String Nazwisko = "Sasiela";
    String nrKlasy = "1";
    String przedmiot = "1";
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

    private int id_studenta;
    private Student pobrany_student_z_db;
    private List<String> oceny_studenta;
    private List<String> daty_ocen;
    private int id_przegladanego_przedmiotu;

    ArrayList<String> oceny = new ArrayList<String>();
    ArrayList<String> daty = new ArrayList<String>();
    String obliczona_srednia;

    private boolean zaznaczony_jakikolwiek_radiobutton = false;

    MyCustomAdapter dataAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dane_ucznia_layout);

        pobrany_student_z_db = pobierz_wszystkie_dane_studenta_z_db();
        id_studenta = pobrany_student_z_db.getId();
        id_przegladanego_przedmiotu = 1;

        oceny =  LoadDataFromDatabase.loadStudentGrades(id_studenta,id_przegladanego_przedmiotu);
        daty =  LoadDataFromDatabase.loadStudentDates(id_studenta,id_przegladanego_przedmiotu);

        //region zainicjalizuj_formatke

        edytujocene = (Button) findViewById(R.id.edytuj_ocene_button_daneucznia);
        usunocene = (Button) findViewById(R.id.usun_ocene_button_daneucznia);
        dodajocene = (Button) findViewById(R.id.dodaj_ocene_button_daneucznia);


//        data_z_ocena_listview = (ListView) findViewById(R.id.data_z_ocena_listview);
        pobierzDanezPoprzedniegoActivity();

        //Generate list View from ArrayList
        displayListView();
//        checkButtonClick();

        zamknijOkno(R.id.Wyjdzbttn_OcenyLayout);

        MiaryStatystyczne statystyka= new MiaryStatystyczne();

        TextView napis_wariancja_przedmiotu = (TextView) findViewById(R.id.napis_wariancja);
        TextView napis_srednia_przedmiotu = (TextView) findViewById(R.id.napis_srednia);
        TextView napis_dominanta_przedmiotu = (TextView) findViewById(R.id.napis_dominanta);
        TextView napis_mediana_przedmiotu = (TextView) findViewById(R.id.napis_mediana);
        TextView napis_odchylenie_przedmiotu = (TextView) findViewById(R.id.napis_odchylenie);
        TextView napis_kwartyle_przedmiotu = (TextView) findViewById(R.id.napis_kwartyle);

        napis_wariancja_przedmiotu.setText("Wariancja: " + Double.toString(statystyka.Wariancja(oceny)));
        napis_srednia_przedmiotu.setText("Srednia: " + Double.toString(statystyka.Srednia(oceny)));
        napis_dominanta_przedmiotu.setText("Dominanta:" + Double.toString(statystyka.Dominanta(oceny)));
        napis_mediana_przedmiotu.setText("Mediana: " + Double.toString(statystyka.Mediana(oceny)));
        napis_odchylenie_przedmiotu.setText("Odchylenie: " + Double.toString(statystyka.Odchylenie(oceny)));
        napis_kwartyle_przedmiotu.setText("Kwartyle: " + Double.toString(statystyka.Kwartyle(oceny)));



//         wyswitlanie odpowiednich activity statystycznych
        Pokaz_Activity_z_klasy(R.id.dodaj_ocene_button_daneucznia, getApplicationContext(), DodajOceneActivity.class);
        Pokaz_Activity_z_klasy(R.id.edytuj_ocene_button_daneucznia, getApplicationContext(), EdytujOceneActivity.class);
//        Pokaz_Activity_z_klasy(R.id.srednia_button_daneucznia, getApplicationContext(), SredniaAcitivity.class);
//        Pokaz_Activity_z_klasy(R.id.mediana_button_daneucznia, getApplicationContext(), MedianaAcitivity.class);
//        Pokaz_Activity_z_klasy(R.id.wariancja_button_daneucznia, getApplicationContext(), WariancjaAcitivity.class);
//        Pokaz_Activity_z_klasy(R.id.dominanta_button_daneucznia, getApplicationContext(), DominantaAcitivity.class);
//        Pokaz_Activity_z_klasy(R.id.odchylenie_button_daneucznia, getApplicationContext(), OdchylenieAcitivity.class);
//        Pokaz_Activity_z_klasy(R.id.kwartyle_button_daneucznia, getApplicationContext(), KwartyleAcitivity.class);
//
//        Button srednia_button_dane_ucznia = (Button) findViewById(R.id.srednia_button_daneucznia);
//        Button dominanta_button_dane_ucznia = (Button) findViewById(R.id.dominanta_button_daneucznia);
//        Button kwartyle_button_dane_ucznia = (Button) findViewById(R.id.kwartyle_button_daneucznia);
//        Button mediana_button_dane_ucznia = (Button) findViewById(R.id.mediana_button_daneucznia);
//        Button odchylenie_button_dane_ucznia = (Button) findViewById(R.id.odchylenie_button_daneucznia);
//        Button wariancja_button_dane_ucznia = (Button) findViewById(R.id.wariancja_button_daneucznia);
        //endregion

        //region dodajocene_onClick
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
        //endregion

        //region edytujocene_onClick
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
        //endregion

        //region srednia_onClick
//        srednia_button_dane_ucznia.setOnClickListener(new Button.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                cel = new Intent(view.getContext(), SredniaAcitivity.class);
//                wyslijDaneDoNastepnegoActivity(view);
//            }
//        });
        //endregion

        //region dominanta_onClick
//        dominanta_button_dane_ucznia.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                cel = new Intent(view.getContext(), DominantaAcitivity.class);
//                wyslijDaneDoNastepnegoActivity(view);
//            }
//        });
        //endregion

        //region kwartyle_onClick
//        kwartyle_button_dane_ucznia.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                cel = new Intent(view.getContext(), KwartyleAcitivity.class);
//                wyslijDaneDoNastepnegoActivity(view);
//            }
//        });
        //endregion

        //region mediana_onClick
//        mediana_button_dane_ucznia.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                cel = new Intent(view.getContext(), MedianaAcitivity.class);
//                wyslijDaneDoNastepnegoActivity(view);
//            }
//        });
        //endregion

        //region odchylenie_standardowe_onClick
//        odchylenie_button_dane_ucznia.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                cel = new Intent(view.getContext(), OdchylenieAcitivity.class);
//                wyslijDaneDoNastepnegoActivity(view);
//            }
//        });
        //endregion

        //region wariancja_onClick
//        wariancja_button_dane_ucznia.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                cel = new Intent(view.getContext(), WariancjaAcitivity.class);
//                wyslijDaneDoNastepnegoActivity(view);
//            }
//        });
        //endregion

    }

    private void wyslijDaneDoNastepnegoActivity(View view) {
        Bundle koszyk = new Bundle();
        koszyk.putString("imie", Imie);
        koszyk.putString("nazwisko", Nazwisko);
        koszyk.putString("klasa", nrKlasy);
        koszyk.putString("przedmiot", przedmiot);
        koszyk.putStringArrayList("ocenyArray", (ArrayList<String>) oceny_z_przyrody);
        koszyk.putStringArrayList("datyArray", (ArrayList<String>) daty_ocen);
        // Definiujemy cel
        cel.putExtras(koszyk);
        // Wysyłamy
        startActivity(cel);
    }


    public Student pobierz_wszystkie_dane_studenta_z_db() {
        pobrany_student_z_db = LoadDataFromDatabase.load_Student_fromDatabase(Imie, Nazwisko);
        return pobrany_student_z_db;
    }

    public List<String> pobierz_oceny() {
        oceny_studenta = LoadDataFromDatabase.loadStudentGrades(id_studenta, id_przegladanego_przedmiotu);
        return oceny_studenta;
    }

    public List<String> pobierz_daty_wystawionych_ocen()
    {
        daty_ocen = LoadDataFromDatabase.loadStudentDates(id_studenta, id_przegladanego_przedmiotu);
        return daty_ocen;
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

        List<String> oceny = pobierz_oceny();
        List<String> daty = pobierz_daty_wystawionych_ocen();

        grade1 = oceny.get(0);
        grade2 = oceny.get(1);
        grade3 = oceny.get(2);

        date1 = daty.get(0);
        date2 = daty.get(1);
        date3 = daty.get(2);

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
        for (Integer i = 0; i < daty_z_przyrody.size(); i++) {

            data_z_ocena.add(daty_z_przyrody.get(i) + " - " + oceny_studenta.get(i));
        }

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


    private class MyCustomAdapter extends ArrayAdapter<Country> {

        private ArrayList<Country> countryList;
        private RadioButton zaznaczony_radio_button = null;
        private RadioButton cb = null;

        public MyCustomAdapter(Context context, int textViewResourceId,
                               ArrayList<Country> countryList) {
            super(context, textViewResourceId, countryList);
            this.countryList = new ArrayList<Country>();
            this.countryList.addAll(countryList);
        }

        private class ViewHolder {
            TextView code;
            RadioButton name;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;
            final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

            Log.v("ConvertView", String.valueOf(position));

            if (convertView == null) {
                LayoutInflater vi = (LayoutInflater)getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
                convertView = vi.inflate(R.layout.country_info, null);

                holder = new ViewHolder();
                holder.code = (TextView) convertView.findViewById(R.id.code);
                holder.name = (RadioButton) convertView.findViewById(R.id.radioButton_ocena_z_data);
                convertView.setTag(holder);

                holder.name.setOnClickListener( new View.OnClickListener() {
                    public void onClick(View v) {
                        cb = (RadioButton) v ;

                        Country country = (Country) cb.getTag();



                        if(zaznaczony_radio_button != null)
                        {
                            if(zaznaczony_radio_button == cb)
                            {

                            }else{
                                radioGroup.clearCheck();
                                zaznaczony_radio_button.setChecked(false);

                                zaznaczony_radio_button = cb;
                                cb.setChecked(true);
                            }
                        }else {
                            radioGroup.clearCheck();
                            zaznaczony_radio_button = cb;
                            cb.setChecked(true);
                        }


                        uaktywnijReszteButtonowPoKliknieciuNaJakiegokolwiekRadioButtona();



                        Toast.makeText(getApplicationContext(),
                                "Clicked on Checkbox: " + cb.getText() +
                                        " is " + cb.isChecked(),
                                Toast.LENGTH_LONG).show();
                        country.setSelected(cb.isChecked());
                    }
                });
            }
            else {
                holder = (ViewHolder) convertView.getTag();
            }

            Country country = countryList.get(position);
            holder.code.setText(" (" + country.getCode() + ")");
            holder.name.setText(country.getName());
            holder.name.setChecked(country.isSelected());
            holder.name.setTag(country);

            return convertView;

        }

    }

//    private void checkButtonClick() {
//
//
//        Button myButton = (Button) findViewById(R.id.findSelected);
//        myButton.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//
//                StringBuffer responseText = new StringBuffer();
//                responseText.append("The following were selected...\n");
//
//                ArrayList<Country> countryList = dataAdapter.countryList;
//                for(int i=0;i<countryList.size();i++){
//                    Country country = countryList.get(i);
//                    if(country.isSelected()){
//                        responseText.append("\n" + country.getName());
//                    }
//                }
//
//                Toast.makeText(getApplicationContext(),
//                        responseText, Toast.LENGTH_LONG).show();
//
//            }
//        });
//
//    }

    private void uaktywnijReszteButtonowPoKliknieciuNaJakiegokolwiekRadioButtona() {

            edytujocene.setEnabled(true);
            usunocene.setEnabled(true);

    }

    private void displayListView() {

        //Array list of countries
        ArrayList<Country> countryList = new ArrayList<Country>();
        for(int i=0; i < oceny.size(); i++) {

            Country country = new Country(daty.get(i), oceny.get(i), false);
            countryList.add(country);
        }

        //create an ArrayAdaptar from the String Array
        dataAdapter = new MyCustomAdapter(this,
                R.layout.country_info, countryList);
        ListView listView = (ListView) findViewById(R.id.listView1);
        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                Country country = (Country) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),
                        "Clicked on Row: " + country.getName(),
                        Toast.LENGTH_LONG).show();
            }
        });

    }
}
