package com.techieuday.javastreams.sections.section4.terminal.ops;

import java.util.List;
import java.util.Iterator;
import java.util.stream.Stream;

import static com.techieuday.javastreams.utils.CommonUtils.*;

public class StreamIterations {

    private static final int NAMES_COUNT = 10;

    // Using forEach()
    public static void usingForEach() {
        List<String> names = randomNames(NAMES_COUNT);
        names.stream().forEach(name -> System.out.println("Processing: " + name));
    }

    // Using forEachOrdered() in Parallel Streams
    public static void usingForEachOrdered() {
        List<String> names = randomNames(NAMES_COUNT);
        Stream<String> nameStream = names.stream().parallel();
        nameStream.forEach(name -> System.out.println("Processing: " + name));
    }

    // Using iterator()
    public static void usingIterator() {
        Stream<String> names = nameStreamIncludes(NAMES_COUNT, "Uday", "Kumar");
        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println("Processing: " + name);
            if (name.equals("Uday")) {
                System.out.println("Stopping early at: Uday");
                break;
            }
        }
    }


    // Using takeWhile() in Java 9+
    public static void usingTakeWhile() {
        Stream<String> names = nameStreamIncludes(NAMES_COUNT, "Uday", "Kumar");
        names.takeWhile(name -> !name.equals("Uday"))
                .forEach(name -> System.out.println("Processing: " + name));
        System.out.println("Stopping early at: Uday");
    }

    public static void main(String[] args) {
        System.out.println("Using forEach():");
        usingForEach();

        System.out.println("\nUsing forEachOrdered():");
        usingForEachOrdered();

        System.out.println("\nUsing Iterator():");
        usingIterator();

        System.out.println("\nUsing takeWhile():");
        usingTakeWhile();
    }
}

