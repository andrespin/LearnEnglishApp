package android.famme.learnenglishapp.utils.authentication_data_checker;

import android.content.Context;
import android.famme.learnenglishapp.R;
import android.famme.learnenglishapp.other.custom_exceptions.TheLoginIsIncorrectlyWrittenException;
import android.famme.learnenglishapp.other.custom_exceptions.ThePassIsIncorrectlyWrittenException;

abstract class AuthCheckerTools {

    private Context context;

    public AuthCheckerTools(Context context) {
        this.context = context;
    }

    // Условия для пароля
    private Boolean isCapitalLetterIncluded = false;
    private Boolean isLowercaseLetterIncluded = false;
    private Boolean isDigitIncluded = false;
    private Boolean isSpecialSymbolIncluded = false;
    private Boolean areLettersLatin = true;

    // Условия для логина
    private Boolean areLoginLettersLatin = true;
    private Boolean isLoginExecutedInCorrectForm = false;

    protected Boolean isLoginCorrect(String login) throws TheLoginIsIncorrectlyWrittenException {
        char[] ch = login.toCharArray();

        boolean isAtSignFoundFirst = false;
        boolean isPointFound = false;

        System.out.println(login);

        // && !isPointFound
        for (int i = 0; i < ch.length; i++) {
            System.out.print(ch[i] + " ");
            if (ch[i] == '@' ) {
                isAtSignFoundFirst = true;
            }

            if (ch[i] == '.') {
                isPointFound = true;
            }
        }

        if (isAtSignFoundFirst && isPointFound) {
            return true;
        } else {
            throw new TheLoginIsIncorrectlyWrittenException(
                    context.getString(R.string.LoginIsIncorrect)
            );
        }
    }

    protected Boolean isPassCorrect(String pass)
            throws ThePassIsIncorrectlyWrittenException {

        char[] ch = pass.toCharArray();

        if (ch.length >= 8) {
            for (int i = 0; i < ch.length; i++) {

                if (Character.isUpperCase(ch[i])) {
                    isCapitalLetterIncluded = Character.isUpperCase(ch[i]);
                }

                if (Character.isLowerCase(ch[i])) {
                    isLowercaseLetterIncluded = Character.isLowerCase(ch[i]);
                }

                if (Character.isDigit(ch[i])) {
                    isDigitIncluded = Character.isDigit(ch[i]);
                }

                if (Character.isLetterOrDigit(ch[i])) {
                    isSpecialSymbolIncluded = Character.isLetterOrDigit(ch[i]);
                }

                if (!isLetterLatin(ch[i]) && Character.isLetter(ch[i])) {
                    areLettersLatin = false;
                }
            }
        } else {
            throw new ThePassIsIncorrectlyWrittenException(
                    context.getResources().getString(R.string.PassLengthIsLessThanEight)
            );
        }
        checkIfTheConditionsAreSatisfied();
        return true;
    }

    private void checkIfTheConditionsAreSatisfied() throws ThePassIsIncorrectlyWrittenException {

        if (!isCapitalLetterIncluded) {
            throw new ThePassIsIncorrectlyWrittenException(
                    context.getResources().getString(R.string.CapitalLetterIsNotIncluded));
        }

        if (!isLowercaseLetterIncluded) {
            throw new ThePassIsIncorrectlyWrittenException(
                    context.getResources().getString(R.string.LowercaseLetterIsNotIncluded));
        }

        if (!isDigitIncluded) {
            throw new ThePassIsIncorrectlyWrittenException(
                    context.getResources().getString(R.string.DigitIsNotIncluded));
        }

        if (!isSpecialSymbolIncluded) {
            throw new ThePassIsIncorrectlyWrittenException(
                    context.getResources().getString(R.string.SpecialSymbolsAreNotIncluded));
        }

        if (!areLettersLatin) {
            throw new ThePassIsIncorrectlyWrittenException(
                    context.getResources().getString(R.string.LettersAreNotLatin));
        }
    }

    private Boolean isLetterLatin(char l) {
        return String.valueOf(l).matches("\\p{IsLatin}+");
    }

}
