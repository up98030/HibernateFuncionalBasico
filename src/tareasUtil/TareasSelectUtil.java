package tareasUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import entity.StudentEntity;
import entity.TareasEntity;

public class TareasSelectUtil {

	public static void main(String[] args) {
		Configuration cf = new Configuration().configure("hibernate.cfg.xml");
		 
	     StandardServiceRegistryBuilder srb = new StandardServiceRegistryBuilder();
	     srb.applySettings(cf.getProperties());
	     ServiceRegistry sr = srb.build();
	     SessionFactory sf = cf.buildSessionFactory(sr);

	     Session session = sf.openSession();
	     TareasEntity std = (TareasEntity) session.load(TareasEntity.class, new Long(2));

	     // For loading Transaction object is not necessary
	     System.out.println("Loaded object Student name is: " + std.getNombreTarea());

	     System.out.println("Object Loaded successfully.....!!");
	     session.close();
	     sf.close();

	}

}
