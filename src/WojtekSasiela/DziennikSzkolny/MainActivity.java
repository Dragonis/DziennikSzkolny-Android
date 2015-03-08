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
            Toast.makeText(getApplicationContext(), "Nie mozna wprowadzic danych do BazyDanych",
                    Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }


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

        if (dbHelper.getReadableDatabase() == null){
            // wyswietla listeUczniow z bazy danych

        }else{
            //TODO Dodaje/Usuwa/Edytuje element(ucznia) do bazy danych
           // insert_Students_IntoDatabase(StudentDao);
//            List<Student> students = StudentDao.queryForEq("id",1);
//            Log.d("Student", students.toString());



//
//            /** Operacje INSERT **/
            insert_Accounts_IntoDatabase(AccountDao);
//
//            insert_Students_IntoDatabase(StudentDao);
//
//            insert_Teachers_IntoDatabase(TeacherDao);
//
//            insert_BIOLOGY_GradesIntoDatabase(BiologyDao);
//            insert_ENGLISH_GradesIntoDatabase(EnglishDao);
//            insert_MATHEMATIC_GradesIntoDatabase(MathematicDao);
//            insert_POLISH_GradesIntoDatabases(PolishDao);
//            insert_RELIGION_GradesIntoDatabase(ReligionDao);
//            insert_WF_GradesIntoDatabase(WFDao);
//
//            SredniaDao.create(new Srednia(1,3,3,3));
//            MedianaDao.create(new Mediana(1,3,3,3));
//            DominantaDao.create(new Dominanta(1,3,3,3));
//            WariancjaDao.create(new Wariancja(1,3,3,3));
//            KwartyleDao.create(new Kwartyle(1, 3, 3, 3));
//            OdchylenieDao.create(new Odchylenie(1, 3, 3, 3));
//
//
//            /** Sprawdzenie czy dane poprawnie sie wyswietlaja **/
//
            List<Account> accounts = AccountDao.queryForEq("id", 1);
            Log.d("Account", accounts.toString());
//
//            List<Student> students = StudentDao.queryForEq("id",1);
//            Log.d("Student", students.toString());
//
//            List<Teacher> teachers = TeacherDao.queryForEq("id",1);
//            Log.d("Teacher", teachers.toString());
//
//            List<Biology> biology_grades = BiologyDao.queryForEq("id",1);
//            Log.d("Biology", biology_grades.toString());
//
//            List<English> english_grades = EnglishDao.queryForEq("id",1);
//            Log.d("English", english_grades.toString());
//
//            List<Mathematic> mathematic_grades = MathematicDao.queryForEq("id",1);
//            Log.d("Matgematic", mathematic_grades.toString());
//
//            List<Polish> polish_grades = PolishDao.queryForEq("id",1);
//            Log.d("Polish", polish_grades.toString());
//
//            List<Religion> religion_grades = ReligionDao.queryForEq("id",1);
//            Log.d("Religion", religion_grades.toString());
//
//            List<WF> wf_grades = WFDao.queryForEq("id",1);
//            Log.d("WF", wf_grades.toString());
//
//            List<Srednia> srednia_dao = SredniaDao.queryForEq("id",1);
//            Log.d("Srednia", srednia_dao.toString());
//
//            List<Mediana> mediana_dao = MedianaDao.queryForEq("id",1);
//            Log.d("Mediana", mediana_dao.toString());
//
//            List<Dominanta> dominanta_dao = DominantaDao.queryForEq("id",1);
//            Log.d("Dominanta", dominanta_dao.toString());
//
//            List<Kwartyle> kwartyle_dao = KwartyleDao.queryForEq("id",1);
//            Log.d("Kwartyle", kwartyle_dao.toString());
//
//            List<Odchylenie> odchylenie_dao = OdchylenieDao.queryForEq("id",1);
//            Log.d("Odchylenie", odchylenie_dao.toString());
//
//            List<Wariancja> wariancjas_dao = WariancjaDao.queryForEq("id",1);
//            Log.d("Wariancja", wariancjas_dao.toString());
        }


        OpenHelperManager.releaseHelper();
    }

    private void insert_Teachers_IntoDatabase(RuntimeExceptionDao<Teacher, Integer> teacherDao) {
        teacherDao.create(new Teacher("Jan", "Kowalski"));
    }

    private void insert_WF_GradesIntoDatabase(RuntimeExceptionDao<WF, Integer> WFDao) {
        WFDao.create(new WF(1,3,4,5));
    }

    private void insert_RELIGION_GradesIntoDatabase(RuntimeExceptionDao<Religion, Integer> religionDao) {
        religionDao.create(new Religion(1, 3, 4, 5));
    }

    private void insert_POLISH_GradesIntoDatabases(RuntimeExceptionDao<Polish, Integer> polishDao) {
        polishDao.create(new Polish(1, 3, 4, 5));
    }

    private void insert_MATHEMATIC_GradesIntoDatabase(RuntimeExceptionDao<Mathematic, Integer> mathematicDao) {
        mathematicDao.create(new Mathematic(1, 3, 4, 5));
    }

    private void insert_ENGLISH_GradesIntoDatabase(RuntimeExceptionDao<English, Integer> englishDao) {
        englishDao.create(new English(1,3,4,5));
    }

    private void insert_BIOLOGY_GradesIntoDatabase(RuntimeExceptionDao<Biology, Integer> biologyDao) {
        biologyDao.create(new Biology(1,3,4,5));
    }

    public void insert_Students_IntoDatabase(RuntimeExceptionDao<Student, Integer> studentDao) {
        studentDao.create(new Student("Wojtek", "Sasiela",1));
        studentDao.create(new Student("Anna", "Kowalska",1));
        studentDao.create(new Student("Joanna", "Pyrzyńska",1));
        studentDao.create(new Student("Izabela", "Tarnowska",1));
        studentDao.create(new Student("Blanka", "Szept",1));
        studentDao.create(new Student("Paweł", "Paluch",1));
        studentDao.create(new Student("Piotr", "Mały",1));
        studentDao.create(new Student("Karol", "Kopytko",1));
        studentDao.create(new Student("Arkadiusz", "Bąk",1));
        studentDao.create(new Student("Teresa", "Wawrzyniak",1));
        studentDao.create(new Student("Katarzyna", "Jagiełło",1));

        studentDao.create(new Student("111", "111",2));
        studentDao.create(new Student("222", "222",2));
        studentDao.create(new Student("333", "333",2));
//        studentDao.create(new Student("333", "333",2));
//        studentDao.create(new Student("4444", "444",2));
//        studentDao.create(new Student("555", "555",2));
//        studentDao.create(new Student("666", "666",2));
//        studentDao.create(new Student("777", "777",2));
//        studentDao.create(new Student("888", "888",2));
//        studentDao.create(new Student("999", "999",2));

        studentDao.create(new Student("AAA", "AAA",3));
        studentDao.create(new Student("BBB", "BBB",3));
        studentDao.create(new Student("CCC", "CCC",3));
        studentDao.create(new Student("DDD", "DDD",3));
        studentDao.create(new Student("EEE", "EEE",3));
//        studentDao.create(new Student("FFF", "FFF",3));
//        studentDao.create(new Student("GGG", "GGG",3));
//        studentDao.create(new Student("HHH", "HHH",3));
//        studentDao.create(new Student("III", "III",3));
//        studentDao.create(new Student("JJJ", "JJJ",3));

        studentDao.create(new Student("4", "klasa",4));
//        studentDao.create(new Student("czwarta", "test",4));
//        studentDao.create(new Student("IV", "test2",4));
//        studentDao.create(new Student("qqq", "qqq",4));
//        studentDao.create(new Student("www", "www",4));
//        studentDao.create(new Student("eee", "eee",4));

        studentDao.create(new Student("V", "abc",5));
        studentDao.create(new Student("5", "z",5));
//        studentDao.create(new Student("piata", "y",5));
//        studentDao.create(new Student("aaa", "aaa",5));
//        studentDao.create(new Student("sss", "sss",5));
//        studentDao.create(new Student("dddd", "ddd",5));

        studentDao.create(new Student("VI", "numera",6));
        studentDao.create(new Student("6", "dzwiek",6));
        studentDao.create(new Student("szosta", "woda",6));
        studentDao.create(new Student("ppp", "ppp",6));
        studentDao.create(new Student("ccc", "ccc",6));
        studentDao.create(new Student("nnn", "nnn",6));
    }

    public void insert_Accounts_IntoDatabase(RuntimeExceptionDao<Account, Integer> accountDao) {
        accountDao.create(new Account("admin login1", "admin password1"));
        accountDao.create(new Account("Uzytkownik", "Haslo"));
        accountDao.create(new Account("root", "testABCD"));
    }


}
