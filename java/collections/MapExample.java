package collections;

import java.util.HashMap;
import java.util.Map;

public class MapExample {

    public static void main(String[] args) {

        Map<String, Integer> wordsCount;
        System.out.println("Hello World");
        wordsCount = new HashMap<>();
        wordsCount.put("the", 153);
        wordsCount.get("the");
        wordsCount.getOrDefault("duck", 0);
        wordsCount.remove("the");
    }
}
