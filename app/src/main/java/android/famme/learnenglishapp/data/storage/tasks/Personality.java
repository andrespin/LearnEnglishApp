package android.famme.learnenglishapp.data.storage.tasks;

import android.content.Context;
import android.famme.learnenglishapp.R;
import android.graphics.Color;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;

public class Personality extends Task {

    public Personality(Context context) {
        super(context);
    }

    public String task1 = context.getString(R.string.personality_task1);

    public String hint1 = "Введите пропущенный фрагмент...";

    @Override
    public String getHint1() {
        return hint1;
    }

    @Override
    public String getTask1() {
        return task1;
    }

    public String task1Q = context.getString(R.string.personality_task1Q);

    @Override
    public String getTask1Q() {
        return task1Q;
    }

    public String task1A = context.getString(R.string.personality_task1A);

    @Override
    public String getTask1A() {
        return task1A;
    }

    public String hint2 = "Введите пропущенный фрагмент...";

    @Override
    public String getHint2() {
        return hint2;
    }

    public String task2 = context.getString(R.string.personality_task2);

    @Override
    public String getTask2() {
        return task2;
    }

    public String task2Q = context.getString(R.string.personality_task2Q);

    @Override
    public String getTask2Q() {
        return task2Q;
    }

    public String task2A = context.getString(R.string.personality_task2A);

    @Override
    public String getTask2A() {
        return task2A;
    }

    public String hint3 = "Введите исправленное предложение...";

    @Override
    public String getHint3() {
        return hint3;
    }

    public String task3 = context.getString(R.string.personality_task3);

    @Override
    public String getTask3() {
        return task3;
    }

    public String task3Q = "The <u>of friends rubbed personalities my have off</u> on me, which I’m happy about.";

    @Override
    public String getTask3Q() {
        return task3Q;
    }

    public String task3A = context.getString(R.string.personality_task3A);

    @Override
    public String getTask3A() {
        return task3A;
    }

    public String hint4 = "Введите исправленное предложение...";

    @Override
    public String getHint4() {
        return hint4;
    }

    public String task4 = context.getString(R.string.personality_task4);

    @Override
    public String getTask4() {
        return task4;
    }

    public String task4Q = "I have <u>learned let people be how my and with to</u> true character shine.";

    @Override
    public String getTask4Q() {
        return task4Q;
    }

    public String task4A = context.getString(R.string.personality_task4A);

    @Override
    public String getTask4A() {
        return task4A;
    }

    public String hint5 = "Введите исправленное слово...";

    @Override
    public String getHint5() {
        return hint5;
    }

    public String task5 = context.getString(R.string.personality_task5);

    @Override
    public String getTask5() {
        return task5;
    }

    public String task5Q = "I think it’s very interesting to <u>peoerxl</u> personality.";

    @Override
    public String getTask5Q() {
        return task5Q;
    }

    public String task5A = context.getString(R.string.personality_task5A);

    @Override
    public String getTask5A() {
        return task5A;
    }

    public String hint6 = "Введите исправленное слово...";

    @Override
    public String getHint6() {
        return hint6;
    }

    public String task6 = context.getString(R.string.personality_task6);

    @Override
    public String getTask6() {
        return task6;
    }

    public String task6Q = "I was painfully shy, but now I’m brimming with <u>cdfnoienec</u>.";

    @Override
    public String getTask6Q() {
        return task6Q;
    }

    public String task6A = context.getString(R.string.personality_task6A);

    @Override
    public String getTask6A() {
        return task6A;
    }

    public String hint7 = "Введите перевод...";

    @Override
    public String getHint7() {
        return hint7;
    }

    public String task7 = context.getString(R.string.personality_task7);

    @Override
    public String getTask7() {
        return task7;
    }

    public String task7Q = context.getString(R.string.personality_task7Q);

    @Override
    public String getTask7Q() {
        return task7Q;
    }

    public String task7A = context.getString(R.string.personality_task7A);

    @Override
    public String getTask7A() {
        return task7A;
    }

    public String hint8 = "Введите перевод...";

    @Override
    public String getHint8() {
        return hint8;
    }

    public String task8 = context.getString(R.string.personality_task8);

    @Override
    public String getTask8() {
        return task8;
    }

    public String task8Q = context.getString(R.string.personality_task8Q);

    @Override
    public String getTask8Q() {
        return task8Q;
    }

    public String task8A = context.getString(R.string.personality_task8A);

    @Override
    public String getTask8A() {
        return task8A;
    }

    public String task9 = context.getString(R.string.personality_task9);

    @Override
    public String getTask9() {
        return task9;
    }

    public String task9Q = context.getString(R.string.personality_task9Q);

    @Override
    public String getTask9Q() {
        return task9Q;
    }

    public Boolean task9A = false;

    @Override
    public Boolean getTask9A() {
        return task9A;
    }

    public String task10 = context.getString(R.string.personality_task10);

    @Override
    public String getTask10() {
        return task10;
    }

    public String task10Q = context.getString(R.string.personality_task10Q);

    @Override
    public String getTask10Q() {
        return task10Q;
    }

    public Boolean task10A = true;

    @Override
    public Boolean getTask10A() {
        return task10A;
    }
}
