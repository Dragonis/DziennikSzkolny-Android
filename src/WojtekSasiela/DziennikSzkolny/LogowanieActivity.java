package WojtekSasiela.DziennikSzkolny;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static WojtekSasiela.DziennikSzkolny.R.id.zaloguj_button_logowanie;

/**
 * Created by Wojtek on 2015-03-18.
 */
public class LogowanieActivity extends Activity {

    Button zaloguj;
    Button zamknij;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logowanie_layout);


        zaloguj = (Button) findViewById(zaloguj_button_logowanie);
        zamknij = (Button) findViewById(R.id.zamknij_button_logowanie);

    zaloguj.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            Bundle koszyk = new Bundle();

            koszyk.putString("Login", "Jan");
            koszyk.putString("Password","Kowalski");
            intent.putExtras(koszyk);

            setResult(RESULT_OK, intent);
            startActivity(intent);
        }
    });

        zamknij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("EXIT", true);
                startActivity(intent);

                finish();
                System.exit(0);

            }
        });



    }

    public void Pokaz_Activity_z_klasy(int id, final Context context, final Class<?> klasa)
    {
        Button b = (Button)findViewById(id);
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
