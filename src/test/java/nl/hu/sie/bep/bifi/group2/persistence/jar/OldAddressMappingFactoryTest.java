package nl.hu.sie.bep.bifi.group2.persistence.jar;

import model.Address;
import org.easymock.TestSubject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import nl.hu.sie.bep.bifi.group2.persistence.jar.generic.MappingFactory;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;


public class OldAddressMappingFactoryTest {
    @TestSubject
    private MappingFactory<Address> mappingFactory = new OldAddressMappingFactory();

    private Map<String, String> mapStub;

    @Before
    public void beforeEach() {
        mapStub = new HashMap<>();
    }

    @After
    public void afterEach() {
        mapStub = null;
    }

    @Test
    public void convertFromMapTest() {
        initializeAllFakeMapData();

        Address result = mappingFactory.convertFromMap(mapStub);

        assertEquals("Teststraat", result.getStreet());
        assertEquals("1", result.getStreetNumber());
        assertEquals("Testplaats", result.getCity());
        assertEquals("1234AB", result.getPostalCode());
    }

    @Test
    public void convertFromMapWithNullValues() {
        initializeAllFakeMapDataExceptPostalCode();

        Address result = mappingFactory.convertFromMap(mapStub);

        assertEquals("Teststraat", result.getStreet());
        assertEquals("1", result.getStreetNumber());
        assertEquals("Testplaats", result.getCity());
        assertEquals("", result.getPostalCode());
    }

    private void initializeAllFakeMapData() {
        initializeAllFakeMapDataExceptPostalCode();
        mapStub.put("POSTCODE", "1234AB");
    }

    private void initializeAllFakeMapDataExceptPostalCode() {
        mapStub.put("plaats", "Testplaats");
        mapStub.put("STRAAT", "Teststraat");
        mapStub.put("HUISNUMMER", "1");
    }
}
