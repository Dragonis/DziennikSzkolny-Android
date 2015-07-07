package WojtekSasiela.DziennikSzkolny.StatisticActivity;

import WojtekSasiela.DziennikSzkolny.MiaryStatystyczne;
import WojtekSasiela.DziennikSzkolny.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.LineGraphView;

import java.util.ArrayList;

/**
 * Created by Wojtek on 2014-11-23.
 */
public class KwartyleAcitivity extends Activity {
    String obliczone_kwartyle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statystyka_kwartyle_layout);
        // Pokaz_Activity_z_klasy(R.id.otworz_srednia_button, getApplicationContext(),SredniaAcitivity.class);

        rysujWykres_Kwartyle();

        MiaryStatystyczne statystyka = new MiaryStatystyczne();

        // dane pochodza z DaneUczniaActivity badz StatystykaActivity
        Bundle przekazanedane = getIntent().getExtras();
        if (przekazanedane == null) {
            Toast.makeText(getApplicationContext(), "Pobrane dane sa puste!", Toast.LENGTH_SHORT);
            obliczone_kwartyle = "0.0";
        } else {
            String imie = przekazanedane.getString("imie");
            String nazwisko = przekazanedane.getString("nazwisko");
            String klasa = przekazanedane.getString("klasa");
            String przedmiot = przekazanedane.getString("przedmiot");
            ArrayList<String> oceny = przekazanedane.getStringArrayList("ocenyArray");
            if (oceny == null) {
                obliczone_kwartyle = "0.0";
            } else {
                obliczone_kwartyle = Float.toString((float) statystyka.Srednia(oceny));
            }
        }

        TextView kwartyle_textview = (TextView) findViewById(R.id.obliczKwartle_textview);
        kwartyle_textview.setText(obliczone_kwartyle);

        // Laczy operacje zamkniecia z konkrentym buttonem
        zamknijOkno(R.id.zamknij_kwartyle);
    }

    public void rysujWykres_Kwartyle()
    {
        // init example series data
        GraphViewSeries exampleSeries = new GraphViewSeries(new GraphView.GraphViewData[] {
                new GraphView.GraphViewData(1, 2.0d)
                , new GraphView.GraphViewData(2, 1.5d)
                , new GraphView.GraphViewData(3, 2.5d)
                , new GraphView.GraphViewData(4, 1.0d)
        });

        GraphView graphView = new LineGraphView(
                this // context
                , "Kwartyle" // heading
        );

        graphView.addSeries(exampleSeries); // data

        LinearLayout layout = (LinearLayout) findViewById(R.id.kwartyle_layout);
        layout.addView(graphView);

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