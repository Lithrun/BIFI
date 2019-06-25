package services;

import model.Address;
import model.Customer;
import nl.hu.sie.bep.bifi.group2.persistence.jar.OldAddressJarDataFactory;
import nl.hu.sie.bep.bifi.group2.persistence.jar.generic.JarDataFactory;
import services.generic.IOldAddressesService;

public class OldAddressesService implements IOldAddressesService {
    private JarDataFactory<Address> jarDataFactory = new OldAddressJarDataFactory();

    public Address getByCustomer(Customer customer) {
        Address customerAddress = customer.getAddress();
        if (isRefferencingToAnOldAddress(customerAddress.getStreet())) {
            return getOldAddressFromJar(customerAddress);
        }
        return customerAddress;
    }

    private Address getOldAddressFromJar(Address address) {
        jarDataFactory.open();
        Address oldAddressFromJar = jarDataFactory.get(address.getStreet());
        jarDataFactory.close();
        return oldAddressFromJar;
    }

    private boolean isRefferencingToAnOldAddress(String value) {
        return value.matches("-[A-Z]+");
    }
}
