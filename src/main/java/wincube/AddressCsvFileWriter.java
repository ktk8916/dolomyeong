package wincube;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class AddressCsvFileWriter {

    private static final String CSV_EXTENSION = ".csv";
    private static final List<String> DEFAULT_HEADER_NAMES = Arrays.asList(
            "ZIP_NO",
            "SIDO",
            "SIDO_ENG",
            "GUNGU",
            "GUNGU_ENG",
            "TOWN","TOWN_ENG",
            "STREET_CODE",
            "STREET_NAME",
            "STREET_NAME_ENG",
            "BASEMENT_YN",
            "BULD_MAIN_NO",
            "BULD_SUB_NO",
            "BULD_MNG_NO",
            "BULK_RECV_NAME",
            "GUNGU_BULD_NAME",
            "LEGAL_DONG_CODE",
            "LEGAL_DONG_NAME",
            "RI",
            "HANG_DONG_NAME",
            "SAN_YN",
            "BUNGI_MAIN",
            "DONG_SEQ",
            "BUNGI_SUB",
            "OLD_POST",
            "POST_NO"
    );

    public void write(String fileName, List<Address> addresses) {
        Path filePath = Paths.get(fileName + CSV_EXTENSION);

        try (BufferedWriter writer = Files.newBufferedWriter(filePath, StandardCharsets.UTF_8)) {
            String header = String.join(",", DEFAULT_HEADER_NAMES);
            writer.write(header);
            writer.newLine();

            for (Address address : addresses) {
                writer.write(address.getCsvAddress());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing file: " + filePath, e);
        }
    }
}
