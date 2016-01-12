package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import entity.StudentEntity;

public class HibernateUtil {

        public static void main(String[] args) {

        Configuration cf = new Configuration().configure("hibernate.cfg.xml");

        StandardServiceRegistryBuilder srb = new StandardServiceRegistryBuilder();
        srb.applySettings(cf.getProperties());
        ServiceRegistry sr = srb.build();
        SessionFactory sf = cf.buildSessionFactory(sr);

        Session session = sf.openSession();
    
        StudentEntity std = new StudentEntity();
                std.setId(2); // Primary Key
                std.setName("Jamil");
                std.setDepartment("ECE");
                std.setCollege("SKCET");

                Transaction tx = session.beginTransaction();
                session.save(std);
                tx.commit();
                System.out.println("Object saved successfully.....!!");
                session.close();
                sf.close();
        }
}