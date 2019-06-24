package persistence.jar.generic;

import java.util.Map;

public interface MappingFactory<T> {
    T convertFromMap(Map data);
}
