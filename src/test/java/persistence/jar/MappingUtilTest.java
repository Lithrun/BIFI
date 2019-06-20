package persistence.jar;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;


public class MappingUtilTest {
    @Test
    public void loadAddressTest() {
        Map<String, String> data = new HashMap<>();
        data.put("STRAAT", "Straatweg");
        data.put("plaats", "Utrecht");
        assertEquals(data.get("plaats"), MappingUtil.loadAddress(data).getCity());
    }
}
