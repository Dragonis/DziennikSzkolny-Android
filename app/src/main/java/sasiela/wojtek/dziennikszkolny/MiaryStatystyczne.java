package sasiela.wojtek.dziennikszkolny;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Wojtek on 2015-03-15.
 */
public final class MiaryStatystyczne {

    private int suma_ocen = 0;
    private int ilosc_ocen = 0;
    private double srednia = 0.0;

    public MiaryStatystyczne() {
    }

    public String Srednia(ArrayList<String> oceny){
    if (oceny == null){ return "null";}
        else {
        ilosc_ocen = oceny.size();

        for (String ocena : oceny) {

            suma_ocen += Integer.parseInt(ocena);
        }

        srednia = suma_ocen / ilosc_ocen;

        return String.valueOf(srednia);
        }
    }

    public String Mediana(ArrayList<String> oceny){
        if (oceny == null){ return "null";}
        else {

            double srednia = Double.parseDouble(Srednia(oceny));
            double mediana = 0.0;
            Collections.sort(oceny);

            // mediana jest wartością środkową w danym zbiorze
            // aby uzyskać tę wartość, należy w pierwszym kroku
            // posortować elementy tablicy (dowolną metodą)
            // tutaj użyliśmy wbudowanej metody Javy sort.
            // jeżeli tablica zawiera parzystą liczbę elementów, to mediana jest
            // średnią wartością dwóch środkowych elementów
            if (oceny.size() % 2 == 0 )
            {
                mediana = Double.parseDouble(oceny.get(oceny.size()/2)) + Double.parseDouble(oceny.get(oceny.size()/2-1));
                // w zmiennej średnia trzymamy sumę dwóch środkowych elementów tablicy

            }
            else // jeżeli tablica zawiera nieparzystą liczbę elementów, to mediana
            {    // jest dokładnie wartością środkową
                mediana = Double.parseDouble(oceny.get(oceny.size()/2));
            }

            return String.valueOf(mediana);
        }
    }

    public String Dominanta(ArrayList<String> oceny){
        if (oceny == null){ return "null";}
        else {

            double dominanta = 0;
            int maks = 0;
            int licznik = 0;

            for (int i = 0; i < oceny.size(); i++) {
                licznik = 0;
                for (int k = 0; k < oceny.size(); k++) {
                    if (oceny.get(i) == oceny.get(k)) {
                        licznik++;
                        if (licznik > maks) {
                            dominanta = Double.parseDouble(oceny.get(i));
                            maks = licznik;
                        }
                    }

                }
            }
            return String.valueOf(dominanta);
        }
    }

    public String Wariancja(ArrayList<String> oceny){
        if (oceny == null){ return "null";}
        else {
            double wariancja = 0.0;
            double srednia = Double.parseDouble(Srednia(oceny));
            int ilosc_elementow = oceny.size();
            for (int i = 1; i < ilosc_elementow; i++) {
                wariancja += (Double.parseDouble(oceny.get(i)) - srednia)*(Double.parseDouble(oceny.get(i)) - srednia);
            }
            wariancja = wariancja / ilosc_elementow;
            DecimalFormat df = new DecimalFormat("#.00");
            String wariancja__2_miejsca_po_przecinku = df.format(wariancja);
            return String.valueOf(wariancja__2_miejsca_po_przecinku.replace(",","."));
        }
    }

    public String Odchylenie(ArrayList<String> oceny){
        if (oceny == null){ return "null";}
        else {
            double wariancja = 0.0;
            double odchylenie = 0.0;
            wariancja = Double.parseDouble(Wariancja(oceny));
            odchylenie = Math.sqrt(wariancja);
            DecimalFormat df = new DecimalFormat("#.00");
            String odchylenie_2_miejsca_po_przecinku = df.format(odchylenie);

            return odchylenie_2_miejsca_po_przecinku;
        }
    }


    public String Kwartyle(ArrayList<String> oceny){
        if (oceny == null){ return "null";}
        else {
            double[] convertData = new double[oceny.size()];
            // conver from ArrayList<String> to double
            for (int i = 0; i < oceny.size(); ++i) {
                convertData[i] = Double.parseDouble(oceny.get(i));
            }
            Kwartyle_z_Q1_Do_Q4 kwartyle = new Kwartyle_z_Q1_Do_Q4();
            double wynik = kwartyle.Q2(convertData);
            return String.valueOf(wynik);
        }
    }

    public class Kwartyle_z_Q1_Do_Q4 {

    private double q1 = 0;
    private double q2 = 0;
    private double q3 = 0;
    private double q4 = 0;

    public double Q1(double[] tab) {

            double positionq1;
            int n = tab.length;

            Arrays.sort(tab);
            if (tab == null || n == 0) {
                throw new IllegalArgumentException(
                        "The data array is null or does not contain any data.");
            } else {
                if (n % 2 == 0) {
                    positionq1 = (n + 1) * 0.25;
                    int positionq1int = (int) positionq1;
                    double leftover = ((positionq1 * 100) % 100) / 100;
                    q1 = (tab[positionq1int - 1] + (leftover * (tab[positionq1int] - tab[positionq1int - 1])));
                    return q1;

                } else {
                    positionq1 = n * 0.25;
                    int positionq1int = (int) positionq1;
                    double leftover = ((positionq1 * 100) % 100) / 100;
                    q1 = (tab[positionq1int - 1] + (leftover * (tab[positionq1int] - tab[positionq1int - 1])));
                    return q1;
                }
            }
        }

        public double Q2(double[] tab) {
            double positionq2;
            int n = tab.length;

            Arrays.sort(tab);
            if (tab == null || n == 0) {
                throw new IllegalArgumentException(
                        "The data array is null or does not contain any data.");
            } else {
                if (n % 2 == 0) {
                    positionq2 = (n + 1) * 0.5;
                    int positionq2int = (int) positionq2;
                    double leftover = ((positionq2 * 100) % 100) / 100;

                    q2 = (tab[positionq2int - 1] + (leftover * (tab[positionq2int] - tab[positionq2int - 1])));

                    return q2;

                } else {
                    positionq2 = n * 0.5;
                    int positionq2int = (int) positionq2;
                    double leftover = ((positionq2 * 100) % 100) / 100;

                    q2 = (tab[positionq2int - 1] + (leftover * (tab[positionq2int] - tab[positionq2int - 1])));

                    return q2;
                }

            }

        }

        public double Q3(double[] tab) {
            double positionq3;
            int n = tab.length;

            Arrays.sort(tab);
            if (tab == null || n == 0) {
                throw new IllegalArgumentException(
                        "The data array is null or does not contain any data.");
            } else {
                if (n % 2 == 0) {
                    positionq3 = (n + 1) * 0.75;
                    int positionq3int = (int) positionq3;
                    double leftover = ((positionq3 * 100) % 100) / 100;

                    q3 = (tab[positionq3int - 1] + (leftover * (tab[positionq3int] - tab[positionq3int - 1])));

                    return q3;

                } else {
                    positionq3 = n * 0.75;
                    int positionq3int = (int) positionq3;
                    double leftover = ((positionq3 * 100) % 100) / 100;

                    q3 = (tab[positionq3int - 1] + (leftover * (tab[positionq3int] - tab[positionq3int - 1])));

                    return q3;
                }
            }
        }

        public double Q4(double[] tab) {
            int n = tab.length;
            Arrays.sort(tab);
            q4 = tab[n - 1];

            return q4;

        }
    }
}
