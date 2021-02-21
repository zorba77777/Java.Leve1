package lesson11;

import java.util.HashMap;
import java.util.Map;

public class Words {

    private static final String[] wordsArr = {
            "creating", "your", "own", "deck", "is",
            "the", "most", "effective",
            "way", "to", "learn", "a",
            "complex", "subject", "subjects",
            "like", "languages", "and",
            "like", "languages", "and",
            "the", "sciences", "can",
            "be", "understood", "simply", "by", "memorizing",
            "facts", "they", "require", "explanation",
            "and", "context", "to", "learn", "effectively"
    };

    public static void main(String[] args) {
        Map<String, Integer> wordMap = new HashMap<>();
        for (String w : wordsArr) {
            Integer valueOf = wordMap.get(w);
            wordMap.put(w, valueOf == null ? 1 : valueOf + 1);
        }
        System.out.println(wordMap);
    }
}
