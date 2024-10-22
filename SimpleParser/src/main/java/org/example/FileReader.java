package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    public List<String> readFile(String path) throws IOException {

        List<String> lines = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(path); InputStreamReader isr = new InputStreamReader(fis); BufferedReader reader = new BufferedReader(isr)) {

            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }

        // Return the list of lines
        return lines;
    }
}
