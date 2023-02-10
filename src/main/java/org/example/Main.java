package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static final String FILE = "/Users/rvt/IdeaProjects/personality-test/src/main/resources/data.txt";

    public static Map<String, String> readFile(Scanner input) {
        Map<String, String> data = new HashMap<>();
        while(input.hasNextLine()) {
            data.put(input.nextLine(), input.nextLine());
        }
        return data;
    }
    public static void writeFile(Map<String, Integer[]> data, PersonalityTest test) {
        try {
            FileWriter writer = new FileWriter("output.txt");

            for (String key : data.keySet()) {
                writer.write(String.format("%s: %s = %s\n", key, Arrays.toString(data.get(key)), test.getType(data.get(key))));
            }
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("Error.");
            e.printStackTrace();
        }

    }
    public static void main(String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(new File(FILE));
        Map<String, String> rawData = readFile(input);
        PersonalityTest test = new PersonalityTest(rawData);

        Map<String, Integer[]> data = test.createData();

        writeFile(data, test);
    }
}