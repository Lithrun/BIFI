package nl.hu.sie.bep.bifi.group2.services.generic;

import nl.hu.sie.bep.bifi.group2.model.Address;
import nl.hu.sie.bep.bifi.group2.model.Customer;

public interface IOldAddressesService {
    Address getByCustomer(Customer customer);
}
