package persistence.jar;

import ADDRLOOKUPER.*;

import java.util.HashMap;
import java.util.Map;

public class JarUtil {
    private JarUtil() {}

    public static Map<String, String> get(String key) {
        Map<String, String> address = new HashMap<>();
        try {
            address = LOOKUP_AdDDR.scanForward(key);
        } catch (AddressLookerUpInWrongStateException wrongState) {
            wrongState.printStackTrace();
        }
        return address;
    }

    public static void open() {
        try {
            LOOKUP_AdDDR.scanStart();
        } catch (AddressLookerUPAlreadyLookinUP alreadyLooking) {
            alreadyLooking.printStackTrace();
        } catch (AddressLookerUPAlreadyReadyToLookUP alreadyReady) {
            alreadyReady.printStackTrace();
        }
    }

    public static void close() {
        try {
            LOOKUP_AdDDR.scanStop();
        } catch (AddressLookerUPAlreadyCloosed alreadyClosed) {
            alreadyClosed.printStackTrace();
        } catch (AddressLookerUPAlreadyLookinUP alreadyLooking) {
            alreadyLooking.printStackTrace();
        }
    }
}