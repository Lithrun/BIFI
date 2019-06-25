package parser;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ParserUtils
{
    public String shortenStringValue(int maxLength, String value)
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
    public String formatDate(Date date)
    {
        if (date == null)
        {
            return "";
        }
        var format = new SimpleDateFormat("ddMMyy");
        return format.format(date);
    }

    public String formatValue(int precision, int scale, double value)
    {
        var valueString = Double.toString(value);
        var parts = valueString.split("\\.");
        
        var fractionalPart = parts[1];
        var integralPart = parts[0];
        
        var fractionalString = leftPad("0", scale, fractionalPart );
        var integralString = rightPad("0", precision, integralPart );
        
        return integralString + fractionalString;
    }
    //It's not duplicated, the adding of the str is different
    @SuppressWarnings("Duplicates")
    private String leftPad(String str, int amount, String value)
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

    //It's not duplicated, the adding of the str is different
    @SuppressWarnings("Duplicates")
    private String rightPad(String str, int amount, String value)
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
