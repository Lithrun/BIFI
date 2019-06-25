package nl.hu.sie.bep.bifi.group2.services.address;

import nl.hu.sie.bep.bifi.group2.model.Address;
import nl.hu.sie.bep.bifi.group2.persistence.jar.OldAddressJarDataFactory;
import nl.hu.sie.bep.bifi.group2.persistence.jar.generic.JarDataFactory;

public class OldAddressesService implements IOldAddressesService 
{
    private JarDataFactory<Address> jarDataFactory = new OldAddressJarDataFactory();

    public Address getByCustomer(Address address) 
    {
        if (address == null)
        {
            return null;
        }
        
        if (isRefferencingToAnOldAddress(address.getStreet())) 
        {
            return  getOldAddressFromJar(address);
        }
        
        return address;
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
