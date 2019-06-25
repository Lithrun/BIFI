package nl.hu.sie.bep.bifi.group2.persistence.mysql;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MySqlUtil {
    private static SessionFactory sessionFactory;
    
    private MySqlUtil() {
    	//This constructor should be empty
    }

    public static SessionFactory createSessionFactory() 
    {
        if (sessionFactory != null)
        {
            return sessionFactory;
        }
        
        try 
        {
            Configuration config = new Configuration();
            config.configure("mysql/hibernate.cfg.xml");
            sessionFactory = config.buildSessionFactory();
            return sessionFactory;
        } 
        catch (Exception exception) 
        {
            Logger logger = LoggerFactory.getLogger(MySqlUtil.class);
            logger.info("getSessionFactory - Exception", exception);
            return null;
        }
    }
}
