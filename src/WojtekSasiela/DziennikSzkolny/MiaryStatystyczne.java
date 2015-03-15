package WojtekSasiela.DziennikSzkolny;

import java.util.ArrayList;

/**
 * Created by Wojtek on 2015-03-15.
 */
public final class MiaryStatystyczne {

    public MiaryStatystyczne() {
    }

    public double Srednia(ArrayList<String> oceny){

        int suma_ocen = 0;
        int ilosc_ocen = oceny.size();
        float srednia = 0.0f;
        for (String ocena: oceny)
        {
            suma_ocen += Integer.parseInt(ocena);
        }

        srednia = suma_ocen / ilosc_ocen ;

        return srednia;
    }

    public double Mediana(ArrayList<String> oceny){

        return 3.14;
    }

    public double Dominanta(ArrayList<String> oceny){

        return 3.14;
    }

    public double Wariancja(ArrayList<String> oceny){

        return 3.14;
    }

    public double Odchylenie(ArrayList<String> oceny){

        return 3.14;
    }

    public double Kwartyle(ArrayList<String> oceny){

        return 3.14;
    }

}
