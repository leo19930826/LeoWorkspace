package com.leo.reflect;

/**
 * Created by LI on 16/6/13.
 */
public class ClassDemo1 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //Foo的实例对象如何表示(静态加载:静态加载的类在编译时就要提供)
        Foo foo1 = new Foo();
        //Foo这个类也是一个实例对象,任何一个类都是Class的实例对象,该实力对象有三种表示方式

        //第一种表示方式--->任何一个类都哟哟一个硬汉的静态成员变量
        Class c1 = Foo.class;

        //第二种表示方式--->已知该类的对象通过getClass()方法
        Class c2 = foo1.getClass();

        //c1,c2表示了Foo类的类类型(class type)

        //不管c1或者c2都代表了Foo类的类类型,一个类只可能是Class类的一个实例对象
        System.out.println(c1 == c2);

        //第三种表示方式--->(动态加载:动态加载的类在源程序编译时可以缺席)
        Class c3 = Class.forName("com.leo.reflect.Foo");
        System.out.println(c2 == c3);

        //通过类的类类型创建该类的对象实例--->通过c1,c2或c3创建Foo的实例对象
        Foo foo = (Foo)c1.newInstance();  //使用前提:需要有无参构造方法
    }
}

class Foo{
    void print() {

    }
}
