package com.example.java_practise.string;

public class StringMatch {

    /**
     * 字符串匹配
     * <p>
     * 题目：
     * 输入一行字符串包含（），如果匹配成功，返回0；否则返回字符串，并在未匹配的括号下面做标记（用A表示箭头指向上面），显示错误信息。
     * <p>
     * 例如：
     * 输入：
     * a=1+(4*7))/(8+8)
     * 输出：
     * a=1+(4*7))/(8+8)
     * Type
     * 没有匹配的左括号
     */
    public static void match(String s) {
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                counter++;
            }
            if (s.charAt(i) == ')') {
                if (counter == 0) {//缺左括号，直接return，break无法避免下面的代码。
                    System.out.println(s + "的第" + i + "个位置，没有匹配的左括号");
                    System.out.println(s);
                    System.out.println(String.format("%" + (i + 1) + "s", "Type"));
                    return;
                } else {
                    counter--;
                }
            }
        }

        if (counter == 0) {
            System.out.println(s + "完全匹配！");
        } else { //肯定>0，缺右括号。因为缺左括号的情况已经break了。
            //再倒回去走一遍，才能找到第一个缺右括号的位置
            int j = s.length();
            int num = counter;
            while (counter > 0) {
                j--;
                if (s.charAt(j) == ')') {
                    counter++;
                }
                if (s.charAt(j) == '(') {
                    counter--;
                }
            }
            System.out.println(s + "从第" + j + "个位置起，有" + num + "个左括号，没有匹配的右括号");
            System.out.println(s);
            System.out.println(String.format("%" + (j + 1) + "s%" + (num - 1) + "s", "Type", "Type"));
        }
    }

    public static void main(String[] args) {
        String s1 = "(x,f(y,z)),z,w)";
        match(s1);
        String s2 = "((((x,f((y,z)),z,((w)"; //这种情况，搞不定！！！【不是连续的左括号多余，而是隔着蹦着】
        match(s2);
    }

}
