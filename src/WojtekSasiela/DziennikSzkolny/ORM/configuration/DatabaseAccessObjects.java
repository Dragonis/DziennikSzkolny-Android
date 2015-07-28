package WojtekSasiela.DziennikSzkolny.ORM.configuration;

/**
 * Created by Wojtek on 2015-02-05.
 */

import WojtekSasiela.DziennikSzkolny.ORM.tables.Student;
import WojtekSasiela.DziennikSzkolny.ORM.tables.new_version_database.*;
import WojtekSasiela.DziennikSzkolny.R;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;


public class DatabaseAccessObjects extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "Accounts414444514124703175234774544141254.db";
    private static final int DATABASE_VERSION = 1;

    private Dao<Student, Integer> StudentDao = null;

    private Dao<Ocena, Integer> OcenaDao = null;
    private Dao<Przedmiot, Integer> PrzedmiotDao = null;
    private Dao<Uczen, Integer> UczenDao = null;
    private Dao<Konto, Integer> KontoDao = null;


    private RuntimeExceptionDao<Student, Integer> StudentRuntimeDao = null;

    private RuntimeExceptionDao<Ocena, Integer> OcenaRuntimeDao = null;
    private RuntimeExceptionDao<Przedmiot, Integer> PrzedmiotRuntimeDao = null;
    private RuntimeExceptionDao<Uczen, Integer> UczenRuntimeDao = null;
    private RuntimeExceptionDao<Konto, Integer> KontoRuntimeDao = null;

    public DatabaseAccessObjects(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION, R.raw.ormlite_config);
    }

    @Override
    public void onCreate(SQLiteDatabase database,
                         ConnectionSource connectionSource) {

        try {
            dodajWszystkieTabele(connectionSource);
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    private void dodajWszystkieTabele(ConnectionSource connectionSource) throws SQLException {

        TableUtils.createTable(connectionSource, Student.class);

        TableUtils.createTable(connectionSource, Ocena.class);
        TableUtils.createTable(connectionSource, Przedmiot.class);
        TableUtils.createTable(connectionSource, Uczen.class);
        TableUtils.createTable(connectionSource, Konto.class);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database,
                          ConnectionSource connectionSource, int oldVersion, int newVersion) {

        // onUpgrade czyli jak jest 2 raz uruchamiana aplikacja i ma modyfikowac dane z poprzedniego uruchomienia
        try {
            usunWszystkieTabele(connectionSource);
            onCreate(database, connectionSource);
        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    private void usunWszystkieTabele(ConnectionSource connectionSource) throws SQLException {

        TableUtils.dropTable(connectionSource, Student.class, true);

        TableUtils.dropTable(connectionSource, Ocena.class, true);
        TableUtils.dropTable(connectionSource, Przedmiot.class, true);
        TableUtils.dropTable(connectionSource, Uczen.class, true);
        TableUtils.dropTable(connectionSource, Konto.class, true);
    }



    public Dao<Student, Integer> getStudentDao() throws SQLException {
        if (StudentDao == null) {
            StudentDao = getDao(Student.class);
        }
        return StudentDao;
    }



    public Dao<Ocena, Integer> getOcenaDao() throws SQLException {
        if (OcenaDao == null) {
            OcenaDao = getDao(Ocena.class);
        }
        return OcenaDao;
    }

    public Dao<Przedmiot, Integer> getPrzedmiotDao() throws SQLException {
        if (PrzedmiotDao == null) {
            PrzedmiotDao = getDao(Przedmiot.class);
        }
        return PrzedmiotDao;
    }

    public Dao<Uczen, Integer> getUczenDao() throws SQLException {
        if (UczenDao == null) {
            UczenDao = getDao(Uczen.class);
        }
        return UczenDao;
    }

    public Dao<Konto, Integer> getKontoDao() throws SQLException {
        if (KontoDao == null) {
            KontoDao = getDao(Konto.class);
        }
        return KontoDao;
    }


    public RuntimeExceptionDao<Student, Integer> getStudentRuntimeExceptionDao() {
        if (StudentRuntimeDao == null) {
            StudentRuntimeDao = getRuntimeExceptionDao(Student.class);
        }
        return StudentRuntimeDao;
    }



    public RuntimeExceptionDao<Ocena, Integer> getOcenaRuntimeExceptionDao() {
        if (OcenaRuntimeDao == null) {
            OcenaRuntimeDao = getRuntimeExceptionDao(Ocena.class);
        }
        return OcenaRuntimeDao;
    }

    public RuntimeExceptionDao<Przedmiot, Integer> getPrzedmiotRuntimeExceptionDao() {
        if (PrzedmiotRuntimeDao == null) {
            PrzedmiotRuntimeDao = getRuntimeExceptionDao(Przedmiot.class);
        }
        return PrzedmiotRuntimeDao;
    }

    public RuntimeExceptionDao<Uczen, Integer> getUczenRuntimeExceptionDao() {
        if (UczenRuntimeDao == null) {
            UczenRuntimeDao = getRuntimeExceptionDao(Uczen.class);
        }
        return UczenRuntimeDao;
    }

    public RuntimeExceptionDao<Konto, Integer> getKontoRuntimeExceptionDao() {
        if (KontoRuntimeDao == null) {
            KontoRuntimeDao = getRuntimeExceptionDao(Konto.class);
        }
        return KontoRuntimeDao;
    }

}


