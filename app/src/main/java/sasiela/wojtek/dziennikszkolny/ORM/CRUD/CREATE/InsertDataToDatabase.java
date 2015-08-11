package sasiela.wojtek.dziennikszkolny.ORM.CRUD.CREATE;


import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.sql.SQLException;

import sasiela.wojtek.dziennikszkolny.ORM.configuration.DatabaseAccessObjects;
import sasiela.wojtek.dziennikszkolny.ORM.tables.Student;
import sasiela.wojtek.dziennikszkolny.ORM.tables.new_version_database.*;

/**
 * Created by Wojtek on 2015-07-04.
 */
public class InsertDataToDatabase {

    //region stare_podejscie_tworzenia_tabel

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

    // NEV VERSION DATABASE
    public static void insert_Oceny_IntoDatabase(RuntimeExceptionDao<Ocena, Integer> ocenaDao) {
        //  Ocena(Integer id_ucznia, Integer id_przedmiotu, Integer ocena, String data)
        ocenaDao.create(new Ocena(1,1,5,"10.10"));
        ocenaDao.create(new Ocena(1,1,3,"4.10"));
        ocenaDao.create(new Ocena(2,2,4,"5.10"));
    }

    public static void insert_Przedmiot_IntoDatabase(RuntimeExceptionDao<Przedmiot, Integer> przedmiotDao) {
        przedmiotDao.create(new Przedmiot("Polski"));
        przedmiotDao.create(new Przedmiot("Angielski"));
        przedmiotDao.create(new Przedmiot("Matematyka"));
        przedmiotDao.create(new Przedmiot("Przyroda"));
        przedmiotDao.create(new Przedmiot("Religia"));
        przedmiotDao.create(new Przedmiot("WF"));
    }

    public static void insert_Uczen_IntoDatabase(RuntimeExceptionDao<Uczen, Integer> uczenDao) {
        uczenDao.create(new Uczen("Wojtek","Sasiela",1));
        uczenDao.create(new Uczen("Kamil","Fajny",1));
        uczenDao.create(new Uczen("Basia","Elegancka",1));
        uczenDao.create(new Uczen("Jolanta","Zabawna",2));
    }

    public static void insert_Konta_IntoDatabase(RuntimeExceptionDao<Konto, Integer> kontoDao) {
        kontoDao.create(new Konto(1,"root","testABCD"));
        kontoDao.create(new Konto(3,"admin login1","admin password1"));
        kontoDao.create(new Konto(2,"Uzytkownik","Haslo"));
    }

    public static void insert_new_Uczen_IntoDatabase(RuntimeExceptionDao<Uczen, Integer> uczenDao,String imie, String nazwisko, Integer klasa)
    {
        uczenDao.create(new Uczen(imie,nazwisko,klasa));
    }

    public static void insert_new_Ocena_IntoDatabase(RuntimeExceptionDao<Ocena, Integer> ocenaDao,  Integer Id_ucznia, Integer Id_przedmiotu, Integer ocena, String data)
    {
        ocenaDao.create(new Ocena(Id_ucznia, Id_przedmiotu, ocena, data));
    }

    public static void dodajOceneIDateUczniowioDanymImieniuiNazwisku(String imie, String nazwisko, String nazwa_przedmiotu, Integer ocena, String data)
    {
        DatabaseAccessObjects dbHelper = OpenHelperManager.getHelper(null, DatabaseAccessObjects.class);

        RuntimeExceptionDao<Uczen, Integer> Uczen_Dao = dbHelper.getUczenRuntimeExceptionDao();
        RuntimeExceptionDao<Przedmiot, Integer> Przedmiot_Dao = dbHelper.getPrzedmiotRuntimeExceptionDao();
        RuntimeExceptionDao<Ocena, Integer> Ocena_Dao = dbHelper.getOcenaRuntimeExceptionDao();

        Uczen uczen = null;
        Integer id_ucznia = 0;
        try {
            uczen = Uczen_Dao.queryBuilder().where().eq("imie",imie).and().eq("nazwisko",nazwisko).queryForFirst();
            id_ucznia = uczen.getId_ucznia();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Przedmiot przedmiot = null;
        Integer id_przedmiotu = 0;
        try {
            przedmiot = Przedmiot_Dao.queryBuilder().where().eq("nazwa",nazwa_przedmiotu).queryForFirst();
            id_przedmiotu = przedmiot.getId_przedmiotu();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        InsertDataToDatabase.insert_new_Ocena_IntoDatabase(Ocena_Dao, id_ucznia, id_przedmiotu, ocena, data);
    }
    //endregion

}
