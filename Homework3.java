import java.util.*;
/**
 * Java. Level 2* Lesson 3. Homework 3.
 *
 * @author Petrov Nikolay
 * @version dated Dec 04, 2019
 */
/*
1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список уникальных слов,
из которых состоит массив (дубликаты не считаем). Посчитать сколько раз встречается каждое слово.
2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров. В этот телефонный справочник
с помощью метода add() можно добавлять записи. С помощью метода get() искать номер телефона по фамилии.
Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны
выводиться все телефоны.
Желательно как можно меньше добавлять своего, чего нет в задании (т.е. не надо в телефонную запись
добавлять еще дополнительные поля (имя, отчество, адрес), делать взаимодействие с пользователем через консоль и т.д.).
Консоль желательно не использовать (в том числе Scanner), тестировать просто из метода main() прописывая add() и get().*/

public class Homework3 {

    static void сountWords(String[]words) {
        Integer value;
        Map<String, Integer> hm = new TreeMap<>();
        for (String word : words) {
            hm.put(word, hm.getOrDefault(word, 0) + 1);
        }
        System.out.println(hm);
        System.out.println("Массив имеет " + words.length + " слова и " +
                hm.size() + " уникальных слов.");
    }

    public static void main(String[]args){
         /*Первое задание*/
        String [] words = { "apple", "group", "credit", "Java", "apple", "phone", "winter", "number", "number","study",
                            "speed", "great", "luck", "easy", "credit", "work", "teacher", "room", "computer", "program",
                            "winter", "new", "factor", "gas", "fire", "work", "speed", "program", "luck","Java","study",
                            "great", "factor"};

        ArrayList <String> al = new ArrayList<>();
        int countw;
        for(int i =0; i<words.length; i++){
            if(!al.contains(words[i])){
                al.add(words[i]);
            }
        }
        System.out.println(Arrays.toString(words)); // Исходный массив
        System.out.println("Количество элементов в исходном массиве : " + words.length);

        System.out.println(al);                    //Коллекция из уникальных слов
        System.out.println("Количество уникальных слов: "+ al.size());

        сountWords(words);

        /*Второе задание*/
       PhoneBook spb = new PhoneBook();
        spb.add("Petrov", "863 233 3301");
        spb.add("Ivanov", "815 546 5541");
        spb.add("Sidorov", "825 415 1945");
        spb.add("Petrov", "545 532 1254");
        System.out.println(spb);
        System.out.println(spb.get("Petrov"));
    }
}

class PhoneBook{
    Map <String, String> pb;

    PhoneBook(){
        pb = new HashMap<>();
    }
    void add(String name, String phone){
        pb.put(phone, name);
    }

    List<String> get(String name) {
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, String> entry : pb.entrySet()) {
            if (name.equals(entry.getValue()))
                list.add(entry.getKey());
        }
        return list;
    }

    @Override
    public String toString(){
        return pb.toString();
    }
}
