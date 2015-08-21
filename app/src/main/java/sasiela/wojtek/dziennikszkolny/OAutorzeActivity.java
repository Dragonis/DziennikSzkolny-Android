package sasiela.wojtek.dziennikszkolny;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Wojtek on 2014-11-23.
 */
public class OAutorzeActivity extends Activity {


    private TextView autor_textview;
    private TextView tematpracy_textview;
    private TextView promotor_textview;
    private TextView uczelnia_textview;
    private TextView wydzial_textview;
    private TextView kierunek_textview;
    private Button b;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oautorze_layout);
        zamknijOkno(R.id.Zamknij_Uczniowie);

        autor_textview = (TextView) findViewById(R.id.autor_textview);
        tematpracy_textview = (TextView) findViewById(R.id.tematpracy_textview);
        promotor_textview = (TextView) findViewById(R.id.promotor_textview);
        uczelnia_textview = (TextView) findViewById(R.id.uczelnia_textview);
        wydzial_textview = (TextView) findViewById(R.id.wydzial_textview);
        kierunek_textview = (TextView) findViewById(R.id.kierunek_textview);

        autor_textview.setText(R.string.AutorProgramu);
        tematpracy_textview.setText(R.string.TematPracyMagisterskiej);
        promotor_textview.setText(R.string.Promitor);
        uczelnia_textview.setText(R.string.Uczelnia);
        wydzial_textview.setText(R.string.Wydział);
        kierunek_textview.setText(R.string.Kierunek);

    }

    public void zamknijOkno(int id) {
        b = (Button) findViewById(id);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}