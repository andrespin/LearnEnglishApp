package android.famme.learnenglishapp.utils.authentication_data_checker;

import android.content.Context;
import android.famme.learnenglishapp.other.custom_exceptions.TheLoginIsIncorrectlyWrittenException;
import android.famme.learnenglishapp.other.custom_exceptions.ThePassIsIncorrectlyWrittenException;
import android.famme.learnenglishapp.other.custom_exceptions.ThePassesAreNotSameException;

public class AuthChecker extends AuthCheckerTools implements IAuthChecker {

    public AuthChecker(Context context) {
        super(context);
    }

    @Override
    public Boolean isPassCorrectlyWritten(String pass) throws ThePassIsIncorrectlyWrittenException {
        return isPassCorrect(pass);
    }

    @Override
    public Boolean isLoginCorrectlyWritten(String login) throws TheLoginIsIncorrectlyWrittenException {
        return isLoginCorrect(login);
    }

    @Override
    public Boolean areThePassesSame(String pass, String passRepeat) throws ThePassesAreNotSameException {
        if (!pass.equals(passRepeat)) {
            throw new ThePassesAreNotSameException("Пароли в окошках не совпадают!");
        }
        return true;
    }

}
