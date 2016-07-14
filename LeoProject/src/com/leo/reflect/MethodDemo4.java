package com.leo.reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by LI on 16/6/15.
 */
public class MethodDemo4 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        ArrayList<String> list1 = new ArrayList<String>();

        Class c1 = list.getClass();
        Class c2=  list1.getClass();
        System.out.println(c1 == c2);


        /*反射的操作都是编译之后的操作
        c1==c2结果返回true说明编译之后集合的泛型是去泛型化的
        JAVA中集合的泛型是防止错误输入的,只在编译阶段有效,绕过编译就无效了
        验证:可以通过方法的反射来操作,绕过编译
        */
        try {
            Method m = c2.getDeclaredMethod("add",Object.class);
            m.invoke(list1,20);  //本来编译阶段不能添加整型参数的,因此绕过了编译操作就绕过了泛型
            System.out.println(list1.size());
            System.out.println(list1);

            //若使用forEach来遍历集合则会产生错误
            /*for (String str: list1) {
                System.out.println(str);
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
