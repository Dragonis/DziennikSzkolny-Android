package WojtekSasiela.DziennikSzkolny;

import WojtekSasiela.DziennikSzkolny.ORM.configuration.DatabaseHelper;
import WojtekSasiela.DziennikSzkolny.ORM.tables.Student;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Wojtek on 2014-12-09.
 */
public class ListaKlasActivity extends Activity {

    private ArrayAdapter<String> adapter = null;
    private ArrayAdapter<String> adapterSubcjets = null;
    private ListView listaKompoment = null;
    private ListView listaKompoment2 = null;
    private Button klasa1 = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_klas_layout);

        listaKompoment = (ListView) findViewById(R.id.listView);
        listaKompoment2 = (ListView) findViewById(R.id.listView0);
        klasa1 = (Button) findViewById(R.id.klasa1);

        // Connect with Database ORM
        DatabaseHelper dbHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
        RuntimeExceptionDao<Student, Integer> studentDao = dbHelper.getStudentRuntimeExceptionDao();
        List<Student> students = studentDao.queryForAll();
        String cars[] =
                {
                        students.get(0).getName()  +  " " + students.get(0).getSurname() ,
                        students.get(1).getName()  +  " " + students.get(1).getSurname() ,
                        students.get(2).getName()  +  " " + students.get(2).getSurname() ,
                        students.get(3).getName()  +  " " + students.get(3).getSurname() ,
                        students.get(4).getName()  +  " " + students.get(4).getSurname() ,
                        students.get(5).getName()  +  " " + students.get(5).getSurname() ,
                        students.get(6).getName()  +  " " + students.get(6).getSurname() ,
                        students.get(7).getName()  +  " " + students.get(7).getSurname() ,
                        students.get(8).getName()  +  " " + students.get(8).getSurname() ,
                        students.get(9).getName()  +  " " + students.get(9).getSurname() ,
                };
        //String cars[] = {"Ania Kowalska", "Joasia Pyrzyńska", "Izabela Tarnowska", "Blanka Szept", "Paweł Paluch", "Piotrek Mały", "Karol Kopytko", "Arkadiusz Bąk", "Teresa Wawrzyniak"};
        String subjects[] = {"Polski", "Angielski", "Matematyka", "Przyroda", "Religia", "WF"};
        ArrayList<String> carL = new ArrayList<String>();
        ArrayList<String> subjectsL = new ArrayList<String>();
        carL.addAll( Arrays.asList(cars) );
        subjectsL.addAll( Arrays.asList(subjects) );
        adapter = new ArrayAdapter<String>(this, R.layout.elementy_listy_glownej, carL);
        adapterSubcjets = new ArrayAdapter<String>(this, R.layout.elementy_listy_glownej, subjectsL );
        listaKompoment.setAdapter(adapter);
        listaKompoment2.setAdapter(adapterSubcjets);

        klasa1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view.setBackgroundColor(Color.BLUE);
            }
        });

        listaKompoment.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                for (int j = 0; j < adapterView.getChildCount(); j++)
                    adapterView.getChildAt(j).setBackgroundColor(Color.TRANSPARENT);

                // change the background color of the selected element
                view.setBackgroundColor(Color.BLUE);
            }
        });

        listaKompoment2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                for (int j = 0; j < adapterView.getChildCount(); j++)
                    adapterView.getChildAt(j).setBackgroundColor(Color.TRANSPARENT);

                // change the background color of the selected element
                view.setBackgroundColor(Color.BLUE);

                        Intent intent = new Intent(getApplicationContext(), DaneUczniaActivity.class);

                        if (intent.resolveActivity(getPackageManager()) != null)
                            startActivity(intent);
                        else {
                            Toast.makeText(getApplicationContext(), "Niestety, ale startActivityForResult wywala blad.",
                                    Toast.LENGTH_LONG).show();
                        }


            }
        });
        zamknijOkno(R.id.Wyjdz_button);

        Toast.makeText(getApplicationContext(), "Pokaz liste klas", Toast.LENGTH_LONG).show();
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