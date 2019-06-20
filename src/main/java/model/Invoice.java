package model;

import org.hibernate.exception.DataException;

import java.util.ArrayList;
import java.util.Date;

public class Invoice {
    private int customerId;
    private int invoiceId;
    private Date date;
    private ArrayList<InvoiceLine> invoiceLines = new ArrayList<InvoiceLine>();
    private String note;
    private int personId;

    public Invoice(){}

    public int getCustomerId() {return customerId;}

    public void setCustomerId(int newCustomerId) {customerId = newCustomerId;}

    public int getInvoiceId() {return invoiceId;}

    public void setInvoiceId(int newInvoiceId) {invoiceId = newInvoiceId;}

    public Date getDate() {return date;}

    public void setDate(Date newDate) {date = newDate;}

    public ArrayList<InvoiceLine> getInvoiceLines() {return invoiceLines;}

    public void setInvoiceLine(InvoiceLine invoiceLine) {invoiceLines.add(invoiceLine);}

    public String getNote() {return note;}

    public void setNote(String newNote) {note = newNote;}

    public int getPersonId() {return invoiceId;}

    public void setPersonId(int newPersonId) {personId = newPersonId;}

}
