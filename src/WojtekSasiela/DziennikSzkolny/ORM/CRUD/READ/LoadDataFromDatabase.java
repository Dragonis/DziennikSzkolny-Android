package WojtekSasiela.DziennikSzkolny.ORM.CRUD.READ;

import WojtekSasiela.DziennikSzkolny.ORM.configuration.DatabaseAccessObjects;
import WojtekSasiela.DziennikSzkolny.ORM.tables.Account;
import WojtekSasiela.DziennikSzkolny.ORM.tables.Student;
import WojtekSasiela.DziennikSzkolny.ORM.tables.new_version_database.*;
import android.content.Context;
import android.util.Log;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.dao.GenericRawResults;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wojtek on 2015-07-04.
 */
public class LoadDataFromDatabase {

    public static List<Account> load_Account_fromDatabase(String username) {
        // Connect with Database ORM
        DatabaseAccessObjects dbHelper = OpenHelperManager.getHelper(null, DatabaseAccessObjects.class);
        RuntimeExceptionDao<Account, Integer> Account_Dao = dbHelper.getAccountRuntimeExceptionDao();
        //TODO sprawdzanie czy dane logowania sa poprawne
        List<Account> accounts = Account_Dao.queryForEq("username", username);
        return accounts;
    }

    public static List<Account> load_Account_fromDatabase(int id) {
        // Connect with Database ORM
        DatabaseAccessObjects dbHelper = OpenHelperManager.getHelper(null, DatabaseAccessObjects.class);
        RuntimeExceptionDao<Account, Integer> Account_Dao = dbHelper.getAccountRuntimeExceptionDao();
        //TODO sprawdzanie czy dane logowania sa poprawne
        List<Account> accounts = Account_Dao.queryForEq("id", id);
        return accounts;
    }

    public static Student load_Student_fromDatabase(String imie_studenta, String surname) {
        // Connect with Database ORM
        DatabaseAccessObjects dbHelper = OpenHelperManager.getHelper(null, DatabaseAccessObjects.class);
        RuntimeExceptionDao<Student, Integer> Student_Dao = dbHelper.getStudentRuntimeExceptionDao();
        //TODO sprawdzanie czy dane logowania sa poprawne
        Student student = null;
        try {
            student = Student_Dao.queryBuilder().where().eq("name", imie_studenta).and().eq("surname", surname).queryForFirst();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    public static List<Student> load_Student_fromDatabase(int id) {
        // Connect with Database ORM
        DatabaseAccessObjects dbHelper = OpenHelperManager.getHelper(null, DatabaseAccessObjects.class);
        RuntimeExceptionDao<Student, Integer> Student_Dao = dbHelper.getStudentRuntimeExceptionDao();
        //TODO sprawdzanie czy dane logowania sa poprawne
        List<Student> students = Student_Dao.queryForEq("id", id);
        Log.e("AccountTableDB", students.get(0).getName());
        Log.e("AccountTableDB", students.get(0).getSurname());
        return students;
    }


    public static List<Student> load_all_Students_fromDatabase(Context context) {
        // Connect with Database ORM
        DatabaseAccessObjects dbHelper = OpenHelperManager.getHelper(context, DatabaseAccessObjects.class);
        RuntimeExceptionDao<Student, Integer> Student_Dao = dbHelper.getStudentRuntimeExceptionDao();
        //TODO sprawdzanie czy dane logowania sa poprawne
        List<Student> students = Student_Dao.queryForAll();
        //Log.e("AccountTableDB", students.get(0).getName());
        //Log.e("AccountTableDB", students.get(0).getSurname());
        return students;
    }


    public static ArrayList<String> load_New_Version_StudentGrades(int id_ucznia, int id_przedmiotu) {
        ArrayList<String> oceny = new ArrayList<String>();
        List<Ocena> ocenaList = null;
        // Connect with Database ORM
        DatabaseAccessObjects dbHelper = OpenHelperManager.getHelper(null, DatabaseAccessObjects.class);
        RuntimeExceptionDao<Ocena, Integer> Ocena_Dao = dbHelper.getOcenaRuntimeExceptionDao();
        //TODO sprawdzanie czy dane logowania sa poprawne
        try {
            ocenaList = Ocena_Dao.queryBuilder().selectColumns("ocena").where().eq("id_ucznia", id_ucznia + 1).and().eq("id_przedmiotu", id_przedmiotu).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Ocena sg : ocenaList) {
            oceny.add(Integer.toString(sg.getOcena()));
        }
        return oceny;
    }

    public static ArrayList<String> load_New_Version_StudentDates(int id_ucznia, int id_przedmiotu) {
        ArrayList<String> daty = new ArrayList<String>();
        // Connect with Database ORM
        DatabaseAccessObjects dbHelper = OpenHelperManager.getHelper(null, DatabaseAccessObjects.class);
        RuntimeExceptionDao<Ocena, Integer> datyDao = dbHelper.getOcenaRuntimeExceptionDao();
        //TODO sprawdzanie czy dane logowania sa poprawne
        List<Ocena> datyList = null;
        try {
            datyList = datyDao.queryBuilder().selectColumns("Data").where().eq("id_ucznia", id_ucznia).and().eq("id_przedmiotu", id_przedmiotu).query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Ocena sg : datyList) {
            daty.add(sg.getData());
        }
        return daty;
    }

    public static ArrayList<String> loadStudentGradesForAllClasses_New_Version(float nr_klasy, String nazwa_przedmiotu) {
        ArrayList<String> oceny = new ArrayList<String>();
        List<Ocena> listaOcen = new ArrayList<Ocena>();

        DatabaseAccessObjects dbHelper = OpenHelperManager.getHelper(null, DatabaseAccessObjects.class);
        RuntimeExceptionDao<Ocena, Integer> Ocena_Dao = dbHelper.getOcenaRuntimeExceptionDao();
        RuntimeExceptionDao<Przedmiot, Integer> Przedmiot_Dao = dbHelper.getPrzedmiotRuntimeExceptionDao();
        RuntimeExceptionDao<Uczen, Integer> Uczen_Dao = dbHelper.getUczenRuntimeExceptionDao();

        try {
//            listaOcen = Ocena_Dao.queryBuilder().selectColumns("Grade").where().eq("nazwa",nazwa_przedmiotu).and().eq("klasa",nr_klasy).query();

            //  Wyswietl wszystkie oceny z matematyki w klasie 4;
            //  select o.oceny from ocena o
            //  join przedmiot p on o.id_przedmiotu = p.id_przedmiotu
            //  join uczen u on o.id_ucznia = u.id_ucznia
            //  where u.klasa = 4 and p.nazwa = 'matematyka';

            QueryBuilder<Przedmiot, Integer> przedmiotQb = Przedmiot_Dao.queryBuilder();
            QueryBuilder<Uczen, Integer> uczenQb = Uczen_Dao.queryBuilder();
            QueryBuilder<Ocena, Integer> ocenaQb = Ocena_Dao.queryBuilder();
            przedmiotQb.join(uczenQb);
            ocenaQb.where().eq("klasa", nr_klasy).and().eq("nazwa", nazwa_przedmiotu);
            ocenaQb.join(przedmiotQb);
            listaOcen = ocenaQb.query();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        for (Ocena ocena : listaOcen) {
            oceny.add(ocena.getOcena().toString());
        }

        return oceny;
    }

    public static List<Uczen> load_Konto_NewVersion_fromDatabase(String username, String password) {
        DatabaseAccessObjects dbHelper = OpenHelperManager.getHelper(null, DatabaseAccessObjects.class);
        RuntimeExceptionDao<Konto, Integer> Konto_Dao = dbHelper.getKontoRuntimeExceptionDao();
        RuntimeExceptionDao<Uczen, Integer> Uczen_Dao = dbHelper.getUczenRuntimeExceptionDao();

        // Wyswietl uzytkownika (imie,nazwisko) ktorego login i haslo to xyz i zyx

        // select imie,nazwisko from uczen u join konto konto k on u.id_ucznia = k.id_ucznia
        // where username='' and password='';

        QueryBuilder<Konto, Integer> kontoQb = Konto_Dao.queryBuilder();
        QueryBuilder<Uczen, Integer> uczenQb = Uczen_Dao.queryBuilder();
        List<Uczen> result = new ArrayList<Uczen>();
        try {
//            query = uczenQb.join(kontoQb).query();
//            query = uczenQb.selectColumns("imie","nazwisko").where().eq("username", username).and().eq("password", password).query();
            String query = "Select imie,nazwisko from uczen u inner join konto k on u.id_ucznia = k.id_ucznia where k.username='" + username + "' and k.password='" + password + "';";
            GenericRawResults<Uczen> rawResults = Uczen_Dao.queryRaw(query, Uczen_Dao.getRawRowMapper());
            result = rawResults.getResults();
            rawResults.close();

        } catch (Exception ex) {
            Log.e("UczenQb join problem", ex.getStackTrace().toString());
        }
        //result.add(new Uczen("Wojtek","Sasiela",1));
        return result;
    }

    public static List<Konto> load_Konto_Nev_Version_fromDatabase(int id) {
        // Connect with Database ORM
        DatabaseAccessObjects dbHelper = OpenHelperManager.getHelper(null, DatabaseAccessObjects.class);
        RuntimeExceptionDao<Konto, Integer> Konto_Dao = dbHelper.getKontoRuntimeExceptionDao();
        //TODO sprawdzanie czy dane logowania sa poprawne
        List<Konto> konta = Konto_Dao.queryForEq("id_konta", id);
        return konta;
    }
}
