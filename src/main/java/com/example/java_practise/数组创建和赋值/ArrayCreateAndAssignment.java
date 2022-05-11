package com.example.java_practise.数组创建和赋值;

import java.util.Scanner;

import org.junit.Test;

public class ArrayCreateAndAssignment {

    /**
     * 普通一维数组
     */
    public static void main(String[] args) {
        // 方法一：使用 {}+new 赋值
        int[] a = new int[]{0, 1, 2, 3, 4, 5};

        // 方法二：使用个数声明，使用for循环赋值
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] b = new int[num];
        for (int i = 0; i < b.length; i++) {
            b[i] = in.nextInt();
        }

        for (int i = 0; i < b.length; i++) {

        }
        // 方法三：使用 {} 直接赋值
        int[] c = {0, 1, 2, 3, 4, 5};

    }

    /**
     * 普通二维数组
     */
    @Test
    public void test1() {
        int[][] a = new int[2][];
        //方法1
        a[0] = new int[2];
        a[0][0] = 1;
        a[0][1] = 2;
        //方法2
        a[0] = new int[]{1, 3};
        a[1] = new int[]{1, 2, 3, 4};

        int[][] a1 = {{1, 2, 3}, {2, 3, 4}};
        System.out.println(a1[0].length);
    }

    /**
     * 对象一维数组
     */
    @Test
    public void test2() {
        //方法一：使用 {}+new 赋值
        Student[] students = new Student[]{new Student("Bser1", 18, 100),
                new Student("1ser2", 18, 100)};
        for (Student s : students) {
            System.out.println(s);
        }
        System.out.println();
        //方法二：使用 {} 直接赋值
        Student stu[] = {new Student("zhang3", 20, 90.0f),
                new Student("lisi", 22, 90.0f),
                new Student("wangwu", 20, 99.0f),
                new Student("zhaoliu", 22, 100.0f)};
        for (Student s : stu) {
            System.out.println(s);
        }
    }
}

class Student {
    private String name;
    private int age;
    private float score;

    public Student(String name, int age, float score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String toString() {
        return name + "\t\t" + age + "\t\t" + score;
    }

}
