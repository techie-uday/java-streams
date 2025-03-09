package com.techieuday.javastreams.sections.section1;

import java.util.*;
import java.util.stream.Collectors;

import static com.techieuday.javastreams.utils.CommonUtils.randomNames;

public class StreamBenchMark {
    public static void main(String[] args) {
        int size = 10_000_000;
        List<String> names = randomNames(size);

        // Traditional Loop Benchmark
        long start = System.currentTimeMillis();
        List<String> loopFiltered = new ArrayList<>();
        for (String name : names) {
            if (name.startsWith("A")) {
                loopFiltered.add(name);
            }
        }
        long loopTime = System.currentTimeMillis() - start;
        System.out.println("For Loop Time: " + loopTime + " ms");

        // Stream Benchmark
        start = System.currentTimeMillis();
        List<String> streamFiltered = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());
        long streamTime = System.currentTimeMillis() - start;
        System.out.println("Stream Time: " + streamTime + " ms");

        // Parallel Stream Benchmark
        start = System.currentTimeMillis();
        List<String> parallelStreamFiltered = names.parallelStream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());
        long parallelTime = System.currentTimeMillis() - start;
        System.out.println("Parallel Stream Time: " + parallelTime + " ms");
    }

}
