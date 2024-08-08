package wincube;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = DirectoryReader.getTxtFileNames();
        for (String name : names) {
            System.out.println("----------------------------------------");
            System.out.printf("%s convert start%n", name);
            List<String> addresses = TxtFileReader.read(name);
            AddressCsvFileWriter.write(name, addresses);
            System.out.printf("%s convert end%n", name);
            System.out.println("----------------------------------------");
        }
    }
}