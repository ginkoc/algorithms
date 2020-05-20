package com.ginko.algorithms.practice.hw;

import java.util.Scanner;

public class BaseConversion {
    /*
    写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。（多组同时输入 ）

    输入描述:
    输入一个十六进制的数值字符串。


    输出描述:
    输出该数值的十进制字符串。

    示例1
    输入
    0xA
    输出
    10
     */

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String input;
        while (reader.hasNext()) {
            input = reader.nextLine().replaceAll("0x", "");
            System.out.println(Long.parseLong(input, 16));
        }
        reader.close();
    }
}
