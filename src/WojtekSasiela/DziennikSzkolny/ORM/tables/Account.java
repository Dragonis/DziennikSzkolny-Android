package WojtekSasiela.DziennikSzkolny.ORM.tables;

import com.j256.ormlite.field.DatabaseField;

import java.util.Date;

/**
 * Created by Wojtek on 2015-02-05.
 */
public class Account {

    @DatabaseField(generatedId=true)
    int id;

    @DatabaseField
    String username;

    @DatabaseField
    String password;

    @DatabaseField
    String name;

    @DatabaseField
    String surname;

    /**
     * Account data created
     */
    @DatabaseField
    Date date;

    public Account() {
    }

    public Account(String name, String surname, String username, String password) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.date = new Date(System.currentTimeMillis());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    @Override
    public String toString() {
        return "Account: [id=" + id + ", username=" + username + ", password=" + password
                + ", date=" + date + "]";

    }
}
