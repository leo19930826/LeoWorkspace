package com.leo.reflect;

/**
 * Created by LI on 16/6/13.
 */
public class ClassDemo2 {
    public static void main(String[] args) {

        Class c1 = int.class;  //int的类类型
        Class c2 = String.class;    //String类的类类型

        System.out.println(c2.getName());
        System.out.println(c2.getSimpleName());

    }
}
