package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import entity.StudentEntity;

public class DeleteUtil {

        public static void main(String[] args) {

                Configuration cf = new Configuration().configure("hibernate.cfg.xml");

                StandardServiceRegistryBuilder srb = new StandardServiceRegistryBuilder();
                srb.applySettings(cf.getProperties());
                ServiceRegistry sr = srb.build();
                SessionFactory sf = cf.buildSessionFactory(sr);

                Session session = sf.openSession();
                StudentEntity std = (StudentEntity) session.load(StudentEntity.class, new Integer(2));
                Transaction tx = session.beginTransaction();
                session.delete(std);
                tx.commit();
                System.out.println("Object Deleted successfully !");
                session.close();
                sf.close();
        }
}
