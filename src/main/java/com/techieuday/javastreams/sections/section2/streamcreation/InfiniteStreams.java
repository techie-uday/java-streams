package com.techieuday.javastreams.sections.section2.streamcreation;

import java.util.stream.Stream;

public class InfiniteStreams {
    public static void main(String[] args) {
        generate(100);
        iterate(100);
    }

    public static void generate(int limit) {
        Stream.generate(() -> "Hello").limit(limit).forEach(System.out::println);
    }

    public static void iterate(int limit) {
        Stream.iterate(1, n -> n + 1).map(n -> "Hello" + n).limit(limit).forEach(System.out::println);
    }
}
