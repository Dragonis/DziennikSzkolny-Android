package sasiela.wojtek.dziennikszkolny;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.Calendar;

import sasiela.wojtek.dziennikszkolny.ORM.CRUD.CREATE.InsertDataToDatabase;
import sasiela.wojtek.dziennikszkolny.ORM.configuration.DatabaseAccessObjects;
import sasiela.wojtek.dziennikszkolny.ORM.tables.new_version_database.Ocena;

/**
 * Created by Wojtek on 2015-03-10.
 */
public class DodajOceneActivity extends Activity {

    private String date;
    private String grade;
    private EditText grade_edittext;
    private EditText date_editext;
    private String Imie;
    private String Nazwisko;
    private String nrKlasy;
    private String przedmiot;

    private TextView ImieNazwiskoTextView;
    private TextView NrKlasyTextView;
    private TextView PrzedmiotTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dodajocene_layout);
        Calendar calendar = Calendar.getInstance();

        ImieNazwiskoTextView = (TextView) findViewById(R.id.imieNazwisko_textview_dodajocene);
        NrKlasyTextView = (TextView) findViewById(R.id.klasa_textview_dodajocene);
        PrzedmiotTextView = (TextView) findViewById(R.id.przedmiot_textview_dodajocene);

        grade_edittext = (EditText) findViewById(R.id.ocena_edittext_dodajocene);
        date_editext = (EditText) findViewById(R.id.data_edittext_dodajocene);
        date_editext.setText(String.valueOf(calendar.get(Calendar.DATE) + "." + String.valueOf(calendar.get(Calendar.MONTH))));

        pobierzDanezPoprzedniegoActivity();

        ImieNazwiskoTextView.setText(Imie + " " + Nazwisko);
        NrKlasyTextView.setText(nrKlasy);
        PrzedmiotTextView.setText(przedmiot);

        zamknijOkno(R.id.zamknij_dodajocene_button);

    }




    public void zamknijOkno(int id) {
        Button b = (Button) findViewById(id);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                date = date_editext.getText().toString();
                grade = grade_edittext.getText().toString();
                InsertDataToDatabase.dodajOceneIDateUczniowioDanymImieniuiNazwisku(Imie,Nazwisko,przedmiot,Integer.parseInt(grade),date);
                przeslijDaneDoWczesniejszegoActivity(date, grade);
            }
        });

    }
    public void pobierzDanezPoprzedniegoActivity() {
        // dane pochodza z ListaKlasActivity
        Bundle przekazanedane = getIntent().getExtras();

        Imie = przekazanedane.getString("Imie");
        Nazwisko = przekazanedane.getString("Nazwisko");
        nrKlasy = przekazanedane.getString("Klasa");
        przedmiot = przekazanedane.getString("Przedmiot");

        grade = przekazanedane.getString("grade");
        date = przekazanedane.getString("date");


    }

    public void przeslijDaneDoWczesniejszegoActivity(String date, String grade) {

        Bundle koszyk = new Bundle();
        koszyk.putString("date", date);
        koszyk.putString("grade", grade);
        koszyk.putString("Imie", Imie );
        koszyk.putString("Nazwisko", Nazwisko);
        koszyk.putString("Klasa", nrKlasy);
        koszyk.putString("Przedmiot", przedmiot);
        Intent cel = new Intent(this, DaneUczniaActivity.class);
        cel.putExtras(koszyk);
        Toast.makeText(getApplicationContext(), "Data: " + date + " " + ",Ocena: " + grade, Toast.LENGTH_SHORT).show();
        startActivity(cel);
    }


}
