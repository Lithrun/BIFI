package parser.parsers;

import model.Address;
import model.Customer;
import parser.IParser;
import parser.FileBuilder;
import parser.ParserUtils;

public class CustomerParser extends ParserUtils implements IParser<Customer>
{
    @Override
    public void parse(FileBuilder builder, Customer model)
    {
        var address = model.getAddress();
        if (address == null) { address = new Address(); }

        var items = new String[]
                {
                        "K",
                        shortenStringValue(40, model.getCompanyName()),
                        shortenStringValue(6, model.getSalutation()),
                        shortenStringValue(20, model.getName()),
                        shortenStringValue(7, model.getInsertion()),
                        shortenStringValue(40, model.getLastName()),

                        shortenStringValue(60, address.getStreet()),
                        shortenStringValue(10, address.getStreetNumber()),
                        shortenStringValue(6, address.getPostalCode()),
                        shortenStringValue(20, address.getCity()),

                        shortenStringValue(13, model.getVatNumber()),
                        shortenStringValue(64, model.getIban()),
                        shortenStringValue(10, model.getBic()),
                };
        builder.add(items);
    }
}
