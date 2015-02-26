package WojtekSasiela.DziennikSzkolny.ORM.tables;

import com.j256.ormlite.field.DatabaseField;

import java.util.Date;

/**
 * Created by Wojtek on 2015-02-05.
 */
public class User {

    @DatabaseField(generatedId=true)
    int id;

    @DatabaseField
    String username;

    @DatabaseField
    String password;

    @DatabaseField
    Date date;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.date = new Date(System.currentTimeMillis());
    }

    @Override
    public String toString() {
        return "Account: [id=" + id + ", username=" + username + ", password=" + password
                + ", date=" + date + "]";

    }
}
