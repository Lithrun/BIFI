package nl.hu.sie.bep.bifi.group2.services.company;

import nl.hu.sie.bep.bifi.group2.model.Company;
import nl.hu.sie.bep.bifi.group2.model.Customer;
import nl.hu.sie.bep.bifi.group2.persistence.mysql.MySqlUtil;
import nl.hu.sie.bep.bifi.group2.persistence.mysql.dao.CustomerDao;
import nl.hu.sie.bep.bifi.group2.services.customer.CustomerService;
import nl.hu.sie.bep.bifi.group2.services.invoices.InvoiceService;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import java.util.ArrayList;

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
    
    public Company[] getCompanies(int month)
    {
        var session = _sessionFactory.openSession();
        try
        {
            //idk man
            var query = "SELECT Bedrijfsnaam FROM Bifi.klant GROUP BY Bedrijfsnaam";
            var result = session.createNativeQuery(query, CustomerDao.class).getResultList();
            var items = new ArrayList<Company>();

            for (var company : result)
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

            return (Company[]) items.toArray();

        }
        catch (HibernateException ex)
        {
            return null;
        }
        finally
        {
            session.close();
        }
    }
}
