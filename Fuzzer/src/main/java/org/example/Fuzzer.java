package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class Fuzzer {

    public String seed() {
        List<String> supportedBinOps = List.of(Constants.ADDITION, Constants.DIVISION, Constants.SUBTRACTION, Constants.MULTIPLICATION);

        Random random = new Random();
        String randSmt = String.format("(simplify (%s %s %s))", supportedBinOps.get(random.nextInt(supportedBinOps.size())), random.nextInt(1, 100000), random.nextInt(1, 100000));

        return randSmt;

    }

    public void writeBatchSeed(int fileLength) {

        String filePath = "./seed.txt";  // File where the line will be written

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int i = 0; i < fileLength; i++) {

                writer.write(seed());
                writer.newLine(); // Add a newline after the line

            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception
        }
    }
}

