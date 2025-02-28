package com.techieuday.javastreams.sections.section2.streamcreation;

import java.util.*;
import java.util.stream.Stream;

import static com.techieuday.javastreams.utils.CommonUtils.generateRandomNames;
import static com.techieuday.javastreams.utils.CommonUtils.range;

public class StreamsFromCollections {

    public static void main(String[] args) {
        createStreamFromList();
        createStreamFromSet();
        createStreamFromMap();
        createParallelStreamFromList();
    }

    public static void createStreamFromList() {
        List<String> names = generateRandomNames(20);
        Stream<String> nameStream = names.stream();
        nameStream.forEach(System.out::println);
    }

    public static void createStreamFromSet() {
        Set<Integer> numbers = new HashSet<>(range(20));
        Stream<Integer> numberStream = numbers.stream();
        numberStream.forEach(System.out::println);
    }

    public static void createStreamFromMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);
        Stream<String> keyStream = map.keySet().stream();
        Stream<Integer> valueStream = map.values().stream();
        Stream<Map.Entry<String, Integer>> entryStream = map.entrySet().stream();
        entryStream.forEach(System.out::println);
        keyStream.forEach(System.out::println);
        valueStream.forEach(System.out::println);
    }

    public static void createParallelStreamFromList() {
//        Generates 1 Million Names
        List<String> names = generateRandomNames(1_000_000);
        Stream<String> nameStream = names.parallelStream();
        nameStream.forEach(System.out::println);
    }
}
