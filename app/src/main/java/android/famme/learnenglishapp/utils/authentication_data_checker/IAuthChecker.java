package android.famme.learnenglishapp.utils.authentication_data_checker;

import android.famme.learnenglishapp.other.custom_exceptions.TheLoginIsIncorrectlyWrittenException;
import android.famme.learnenglishapp.other.custom_exceptions.ThePassIsIncorrectlyWrittenException;
import android.famme.learnenglishapp.other.custom_exceptions.ThePassesAreNotSameException;

public interface IAuthChecker {

    /**
     * Метод проверяет правильно ли записан пароль, если:
     * в пароле минимум 1 Заглавная англ. Буква,
     * 1 строчная, 1 цифра, 1 спец. Символ,
     * а длина пароля не менее 8 символов), то возвращает true,
     * иначе выбрасывает исключение ThePassIsIncorrectlyWrittenException;
     */
    Boolean isPassCorrectlyWritten(String pass)
            throws ThePassIsIncorrectlyWrittenException;

    /**
     * Метод проверяет записана ли почта в виде
     * x@x.x, если нет, то выбрасывает исключение
     * TheLoginIsIncorrectlyWrittenException()
     */
    Boolean isLoginCorrectlyWritten(String login)
            throws TheLoginIsIncorrectlyWrittenException;


    /**
     * @param pass
     * @param passRepeat
     * @return true возвращает true если пароли одинаковые, или бросает исключение
     * @throws ThePassesAreNotSameException
     */
    Boolean areThePassesSame(String pass, String passRepeat)
            throws ThePassesAreNotSameException;

}
