package WojtekSasiela.DziennikSzkolny;


import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

class Database
{
    Database() {
    }

    SQLiteDatabase db = null;

    public void getAllData()
    {
        String TAG = "DziennikSzkolny";
        Cursor c = null;
        
        db.execSQL("DROP TABLE uczen");
        db.execSQL("DROP TABLE nauczyciel");
        db.execSQL("DROP TABLE klasa");

        //db.execSQL("CREATE TABLE student(rollno VARCHAR,name VARCHAR,marks VARCHAR);");
        // Tworzenie tabeli uczen, i jego CRUD
        db.execSQL("CREATE TABLE IF NOT EXISTS uczen(id VARCHAR,imie VARCHAR,nazwisko VARCHAR, klasa VARCHAR, oceny VARCHAR);");
        db.execSQL("CREATE TABLE IF NOT EXISTS nauczyciel(id VARCHAR, imie VARCHAR, nazwisko VARCHAR, przedmiot VARCHAR, zarobki VARCHAR);");
        db.execSQL("CREATE TABLE IF NOT EXISTS klasa(id VARCHAR,wychowawca VARCHAR);");

        // UCZNIOWIE
        // id, imie,nazwisko,klasa,oceny
        db.execSQL("INSERT INTO uczen VALUES('1','Jan','Kowalski','1','3');");
        db.execSQL("INSERT INTO uczen VALUES('2','Adrian','Wisniewski','1','3');");
        db.execSQL("INSERT INTO uczen VALUES('3','Marian','Prostacki','1','3');");

        // NAUCZYCIELE
        db.execSQL("INSERT INTO nauczyciel VALUES('1','Basia','Karyta','Angielski','2200');");
        db.execSQL("INSERT INTO nauczyciel VALUES('2','Anna','Biała','Polski','1800');");

        // PRZYDZIELONA KLASA
        db.execSQL("INSERT INTO klasa VALUES('1','2');");

        for (int i=0;i<=5;i++) {
            c = db.rawQuery("SELECT * FROM uczen WHERE klasa='" + 1 + "' and id='" + i + "'", null);
            if(c.moveToFirst())
            {
                Log.e(TAG, "1 klasa: " + c.getString(0) + " " + c.getString(1) + " " + c.getString(2));
            }
        }
        db.close();
    }


}