package nl.hu.sie.bep.bifi.group2.services;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

class MappingUtil {

    private static Mapper mapper;
    
    private MappingUtil() {
    	
    }
    static Mapper getMapper() {

        if (mapper == null) {
            mapper = DozerBeanMapperBuilder.buildDefault();
        }
        return mapper;
    }
}
