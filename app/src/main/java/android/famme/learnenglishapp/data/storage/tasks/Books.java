package android.famme.learnenglishapp.data.storage.tasks;

import android.content.Context;

/**
 * Тут записаны 10 задании к теме Books, другие классы работают аналогично.
 * ВНИМАНИЕ: При необъодимости тут можно скорректировать тексты заданий!
 * task1 - это текст самого задания, 1 - номер задания;
 * hint1 - это текст к подсказке, которая высвечивается в поле ввода;
 * task1Q - это вопрос к задани;
 * task1A - это ответ к заданию
 *
 *Остальные задания абсолютно одинаковы, за исключением 2 последних,
 * в 2 последних нету переменной hint, а переменные с ответами task9A и
 * task10A имеют тип Boolean, которому можно присвоить только true или false;
 *
 */

public class Books extends Task {
    public Books(Context context) {
        super(context);
    }

    public String task1 = "1.  Восстановите пропуски в предложении";

    public String hint1 = "Введите пропущенный фрагмент...";

    public String task1Q = "Don’t you think books ______________________ thing in the world?";

    public String task1A = "are the best";

    public String task2 = "2.  Восстановите пропуски в предложении";

    public String hint2 = "Введите пропущенный фрагмент...";

    public String task2Q = "I have been ______________________ bookworm since then.";

    public String task2A = "a bit of a";

    public String hint3 = "Введите исправленное предложение...";

    public String task3 = "3.\tВосстановите порядок слов в предложении";

    public String task3Q = "I can’t remember <u>my reading life a when time I in wasn’t</u> a book.";

    public String task3A = "I can’t remember a time in my life when I wasn’t reading a book.";

    public String hint4 = "Введите исправленное предложение...";

    public String task4 = "4.\tВосстановите порядок слов в предложении";

    public String task4Q = " <u>my You’ll see with head usually me</u> buried in a book.";

    public String task4A = "You’ll usually see me with my head buried in a book.";

    public String hint5 = "Введите исправленное слово...";

    public String task5 = "5.\tИсправьте выделенное слово так, чтобы оно стало верным";

    public String task5Q = "Novels are great for getting to know other worlds and <u>ustrcleu</u>.";

    public String task5A = "cultures";

    public String hint6 = "Введите исправленное слово...";

    public String task6 = "6.\tИсправьте выделенное слово так, чтобы оно стало верным";

    public String task6Q = "Books need to be in your hand and made of <u>parep</u>.";

    public String task6A = "paper";

    public String hint7 = "Введите перевод...";

    public String task7 = "7.\tПереведите предложение на русский язык";

    public String task7Q = "I still prefer books to the Internet.";

    public String task7A = "Я по-прежнему предпочитаю книги Интернету.";

    public String hint8 = "Введите перевод...";

    public String task8 = "8.\tПереведите предложение на русский язык";

    public String task8Q = "Encyclopedias are cool too – you can learn everything about everything in these.";

    public String task8A = "Энциклопедии тоже классные – в них можно узнать все обо всем.";

    public String task9 = "9.\tВерно ли данное утверждение?";

    public String task9Q = "I love all kinds of books.";

    public Boolean task9A = true;

    public String task10 = "10.\tВерно ли данное утверждение?";

    public String task10Q = "I also like autobiographies because I think it’s interesting to read about people’s lives.";

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
