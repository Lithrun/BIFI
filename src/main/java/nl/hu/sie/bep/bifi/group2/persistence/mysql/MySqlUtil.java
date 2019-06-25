package nl.hu.sie.bep.bifi.group2.persistence.mysql;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MySqlUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration config = new Configuration();
                config.configure("mysql/hibernate.cfg.xml");
                sessionFactory = config.buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
