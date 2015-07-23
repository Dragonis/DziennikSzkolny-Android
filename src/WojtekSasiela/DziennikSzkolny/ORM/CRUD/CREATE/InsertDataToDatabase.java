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


    //region Lepsze_podejscie_tworzenia_tabel
    public static void insert_Subcjet_IntoDatabase(RuntimeExceptionDao<Subcjet, Integer> subcjetDao) {
        // Subcjet(ID_Subcjet,NazwaPrzedmiotu);
        subcjetDao.create(new Subcjet(1,"Polski"));
        subcjetDao.create(new Subcjet(1,"Angielski"));
        subcjetDao.create(new Subcjet(1,"Matematyka"));
        subcjetDao.create(new Subcjet(1,"Przyroda"));
        subcjetDao.create(new Subcjet(1,"Religia"));
        subcjetDao.create(new Subcjet(1,"WF"));
    }

    public static void insert_StudentGrades_IntoDatabase(RuntimeExceptionDao<StudentGrades, Integer> studentGradesDao) {
        // StudentGrades(ID_Student,ID_NazwaPrzedmiotu,Ocena);

        //region Oceny dla_kazdego_przedmiotu_dla_uzytownika_o_ID=3
        for (int id_studenta = 1; id_studenta <= 10; id_studenta++) {
        for(int id_przedmiotu=1; id_przedmiotu<=10; id_przedmiotu++) {

                studentGradesDao.create(new StudentGrades(id_studenta, id_przedmiotu, 5, "10.10"));
                studentGradesDao.create(new StudentGrades(id_studenta, id_przedmiotu, 3, "10.10"));
                studentGradesDao.create(new StudentGrades(id_studenta, id_przedmiotu, 4, "10.10"));
                studentGradesDao.create(new StudentGrades(id_studenta, id_przedmiotu, 6, "10.10"));

            }
        }
        //endregion
    }

    public static void insert_Student_NewVersion_IntoDatabase(RuntimeExceptionDao<Student_NewVersion, Integer> student_newVersion_dao) {
        //int ID_StudentGrades, int ID_Classroom, String name, String surname, Integer classrom
        student_newVersion_dao.create(new Student_NewVersion(1,1,"Imie nowego studenta","Naziwsko nowego studenta",1));
        student_newVersion_dao.create(new Student_NewVersion(1,1,"Imie nowego studenta","Naziwsko nowego studenta",1));
        student_newVersion_dao.create(new Student_NewVersion(1,1,"Imie nowego studenta","Naziwsko nowego studenta",1));
    }

    public static void insert_Classroom_IntoDatabase(RuntimeExceptionDao<Classroom, Integer> classroomDao) {
        classroomDao.create(new Classroom("Przykladowa nazwa klasy"));
    }

    public static void insert_Teachers_IntoDatabase(RuntimeExceptionDao<Teacher, Integer> teacherDao) {
        teacherDao.create(new Teacher("Jan", "Kowalski"));
    }
    //endregion

    //region stare_podejscie_tworzenia_tabel
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
        studentDao.create(new Student("Izabela", "Tarnowska", 1));
        studentDao.create(new Student("Blanka", "Szept", 1));
        studentDao.create(new Student("Paweł", "Paluch", 1));
        studentDao.create(new Student("Piotr", "Mały", 1));
        studentDao.create(new Student("Karol", "Kopytko", 1));
        studentDao.create(new Student("Arkadiusz", "Bąk", 1));
        studentDao.create(new Student("Teresa", "Wawrzyniak", 1));
        studentDao.create(new Student("Katarzyna", "Jagiełło", 1));

        studentDao.create(new Student("Barbara", "Lewandowska", 2));
        studentDao.create(new Student("Ewelina", "2elik", 2));
        studentDao.create(new Student("Diana", "Kosmała", 2));

        studentDao.create(new Student("Karolina", "Ordon", 3));
        studentDao.create(new Student("Joanna", "Pieprzyk", 3));

        studentDao.create(new Student("Stefan", "Batory", 3));
        studentDao.create(new Student("Bartosz", "Zuch", 3));
        studentDao.create(new Student("Jadwiga", "Konieczko", 3));

        studentDao.create(new Student("Amelia", "Koral", 4));

        studentDao.create(new Student("Justyna", "Boś", 5));
        studentDao.create(new Student("Alicja", "Stępień", 5));

        studentDao.create(new Student("Kamila", "Piotrowska", 6));
        studentDao.create(new Student("Roksana", "Fajna", 6));
        studentDao.create(new Student("Beata", "Bezpieczna", 6));
        studentDao.create(new Student("Maria", "Ciekawska", 6));
        studentDao.create(new Student("Marta", "Okoń", 6));
        studentDao.create(new Student("Angelika", "Wesołowska", 6));
    }

    public static void insert_Accounts_IntoDatabase(RuntimeExceptionDao<Account, Integer> accountDao) {
        accountDao.create(new Account("Jan","Kowalski","admin login1", "admin password1"));
        accountDao.create(new Account("Johny","Brown","Uzytkownik", "Haslo"));
        accountDao.create(new Account("Wojciech","Sasiela","root", "testABCD"));
    }
    //endregion

}
