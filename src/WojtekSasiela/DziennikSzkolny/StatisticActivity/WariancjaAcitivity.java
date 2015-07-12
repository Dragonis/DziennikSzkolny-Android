package WojtekSasiela.DziennikSzkolny.StatisticActivity;

import WojtekSasiela.DziennikSzkolny.MiaryStatystyczne;
import WojtekSasiela.DziennikSzkolny.R;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.LineGraphView;
import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.BarChart;
import org.achartengine.chart.LineChart;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.SeriesSelection;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import java.util.ArrayList;

/**
 * Created by Wojtek on 2014-11-23.
 */
public class WariancjaAcitivity extends Activity {

    private GraphicalView mChart;

    private String[] mMonth = new String[] {
            "Jan", "Feb" , "Mar", "Apr", "May", "Jun",
            "Jul", "Aug" , "Sep", "Oct", "Nov", "Dec"
    };
    String obliczona_wariancja;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statystyka_wariancja_layout);
        // Pokaz_Activity_z_klasy(R.id.otworz_srednia_button, getApplicationContext(),SredniaAcitivity.class);

        //rysujWykres_Wariancja();
        openChart();

        MiaryStatystyczne statystyka = new MiaryStatystyczne();

        // dane pochodza z DaneUczniaActivity badz StatystykaActivity
        Bundle przekazanedane = getIntent().getExtras();
        if (przekazanedane == null) {
            Toast.makeText(getApplicationContext(),"Pobrane dane sa puste!",Toast.LENGTH_SHORT);
            obliczona_wariancja = "0.0";
        } else {


            String imie = przekazanedane.getString("imie");
            String nazwisko = przekazanedane.getString("nazwisko");
            String klasa = przekazanedane.getString("klasa");
            String przedmiot = przekazanedane.getString("przedmiot");

            ArrayList<String> oceny = przekazanedane.getStringArrayList("ocenyArray");

            if (oceny == null) {
                obliczona_wariancja = "0.0";
            } else {
                obliczona_wariancja = Float.toString((float) statystyka.Wariancja(oceny));
            }


        }
        TextView wariancja_textview = (TextView) findViewById(R.id.obliczWariancje_textview);
        wariancja_textview.setText(obliczona_wariancja);

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

    private void openChart(){
        int[] x = { 0,1,2,3,4,5,6,7 };
//        int[] income = { 2000,2500,2700,3000,2800,3500,3700,3800};
        int[] income = { 2, 2, 2, 2, 2, 2, 2, 2 };
        int[] expense = {3, 4, 2, 5, 3, 1, 6, 3 };

        // Creating an  XYSeries for Income
        XYSeries incomeSeries = new XYSeries("Srednia");
        // Creating an  XYSeries for Expense
        XYSeries expenseSeries = new XYSeries("Oceny");
        // Adding data to Income and Expense Series
        for(int i=0;i<x.length;i++){
            incomeSeries.add(x[i], income[i]);
            expenseSeries.add(x[i],expense[i]);
        }

        // Creating a dataset to hold each series
        XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
        // Adding Income Series to the dataset
        dataset.addSeries(incomeSeries);
        // Adding Expense Series to dataset
        dataset.addSeries(expenseSeries);


        // Creating XYSeriesRenderer to customize incomeSeries
        XYSeriesRenderer incomeRenderer = new XYSeriesRenderer();
        incomeRenderer.setColor(Color.WHITE);
        incomeRenderer.setPointStyle(PointStyle.CIRCLE);
        incomeRenderer.setFillPoints(true);
        incomeRenderer.setLineWidth(2);
        incomeRenderer.setDisplayChartValues(true);


        // Creating XYSeriesRenderer to customize expenseSeries
        XYSeriesRenderer expenseRenderer = new XYSeriesRenderer();
        expenseRenderer.setColor(Color.YELLOW);
        expenseRenderer.setPointStyle(PointStyle.CIRCLE);
        expenseRenderer.setFillPoints(true);
        expenseRenderer.setLineWidth(2);
        expenseRenderer.setDisplayChartValues(true);



        // Creating a XYMultipleSeriesRenderer to customize the whole chart
        XYMultipleSeriesRenderer multiRenderer = new XYMultipleSeriesRenderer();
        multiRenderer.setXLabels(0);
        multiRenderer.setChartTitle("Income vs Expense Chart");
        multiRenderer.setXTitle("Year 2012");
        multiRenderer.setYTitle("Amount in Dollars");
        multiRenderer.setZoomButtonsVisible(true);
        multiRenderer.setBarSpacing(4);
        for(int i=0;i<x.length;i++){
            multiRenderer.addXTextLabel(i, mMonth[i]);
        }

        // Adding incomeRenderer and expenseRenderer to multipleRenderer
        // Note: The order of adding dataseries to dataset and renderers to multipleRenderer
        // should be same
        multiRenderer.addSeriesRenderer(incomeRenderer);
        multiRenderer.addSeriesRenderer(expenseRenderer);

        // Getting a reference to LinearLayout of the MainActivity Layout
        LinearLayout chartContainer = (LinearLayout) findViewById(R.id.wariancja_layout);


        // Specifying chart types to be drawn in the graph
        // Number of data series and number of types should be same
        // Order of data series and chart type will be same
        String[] types = new String[] { LineChart.TYPE, BarChart.TYPE };

        // Creating a combined chart with the chart types specified in types array
        mChart = (GraphicalView) ChartFactory.getCombinedXYChartView(getBaseContext(), dataset, multiRenderer, types);

        multiRenderer.setClickEnabled(true);
        multiRenderer.setSelectableBuffer(10);
        mChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SeriesSelection seriesSelection = mChart.getCurrentSeriesAndPoint();

                if (seriesSelection != null) {
                    int seriesIndex = seriesSelection.getSeriesIndex();
                    String selectedSeries="Income";
                    if(seriesIndex==0)
                        selectedSeries = "Income";
                    else
                        selectedSeries = "Expense";
                    // Getting the clicked Month
                    String month = mMonth[(int)seriesSelection.getXValue()];
                    // Getting the y value
                    int amount = (int) seriesSelection.getValue();
                    Toast.makeText(
                            getBaseContext(),
                            selectedSeries + " in " + month + " : " + amount,
                            Toast.LENGTH_SHORT).show();
                }
            }

        });

        // Adding the Combined Chart to the LinearLayout
        chartContainer.addView(mChart);
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