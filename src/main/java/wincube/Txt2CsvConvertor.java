package wincube;

import java.util.List;
import java.util.stream.Collectors;

public class Txt2CsvConvertor {

    private final DirectoryReader directoryReader = new DirectoryReader();
    private final TxtFileReader txtFileReader = new TxtFileReader();
    private final AddressCsvFileWriter addressCsvFileWriter = new AddressCsvFileWriter();

    public void startConvert() {
        List<String> regions = directoryReader.getTxtFileNames();
        for (String region : regions) {
            System.out.println("----------------------------------------");
            System.out.printf("%s convert start%n", region);

            List<Address> addresses = txtFileReader.read(region)
                    .stream()
                    .map(Address::from)
                    .collect(Collectors.toList());

            addressCsvFileWriter.write(region, addresses);

            System.out.printf("%s convert end%n", region);
            System.out.println("----------------------------------------");
        }
    }
}
