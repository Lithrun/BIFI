package parser.parsers;

import model.Address;
import model.Customer;
import parser.IParser;
import parser.FileBuilder;
import parser.ParserUtils;

public class CustomerParser extends ParserUtils implements IParser<Customer>
{
    @Override
    public void Parse(FileBuilder builder, Customer model)
    {
        var address = model.getAddress();
        if (address == null)
        {
            address = new Address();
        }

        var items = new String[]
                {
                        "K",
                        Shorten(40, model.getCompanyName()),
                        Shorten(6, model.getSalutation()),
                        Shorten(20, model.getName()),
                        Shorten(7, model.getInsertion()),
                        Shorten(40, model.getLastName()),

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
}
