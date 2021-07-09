package com.test.java8;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class StreamAPI {
    public static void main(String[] args) {
        //createStream();
        terminalOperations();
    }

//Create Stream
public static void createStream() {
        //from varargs
        Stream<Integer> stream1 = Stream.of(1,2,3,4,5);
        stream1.forEach(p -> System.out.println(p));
        //from list
        List<String> list = new ArrayList();
        list.add("a");
        list.add("b");
        Stream<String> stream2 = list.stream();
        stream2.forEach(p -> System.out.println(p));
        //creating primitive streams
        IntStream stream3 = IntStream.of(1,2,3,4,5);
        stream3.forEach(p -> System.out.println(p));
}

//terminal operations on streams
public static void terminalOperations() {
        //filtering -> Stream filter(Predicate<? super T> )
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.stream().filter(num -> num > 2).forEach(System.out::println);

        //mapping
        List<String> list2 = new ArrayList();
        list2.add("Mark");
        list2.add("Andy");
        list2.stream().map(name -> name.toUpperCase() ).forEach(System.out::println);
        list2.stream().mapToInt(name -> name.length()).forEach(System.out::println);

        List<List<String>> list3 = new ArrayList<>();
        list3.add(Arrays.asList("a","b","c"));
        list3.add(Arrays.asList("d","e","f"));

        list3.stream().flatMap(p -> p.stream()).forEach(System.out::println);

        //slicing ->distinct, limit, skip(from first)

        List<String> countries = new ArrayList<>();
        countries.add("USA");
        countries.add("GERMANY");
        countries.add("TURKEY");
        countries.add("NORWAY");
        countries.add("USA");
        countries.add("GERMANY");
        countries.add("TURKEY");
        //works on object.equals()
        countries.stream().distinct().forEach(System.out::println);

        //matching
        //match and find if there exists any county of length 3
        boolean foundAny = countries.stream().anyMatch(p->p.length() == 3);
        System.out.println("Any country name with 3 char :" + foundAny);

        //match and find if there exists all county of length 3
        boolean foundAll = countries.stream().anyMatch(p->p.length() == 3);
        System.out.println("Any country name with 3 char :" + foundAll);

        //match and find if  no element matches the predicate
        boolean foundNone = countries.stream().noneMatch(p-> p.length() ==3);
        System.out.println("No country name with 3 char :" + foundNone);

        //find
        //find and return the first matching predicate
        Optional<String> country = countries.stream().filter(p->p.length() == 3).findFirst();
        if(country.isPresent())  System.out.println(country.get());

        country = countries.stream().filter(p->p.length() == 6).findAny();
        if(country.isPresent())  System.out.println(country.get());

        //reduction
        Optional<Integer> countriesLengthsSum = countries.stream().distinct().map(p-> p.length()).reduce((p,q) -> p + q);
        if(countriesLengthsSum.isPresent())  System.out.println(countriesLengthsSum.get());

        //collect

        //parallel streams
        //seq
        Stream.of(1,2,3,4,5).forEach(n-> System.out.println(n + " " + Thread.currentThread().getName()));
        //parallel
        Stream.of(1,2,3,4,5).parallel().forEach(n-> System.out.println(n + " " + Thread.currentThread().getName()));

}



}
