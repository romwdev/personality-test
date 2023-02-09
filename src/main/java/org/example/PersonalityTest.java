package org.example;

import java.util.HashMap;
import java.util.Map;

public class PersonalityTest {
    Map<String, String> rawData;
    Map<String, Integer[]> data = new HashMap<>();

    public PersonalityTest(Map<String, String> data) {
        rawData = new HashMap<>(data);
    }

    public Integer[] convertScores(String score) {
        Integer[] result = new Integer[4];
        Map<Character, Double> ei = new HashMap<>();
        putValues(ei);
        Map<Character, Double> sn = new HashMap<>();
        putValues(sn);
        Map<Character, Double> tf = new HashMap<>();
        putValues(tf);
        Map<Character, Double> jp = new HashMap<>();
        putValues(jp);


        for (int i = 1; i <= 70; i++) {
            char scoreChar = Character.toUpperCase(score.charAt(i - 1));
            switch (i % 7) {
                case 1:
                    ei.put(scoreChar, ei.get(scoreChar) + 1);
                    break;
                case 2:
                case 3:
                    sn.put(scoreChar, sn.get(scoreChar) + 1);
                    break;
                case 4:
                case 5:
                    tf.put(scoreChar, tf.get(scoreChar) + 1);
                    break;
                case 6:
                case 0:
                    jp.put(scoreChar, jp.get(scoreChar) + 1);
                    break;
            }
        }

        result[0] = (int) ((ei.get('B') / (10 - ei.get('-'))) * 100);
        result[1] = (int) ((sn.get('B') / (20 - sn.get('-'))) * 100);
        result[2] = (int) ((tf.get('B') / (20 - tf.get('-'))) * 100);
        result[3] = (int) ((jp.get('B') / (20 - jp.get('-'))) * 100);

        return result;
    }
    private void putValues(Map<Character, Double> map) {
        map.put('A', 0.0);
        map.put('B', 0.0);
        map.put('-', 0.0);
    }

    public Map<String, Integer[]> createData() {
        for (String key : rawData.keySet()) {
            Integer[] value = convertScores(rawData.get(key));
            data.put(key, value);
        }
        return data;
    }
    public String getType(Integer[] scores) {
        StringBuilder type = new StringBuilder();

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] < 50) {
                type.append(i == 0 ? "E" : i == 1 ? "S" : i == 2 ? "T" : "J");
            } else if (scores[i] > 50) {
                type.append(i == 0 ? "I" : i == 1 ? "N" : i == 2 ? "F" : "P");
            } else {
                type.append("X");
            }
        }
        return type.toString();
    }
}
