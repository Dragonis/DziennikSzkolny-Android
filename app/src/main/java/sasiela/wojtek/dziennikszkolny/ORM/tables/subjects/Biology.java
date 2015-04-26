package sasiela.wojtek.dziennikszkolny.ORM.tables.subjects;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by Wojtek on 2015-02-26.
 */
public class Biology {

    @DatabaseField(generatedId=true)
    Integer id;

    @DatabaseField
    Integer Id_student;

    @DatabaseField
    String Name;

    @DatabaseField
    Integer Grade1;

    @DatabaseField
    Integer Grade2;

    @DatabaseField
    Integer Grade3;

    @DatabaseField
    String  Date1;

    @DatabaseField
    String  Date2;

    @DatabaseField
    String  Date3;

    @DatabaseField
    Integer Id_Teacher;

    public Biology() {
    }

    public Biology(Integer id_student, Integer grade1, Integer grade2, Integer grade3, String date1, String date2, String date3) {
        Id_student = id_student;
        Grade1 = grade1;
        Grade2 = grade2;
        Grade3 = grade3;
        Date1 = date1;
        Date2 = date2;
        Date3 = date3;
    }

    public String getDate1() {
        return Date1;
    }

    public void setDate1(String date1) {
        Date1 = date1;
    }

    public String getDate2() {
        return Date2;
    }

    public void setDate2(String date2) {
        Date2 = date2;
    }

    public String getDate3() {
        return Date3;
    }

    public void setDate3(String date3) {
        Date3 = date3;
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

    public Integer getId_Teacher() {
        return Id_Teacher;
    }

    public void setId_Teacher(Integer id_Teacher) {
        Id_Teacher = id_Teacher;
    }
}
