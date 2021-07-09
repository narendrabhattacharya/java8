package com.test.java8;

import java.util.ArrayList;
import java.util.List;

public class MethodReferences {

    public static void main(String[] args) {
        constuctorReferences();
    }

   public static int getStaticLength(String str){
        return str.length();
   }

    public int getLength(String str){
        return str.length();
    }

   public static void staticMethods(){
        List<String> list = new ArrayList<>();
        list.add("frog");
        list.add("swim");
        list.add("ocean");
        //code without method ref
        list.stream().mapToInt(a -> MethodReferences.getStaticLength(a)).forEach(System.out:: println);
       //code with method ref
        list.stream().mapToInt(MethodReferences::getStaticLength).forEach(System.out::println);
   }

    public static void instanceMethods(){
        List<String> list = new ArrayList<>();
        list.add("frog");
        list.add("swim");
        list.add("ocean");

        MethodReferences mr = new MethodReferences();

        //code without method ref
        list.stream().mapToInt(a -> mr.getLength(a)).forEach(System.out:: println);
        //code with method ref
        list.stream().mapToInt(mr::getLength).forEach(System.out::println);
    }

    public static void arbitraryMethods(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Matt", 34, 2999));
        list.add(new Employee("Mark", 30, 45555));

        //code without method
        list.stream().mapToInt(e -> e.getSalary()).sum();
        //code with method reference
        list.stream().mapToInt(Employee :: getSalary).sum();
    }


    public static void constuctorReferences(){
        List<String> list = new ArrayList<>();
        list.add("Joe");
        list.add("Megan");

        //code without constructor reference
        list.stream().map(name-> new Employee(name)).forEach(System.out::println);
        //code with constructor reference
        list.stream().map(Employee::new).forEach(System.out::println);
    }

}

class Employee {
    String name;
    int age;
    int salary;

    Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
    Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
