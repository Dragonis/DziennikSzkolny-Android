package WojtekSasiela.DziennikSzkolny.ORM.CRUD.DELETE;

import WojtekSasiela.DziennikSzkolny.ORM.configuration.DatabaseAccessObjects;
import WojtekSasiela.DziennikSzkolny.ORM.tables.Account;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.DeleteBuilder;
import java.sql.SQLException;

/**
 * Created by Wojtek on 2015-07-06.
 */
public class DeleteDataFromDatabase {

    public static void usunDaneUzytkownika(int ID_modyfiuk_Uzytkownika)
    {
        // Connect with Database ORM
        DatabaseAccessObjects dbHelper = OpenHelperManager.getHelper(null, DatabaseAccessObjects.class);
        RuntimeExceptionDao<Account, Integer> accountDao = dbHelper.getAccountRuntimeExceptionDao();
        DeleteBuilder<Account,Integer> deleteBuilder = accountDao.deleteBuilder();
        try {

            deleteBuilder.where().eq("id", ID_modyfiuk_Uzytkownika);
            deleteBuilder.delete();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
