package parser;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ParserUtils
{
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
    
    public String Format(Date date)
    {
        if (date == null)
        {
            return "";
        }
        var format = new SimpleDateFormat("ddMMyy");
        return format.format(date);
    }
    
    public String Format(int precision, int scale, double value)
    {
        var fractional = value % 1;
        var fractionalString = StringUtils.leftPad("0", precision, Double.toString(scale) );
        if (fractionalString.length() > scale)
        {
            fractionalString = fractionalString.substring(0, scale);
        }

        var integral = value - fractional;
        var integralString = StringUtils.rightPad("0", precision, Double.toString(integral) );
        if (integralString.length() > scale)
        {
            integralString = integralString.substring(0, scale);
        }
        
        return integralString + fractionalString;
    }
}
