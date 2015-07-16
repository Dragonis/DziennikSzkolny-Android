package WojtekSasiela.DziennikSzkolny;

import WojtekSasiela.DziennikSzkolny.ORM.CRUD.READ.LoadDataFromDatabase;
import WojtekSasiela.DziennikSzkolny.StatisticActivity.*;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

/**
 * Created by Wojtek on 2014-11-23.
 */
public class StatystykiActivity extends Activity {
    ArrayList<String> ocenyArray;
    // get the selected radio button from the group
    RadioGroup radioGroup;
    RatingBar ratingBar;
    RadioButton radioButton;
    int liczba_gwiazdek;
    int selectedOption;

    ArrayList<String> oceny = new ArrayList<String>();
    ArrayList<String> daty = new ArrayList<String>();
    private CharSequence kliknieta_nazwa_przedmiotu;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statystyki_layout);
        radioGroup = (RadioGroup) findViewById(R.id.radioSets);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        int id_studenta = 1;
        int id_przegladanego_przedmiotu = 1;
        oceny =  LoadDataFromDatabase.loadStudentGrades(id_studenta, id_przegladanego_przedmiotu);

        Button oblicz_button_statystyki = (Button) findViewById(R.id.oblicz_button_statystyki);

        TextView srednia_klasy_statystyki = (TextView) findViewById(R.id.srednia_klasy_statystyki);
        TextView mediana_klasy_statystyki = (TextView) findViewById(R.id.mediana_klasy_statystyki);
        TextView dominanta_klasy_statystyki = (TextView) findViewById(R.id.dominanta_klasy_statystyki);
        TextView odchylenie_klasy_statystyki = (TextView) findViewById(R.id.odchylenie_klasy_statystyki);
        TextView kwartyle_klasy_statystyki = (TextView) findViewById(R.id.kwartyle_klasy_statystyki);



        //Pokaz_Activity_z_klasy(R.id.otworz_srednia_button, getApplicationContext(), SredniaAcitivity.class);
//        Pokaz_Activity_z_klasy(R.id.oblicz_button_statystyki, getApplicationContext(), WariancjaAcitivity.class);
//        Pokaz_Activity_z_klasy(R.id.oblicz_button_statystyki, getApplicationContext(), OdchylenieAcitivity.class);
//        Pokaz_Activity_z_klasy(R.id.oblicz_button_statystyki, getApplicationContext(), MedianaAcitivity.class);
//        Pokaz_Activity_z_klasy(R.id.oblicz_button_statystyki, getApplicationContext(), DominantaAcitivity.class);
//        Pokaz_Activity_z_klasy(R.id.otworz_kwartyle_button, getApplicationContext(), KwartyleAcitivity.class);    Pokaz_Activity_z_klasy(R.id.otworz_wariancja_button, getApplicationContext(), WariancjaAcitivity.class);
//        Pokaz_Activity_z_klasy(R.id.otworz_odchylenie_button, getApplicationContext(), OdchylenieAcitivity.class);
//        Pokaz_Activity_z_klasy(R.id.otworz_mediana_button, getApplicationContext(), MedianaAcitivity.class);
//        Pokaz_Activity_z_klasy(R.id.otworz_dominanta_button, getApplicationContext(), DominantaAcitivity.class);
//        Pokaz_Activity_z_klasy(R.id.otworz_kwartyle_button, getApplicationContext(), KwartyleAcitivity.class);
        zamknijOkno(R.id.Zamknij_Statystyki);

//        final Button srednia_button_statystyki = (Button) findViewById(R.id.otworz_srednia_button);
//        srednia_button_statystyki.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Pobieramy tekst z pola
//                //TODO W ocenyArray wsadz dane o ocenach z danej klasy
//                ocenyArray = new ArrayList<String>();
//                ocenyArray.add("0");
//                ocenyArray.add("0");
//                ocenyArray.add("0");
//                // Pakujemy go w Bundle
//                Bundle koszyk = new Bundle();
//                koszyk.putStringArrayList("ocenyArray", ocenyArray);
//                Intent cel = new Intent(view.getContext(), SredniaAcitivity.class);
//                cel.putExtras(koszyk);
//                startActivity(cel);
//
//
//            }
//        });

        oblicz_button_statystyki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO W ocenyArray wsadz dane o ocenach z danej klasy
//                ocenyArray = new ArrayList<String>();
//                ocenyArray.add("0");
//                ocenyArray.add("0");
//                ocenyArray.add("0");

                selectedOption = radioGroup.getCheckedRadioButtonId();
                // find the radiobutton by the previously returned id

                liczba_gwiazdek = ratingBar.getRating();
                radioButton = (RadioButton) findViewById(selectedOption);

//                Bundle koszyk = new Bundle();
//                Intent cel = new Intent();
//                koszyk.putStringArrayList("ocenyArray", ocenyArray);
                if (radioButton == null) {
                    Toast.makeText(getApplicationContext(), "Wybierz miare statystyczna i nr klasy", Toast.LENGTH_SHORT).show();
                } else {
//
//                    if (radioButton.getText().equals("Polski")) {
//                        cel = new Intent(view.getContext(), SredniaAcitivity.class);
//                    }
//                    if (radioButton.getText().equals("Angielski")) {
//                        cel = new Intent(view.getContext(), WariancjaAcitivity.class);
//                    }
//                    if (radioButton.getText().equals("Matematyka")) {
//                        cel = new Intent(view.getContext(), OdchylenieAcitivity.class);
//                    }
//                    if (radioButton.getText().equals("Przyroda")) {
//                        cel = new Intent(view.getContext(), MedianaAcitivity.class);
//                    }
//                    if (radioButton.getText().equals("Religia")) {
//                        cel = new Intent(view.getContext(), DominantaAcitivity.class);
//                    }
//                    if (radioButton.getText().equals("WF")) {
//                        cel = new Intent(view.getContext(), KwartyleAcitivity.class);
//                    }

                    kliknieta_nazwa_przedmiotu = radioButton.getText();

                    /*
                     Zmienna - Opis
                     oceny - Tablica ocen
                     liczba_gwiazdek - kliknieta liczba gwiazdek
                    kliknieta_nazwa_przedmiotu - kliknieta nazwa przedmiotu
                     */

                    srednia_klasy_statystyki.setText("Srednia: " + oceny.get(0));
                    mediana_klasy_statystyki.setText("Mediana: " + oceny.get(0));
                    dominanta_klasy_statystyki.setText("Dominanta: " + oceny.get(0));
                    odchylenie_klasy_statystyki.setText("Odchylenie: " + oceny.get(0));
                    kwartyle_klasy_statystyki.setText("Kwartyyle: " + oceny.get(0));


                    Toast.makeText(getApplicationContext(),
                            kliknieta_nazwa_przedmiotu + " " + String.valueOf(liczba_gwiazdek)
                            , Toast.LENGTH_SHORT).show();

//                        cel.putExtras(koszyk);
//                        startActivity(cel);

                }
            }
        });
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