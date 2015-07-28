package WojtekSasiela.DziennikSzkolny.ORM.configuration;

/**
 * Created by Wojtek on 2015-02-05.
 */

import WojtekSasiela.DziennikSzkolny.ORM.tables.Account;
import WojtekSasiela.DziennikSzkolny.ORM.tables.Student;
import WojtekSasiela.DziennikSzkolny.ORM.tables.miary_statystyczne.*;
import WojtekSasiela.DziennikSzkolny.ORM.tables.new_version_database.*;
import WojtekSasiela.DziennikSzkolny.R;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.io.IOException;
import java.sql.SQLException;


public class DatabaseAccessObjects extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "Accounts41444451412703175234774544141254.db";
    private static final int DATABASE_VERSION = 1;

    private Dao<Account, Integer> AccountDao = null;
    private Dao<Student, Integer> StudentDao = null;

    private Dao<Srednia, Integer> SredniaDao = null;
    private Dao<Mediana, Integer> MedianaDao = null;
    private Dao<Dominanta, Integer> DominantaDao = null;
    private Dao<Kwartyle, Integer> KwartyleDao = null;
    private Dao<Odchylenie, Integer> OdchylenieDao = null;
    private Dao<Wariancja, Integer> WariancjaDao = null;

    private Dao<Ocena, Integer> OcenaDao = null;
    private Dao<Przedmiot, Integer> PrzedmiotDao = null;
    private Dao<Uczen, Integer> UczenDao = null;
    private Dao<Konto, Integer> KontoDao = null;


    private RuntimeExceptionDao<Account, Integer> AccountRuntimeDao = null;
    private RuntimeExceptionDao<Student, Integer> StudentRuntimeDao = null;

    private RuntimeExceptionDao<Srednia, Integer> SredniaRuntimeDao = null;
    private RuntimeExceptionDao<Dominanta, Integer> DominantaRuntimeDao = null;
    private RuntimeExceptionDao<Kwartyle, Integer> KwartyleRuntimeDao = null;
    private RuntimeExceptionDao<Mediana, Integer> MedianaRuntimeDao = null;
    private RuntimeExceptionDao<Odchylenie, Integer> OdchylenieRuntimeDao = null;
    private RuntimeExceptionDao<Wariancja, Integer> WariancjaRuntimeDao = null;

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

        TableUtils.createTable(connectionSource, Account.class);
        TableUtils.createTable(connectionSource, Student.class);

        TableUtils.createTable(connectionSource, Srednia.class);
        TableUtils.createTable(connectionSource, Mediana.class);
        TableUtils.createTable(connectionSource, Dominanta.class);
        TableUtils.createTable(connectionSource, Wariancja.class);
        TableUtils.createTable(connectionSource, Odchylenie.class);
        TableUtils.createTable(connectionSource, Kwartyle.class);

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

        TableUtils.dropTable(connectionSource, Account.class, true);
        TableUtils.dropTable(connectionSource, Student.class, true);

        TableUtils.dropTable(connectionSource, Srednia.class, true);
        TableUtils.dropTable(connectionSource, Mediana.class, true);
        TableUtils.dropTable(connectionSource, Dominanta.class, true);
        TableUtils.dropTable(connectionSource, Odchylenie.class, true);
        TableUtils.dropTable(connectionSource, Wariancja.class, true);
        TableUtils.dropTable(connectionSource, Kwartyle.class, true);

        TableUtils.dropTable(connectionSource, Ocena.class, true);
        TableUtils.dropTable(connectionSource, Przedmiot.class, true);
        TableUtils.dropTable(connectionSource, Uczen.class, true);
        TableUtils.dropTable(connectionSource, Konto.class, true);
    }


    public Dao<Account, Integer> getAccountDao() throws SQLException {
        if (AccountDao == null) {
            AccountDao = getDao(Account.class);
        }
        return AccountDao;
    }


    public Dao<Student, Integer> getStudentDao() throws SQLException {
        if (StudentDao == null) {
            StudentDao = getDao(Student.class);
        }
        return StudentDao;
    }

    public Dao<Srednia, Integer> getSredniaDao() throws SQLException {
        if (SredniaDao == null) {
            SredniaDao = getDao(Srednia.class);
        }
        return SredniaDao;
    }

    public Dao<Mediana, Integer> getMedianaDao() throws SQLException {
        if (MedianaDao == null) {
            MedianaDao = getDao(Mediana.class);
        }
        return MedianaDao;
    }

    public Dao<Dominanta, Integer> getDominantaDao() throws SQLException {
        if (DominantaDao == null) {
            DominantaDao = getDao(Dominanta.class);
        }
        return DominantaDao;
    }

    public Dao<Kwartyle, Integer> getKwartyleDao() throws SQLException {
        if (KwartyleDao == null) {
            KwartyleDao = getDao(Kwartyle.class);
        }
        return KwartyleDao;
    }

    public Dao<Odchylenie, Integer> getOdchylenieDao() throws SQLException {
        if (OdchylenieDao == null) {
            OdchylenieDao = getDao(Odchylenie.class);
        }
        return OdchylenieDao;
    }

    public Dao<Wariancja, Integer> getWariancjaDao() throws SQLException {
        if (WariancjaDao == null) {
            WariancjaDao = getDao(Wariancja.class);
        }
        return WariancjaDao;
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

    public RuntimeExceptionDao<Account, Integer> getAccountRuntimeExceptionDao() {
        if (AccountRuntimeDao == null) {
            AccountRuntimeDao = getRuntimeExceptionDao(Account.class);
        }
        return AccountRuntimeDao;
    }

    public RuntimeExceptionDao<Student, Integer> getStudentRuntimeExceptionDao() {
        if (StudentRuntimeDao == null) {
            StudentRuntimeDao = getRuntimeExceptionDao(Student.class);
        }
        return StudentRuntimeDao;
    }

    public RuntimeExceptionDao<Srednia, Integer> getSredniaRuntimeExceptionDao() {
        if (SredniaRuntimeDao == null) {
            SredniaRuntimeDao = getRuntimeExceptionDao(Srednia.class);
        }
        return SredniaRuntimeDao;
    }

    public RuntimeExceptionDao<Dominanta, Integer> getDominantaRuntimeExceptionDao() {
        if (DominantaRuntimeDao == null) {
            DominantaRuntimeDao = getRuntimeExceptionDao(Dominanta.class);
        }
        return DominantaRuntimeDao;
    }

    public RuntimeExceptionDao<Kwartyle, Integer> getKwartyleRuntimeExceptionDao() {
        if (KwartyleRuntimeDao == null) {
            KwartyleRuntimeDao = getRuntimeExceptionDao(Kwartyle.class);
        }
        return KwartyleRuntimeDao;
    }

    public RuntimeExceptionDao<Mediana, Integer> getMedianaRuntimeExceptionDao() {
        if (MedianaRuntimeDao == null) {
            MedianaRuntimeDao = getRuntimeExceptionDao(Mediana.class);
        }
        return MedianaRuntimeDao;
    }

    public RuntimeExceptionDao<Odchylenie, Integer> getOdchylenieRuntimeExceptionDao() {
        if (OdchylenieRuntimeDao == null) {
            OdchylenieRuntimeDao = getRuntimeExceptionDao(Odchylenie.class);
        }
        return OdchylenieRuntimeDao;
    }

    public RuntimeExceptionDao<Wariancja, Integer> getWariancjaRuntimeExceptionDao() {
        if (WariancjaRuntimeDao == null) {
            WariancjaRuntimeDao = getRuntimeExceptionDao(Wariancja.class);
        }
        return WariancjaRuntimeDao;
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


