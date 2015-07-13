package WojtekSasiela.DziennikSzkolny.ORM.CRUD.READ;

import WojtekSasiela.DziennikSzkolny.ORM.Classroom;
import WojtekSasiela.DziennikSzkolny.ORM.StudentGrades;
import WojtekSasiela.DziennikSzkolny.ORM.Student_NewVersion;
import WojtekSasiela.DziennikSzkolny.ORM.Subcjet;
import WojtekSasiela.DziennikSzkolny.ORM.configuration.DatabaseAccessObjects;
import WojtekSasiela.DziennikSzkolny.ORM.tables.Account;
import WojtekSasiela.DziennikSzkolny.ORM.tables.Student;
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

    public static void load_Subcjet_FromDatabase()
    {
        // Connect with Database ORM
        DatabaseAccessObjects dbHelper = OpenHelperManager.getHelper(null, DatabaseAccessObjects.class);
        RuntimeExceptionDao<Subcjet, Integer> subcjetDao = dbHelper.getSubcjetRuntimeExceptionDao();
        List<Subcjet> subcjets = subcjetDao.queryForEq("subcjet", "Przykladowa nazwa przedmiotu");
        Log.e("SubcjetTableDB", subcjets.get(0).getSubcjet());

        //Integer max_liczba_studentow_w_klasie = students.size();
        //osoby = new ArrayList<String>(max_liczba_studentow_w_klasie);
    }

    public static void load_Classroom_FromDatabase()
    {
        // Connect with Database ORM
        DatabaseAccessObjects dbHelper = OpenHelperManager.getHelper(null, DatabaseAccessObjects.class);
        RuntimeExceptionDao<Classroom, Integer> classroomDao = dbHelper.getClassroomRuntimeExceptionDao();
        List<Classroom> classrooms = classroomDao.queryForEq("Name", "Przykladowa nazwa klasy");
        Log.e("ClassroomTableDB",classrooms.get(0).getName());

        //Integer max_liczba_studentow_w_klasie = students.size();
        //osoby = new ArrayList<String>(max_liczba_studentow_w_klasie);
    }

    public static void load_StudentGrades_FromDatabase()
    {
        // Connect with Database ORM
        DatabaseAccessObjects dbHelper = OpenHelperManager.getHelper(null, DatabaseAccessObjects.class);
        RuntimeExceptionDao<StudentGrades, Integer> StudentGradesDao = dbHelper.getStudentGradesRuntimeExceptionDao();
        List<StudentGrades> studentGrades = StudentGradesDao.queryForEq("Grade", 3);

        if(!studentGrades.isEmpty())
        {
            Log.e("StudentGradesTableDB",Integer.toString(studentGrades.get(0).getGrade()));
        }
        else
        {
            Log.e("StudentGradesTableDB","Nie ma takiej wartoœci w tabeli StudentGrades");
        }


        //Integer max_liczba_studentow_w_klasie = students.size();
        //osoby = new ArrayList<String>(max_liczba_studentow_w_klasie);
    }

    public static void load_Student_NewVersion_FromDatabase()
    {
        // Connect with Database ORM
        DatabaseAccessObjects dbHelper = OpenHelperManager.getHelper(null, DatabaseAccessObjects.class);
        RuntimeExceptionDao<Student_NewVersion, Integer> Student_NewVersion_Dao = dbHelper.getStudent_NewVersion_RuntimeExceptionDao();
        List<Student_NewVersion> studentNewVersion = Student_NewVersion_Dao.queryForEq("name", "Imie nowego studenta");
        Log.e("StudentNewVersionTableDB", studentNewVersion.get(0).getName());


        //Integer max_liczba_studentow_w_klasie = students.size();
        //osoby = new ArrayList<String>(max_liczba_studentow_w_klasie);
    }


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

    public static List<Integer> loadStudentGrades(int id_ucznia,int id_przedmiotu)
    {
        List<Integer> oceny = new ArrayList<>();
        // Connect with Database ORM
        DatabaseAccessObjects dbHelper = OpenHelperManager.getHelper(null, DatabaseAccessObjects.class);
        RuntimeExceptionDao<StudentGrades, Integer> StudentGrades_Dao = dbHelper.getStudentGradesRuntimeExceptionDao();
        //TODO sprawdzanie czy dane logowania sa poprawne
        List<StudentGrades> studentGrades = null;
        try {
            studentGrades = StudentGrades_Dao.queryBuilder().selectColumns("Grade").query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(int i=0;i<studentGrades.size();i++)
        {
            oceny.add((Integer) studentGrades.get(i).getGrade());
        }
        return oceny;
    }

    public static List<String> loadStudentDates(int id_ucznia,int id_przedmiotu)
    {
        List<String> daty = new ArrayList<>();
        // Connect with Database ORM
        DatabaseAccessObjects dbHelper = OpenHelperManager.getHelper(null, DatabaseAccessObjects.class);
        RuntimeExceptionDao<StudentGrades, Integer> StudentGrades_Dao = dbHelper.getStudentGradesRuntimeExceptionDao();
        //TODO sprawdzanie czy dane logowania sa poprawne
        List<StudentGrades> studentGrades = null;
        try {
            studentGrades = StudentGrades_Dao.queryBuilder().selectColumns("Date").query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(int i=0;i<studentGrades.size();i++)
        {
            daty.add(studentGrades.get(i).getDate());
        }
        return daty;
    }

}
