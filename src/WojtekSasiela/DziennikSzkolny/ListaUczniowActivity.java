package WojtekSasiela.DziennikSzkolny;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Wojtek on 2014-11-23.
 */
public class ListaUczniowActivity extends Activity {


    TextView textViewName,textViewMarks, textViewText;
    SQLiteDatabase db;
    ListView list ;
    ArrayAdapter<String> adapter ;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uczniowie_layout);
        zamknijOkno(R.id.Zamknij_Uczniowie);
        wczytajdoListViewa();

        textViewName=(TextView)findViewById(R.id.textViewName);
        textViewMarks=(TextView)findViewById(R.id.textViewMarks);
        textViewText=(TextView)findViewById(R.id.textViewText);

        db=openOrCreateDatabase("StudentDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student(rollno VARCHAR,name VARCHAR,marks VARCHAR);");
        db.execSQL("INSERT INTO student VALUES('AAAAA','BBBBBB','CCCCCC');");

        Cursor c=db.rawQuery("SELECT * FROM student WHERE rollno='AAAAA'", null);
        if(c.moveToFirst())
        {
            //Sprawdzanie bazy SQLite
            // Szczegoly: http://www.codeproject.com/Articles/783073/A-Simple-Android-SQLite-Example
            textViewText.setText(c.getString(0));
            textViewName.setText(c.getString(1));
            textViewMarks.setText(c.getString(2));
        }
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


    public void wczytajdoListViewa()
    {

    }
}