package com.ginko.algorithms.practice.hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CombineRecord {

    /*
    数据表记录包含表索引和数值（int范围的整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。

    输入描述:
    先输入键值对的个数
    然后输入成对的index和value值，以空格隔开

    输出描述:
    输出合并后的键值对（多行）

    示例1
    输入
    4
    0 1
    0 2
    1 2
    3 4
    输出
    0 3
    1 2
    3 4
     */

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Map<Integer, Integer> map = new HashMap<>();

        int recordNumber = reader.nextInt();
        Integer k;
        Integer v;
        reader.nextLine();
        for (int i = 0; i < recordNumber; i++) {
            String[] record = reader.nextLine().split(" ");
            k = Integer.valueOf(record[0]);
            v = Integer.valueOf(record[1]);
            if (!map.containsKey(k)) {
                map.put(k, v);
            } else {
                map.put(k, v + map.get(k));
            }
        }
        reader.close();

        List<Integer> sortedList = new ArrayList<>(map.keySet());
        Collections.sort(sortedList);
        sortedList.forEach(key -> System.out.println(key.toString() + " " + map.get(key).toString()));
    }
}
