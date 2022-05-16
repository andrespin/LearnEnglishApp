package android.famme.learnenglishapp.data.storage.themes;

import java.util.ArrayList;

public class Themes implements IThemes{

    @Override
    public ArrayList<String> getThemes() {
        ArrayList<String> themes = new ArrayList<>();
        themes.add("Personality");
        themes.add("Shopping");
        themes.add("Education");
        themes.add("Family");
        themes.add("Lifestyle");
        themes.add("Clothes");
        themes.add("Books");
        themes.add("Culture");
        themes.add("Life");
        themes.add("Summer");
        return themes;
    }
}
