package WojtekSasiela.DziennikSzkolny;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Wojtek on 2015-03-08.
 */
public class EdytujUczniaActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edytujucznia_layout);

        Button zapisz = (Button) findViewById(R.id.zapisz_button_edytujucznia);
        zapisz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Dany zostały zmienione",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });


        zamknijOkno(R.id.zamknij_button_edytujucznia);

//        Button zamknij = (Button) findViewById(R.id.zamknij_button_edytujucznia);
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
