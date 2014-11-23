package WojtekSasiela.DziennikSzkolny;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        //Pokaz_Activity(R.id.O_Autorze_Button, Intent.ACTION_VIEW, "http://www.google.pl");
        Pokaz_Activity_z_klasy(R.id.O_Autorze_Button, getApplicationContext(), OpcjeAcitivity.class);


        // Buttony przekierowywujace na konkretne Activity
        // laczy Vidok z Controllerem
        Pokaz_Activity_z_klasy(R.id.OpcjeButton, getApplicationContext(),OpcjeAcitivity.class);
        Pokaz_Activity_z_klasy(R.id.UczniowieButton, getApplicationContext(),ListaUczniowActivity.class);
        Pokaz_Activity_z_klasy(R.id.ZobaczStatyButton, getApplicationContext(), StatystykiActivity.class);

    }

    public void Pokaz_Activity(int id, final String destinity, final String url)
    {
        Button b = (Button)findViewById(id);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                intent = new Intent(destinity, Uri.parse(url));

                if(intent.resolveActivity(getPackageManager()) != null)
                    startActivity(intent);
                else
                {
                    Toast.makeText(getApplicationContext(), "Niestety, ale startActivityForResult wywala blad.",
                            Toast.LENGTH_LONG).show();
                }

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
