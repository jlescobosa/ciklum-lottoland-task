package com.github.jlescobosa.automation.ciklum.lottoland.task.utils;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {


    public static String getRandomAlphaNumeric(int len) {
        char[] ch = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
                'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
                'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
                'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
                'w', 'x', 'y', 'z'};

        char[] c = new char[len];
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            c[i] = ch[random.nextInt(ch.length)];
        }
        return new String(c);
    }

    public static String getRandomNumber(long min, long max) {
        return String.valueOf(ThreadLocalRandom.current().nextLong(min, max + 1));
    }

    public static ArrayList<String> getRandomElements(ArrayList<String> input, int numberOfElements) {
        ArrayList<String> output = new ArrayList<>();
        Random rdm = new Random();
        for (int i = 0; i < numberOfElements; i++) {
            int idx = rdm.nextInt(input.size());
            output.add(input.get(idx));
            input.remove(idx);
        }
        return output;
    }
}
