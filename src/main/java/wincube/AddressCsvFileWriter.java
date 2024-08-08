package wincube;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class AddressCsvFileWriter {

    private static final String CSV_EXTENSION = ".csv";

    public static void write(String fileName, List<String> addresses) {
        Path filePath = Paths.get(fileName + CSV_EXTENSION);

        try (BufferedWriter writer = Files.newBufferedWriter(filePath, StandardCharsets.UTF_8)) {
            for (String address : addresses) {
                String csvAddress = address.replace("|", ",");
                writer.write(csvAddress);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing file: " + filePath, e);
        }
    }
}
