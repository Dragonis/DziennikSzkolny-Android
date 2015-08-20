package sasiela.wojtek.dziennikszkolny;


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

import sasiela.wojtek.dziennikszkolny.ORM.Country;
import sasiela.wojtek.dziennikszkolny.ORM.tables.Student;
import sasiela.wojtek.dziennikszkolny.ORM.configuration.DatabaseAccessObjects;
import sasiela.wojtek.dziennikszkolny.ORM.tables.new_version_database.Ocena;
import sasiela.wojtek.dziennikszkolny.ORM.tables.new_version_database.Przedmiot;
import sasiela.wojtek.dziennikszkolny.ORM.tables.new_version_database.Uczen;

/**
 * Created by Wojtek on 2015-01-28.
 */
public class DaneUczniaActivity extends Activity {

    String Imie, Nazwisko, nrKlasy, przedmiot;
    String date1, grade1;
    List<String> oceny_z_przyrody, daty_z_przyrody = new ArrayList<String>();
    ArrayList<String> data_z_ocena = new ArrayList<String>();
    Intent cel;
    RadioButton radioButton1, radioButton2, radioButton3;

    Button edytujocene, usunocene, dodajocene;

    private int id_studenta;
    private Student pobrany_student_z_db;
    private List<String> oceny_studenta;
    private List<String> daty_ocen;
    private int id_przegladanego_przedmiotu;
    int id_kliknietego_elementu_w_ListView;

    List<String> oceny = new ArrayList<String>();
    List<String> daty = new ArrayList<String>();
    String obliczona_srednia;

    private boolean zaznaczony_jakikolwiek_radiobutton = false;

    MyCustomAdapter dataAdapter = null;

    TextView pokaz_imie_nazwisko_textview;
    TextView nrKlasy_textview;
    TextView przedmiot_textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dane_ucznia_layout);

        MiaryStatystyczne statystyka = new MiaryStatystyczne();

        TextView napis_wariancja_przedmiotu = (TextView) findViewById(R.id.napis_wariancja);
        TextView napis_srednia_przedmiotu = (TextView) findViewById(R.id.napis_srednia);
        TextView napis_dominanta_przedmiotu = (TextView) findViewById(R.id.napis_dominanta);
        TextView napis_mediana_przedmiotu = (TextView) findViewById(R.id.napis_mediana);
        TextView napis_odchylenie_przedmiotu = (TextView) findViewById(R.id.napis_odchylenie);
        TextView napis_kwartyle_przedmiotu = (TextView) findViewById(R.id.napis_kwartyle);

        pokaz_imie_nazwisko_textview = (TextView) findViewById(R.id.pokazImieiNaziwsko);
        nrKlasy_textview = (TextView) findViewById(R.id.nrKlasy);
        przedmiot_textview = (TextView) findViewById(R.id.przedmiot);

        pobierzDanezPoprzedniegoActivity();

        pokaz_imie_nazwisko_textview.setText(Imie + " " + Nazwisko);
        nrKlasy_textview.setText(nrKlasy);
        przedmiot_textview.setText(przedmiot);

        if (oceny.isEmpty() || daty.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Uczeń ten nie ma żadnych ocen.", Toast.LENGTH_LONG).show();

            napis_wariancja_przedmiotu.setText("Wariancja: " + " -" );
            napis_srednia_przedmiotu.setText("Srednia: " + " - ");
            napis_dominanta_przedmiotu.setText("Dominanta:" + " - " );
            napis_mediana_przedmiotu.setText("Mediana: " + " - ");
            napis_odchylenie_przedmiotu.setText("Odchylenie: " + " - ");
            napis_kwartyle_przedmiotu.setText("Kwartyle: " + " - ");

        } else {

            for (Integer i = 0; i < daty.size(); i++) {

                data_z_ocena.add(daty.get(i) + " - " + oceny.get(i));
            }

            napis_wariancja_przedmiotu.setText("Wariancja: " + Double.toString(statystyka.Wariancja((ArrayList<String>) oceny)));
            napis_srednia_przedmiotu.setText("Srednia: " + Double.toString(statystyka.Srednia((ArrayList<String>) oceny)));
            napis_dominanta_przedmiotu.setText("Dominanta:" + Double.toString(statystyka.Dominanta((ArrayList<String>) oceny)));
            napis_mediana_przedmiotu.setText("Mediana: " + Double.toString(statystyka.Mediana((ArrayList<String>) oceny)));
            napis_odchylenie_przedmiotu.setText("Odchylenie: " + Double.toString(statystyka.Odchylenie((ArrayList<String>) oceny)));
            napis_kwartyle_przedmiotu.setText("Kwartyle: " + Double.toString(statystyka.Kwartyle((ArrayList<String>) oceny)));

        }

        //region zainicjalizuj_formatke

        edytujocene = (Button) findViewById(R.id.edytuj_ocene_button_daneucznia);
        usunocene = (Button) findViewById(R.id.usun_ocene_button_daneucznia);
        dodajocene = (Button) findViewById(R.id.dodaj_ocene_button_daneucznia);




        //Generate list View from ArrayList
        displayListView();
//        checkButtonClick();

        zamknijOkno(R.id.Wyjdzbttn_OcenyLayout);


        Pokaz_Activity_z_klasy(R.id.dodaj_ocene_button_daneucznia, getApplicationContext(), DodajOceneActivity.class);
        Pokaz_Activity_z_klasy(R.id.edytuj_ocene_button_daneucznia, getApplicationContext(), EdytujOceneActivity.class);
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
                zamknijOkno(R.id.dodaj_ocene_button_daneucznia);
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

        usunocene.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "Usunięto element: " + id_kliknietego_elementu_w_ListView, Toast.LENGTH_SHORT).show();
            }
        });

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

        oceny = pobierzOcenyzDB_New_Version(Imie, Nazwisko, nrKlasy, przedmiot);
        daty = pobierzDatyzDB_New_Version(Imie, Nazwisko, nrKlasy, przedmiot);

        String grade = przekazanedane.getString("grade");
        String date = przekazanedane.getString("date");

        if(grade == null && date == null ) {
        }else{
            Toast.makeText(DaneUczniaActivity.this, "Data: " + date + " " + ",Ocena: " + grade, Toast.LENGTH_SHORT).show();
        }

    }

    public List<String> pobierzOcenyzDB_New_Version(String imie, String nazwisko, String nrKlasy, String nazwaPrzedmiotu) {
        // TODO Pobieranie ocen z bazy danych i wyswietlenie w tabelach
        DatabaseAccessObjects dbHelper = OpenHelperManager.getHelper(this, DatabaseAccessObjects.class);
        RuntimeExceptionDao<Uczen, Integer> uczenDao = dbHelper.getUczenRuntimeExceptionDao();
        RuntimeExceptionDao<Ocena, Integer> ocenaDao = dbHelper.getOcenaRuntimeExceptionDao();
        RuntimeExceptionDao<Przedmiot, Integer> przedmiotDao = dbHelper.getPrzedmiotRuntimeExceptionDao();
        List<Ocena> oceny = new ArrayList<Ocena>();
        try {
            List<Uczen> students = uczenDao.queryBuilder().where().eq("nazwisko", nazwisko).query();
            List<Przedmiot> przedmioty = przedmiotDao.queryBuilder().where().eq("nazwa", nazwaPrzedmiotu).query();

            Integer id_ucznia = students.get(0).getId_ucznia();
            Integer id_przedmiotu = przedmioty.get(0).getId_przedmiotu();

            oceny = ocenaDao.queryBuilder().selectColumns("ocena").where().eq("id_ucznia", id_ucznia).and().eq("id_przedmiotu", id_przedmiotu).query();
        } catch (Exception ex) {
//            Toast.makeText(getApplicationContext(), "DameiczmoaActivity ERROR Oceny: " + ex.getMessage() ,Toast.LENGTH_LONG).show();

        }

        //zamiana z List<Integer> na List,String> zeby pozniej moc te oceny przeslac do nastepnego activity
        List<String> oceny_string = new ArrayList<String>();
        for (Ocena ocena : oceny) {
            oceny_string.add(ocena.getOcena().toString());
        }

        return oceny_string;

    }

    public List<String> pobierzDatyzDB_New_Version(String imie, String nazwisko, String nrKlasy, String nazwaPrzedmiotu) {
        // TODO Pobieranie ocen z bazy danych i wyswietlenie w tabelach
        DatabaseAccessObjects dbHelper = OpenHelperManager.getHelper(this, DatabaseAccessObjects.class);
        RuntimeExceptionDao<Uczen, Integer> uczenDao = dbHelper.getUczenRuntimeExceptionDao();
        RuntimeExceptionDao<Ocena, Integer> ocenaDao = dbHelper.getOcenaRuntimeExceptionDao();
        RuntimeExceptionDao<Przedmiot, Integer> przedmiotDao = dbHelper.getPrzedmiotRuntimeExceptionDao();
        List<Ocena> daty = new ArrayList<Ocena>();
        try {
            List<Uczen> students = uczenDao.queryForEq("nazwisko", nazwisko);
            List<Przedmiot> przedmioty = przedmiotDao.queryForEq("nazwa", nazwaPrzedmiotu);
            Integer id_ucznia = students.get(0).getId_ucznia();
            Integer id_przedmiotu = przedmioty.get(0).getId_przedmiotu();

            daty = ocenaDao.queryBuilder().selectColumns("Data").where().eq("id_ucznia", id_ucznia).and().eq("id_przedmiotu", id_przedmiotu).query();
            // id kliknietej osoby (nizej)
        } catch (Exception ex) {
            //Toast.makeText(getApplicationContext(), "DameiczmoaActivity ERROR Daty: " + ex.getMessage() ,Toast.LENGTH_LONG).show();

        }
        List<String> listaDat = new ArrayList<String>();
        for (Ocena data : daty) {
            listaDat.add(data.getData());
        }
        return listaDat;
    }

    public Uczen pobierzStudenta_NewVersion(int id_ucznia)
    {
        DatabaseAccessObjects dbHelper = OpenHelperManager.getHelper(this, DatabaseAccessObjects.class);
        RuntimeExceptionDao<Uczen, Integer> uczenDao = dbHelper.getUczenRuntimeExceptionDao();
        Uczen student = uczenDao.queryForEq("id_ucznia", id_ucznia).get(0);
        return student;
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
        public View getView(final int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;
            final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

            Log.v("ConvertView", String.valueOf(position));

            if (convertView == null) {
                LayoutInflater vi = (LayoutInflater) getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
                convertView = vi.inflate(R.layout.country_info, null);

                holder = new ViewHolder();
                holder.code = (TextView) convertView.findViewById(R.id.code);
                holder.name = (RadioButton) convertView.findViewById(R.id.radioButton_ocena_z_data);
                convertView.setTag(holder);

                holder.name.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        cb = (RadioButton) v;

                        Country country = (Country) cb.getTag();


                        if (zaznaczony_radio_button != null) {
                            if (zaznaczony_radio_button == cb) {

                            } else {
                                radioGroup.clearCheck();
                                zaznaczony_radio_button.setChecked(false);

                                zaznaczony_radio_button = cb;
                                cb.setChecked(true);
                            }
                        } else {
                            radioGroup.clearCheck();
                            zaznaczony_radio_button = cb;
                            zaznaczony_jakikolwiek_radiobutton = true;
                            cb.setChecked(true);
                        }

                        id_kliknietego_elementu_w_ListView = position;


                        uaktywnijReszteButtonowPoKliknieciuNaJakiegokolwiekRadioButtona();


                        Toast.makeText(getApplicationContext(),
                                "Clicked on Checkbox: " + cb.getText() +
                                        " is " + cb.isChecked(),
                                Toast.LENGTH_LONG).show();
                        country.setSelected(cb.isChecked());
                    }
                });
            } else {
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

    private void uaktywnijReszteButtonowPoKliknieciuNaJakiegokolwiekRadioButtona() {

        edytujocene.setEnabled(true);
        usunocene.setEnabled(true);

    }

    private void displayListView() {

        //Array list of countries
        ArrayList<Country> countryList = new ArrayList<Country>();
        for (int i = 0; i < oceny.size(); i++) {

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
