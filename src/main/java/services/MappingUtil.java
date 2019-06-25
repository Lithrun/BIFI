package services;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

class MappingUtil {

    private static Mapper mapper;
    static Mapper getMapper() {

        if (mapper == null) {
            mapper = DozerBeanMapperBuilder.buildDefault();
        }
        return mapper;
    }
}
