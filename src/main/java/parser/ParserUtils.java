package parser;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ParserUtils
{
    /**
     * Shorten string if the length excites the max length
     * @param maxLength
     * @param value
     * @return
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
     * @param date
     * @return
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
     * @param precision amount of leading zeros for the integral value 
     * @param scale amount of trailing zeros for the fractional value  
     * @param value
     * @return
     */
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
