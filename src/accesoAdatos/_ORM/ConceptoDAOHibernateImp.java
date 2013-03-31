package accesoAdatos._ORM;

import java.util.ArrayList;

import negocio.Comunidad;
import negocio.Concepto;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.JDBCConnectionException;

public class ConceptoDAOHibernateImp {
	private Session sesion = null; // Hibernate Session
	private Transaction tx = null; // Hibernate Transaction
	
	public void crearConcepto(Concepto c) throws Exception {
		try {
			sesion = UtilidadHibernate.getSessionFactory().openSession();
			tx = sesion.beginTransaction();
			sesion.save(c);
			tx.commit();
			sesion.close();
		}
		catch (JDBCConnectionException e)
		{ // no puede conectar con la bd, error grave.
			System.out.println("No se puede conectar  a la BD");
				throw new Exception(e);
				
		}
		catch (HibernateException e) { 
			System.out.println("Excepcion");
			rollback();
			throw new Exception(e);
			
		} 

	}
	
	public void actualizarConcepto(Concepto c) throws Exception {
		// TODO Auto-generated method stub
		try {
			sesion = UtilidadHibernate.getSessionFactory().openSession();
			tx = sesion.beginTransaction();
			sesion.update(c);
			tx.commit();
			sesion.close();
		}
		catch (JDBCConnectionException e)
		{ // no puede conectar con la bd, error grave.
			System.out.println("No se puede conectar  a la BD");
				throw new Exception(e);
				
		}
		catch (HibernateException e) { 
			System.out.println("Excepcion");
			rollback();
			throw new Exception(e);
			
		} 
	}	
	private void rollback()
		{
		try {
				if (tx != null) {
					tx.rollback();
				}
		} catch (HibernateException ignored) {
			// No se puede hacer rollback de la transacción;
		}
	}
	
	public void borrarConcepto(Concepto c) throws Exception {
		// TODO Auto-generated method stub
		try {
			sesion = UtilidadHibernate.getSessionFactory().openSession();
			tx = sesion.beginTransaction();
			sesion.delete(c);
			tx.commit();
			sesion.close();
		}
		catch (JDBCConnectionException e)
		{ // no puede conectar con la bd, error grave.
			System.out.println("No se puede conectar  a la BD");
				throw new Exception(e);
				
		}
		catch (HibernateException e) { 
			System.out.println("Excepcion");
			rollback();
			throw new Exception(e);
			
		} 
	}
	@SuppressWarnings("unchecked")
	public ArrayList getListaConceptoDAO() throws Exception {		
		ArrayList ListaConceptos = new ArrayList();    
		try{        
            sesion = UtilidadHibernate.getSessionFactory().openSession();
            tx = sesion.beginTransaction();            
            ListaConceptos = (ArrayList) sesion.createQuery("from Concepto").list();            
            tx.commit();
            sesion.close();
        }
        catch(JDBCConnectionException e){
            System.out.println("No se puede conectar con las bd, error grave.");
            throw new Exception(e);
        }
        catch(HibernateException e){
            rollback();
            throw new Exception(e);
        }
        return ListaConceptos;
    }

}
