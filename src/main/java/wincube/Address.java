package wincube;

public class Address {
    private final String csvAddress;

    public static Address from(String line) {
        String replace = line.replace("|", "\",\"");
        return new Address("\"" + replace + "\"");
    }

    private Address(String csvAddress) {
        this.csvAddress = csvAddress;
    }

    public String getCsvAddress() {
        return csvAddress;
    }
}
