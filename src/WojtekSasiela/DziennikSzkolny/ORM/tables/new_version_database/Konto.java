package WojtekSasiela.DziennikSzkolny.ORM.tables.new_version_database;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by Wojtek on 27.07.2015.
 */
public class Konto {

    @DatabaseField(generatedId = true)
    Integer id_konta;

    @DatabaseField
    Integer id_ucznia;

    @DatabaseField
    String username;

    @DatabaseField
    String password;

    public Konto() {
    }

    public Konto(Integer id_ucznia, String username, String password) {
        this.id_ucznia = id_ucznia;
        this.username = username;
        this.password = password;
    }

    public Integer getId_konta() {
        return id_konta;
    }

    public void setId_konta(Integer id_konta) {
        this.id_konta = id_konta;
    }

    public Integer getId_ucznia() {
        return id_ucznia;
    }

    public void setId_ucznia(Integer id_ucznia) {
        this.id_ucznia = id_ucznia;
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
}
