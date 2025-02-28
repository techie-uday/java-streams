package com.techieuday.javastreams.sections.section2.streamcreation;
// Learn Java Streams: Streams from Files Operations

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileStreamOperations {

    private static final String DATA_DIR = "data/";
    private static final String LOGS_DIR = DATA_DIR + "logs/";
    private static final String EMPLOYEES_CSV = DATA_DIR + "employees.csv";
    private static final String LARGEFILE_LOG = DATA_DIR + "largefile.log";
    private static final String DATA_FILE = DATA_DIR + "data.txt";

    public static void main(String[] args) {
        readFileLineByLine();
        readLinesWithBufferedReader();
        filterLogsBySeverity("ERROR");
        countEntriesInFile("ERROR");
        extractUniqueWords();
        processCSVFile();
        listAllFilesInDirectory();
        findFilesModifiedInLastMonth();
        mergeMultipleFiles();
        parallelProcessLargeFile();
        transformFileContent();
    }

    // 1. Reading a File Line by Line
    private static void readFileLineByLine() {
        System.out.println("Reading file line by line:");
        try (Stream<String> lines = Files.lines(Paths.get(EMPLOYEES_CSV))) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 2. BufferedReader.lines() - Read a file using BufferedReader
    private static void readLinesWithBufferedReader() {
        System.out.println("\nReading file using BufferedReader.lines():");
        try (BufferedReader br = Files.newBufferedReader(Paths.get("data/employees.csv"))) {
            br.lines().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 2. Filtering Logs by Severity (INFO, ERROR, EXCEPTION, etc.)
    private static void filterLogsBySeverity(String severity) {
        System.out.println("\nFiltering logs for severity: " + severity);
        try (Stream<String> lines = Files.lines(Paths.get(LARGEFILE_LOG))) {
            lines.filter(line -> line.contains(severity))
                 .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 3. Counting Specific Entries in a File
    private static void countEntriesInFile(String keyword) {
        System.out.println("\nCounting occurrences of: " + keyword);
        try (Stream<String> lines = Files.lines(Paths.get(LARGEFILE_LOG))) {
            long count = lines.filter(line -> line.contains(keyword)).count();
            System.out.println("Total count: " + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 4. Extracting Unique Words from a File
    private static void extractUniqueWords() {
        System.out.println("\nExtracting unique words from file:");
        try (Stream<String> lines = Files.lines(Paths.get(EMPLOYEES_CSV))) {
            Set<String> uniqueWords = lines.flatMap(line -> Stream.of(line.split("\s+")))
                                           .map(String::toLowerCase)
                                           .collect(Collectors.toSet());
            uniqueWords.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 5. Processing CSV Files using Streams
    private static void processCSVFile() {
        System.out.println("\nProcessing Employee CSV File:");
        try (Stream<String> lines = Files.lines(Paths.get(EMPLOYEES_CSV))) {
            lines.skip(1) // Skip header
                 .map(line -> line.split(","))
                 .filter(columns -> columns.length >= 5)
                 .forEach(columns -> System.out.println("Employee: " + columns[1] + ", Department: " + columns[2]));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 6. Listing All Files in a Directory
    private static void listAllFilesInDirectory() {
        System.out.println("\nListing all files in the directory:");
        try (Stream<Path> paths = Files.list(Paths.get(LOGS_DIR))) {
            paths.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 7. Finding Files Modified in the Last Month
    private static void findFilesModifiedInLastMonth() {
        System.out.println("\nFinding files modified in the last month:");
        try (Stream<Path> files = Files.find(Paths.get(LOGS_DIR), 1,
                (path, attr) -> attr.lastModifiedTime()
                        .toMillis() > System.currentTimeMillis() - 30L * 24 * 60 * 60 * 1000)) {
            files.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 8. Merging Multiple Files into a Single Stream
    private static void mergeMultipleFiles() {
        System.out.println("\nMerging multiple log files:");
        try (Stream<Path> files = Files.list(Paths.get(LOGS_DIR))) {
            files.filter(Files::isRegularFile)
                 .flatMap(file -> {
                     try {
                         return Files.lines(file);
                     } catch (IOException e) {
                         return Stream.empty();
                     }
                 })
                 .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 9. Parallel Processing of Large Files
    private static void parallelProcessLargeFile() {
        System.out.println("\nParallel processing large log file:");
        try (Stream<String> lines = Files.lines(Paths.get(LARGEFILE_LOG)).parallel()) {
            long count = lines.filter(line -> line.contains("ERROR")).count();
            System.out.println("Total ERROR logs: " + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 10. Transforming File Content using Streams
    private static void transformFileContent() {
        System.out.println("\nTransforming file content:");
        try (Stream<String> lines = Files.lines(Paths.get(DATA_FILE))) {
            List<String> transformedLines = lines.map(String::toUpperCase)
                                                 .collect(Collectors.toList());
            Files.write(Paths.get("transformed_data.txt"), transformedLines);
            System.out.println("Transformed file saved as transformed_data.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
