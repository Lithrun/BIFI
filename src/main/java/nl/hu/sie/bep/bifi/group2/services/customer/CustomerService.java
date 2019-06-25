package nl.hu.sie.bep.bifi.group2.services.customer;

import nl.hu.sie.bep.bifi.group2.model.Customer;
import nl.hu.sie.bep.bifi.group2.persistence.mysql.MySqlUtil;
import nl.hu.sie.bep.bifi.group2.persistence.mysql.dao.CustomerDao;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

import java.util.ArrayList;

public class CustomerService
{
    private SessionFactory _sessionFactory;
    
    public CustomerService()
    {
        _sessionFactory = MySqlUtil.createSessionFactory();
    }
    
    public Customer[] getCustomersByCompany(String companyName)
    {
        //Should be company id but the database is pretty weird
        var session = _sessionFactory.openSession();
        try
        {
            //idk man
            var query = "SELECT * FROM Bifi.klant GROUP BY Bedrijfsnaam";
            var result = session.createNativeQuery(query, CustomerDao.class).getResultList();
            var items = new ArrayList<Customer>();

            for (var dao : result)
            {
                var newCompany = Customer.fromCustomerDao(dao);
                
                
                
                items.add(newCompany);
            }

            return (Customer[]) items.toArray();

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
