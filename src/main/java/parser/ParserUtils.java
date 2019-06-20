package parser;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ParserUtils
{
    /**
     * Shorten string if the length excites the max length
     */
    public String Shorten(int maxLength, String value)
    {
        if (value == null)
        {
            return "";
        }
        
        if (value.length() < maxLength)
        {
            return value;
        }
        
        return value.substring(0, maxLength);
    }

    /**
     * Format date to ddMMyy
     */
    public String Format(Date date)
    {
        if (date == null)
        {
            return "";
        }
        var format = new SimpleDateFormat("ddMMyy");
        return format.format(date);
    }

    /**
     * Format a double from 10.04 to 0001004 depending on parameters
     */
    public String Format(int precision, int scale, double value)
    {
        var valueString = Double.toString(value);
        var parts = valueString.split("\\.");
        
        var fractionalPart = parts[1];
        var integralPart = parts[0];
        
        var fractionalString = LeftPad("0", scale, fractionalPart );
        var integralString = RightPad("0", precision, integralPart );
        
        return integralString + fractionalString;
    }
    
    /**
     * Java's right pad is weird
     */
    //It's not duplicated, the adding of the str is different
    @SuppressWarnings("Duplicates")
    private String LeftPad(String str, int amount, String value)
    {
        if (value.length() >= amount)
        {
            return value;
        }

        var pads = amount - value.length();

        for( var i = 0; i < pads; i++)
        {
            value = value + str;
        }

        return value;
    }

    /**
     * Java's right pad is weird
     */
    //It's not duplicated, the adding of the str is different
    @SuppressWarnings("Duplicates")
    private String RightPad(String str, int amount, String value)
    {
        if (value.length() >= amount)
        {
            return value;
        }
        
        var pads = amount - value.length();
        
        for( var i = 0; i < pads; i++)
        {
            value = str + value;
        }
        
        return value;
    }
}
