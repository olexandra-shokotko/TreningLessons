package Task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Task3 {
    private static final String FILE_NAME = "words.txt";

    public static void main(String[] args) {
        System.out.println(getAllWordFromFile(FILE_NAME));
        System.out.println(countWordsFrequenciesSorted(getAllWordFromFile(FILE_NAME)));
    }

    public static String countWordsFrequenciesSorted(List<String> allWords) {
        Map<String, Integer> wordsFrequencies = new HashMap<>();
        for (String word : allWords) {
            wordsFrequencies.merge(word, 1, Integer::sum);
        }

        LinkedHashMap<String, Integer> sortedWordsFrequencies = wordsFrequencies.entrySet().stream().
                sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
                collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        StringBuilder result = new StringBuilder();
        sortedWordsFrequencies.forEach((k, v) -> result.append(k).append(" ").append(v).append("\n"));

        return result.toString();
    }

    public static List<String> getAllWordFromFile(String fileName) {
        List<String> allWords = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();

            while (line != null) {
                allWords.addAll(Arrays.asList(line.split(" ")));
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return allWords.stream().filter(str -> !str.isBlank()).map(String::trim).collect(Collectors.toList());
    }
}
