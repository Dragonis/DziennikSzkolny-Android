package WojtekSasiela.DziennikSzkolny.ORM.tables.new_version_database;

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
    String mazwisko;

    @DatabaseField
    Integer klasa;

    public Uczen() {
    }

    public Uczen(String imie, String mazwisko, Integer klasa) {
        this.imie = imie;
        this.mazwisko = mazwisko;
        this.klasa = klasa;
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

    public String getMazwisko() {
        return mazwisko;
    }

    public void setMazwisko(String mazwisko) {
        this.mazwisko = mazwisko;
    }

    public Integer getKlasa() {
        return klasa;
    }

    public void setKlasa(Integer klasa) {
        this.klasa = klasa;
    }
}
