package WojtekSasiela.DziennikSzkolny;

import WojtekSasiela.DziennikSzkolny.ORM.configuration.DatabaseHelper;
import WojtekSasiela.DziennikSzkolny.ORM.tables.Account;
import WojtekSasiela.DziennikSzkolny.ORM.tables.Student;
import WojtekSasiela.DziennikSzkolny.ORM.tables.Teacher;
import WojtekSasiela.DziennikSzkolny.ORM.tables.miary_statystyczne.*;
import WojtekSasiela.DziennikSzkolny.ORM.tables.subjects.*;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.sql.SQLException;
import java.util.List;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    public static String TAG = "DziennikSzkolny";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        try {
            doAccountDataStuff();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Database databaseInstance = new Database(this,"Student.db",2);
        databaseInstance.db = openOrCreateDatabase("StudentDB.db", MODE_PRIVATE, null);
        databaseInstance.getAllData();

        //Pokaz_Activity(R.id.O_Autorze_Button, Intent.ACTION_VIEW, "http://www.google.pl");
        Pokaz_Activity_z_klasy(R.id.O_Autorze_Button, getApplicationContext(), OpcjeAcitivity.class);


        // Buttony przekierowywujace na konkretne Activity
        // laczy Vidok z Controllerem
        Pokaz_Activity_z_klasy(R.id.OpcjeButton, getApplicationContext(),OpcjeAcitivity.class);
        Pokaz_Activity_z_klasy(R.id.UczniowieButton, getApplicationContext(),ListaUczniowActivity.class);
        Pokaz_Activity_z_klasy(R.id.ZobaczStatyButton, getApplicationContext(), StatystykiActivity.class);
        Pokaz_Activity_z_klasy(R.id.ListaKlas_Button, getApplicationContext(), ListaKlasActivity.class);
        //BaseSQLite baseSQLite = BaseSQLite.getInstance(getApplicationContext());

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


    private void doAccountDataStuff() throws SQLException{

        // WYSYLASZ REKORDY DO BAZY DANYCH

        DatabaseHelper dbHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);

        RuntimeExceptionDao<Account, Integer> AccountDao = dbHelper.getAccountRuntimeExceptionDao();
        RuntimeExceptionDao<Student, Integer> StudentDao = dbHelper.getStudentRuntimeExceptionDao();
        RuntimeExceptionDao<Teacher, Integer> TeacherDao = dbHelper.getTeacherRuntimeExceptionDao();

        RuntimeExceptionDao<Biology, Integer> BiologyDao = dbHelper.getBiologyRuntimeExceptionDao();
        RuntimeExceptionDao<English, Integer> EnglishDao = dbHelper.getEnglishRuntimeExceptionDao();
        RuntimeExceptionDao<Mathematic, Integer> MathematicDao = dbHelper.getMathematicRuntimeExceptionDao();
        RuntimeExceptionDao<Polish, Integer> PolishDao = dbHelper.getPolishRuntimeExceptionDao();
        RuntimeExceptionDao<Religion, Integer> ReligionDao = dbHelper.getReligionRuntimeExceptionDao();
        RuntimeExceptionDao<WF, Integer> WFDao = dbHelper.getWFRuntimeExceptionDao();

        RuntimeExceptionDao<Srednia, Integer> SredniaDao = dbHelper.getSredniaRuntimeExceptionDao();
        RuntimeExceptionDao<Mediana, Integer> MedianaDao = dbHelper.getMedianaRuntimeExceptionDao();
        RuntimeExceptionDao<Dominanta, Integer> DominantaDao = dbHelper.getDominantaRuntimeExceptionDao();
        RuntimeExceptionDao<Kwartyle, Integer> KwartyleDao = dbHelper.getKwartyleRuntimeExceptionDao();
        RuntimeExceptionDao<Odchylenie, Integer> OdchylenieDao = dbHelper.getOdchylenieRuntimeExceptionDao();
        RuntimeExceptionDao<Wariancja, Integer> WariancjaDao = dbHelper.getWariancjaRuntimeExceptionDao();

        AccountDao.create(new Account("admin login1", "admin password1"));
        AccountDao.create(new Account("Uzytkownik", "Haslo"));
        AccountDao.create(new Account("root", "testABCD"));

        StudentDao.create(new Student("Wojtek", "Sasiela"));
        StudentDao.create(new Student("Anna", "Kowalska"));
        StudentDao.create(new Student("Joanna", "Pyrzyńska"));
        StudentDao.create(new Student("Izabela", "Tarnowska"));
        StudentDao.create(new Student("Blanka", "Szept"));
        StudentDao.create(new Student("Paweł", "Paluch"));
        StudentDao.create(new Student("Piotr", "Mały"));
        StudentDao.create(new Student("Karol", "Kopytko"));
        StudentDao.create(new Student("Arkadiusz", "Bąk"));
        StudentDao.create(new Student("Teresa", "Wawrzyniak"));
        StudentDao.create(new Student("Katarzyna", "Jagiełło"));

        TeacherDao.create(new Teacher("Jan", "Kowalski"));

        BiologyDao.create(new Biology(1,3,4,5));
        EnglishDao.create(new English(1,3,4,5));
        MathematicDao.create(new Mathematic(1, 3, 4, 5));
        PolishDao.create(new Polish(1, 3, 4, 5));
        ReligionDao.create(new Religion(1, 3, 4, 5));
        WFDao.create(new WF(1,3,4,5));

        SredniaDao.create(new Srednia(1,3,3,3));
        MedianaDao.create(new Mediana(1,3,3,3));
        DominantaDao.create(new Dominanta(1,3,3,3));
        WariancjaDao.create(new Wariancja(1,3,3,3));
        KwartyleDao.create(new Kwartyle(1, 3, 3, 3));
        OdchylenieDao.create(new Odchylenie(1, 3, 3, 3));


        /** Sprawdzenie czy dane poprawnie sie wyswietlaja **/

        List<Account> accounts = AccountDao.queryForEq("id", 1);
        Log.d("Account", accounts.toString());

        List<Student> students = StudentDao.queryForEq("id",1);
        Log.d("Student", students.toString());

        List<Teacher> teachers = TeacherDao.queryForEq("id",1);
        Log.d("Teacher", teachers.toString());

        List<Biology> biology_grades = BiologyDao.queryForEq("id",1);
        Log.d("Biology", biology_grades.toString());

        List<English> english_grades = EnglishDao.queryForEq("id",1);
        Log.d("English", english_grades.toString());

        List<Mathematic> mathematic_grades = MathematicDao.queryForEq("id",1);
        Log.d("Matgematic", mathematic_grades.toString());

        List<Polish> polish_grades = PolishDao.queryForEq("id",1);
        Log.d("Polish", polish_grades.toString());

        List<Religion> religion_grades = ReligionDao.queryForEq("id",1);
        Log.d("Religion", religion_grades.toString());

        List<WF> wf_grades = WFDao.queryForEq("id",1);
        Log.d("WF", wf_grades.toString());

        List<Srednia> srednia_dao = SredniaDao.queryForEq("id",1);
        Log.d("Srednia", srednia_dao.toString());

        List<Mediana> mediana_dao = MedianaDao.queryForEq("id",1);
        Log.d("Mediana", mediana_dao.toString());

        List<Dominanta> dominanta_dao = DominantaDao.queryForEq("id",1);
        Log.d("Dominanta", dominanta_dao.toString());

        List<Kwartyle> kwartyle_dao = KwartyleDao.queryForEq("id",1);
        Log.d("Kwartyle", kwartyle_dao.toString());

        List<Odchylenie> odchylenie_dao = OdchylenieDao.queryForEq("id",1);
        Log.d("Odchylenie", odchylenie_dao.toString());

        List<Wariancja> wariancjas_dao = WariancjaDao.queryForEq("id",1);
        Log.d("Wariancja", wariancjas_dao.toString());

        OpenHelperManager.releaseHelper();
    }



}
