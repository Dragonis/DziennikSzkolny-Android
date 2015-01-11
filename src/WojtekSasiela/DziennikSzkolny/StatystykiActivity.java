package WojtekSasiela.DziennikSzkolny;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.LineGraphView;

/**
 * Created by Wojtek on 2014-11-23.
 */
public class StatystykiActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statystyki_layout);
        Pokaz_Activity_z_klasy(R.id.otworz_srednia_button, getApplicationContext(), SredniaAcitivity.class);
        Pokaz_Activity_z_klasy(R.id.otworz_wariancja_button, getApplicationContext(), SredniaAcitivity.class);
        Pokaz_Activity_z_klasy(R.id.otworz_odchylenie_button, getApplicationContext(), SredniaAcitivity.class);
        Pokaz_Activity_z_klasy(R.id.otworz_mediana_button, getApplicationContext(), SredniaAcitivity.class);
        Pokaz_Activity_z_klasy(R.id.otworz_dominanta_button, getApplicationContext(), SredniaAcitivity.class);
        Pokaz_Activity_z_klasy(R.id.otworz_kwartyle_button, getApplicationContext(), SredniaAcitivity.class);
        zamknijOkno(R.id.Zamknij_Statystyki);

        rysujWykres();

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

    public void rysujWykres()
    {
        // init example series data
        GraphViewSeries exampleSeries = new GraphViewSeries(new GraphView.GraphViewData[] {
                new GraphView.GraphViewData(1, 2.0d)
                , new GraphView.GraphViewData(2, 1.5d)
                , new GraphView.GraphViewData(3, 2.5d)
                , new GraphView.GraphViewData(4, 1.0d)
        });

        GraphViewSeries exampleSeries2 = new GraphViewSeries(new GraphView.GraphViewData[] {
                new GraphView.GraphViewData(1, 1.0d)
                , new GraphView.GraphViewData(2, 4.5d)
                , new GraphView.GraphViewData(3, 2.5d)
                , new GraphView.GraphViewData(4, 3.0d)
        });

        GraphView graphView = new LineGraphView(
                this // context
                , "GraphViewDemo" // heading
        );
        GraphView graphView2 = new LineGraphView(
                this // context
                , "GraphViewDemo" // heading
        );
        graphView.addSeries(exampleSeries); // data
        graphView2.addSeries(exampleSeries2); // data

        LinearLayout layout = (LinearLayout) findViewById(R.id.layout);
        LinearLayout layout2 = (LinearLayout) findViewById(R.id.layout2);
        layout.addView(graphView);
        layout2.addView(graphView2);
    }
}