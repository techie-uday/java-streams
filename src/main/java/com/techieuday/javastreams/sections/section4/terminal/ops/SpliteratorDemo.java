package com.techieuday.javastreams.sections.section4.terminal.ops;

import java.util.*;
import java.util.function.Consumer;

import static com.techieuday.javastreams.constants.Constants.*;
import static com.techieuday.javastreams.utils.CommonUtils.randomNames;

public class SpliteratorDemo {

    static class CustomSpliterator<T> implements Spliterator<T> {
        private final List<T> list;
        private int current = 0;

        public CustomSpliterator(List<T> list) {
            this.list = list;
        }

        @Override
        public boolean tryAdvance(Consumer<? super T> action) {
            if (current < list.size()) {
                action.accept(list.get(current++));
                return true;
            }
            return false;
        }

        @Override
        public Spliterator<T> trySplit() {
            int size = list.size() - current;
            if (size < 2) {
                return null; // Not enough elements to split
            }
            int splitIndex = current + size / 2;
            List<T> subList = list.subList(current, splitIndex);
            current = splitIndex;
            return new CustomSpliterator<>(subList);
        }

        @Override
        public long estimateSize() {
            return list.size() - current;
        }

        @Override
        public int characteristics() {
            return ORDERED | SIZED | SUBSIZED;
        }
    }

    // Using spliterator()
    public static void usingSpliterator() {
        List<String> names = randomNames(MEDIUM_LIMIT);
        Spliterator<String> spliterator = names.stream().spliterator();
        spliterator.forEachRemaining(name -> System.out.println("Processing: " + name));
    }

    // Example: Using Iterator.forEachRemaining()
    public static void usingIteratorForEachRemaining() {
        List<String> names = randomNames(MEDIUM_LIMIT);
        Iterator<String> iterator = names.iterator();
        System.out.println("Using Iterator.forEachRemaining():");
        iterator.forEachRemaining(System.out::println);
    }

    // Example: Using Spliterator.forEachRemaining()
    public static void usingSpliteratorForEachRemaining() {
        List<String> names = randomNames(MEDIUM_LIMIT);
        Spliterator<String> spliterator = names.spliterator();

        System.out.println("Using Spliterator.forEachRemaining():");
        spliterator.forEachRemaining(System.out::println);
    }

    // Example: Using trySplit() to divide workload
    public static void usingTrySplit() {
        List<String> names = randomNames(SHORT_LIMIT);
        Spliterator<String> spliterator1 = names.spliterator();
        Spliterator<String> spliterator2 = spliterator1.trySplit();
        long size1 = spliterator1.estimateSize();
        long size2 = spliterator2.estimateSize();
        System.out.println("Processing from Spliterator 1:");
        spliterator1.forEachRemaining(System.out::println);
        System.out.println("\nProcessing from Spliterator 2:");
        if (spliterator2 != null) {
            spliterator2.forEachRemaining(System.out::println);
        }
    }

    // Example: Using tryAdvance()
    public static void usingTryAdvance() {
        List<String> names = randomNames(MEDIUM_LIMIT);
        Spliterator<String> spliterator = names.spliterator();

        System.out.println("Processing one element at a time using tryAdvance():");
        while (spliterator.tryAdvance(System.out::println));
    }

    // Example: Using characteristics()
    public static void usingCharacteristics() {
        List<String> names = randomNames(MEDIUM_LIMIT);
        Spliterator<String> spliterator = names.spliterator();

        int characteristics = spliterator.characteristics();
        System.out.println("Raw Characteristics Value: " + characteristics);

        System.out.println("Decoded Characteristics:");
        System.out.println("ORDERED? " + ((characteristics & Spliterator.ORDERED) != 0));
        System.out.println("DISTINCT? " + ((characteristics & Spliterator.DISTINCT) != 0));
        System.out.println("SORTED? " + ((characteristics & Spliterator.SORTED) != 0));
        System.out.println("SIZED? " + ((characteristics & Spliterator.SIZED) != 0));
        System.out.println("SUBSIZED? " + ((characteristics & Spliterator.SUBSIZED) != 0));
        System.out.println("IMMUTABLE? " + ((characteristics & Spliterator.IMMUTABLE) != 0));
        System.out.println("NONNULL? " + ((characteristics & Spliterator.NONNULL) != 0));
        System.out.println("CONCURRENT? " + ((characteristics & Spliterator.CONCURRENT) != 0));
    }

    // Example: Using a Custom Spliterator
    public static void usingCustomSpliterator() {
        List<String> names = List.of("Amit", "Raj", "Suresh", "Vikram", "Neha", "Divya", "Rohan");
        CustomSpliterator<String> customSpliterator = new CustomSpliterator<>(names);

        System.out.println("Processing from Custom Spliterator:");
        customSpliterator.forEachRemaining(System.out::println);
    }

    public static void main(String[] args) {
        usingSpliterator();
        usingIteratorForEachRemaining();
        System.out.println();
        usingSpliteratorForEachRemaining();
        System.out.println();
        usingTrySplit();
        System.out.println();
        usingTryAdvance();
        System.out.println();
        usingCharacteristics();
        System.out.println();
        usingCustomSpliterator();
    }
}



