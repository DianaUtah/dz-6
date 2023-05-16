import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] words = {"мама", "тата", "їж їжак желе", "абракадабра"};
        Set<Character> letters = findLetters(words);
        System.out.println(letters);
    }

    public static Set<Character> findLetters(String[] words) {
        List<String> foundWords = new ArrayList<>();

        for (String word : words) {
            int[] counts = new int[Character.MAX_VALUE + 1];
            boolean isEven = true;

            for (char c : word.toCharArray()) {
                if (Character.isLetter(c)) {
                    counts[Character.toLowerCase(c)]++;
                }
            }

            for (int count : counts) {
                if (count % 2 != 0) {
                    isEven = false;
                    break;
                }
            }

            if (isEven) {
                foundWords.add(word);
                if (foundWords.size() == 2) {
                    break;
                }
            }
        }

        Set<Character> letters = new HashSet<>();

        for (String word : foundWords) {
            for (char c : word.toCharArray()) {
                if (Character.isLetter(c)) {
                    letters.add(Character.toLowerCase(c));
                }
            }
        }

        return letters;
    }
}