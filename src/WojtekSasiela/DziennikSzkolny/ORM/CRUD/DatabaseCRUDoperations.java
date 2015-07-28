package WojtekSasiela.DziennikSzkolny.ORM.CRUD;

import WojtekSasiela.DziennikSzkolny.ORM.CRUD.CREATE.InsertDataToDatabase;
import WojtekSasiela.DziennikSzkolny.ORM.configuration.DatabaseAccessObjects;
import WojtekSasiela.DziennikSzkolny.ORM.tables.Student;
import WojtekSasiela.DziennikSzkolny.ORM.tables.new_version_database.*;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

/**
 * InsertDataToDatabased by Wojtek on 2015-04-23.
 */
public class DatabaseCRUDoperations {

    private RuntimeExceptionDao<Student, Integer> StudentDao;

    private RuntimeExceptionDao<Ocena, Integer> OcenaDao;
    private RuntimeExceptionDao<Przedmiot, Integer> PrzedmiotDao;
    private RuntimeExceptionDao<Uczen, Integer> UczenDao;
    private RuntimeExceptionDao<Konto, Integer> KontaDao;

    public DatabaseCRUDoperations() {
    }


    public DatabaseCRUDoperations(DatabaseAccessObjects dbHelper) {

        StudentDao = dbHelper.getStudentRuntimeExceptionDao();

        OcenaDao = dbHelper.getOcenaRuntimeExceptionDao();
        PrzedmiotDao = dbHelper.getPrzedmiotRuntimeExceptionDao();
        UczenDao = dbHelper.getUczenRuntimeExceptionDao();
        KontaDao = dbHelper.getKontoRuntimeExceptionDao();

        // jezeli znajduje sie baza danych na urzadzeniu
        if (dbHelper.getReadableDatabase() != null) {
            //TODO Dodaje/Usuwa/Edytuje element(ucznia) do bazy danych

            insert_sample_database();

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

//        InsertDataToDatabase.insert_Accounts_IntoDatabase(AccountDao);

        InsertDataToDatabase.insert_Students_IntoDatabase(StudentDao);

        InsertDataToDatabase.insert_Oceny_IntoDatabase(OcenaDao);
        InsertDataToDatabase.insert_Przedmiot_IntoDatabase(PrzedmiotDao);
        InsertDataToDatabase.insert_Uczen_IntoDatabase(UczenDao);
        InsertDataToDatabase.insert_Konta_IntoDatabase(KontaDao);
    }

}
