package Home_work_3;

import java.util.HashMap;
import java.util.HashSet;

public class Phonebook {
    HashMap<String, HashSet<String>> tellphone = new HashMap<>();

    Phonebook() {
    }

    public void add(String FIO, String phonenumber) {
        HashSet<String> phoneBook = tellphone.getOrDefault(FIO, new HashSet<>());
        phoneBook.add(phonenumber);
        this.tellphone.put(FIO, phoneBook);
    }

    public HashSet<String> get(String FIO) {
        return tellphone.get(FIO);
    }
}