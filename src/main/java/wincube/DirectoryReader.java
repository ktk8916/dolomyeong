package wincube;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class DirectoryReader {

    public static List<String> getTxtFileNames() {
        Path currentDirectory = Paths.get("");
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(currentDirectory)) {
            return Stream.of(directoryStream)
                    .flatMap(paths -> StreamSupport.stream(paths.spliterator(), false))
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .filter(fileName -> fileName.endsWith(".txt"))
                    .map(fileName -> fileName.replace(".txt", ""))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Error reading directory: " + e.getMessage());
        }
    }
}
