package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FileService {
    public static List<Integer> readFile(String fileName) {
        List<Integer> numbers = Collections.emptyList();
        try {
            numbers = Files.readAllLines(Paths.get(fileName)).stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return numbers;
    }
}
