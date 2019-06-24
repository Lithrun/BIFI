package persistence.jar;

import java.util.Map;

class OldAddressDTO {
    private Map data;

    OldAddressDTO(Map data) {
        this.data = data;
    }

    String getStreet() {
        return getDataString("STRAAT");
    }

    String getCity() {
        return getDataString("plaats");
    }

    String getStreetNumber() {
        return getDataString("HUISNUMMER");
    }

    String getPostalCode() {
        return getDataString("POSTCODE");
    }

    private String getDataString(String key) {
        return data.containsKey(key) ? data.get(key).toString() : "";
    }
}
