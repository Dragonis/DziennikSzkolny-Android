package sasiela.wojtek.dziennikszkolny.ORM.CRUD;



import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

import sasiela.wojtek.dziennikszkolny.ORM.CRUD.CREATE.InsertDataToDatabase;
import sasiela.wojtek.dziennikszkolny.ORM.configuration.DatabaseAccessObjects;
import sasiela.wojtek.dziennikszkolny.ORM.tables.Student;
import sasiela.wojtek.dziennikszkolny.ORM.tables.new_version_database.Konto;
import sasiela.wojtek.dziennikszkolny.ORM.tables.new_version_database.Ocena;
import sasiela.wojtek.dziennikszkolny.ORM.tables.new_version_database.Przedmiot;
import sasiela.wojtek.dziennikszkolny.ORM.tables.new_version_database.Uczen;

/**
 * InsertDataToDatabased by Wojtek on 2015-04-23.
 */
public class DatabaseCRUDoperations {

    private RuntimeExceptionDao<Student, Integer> StudentDao;

    private RuntimeExceptionDao<Ocena, Integer> OcenaDao;
    private RuntimeExceptionDao<Przedmiot, Integer> PrzedmiotDao;
    private RuntimeExceptionDao<Uczen, Integer> UczenDao;
    private RuntimeExceptionDao<Konto, Integer> KontaDao;

    public DatabaseCRUDoperations(DatabaseAccessObjects dbHelper) {

        StudentDao = dbHelper.getStudentRuntimeExceptionDao();

        OcenaDao = dbHelper.getOcenaRuntimeExceptionDao();
        PrzedmiotDao = dbHelper.getPrzedmiotRuntimeExceptionDao();
        UczenDao = dbHelper.getUczenRuntimeExceptionDao();
        KontaDao = dbHelper.getKontoRuntimeExceptionDao();

        // jezeli znajduje sie baza danych na urzadzeniu
        if (dbHelper.getReadableDatabase() != null) {

            insert_sample_database();

    } else {

        // wyswietla listeUczniow z bazy danych

    }

        OpenHelperManager.releaseHelper();
    }
    
    public void insert_sample_database() {

        InsertDataToDatabase.insert_Students_IntoDatabase(StudentDao);

        InsertDataToDatabase.insert_Oceny_IntoDatabase(OcenaDao);
        InsertDataToDatabase.insert_Przedmiot_IntoDatabase(PrzedmiotDao);
        InsertDataToDatabase.insert_Uczen_IntoDatabase(UczenDao);
        InsertDataToDatabase.insert_Konta_IntoDatabase(KontaDao);
    }

}
