package parser;

import model.InvoiceLine;

public class InvoiceLineParser extends ParserUtils implements IParser<InvoiceLine>
{
    @Override
    public void Parse(LineBuilder builder, InvoiceLine model)
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
