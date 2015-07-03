package WojtekSasiela.DziennikSzkolny.ORM;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by Wojtek on 2015-07-03.
 */
public class Classroom {

    @DatabaseField(generatedId=true)
    int ID_Classroom;

    @DatabaseField
    String Name;

    public Classroom() {
    }

    public Classroom(int ID_Classroom, String name) {
        this.ID_Classroom = ID_Classroom;
        Name = name;
    }

    public int getID_Classroom() {
        return ID_Classroom;
    }

    public void setID_Classroom(int ID_Classroom) {
        this.ID_Classroom = ID_Classroom;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
