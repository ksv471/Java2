package Home_work_3;

import java.util.Arrays;
import java.util.HashMap;

public class Home_work_3 {
    public static void main(String[] args) {
        String[] words = new String[]{"Красный", "Оранжевый", "Жёлтый", "Зелёный", "Голубой", "Синий",
                "Фиолетовый", "Красный", "Красный", "Жёлтый", "Зелёный", "Зелёный", "Голубой", "Синий",
                "Фиолетовый", "Фиолетовый"};
        System.out.println("Массив с набором слов: " + Arrays.toString(words));

        HashMap<String, Integer> doubleWords = new HashMap<>();
        for(String i : words) {
            doubleWords.put(i, doubleWords.getOrDefault(i, 0) + 1);
        }

        System.out.println("Количество слов в массиве: " + doubleWords);
        Phonebook pbook = new Phonebook();
        pbook.add("Иванов И.И.", "880053535");
        pbook.add("Федоров Ф.Ф.", "88002006");
        pbook.add("Андреев А.А.", "880020505");
        System.out.println(pbook.get("Иванов И.И."));
        System.out.println(pbook.get("Федоров Ф.Ф."));
        System.out.println(pbook.get("Андреев А.А."));
    }
}