package WojtekSasiela.DziennikSzkolny.Activity;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

class Database extends SQLiteOpenHelper
{

    SQLiteDatabase db = null;
    String TAG = "DziennikSzkolny";
    Cursor c = null;


    public Database(Context context, String databaseName, int databaseVersion) {
        super(context, databaseName, null, databaseVersion);
        // TODO Auto-generated constructor stub
    }

    public void getAllData()
    {
        zapelnijTabeleDanymi();
        wyswietlListeUczniowzKlasy(1);

        db.close();
    }
    public void stworzTabeleWBazie()
    {
        // Tworzenie tabeli uczen, i jego CRUD
        db.execSQL("CREATE TABLE uczen(id VARCHAR,imie VARCHAR,nazwisko VARCHAR, klasa VARCHAR, polski VARCHAR, angielski VARCHAR, matematyka VARCHAR, przyroda VARCHAR);");
        db.execSQL("CREATE TABLE nauczyciel(id VARCHAR, imie VARCHAR, nazwisko VARCHAR, przedmiot VARCHAR, zarobki VARCHAR);");
        db.execSQL("CREATE TABLE klasa(id VARCHAR,wychowawca VARCHAR);");
        db.execSQL("CREATE TABLE matematyka(id VARCHAR,nauczyciel VARCHAR, ocena1 VARCHAR, ocena2 VARCHAR, ocena3 VARCHAR);");
        db.execSQL("CREATE TABLE przyroda(id VARCHAR,nauczyciel VARCHAR, ocena1 VARCHAR, ocena2 VARCHAR, ocena3 VARCHAR);");
        db.execSQL("CREATE TABLE polski(id VARCHAR,nauczyciel VARCHAR, ocena1 VARCHAR, ocena2 VARCHAR, ocena3 VARCHAR);");
        db.execSQL("CREATE TABLE angielski(id VARCHAR,nauczyciel VARCHAR, ocena1 VARCHAR, ocena2 VARCHAR, ocena3 VARCHAR);");
        db.execSQL("CREATE TABLE przedmioty(id VARCHAR,nazwa VARCHAR,nauczyciel VARCHAR,zarobki VARCHAR);");
    }

    public void zapelnijTabeleDanymi()
    {
        // UCZNIOWIE
        // id, imie,nazwisko,klasa,oceny
        db.execSQL("INSERT INTO uczen VALUES('1','Jan','Kowalski','1','3','3','3','3');");
        db.execSQL("INSERT INTO uczen VALUES('2','Adrian','Wisniewski','1','3','3','3','3');");
        db.execSQL("INSERT INTO uczen VALUES('3','Marian','Prostacki','1','3','3','3','3');");

        // NAUCZYCIELE
        db.execSQL("INSERT INTO nauczyciel VALUES('1','Basia','Karyta','Angielski','2200');");
        db.execSQL("INSERT INTO nauczyciel VALUES('2','Anna','Biała','Polski','1800');");

        // PRZYDZIELONA KLASA
        db.execSQL("INSERT INTO klasa VALUES('1','2');");
    }

    public void wyswietlListeUczniowzKlasy(int nrKlasy)
    {
        for (int i=0;i<=3;i++) {
            c = db.rawQuery("SELECT * FROM uczen WHERE klasa='" + nrKlasy + "' and id='" + i + "'", null);
            if(c.moveToFirst())
            {
                Log.e(TAG, "1 klasa: " + c.getString(0) + " " + c.getString(1) + " " + c.getString(2));
            }
        }
    }

    public void wstawOceneUczniowi(String przedmiot, String uczen, int ocena)
    {
        //  c = db.rawQuery("INSERT INTO p.ocena1 WHERE p.id = u.polski FROM uczen u INNER JOIN polski p on u.polski", null);
    }

    public void usunOcene(String przedmiot, int nrOceny)
    {
        //  c = db.rawQuery("DELETE FROM uczen u WHERE u.polski = " + nrOceny, null);
    }

    public void wyswietlWszystkieNazwyPrzedmiotow()
    {
        for (int i=0;i<=3;i++) {
            c = db.rawQuery("SELECT nazwa FROM Przedmioty", null);
            if(c.moveToFirst())
            {
                Log.e(TAG, "Nazwa przedmiotu: " + c.getString(0) );
            }
        }
    }

    public void wyswietlZarobkinauczyciela(int idNauczyciela)
    {
        c = db.rawQuery("SELECT zarobki FROM Przedmioty p INNER JOIN nauczyciel n where p.id = n.id ", null);
        Log.e(TAG, "Zarobki nauczyciela: " + c.getString(0) );
    }

    public void wyswietlWszystkieOcenyucznia(int idUcznia,String przedmiot)
    {

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        stworzTabeleWBazie();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        db.execSQL("DROP TABLE uczen");
        db.execSQL("DROP TABLE nauczyciel");
        db.execSQL("DROP TABLE klasa");
        db.execSQL("DROP TABLE matematyka");
        db.execSQL("DROP TABLE przyroda");
        db.execSQL("DROP TABLE polski");
        db.execSQL("DROP TABLE angielski");
        db.execSQL("DROP TABLE przedmioty");

    }

    // DODATKOWO TRZXEBA ZAIMPLEMENTOWAC JESZCZE METODY STATYSTYCZNE

}