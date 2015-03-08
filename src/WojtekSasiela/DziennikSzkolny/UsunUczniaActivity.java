package WojtekSasiela.DziennikSzkolny;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Wojtek on 2015-03-06.
 */
public class UsunUczniaActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragmnt_usunucznia_layout);
        zamknijOkno(R.id.zapiszucznia_button_usunucznia);
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
