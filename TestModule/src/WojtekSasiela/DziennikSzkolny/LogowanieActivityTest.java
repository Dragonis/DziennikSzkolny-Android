package WojtekSasiela.DziennikSzkolny;

import WojtekSasiela.DziennikSzkolny.ORM.CRUD.CREATE.InsertDataToDatabase;
import WojtekSasiela.DziennikSzkolny.ORM.CRUD.DatabaseCRUDoperations;
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

import java.util.ArrayList;
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

    public void testCzyMoznaWczytacStudentaPoImieniuINazwisku()
    {
        TouchUtils.clickView(this, zaloguj_button);
        Student student = LoadDataFromDatabase.load_Student_fromDatabase("Wojtek","Sasiela");
        assertEquals("Wojtek",student.getName());
        assertEquals("Sasiela",student.getSurname());
        assertEquals(1,(int)student.getClassrom());
    }

    public void testCzyMoznaWczytacStudentaPoId()
    {
        TouchUtils.clickView(this, zaloguj_button);
        List<Student> student = LoadDataFromDatabase.load_Student_fromDatabase(1); //Student_ID
        String name = student.get(0).getName();
        String surname = student.get(0).getSurname();
        int studnet_class = student.get(0).getClassrom();
        assertEquals("Wojtek",name);
        assertEquals("Sasiela",surname);
        assertEquals(1,studnet_class);
    }

    public void testWczytajOcenyDanegoPrzedmiotuDanegoUczniaODanymID()
    {
        int id_ucznia = 1;
        int id_przedmiotu = 1;
        List<Integer> oceny = null;
        TouchUtils.clickView(this, zaloguj_button);
        oceny = LoadDataFromDatabase.loadStudentGrades(id_ucznia,id_przedmiotu);
        assertEquals(5,(int)oceny.get(0));
        assertEquals(3,(int)oceny.get(1));
        assertEquals(4,(int)oceny.get(2));
        assertEquals(6,(int)oceny.get(3));
        id_ucznia = 2;
        oceny = null;
        oceny = LoadDataFromDatabase.loadStudentGrades(id_ucznia,id_przedmiotu);
        assertEquals(5,(int)oceny.get(0));
        assertEquals(3,(int)oceny.get(1));
        assertEquals(4,(int)oceny.get(2));
        assertEquals(6,(int)oceny.get(3));
    }

    public void testCzyMoznaWczytacWszystkichStudentowzDB()
    {
        TouchUtils.clickView(this, zaloguj_button);
        List<Student> students = logowanie_activity.wczytajWszystkichStudentowzDB();
        List<Student> student = new ArrayList<Student>();
        DatabaseCRUDoperations crud = new DatabaseCRUDoperations();
        //region przytkladowa_baza_studentow
        student.add(new Student("Wojtek", "Sasiela", 1));
        student.add(new Student("Anna", "Kowalska", 1));
        student.add(new Student("Joanna", "Pyrzyñska", 1));
        student.add(new Student("Izabela", "Tarnowska", 1));
        student.add(new Student("Blanka", "Szept", 1));
        student.add(new Student("Pawe³", "Paluch", 1));
        student.add(new Student("Piotr", "Ma³y", 1));
        student.add(new Student("Karol", "Kopytko", 1));
        student.add(new Student("Arkadiusz", "B¹k", 1));
        student.add(new Student("Teresa", "Wawrzyniak", 1));
        student.add(new Student("Katarzyna", "Jagie³³o", 1));

        student.add(new Student("Barbara", "Lewandowska", 2));
        student.add(new Student("Ewelina", "2elik", 2));
        student.add(new Student("Diana", "Kosma³a", 2));

        student.add(new Student("Karolina", "Ordon", 3));
        student.add(new Student("Joanna", "Pieprzyk", 3));

        student.add(new Student("Stefan", "Batory", 3));
        student.add(new Student("Bartosz", "Zuch", 3));
        student.add(new Student("Jadwiga", "Konieczko", 3));

        student.add(new Student("Amelia", "Koral", 4));

        student.add(new Student("Justyna", "Boœ", 5));
        student.add(new Student("Alicja", "Stêpieñ", 5));

        student.add(new Student("Kamila", "P{aw³owska", 6));
        student.add(new Student("Roksana", "Fajna", 6));
        student.add(new Student("Beata", "Bezpieczna", 6));
        student.add(new Student("Maria", "Ciekawska", 6));
        student.add(new Student("Marta", "Okoñ", 6));
        student.add(new Student("Angelika", "Weso³owska", 6));
        //endregion

        for(int i=0; i<students.size(); i++)
        {
            assertEquals(student.get(i).getName(), students.get(i).getName());
            assertEquals(student.get(i).getSurname(), students.get(i).getSurname());
            assertEquals(student.get(i).getClassrom(), students.get(i).getClassrom());
        };

    }

}