package lesson11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Phonebook {

    private static final Map<String, ArrayList<Long>> phonebook = new HashMap<>();

    public static void main(String[] args) {
        add("Petrov", 79992110111L);
        add("Ivanov", 79112120112L);
        add("Sidorov", 79115480112L);
        add("Ivanov", 79812120112L);
        add("Hruschev", 79112120112L);
        add("Brezhnev", 79123120112L);
        add("Sidorov", 79151320112L);
        add("Sidorov", 79453420112L);
        System.out.println();

        System.out.println("Записи в телефонной книге на текущий момент:");
        get("Vasechkin");
        get("Sidorov");
        get("Brezhnev");
        get("Hruschev");
        get("Ivanov");
        get("Petrov");
    }

    static void add(String name, Long nubmer) {
        ArrayList<Long> phoneOfSomeone = phonebook.get(name);
        if (phoneOfSomeone == null) {
            phoneOfSomeone = new ArrayList<Long>();
        }

        if (!phoneOfSomeone.contains(nubmer)) {
            phoneOfSomeone.add(nubmer);
            phonebook.put(name, phoneOfSomeone);
            System.out.println("В телефонную книгу добавлена запись " + name + " " + nubmer);
        } else {
            System.out.println("В телефонной книге уже есть такая запись");
        }

    }

    static void get(String name) {
        Set<Map.Entry<String, ArrayList<Long>>> mapS = phonebook.entrySet();
        boolean checkName = false;
        for (Map.Entry<String, ArrayList<Long>> mapSEntry : mapS) {
            if (mapSEntry.getKey().equals(name)) {
                System.out.println(name + " " + mapSEntry.getValue());
                checkName = true;
            }
        }
        if (!checkName) {
            System.out.printf("Запись %s не найдена\n", name);
        }
    }
}
