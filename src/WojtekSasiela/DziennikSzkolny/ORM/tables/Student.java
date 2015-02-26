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



}
