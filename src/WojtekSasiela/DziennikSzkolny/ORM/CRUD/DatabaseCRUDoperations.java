package WojtekSasiela.DziennikSzkolny.ORM.CRUD;

import WojtekSasiela.DziennikSzkolny.ORM.CRUD.CREATE.InsertDataToDatabase;
import WojtekSasiela.DziennikSzkolny.ORM.CRUD.READ.LoadDataFromDatabase;
import WojtekSasiela.DziennikSzkolny.ORM.configuration.DatabaseAccessObjects;
import WojtekSasiela.DziennikSzkolny.ORM.tables.Account;
import WojtekSasiela.DziennikSzkolny.ORM.tables.Student;
import WojtekSasiela.DziennikSzkolny.ORM.tables.miary_statystyczne.*;
import WojtekSasiela.DziennikSzkolny.ORM.tables.new_version_database.*;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;

/**
 * InsertDataToDatabased by Wojtek on 2015-04-23.
 */
public class DatabaseCRUDoperations {

    private RuntimeExceptionDao<Student, Integer> StudentDao;
    private RuntimeExceptionDao<Account, Integer> AccountDao;

    private RuntimeExceptionDao<Srednia, Integer> SredniaDao;
    private RuntimeExceptionDao<Mediana, Integer> MedianaDao;
    private RuntimeExceptionDao<Dominanta, Integer> DominantaDao;
    private RuntimeExceptionDao<Kwartyle, Integer> KwartyleDao;
    private RuntimeExceptionDao<Odchylenie, Integer> OdchylenieDao;
    private RuntimeExceptionDao<Wariancja, Integer> WariancjaDao;

    private RuntimeExceptionDao<Ocena, Integer> OcenaDao;
    private RuntimeExceptionDao<Przedmiot, Integer> PrzedmiotDao;
    private RuntimeExceptionDao<Uczen, Integer> UczenDao;

    public DatabaseCRUDoperations() {
    }


    public DatabaseCRUDoperations(DatabaseAccessObjects dbHelper) {

        StudentDao = dbHelper.getStudentRuntimeExceptionDao();
        AccountDao = dbHelper.getAccountRuntimeExceptionDao();

        SredniaDao = dbHelper.getSredniaRuntimeExceptionDao();
        MedianaDao = dbHelper.getMedianaRuntimeExceptionDao();
        DominantaDao = dbHelper.getDominantaRuntimeExceptionDao();
        KwartyleDao = dbHelper.getKwartyleRuntimeExceptionDao();
        OdchylenieDao = dbHelper.getOdchylenieRuntimeExceptionDao();
        WariancjaDao = dbHelper.getWariancjaRuntimeExceptionDao();

        OcenaDao = dbHelper.getOcenaRuntimeExceptionDao();
        PrzedmiotDao = dbHelper.getPrzedmiotRuntimeExceptionDao();
        UczenDao = dbHelper.getUczenRuntimeExceptionDao();

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

        InsertDataToDatabase.insert_Accounts_IntoDatabase(AccountDao);
        InsertDataToDatabase.insert_Students_IntoDatabase(StudentDao);

        InsertDataToDatabase.insert_Oceny_IntoDatabase(OcenaDao);
        InsertDataToDatabase.insert_Przedmiot_IntoDatabase(PrzedmiotDao);
        InsertDataToDatabase.insert_Uczen_IntoDatabase(UczenDao);
    }

}
