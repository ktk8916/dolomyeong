package wincube;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TxtFileReader {

    private static final String TXT_EXTENSION = ".txt";

    public static List<String> read(String fileName) {
        Path filePath = Paths.get(fileName + TXT_EXTENSION);
        List<String> contents = new ArrayList<>();

        try (BufferedReader bufferedReader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            boolean isFirst = true;
            int lineCount = 0;

            String readLine;
            while ((readLine = bufferedReader.readLine()) != null) {
                if (!isFirst) {
                    lineCount++;
                    contents.add(readLine);
                }
                isFirst = false;
            }

            System.out.printf("read %d line%n", lineCount);
            return contents;
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + filePath, e);
        }
    }
}
