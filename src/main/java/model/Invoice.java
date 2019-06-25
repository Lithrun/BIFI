package model;

import java.util.ArrayList;
import java.util.Date;

public class Invoice {
    private int customerId;
    private int invoiceId;
    private Date date;
    private ArrayList<InvoiceLine> invoiceLines = new ArrayList<InvoiceLine>();
    private String note;
    private int personId;

    public Invoice() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<InvoiceLine> getInvoiceLines() {
        return invoiceLines;
    }

    public void setInvoiceLine(InvoiceLine invoiceLine) {
        invoiceLines.add(invoiceLine);
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getPersonId() {
        return invoiceId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

}
