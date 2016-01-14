package tareasUtil;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.TareasEntity;

public class TareasInsertUtil {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        TareasEntity tareasEntity = new TareasEntity();

        tareasEntity.setIdTarea(2L);        
        tareasEntity.setNombreTarea("Tarea de Prueba1");
        tareasEntity.setFechaInicio(new Date());
        tareasEntity.setFechaFin(new Date());
        tareasEntity.setEstado("ACT");
        tareasEntity.setDescripcionTarea("Es la primera tarea de prueba de hibernate");
        tareasEntity.setArchivoAdjunto("Archivo1.pdf");
        tareasEntity.setArchivo("Archivo subido.pdf");
        tareasEntity.setObservaciones("Observaciones de la tarea1");
        tareasEntity.setIdModulo(74477);
        tareasEntity.setIdProfesorCreador(4494);
        tareasEntity.setIdProfesor(111);
        tareasEntity.setCalificacion(0);
                     
        //Save the employee in database
        session.save(tareasEntity);
 
        //Commit the transaction
        session.getTransaction().commit();
        HibernateUtil.shutdown();
	

}}
