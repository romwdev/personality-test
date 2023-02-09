package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static final String FILE = "/Users/rvt/IdeaProjects/personality-test/src/main/resources/data.txt";
    public static void main(String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(new File(FILE));
        Map<String, String> data = new HashMap<>();
        while(input.hasNextLine()) {
            data.put(input.nextLine(), input.nextLine());
        }
        PersonalityTest test = new PersonalityTest(data);

        Map<String, Integer[]> betterData = test.createData();
//        test.convertScores(data.get("Princess Leia"));
        for (String key : betterData.keySet()) {
            System.out.printf("%s: %s = %s\n", key, Arrays.toString(betterData.get(key)), test.getType(betterData.get(key)));
        }

    }
}