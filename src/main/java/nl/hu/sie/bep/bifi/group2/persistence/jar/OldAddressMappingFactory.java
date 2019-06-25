package nl.hu.sie.bep.bifi.group2.persistence.jar;

import model.Address;
import nl.hu.sie.bep.bifi.group2.persistence.jar.generic.MappingFactory;

import java.util.Map;

public class OldAddressMappingFactory implements MappingFactory<Address> {
    private Address address = null;

    public Address convertFromMap(Map data) {
        if (!data.isEmpty()) {
            OldAddressDTO dto = new OldAddressDTO(data);
            address = transferDTO(dto);
        }
        return address;
    }

    private Address transferDTO(OldAddressDTO dto) {
        address = new Address();
        address.setStreet(dto.getStreet());
        address.setStreetNumber(dto.getStreetNumber());
        address.setCity(dto.getCity());
        address.setPostalCode(dto.getPostalCode());
        return address;
    }
}
