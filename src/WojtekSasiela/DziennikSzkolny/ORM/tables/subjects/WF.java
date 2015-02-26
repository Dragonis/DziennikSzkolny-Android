package WojtekSasiela.DziennikSzkolny.ORM.tables.subjects;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by Wojtek on 2015-02-26.
 */
public class WF {

    @DatabaseField(generatedId=true)
    Integer id;

    @DatabaseField
    Integer Id_subcjet;

    @DatabaseField
    String Name;

    @DatabaseField
    Integer Id_Teacher;
}
