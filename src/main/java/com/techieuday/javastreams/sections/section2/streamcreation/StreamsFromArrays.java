package com.techieuday.javastreams.sections.section2.streamcreation;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamsFromArrays {
    public static void main(String[] args) {
        fromIntPrimitiveArray();
        fromLongPrimitiveArray();
        fromDoublePrimitiveArray();
        fromDoublePrimitiveArrayParallel();
        fromObjectArray();
    }

    public static void fromIntPrimitiveArray() {
        int[] numbers = {1, 2, 3, 4, 5};
        IntStream stream = Arrays.stream(numbers);
        stream.forEach(System.out::println);
    }

    public static void fromLongPrimitiveArray() {
        long[] numbers = {1, 2, 3, 4, 5};
        LongStream stream = Arrays.stream(numbers);
        stream.forEach(System.out::println);
    }

    public static void fromDoublePrimitiveArray() {
        double[] numbers = {1, 2, 3, 4, 5};
        DoubleStream stream = Arrays.stream(numbers);
        stream.forEach(System.out::println);
    }

    public static void fromDoublePrimitiveArrayParallel() {
        double[] numbers = {1, 2, 3, 4, 5};
        DoubleStream stream = Arrays.stream(numbers).parallel();
        stream.forEach(System.out::println);
    }

    public static void fromObjectArray() {
        Integer[] numbers = {1, 2, 3, 4, 5};
        Stream<Integer> stream = Arrays.stream(numbers);
        stream.forEach(System.out::println);
    }


}
