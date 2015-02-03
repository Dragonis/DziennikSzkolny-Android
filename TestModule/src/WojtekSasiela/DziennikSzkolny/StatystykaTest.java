package WojtekSasiela.DziennikSzkolny;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class StatystykaTest extends TestCase {

    Statystyka stat = new Statystyka();

    public void setUp() throws Exception {
        super.setUp();

    }

    public void tearDown() throws Exception {

    }

    public void testSredniaArytmetyczna() throws Exception {

        ArrayList<Double> oceny = new ArrayList<Double>();
        oceny.add(3.5);
        oceny.add(4.0);
        oceny.add(3.0);
        oceny.add(2.0);

        assertEquals(3.125,stat.sredniaArytmetyczna(oceny));
    }

    public void testWariancja() throws Exception {

    }

    public void testDominanta() throws Exception {

    }

    public void testKwartyle() throws Exception {

    }

    public void testMediana() throws Exception {

    }

    public void testOdchylenieStandardowe() throws Exception {

    }
}