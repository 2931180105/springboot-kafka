package com.lucky.springbootkafka.lambda;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: H
 * @description:
 * @program: springboot-kafka
 * @create: 2019-12-19 12:07
 **/
public class lambdaTest {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(10,"张三");
        map.put(20,"李四");
        map.put(30,"王五");
        List<String> list= map.entrySet().stream()
                .filter(a->a.getKey()>=20)
                .map(a->a.getValue())
                .collect(Collectors.toList());
        System.out.println(list);
    }
}
@FunctionalInterface //检测当前接口是否是函数式接口
interface Test1{
    int show(int a,int b);
}

class Person{
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}