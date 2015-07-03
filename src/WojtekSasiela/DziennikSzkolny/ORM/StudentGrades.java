package WojtekSasiela.DziennikSzkolny.ORM;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by Wojtek on 2015-07-03.
 */
public class StudentGrades {

    @DatabaseField(generatedId=true)
    int ID_StudentGrades;

    @DatabaseField
    int ID_Subcjet;

    @DatabaseField
    int Grade;

    public StudentGrades() {
    }

    public StudentGrades(int ID_StudentGrades, int ID_Subcjet, int grade) {
        this.ID_StudentGrades = ID_StudentGrades;
        this.ID_Subcjet = ID_Subcjet;
        Grade = grade;
    }

    public int getID_StudentGrades() {
        return ID_StudentGrades;
    }

    public void setID_StudentGrades(int ID_StudentGrades) {
        this.ID_StudentGrades = ID_StudentGrades;
    }

    public int getID_Subcjet() {
        return ID_Subcjet;
    }

    public void setID_Subcjet(int ID_Subcjet) {
        this.ID_Subcjet = ID_Subcjet;
    }

    public int getGrade() {
        return Grade;
    }

    public void setGrade(int grade) {
        Grade = grade;
    }
}
