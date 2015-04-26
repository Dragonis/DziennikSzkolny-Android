package sasiela.wojtek.dziennikszkolny;


import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.sql.SQLException;

import sasiela.wojtek.dziennikszkolny.ORM.configuration.DatabaseHelper;
import sasiela.wojtek.dziennikszkolny.ORM.tables.Account;
import sasiela.wojtek.dziennikszkolny.ORM.tables.Student;
import sasiela.wojtek.dziennikszkolny.ORM.tables.Teacher;
import sasiela.wojtek.dziennikszkolny.ORM.tables.miary_statystyczne.Dominanta;
import sasiela.wojtek.dziennikszkolny.ORM.tables.miary_statystyczne.Kwartyle;
import sasiela.wojtek.dziennikszkolny.ORM.tables.miary_statystyczne.Mediana;
import sasiela.wojtek.dziennikszkolny.ORM.tables.miary_statystyczne.Odchylenie;
import sasiela.wojtek.dziennikszkolny.ORM.tables.miary_statystyczne.Srednia;
import sasiela.wojtek.dziennikszkolny.ORM.tables.miary_statystyczne.Wariancja;
import sasiela.wojtek.dziennikszkolny.ORM.tables.subjects.Biology;
import sasiela.wojtek.dziennikszkolny.ORM.tables.subjects.English;
import sasiela.wojtek.dziennikszkolny.ORM.tables.subjects.Mathematic;
import sasiela.wojtek.dziennikszkolny.ORM.tables.subjects.Polish;
import sasiela.wojtek.dziennikszkolny.ORM.tables.subjects.Religion;
import sasiela.wojtek.dziennikszkolny.ORM.tables.subjects.WF;

/**
 * Created by Wojtek on 2015-04-23.
 */
public class DatabaseCRUDoperations {

    RuntimeExceptionDao<Student, Integer> StudentDao;
    RuntimeExceptionDao<Account, Integer> AccountDao;
    RuntimeExceptionDao<Teacher, Integer> TeacherDao;
    RuntimeExceptionDao<Biology, Integer> BiologyDao;
    RuntimeExceptionDao<English, Integer> EnglishDao;
    RuntimeExceptionDao<Mathematic, Integer> MathematicDao;
    RuntimeExceptionDao<Polish, Integer> PolishDao;
    RuntimeExceptionDao<Religion, Integer> ReligionDao;
    RuntimeExceptionDao<WF, Integer> WFDao;

    RuntimeExceptionDao<Srednia, Integer> SredniaDao;
    RuntimeExceptionDao<Mediana, Integer> MedianaDao;
    RuntimeExceptionDao<Dominanta, Integer> DominantaDao;
    RuntimeExceptionDao<Kwartyle, Integer> KwartyleDao;
    RuntimeExceptionDao<Odchylenie, Integer> OdchylenieDao;
    RuntimeExceptionDao<Wariancja, Integer> WariancjaDao;
    
    public DatabaseCRUDoperations() {
    }


    public void doAccountDataStuff(DatabaseHelper dbHelper) throws SQLException {

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
        if (dbHelper.getReadableDatabase() == null) {

            // wyswietla listeUczniow z bazy danych

        } else {
            //TODO Dodaje/Usuwa/Edytuje element(ucznia) do bazy danych
            insert_sample_database();
            /**
            *Aby dodac rekordy do bazy danych uzywasz
             costamDao.create(Obiekt(wartosci);

             *Aby usunac
             * costamDao.delete(Obiekt9wartosc));
            */

    }

        OpenHelperManager.releaseHelper();
    }

    public void insert_sample_database() {
        insert_Accounts_IntoDatabase(AccountDao);
        insert_Students_IntoDatabase(StudentDao);

        insert_BIOLOGY_GradesIntoDatabase(BiologyDao);
        insert_ENGLISH_GradesIntoDatabase(EnglishDao);
        insert_MATHEMATIC_GradesIntoDatabase(MathematicDao);
        insert_POLISH_GradesIntoDatabases(PolishDao);
        insert_RELIGION_GradesIntoDatabase(ReligionDao);
        insert_WF_GradesIntoDatabase(WFDao);
    }

    private void insert_Teachers_IntoDatabase(RuntimeExceptionDao<Teacher, Integer> teacherDao) {
        teacherDao.create(new Teacher("Jan", "Kowalski"));
    }

    private void insert_WF_GradesIntoDatabase(RuntimeExceptionDao<WF, Integer> WFDao) {
        WFDao.create(new WF(1, 3, 4, 5));
        WFDao.create(new WF(2, 3, 4, 5));
        WFDao.create(new WF(3, 3, 4, 5));
    }

    private void insert_RELIGION_GradesIntoDatabase(RuntimeExceptionDao<Religion, Integer> religionDao) {
        religionDao.create(new Religion(1, 3, 4, 5));
        religionDao.create(new Religion(2, 3, 4, 5));
        religionDao.create(new Religion(3, 3, 4, 5));
    }

    private void insert_POLISH_GradesIntoDatabases(RuntimeExceptionDao<Polish, Integer> polishDao) {
        polishDao.create(new Polish(1, 3, 4, 5));
        polishDao.create(new Polish(2, 3, 4, 5));
        polishDao.create(new Polish(3, 3, 4, 5));
    }

    private void insert_MATHEMATIC_GradesIntoDatabase(RuntimeExceptionDao<Mathematic, Integer> mathematicDao) {
        mathematicDao.create(new Mathematic(1, 3, 4, 5));
        mathematicDao.create(new Mathematic(2, 3, 4, 5));
        mathematicDao.create(new Mathematic(3, 3, 4, 5));
    }

    private void insert_ENGLISH_GradesIntoDatabase(RuntimeExceptionDao<English, Integer> englishDao) {
        englishDao.create(new English(1, 3, 4, 5));
        englishDao.create(new English(2, 3, 4, 5));
        englishDao.create(new English(3, 3, 4, 5));
    }

    private void insert_BIOLOGY_GradesIntoDatabase(RuntimeExceptionDao<Biology, Integer> biologyDao) {
        biologyDao.create(new Biology(1, 3, 4, 5, "10.10", "14.04", "5.05"));
        biologyDao.create(new Biology(2, 1, 2, 3, "10.10", "14.04", "5.05"));
        biologyDao.create(new Biology(3, 0, 0, 0, "10.10", "14.04", "5.05"));
        biologyDao.create(new Biology(4, 0, 0, 0, "10.10", "14.04", "5.05"));
        biologyDao.create(new Biology(5, 0, 0, 0, "10.10", "14.04", "5.05"));
        biologyDao.create(new Biology(6, 0, 0, 0, "10.10", "14.04", "5.05"));
        biologyDao.create(new Biology(7, 0, 0, 0, "10.10", "14.04", "5.05"));
        biologyDao.create(new Biology(8, 0, 0, 0, "10.10", "14.04", "5.05"));
        biologyDao.create(new Biology(9, 0, 0, 0, "10.10", "14.04", "5.05"));
    }

    public void insert_Students_IntoDatabase(RuntimeExceptionDao<Student, Integer> studentDao) {
        studentDao.create(new Student("Wojtek", "Sasiela", 1));
        studentDao.create(new Student("Anna", "Kowalska", 1));
        studentDao.create(new Student("Joanna", "Pyrzy�ska", 1));
        studentDao.create(new Student("Izabela", "Tarnowska", 1));
        studentDao.create(new Student("Blanka", "Szept", 1));
        studentDao.create(new Student("Pawe�", "Paluch", 1));
        studentDao.create(new Student("Piotr", "Ma�y", 1));
        studentDao.create(new Student("Karol", "Kopytko", 1));
        studentDao.create(new Student("Arkadiusz", "B�k", 1));
        studentDao.create(new Student("Teresa", "Wawrzyniak", 1));
        studentDao.create(new Student("Katarzyna", "Jagie��o", 1));

        studentDao.create(new Student("111", "111", 2));
        studentDao.create(new Student("222", "222", 2));
        studentDao.create(new Student("333", "333", 2));
//        studentDao.create(new Student("333", "333",2));
//        studentDao.create(new Student("4444", "444",2));
//        studentDao.create(new Student("555", "555",2));
//        studentDao.create(new Student("666", "666",2));
//        studentDao.create(new Student("777", "777",2));
//        studentDao.create(new Student("888", "888",2));
//        studentDao.create(new Student("999", "999",2));

        studentDao.create(new Student("AAA", "AAA", 3));
        studentDao.create(new Student("BBB", "BBB", 3));
        studentDao.create(new Student("CCC", "CCC", 3));
        studentDao.create(new Student("DDD", "DDD", 3));
        studentDao.create(new Student("EEE", "EEE", 3));
//        studentDao.create(new Student("FFF", "FFF",3));
//        studentDao.create(new Student("GGG", "GGG",3));
//        studentDao.create(new Student("HHH", "HHH",3));
//        studentDao.create(new Student("III", "III",3));
//        studentDao.create(new Student("JJJ", "JJJ",3));

        studentDao.create(new Student("4", "klasa", 4));
//        studentDao.create(new Student("czwarta", "test",4));
//        studentDao.create(new Student("IV", "test2",4));
//        studentDao.create(new Student("qqq", "qqq",4));
//        studentDao.create(new Student("www", "www",4));
//        studentDao.create(new Student("eee", "eee",4));

        studentDao.create(new Student("V", "abc", 5));
        studentDao.create(new Student("5", "z", 5));
//        studentDao.create(new Student("piata", "y",5));
//        studentDao.create(new Student("aaa", "aaa",5));
//        studentDao.create(new Student("sss", "sss",5));
//        studentDao.create(new Student("dddd", "ddd",5));

        studentDao.create(new Student("VI", "numera", 6));
        studentDao.create(new Student("6", "dzwiek", 6));
        studentDao.create(new Student("szosta", "woda", 6));
        studentDao.create(new Student("ppp", "ppp", 6));
        studentDao.create(new Student("ccc", "ccc", 6));
        studentDao.create(new Student("nnn", "nnn", 6));
    }

    public void insert_Accounts_IntoDatabase(RuntimeExceptionDao<Account, Integer> accountDao) {
        accountDao.create(new Account("Jan","Kowalski","admin login1", "admin password1"));
        accountDao.create(new Account("Johny","Brown","Uzytkownik", "Haslo"));
        accountDao.create(new Account("Wojciech","Sasiela","root", "testABCD"));
    }

}
