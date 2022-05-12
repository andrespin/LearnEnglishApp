package android.famme.learnenglishapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import android.app.Activity;
import android.famme.learnenglishapp.App;
import android.famme.learnenglishapp.R;
import android.famme.learnenglishapp.data.storage.IPreferences;
import android.famme.learnenglishapp.utils.navigator.INavigator;
import android.os.Bundle;
import android.view.View;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}