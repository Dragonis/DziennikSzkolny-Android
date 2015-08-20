package sasiela.wojtek.dziennikszkolny.ORM.CRUD.UPDATE;


import android.accounts.Account;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.UpdateBuilder;

import java.sql.SQLException;

import sasiela.wojtek.dziennikszkolny.ORM.configuration.DatabaseAccessObjects;
import sasiela.wojtek.dziennikszkolny.ORM.tables.new_version_database.Konto;
import sasiela.wojtek.dziennikszkolny.ORM.tables.new_version_database.Uczen;

/**
 * Created by Wojtek on 2015-07-05.
 */
public class UpdateDataInDatabase {

    public static void aktualizujDaneUcznia(String stareImie, String stareNazwisko,String staraKlasa, String noweImie, String noweNazwisko, String nowaKlasa)
    {
        // Connect with Database ORM
        DatabaseAccessObjects dbHelper = OpenHelperManager.getHelper(null, DatabaseAccessObjects.class);
        RuntimeExceptionDao<Uczen, Integer> uczenDao = dbHelper.getUczenRuntimeExceptionDao();
        UpdateBuilder<Uczen,Integer> updateBuilder = uczenDao.updateBuilder();
        try {
            updateBuilder.where().eq("imie",stareImie);
            updateBuilder.where().eq("nazwisko",stareNazwisko);
            updateBuilder.where().eq("klasa",staraKlasa);
            updateBuilder.updateColumnValue("imie", noweImie);
            updateBuilder.updateColumnValue("nazwisko", noweNazwisko);
            updateBuilder.updateColumnValue("klasa", nowaKlasa);
            updateBuilder.update();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Log.e("AccountTableDB", accounts.get(0).getName());
    }

    public static void aktualizujDaneKontaUzytkownika(String staryLogine, String stareHaslo, String nowyLogin, String noweHaslo)
    {
        // Connect with Database ORM
        DatabaseAccessObjects dbHelper = OpenHelperManager.getHelper(null, DatabaseAccessObjects.class);
        RuntimeExceptionDao<Konto, Integer> kontoDao = dbHelper.getKontoRuntimeExceptionDao();
        UpdateBuilder<Konto,Integer> updateBuilder = kontoDao.updateBuilder();
        try {
            updateBuilder.where().eq("username",staryLogine);
            updateBuilder.where().eq("password",stareHaslo);
            updateBuilder.updateColumnValue("username", nowyLogin);
            updateBuilder.updateColumnValue("password", noweHaslo);
            updateBuilder.update();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Log.e("AccountTableDB", accounts.get(0).getName());
    }
}

