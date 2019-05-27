package parser;

import org.apache.commons.beanutils.PropertyUtils;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;

public class IefParser<T>
{
    private T _model;
    
    private Class<?>[] _parsers = new Class[]
    {
        CompanyParser.class,
        InvoiceInformationLineParser.class,
        InvoiceLineParser.class,
        TextLineParser.class,
        CustomerParser.class,
    };

    public IefParser(T model)
    {
        _model = model;
    }

    /**
     * Parse the object to a string
     * @return A string that represents the IEF file
     */
    public String Parse() 
    {
        var builder = new LineBuilder();
        Parse(builder, _model);
        return builder.Build();
    }
    
    private <MT> void Parse(LineBuilder builder, MT model)
    {
        var modelClass = model.getClass();
        var parser = GetParser(modelClass);
        if (parser == null)
        {
            return;
        }
        
        parser.Parse(builder, model);
        builder.NextLine();
        
        var properties = GetProperties(modelClass);
        
        for( var property : properties)
        {
            var type = property.getPropertyType();
            
            if(type.isArray())
            {
                var value = GetValue(model, property.getName());
                if (value == null)
                {
                    continue;
                }
                
                for (var i = 0; i < Array.getLength(value); i++)
                {
                    var arrayValue = Array.get(value, i);
                    if (arrayValue == null)
                    {
                        continue;
                    }
                    
                    Parse(builder, arrayValue);
                }
                
            }
            else if (type.getClassLoader() != null)
            {
                var value = GetValue(model, property.getName());
                if (value == null)
                {
                    continue;
                }
                
                Parse(builder, value); 
            }
        }
    }

    private Object GetValue(Object model, String name)
    {
        try
        {
            return PropertyUtils.getProperty(model, name);
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
        catch (InvocationTargetException e)
        {
            e.printStackTrace();
        }
        catch (NoSuchMethodException e)
        {
            e.printStackTrace();
        }
        
        return null;
    }

    private IParser GetParser(Class<?> model)
    {
        for (var parser : _parsers)
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
                    
                    return TryCreateParser(parser);
                }
            }
        }
        
        return null;
    }

    /***
     * Try create a parser else return null
     * @param parser
     * @return
     */
    private IParser TryCreateParser(Class<?> parser)
    {
        try
        {
            return (IParser) parser.newInstance();
        }
        catch (InstantiationException e)
        {
            return null;
        }
        catch (IllegalAccessException e)
        {
            return null;
        }
        
    }

    /**
     * Get all the getters of an object
     * @param type The object type
     */
    private PropertyDescriptor[] GetProperties(Class<?> type) 
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
