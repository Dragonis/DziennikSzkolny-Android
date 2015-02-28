package WojtekSasiela.DziennikSzkolny;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.LineGraphView;

/**
 * Created by Wojtek on 2014-11-23.
 */
public class KwartyleAcitivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kwartyle_layout);

        // Pokaz_Activity_z_klasy(R.id.otworz_srednia_button, getApplicationContext(),SredniaAcitivity.class);

        rysujWykres_Kwartyle();

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