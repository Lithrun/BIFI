package services.generic;

import model.Address;
import model.Customer;

public interface IOldAddressesService {
    Address getByCustomer(Customer customer);
}
