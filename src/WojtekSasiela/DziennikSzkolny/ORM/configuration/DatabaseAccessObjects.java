package WojtekSasiela.DziennikSzkolny.ORM.configuration;

/**
 * Created by Wojtek on 2015-02-05.
 */

import WojtekSasiela.DziennikSzkolny.ORM.Classroom;
import WojtekSasiela.DziennikSzkolny.ORM.StudentGrades;
import WojtekSasiela.DziennikSzkolny.ORM.Student_NewVersion;
import WojtekSasiela.DziennikSzkolny.ORM.Subcjet;
import WojtekSasiela.DziennikSzkolny.ORM.tables.Account;
import WojtekSasiela.DziennikSzkolny.ORM.tables.Student;
import WojtekSasiela.DziennikSzkolny.ORM.tables.Teacher;
import WojtekSasiela.DziennikSzkolny.ORM.tables.miary_statystyczne.*;
import WojtekSasiela.DziennikSzkolny.ORM.tables.subjects.*;
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
    private static final String DATABASE_NAME = "Accounts4144445141270124141254.db";
    private static final int DATABASE_VERSION = 1;

    private Dao<Classroom, Integer> ClassroomDao = null;
    private Dao<Student_NewVersion, Integer> Student_NewVersion_Dao = null;
    private Dao<StudentGrades, Integer> StudentGradesDao = null;
    private Dao<Subcjet, Integer> SubcjetDao = null;

    private Dao<Account, Integer> AccountDao = null;
    private Dao<Student, Integer> StudentDao = null;
    private Dao<Teacher, Integer> TeacherDao = null;

    private Dao<Biology, Integer> BiologyDao = null;
    private Dao<English, Integer> EnglishDao = null;
    private Dao<Mathematic, Integer> MathematicDao = null;
    private Dao<Polish, Integer> PolishDao = null;
    private Dao<Religion, Integer> ReligionDao = null;
    private Dao<WF, Integer> WFDao = null;

    private Dao<Srednia, Integer> SredniaDao = null;
    private Dao<Mediana, Integer> MedianaDao = null;
    private Dao<Dominanta, Integer> DominantaDao = null;
    private Dao<Kwartyle, Integer> KwartyleDao = null;
    private Dao<Odchylenie, Integer> OdchylenieDao = null;
    private Dao<Wariancja, Integer> WariancjaDao = null;

    private Dao<Ocena, Integer> OcenaDao = null;
    private Dao<Przedmiot, Integer> PrzedmiotDao = null;
    private Dao<Uczen, Integer> UczenDao = null;


    private RuntimeExceptionDao<Classroom, Integer> ClassroomRuntimeDao = null;
    private RuntimeExceptionDao<Student_NewVersion, Integer> Student_NewVersion_RuntimeDao = null;
    private RuntimeExceptionDao<StudentGrades, Integer> StudentGradesRuntimeDao = null;
    private RuntimeExceptionDao<Subcjet, Integer> SubcjetRuntimeDao = null;

    private RuntimeExceptionDao<Account, Integer> AccountRuntimeDao = null;
    private RuntimeExceptionDao<Student, Integer> StudentRuntimeDao = null;
    private RuntimeExceptionDao<Teacher, Integer> TeacherRuntimeDao = null;

    private RuntimeExceptionDao<Biology, Integer> BiologyRuntimeDao = null;
    private RuntimeExceptionDao<English, Integer> EnglishRuntimeDao = null;
    private RuntimeExceptionDao<Mathematic, Integer> MathematicRuntimeDao = null;
    private RuntimeExceptionDao<Polish, Integer> PolishRuntimeDao = null;
    private RuntimeExceptionDao<Religion, Integer> ReligionRuntimeDao = null;
    private RuntimeExceptionDao<WF, Integer> WFRuntimeDao = null;

    private RuntimeExceptionDao<Srednia, Integer> SredniaRuntimeDao = null;
    private RuntimeExceptionDao<Dominanta, Integer> DominantaRuntimeDao = null;
    private RuntimeExceptionDao<Kwartyle, Integer> KwartyleRuntimeDao = null;
    private RuntimeExceptionDao<Mediana, Integer> MedianaRuntimeDao = null;
    private RuntimeExceptionDao<Odchylenie, Integer> OdchylenieRuntimeDao = null;
    private RuntimeExceptionDao<Wariancja, Integer> WariancjaRuntimeDao = null;

    private RuntimeExceptionDao<Ocena, Integer> OcenaRuntimeDao = null;
    private RuntimeExceptionDao<Przedmiot, Integer> PrzedmiotRuntimeDao = null;
    private RuntimeExceptionDao<Uczen, Integer> UczenRuntimeDao = null;

    public DatabaseAccessObjects(Context context){
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

        TableUtils.createTable(connectionSource, Classroom.class);
        TableUtils.createTable(connectionSource, Student_NewVersion.class);
        TableUtils.createTable(connectionSource, StudentGrades.class);
        TableUtils.createTable(connectionSource, Subcjet.class);

        TableUtils.createTable(connectionSource, Account.class);
        TableUtils.createTable(connectionSource, Student.class);
        TableUtils.createTable(connectionSource, Teacher.class);

        TableUtils.createTable(connectionSource, Biology.class);
        TableUtils.createTable(connectionSource, English.class);
        TableUtils.createTable(connectionSource, Mathematic.class);
        TableUtils.createTable(connectionSource, Polish.class);
        TableUtils.createTable(connectionSource, Religion.class);
        TableUtils.createTable(connectionSource, WF.class);

        TableUtils.createTable(connectionSource, Srednia.class);
        TableUtils.createTable(connectionSource, Mediana.class);
        TableUtils.createTable(connectionSource, Dominanta.class);
        TableUtils.createTable(connectionSource, Wariancja.class);
        TableUtils.createTable(connectionSource, Odchylenie.class);
        TableUtils.createTable(connectionSource, Kwartyle.class);

        TableUtils.createTable(connectionSource, Ocena.class);
        TableUtils.createTable(connectionSource, Przedmiot.class);
        TableUtils.createTable(connectionSource, Uczen.class);
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

        TableUtils.dropTable(connectionSource, Classroom.class, true);
        TableUtils.dropTable(connectionSource, Student_NewVersion.class, true);
        TableUtils.dropTable(connectionSource, StudentGrades.class, true);
        TableUtils.dropTable(connectionSource, Subcjet.class, true);

        TableUtils.dropTable(connectionSource, Account.class, true);
        TableUtils.dropTable(connectionSource, Student.class, true);
        TableUtils.dropTable(connectionSource, Teacher.class, true);

        TableUtils.dropTable(connectionSource, Biology.class, true);
        TableUtils.dropTable(connectionSource, English.class, true);
        TableUtils.dropTable(connectionSource, Mathematic.class, true);
        TableUtils.dropTable(connectionSource, Polish.class, true);
        TableUtils.dropTable(connectionSource, Religion.class, true);
        TableUtils.dropTable(connectionSource, WF.class, true);

        TableUtils.dropTable(connectionSource, Srednia.class, true);
        TableUtils.dropTable(connectionSource, Mediana.class, true);
        TableUtils.dropTable(connectionSource, Dominanta.class, true);
        TableUtils.dropTable(connectionSource, Odchylenie.class, true);
        TableUtils.dropTable(connectionSource, Wariancja.class, true);
        TableUtils.dropTable(connectionSource, Kwartyle.class, true);

        TableUtils.dropTable(connectionSource, Ocena.class, true);
        TableUtils.dropTable(connectionSource, Przedmiot.class, true);
        TableUtils.dropTable(connectionSource, Uczen.class, true);
    }

    public Dao<Classroom, Integer> getClassroomDao() throws SQLException{
        if (ClassroomDao == null) {
            ClassroomDao = getDao(Classroom.class);
        }
        return ClassroomDao;
    }

    public Dao<Student_NewVersion, Integer> getStudent_NewVersion_Dao() throws SQLException{
        if (Student_NewVersion_Dao == null) {
            Student_NewVersion_Dao = getDao(Student_NewVersion.class);
        }
        return Student_NewVersion_Dao;
    }

    public Dao<StudentGrades, Integer> getStudentGradesDao() throws SQLException{
        if (StudentGradesDao == null) {
            StudentGradesDao = getDao(StudentGrades.class);
        }
        return StudentGradesDao;
    }

    public Dao<Subcjet, Integer> getSubcjetDao() throws SQLException{
        if (SubcjetDao == null) {
            SubcjetDao = getDao(Subcjet.class);
        }
        return SubcjetDao;
    }


    public Dao<Account, Integer> getAccountDao() throws SQLException{
        if (AccountDao == null) {
            AccountDao = getDao(Account.class);
        }
        return AccountDao;
    }


    public Dao<Student, Integer> getStudentDao() throws SQLException{
        if (StudentDao == null) {
            StudentDao = getDao(Student.class);
        }
        return StudentDao;
    }

    public Dao<Teacher, Integer> getTeacherDao() throws SQLException{
        if (TeacherDao == null) {
            TeacherDao = getDao(Teacher.class);
        }
        return TeacherDao;
    }

    public Dao<Biology, Integer> getBiologyDao() throws SQLException{
        if (BiologyDao == null) {
            BiologyDao = getDao(Biology.class);
        }
        return BiologyDao;
    }

    public Dao<English, Integer> getEnglishDao() throws SQLException{
        if (EnglishDao == null) {
            EnglishDao = getDao(English.class);
        }
        return EnglishDao;
    }

    public Dao<Mathematic, Integer> getMathematicDao() throws SQLException{
        if (MathematicDao == null) {
            MathematicDao = getDao(Mathematic.class);
        }
        return MathematicDao;
    }

    public Dao<Polish, Integer> getPolishDao() throws SQLException{
        if (PolishDao == null) {
            PolishDao = getDao(Polish.class);
        }
        return PolishDao;
    }

    public Dao<Religion, Integer> getReligionDao() throws SQLException{
        if (ReligionDao == null) {
            ReligionDao = getDao(Religion.class);
        }
        return ReligionDao;
    }

    public Dao<WF, Integer> getWFDao() throws SQLException{
        if (WFDao == null) {
            WFDao = getDao(WF.class);
        }
        return WFDao;
    }

    public Dao<Srednia, Integer> getSredniaDao() throws SQLException{
        if (SredniaDao == null) {
            SredniaDao = getDao(Srednia.class);
        }
        return SredniaDao;
    }

    public Dao<Mediana, Integer> getMedianaDao() throws SQLException{
        if (MedianaDao == null) {
            MedianaDao = getDao(Mediana.class);
        }
        return MedianaDao;
    }

    public Dao<Dominanta, Integer> getDominantaDao() throws SQLException{
        if (DominantaDao == null) {
            DominantaDao = getDao(Dominanta.class);
        }
        return DominantaDao;
    }

    public Dao<Kwartyle, Integer> getKwartyleDao() throws SQLException{
        if (KwartyleDao == null) {
            KwartyleDao = getDao(Kwartyle.class);
        }
        return KwartyleDao;
    }

    public Dao<Odchylenie, Integer> getOdchylenieDao() throws SQLException{
        if (OdchylenieDao == null) {
            OdchylenieDao = getDao(Odchylenie.class);
        }
        return OdchylenieDao;
    }

    public Dao<Wariancja, Integer> getWariancjaDao() throws SQLException{
        if (WariancjaDao == null) {
            WariancjaDao = getDao(Wariancja.class);
        }
        return WariancjaDao;
    }

    public Dao<Ocena, Integer> getOcenaDao() throws SQLException{
        if (OcenaDao == null) {
            OcenaDao = getDao(Ocena.class);
        }
        return OcenaDao;
    }

    public Dao<Przedmiot, Integer> getPrzedmiotDao() throws SQLException{
        if (PrzedmiotDao == null) {
            PrzedmiotDao = getDao(Przedmiot.class);
        }
        return PrzedmiotDao;
    }

    public Dao<Uczen, Integer> getUczenDao() throws SQLException{
        if (UczenDao == null) {
            UczenDao = getDao(Uczen.class);
        }
        return UczenDao;
    }

    public RuntimeExceptionDao<Classroom, Integer> getClassroomRuntimeExceptionDao(){
        if (ClassroomRuntimeDao == null) {
            ClassroomRuntimeDao = getRuntimeExceptionDao(Classroom.class);
        }
        return ClassroomRuntimeDao;
    }

    public RuntimeExceptionDao<Student_NewVersion, Integer> getStudent_NewVersion_RuntimeExceptionDao(){
        if (Student_NewVersion_RuntimeDao == null) {
            Student_NewVersion_RuntimeDao = getRuntimeExceptionDao(Student_NewVersion.class);
        }
        return Student_NewVersion_RuntimeDao;
    }

    public RuntimeExceptionDao<StudentGrades, Integer> getStudentGradesRuntimeExceptionDao(){
        if (StudentGradesRuntimeDao == null) {
            StudentGradesRuntimeDao = getRuntimeExceptionDao(StudentGrades.class);
        }
        return StudentGradesRuntimeDao;
    }

    public RuntimeExceptionDao<Subcjet, Integer> getSubcjetRuntimeExceptionDao(){
        if (SubcjetRuntimeDao == null) {
            SubcjetRuntimeDao = getRuntimeExceptionDao(Subcjet.class);
        }
        return SubcjetRuntimeDao;
    }

    public RuntimeExceptionDao<Account, Integer> getAccountRuntimeExceptionDao(){
        if (AccountRuntimeDao == null) {
            AccountRuntimeDao = getRuntimeExceptionDao(Account.class);
        }
        return AccountRuntimeDao;
    }
    public RuntimeExceptionDao<Student, Integer> getStudentRuntimeExceptionDao(){
        if (StudentRuntimeDao == null) {
            StudentRuntimeDao = getRuntimeExceptionDao(Student.class);
        }
        return StudentRuntimeDao;
    }
    public RuntimeExceptionDao<Teacher, Integer> getTeacherRuntimeExceptionDao(){
        if (TeacherRuntimeDao == null) {
            TeacherRuntimeDao = getRuntimeExceptionDao(Teacher.class);
        }
        return TeacherRuntimeDao;
    }
    public RuntimeExceptionDao<Biology, Integer> getBiologyRuntimeExceptionDao(){
        if (BiologyRuntimeDao == null) {
            BiologyRuntimeDao = getRuntimeExceptionDao(Biology.class);
        }
        return BiologyRuntimeDao;
    }
    public RuntimeExceptionDao<English, Integer> getEnglishRuntimeExceptionDao(){
        if (EnglishRuntimeDao == null) {
            EnglishRuntimeDao = getRuntimeExceptionDao(English.class);
        }
        return EnglishRuntimeDao;
    }
    public RuntimeExceptionDao<Mathematic, Integer> getMathematicRuntimeExceptionDao(){
        if (MathematicRuntimeDao == null) {
            MathematicRuntimeDao = getRuntimeExceptionDao(Mathematic.class);
        }
        return MathematicRuntimeDao;
    }
    public RuntimeExceptionDao<Polish, Integer> getPolishRuntimeExceptionDao(){
        if (PolishRuntimeDao == null) {
            PolishRuntimeDao = getRuntimeExceptionDao(Polish.class);
        }
        return PolishRuntimeDao;
    }
    public RuntimeExceptionDao<Religion, Integer> getReligionRuntimeExceptionDao(){
        if (ReligionRuntimeDao == null) {
            ReligionRuntimeDao = getRuntimeExceptionDao(Religion.class);
        }
        return ReligionRuntimeDao;
    }
    public RuntimeExceptionDao<WF, Integer> getWFRuntimeExceptionDao(){
        if (WFRuntimeDao == null) {
            WFRuntimeDao = getRuntimeExceptionDao(WF.class);
        }
        return WFRuntimeDao;
    }
    public RuntimeExceptionDao<Srednia, Integer> getSredniaRuntimeExceptionDao(){
        if (SredniaRuntimeDao == null) {
            SredniaRuntimeDao = getRuntimeExceptionDao(Srednia.class);
        }
        return SredniaRuntimeDao;
    }
    public RuntimeExceptionDao<Dominanta, Integer> getDominantaRuntimeExceptionDao(){
        if (DominantaRuntimeDao == null) {
            DominantaRuntimeDao = getRuntimeExceptionDao(Dominanta.class);
        }
        return DominantaRuntimeDao;
    }
    public RuntimeExceptionDao<Kwartyle, Integer> getKwartyleRuntimeExceptionDao(){
        if (KwartyleRuntimeDao == null) {
            KwartyleRuntimeDao = getRuntimeExceptionDao(Kwartyle.class);
        }
        return KwartyleRuntimeDao;
    }
    public RuntimeExceptionDao<Mediana, Integer> getMedianaRuntimeExceptionDao(){
        if (MedianaRuntimeDao == null) {
            MedianaRuntimeDao = getRuntimeExceptionDao(Mediana.class);
        }
        return MedianaRuntimeDao;
    }
    public RuntimeExceptionDao<Odchylenie, Integer> getOdchylenieRuntimeExceptionDao(){
        if (OdchylenieRuntimeDao == null) {
            OdchylenieRuntimeDao = getRuntimeExceptionDao(Odchylenie.class);
        }
        return OdchylenieRuntimeDao;
    }
    public RuntimeExceptionDao<Wariancja, Integer> getWariancjaRuntimeExceptionDao(){
        if (WariancjaRuntimeDao == null) {
            WariancjaRuntimeDao = getRuntimeExceptionDao(Wariancja.class);
        }
        return WariancjaRuntimeDao;
    }

    public RuntimeExceptionDao<Ocena, Integer> getOcenaRuntimeExceptionDao(){
        if (OcenaRuntimeDao == null) {
            OcenaRuntimeDao = getRuntimeExceptionDao(Ocena.class);
        }
        return OcenaRuntimeDao;
    }

    public RuntimeExceptionDao<Przedmiot, Integer> getPrzedmiotRuntimeExceptionDao(){
        if (PrzedmiotRuntimeDao == null) {
            PrzedmiotRuntimeDao = getRuntimeExceptionDao(Przedmiot.class);
        }
        return PrzedmiotRuntimeDao;
    }

    public RuntimeExceptionDao<Uczen, Integer> getUczenRuntimeExceptionDao(){
        if (UczenRuntimeDao == null) {
            UczenRuntimeDao = getRuntimeExceptionDao(Uczen.class);
        }
        return UczenRuntimeDao;
    }
}
