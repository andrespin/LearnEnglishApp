package android.famme.learnenglishapp.data.storage.tasks;

import android.content.Context;

public class Clothes extends Task {
    public Clothes(Context context) {
        super(context);
    }

    public String task1 = "1.  Восстановите пропуски в предложении";

    public String hint1 = "Введите пропущенный фрагмент...";

    public String task1Q = "I have ______________________ clothes.";

    public String task1A = "too many";

    public String task2 = "2.  Восстановите пропуски в предложении";

    public String hint2 = "Введите пропущенный фрагмент...";

    public String task2Q = "The ______________________ I love clothes and I love shopping.";

    public String task2A = "simple truth is";

    public String hint3 = "Введите исправленное предложение...";

    public String task3 = "3.\tВосстановите порядок слов в предложении";

    public String task3Q = " <u>have I only I’ve clothes many</u> worn once.";

    public String task3A = "I have many clothes I’ve only worn once.";

    public String hint4 = "Введите исправленное предложение...";

    public String task4 = "4.\tВосстановите порядок слов в предложении";

    public String task4Q = " <u>sure I’m so need don’t I</u> many clothes.";

    public String task4A = "I’m sure I don’t need so many clothes.";

    public String hint5 = "Введите исправленное слово...";

    public String task5 = "5.\tИсправьте выделенное слово так, чтобы оно стало верным";

    public String task5Q = " Sometimes I even find something at the back of a <u>wardre</u> that I never even wore.";

    public String task5A = "drawer";

    public String hint6 = "Введите исправленное слово...";

    public String task6 = "6.\tИсправьте выделенное слово так, чтобы оно стало верным";

    public String task6Q = "I’m sure I’d be a lot <u>eirchr</u> if I didn’t buy so many clothes.";

    public String task6A = "richer";

    public String hint7 = "Введите перевод...";

    public String task7 = "7.\tПереведите предложение на русский язык";

    public String task7Q = "I have many clothes I’ve only worn once.";

    public String task7A = "У меня есть много одежды, которую я надевал всего один раз.";

    public String hint8 = "Введите перевод...";

    public String task8 = "8.\tПереведите предложение на русский язык";

    public String task8Q = "That’s way too embarrassing.";

    public String task8A = "Это слишком неловко.";

    public String task9 = "9.\tВерно ли данное утверждение?";

    public String task9Q = "The simple truth is I hate clothes and I hate shopping.";

    public Boolean task9A = false;

    public String task10 = "10.\tВерно ли данное утверждение?";

    public String task10Q = "Maybe I have a problem.";

    public Boolean task10A = true;

    @Override
    public String getHint1() {
        return hint1;
    }

    @Override
    public String getTask1() {
        return task1;
    }

    @Override
    public String getTask1Q() {
        return task1Q;
    }

    @Override
    public String getTask1A() {
        return task1A;
    }

    @Override
    public String getHint2() {
        return hint2;
    }

    @Override
    public String getTask2() {
        return task2;
    }

    @Override
    public String getTask2Q() {
        return task2Q;
    }

    @Override
    public String getTask2A() {
        return task2A;
    }

    @Override
    public String getHint3() {
        return hint3;
    }

    @Override
    public String getTask3() {
        return task3;
    }

    @Override
    public String getTask3Q() {
        return task3Q;
    }

    @Override
    public String getTask3A() {
        return task3A;
    }

    @Override
    public String getHint4() {
        return hint4;
    }

    @Override
    public String getTask4() {
        return task4;
    }

    @Override
    public String getTask4Q() {
        return task4Q;
    }

    @Override
    public String getTask4A() {
        return task4A;
    }

    @Override
    public String getHint5() {
        return hint5;
    }

    @Override
    public String getTask5() {
        return task5;
    }

    @Override
    public String getTask5Q() {
        return task5Q;
    }

    @Override
    public String getTask5A() {
        return task5A;
    }

    @Override
    public String getHint6() {
        return hint6;
    }

    @Override
    public String getTask6() {
        return task6;
    }

    @Override
    public String getTask6Q() {
        return task6Q;
    }

    @Override
    public String getTask6A() {
        return task6A;
    }


    @Override
    public String getHint7() {
        return hint7;
    }

    @Override
    public String getTask7() {
        return task7;
    }

    @Override
    public String getTask7Q() {
        return task7Q;
    }

    @Override
    public String getTask7A() {
        return task7A;
    }

    @Override
    public String getHint8() {
        return hint8;
    }

    @Override
    public String getTask8() {
        return task8;
    }

    @Override
    public String getTask8Q() {
        return task8Q;
    }

    @Override
    public String getTask8A() {
        return task8A;
    }

    @Override
    public String getTask9() {
        return task9;
    }

    @Override
    public String getTask9Q() {
        return task9Q;
    }

    @Override
    public Boolean getTask9A() {
        return task9A;
    }

    @Override
    public String getTask10() {
        return task10;
    }

    @Override
    public String getTask10Q() {
        return task10Q;
    }

    @Override
    public Boolean getTask10A() {
        return task10A;
    }

}
