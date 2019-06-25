package nl.hu.sie.bep.bifi.group2.persistence.jar.generic;

import java.util.Map;

public interface MappingFactory<T> {
    T convertFromMap(Map data);
}
