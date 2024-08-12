package wincube;

import java.util.ArrayList;
import java.util.List;

public class Address {
    private final String csvAddress;

    public static Address from(String line) {
        String[] columns = line.split("\\|", -1);
        List<String> list =  new ArrayList<>();
        for (String column : columns) {
            if(column.contains(",")) {
                list.add("\"" + column + "\"");
            } else {
                list.add(column);
            }
        }
        return new Address(String.join(",", list));
    }

    private Address(String csvAddress) {
        this.csvAddress = csvAddress;
    }

    public String getCsvAddress() {
        return csvAddress;
    }
}
