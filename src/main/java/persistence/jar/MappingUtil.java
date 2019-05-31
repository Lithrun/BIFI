package persistence.jar;

import model.Address;

import java.util.Map;

public class MappingUtil {
    private MappingUtil() {}

    public static Address loadAddress(Map<String, String> data) {
        Address address = new Address();
        address.setStreet(data.get("STRAAT"));
        address.setStreetNumber(data.get("HUISNUMMER"));
        address.setPostalCode(data.get("POSTCODE"));
        address.setCity(data.get("plaats"));
        return address;
    }
}
