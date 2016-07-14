package com.leo.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by LI on 16/6/15.
 * 1.如何获取某个方法
 *   方法的名称和方法的参数列表才能唯一决定某个方法
 * 2.方法反射的操作
 *   method.invoke(对象,参数列表)
 */
public class MethodDemo1 {
    public static void main(String[] args) {
        //获取print(int, int)方法,1.获取一个方法就是获取类的信息,获取类的信息首先要获取类的类类型
        A a1 = new A();
        Class c = a1.getClass();

        /*
        2.获取方法:名称和参数列表来决定
          getMethod()获取的是public方法
         */
        try {
            Method m = c.getDeclaredMethod("print",new Class[]{int.class, int.class});

            //传统的方法调用方式
            a1.print(20,30);

            //方法的反射操作(利用m对象才进行方法调用)
            //方法如果没有返回值返回null,有返回值返回具体的返回值
           Object o = m.invoke(a1,new Object[]{10, 20});

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

class A {
    public void print(int a, int b) {
        System.out.println(a+b);
    }

    public void print(String a, String b) {
        System.out.println(a.toUpperCase()+ "," +b.toUpperCase());
    }
}
