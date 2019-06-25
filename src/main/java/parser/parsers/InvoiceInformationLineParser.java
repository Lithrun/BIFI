package parser.parsers;

import model.InvoiceLineInformation;
import parser.FileBuilder;
import parser.IParser;
import parser.ParserUtils;

public class InvoiceInformationLineParser extends ParserUtils implements IParser<InvoiceLineInformation>
{
    @Override
    public void parse(FileBuilder builder, InvoiceLineInformation model)
    {
        var items = new String[]
        {
            "F", // to pay respect
                formatDate(model.getDate()),
                shortenStringValue(10, model.getInvoiceNumber())
        };

        builder.add(items);
    }
}
