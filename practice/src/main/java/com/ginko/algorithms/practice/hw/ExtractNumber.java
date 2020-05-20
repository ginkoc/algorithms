package com.ginko.algorithms.practice.hw;

import java.util.Scanner;
import java.util.TreeSet;

public class ExtractNumber {
    /*
    输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。

    输入描述:
    输入一个int型整数

    输出描述:
    按照从右向左的阅读顺序，返回一个不含重复数字的新的整数

    示例1
    输入
    9876673
    输出
    37689
     */

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String line = reader.nextLine();
        reader.close();

        TreeSet<Character> set = new TreeSet<>();
        for (int index = line.length() - 1; index >= 0; index--) {
            set.add(line.charAt(index));
        }

        StringBuilder sb = new StringBuilder();
        while (!set.isEmpty()) {
            sb.append(set.pollFirst());
        }
        System.out.println(sb.toString());
    }
}
