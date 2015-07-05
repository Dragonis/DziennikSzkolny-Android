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
public class MedianaAcitivity extends Activity {
    String obliczona_mediana;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_mediana_layout);
        // Pokaz_Activity_z_klasy(R.id.otworz_srednia_button, getApplicationContext(),SredniaAcitivity.class);

        MiaryStatystyczne statystyka = new MiaryStatystyczne();

        // dane pochodza z DaneUczniaActivity badz StatystykaActivity
        Bundle przekazanedane = getIntent().getExtras();
        if (przekazanedane == null) {
            Toast.makeText(getApplicationContext(), "Pobrane dane sa puste!", Toast.LENGTH_SHORT);
            obliczona_mediana = "0.0";
        } else {
            String imie = przekazanedane.getString("imie");
            String nazwisko = przekazanedane.getString("nazwisko");
            String klasa = przekazanedane.getString("klasa");
            String przedmiot = przekazanedane.getString("przedmiot");
            ArrayList<String> oceny = przekazanedane.getStringArrayList("ocenyArray");
            if (oceny == null) {
                obliczona_mediana = "0.0";
            } else {
                obliczona_mediana = Float.toString((float) statystyka.Mediana(oceny));
            }

        }
        TextView mediana_textview = (TextView) findViewById(R.id.obliczMediane_textview);
        mediana_textview.setText(obliczona_mediana);

        rysujWykres_Mediana();

        // Laczy operacje zamkniecia z konkrentym buttonem
        zamknijOkno(R.id.zamknij_mediana);
    }

    public void rysujWykres_Mediana()
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
                , "Mediana" // heading
        );

        graphView.addSeries(exampleSeries); // data

        LinearLayout layout = (LinearLayout) findViewById(R.id.mediana_layout);
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