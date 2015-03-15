package WojtekSasiela.DziennikSzkolny;

import WojtekSasiela.DziennikSzkolny.Fragments.*;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Wojtek on 2014-11-23.
 */
public class StatystykiActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_statystyki_layout);


        Pokaz_Activity_z_klasy(R.id.otworz_srednia_button, getApplicationContext(), SredniaAcitivity.class);
        Pokaz_Activity_z_klasy(R.id.otworz_wariancja_button, getApplicationContext(), WariancjaAcitivity.class);
        Pokaz_Activity_z_klasy(R.id.otworz_odchylenie_button, getApplicationContext(), OdchylenieAcitivity.class);
        Pokaz_Activity_z_klasy(R.id.otworz_mediana_button, getApplicationContext(), MedianaAcitivity.class);
        Pokaz_Activity_z_klasy(R.id.otworz_dominanta_button, getApplicationContext(), DominantaAcitivity.class);
        Pokaz_Activity_z_klasy(R.id.otworz_kwartyle_button, getApplicationContext(), KwartyleAcitivity.class);
        zamknijOkno(R.id.Zamknij_Statystyki);

        Button srednia_button_statystyki = (Button) findViewById(R.id.otworz_srednia_button);
        srednia_button_statystyki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Pobieramy tekst z pola
                //TODO W ocenyArray wsadz dane o ocenach z danej klasy
                ArrayList<String> ocenyArray = new ArrayList<String>();
                ocenyArray.add("0");
                ocenyArray.add("0");
                ocenyArray.add("0");
                // Pakujemy go w Bundle
                Bundle koszyk = new Bundle();
                koszyk.putStringArrayList("ocenyArray", ocenyArray);
                // Definiujemy cel
                Intent cel = new Intent(view.getContext(), SredniaAcitivity.class);
                cel.putExtras(koszyk);
                // Wysyłamy
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