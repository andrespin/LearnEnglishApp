package android.famme.learnenglishapp.data.storage.preferences;

public interface IPreferences {

    void setLogin(String log);

    String getLogin();

    String getPass();

    void setPass(String p);

    String getNameLogin();

    void setNameLogin(String name);

    void deleteLoginAndPass();

}
