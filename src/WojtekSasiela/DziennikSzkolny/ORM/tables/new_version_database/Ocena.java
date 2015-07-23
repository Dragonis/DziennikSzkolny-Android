package WojtekSasiela.DziennikSzkolny.ORM.tables.new_version_database;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by Wojtek on 23.07.2015.
 */
public class Ocena {

    @DatabaseField(generatedId=true)
    Integer id_oceny;

    @DatabaseField
    Integer id_przedmiotu;

    @DatabaseField
    Integer id_ucznia;

    @DatabaseField
    Integer ocena;
    
    @DatabaseField
    String Data;

    public Ocena() {
    }

    public Ocena(Integer id_ucznia, Integer id_przedmiotu, Integer ocena, String data) {
        this.id_przedmiotu = id_przedmiotu;
        this.id_ucznia = id_ucznia;
        this.ocena = ocena;
        Data = data;
    }

    public Integer getId_oceny() {
        return id_oceny;
    }

    public void setId_oceny(Integer id_oceny) {
        this.id_oceny = id_oceny;
    }

    public Integer getId_przedmiotu() {
        return id_przedmiotu;
    }

    public void setId_przedmiotu(Integer id_przedmiotu) {
        this.id_przedmiotu = id_przedmiotu;
    }

    public Integer getId_ucznia() {
        return id_ucznia;
    }

    public void setId_ucznia(Integer id_ucznia) {
        this.id_ucznia = id_ucznia;
    }

    public Integer getOcena() {
        return ocena;
    }

    public void setOcena(Integer ocena) {
        this.ocena = ocena;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }
}
