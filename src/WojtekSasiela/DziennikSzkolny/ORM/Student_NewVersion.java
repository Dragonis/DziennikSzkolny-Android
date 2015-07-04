package WojtekSasiela.DziennikSzkolny.ORM;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by Wojtek on 2015-07-03.
 */
public class Student_NewVersion {

    @DatabaseField(generatedId=true)
    int ID_Student;

    @DatabaseField
    int ID_StudentGrades;

    @DatabaseField
    int ID_Classroom;

    @DatabaseField
    String name;

    @DatabaseField
    String surname;

    @DatabaseField
    Integer classrom;

    public Student_NewVersion() {
    }

    public Student_NewVersion(int ID_StudentGrades, int ID_Classroom, String name, String surname, Integer classrom) {
        //this.ID_Student = ID_Student;
        this.ID_StudentGrades = ID_StudentGrades;
        this.ID_Classroom = ID_Classroom;
        this.name = name;
        this.surname = surname;
        this.classrom = classrom;
    }

    public int getID_Student() {
        return ID_Student;
    }

    public void setID_Student(int ID_Student) {
        this.ID_Student = ID_Student;
    }

    public int getID_StudentGrades() {
        return ID_StudentGrades;
    }

    public void setID_StudentGrades(int ID_StudentGrades) {
        this.ID_StudentGrades = ID_StudentGrades;
    }

    public int getID_Classroom() {
        return ID_Classroom;
    }

    public void setID_Classroom(int ID_Classroom) {
        this.ID_Classroom = ID_Classroom;
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

    public Integer getClassrom() {
        return classrom;
    }

    public void setClassrom(Integer classrom) {
        this.classrom = classrom;
    }
}
