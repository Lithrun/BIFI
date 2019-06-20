package parser.parsers;

import model.InvoiceLineInformation;
import parser.IParser;
import parser.FileBuilder;
import parser.ParserUtils;

public class InvoiceInformationLineParser extends ParserUtils implements IParser<InvoiceLineInformation>
{
    @Override
    public void Parse(FileBuilder builder, InvoiceLineInformation model)
    {
        var items = new String[]
        {
            "F", // to pay respect
            Format(model.getDate()),
            Shorten(10, model.getInvoiceNumber())
        };

        builder.Add(items);
        
    }
}
