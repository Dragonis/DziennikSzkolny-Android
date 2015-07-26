package WojtekSasiela.DziennikSzkolny;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainLobbyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    public static String TAG = "DziennikSzkolny";

    Button wyloguj;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        odbierzDanezPoprzedniegoActivity_iWyswietl();

        WyswietlButton_i_PrzelaczNaActivityzKlasy(R.id.OpcjeButton, getApplicationContext(), OpcjeAcitivity.class);
        WyswietlButton_i_PrzelaczNaActivityzKlasy(R.id.UczniowieButton, getApplicationContext(), OAutorzeActivity.class);
        WyswietlButton_i_PrzelaczNaActivityzKlasy(R.id.ZobaczStatyButton, getApplicationContext(), StatystykiActivity.class);
        WyswietlButton_i_PrzelaczNaActivityzKlasy(R.id.ListaKlas_Button, getApplicationContext(), ListaKlasActivity.class);

        wyloguj = (Button) findViewById(R.id.wyloguj_button);
        wyloguj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });

    }

    public void odbierzDanezPoprzedniegoActivity_iWyswietl() {
        Bundle przekazanedane = getIntent().getExtras();

        String imie = przekazanedane.getString("Imie");
        String nazwisko = przekazanedane.getString("Nazwisko");
        TextView imieinazwisko = (TextView) findViewById(R.id.textviewImieiNazwisko);
        imieinazwisko.setText(imie + " " + nazwisko);
    }

    public void WyswietlButton_i_PrzelaczNaActivityzKlasy(int id, final Context context, final Class<?> klasa) {
        Button b = (Button) findViewById(id);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, klasa);

                if (intent.resolveActivity(getPackageManager()) != null)
                    startActivity(intent);
                else {
                    Toast.makeText(getApplicationContext(), "Niestety, ale startActivityForResult wywala blad.",
                            Toast.LENGTH_LONG).show();
                }

            }
        });

    }

}
