package sasiela.wojtek.dziennikszkolny;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import sasiela.wojtek.dziennikszkolny.ORM.CRUD.READ.LoadDataFromDatabase;

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
        Ustaw_wartosc_miarom_statystycznym("- ","- ","- ","- ","- ","- " );
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

                    try {

                        oceny = LoadDataFromDatabase.LoadAverageAllGradesInAllClasses(liczba_gwiazdek);
                        MiaryStatystyczne miaryStatystyczne = new MiaryStatystyczne();
                        String srednia = String.valueOf(miaryStatystyczne.Srednia(oceny));
                        String dominanta = String.valueOf(miaryStatystyczne.Dominanta(oceny));
                        String wariancja = String.valueOf(miaryStatystyczne.Wariancja(oceny));
                        String mediana = String.valueOf(miaryStatystyczne.Mediana(oceny));
                        String odchylenie = miaryStatystyczne.Odchylenie(oceny);
                        String kwartyle = String.valueOf(miaryStatystyczne.Kwartyle(oceny));
                        Ustaw_wartosc_miarom_statystycznym(srednia,dominanta, wariancja, mediana, odchylenie, kwartyle);
                    } catch (Exception ex) {
                        ex.getStackTrace();
                        Toast.makeText(getApplicationContext(),
                                "Klasa ta, nie ma żadnego ucznia, bądz tez uczeń ten nie ma żadnych ocen.",
                                Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }

    public void Ustaw_wartosc_miarom_statystycznym(String srednia, String dominanta, String wariancja, String mediana , String odchylenie, String kwartyle) {
        srednia_klasy_statystyki.setText("Srednia: " + srednia);
        wariancja_klasy_statystyki.setText("Wariancja: " + wariancja);
        mediana_klasy_statystyki.setText("Mediana: " + mediana);
        dominanta_klasy_statystyki.setText("Dominanta: " + dominanta);
        odchylenie_klasy_statystyki.setText("Odchylenie: " + odchylenie);
        kwartyle_klasy_statystyki.setText("Kwartyyle: " + kwartyle);
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