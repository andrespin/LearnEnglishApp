package android.famme.learnenglishapp.ui.themes;

import android.famme.learnenglishapp.data.storage.themes.IThemes;
import android.famme.learnenglishapp.data.storage.themes.Themes;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import javax.inject.Inject;

public class ThemesViewModel extends ViewModel {

    @Inject
    IThemes themes;

    ArrayList<String> getThemes() {

        ArrayList<String> l = new ArrayList<>();
     //   System.out.println("themes.getThemes() " + themes.getThemes());
              //  themes.getThemes();

        return new Themes().getThemes();
    }

}
