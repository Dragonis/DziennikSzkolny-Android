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
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by Wojtek on 2015-03-10.
 */
public class DodajOceneActivity extends Activity {

    String date;
    String grade;
    private EditText grade_edittext;
    private EditText date_editext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dodajocene_layout);
        Calendar calendar = Calendar.getInstance();


        grade_edittext = (EditText) findViewById(R.id.ocena_edittext_dodajocene);
        date_editext = (EditText) findViewById(R.id.data_edittext_dodajocene);
        date_editext.setText(String.valueOf(calendar.get(Calendar.DATE) + "." + String.valueOf(calendar.get(Calendar.MONTH)) ));
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
                przeslijDaneDoWczesniejszegoActivity(date, grade);
            }
        });

    }


    public void przeslijDaneDoWczesniejszegoActivity(String date, String grade) {

        Bundle koszyk = new Bundle();
        koszyk.putString("date", date);
        koszyk.putString("grade", grade);
        Intent cel = new Intent(this, DaneUczniaActivity.class);
        cel.putExtras(koszyk);
        startActivity(cel);
    }


}
