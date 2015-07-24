package WojtekSasiela.DziennikSzkolny.ORM.CRUD.READ;

import WojtekSasiela.DziennikSzkolny.ORM.configuration.DatabaseAccessObjects;
import WojtekSasiela.DziennikSzkolny.ORM.tables.Account;
import WojtekSasiela.DziennikSzkolny.ORM.tables.Student;
import WojtekSasiela.DziennikSzkolny.ORM.tables.new_version_database.Ocena;
import WojtekSasiela.DziennikSzkolny.ORM.tables.new_version_database.Przedmiot;
import android.content.Context;
import android.util.Log;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wojtek on 2015-07-04.
 */
public class LoadDataFromDatabase {

    public static List<Account> load_Account_fromDatabase(String username)
    {
        // Connect with Database ORM
        DatabaseAccessObjects dbHelper = OpenHelperManager.getHelper(null, DatabaseAccessObjects.class);
        RuntimeExceptionDao<Account, Integer> Account_Dao = dbHelper.getAccountRuntimeExceptionDao();
        //TODO sprawdzanie czy dane logowania sa poprawne
        List<Account> accounts = Account_Dao.queryForEq("username", username);
        return accounts;
    }

    public static List<Account> load_Account_fromDatabase(int id)
    {
        // Connect with Database ORM
        DatabaseAccessObjects dbHelper = OpenHelperManager.getHelper(null, DatabaseAccessObjects.class);
        RuntimeExceptionDao<Account, Integer> Account_Dao = dbHelper.getAccountRuntimeExceptionDao();
        //TODO sprawdzanie czy dane logowania sa poprawne
        List<Account> accounts = Account_Dao.queryForEq("id", id);
        return accounts;
    }

    public static Student load_Student_fromDatabase(String imie_studenta, String surname)
    {
        // Connect with Database ORM
        DatabaseAccessObjects dbHelper = OpenHelperManager.getHelper(null, DatabaseAccessObjects.class);
        RuntimeExceptionDao<Student, Integer> Student_Dao = dbHelper.getStudentRuntimeExceptionDao();
        //TODO sprawdzanie czy dane logowania sa poprawne
        Student student = null;
        try {
            student = Student_Dao.queryBuilder().where().eq("name",imie_studenta).and().eq("surname",surname).queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public static List<Student> load_Student_fromDatabase(int id)
    {
        // Connect with Database ORM
        DatabaseAccessObjects dbHelper = OpenHelperManager.getHelper(null, DatabaseAccessObjects.class);
        RuntimeExceptionDao<Student, Integer> Student_Dao = dbHelper.getStudentRuntimeExceptionDao();
        //TODO sprawdzanie czy dane logowania sa poprawne
        List<Student> students = Student_Dao.queryForEq("id", id);
        Log.e("AccountTableDB", students.get(0).getName());
        Log.e("AccountTableDB", students.get(0).getSurname());
        return students;
    }


    public static List<Student> load_all_Students_fromDatabase(Context context)
    {
        // Connect with Database ORM
        DatabaseAccessObjects dbHelper = OpenHelperManager.getHelper(context, DatabaseAccessObjects.class);
        RuntimeExceptionDao<Student, Integer> Student_Dao = dbHelper.getStudentRuntimeExceptionDao();
        //TODO sprawdzanie czy dane logowania sa poprawne
        List<Student> students = Student_Dao.queryForAll();
        //Log.e("AccountTableDB", students.get(0).getName());
        //Log.e("AccountTableDB", students.get(0).getSurname());
        return students;
    }



    public static ArrayList<String> load_New_Version_StudentGrades(int id_ucznia,int id_przedmiotu)
    {
        ArrayList<String> oceny = new ArrayList<String>();
        List<Ocena> ocenaList = null;
        // Connect with Database ORM
        DatabaseAccessObjects dbHelper = OpenHelperManager.getHelper(null, DatabaseAccessObjects.class);
        RuntimeExceptionDao<Ocena, Integer> Ocena_Dao = dbHelper.getOcenaRuntimeExceptionDao();
        //TODO sprawdzanie czy dane logowania sa poprawne
        try {
            ocenaList = Ocena_Dao.queryBuilder().selectColumns("ocena").where().eq("id_ucznia", id_ucznia + 1).and().eq("id_przedmiotu",id_przedmiotu).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for(Ocena sg : ocenaList)
        {
            oceny.add(Integer.toString(sg.getOcena()));
        }
        return oceny;
    }

    public static ArrayList<String> load_New_Version_StudentDates(int id_ucznia,int id_przedmiotu)
    {
        ArrayList<String> daty = new ArrayList<String>();
        // Connect with Database ORM
        DatabaseAccessObjects dbHelper = OpenHelperManager.getHelper(null, DatabaseAccessObjects.class);
        RuntimeExceptionDao<Ocena, Integer> datyDao = dbHelper.getOcenaRuntimeExceptionDao();
        //TODO sprawdzanie czy dane logowania sa poprawne
        List<Ocena> datyList = null;
        try {
            datyList = datyDao.queryBuilder().selectColumns("Data").where().eq("id_ucznia",id_ucznia).and().eq("id_przedmiotu",id_przedmiotu).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(Ocena sg : datyList)
        {
            daty.add(sg.getData());
        }
        return daty;
    }

    public static ArrayList<String> loadStudentGradesForAllClasses_New_Version(float nr_klasy,String nazwa_przedmiotu)
    {
        ArrayList<String> oceny = new ArrayList<String>();
        List<Ocena> listaOcen = new ArrayList<Ocena>();

        DatabaseAccessObjects dbHelper = OpenHelperManager.getHelper(null, DatabaseAccessObjects.class);
        RuntimeExceptionDao<Ocena, Integer> Ocena_Dao = dbHelper.getOcenaRuntimeExceptionDao();
        RuntimeExceptionDao<Przedmiot, Integer> Przedmiot_Dao = dbHelper.getPrzedmiotRuntimeExceptionDao();
//        RuntimeExceptionDao<Przedmiot, Integer> Przedmiot_Dao = dbHelper.getPrzedmiotRuntimeExceptionDao();
//        RuntimeExceptionDao<Uczen, Integer> Uczen_Dao = dbHelper.getUczenRuntimeExceptionDao();

        try {
//            listaOcen = Ocena_Dao.queryForAll();
//            listaPrzedmiotow = Przedmiot_Dao.queryForAll();
//            listaUczniow = Uczen_Dao.queryForAll();


//            listaOcen = Ocena_Dao.queryBuilder().selectColumns("Grade").where().eq("nazwa",nazwa_przedmiotu).and().eq("klasa",nr_klasy).query();
            int id_przedmiotu = Przedmiot_Dao.queryBuilder().selectColumns("id_przedmiotu").where().eq("nazwa",nazwa_przedmiotu).query().get(0).getId_przedmiotu();
            listaOcen = Ocena_Dao.queryBuilder().selectColumns("ocena").where().eq("id_przedmiotu",id_przedmiotu).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        for(Ocena ocena : listaOcen)
        {
            oceny.add(ocena.getOcena().toString());
        }

        return oceny;
    }
}
