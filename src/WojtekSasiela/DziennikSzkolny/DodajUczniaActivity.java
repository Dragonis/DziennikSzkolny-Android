package WojtekSasiela.DziennikSzkolny;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Wojtek on 2015-03-06.
 */
public class DodajUczniaActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_dodajucznia_layout);
        zamknijOkno(R.id.zamknij_button_dodaj);

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
