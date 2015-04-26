package sasiela.wojtek.dziennikszkolny.ORM.tables.miary_statystyczne;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by Wojtek on 2015-02-26.
 */
public class Odchylenie {

    @DatabaseField(generatedId=true)
    Integer id;

    @DatabaseField
    Integer Id_student;

    @DatabaseField
    Integer Grade1;

    @DatabaseField
    Integer Grade2;

    @DatabaseField
    Integer Grade3;

    public Odchylenie() {
    }

    public Odchylenie(Integer id_student, Integer grade1, Integer grade2, Integer grade3) {
        Id_student = id_student;
        Grade1 = grade1;
        Grade2 = grade2;
        Grade3 = grade3;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_student() {
        return Id_student;
    }

    public void setId_student(Integer id_student) {
        Id_student = id_student;
    }

    public Integer getGrade1() {
        return Grade1;
    }

    public void setGrade1(Integer grade1) {
        Grade1 = grade1;
    }

    public Integer getGrade2() {
        return Grade2;
    }

    public void setGrade2(Integer grade2) {
        Grade2 = grade2;
    }

    public Integer getGrade3() {
        return Grade3;
    }

    public void setGrade3(Integer grade3) {
        Grade3 = grade3;
    }
}
