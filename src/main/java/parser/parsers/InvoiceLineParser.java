package parser.parsers;

import model.InvoiceLine;
import parser.IParser;
import parser.FileBuilder;
import parser.ParserUtils;

public class InvoiceLineParser extends ParserUtils implements IParser<InvoiceLine>
{
    @Override
    public void Parse(FileBuilder builder, InvoiceLine model)
    {
        var items = new String[]
        {
            "R",
            Shorten(60, model.getDescription()),
            Format(3, 2, model.getQuantity()),
            Format(3, 2, model.getPriceExclVat()),
            Integer.toString(model.getVatType()),
            Format(model.getDate()),
            Shorten(6, model.getUnit())
        };

        builder.AddRange(items);
        
    }
}
