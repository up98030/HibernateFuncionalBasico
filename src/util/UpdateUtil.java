package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import entity.StudentEntity;

public class UpdateUtil {

        public static void main(String[] args) {

                Configuration cf = new Configuration().configure("hibernateMysql.cfg.xml");

                StandardServiceRegistryBuilder srb = new StandardServiceRegistryBuilder();
                srb.applySettings(cf.getProperties());
                ServiceRegistry sr = srb.build();
                SessionFactory sf = cf.buildSessionFactory(sr);

                Session session = sf.openSession();

                StudentEntity std = (StudentEntity) session.load(StudentEntity.class, new Integer(24));
                Transaction tx = session.beginTransaction();

                // std.setId(3); // We Should not update "id"
                std.setName("Ameer");
                std.setCollege("PSG");
                tx.commit(); // Update method will be called implicitly.
                System.out.println("Object Updated successfully !");
                session.close();
                sf.close();
        }
}