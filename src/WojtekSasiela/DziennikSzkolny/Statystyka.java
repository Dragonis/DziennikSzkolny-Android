package WojtekSasiela.DziennikSzkolny;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Wojtek on 2015-01-28.
 */
public class Statystyka {
    public Statystyka() {
    }

    // Opisy statystyczne w javie
    // http://www.flash.com.pl/metody-statystyczne-t5310.html


    public double sredniaArytmetyczna()
    {
        double suma_ocen = 0;
        double wynik = 0;

        List<Double> oceny = new ArrayList<Double>();
        oceny.add(3.5);
        oceny.add(4.0);
        oceny.add(3.0);
        oceny.add(2.0);

        for(double ocena : oceny)
        {
            suma_ocen += ocena;
        }

        wynik = suma_ocen / oceny.size();
        return wynik;
    }

    public void wariancja()
    {
        // wzor na wariancje
        // http://www.naukowiec.org/wzory/statystyka/wariancja_6.html

        double suma_ocen = 0;
        double wynik = 0;
        double roznica_miedzy_wynikami_a_srednia[] = new double[4];
        List<Double> oceny = new ArrayList<Double>();

        oceny.add(3.5);
        oceny.add(4.0);
        oceny.add(3.0);
        oceny.add(2.0);

        double wariancja = 0;
        double obliczenia = 0;
        for(double ocena : oceny)
        {
            obliczenia = ocena - sredniaArytmetyczna();
            obliczenia = obliczenia * obliczenia;
            wynik = obliczenia / oceny.size();
        }

    }

    public void dominanta()
    {
        // http://kursjava.pl/srednia-mediana-dominanta/

        int liczby[] = { 1, 2, 3, 4, 4, 4, 4, 5, 6, 7, 8, 13, 13,
                13, 13, 13, 9, 10, 100, 1 };

        int dominanta = 0;
        int maks = 0;
        int licznik = 0;

        for (int i = 0; i < liczby.length; i++) {
            licznik = 0;
            for (int k = 0; k < liczby.length; k++) {
                if (liczby[i] == liczby[k]) {
                    licznik++;
                    if (licznik > maks) {
                        dominanta = liczby[i];
                        maks = licznik;
                    }
                }

            }
        }
        System.out.println("Dominanta liczb w tablicy to: " + dominanta);

    }

    public void kwartyle()
    {
        // http://forum.4programmers.net/Newbie/169580-delphi_statystyka_-_wyznaczanie_kwartyli

    }

    public void mediana()
    {
        // http://podstawyprogramowania.pl/java/przyklady/java-mediana-elementow-tablicy/

        int liczby[] = { 1, 2, 3, 4, 4, 4, 4, 5, 6, 7, 8, 13, 13,
                13, 13, 13, 9, 10, 100, 1 };

        double mediana = 0;
        Arrays.sort(liczby);
        if (liczby.length % 2 == 0) {
            mediana = (liczby[liczby.length / 2] + liczby[(liczby.length / 2) + 1]) / 2.0;
        } else {
            mediana = liczby[liczby.length / 2];
        }

        System.out.println("Mediana liczb w tablicy to: " + mediana);

    }

    public void odchylenieStandardowe()
    {
        // http://www.naukowiec.org/wzory/statystyka/odchylenie-standardowe_5.html
    }

}
