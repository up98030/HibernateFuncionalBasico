package tareasUtil;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();
    
    private static SessionFactory buildSessionFactory()
    {
        try
        {
        	
        	Configuration cf = new Configuration().configure("hibernate.cfg.xml");

            StandardServiceRegistryBuilder srb = new StandardServiceRegistryBuilder();
            srb.applySettings(cf.getProperties());
            ServiceRegistry sr = srb.build();
            SessionFactory sf = cf.buildSessionFactory(sr);
        	
            // Create the SessionFactory from hibernate.cfg.xml
            return sf;
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
  
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
  
    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }

}
