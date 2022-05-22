package android.famme.learnenglishapp.ui.progress.graph;

public class ResultsData {


    public int personality;

    public int shopping;

    public int education;

    public int family;

    public int lifestyle;

    public int clothes;

    public int books;

    public int culture;

    public int life;

    public int summer;

    public ResultsData(int personality,
                       int shopping,
                       int education,
                       int family,
                       int lifestyle,
                       int clothes,
                       int books,
                       int culture,
                       int life,
                       int summer) {
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

    public int getPersonality() {
        return this.personality;
    }

    public void setPersonality(int personality) {
        this.personality = personality;
    }

    public int getShopping() {
        return this.shopping;
    }

    public void setShopping(int shopping) {
        this.shopping = shopping;
    }

    public int getEducation() {
        return this.education;
    }

    public void setEducation(int education) {
        this.education = education;
    }

    public int getFamily() {
        return this.family;
    }

    public void setFamily(int family) {
        this.family = family;
    }

    public int getLifestyle() {
        return this.lifestyle;
    }

    public void setLifestyle(int lifestyle) {
        this.lifestyle = lifestyle;
    }

    public int getClothes() {
        return this.clothes;
    }

    public void setClothes(int clothes) {
        this.clothes = clothes;
    }

    public int getBooks() {
        return this.books;
    }

    public void setBooks(int books) {
        this.books = books;
    }

    public int getCulture() {
        return this.culture;
    }

    public void setCulture(int culture) {
        this.culture = culture;
    }

    public int getLife() {
        return this.life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getSummer() {
        return this.summer;
    }

    public void setSummer(int summer) {
        this.summer = summer;
    }


}
