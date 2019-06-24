package persistence.jar;

import model.Address;
import org.easymock.TestSubject;
import org.junit.Test;
import persistence.jar.generic.MappingFactory;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;


public class OldAddressMappingFactoryTest {
    @TestSubject
    MappingFactory<Address> mappingFactory = new OldAddressMappingFactory();

    private Map<String, String> mapStub = new HashMap<>();

    @Test
    public void convertFromMapTest() {
        mapStub.put("plaats", "Testplaats");
        mapStub.put("STRAAT", "Teststraat");
        mapStub.put("HUISNUMMER", "1");
        mapStub.put("POSTCODE", "1234TE");

        Address result = mappingFactory.convertFromMap(mapStub);

        assertEquals("Teststraat", mappingFactory.convertFromMap(mapStub).getStreet());
    }
}
