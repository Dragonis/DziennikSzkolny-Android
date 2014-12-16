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

        db.execSQL("CREATE TABLE IF NOT EXISTS student(rollno VARCHAR,name VARCHAR,marks VARCHAR);");
        db.execSQL("INSERT INTO student VALUES('Test','Test2','Test3');");

        c = db.rawQuery("SELECT * FROM student WHERE rollno='Test'", null);

        if(c.moveToFirst())
        {
            //Sprawdzanie bazy SQLite
            // Szczegoly: http://www.codeproject.com/Articles/783073/A-Simple-Android-SQLite-Example

//                Toast.makeText(getApplicationContext(), c.getString(0), Toast.LENGTH_LONG);
//                Toast.makeText(getApplicationContext(), c.getString(1), Toast.LENGTH_LONG);
//                Toast.makeText(getApplicationContext(), c.getString(2), Toast.LENGTH_LONG);
            Log.e(TAG, c.getString(0));
            Log.e(TAG, c.getString(1));
            Log.e(TAG, c.getString(2));

            db.close();

            Log.e(TAG, " Poprawne dzialanie Singletona BazoDanowego");
        }
    }


}