package android.famme.learnenglishapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.famme.learnenglishapp.R;
import android.os.Bundle;

/**
 * Приложение реализовано с 1 классом Activity, остальные
 * окна являются фрагментами.
 * Стек, используемый в данном приложении:
 * Архитектурный паттерн - MVVM,
 * Управление зависимостями - Dagger 2,
 * Ассинхронная работа - RxJava 3,
 * Навигация - Android Jetpack Navigation
 * Серверная часть - Firebase,
 * Внутренняя база данных - sqlite,
 * Фреймворк для работы с sqlite - Room,
 * Также для хранения примитивных данных используется SharedPreferences.
 *
 * При запуске класса MainActivity отображается элемент
 * androidx.navigation.fragment.NavHostFragment, который
 * содержит в себе @navigation/main_graph". Далее через интерфейс INavigator
 * (android/famme/learnenglishapp/utils/navigator/INavigator.java) осуществляется
 * навигация между фрагментами в приложении.
 * Для многих интерфейсов указаны комментарии, чтобы было понятнее как работает код.
 * Также над классами фрагментов содержатся комментарии.
 * Названия методов отражают функции, который они выполняют.
 *
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}