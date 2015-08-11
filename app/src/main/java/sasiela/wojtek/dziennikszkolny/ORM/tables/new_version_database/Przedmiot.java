package sasiela.wojtek.dziennikszkolny.ORM.tables.new_version_database;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by Wojtek on 23.07.2015.
 */
public class Przedmiot {

    @DatabaseField(generatedId=true)
    Integer id_przedmiotu;

    @DatabaseField
    String nazwa;

    public Przedmiot() {
    }

    public Przedmiot(String nazwa) {
        this.nazwa = nazwa;
    }

    public Integer getId_przedmiotu() {
        return id_przedmiotu;
    }

    public void setId_przedmiotu(Integer id_przedmiotu) {
        this.id_przedmiotu = id_przedmiotu;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}
