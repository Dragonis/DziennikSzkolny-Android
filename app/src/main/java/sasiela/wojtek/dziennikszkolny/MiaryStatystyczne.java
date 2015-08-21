package sasiela.wojtek.dziennikszkolny;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Wojtek on 2015-03-15.
 */
public final class MiaryStatystyczne {

    int suma_ocen = 0;
    int ilosc_ocen = 0;
    double srednia = 0.0;

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

            //return 3.14;
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
            //return 3.14;
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
            return String.valueOf(wariancja);
//            return 3.14;
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
//            String odchylenie_2miejsca_po_przecinku = String.format("%.2f", odchylenie);

//            return odchylenie;
//            return Double.parseDouble(odchylenie_2_miejsca_po_przecinku);
            return odchylenie_2_miejsca_po_przecinku;
//            return 3.14;
        }
    }

    public String Kwartyle(ArrayList<String> oceny){
        if (oceny == null){ return "null";}
        else {
            return "3.14";
        }
    }

}
