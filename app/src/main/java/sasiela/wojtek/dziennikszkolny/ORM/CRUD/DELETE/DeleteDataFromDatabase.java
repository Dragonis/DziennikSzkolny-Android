package sasiela.wojtek.dziennikszkolny.ORM.CRUD.DELETE;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.sql.SQLException;

import sasiela.wojtek.dziennikszkolny.ORM.configuration.DatabaseAccessObjects;
import sasiela.wojtek.dziennikszkolny.ORM.tables.new_version_database.Uczen;

/**
 * Created by Wojtek on 2015-07-06.
 */
public class DeleteDataFromDatabase {


    public static void usunUcznia(String imie, String nazwisko)
    {
        // Connect with Database ORM
        DatabaseAccessObjects dbHelper = OpenHelperManager.getHelper(null, DatabaseAccessObjects.class);
        RuntimeExceptionDao<Uczen, Integer> uczenDao = dbHelper.getUczenRuntimeExceptionDao();
        DeleteBuilder<Uczen,Integer> uczenDeleteBuilder = uczenDao.deleteBuilder();
        try {

            uczenDeleteBuilder.where().eq("imie", imie).and().eq("nazwisko",nazwisko);
            uczenDeleteBuilder.delete();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
