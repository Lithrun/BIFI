package services;

import model.Address;
import model.Customer;
import persistence.jar.JarUtil;
import persistence.jar.MappingUtil;
import services.generic.IOldAddressesService;

import java.util.logging.Level;
import java.util.logging.Logger;

public class OldAddressesService implements IOldAddressesService {
    private static final Logger LOGGER = Logger.getLogger( OldAddressesService.class.getName() );

    public Address getByCustomer(Customer customer) {
        Address address = customer.getAddress();
        if (address != null && address.getStreet() != null && address.getStreet().startsWith("-")) {
            String key = address.getStreet().substring(1);

            // Get the old address
            JarUtil.open();
            address = MappingUtil.loadAddress(JarUtil.get(key));
            JarUtil.close();
        } else {
            LOGGER.log(Level.FINE, "warning: no key found to lookup old addresses from jar.");
        }
        return address;
    }
}
