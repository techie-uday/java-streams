package com.techieuday.javastreams.sections.section1;

import java.util.List;
import java.util.stream.Collectors;

import static com.techieuday.javastreams.utils.CommonUtils.atLeastNNamesStartsWith;

public class LazyStreamExample {
    public static void main(String[] args) {
        List<String> names = atLeastNNamesStartsWith(50, 10, "J");
        System.out.println("Names: " + names);

        System.out.println("Before Stream Execution");

        List<String> firstJNames = names.stream()
                .filter(name -> {
                    System.out.println("Filtering: " + name);
                    return name.startsWith("J");
                })
                .limit(2)
                .toList();

        System.out.println("After Stream Execution");
        System.out.println("First name with J: " + firstJNames);
    }
}
