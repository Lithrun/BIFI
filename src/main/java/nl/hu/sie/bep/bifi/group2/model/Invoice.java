package nl.hu.sie.bep.bifi.group2.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Invoice {
    private int customerId;
    private int invoiceId;
    private Date date;
    private List<InvoiceLine> invoiceLines = new ArrayList<>();
    private String note;
    private int personId;

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

    public List<InvoiceLine> getInvoiceLines() {
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
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

}
