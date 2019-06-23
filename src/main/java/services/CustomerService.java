package services;

import com.github.dozermapper.core.Mapper;
import model.Customer;
import org.hibernate.SessionFactory;
import persistence.mysql.MySqlUtil;
import persistence.mysql.dao.CustomerDao;
import services.generic.ICustomerService;

import java.util.ArrayList;
import java.util.List;

public class CustomerService implements ICustomerService {

    private SessionFactory sessionFactory;
    public CustomerService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Customer> getAll() {
        var session = this.sessionFactory.openSession();
        var customerDaos = session.createQuery("from CustomerDao ", CustomerDao.class).list();
        var customers = new ArrayList<Customer>();
        for (var customerDao : customerDaos) {
            Mapper mapper = MappingUtil.getMapper();
            var customer = mapper.map(customerDao, Customer.class);
            
            customer.setName(customerDao.getPerson().getFirstName());
            customer.setInsertion(customerDao.getPerson().getInsertion());
            customer.setLastName(customerDao.getPerson().getLastName());
            customers.add(customer);
        }
        session.close();
        return customers;
    }
}
