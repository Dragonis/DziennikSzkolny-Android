package sasiela.wojtek.dziennikszkolny;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Wojtek on 2015-03-10.
 */
public class DodajOceneActivity extends Activity {


    DatePicker dp;
    Calendar c;
    int year;
    int month;
    int day;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dodajocene_layout);

        initialize();

        dp.init(year, month, day, null);
        day = dp.getDayOfMonth();
        month = dp.getMonth();
        year = dp.getYear();

        zamknijOkno(R.id.zamknij_dodajocene_button);

        Toast.makeText(DodajOceneActivity.this, day + " " + month + " " + year, Toast.LENGTH_SHORT).show();

    }

    public void initialize() {
        c = Calendar.getInstance();
        dp = (DatePicker) findViewById(R.id.datePicker);
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
    }


    public void zamknijOkno(int id) {
        Button b = (Button) findViewById(id);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                przeslijDaneDoWczesniejszegoActivity(day, month, year);
            }
        });

    }


    public void przeslijDaneDoWczesniejszegoActivity(int day, int month, int year) {

        Bundle koszyk = new Bundle();
        koszyk.putInt("day", day);
        koszyk.putInt("month", month);
        koszyk.putInt("year", year);
        koszyk.putInt("grade", 5);
        Intent cel = new Intent(this, DaneUczniaActivity.class);
        cel.putExtras(koszyk);
        startActivity(cel);
    }


}
