package com.bt.elderbracelet.activity;

import com.bt.elderbracelet.tools.SpHelp;

/**
 * Created by Administrator on 2017/9/28.
 */

public class Test {
    public static void main(String[] args)
    {
        Person p = new Person("乐华",20);
        SpHelp.saveObject("乐华",p);
        Person pp = (Person) SpHelp.getObject("乐华");
        System.out.println(pp);
    }
}

class Person{
    int age;
    String name;

    public Person( String name,int age)
    {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
