package android.famme.learnenglishapp.data.storage.room;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "result")
public class ResultEntity {

    @NonNull
    @PrimaryKey
    public String login;

    public String personality;

    public String shopping;

    public String education;

    public String family;

    public String lifestyle;

    public String clothes;

    public String books;

    public String culture;

    public String life;

    public String summer;

    public ResultEntity(@NonNull String login,
                        String personality,
                        String shopping,
                        String education,
                        String family,
                        String lifestyle,
                        String clothes,
                        String books,
                        String culture,
                        String life,
                        String summer) {
        this.login = login;
        this.personality = personality;
        this.shopping = shopping;
        this.education = education;
        this.family = family;
        this.lifestyle = lifestyle;
        this.clothes = clothes;
        this.books = books;
        this.culture = culture;
        this.life = life;
        this.summer = summer;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPersonality() {
        return this.personality;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }

    public String getShopping() {
        return this.shopping;
    }

    public void setShopping(String shopping) {
        this.shopping = shopping;
    }

    public String getEducation() {
        return this.education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getFamily() {
        return this.family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getLifestyle() {
        return this.lifestyle;
    }

    public void setLifestyle(String lifestyle) {
        this.lifestyle = lifestyle;
    }

    public String getClothes() {
        return this.clothes;
    }

    public void setClothes(String clothes) {
        this.clothes = clothes;
    }

    public String getBooks() {
        return this.books;
    }

    public void setBooks(String books) {
        this.books = books;
    }

    public String getCulture() {
        return this.culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    public String getLife() {
        return this.life;
    }

    public void setLife(String life) {
        this.life = life;
    }

    public String getSummer() {
        return this.summer;
    }

    public void setSummer(String summer) {
        this.summer = summer;
    }
}


