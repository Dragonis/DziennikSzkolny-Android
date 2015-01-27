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
public class WariancjaAcitivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wariancja_layout);

        // Pokaz_Activity_z_klasy(R.id.otworz_srednia_button, getApplicationContext(),SredniaAcitivity.class);

        rysujWykres_Wariancja();

        // Laczy operacje zamkniecia z konkrentym buttonem
        zamknijOkno(R.id.zamknij_wariancja);
    }

    public void rysujWykres_Wariancja()
    {
        // init example series data
        GraphViewSeries exampleSeries_wariancja = new GraphViewSeries(new GraphView.GraphViewData[] {
                new GraphView.GraphViewData(1, 2.0d)
                , new GraphView.GraphViewData(2, 5.5d)
                , new GraphView.GraphViewData(3, 3.5d)
                , new GraphView.GraphViewData(4, 4.0d)
        });

        GraphView graphView_wariancja = new LineGraphView(
                this // context
                , "Wariancja" // heading
        );

        graphView_wariancja.addSeries(exampleSeries_wariancja); // data

        LinearLayout layout = (LinearLayout) findViewById(R.id.wariancja_layout);
        layout.addView(graphView_wariancja);

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