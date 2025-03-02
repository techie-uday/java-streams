package com.techieuday.javastreams.sections.section1;

import java.util.ArrayList;
import java.util.List;

import static com.techieuday.javastreams.utils.CommonUtils.randomNames;

public class WhatAreStreams {

    public static void main(String[] args) {
        long generationStartTime = System.currentTimeMillis();
        List<String> randomNames = randomNames(10000000);
        long generationTime = System.currentTimeMillis() - generationStartTime;
        System.out.println("Names Generation has taken: " + generationTime + " ms");

        long startWithoutStreams = System.currentTimeMillis();
        convertNamesToUpperWithoutStreams(randomNames);
        long timeWithoutStreams = System.currentTimeMillis() - startWithoutStreams;
        System.out.println("Time taken without streams: " + timeWithoutStreams + " ms");

        long startWithStreams = System.currentTimeMillis();
        convertNamesToUpperWithStreams(randomNames);
        long timeWithStreams = System.currentTimeMillis() - startWithStreams;
        System.out.println("Time taken with streams: " + timeWithStreams + " ms");

        long startWithParallelStreams = System.currentTimeMillis();
        convertNamesToUpperWithParallelStreams(randomNames);
        long timeWithParallelStreams = System.currentTimeMillis() - startWithParallelStreams;
        System.out.println("Time taken with parallel streams: " + timeWithParallelStreams + " ms");

    }

    public static List<String> convertNamesToUpperWithoutStreams(List<String> names) {
        List<String> upperCaseNames = new ArrayList<>();
        for (String name : names) {
            upperCaseNames.add(name.toUpperCase());
        }
        return upperCaseNames;
    }

    public static List<String> convertNamesToUpperWithStreams(List<String> names) {
       return names.stream().map(String::toUpperCase).toList();
    }

    public static List<String> convertNamesToUpperWithParallelStreams(List<String> names) {
        return names.parallelStream().map(String::toUpperCase).toList();
    }


}
