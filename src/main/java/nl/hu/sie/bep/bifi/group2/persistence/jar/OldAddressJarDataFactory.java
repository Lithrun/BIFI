package nl.hu.sie.bep.bifi.group2.persistence.jar;

import ADDRLOOKUPER.*;
import nl.hu.sie.bep.bifi.group2.model.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import nl.hu.sie.bep.bifi.group2.persistence.jar.generic.JarDataFactory;
import nl.hu.sie.bep.bifi.group2.persistence.jar.generic.MappingFactory;

import java.util.HashMap;
import java.util.Map;

public class OldAddressJarDataFactory implements JarDataFactory<Address> {
    private static final Logger LOGGER = LoggerFactory.getLogger(JarDataFactory.class);

    private MappingFactory<Address> mappingFactory;

    public OldAddressJarDataFactory() {
        mappingFactory = new OldAddressMappingFactory();
    }

    public OldAddressJarDataFactory(MappingFactory<Address> mappingFactory) {
        this.mappingFactory = mappingFactory;
    }

    private static String makeScannable(String value) {
        return value.substring(1);
    }

    public Address get(String value) {
        Map<String, String> address = new HashMap<>();
        try {
            address = LOOKUP_AdDDR.scanForward(makeScannable(value));
        } catch (AddressLookerUpInWrongStateException wrongState) {
            LOGGER.error("Wrong state detected", wrongState);
        }
        return address == null || address.isEmpty() ? null : mappingFactory.convertFromMap(address);
    }

    public void open() {
        try {
            LOOKUP_AdDDR.scanStart();
        } catch (AddressLookerUPAlreadyLookinUP alreadyLooking) {
            LOGGER.error("Simultaneous processing is not allowed", alreadyLooking);
        } catch (AddressLookerUPAlreadyReadyToLookUP alreadyReady) {
            LOGGER.warn("Connection seems already open", alreadyReady);
        }
    }

    public void close() {
        try {
            LOOKUP_AdDDR.scanStop();
        } catch (AddressLookerUPAlreadyLookinUP alreadyLooking) {
            LOGGER.error("Simultaneous processing is not allowed", alreadyLooking);
        } catch (AddressLookerUPAlreadyCloosed alreadyClosed) {
            LOGGER.warn("Connection seems already closed", alreadyClosed);
        }
    }
}