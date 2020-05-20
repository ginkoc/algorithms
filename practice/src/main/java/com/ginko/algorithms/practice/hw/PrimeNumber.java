package com.ginko.algorithms.practice.hw;

public class PrimeNumber {

    /*
    功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（如180的质因子为2 2 3 3 5 ）

    最后一个数后面也要有空格

    详细描述：


    函数接口说明：

    public String getResult(long ulDataInput)

    输入参数：

    long ulDataInput：输入的正整数

    返回值：
    String


    输入描述:
    输入一个long型整数


    输出描述:
    按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。
    */

    public String getResult(long ulDataInput) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            double sqrt = Math.sqrt(ulDataInput);
            long i = 2L;

            for (; i < sqrt; i++) {
                if (ulDataInput % i == 0) {
                    ulDataInput /= i;
                    sb.append(i);
                    sb.append(" ");
                    break;
                }
            }

            if (i > sqrt) {
                sb.append(ulDataInput);
                sb.append(" ");
                return sb.toString();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("args = [" + new PrimeNumber().getResult(11) + "]");
    }
}
