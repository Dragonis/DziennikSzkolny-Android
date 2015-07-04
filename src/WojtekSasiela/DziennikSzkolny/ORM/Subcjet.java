package WojtekSasiela.DziennikSzkolny.ORM;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by Wojtek on 2015-07-03.
 */
public class Subcjet {


    @DatabaseField(generatedId=true)
    int ID_Subcjet;

    @DatabaseField
    int ID_Teacher;

    @DatabaseField
    int ID_Student;

    @DatabaseField
    String subcjet;

    public Subcjet() {
    }

    public Subcjet( int ID_Teacher, int ID_Student, String subcjet) {
        this.ID_Teacher = ID_Teacher;
        this.ID_Student = ID_Student;
        this.subcjet = subcjet;
    }

    public int getID_Subcjet() {
        return ID_Subcjet;
    }

    public void setID_Subcjet(int ID_Subcjet) {
        this.ID_Subcjet = ID_Subcjet;
    }

    public int getID_Teacher() {
        return ID_Teacher;
    }

    public void setID_Teacher(int ID_Teacher) {
        this.ID_Teacher = ID_Teacher;
    }

    public int getID_Student() {
        return ID_Student;
    }

    public void setID_Student(int ID_Student) {
        this.ID_Student = ID_Student;
    }

    public String getSubcjet() {
        return subcjet;
    }

    public void setSubcjet(String subcjet) {
        this.subcjet = subcjet;
    }
}
