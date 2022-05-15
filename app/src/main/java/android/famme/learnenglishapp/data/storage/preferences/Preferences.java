package android.famme.learnenglishapp.data.storage.preferences;

import android.content.SharedPreferences;
import android.famme.learnenglishapp.data.storage.preferences.IPreferences;

public class Preferences implements IPreferences {

    private final String login = "LOGIN";

    private final String pass = "PASSWORD";

    private final String name = "NAME";

    private SharedPreferences prefs;

    public Preferences(SharedPreferences prefs) {
        this.prefs = prefs;
    }

    @Override
    public void setLogin(String log) {
        prefs.edit().putString(login, log).apply();
    }

    @Override
    public String getLogin() {
        return prefs.getString(login, "");
    }

    @Override
    public void setPass(String p) {
        prefs.edit().putString(pass, p).apply();
    }

    @Override
    public String getNameLogin() {
        return prefs.getString(this.name, "");
    }

    @Override
    public void setNameLogin(String name) {
        prefs.edit().putString(this.name, name).apply();
    }

    public void deleteLoginAndPass() {
        prefs.edit().remove(login).apply();
        prefs.edit().remove(pass).apply();
    }

    @Override
    public String getPass() {
        return prefs.getString(pass, "");
    }

}
