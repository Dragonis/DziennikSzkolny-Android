package sasiela.wojtek.dziennikszkolny.ORM.tables;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by Wojtek on 2015-02-26.
 */
public class Teacher {

    @DatabaseField(generatedId=true)
    int id;

    @DatabaseField
    String name;

    @DatabaseField
    String surname;

    @DatabaseField
    Integer Id_Subcjet;

    public Teacher() {
    }

    public Teacher(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getId_Subcjet() {
        return Id_Subcjet;
    }

    public void setId_Subcjet(Integer id_Subcjet) {
        Id_Subcjet = id_Subcjet;
    }
}
