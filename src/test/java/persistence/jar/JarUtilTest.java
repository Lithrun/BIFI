package persistence.jar;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class JarUtilTest {
    @Test
    public void getTest() {
        JarUtil.open();
        Map<String, String> address = JarUtil.get("MOATA");
        JarUtil.close();
        assertEquals("Rotterdam", address.get("plaats"));
    }
}
