package persistence.jar;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MappingUtilTest {
    @Test
    void loadAddressTest() {
        Map<String, String> data = new HashMap<>();
        data.put("STRAAT", "Straatweg");
        data.put("plaats", "Utrecht");
        assertEquals(data.get("plaats"), MappingUtil.loadAddress(data).getCity());
    }
}
