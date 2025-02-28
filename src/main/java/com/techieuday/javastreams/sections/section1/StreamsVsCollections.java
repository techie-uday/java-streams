package com.techieuday.javastreams.sections.section1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.techieuday.javastreams.utils.CommonUtils.atLeastNNamesStartsWith;

public class StreamsVsCollections {

    public static void withCollections(List<String> names) {
        List<String> filteredNames = new ArrayList<>();
        for (String name : names) {
            if (name.startsWith("A")) {
                filteredNames.add(name.toUpperCase());
            }
        }
        Collections.sort(filteredNames);
        System.out.println(filteredNames);
    }

    public static void withStreams(List<String> names) {
        List<String> filteredNames = names.stream()
                .filter(name -> name.startsWith("A"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(filteredNames);
    }

    public static void main(String[] args) {
        List<String> names = atLeastNNamesStartsWith(30, 10, "A");
        withCollections(names);
        withStreams(names);
    }
}
