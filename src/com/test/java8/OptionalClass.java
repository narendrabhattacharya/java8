package com.test.java8;

import java.util.Optional;
import java.util.HashMap;
import java.util.Map;

public class OptionalClass {

    Map<Integer, Emp> empMap = new HashMap<>();
    public Emp getEmp(Integer empId) {
        return empMap.get(empId);
    }

    public Optional<Emp> getEmpOptional(Integer empId) {
        // Before returning the employee object we are wrapping it into an Optional
        //Optional.of -> use only when object is not null
        //Optional.empty() -> creates null
        return Optional.ofNullable(empMap.get(empId));
    }

    public static void main(String[] args) {
        OptionalClass demo = new OptionalClass();
        //Emp e = demo.getEmp(123);
        //this will throw null pointer exception because e is null
        //System.out.println(e.getName());
        Optional<Emp> emp = demo.getEmpOptional(123);
        //this will throw null pointer exception because e is null
        if(emp.isPresent()) System.out.println(emp.get().getName());
        else System.out.print("Employee not present");
    }


}

  class Emp {
        String name;
        int age;
        int salary;

      Emp(String name) {
            this.name = name;
        }

      Emp(String name, int age, int salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
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


