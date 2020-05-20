package com.ginko.algorithms.practice.hw;

import java.util.Arrays;
import java.util.Scanner;

public class SortWords {

    /*给定n个字符串，请对n个字符串按照字典序排列。

    输入描述:
    输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
    输出描述:
    数据输出n行，输出结果为按照字典序排列的字符串。

    示例1

            输入
            9
            cap
            to
            cat
            card
            two
            too
            up
            boat
            boot

            输出
            boat
            boot
            cap
            card
            cat
            to
            too
            two
            up*/

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int wordCount = reader.nextInt();
        String[] words = new String[wordCount];

        for (int i = 0; i < wordCount; i++) {
            words[i] = reader.next();
        }
        reader.close();

        Arrays.sort(words, (w1, w2) -> {
            int len1 = w1.length();
            int len2 = w2.length();
            int len = len1 > len2 ? len2 : len1;

            for (int i = 0; i < len; i++) {
                if (w1.charAt(i) < w2.charAt(i)) {
                    return -1;
                } else if (w1.charAt(i) > w2.charAt(i)) {
                    return 1;
                }
            }

            return len == len1 ? len == len2 ? 0 : -1 : 1;
        });

        for (String word : words) {
            System.out.println(word);
        }
    }
}