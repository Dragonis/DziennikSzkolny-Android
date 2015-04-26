package sasiela.wojtek.dziennikszkolny;

/**
 * Created by Wojtek on 2015-04-26.
 */
public class LogowanieActivityUnitTest extends android.test.ActivityUnitTestCase<LogowanieActivity> {


    public LogowanieActivityUnitTest() {
        super(LogowanieActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

    }

    public void testSprawdzLogin(){
        assertEquals(true,true);
    }

    public void testSprawdzhaslo(){
        assertEquals(true,false);
    }
}
