package WojtekSasiela.DziennikSzkolny.ORM.CRUD;

import WojtekSasiela.DziennikSzkolny.ORM.CRUD.CREATE.InsertDataToDatabase;
import WojtekSasiela.DziennikSzkolny.ORM.CRUD.READ.LoadDataFromDatabase;
import WojtekSasiela.DziennikSzkolny.ORM.Classroom;
import WojtekSasiela.DziennikSzkolny.ORM.StudentGrades;
import WojtekSasiela.DziennikSzkolny.ORM.Student_NewVersion;
import WojtekSasiela.DziennikSzkolny.ORM.Subcjet;
import WojtekSasiela.DziennikSzkolny.ORM.configuration.DatabaseAccessObjects;
import WojtekSasiela.DziennikSzkolny.ORM.tables.Account;
import WojtekSasiela.DziennikSzkolny.ORM.tables.Student;
import WojtekSasiela.DziennikSzkolny.ORM.tables.Teacher;
import WojtekSasiela.DziennikSzkolny.ORM.tables.miary_statystyczne.*;
import WojtekSasiela.DziennikSzkolny.ORM.tables.subjects.*;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.sql.SQLException;

/**
 * InsertDataToDatabased by Wojtek on 2015-04-23.
 */
public class DatabaseCRUDoperations {


    private RuntimeExceptionDao<Classroom, Integer> ClassroomDao;
    private RuntimeExceptionDao<Student_NewVersion, Integer> Student_NewVersion_Dao;
    private RuntimeExceptionDao<StudentGrades, Integer> StudentGradesDao;
    private RuntimeExceptionDao<Subcjet, Integer> SubcjetDao;

    private RuntimeExceptionDao<Student, Integer> StudentDao;
    private RuntimeExceptionDao<Account, Integer> AccountDao;
    private RuntimeExceptionDao<Teacher, Integer> TeacherDao;
    private RuntimeExceptionDao<Biology, Integer> BiologyDao;
    private RuntimeExceptionDao<English, Integer> EnglishDao;
    private RuntimeExceptionDao<Mathematic, Integer> MathematicDao;
    private RuntimeExceptionDao<Polish, Integer> PolishDao;
    private RuntimeExceptionDao<Religion, Integer> ReligionDao;
    private RuntimeExceptionDao<WF, Integer> WFDao;
    private RuntimeExceptionDao<Srednia, Integer> SredniaDao;
    private RuntimeExceptionDao<Mediana, Integer> MedianaDao;
    private RuntimeExceptionDao<Dominanta, Integer> DominantaDao;
    private RuntimeExceptionDao<Kwartyle, Integer> KwartyleDao;
    private RuntimeExceptionDao<Odchylenie, Integer> OdchylenieDao;
    private RuntimeExceptionDao<Wariancja, Integer> WariancjaDao;
    
    public DatabaseCRUDoperations() {
    }


    public DatabaseCRUDoperations(DatabaseAccessObjects dbHelper) {

        ClassroomDao = dbHelper.getClassroomRuntimeExceptionDao();
        Student_NewVersion_Dao = dbHelper.getStudent_NewVersion_RuntimeExceptionDao();
        StudentGradesDao = dbHelper.getStudentGradesRuntimeExceptionDao();
        SubcjetDao = dbHelper.getSubcjetRuntimeExceptionDao();

        StudentDao = dbHelper.getStudentRuntimeExceptionDao();
        AccountDao = dbHelper.getAccountRuntimeExceptionDao();
        TeacherDao = dbHelper.getTeacherRuntimeExceptionDao();
        
        BiologyDao = dbHelper.getBiologyRuntimeExceptionDao();
        EnglishDao = dbHelper.getEnglishRuntimeExceptionDao();
        MathematicDao = dbHelper.getMathematicRuntimeExceptionDao();
        PolishDao = dbHelper.getPolishRuntimeExceptionDao();
        ReligionDao = dbHelper.getReligionRuntimeExceptionDao();
        WFDao = dbHelper.getWFRuntimeExceptionDao();
        
        SredniaDao = dbHelper.getSredniaRuntimeExceptionDao();
        MedianaDao = dbHelper.getMedianaRuntimeExceptionDao();
        DominantaDao = dbHelper.getDominantaRuntimeExceptionDao();
        KwartyleDao = dbHelper.getKwartyleRuntimeExceptionDao();
        OdchylenieDao = dbHelper.getOdchylenieRuntimeExceptionDao();
        WariancjaDao = dbHelper.getWariancjaRuntimeExceptionDao();

        // jezeli znajduje sie baza danych na urzadzeniu
        if (dbHelper.getReadableDatabase() != null) {
            //TODO Dodaje/Usuwa/Edytuje element(ucznia) do bazy danych

            insert_sample_database();
            load_sample_database();

            /**
            *Aby dodac rekordy do bazy danych uzywasz
             costamDao.InsertDataToDatabase(Obiekt(wartosci);

             *Aby usunac
             * costamDao.delete(Obiekt9wartosc));
            */

    } else {

        // wyswietla listeUczniow z bazy danych

    }

        OpenHelperManager.releaseHelper();
    }
    
    public void insert_sample_database() {
  
        InsertDataToDatabase.insert_Classroom_IntoDatabase(ClassroomDao);
        InsertDataToDatabase.insert_Student_NewVersion_IntoDatabase(Student_NewVersion_Dao);
        InsertDataToDatabase.insert_StudentGrades_IntoDatabase(StudentGradesDao);
        InsertDataToDatabase.insert_Subcjet_IntoDatabase(SubcjetDao);

        InsertDataToDatabase.insert_Accounts_IntoDatabase(AccountDao);
        InsertDataToDatabase.insert_Students_IntoDatabase(StudentDao);

        InsertDataToDatabase.insert_BIOLOGY_GradesIntoDatabase(BiologyDao);
        InsertDataToDatabase.insert_ENGLISH_GradesIntoDatabase(EnglishDao);
        InsertDataToDatabase.insert_MATHEMATIC_GradesIntoDatabase(MathematicDao);
        InsertDataToDatabase.insert_POLISH_GradesIntoDatabases(PolishDao);
        InsertDataToDatabase.insert_RELIGION_GradesIntoDatabase(ReligionDao);
        InsertDataToDatabase.insert_WF_GradesIntoDatabase(WFDao);
    }

    public void load_sample_database()
    {
        
        LoadDataFromDatabase.load_Subcjet_FromDatabase();
        LoadDataFromDatabase.load_Classroom_FromDatabase();
        LoadDataFromDatabase.load_StudentGrades_FromDatabase();
        LoadDataFromDatabase.load_Student_NewVersion_FromDatabase();
    }

}
