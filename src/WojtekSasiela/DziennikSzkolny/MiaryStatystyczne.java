package WojtekSasiela.DziennikSzkolny;

import java.util.List;
import java.util.Collections;

/**
 * Created by Wojtek on 2015-03-15.
 */
public final class MiaryStatystyczne {

    int suma_ocen;
    int ilosc_ocen;
    double srednia;

    public MiaryStatystyczne() {
    }

    public double Srednia(List<String> oceny){
    if (oceny == null){ return 0;}
        else {
        ilosc_ocen = oceny.size();

        for (String ocena : oceny) {

            suma_ocen += Integer.parseInt(ocena);
        }

        srednia = suma_ocen / ilosc_ocen;

        return srednia;
        }
    }

    public double Mediana(List<String> oceny){
        if (oceny == null){ return 0;}
        else {

            double srednia = Srednia(oceny);
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



            return mediana;

        }
    }

    public double Dominanta(List<String> oceny){
        if (oceny == null){ return 0;}
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


            return dominanta;
        }
    }

    public double Wariancja(List<String> oceny){
        if (oceny == null){ return 0;}
        else {
            double wariancja = 0.0;
            double srednia = Srednia(oceny);
            int ilosc_elementow = oceny.size();
            for (int i = 1; i < ilosc_elementow; i++) {
                wariancja += (Double.parseDouble(oceny.get(i)) - srednia)*(Double.parseDouble(oceny.get(i)) - srednia);
            }
            wariancja = wariancja / ilosc_elementow;

           return wariancja;

        }
    }

    public double Odchylenie(List<String> oceny){
        if (oceny == null){ return 0;}
        else {
            double wariancja = 0.0;
            double odchylenie = 0.0;
            wariancja = Wariancja(oceny);

            return odchylenie;
        }
    }

    public double Kwartyle(List<String> oceny){
        if (oceny == null){ return 0;}
        else {
            double kwartyle = 3.1414;


            return kwartyle;
        }
    }

}
