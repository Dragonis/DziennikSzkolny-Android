package sasiela.wojtek.dziennikszkolny.ORM.tables.new_version_database;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by Wojtek on 23.07.2015.
 */
public class Uczen {

    @DatabaseField(generatedId=true)
    Integer id_ucznia;

    @DatabaseField
    String imie;

    @DatabaseField
    String nazwisko;

    @DatabaseField
    Integer klasa;

    @DatabaseField
    boolean isNauczyciel;

    public Uczen() {
    }

    public Uczen(String imie, String nazwisko, Integer klasa, boolean isNauczyciel) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.klasa = klasa;
        this.isNauczyciel = isNauczyciel;
    }

    public Integer getId_ucznia() {
        return id_ucznia;
    }

    public void setId_ucznia(Integer id_ucznia) {
        this.id_ucznia = id_ucznia;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Integer getKlasa() {
        return klasa;
    }

    public void setKlasa(Integer klasa) {
        this.klasa = klasa;
    }

    public boolean isNauczyciel() {
        return isNauczyciel;
    }

    public void setIsNauczyciel(boolean isNauczyciel) {
        this.isNauczyciel = isNauczyciel;
    }
}
