package com.test.java8;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class NewComparator {

    public static void main(String[] args) {

    }

    public static void sortOld(){
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Jane",54));
        personList.add(new Person("Dave",21));
        personList.add(new Person("Carl",34));

        // Here we are using an anonymous comparator to sort the List.
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        personList.forEach(System.out::println);
    }

    //sort using comparing
    public static void sortNew(){
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Jane", 54));
        personList.add(new Person("Dave", 21));
        personList.add(new Person("Carl", 34));
        //reversed for descending order
        Collections.sort(personList, Comparator.comparing(Person::getName).reversed());
        personList.forEach(System.out::println);

    }

    //sort chaining
    public static void sortNewChain(){
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Jane",54));
        personList.add(new Person("Dave",21));
        personList.add(new Person("Carl",34));
        personList.add(new Person("Dave",58));
        personList.add(new Person("Carl",12));

        //Using thenComparing() method to sort the List on the basis of two criterias.
        Collections.sort(personList, Comparator.comparing(Person::getName).reversed().thenComparing(Person::getAge).reversed());
        personList.forEach(System.out::println);
    }

    //natural order sorting
    public static void naturalSort(){
        List<String> fruits = new ArrayList<>();
        fruits.add("guava");
        fruits.add("peach");
        fruits.add("apple");
        fruits.add("banana");
        Collections.sort(fruits, Comparator.naturalOrder());
        fruits.forEach(System.out::println);
    }

    public static void reverseOrder(){
        List<String> fruits = new ArrayList<>();
        fruits.add("guava");
        fruits.add("peach");
        fruits.add("apple");
        fruits.add("banana");
        // Sorting the List in reverse order.
        Collections.sort(fruits, Comparator.reverseOrder());
        fruits.forEach(System.out::println);
    }

    public static void nullFirstNullLast(){
        List<String> fruits = new ArrayList<>();
        fruits.add("guava");
        fruits.add(null);
        fruits.add("apple");
        fruits.add("banana");

        // Sorting the List keeping nulls first.
        Collections.sort(fruits, Comparator.nullsFirst(Comparator.naturalOrder()));
        fruits.forEach(System.out::println);
        // Sorting the List keeping nulls last.
        Collections.sort(fruits, Comparator.nullsLast(Comparator.naturalOrder()));
        fruits.forEach(System.out::println);


    }
}


class Person {
    String name;
    int age;
    int yearsOfService;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}