package persistence.jar;

import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class JarUtilTest {
    @Test
    void getTest() {
        JarUtil.open();
        Map<String, String> address = JarUtil.get("MOATA");
        JarUtil.close();
        assertEquals("Rotterdam", address.get("plaats"));
    }
}
