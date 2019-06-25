package nl.hu.sie.bep.bifi.group2.services.company;

import nl.hu.sie.bep.bifi.group2.model.Company;
import nl.hu.sie.bep.bifi.group2.services.customer.CustomerService;
import nl.hu.sie.bep.bifi.group2.services.invoices.InvoiceService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CompanyService
{

    private CustomerService _customerService;
    private InvoiceService _invoiceService;
    
    public CompanyService()
    {
        _customerService = new CustomerService();
        _invoiceService = new InvoiceService();
    }
    
    public List<Company> getCompanies(int month)
    {
        var companies = _customerService.getAllCustomers()
                .stream()
                .distinct()
                .collect(Collectors.toList());
        
        var items = new ArrayList<Company>();
        
        for (var company : companies)
        {
            var newCompany = Company.fromCustomer(company);
            var customers = _customerService.getCustomersByCompany(newCompany.getName());
            
            for (var customer : customers)
            {
               var invoices = _invoiceService.getInvoiceForCustomerByMonth(customer.getCustomerId(), month);
               customer.setInvoices(invoices);
            }
            
            newCompany.setCustomers(customers);
            items.add(newCompany);
        }
        
        return items;
    }
}
