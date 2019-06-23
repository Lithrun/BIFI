package model;

import java.sql.Date;

public class InvoiceLineInformation 
{
    private Date date;
    private String invoiceNumber;

    public Date getDate() { return date; }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public String getInvoiceNumber()
    {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber)
    {
        this.invoiceNumber = invoiceNumber;
    }
}
