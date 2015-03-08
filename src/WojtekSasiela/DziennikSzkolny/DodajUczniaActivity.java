package WojtekSasiela.DziennikSzkolny;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Wojtek on 2015-03-08.
 */
public class DodajUczniaActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dodajucznia_layout);

        Button zapisz = (Button) findViewById(R.id.zapisz_button_dodajucznia);
        zapisz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO DOdanie uzytkownika do bazy danych

                Toast.makeText(getApplicationContext(), "Użytkownik został zapisany",
                        Toast.LENGTH_SHORT).show();
            finish();
            }
        });

    zamknijOkno(R.id.zamknij_button_dodajucznia);


//        Button zamknij = (Button) findViewById(R.id.zamknij_button_dodajucznia);
//        zamknij.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//            }
//        });
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
