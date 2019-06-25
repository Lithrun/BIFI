package nl.hu.sie.bep.bifi.group2.parser;

import org.apache.commons.beanutils.PropertyUtils;
import nl.hu.sie.bep.bifi.group2.parser.parsers.*;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

public class FileParser<T>
{
    private T model;

    //Can be made static or can be done by static constructors or something
    private Map<Class<?>, Class<?>> parserCache = new HashMap<>();

    //Can be generated by reflection, but meh
    private Class<?>[] parsers = new Class[]
    {
        CompanyParser.class,
        InvoiceInformationLineParser.class,
        InvoiceLineParser.class,
        TextLineParser.class,
        CustomerParser.class,
    };

    public FileParser(T model)
    {
        this.model = model;
    }

    public String parse()
    {
        var builder = new FileBuilder();
        parse(builder, model);
        return builder.build();
    }

    private <MT> void parse(FileBuilder builder, MT model)
    {
        var modelClass = model.getClass();
        var parser = getParser(modelClass);
        if (parser == null)
        {
            return;
        }

        parser.parse(builder, model);
        builder.nextLine();
        
        var properties = getProperties(modelClass);
        
        for(var property : properties)
        {
            var type = property.getPropertyType();
            var value = getValue(model, property.getName());
            if (value == null) continue;
            if(type.isArray())
            {
                handleArray(builder, value);
            }

            else if (type.getClassLoader() != null)
            {
                handleClassLoader(builder, value);
            }
        }
    }

    private void handleClassLoader(FileBuilder builder, Object value) {
        parse(builder, value);
    }

    private void handleArray(FileBuilder builder, Object value) {
        for (var i = 0; i < Array.getLength(value); i++)
        {
            var arrayValue = Array.get(value, i);
            if (arrayValue == null)
            {
                continue;
            }
            parse(builder, arrayValue);
        }
    }

    private Object getValue(Object model, String name)
    {
        try
        {
            return PropertyUtils.getProperty(model, name);
        }
        catch (IllegalAccessException|InvocationTargetException|NoSuchMethodException e)
        {
            e.printStackTrace();
        }
        
        return null;
    }

    private IParser getParser(Class<?> model)
    {
        if (parserCache.containsKey(model))
        {
            return tryCreateParser(parserCache.get(model));
        }
        
        for (var parser : parsers)
        {
            var interfaces = parser.getGenericInterfaces();
            
            for (var generic : interfaces)
            {
                var types = ((ParameterizedType)generic).getActualTypeArguments();
                for ( var type : types)
                {
                    if (type != model)
                    {
                        continue;
                    }
                    
                    var instance = tryCreateParser(parser);
                    if (instance == null)
                    {
                        return null;
                    }
                    
                    //cache the parser type so we have to do less when repeated
                    parserCache.put(model, parser);
                    return instance;
                }
            }
        }
        
        return null;
    }

    private IParser tryCreateParser(Class<?> parser)
    {
        try
        {
            return (IParser) parser.getDeclaredConstructor().newInstance();
        }
        catch (InstantiationException|IllegalAccessException|NoSuchMethodException|InvocationTargetException e)
        {
            return null;
        }
        
    }

    private PropertyDescriptor[] getProperties(Class<?> type)
    {
        try
        {
            return Introspector.getBeanInfo(type).getPropertyDescriptors();
        }
        catch (IntrospectionException e)
        {
            e.printStackTrace();
            return new PropertyDescriptor[0];
        }
    }
}
