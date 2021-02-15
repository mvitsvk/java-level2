//1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
// Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем). Посчитать сколько раз встречается каждое слово.
//2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
// В этот телефонный справочник с помощью метода add() можно добавлять записи. С помощью метода get() искать номер телефона по фамилии.
// Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
//
// Желательно как можно меньше добавлять своего, чего нет в задании (т.е. не надо в телефонную запись добавлять еще дополнительные поля (имя, отчество, адрес),
// делать взаимодействие с пользователем через консоль и т.д.). Консоль желательно не использовать (в том числе Scanner),
// тестировать просто из метода main() прописывая add() и get().




        package ru.level2.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        mass();
        System.out.println();
        System.out.println("=======================");
        System.out.println();
        bookphone();
    }

    static public void bookphone(){
        PhoneBook book = new PhoneBook();

        book.add("8-800-001", "Вася");
        book.add("8-800-002", "Вася");
        book.add("8-800-003", "Боря");
        book.add("8-800-004", "Петя");
        book.add("8-800-005", "Катя");
        book.add("8-800-006", "Катя");

        book.get("Вася");

        book.get("Боря");

        System.out.println("ALL " +book.toString());
    }


    static public void mass(){
        ArrayList <String> mass1 = new ArrayList();
        mass1.add("Катя");
        mass1.add("Маня");
        mass1.add("Петя");
        mass1.add("Ханс");
        mass1.add("Ганз");
        mass1.add("Маня");
        mass1.add("Катя");
        mass1.add("Вася");
        mass1.add("Рома");
        mass1.add("Ганз");
        mass1.add("Мурка");
        mass1.add("Шурка");
        mass1.add("Петя");
        mass1.add("Рома");
        mass1.add("Ира");
        mass1.add("Ханс");

        System.out.println("Print Array " + mass1.toString());

        Set <String> mass2 = new HashSet<>();

        mass2.addAll(mass1);

        System.out.println("Print set " + mass2.toString());


        Iterator<String> iterator = mass2.iterator();

        while(iterator.hasNext()){

            int sum = 0;
            String name = iterator.next();

            System.out.print("Name " + name);

            for (int i = 0; i < mass1.size(); i++) if (name == mass1.get(i)) sum++;

            System.out.println(" SUM= " + sum);
        }

    }
}
