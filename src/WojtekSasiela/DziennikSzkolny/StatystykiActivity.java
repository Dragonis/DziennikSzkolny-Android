package WojtekSasiela.DziennikSzkolny;

import WojtekSasiela.DziennikSzkolny.ORM.CRUD.READ.LoadDataFromDatabase;
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

    private ArrayList<String> ocenyArray;
    private RadioGroup radioGroup;
    private RatingBar ratingBar;
    private RadioButton radioButton;
    private Button oblicz_button_statystyki;

    private ArrayList<String> oceny, daty = new ArrayList<String>();
    private CharSequence kliknieta_nazwa_przedmiotu;
    private String kliknieta_nazwa_przedmiotu_to_String;

    private TextView srednia_klasy_statystyki,
            wariancja_klasy_statystyki,
            mediana_klasy_statystyki,
            dominanta_klasy_statystyki,
            odchylenie_klasy_statystyki,
            kwartyle_klasy_statystyki;

    private float liczba_gwiazdek;
    private int selectedOption;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statystyki_layout);
        zamknijOkno(R.id.Zamknij_Statystyki);

        inicjalizacjaZmiennychTejKlasy();

        oblicz_button_statystyki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selectedOption = radioGroup.getCheckedRadioButtonId();
                liczba_gwiazdek = ratingBar.getRating();
                radioButton = (RadioButton) findViewById(selectedOption);

                if (radioButton == null) {
                    Toast.makeText(getApplicationContext(), "Wybierz miare statystyczna i nr klasy", Toast.LENGTH_SHORT).show();
                } else {

                    kliknieta_nazwa_przedmiotu = radioButton.getText();
                    kliknieta_nazwa_przedmiotu_to_String = radioButton.getText().toString();

                    oceny = LoadDataFromDatabase.loadStudentGradesForAllClasses_New_Version(liczba_gwiazdek, kliknieta_nazwa_przedmiotu_to_String);

                    try {
                        srednia_klasy_statystyki.setText("Srednia: " + oceny.get(0));
                        wariancja_klasy_statystyki.setText("Wariancja: " + oceny.get(1));
                        mediana_klasy_statystyki.setText("Mediana: " + oceny.get(0));
                        dominanta_klasy_statystyki.setText("Dominanta: " + oceny.get(0));
                        odchylenie_klasy_statystyki.setText("Odchylenie: " + oceny.get(1));
                        kwartyle_klasy_statystyki.setText("Kwartyyle: " + oceny.get(1));
                    } catch (Exception ex) {
                        ex.getStackTrace();
                        Toast.makeText(getApplicationContext(),
                                "Nie wszyscy uczniowie maja wprowadzone oceny. Dlatego nie mozna obliczyc miary statyst. ",
                                Toast.LENGTH_LONG).show();
                    }

                    Toast.makeText(getApplicationContext(),
                            kliknieta_nazwa_przedmiotu + " " + String.valueOf(liczba_gwiazdek)
                            , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void inicjalizacjaZmiennychTejKlasy() {
        radioGroup = (RadioGroup) findViewById(R.id.radioSets);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        oblicz_button_statystyki = (Button) findViewById(R.id.oblicz_button_statystyki);

        srednia_klasy_statystyki = (TextView) findViewById(R.id.srednia_klasy_statystyki);
        wariancja_klasy_statystyki = (TextView) findViewById(R.id.wariancja_klasy_statystyki);
        mediana_klasy_statystyki = (TextView) findViewById(R.id.mediana_klasy_statystyki);
        dominanta_klasy_statystyki = (TextView) findViewById(R.id.dominanta_klasy_statystyki);
        odchylenie_klasy_statystyki = (TextView) findViewById(R.id.odchylenie_klasy_statystyki);
        kwartyle_klasy_statystyki = (TextView) findViewById(R.id.kwartyle_klasy_statystyki);
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