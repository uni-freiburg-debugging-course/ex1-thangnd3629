package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileReader {
    public List<String> readFileFromResources(String fileName) throws IOException {

        InputStream inputStream = FileReader.class.getClassLoader().getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new IllegalArgumentException("File not found: " + fileName);
        }

        try (Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8)) {
            return scanner.useDelimiter("\\A").tokens()
                    .flatMap(text -> text.lines().toList().stream())
                    .collect(Collectors.toList());
        }
    }
}
