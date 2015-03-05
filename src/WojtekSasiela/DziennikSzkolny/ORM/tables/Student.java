package WojtekSasiela.DziennikSzkolny.ORM.tables;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by Wojtek on 2015-02-26.
 */
public class Student {

    @DatabaseField(generatedId=true)
    int id;

    @DatabaseField
    String name;

    @DatabaseField
    String surname;

    @DatabaseField
    Integer classrom;

    @DatabaseField
    Integer Id_Polish;

    @DatabaseField
    Integer Id_English;

    @DatabaseField
    Integer Id_Math;

    @DatabaseField
    Integer Id_Biology;

    @DatabaseField
    Integer Id_Religion;

    @DatabaseField
    Integer Id_WF;

    public Student() {
    }

    public Student(String name, String surname, Integer classrom) {
        this.name = name;
        this.surname = surname;
        this.classrom = classrom;
    }
//
//    public Student(String name, String surname, Integer classrom, Integer id_Polish, Integer id_English, Integer id_Math, Integer id_Biology, Integer id_Religion, Integer id_WF) {
//        this.name = name;
//        this.surname = surname;
//        this.classrom = classrom;
//        Id_Polish = id_Polish;
//        Id_English = id_English;
//        Id_Math = id_Math;
//        Id_Biology = id_Biology;
//        Id_Religion = id_Religion;
//        Id_WF = id_WF;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getClassrom() {
        return classrom;
    }

    public void setClassrom(Integer classrom) {
        this.classrom = classrom;
    }

    public Integer getId_Polish() {
        return Id_Polish;
    }

    public void setId_Polish(Integer id_Polish) {
        Id_Polish = id_Polish;
    }

    public Integer getId_English() {
        return Id_English;
    }

    public void setId_English(Integer id_English) {
        Id_English = id_English;
    }

    public Integer getId_Math() {
        return Id_Math;
    }

    public void setId_Math(Integer id_Math) {
        Id_Math = id_Math;
    }

    public Integer getId_Biology() {
        return Id_Biology;
    }

    public void setId_Biology(Integer id_Biology) {
        Id_Biology = id_Biology;
    }

    public Integer getId_Religion() {
        return Id_Religion;
    }

    public void setId_Religion(Integer id_Religion) {
        Id_Religion = id_Religion;
    }

    public Integer getId_WF() {
        return Id_WF;
    }

    public void setId_WF(Integer id_WF) {
        Id_WF = id_WF;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", classrom=" + classrom +
                ", Id_Polish=" + Id_Polish +
                ", Id_English=" + Id_English +
                ", Id_Math=" + Id_Math +
                ", Id_Biology=" + Id_Biology +
                ", Id_Religion=" + Id_Religion +
                ", Id_WF=" + Id_WF +
                '}';
    }
}
