package Task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {
    private static final String FILE_NAME = "file1.txt";
    private static final String REGEX = "\\(?\\d{3}\\)?(?: |-)\\d{3}-\\d{4}";

    public static void main(String[] args) {
        outputValidNumbersFromFile(FILE_NAME);
    }

    public static void outputValidNumbersFromFile(String fileName) {
        List<String> allNumbers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            while (line != null) {
                allNumbers.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String number : allNumbers) {
            if (checkIfNumberValid(number, REGEX)) {
                System.out.println(number);
            }
        }
    }

    public static boolean checkIfNumberValid(String number, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);
        return matcher.find();
    }
}
