package WojtekSasiela.DziennikSzkolny;

import WojtekSasiela.DziennikSzkolny.Fragments.*;
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
    float liczba_gwiazdek;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_statystyki_layout);
        radioGroup = (RadioGroup) findViewById(R.id.radioSets);
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        Button pokaz_button_statystyki = (Button) findViewById(R.id.pokaz_button_statystyki);
          //Pokaz_Activity_z_klasy(R.id.otworz_srednia_button, getApplicationContext(), SredniaAcitivity.class);
        Pokaz_Activity_z_klasy(R.id.pokaz_button_statystyki, getApplicationContext(), WariancjaAcitivity.class);
        Pokaz_Activity_z_klasy(R.id.pokaz_button_statystyki, getApplicationContext(), OdchylenieAcitivity.class);
        Pokaz_Activity_z_klasy(R.id.pokaz_button_statystyki, getApplicationContext(), MedianaAcitivity.class);
        Pokaz_Activity_z_klasy(R.id.pokaz_button_statystyki, getApplicationContext(), DominantaAcitivity.class);
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

        pokaz_button_statystyki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO W ocenyArray wsadz dane o ocenach z danej klasy
                ocenyArray = new ArrayList<String>();
                ocenyArray.add("0");
                ocenyArray.add("0");
                ocenyArray.add("0");

                int selectedOption = radioGroup.getCheckedRadioButtonId();
                	            // find the radiobutton by the previously returned id

                                liczba_gwiazdek = ratingBar.getRating();
                	            RadioButton radioButton = (RadioButton) findViewById(selectedOption);
                	            Toast.makeText(StatystykiActivity.this, radioButton.getText() + " " + liczba_gwiazdek
                , Toast.LENGTH_SHORT).show();



                Bundle koszyk = new Bundle();
                Intent cel = new Intent();
                koszyk.putStringArrayList("ocenyArray", ocenyArray);

                if(radioButton.getText().equals("Srednia arytmetyczna")) {
                    cel = new Intent(view.getContext(), SredniaAcitivity.class);
                    Pokaz_Activity_z_klasy(R.id.pokaz_button_statystyki, getApplicationContext(), WariancjaAcitivity.class);

                }
                if(radioButton.getText().equals("Wariancja"))
                {
                     cel = new Intent(view.getContext(), WariancjaAcitivity.class);
                }
                if(radioButton.getText().equals("Odchylenie standardowe"))
                {
                     cel = new Intent(view.getContext(), OdchylenieAcitivity.class);
                }
                if(radioButton.getText().equals("Mediana"))
                {
                    cel = new Intent(view.getContext(), MedianaAcitivity.class);
                }
                if(radioButton.getText().equals("Dominanta"))
                {
                    cel = new Intent(view.getContext(), DominantaAcitivity.class);
                }
                if(radioButton.getText().equals("Kwartyle"))
                {
                    cel = new Intent(view.getContext(), KwartyleAcitivity.class);
                }


                cel.putExtras(koszyk);
                startActivity(cel);
            }
        });
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

    public void zamknijOkno(int id)
    {
        Button b = (Button)findViewById(id);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}