package com.ginko.algorithms.algorithms4.exercise.ex1_3;


import com.ginko.algorithms.algorithms4.basis.LinkedListStack;

public class ExpressionFixer {

    private static final String PLUG = "+";
    private static final String MIN = "-";
    private static final String MUL = "*";
    private static final String DIV = "/";
    private static final String SQRT = "sqrt";

    public static String fix(String s) {
        LinkedListStack<String> ops = new LinkedListStack<String>();
        LinkedListStack<String> exps = new LinkedListStack<String>();
        String[] stringArr = s.trim().split("\\s+");

        for (String str : stringArr) {
            if (str.equals(PLUG) || str.equals(MIN) || str.equals(MUL) || str.equals(DIV) || str.equals(SQRT)) {
                ops.push(str);
            } else if (str.equals(")")) {
                String op = ops.pop();
                String exp;
                if (op.equals(SQRT)) {
                    exp = SQRT + " ( " + exps.pop() + " )";
                } else {
                    String exp1 = exps.pop();
                    exp = "( " + exps.pop() + " " + op + " " + exp1 + " )";
                }

                exps.push(exp);
            } else {
                exps.push(String.valueOf(str));
            }
        }

        if (exps.size() > 1) {
            throw new IllegalArgumentException("error argument");
        }

        return exps.pop();
    }

    public static void main(String[] args) {
        String s1 = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) ) + 1 + 2 ) )";
        String s2 = "1 + 2 + 3 ) * 4 * 5 ) ) )";
        String s3 = "1 + sqrt 5 ) ) / 2 )";

        System.out.println(fix(s3));
    }
}
