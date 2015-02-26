package WojtekSasiela.DziennikSzkolny.ORM.configuration;

/**
 * Created by Wojtek on 2015-02-05.
 */

import WojtekSasiela.DziennikSzkolny.ORM.tables.Account;
import WojtekSasiela.DziennikSzkolny.R;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;


public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "Accounts.db";
    private static final int DATABASE_VERSION = 1;
    private Dao<Account, Integer> AccountDao = null;
    private RuntimeExceptionDao<Account, Integer> AccountRuntimeDao = null;

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
    }

    @Override
    public void onCreate(SQLiteDatabase database,
                         ConnectionSource connectionSource) {
        // TODO Auto-generated method stub
        try {
            TableUtils.createTable(connectionSource, Account.class);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase database,
                          ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, Account.class, true);
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    public Dao<Account, Integer> getAccountDao() throws SQLException{
        if (AccountDao == null) {
            AccountDao = getDao(Account.class);
        }
        return AccountDao;
    }

    public RuntimeExceptionDao<Account, Integer> getAccountRuntimeExceptionDao() throws SQLException{
        if (AccountRuntimeDao == null) {
            AccountRuntimeDao = getRuntimeExceptionDao(Account.class);
        }
        return AccountRuntimeDao;
    }
}
