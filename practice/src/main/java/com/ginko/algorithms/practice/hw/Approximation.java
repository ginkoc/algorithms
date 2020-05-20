package com.ginko.algorithms.practice.hw;

import java.util.Scanner;

public class Approximation {

    /*
    写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。

    输入描述:
    输入一个正浮点数值

    输出描述:
    输出该数值的近似整数值

    示例1
    输入
    5.5
    输出
    6
     */

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String floatNumber = reader.nextLine();
        reader.close();

        int index = floatNumber.indexOf(".");
        if (index == -1) {
            System.out.println(floatNumber);
            return;
        }

        boolean upon = Integer.valueOf(
                floatNumber.substring(index + 1, index + 2)) >= 5;
        int n = upon ? Integer.valueOf(floatNumber.substring(0, index)) + 1
                : Integer.valueOf(floatNumber.substring(0, index));
        System.out.println(n);
    }
}
