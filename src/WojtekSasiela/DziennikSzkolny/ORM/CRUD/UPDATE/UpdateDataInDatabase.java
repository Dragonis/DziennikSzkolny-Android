package WojtekSasiela.DziennikSzkolny.ORM.CRUD.UPDATE;

import WojtekSasiela.DziennikSzkolny.ORM.configuration.DatabaseAccessObjects;
import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.stmt.UpdateBuilder;

import java.sql.SQLException;

/**
 * Created by Wojtek on 2015-07-05.
 */
public class UpdateDataInDatabase {

    public static void aktualizujDaneUzytkownika(int ID_modyfiuk_Uzytkownika, String nowy_login, String nowe_haslo)
    {
//        // Connect with Database ORM
//        DatabaseAccessObjects dbHelper = OpenHelperManager.getHelper(null, DatabaseAccessObjects.class);
//        RuntimeExceptionDao<Account, Integer> accountDao = dbHelper.getAccountRuntimeExceptionDao();
//        UpdateBuilder<Account,Integer> updateBuilder = accountDao.updateBuilder();
//        try {
//            updateBuilder.where().eq("id",ID_modyfiuk_Uzytkownika);
//            updateBuilder.updateColumnValue("username", nowy_login);
//            updateBuilder.updateColumnValue("password", nowe_haslo);
//            updateBuilder.update();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        //Log.e("AccountTableDB", accounts.get(0).getName());
    }
}

