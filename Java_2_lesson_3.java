package HomeWork_Java_lvl_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Java_2_lesson_3 {

    public static void main(String[] args) {

        Map<String, Integer> words = new HashMap<>();
        String[] wordsArray = {"hi", "lesson", "joke", "infinity", "mostly",
                             "joke", "instantly", "kindness", "lesson", "get"};
        for (String s : wordsArray) {
            if (words.containsKey(s)) {
                words.put(s, words.get(s) + 1);
            } else words.put(s, 1);
        }
        System.out.print(words);

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("sidorov", "1");
        phoneBook.add("vasiliev", "2");
        phoneBook.add("sidorov", "3");

        phoneBook.get("sidorov");

    }

}

class PhoneBook {

    HashMap<String, ArrayList<Person>> pb = new HashMap<>();
    Person[] persons = new Person[10];{
        persons[0] = new Person("ivanov", "1");
        persons[1] = new Person("petrov", "2");
        persons[2] = new Person("ivanov", "4");
    }

    public void add(String lastname, String phone) {
        if (pb.containsKey(lastname)) {
            ArrayList<Person> persons = pb.get(lastname);
            persons.add(new Person(lastname, phone));
        } else {
            ArrayList<Person> persons = new ArrayList<>();
            persons.add(new Person(lastname, phone));
            pb.put(lastname, persons);
        }
    }

    public ArrayList<String> get(String lastname) {
        if (!pb.containsKey(lastname)) return null;
        ArrayList<Person> persons = pb.get(lastname);
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < persons.size(); i++) {
            result.add(persons.get(i).getPhone());
        }
    return result;
    }
}