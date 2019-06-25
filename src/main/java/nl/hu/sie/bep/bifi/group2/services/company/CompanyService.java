package nl.hu.sie.bep.bifi.group2.services.company;

import nl.hu.sie.bep.bifi.group2.model.Company;
import nl.hu.sie.bep.bifi.group2.persistence.mysql.MySqlUtil;
import nl.hu.sie.bep.bifi.group2.services.customer.CustomerService;
import nl.hu.sie.bep.bifi.group2.services.invoices.InvoiceService;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CompanyService
{
    private SessionFactory _sessionFactory;
    private CustomerService _customerService;
    private InvoiceService _invoiceService;
    
    public CompanyService()
    {
        _sessionFactory = MySqlUtil.createSessionFactory();

        _customerService = new CustomerService(); //todo DI :)
        _invoiceService = new InvoiceService(); //todo DI :)
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
