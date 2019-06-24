package persistence.jar;

import java.util.Map;

class OldAddressDTO {
    private Map data;

    OldAddressDTO(Map data) {
        this.data = data;
    }

    String getStreet() {
        return data.get("STRAAT").toString();
    }

    String getCity() {
        return data.get("plaats").toString();
    }

    String getStreetNumber() {
        return data.get("HUISNUMMER").toString();
    }

    String getPostalCode() {
        return data.get("POSTCODE").toString();
    }
}
