package android.famme.learnenglishapp.data.storage.tasks;

import android.content.Context;

public class Family extends Task {

    public Family(Context context) {
        super(context);
    }


    public String task1 = "1.  Восстановите пропуски в предложении";

    public String hint1 = "Введите пропущенный фрагмент...";

    public String task1Q = "What does family ___________________?";

    public String task1A = "mean to you";

    public String task2 = "2.  Восстановите пропуски в предложении";

    public String hint2 = "Введите пропущенный фрагмент...";

    public String task2Q = "Maybe the stress of modern life puts ____________________on families.";

    public String task2A = "too much pressure";

    public String hint3 = "Введите исправленное предложение...";

    public String task3 = "3.\tВосстановите порядок слов в предложении";

    public String task3Q = "Brothers and sisters who <u>each don’t other like</u>, parents who never talk to each other.";

    public String task3A = "Brothers and sisters who don’t like each other, parents who never talk to each other.";

    public String hint4 = "Введите исправленное предложение...";

    public String task4 = "4.\tВосстановите порядок слов в предложении";

    public String task4Q = "There is a lot of talk in the news <u>family of breakdown the about life</u>.";

    public String task4A = "There is a lot of talk in the news about the breakdown of family life.";

    public String hint5 = "Введите исправленное слово...";

    public String task5 = "5.\tИсправьте выделенное слово так, чтобы оно стало верным";

    public String task5Q = "I know a lot of families that have many <u>eoblpmrs</u>.";

    public String task5A = "problems";

    public String hint6 = "Введите исправленное слово...";

    public String task6 = "6.\tИсправьте выделенное слово так, чтобы оно стало верным";

    public String task6Q = "It seems as though family life was better a <u>oegraneint</u> or two ago.";

    public String task6A = "generation";

    public String hint7 = "Введите перевод...";

    public String task7 = "7.\tПереведите предложение на русский язык";

    public String task7Q = "In a perfect world, all families should be happy and everyone should get on well together.";

    public String task7A = "В идеальном мире все семьи должны быть счастливы, и все должны хорошо ладить друг с другом.";

    public String hint8 = "Введите перевод...";

    public String task8 = "8.\tПереведите предложение на русский язык";

    public String task8Q = "I know a lot of families that have many problems.";

    public String task8A = "Я знаю много семей, у которых много проблем.";

    public String task9 = "9.\tВерно ли данное утверждение?";

    public String task9Q = "It seems as though single life was better a generation or two ago.";

    public Boolean task9A = false;

    public String task10 = "10.\tВерно ли данное утверждение?";

    public String task10Q = "This means single parents have less time to spend with their children, which solves problems.";

    public Boolean task10A = false;

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
