package WojtekSasiela.DziennikSzkolny.ORM.tables;

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

}
