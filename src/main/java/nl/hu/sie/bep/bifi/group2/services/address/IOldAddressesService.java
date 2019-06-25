package nl.hu.sie.bep.bifi.group2.services.address;

import nl.hu.sie.bep.bifi.group2.model.Address;

public interface IOldAddressesService 
{
    Address getByCustomer(Address address);
}
