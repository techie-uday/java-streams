package com.techieuday.javastreams.sections.section1;

import java.util.List;

import static com.techieuday.javastreams.utils.CommonUtils.atLeastNNamesStartsWith;

public class DebuggingStreams {

    public static void testPeekEffectsLazy(String[] args) {
        List<String> names = atLeastNNamesStartsWith(30, 10, "A");

        System.out.println("Before Stream Execution");

        List<String> result = names.stream()
                .filter(name -> {
                    System.out.println("Filtering: " + name);
                    return name.startsWith("A");
                })
                .peek(name -> System.out.println("Peeking: " + name))
                .limit(2)
                .toList();

        System.out.println("After Stream Execution");
        System.out.println("Result: " + result);
    }

    public static void main(String[] args) {

    }
}
