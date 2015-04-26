package WojtekSasiela.DziennikSzkolny.ORM.tables.subjects;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by Wojtek on 2015-02-26.
 */
public class WF {

    @DatabaseField(generatedId=true)
    Integer id;

    @DatabaseField
    Integer Id_student;

    @DatabaseField
    String Name;

    @DatabaseField
    Integer Id_Teacher;

    @DatabaseField
    Integer Grade1;

    @DatabaseField
    Integer Grade2;

    @DatabaseField
    Integer Grade3;

    public WF() {
    }

    public WF(Integer id_student, Integer grade1, Integer grade2, Integer grade3) {
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

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getId_Teacher() {
        return Id_Teacher;
    }

    public void setId_Teacher(Integer id_Teacher) {
        Id_Teacher = id_Teacher;
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
