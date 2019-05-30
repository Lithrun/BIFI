package parser.parsers;

import model.Address;
import model.Company;
import parser.IParser;
import parser.FileBuilder;
import parser.ParserUtils;

/**
 * Parse the company
 * Their is no address parser because this will be in the company line
 */
public class CompanyParser extends ParserUtils implements IParser<Company>
{
    @Override
    public void Parse(FileBuilder builder, Company model)
    {
        var address = GetAddress(model);
        
        var items = new String[]
        {
            "B",
            Shorten(60, model.getName()),                
                
            Shorten(60, address.getStreet()),
            Shorten(10, address.getStreetNumber()),
            Shorten(6, address.getPostalCode()),
            Shorten(20, address.getCity()),
                
            Shorten(13, model.getVatNumber()),
            Shorten(64, model.getIban()),
            Shorten(10, model.getBic()),
        };
        
        builder.AddRange(items);
    }
    
    private Address GetAddress(Company model)
    {
        var address = model.getAddress();
        if (address == null)
        {
            return new Address();
        }
        
        return address;
    }
    
}
