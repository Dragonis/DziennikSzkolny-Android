package WojtekSasiela.DziennikSzkolny;

import WojtekSasiela.DziennikSzkolny.ORM.CRUD.READ.LoadDataFromDatabase;
import WojtekSasiela.DziennikSzkolny.ORM.StudentGrades;
import WojtekSasiela.DziennikSzkolny.ORM.configuration.DatabaseAccessObjects;
import android.widget.TextView;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.Toast;
import WojtekSasiela.DziennikSzkolny.ORM.tables.Student;
import WojtekSasiela.DziennikSzkolny.ORM.StudentGrades;
import WojtekSasiela.DziennikSzkolny.ORM.configuration.DatabaseAccessObjects;

import java.util.List;

/**
 * Created by Wojtek on 2015-07-08.
 */
public class LogowanieActivityTest extends ActivityInstrumentationTestCase2<LogowanieActivity> {

    LogowanieActivity logowanie_activity;
    TextView login_textview;
    private Button zaloguj_button;
    private Button wprowadz_baze_button;

    public LogowanieActivityTest() {
        super(LogowanieActivity.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        logowanie_activity = getActivity();
        login_textview = (TextView) logowanie_activity.findViewById(R.id.loginTextView);
        zaloguj_button = (Button) logowanie_activity.findViewById(R.id.zaloguj_button_logowanie);
        wprowadz_baze_button = (Button) logowanie_activity.findViewById(R.id.przykladowabazaDanychButton);
    }

    public void testActivityExists()
    {
        assertNotNull(logowanie_activity);
    }

    public void testLoginTextViewExists()
    {
        assertNotNull(login_textview);
    }

    public void testEnterTextIntoTheInput()
    {
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                login_textview.requestFocus();
            }
        });

        getInstrumentation().waitForIdleSync();
        getInstrumentation().sendStringSync("root");
    }

    public void testVertifyTheMessage_DoesLoginIsRoot()
    {
        TextView greetMessage = (TextView) logowanie_activity.findViewById(R.id.loginTextView);

        String actualText = greetMessage.getText().toString();
        assertEquals("root", actualText);

//        This code does the following:
//
//    Gets the TextView element by its ID message_text_view.
//        Obtains the text of the TextView element by calling getText method.
//            Calls assertEquals to compare the expected message "Hello, Jake!" with the actual message from the TextView.


//    This is what this code does:
//
//    Selects the text input by calling nameEditText.requestFocus() in the main thread of the app.
//            Waits for application to be idle: waitForIdleSync().
//    Enters text "root" into the input: sendStringSync("Jake").
//    http://evgenii.com/blog/testing-activity-in-android-studio-tutorial-part-3/


    }


    public void ClickOnTheButton() {
        TouchUtils.clickView(this, zaloguj_button);

//        This code does two things:
//
//    Gets a Button by its ID greet_button.
//            Taps the button.

    }


    public void testCzyLoginextViewMaNapisRoot() {
        String actual = login_textview.getText().toString();
        assertEquals("root", actual);
    }

    public void testCzyNazwaAplikacjiNieJestPusta() {
        String expected = logowanie_activity.getString(R.string.app_name);
        assertEquals("Dziennik szkoly podstaowej nr 3 w Tarnobrzegu",expected);
    }

//    public void testCzyPojawiaSieWiadomosc_NieMaTakiegoUzytkownika_przyPustejBazieDanych(){
//        Toast someToast;
//        boolean isShown;
//
//        TouchUtils.clickView(this, zaloguj_button); //Naciskasz przycisk Zaloguj
//        someToast = Toast.makeText(this, "Nie ma takiego uzytkownika", Toast.LENGTH_LONG);
//        isShown = someToast.getView().isShown();
//
//        assertTrue(isShown);
//    }
//
//
//    public void testCzyMoznaWczytacPrzykladoweOceny() {
//        TouchUtils.clickView(this, zaloguj_button); //Naciskasz przycisk 'Wprwoadz przykladowa baze danych'
//
//        DatabaseAccessObjects dbHelper = OpenHelperManager.getHelper(null, DatabaseAccessObjects.class);
//        RuntimeExceptionDao<StudentGrades, Integer> StudentGradesDao = dbHelper.getStudentGradesRuntimeExceptionDao();
//        List<StudentGrades> studentGrades = StudentGradesDao.queryForEq("Grade", 3);
//        assertNotNull(studentGrades);
//    }
//
//    public void testCzyMoznaWczytacPrzykladowychStudentow() {
//        TouchUtils.clickView(this, zaloguj_button); //Naciskasz przycisk 'Wprwoadz przykladowa baze danych'
//
//        DatabaseAccessObjects dbHelper = OpenHelperManager.getHelper(null, DatabaseAccessObjects.class);
//        RuntimeExceptionDao<Student, Integer> StudentsDao = dbHelper.getStudentRuntimeExceptionDao();
//        List<Student> students = StudentsDao.queryForAll();;
//        assertNotNull(students);
//    }


}