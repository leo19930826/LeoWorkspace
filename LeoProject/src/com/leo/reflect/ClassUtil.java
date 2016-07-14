package com.leo.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by LI on 16/6/13.
 */
public class ClassUtil {

    /**
     * 打印类的信息
     */
    public static void printClassMessage(Object obj) throws NoSuchMethodException {

        //要获取类的信息,首先要获取类的类类型
        Class c = obj.getClass(); //传递的是哪个子类的对象,c就是该子类的类类型

        //获取类的名称
        System.out.println("类的全限定名称是:"+c.getName());

        /*
        1.Method类,方法对象
        一个成员方法就是一个Method对象
        getMethods()方法获取的是所有的public方法,包括从父类那继承过来的
        getDeclaredMethods()方法获取的是所有该类自己声明的方法,不问访问权限
         */
        Method[] ms = c.getMethods();

        Method[] mm = c.getDeclaredMethods();

        for (int i = 0; i< ms.length;i++){
            //得到方法的返回值类型的类类型
            Class returnType = ms[i].getReturnType();
            System.out.println(returnType.getName());

            //得到方法的名称
            System.out.println(ms[i].getName());

            //获取参数类型--->得到的是参数列表的类型的类类型
            Class[] paramTypes = ms[i].getParameterTypes();
            for (Class param : paramTypes) {
                System.out.println(param.getName());
            }

            /*
            2.Field,成员变量对象
            一个成员变量就是一个Field对象,Field类封装了关于成员变量的操作
            getFields()方法获取的是所有的public的成员变量的信息
            getDeclaredFields()方法获取的是该类自己生命的成员变量的信息
             */
            Field[] fs = c.getFields();
            Field[] ff = c.getDeclaredFields();

            for(Field field : ff) {
                //得到成员变量的类型的类类型
                Class fieldType = field.getType();
                String typeName = fieldType.getName();

                //得到成员变量的名称
                String fieldName = field.getName();
            }

            /*
            3.Constructor,构造函数对象
            一个构造函数就是一个Constructor对象,Constructor类封装了关于构造函数的操作
            getConstructors()方法得到所有的public构造函数
            getDeclaredConstructors()方法得到自己的构造函数
             */
            Constructor[] cs = c.getConstructors();
            Constructor[] cst = c.getDeclaredConstructors();
            for(Constructor constructor : cst) {
                System.out.println(constructor.getName());
                //获取构造函数的参数列表
                Class[] paramType = constructor.getParameterTypes();
                for (Class class1 : paramTypes) {
                    System.out.println(class1.getName());
                }
            }
        }
    }
}
