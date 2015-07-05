package WojtekSasiela.DziennikSzkolny.ORM.CRUD.CREATE;

import WojtekSasiela.DziennikSzkolny.ORM.Classroom;
import WojtekSasiela.DziennikSzkolny.ORM.StudentGrades;
import WojtekSasiela.DziennikSzkolny.ORM.Student_NewVersion;
import WojtekSasiela.DziennikSzkolny.ORM.Subcjet;
import WojtekSasiela.DziennikSzkolny.ORM.tables.Account;
import WojtekSasiela.DziennikSzkolny.ORM.tables.Student;
import WojtekSasiela.DziennikSzkolny.ORM.tables.Teacher;
import WojtekSasiela.DziennikSzkolny.ORM.tables.subjects.*;
import com.j256.ormlite.dao.RuntimeExceptionDao;

/**
 * Created by Wojtek on 2015-07-04.
 */
public class InsertDataToDatabase {


    public static void insert_Subcjet_IntoDatabase(RuntimeExceptionDao<Subcjet, Integer> subcjetDao) {
        subcjetDao.create(new Subcjet(1,1,"Przykladowa nazwa przedmiotu"));
    }

    public static void insert_StudentGrades_IntoDatabase(RuntimeExceptionDao<StudentGrades, Integer> studentGradesDao) {
        studentGradesDao.create(new StudentGrades(1,5));
        studentGradesDao.create(new StudentGrades(1,3));
        studentGradesDao.create(new StudentGrades(1,4));
        studentGradesDao.create(new StudentGrades(1,6));
    }

    public static void insert_Student_NewVersion_IntoDatabase(RuntimeExceptionDao<Student_NewVersion, Integer> student_newVersion_dao) {
        student_newVersion_dao.create(new Student_NewVersion(1,1,"Imie nowego studenta","Naziwsko nowego studenta",1));
    }

    public static void insert_Classroom_IntoDatabase(RuntimeExceptionDao<Classroom, Integer> classroomDao) {
        classroomDao.create(new Classroom("Przykladowa nazwa klasy"));
    }

    public static void insert_Teachers_IntoDatabase(RuntimeExceptionDao<Teacher, Integer> teacherDao) {
        teacherDao.create(new Teacher("Jan", "Kowalski"));
    }

    public static void insert_WF_GradesIntoDatabase(RuntimeExceptionDao<WF, Integer> WFDao) {
        WFDao.create(new WF(1, 3, 4, 5));
        WFDao.create(new WF(2, 3, 4, 5));
        WFDao.create(new WF(3, 3, 4, 5));
    }

    public static void insert_RELIGION_GradesIntoDatabase(RuntimeExceptionDao<Religion, Integer> religionDao) {
        religionDao.create(new Religion(1, 3, 4, 5));
        religionDao.create(new Religion(2, 3, 4, 5));
        religionDao.create(new Religion(3, 3, 4, 5));
    }

    public static void insert_POLISH_GradesIntoDatabases(RuntimeExceptionDao<Polish, Integer> polishDao) {
        polishDao.create(new Polish(1, 3, 4, 5));
        polishDao.create(new Polish(2, 3, 4, 5));
        polishDao.create(new Polish(3, 3, 4, 5));
    }

    public static void insert_MATHEMATIC_GradesIntoDatabase(RuntimeExceptionDao<Mathematic, Integer> mathematicDao) {
        mathematicDao.create(new Mathematic(1, 3, 4, 5));
        mathematicDao.create(new Mathematic(2, 3, 4, 5));
        mathematicDao.create(new Mathematic(3, 3, 4, 5));
    }

    public static void insert_ENGLISH_GradesIntoDatabase(RuntimeExceptionDao<English, Integer> englishDao) {
        englishDao.create(new English(1, 3, 4, 5));
        englishDao.create(new English(2, 3, 4, 5));
        englishDao.create(new English(3, 3, 4, 5));
    }

    public static void insert_BIOLOGY_GradesIntoDatabase(RuntimeExceptionDao<Biology, Integer> biologyDao) {
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

    public static void insert_Students_IntoDatabase(RuntimeExceptionDao<Student, Integer> studentDao) {
        studentDao.create(new Student("Wojtek", "Sasiela", 1));
        studentDao.create(new Student("Anna", "Kowalska", 1));
        studentDao.create(new Student("Joanna", "Pyrzyñska", 1));
        studentDao.create(new Student("Izabela", "Tarnowska", 1));
        studentDao.create(new Student("Blanka", "Szept", 1));
        studentDao.create(new Student("Pawe³", "Paluch", 1));
        studentDao.create(new Student("Piotr", "Ma³y", 1));
        studentDao.create(new Student("Karol", "Kopytko", 1));
        studentDao.create(new Student("Arkadiusz", "B¹k", 1));
        studentDao.create(new Student("Teresa", "Wawrzyniak", 1));
        studentDao.create(new Student("Katarzyna", "Jagie³³o", 1));

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

    public static void insert_Accounts_IntoDatabase(RuntimeExceptionDao<Account, Integer> accountDao) {
        accountDao.create(new Account("Jan","Kowalski","admin login1", "admin password1"));
        accountDao.create(new Account("Johny","Brown","Uzytkownik", "Haslo"));
        accountDao.create(new Account("Wojciech","Sasiela","root", "testABCD"));
    }

}
