package parser;

import model.InvoiceLineInformation;

public class InvoiceInformationLineParser extends ParserUtils implements IParser<InvoiceLineInformation>
{
    @Override
    public void Parse(LineBuilder builder, InvoiceLineInformation model)
    {
        var items = new String[]
        {
            "F", // to pay respect
            Format(model.getDate()),
            Shorten(10, model.getInvoiceNumber())
        };

        builder.AddRange(items);
        
    }
}
