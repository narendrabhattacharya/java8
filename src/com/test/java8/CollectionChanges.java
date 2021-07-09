package com.test.java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Iterator;
import java.util.Map;

public class CollectionChanges {
    public static void main(String[] args) {
        forEachRemaining();
        getOfDefault();
        putIfAbsent();
        compute();
        computeIfAbsent();
        computeIfPresent();
    }
    //Iterator improvement
    public static void forEachRemaining() {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Grapes");
        fruits.add("Oranges");
        
        Iterator<String> iterator =  fruits.iterator();
        
        //old way
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        iterator =  fruits.iterator();
        //new way using Consumer
        iterator.forEachRemaining(System.out::println);

    }

    //MAP Api changes

    public static void getOfDefault() {
        Map<String, Integer> fruits = new HashMap<>();
        fruits.put("apple", 20);

        //old way
        if(fruits.containsKey("mango")){
            fruits.put("mango", fruits.get("mango") + 2);
        }else{
            fruits.put("mango", 20);
        }

        //new way
        fruits.put("mango", fruits.getOrDefault("mango", 0)+20);
    }

    public static void putIfAbsent(){
        Map<String, Integer> fruits = new HashMap<>();
        fruits.put("apple", 20);
        System.out.println(fruits.get("apple"));
        fruits.putIfAbsent("apple", 10);
        System.out.println(fruits.get("apple"));
    }

    public static void compute(){
        Map<String, Integer> fruits = new HashMap<>();
        fruits.put("apple", 20);

        int val = fruits.compute("apple", (k, v) -> v +10);
        System.out.println(val);
        // Below line will throw Null Pointer Exception.
        //val = fruits.compute("banana", (k, v) -> v + 10);
    }

    public static void computeIfAbsent(){
        Map<String, Integer> fruits = new HashMap<>();
        fruits.put("apple", 20);
        int val = fruits.computeIfAbsent("apple", v-> 10);
        System.out.println(val);

    }

    public static void computeIfPresent(){
        Map<String, Integer> fruits = new HashMap<>();
        fruits.put("apple", 20);
        int val = Optional.of(fruits.computeIfPresent("banana", (k,v ) -> 10));
        System.out.println(val);

    }

    public static void replace(){
        Map<String, Integer> fruits = new HashMap<>();
        fruits.put("apple", 20);
        fruits.put("banana", 20);

        fruits.replace("apple", 50);
        System.out.println(fruits.get("apple"));
    }

    public static void replaceNewWithOldVal() {
        Map<String, Integer> fruits = new HashMap<>();
        fruits.put("apple", 20);
        fruits.put("banana", 20);

        fruits.replace("apple", 30, 50);

        System.out.println(fruits.get("apple"));
        fruits.replace("apple", 20, 50);
        System.out.println(fruits.get("apple"));
    }

    public static void replaceAll(){
        Map<String, Integer> fruits = new HashMap<>();
        fruits.put("apple", 20);
        fruits.put("banana", 20);

        fruits.replaceAll((k, v) -> 50);  //Value becomes 50 for all keys

        System.out.println(fruits.get("apple"));
        System.out.println(fruits.get("banana"));
    }

    public static void remove(){
        Map<String, Integer> fruits = new HashMap<>();
        fruits.put("apple", 20);
        fruits.put("banana", 20);

        fruits.remove("apple");  //apple will be removed

        System.out.println(fruits.get("apple"));
    }

    public static void removeObjectKeyVal(){
        Map<String, Integer> fruits = new HashMap<>();
        fruits.put("apple", 20);
        fruits.put("banana", 20);

        fruits.remove("apple" , 30);  //apple will not be removed because the value is 20
        System.out.println(fruits.get("apple"));
        fruits.remove("apple" , 20);  //apple will be removed
        System.out.println(fruits.get("apple"));
    }

    public static void iterateMap(){
        Map<String, Integer> fruits = new HashMap<>();
        fruits.put("apple", 10);
        fruits.put("banana", 20);
        fruits.put("orange", 30);
        //consumer that takes
        fruits.forEach((k,v) -> System.out.println("Key: " + k + " Value: " + v));
    }

}
