package com.ginko.algorithms.practice.hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Dictionary {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] inputs = line.split("\\s+");
            int totalWord = Integer.parseInt(inputs[0]);
            String brotherWord = inputs[inputs.length - 2];
            int showBrother = Integer.parseInt(inputs[inputs.length - 1]);

            List<String> brothers = new ArrayList<>();
            char[] sortedVar1 = brotherWord.toCharArray();
            Arrays.sort(sortedVar1);
            for (int i = 1; i <= totalWord; i++) {
                if (brotherWord.length() != inputs[i].length()) {
                    continue;
                }

                if (isBrother(brotherWord, inputs[i], sortedVar1)) {
                    brothers.add(inputs[i]);
                }
            }

            System.out.println(brothers.size());
            if (brothers.size() > 0 && showBrother <= brothers.size()) {
                Collections.sort(brothers);
                System.out.println(brothers.get(showBrother - 1));
            }
        }

        reader.close();
    }

    public static boolean isBrother(String word1, String word2, char[] sortedVar1) {
        char[] var2 = word2.toCharArray();
        int diffCharInSamePlaceCount = 0;

        for (int j = 0; j < var2.length; j++) {
            int sortingPlace = var2.length - j - 1;
            if (word1.charAt(sortingPlace) != word2.charAt(sortingPlace)) {
                diffCharInSamePlaceCount++;
            }

            for (int k = 0; k < sortingPlace; k++) {
                if (var2[k] > var2[k + 1]) {
                    swap(var2, k, k + 1);
                }
            }

            if (sortedVar1[sortingPlace] != var2[sortingPlace]) {
                return false;
            }
        }

        return diffCharInSamePlaceCount > 0;
    }

    public static void swap(char[] a, int i, int j) {
        char tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
