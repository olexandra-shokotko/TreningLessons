package Task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    private static final String FILE_NAME = "file2.txt";
    private static final String JSON_FILE_NAME = "user.json";

    public static void main(String[] args) {
        List<User> listOfUsersFromFile = getListOfUsersFromFile(FILE_NAME);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(listOfUsersFromFile);
        writeToFileJson(json, JSON_FILE_NAME);
    }

    public static void writeToFileJson(String json, String fileName) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            byte[] buffer = json.getBytes();
            fileOutputStream.write(buffer, 0, buffer.length);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<User> getListOfUsersFromFile(String fileName) {
        List<User> allUsers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            boolean firstLine = true;

            while (line != null) {
                if (!firstLine) {
                    String[] s = line.split(" ");
                    User newUser = new User(s[0], Integer.parseInt(s[1]));
                    allUsers.add(newUser);
                } else {
                    firstLine = false;
                }

                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return allUsers;
    }
}
