package android.famme.learnenglishapp.utils.firebase;

import android.app.Activity;

import java.util.List;

import io.reactivex.rxjava3.subjects.PublishSubject;

/**
 * Здесь описаны методы для работы с Firebase BAAS-сервисом, код для реализвации взят из
 * официальной документации сервиса:
 * Firebase https://firebase.google.com/docs/auth/android/firebaseui.
 * <p>
 * ВНИМАНИЕ:
 * Поведение, происходящее
 * на сервере Firebase не контроллируется, поэтому нет возможности гарантировать
 * корректное поведение сервера!!!
 * Также возможна некорректная работа на устройствах без Google-сервисов.
 * Также замечено было, что работа с Firebase временами блокируется по непонятным причинам.
 */

public interface IAuthFirebase {

    /**
     * Ф-я возвращает переменную, являющаюся экземпляром класса PublishSubject
     * из библиотеки RxJava3,
     * на которую мы подписываемся, чтобы получать данные о состоянии
     * аутентификации пользователя.
     */

    PublishSubject<AuthData> getEventAuth();

    /**
     * @param email
     * @param password
     * @param activity Вход пользователя по логину (email) и паролю, через Firebase
     */

    void signIn(String email, String password, Activity activity);

    /**
     * @param email
     * @param password
     * @param activity Создание нового пользователя при регистрации
     */

    void signUp(String email, String password, Activity activity);


    /**
     * Выход из пользователя. После вызова данной ф-ии
     * высветится экран аутентификации.
     */

    void signOut();

    /**
     * @param email Сброс пароля
     */

    void resetPass(String email);

    /**
     * @param email
     * @param newPass Функция обновления пароля
     */

    void updatePass(String email, String newPass);

    /**
     * @param email Функция обноволения логина
     */

    void updateLogin(String email);


    /**
     * Удаление пользователя через сервис, при получении уведомления об успешном удалении
     * пользователя все данные пользователя в приложении будут удалены, а пользователь вернётся
     * к экрану авторизации.
     */

    void deleteUser();

    /**
     * @param email
     * @param password Повторная аутентификация пользователя.
     */

    void repeatAuth(String email, String password);

    /**
     * @param login При вызове ф-ии переменная класса PublishSubject, излучает
     *              данные с именем пользователя
     */

    void getUserName(String login);

    /**
     * @param login
     * @param name  Ф-ия сохраняет имя пользователя в качестве данных.
     */
    void saveUserName(String login, String name);

    List<String> getProfileResult();

    void deleteProfileResult();

    void setProfileResult();

}
