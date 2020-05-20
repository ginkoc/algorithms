package com.ginko.algorithms.practice.hw;

import java.util.Scanner;

public class StringSplit {

    /*
    连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
    长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。

    输入描述：

    连续输入字符串(输入2次,每个字符串长度小于100)

    输出描述：

    输出到长度为8的新字符串数组

    示例1：

    输入：

    abc
    123456789
    输出：

    abc00000
    12345678
    90000000
    */

    public static void main(String[] args) {
        final int subLen = 8;
        Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        reader.nextLine();
        String[] lines = new String[n];
        for (int k = 0; k < n; k++) {
            lines[k] = reader.nextLine();
        }
        reader.close();


        for (String line : lines) {
            if ("".equals(line)) {
                continue;
            }

            int len = line.length();
            int index = 0;
            StringBuilder shower;

            while (true) {
                int distance = len - index;
                if (distance < subLen) {
                    if (distance > 0) {
                        shower = new StringBuilder(line.substring(index));

                        for (int i = 0; i < subLen - distance; i++) {
                            shower.append("0");
                        }

                        System.out.println(shower);
                    }
                    break;
                } else {
                    System.out.println(line.substring(index, index + subLen));
                }

                index += subLen;
            }
        }
    }
}
