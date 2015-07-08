package WojtekSasiela.DziennikSzkolny;

import junit.framework.TestCase;
import android.widget.EditText;
import android.widget.TextView;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;

/**
 * Created by Wojtek on 2015-07-08.
 */
public class LogowanieActivityTest extends ActivityInstrumentationTestCase2<LogowanieActivity> {

    LogowanieActivity logowanie_activity;
    TextView login_textview;
    private Button greetButton;

    public LogowanieActivityTest() {
        super(LogowanieActivity.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        logowanie_activity = getActivity();
        login_textview = (TextView) logowanie_activity.findViewById(R.id.loginTextView);
        greetButton = (Button) logowanie_activity.findViewById(R.id.zaloguj_button_logowanie);
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

    }
//    This is what this code does:
//
//    Selects the text input by calling nameEditText.requestFocus() in the main thread of the app.
//            Waits for application to be idle: waitForIdleSync().
//    Enters text "root" into the input: sendStringSync("Jake").
//    http://evgenii.com/blog/testing-activity-in-android-studio-tutorial-part-3/



    public void ClickOnTheButton() {
        TouchUtils.clickView(this, greetButton);

//        This code does two things:
//
//    Gets a Button by its ID greet_button.
//            Taps the button.

    }


//    public void testCzyLoginextViewMaNapisRoot() {
//        String actual = login_textview.getText().toString();
//        assertEquals("root", actual);
//    }
//
//    public void testCzyNazwaAplikacjiNieJestPusta() {
//        String expected = logowanie_activity.getString(R.string.app_name);
//
//    }
//
//    public void tearDown() throws Exception {
//
//    }
//
//    public void testCzyMoznaStworzycPrzykladowaBazeDanych()
//    {
//

}