package accesoAdatos._ORM;

import java.util.ArrayList;

import negocio.Comunidad;
import negocio.Factura;
import negocio.NotaInformativa;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.JDBCConnectionException;

import accesoAdatos._interfaces.IComunidadDao;
import accesoAdatos._interfaces.IFacturaDao;


public  class NotaInformativaDAOHibernateImp implements IFacturaDao {
	private Session sesion = null; // Hibernate Session
	private Transaction tx = null; // Hibernate Transaction
	
	public void crearNotaInformativa(NotaInformativa ni) throws Exception {
		try {
			sesion = UtilidadHibernate.getSessionFactory().openSession();
			tx = sesion.beginTransaction();
			sesion.save(ni);
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
	
	public void actualizarNotaInformativa(NotaInformativa ni) throws Exception {
		// TODO Auto-generated method stub
		try {
			sesion = UtilidadHibernate.getSessionFactory().openSession();
			tx = sesion.beginTransaction();
			sesion.update(ni);
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
	
	public void borrarNotaInformativa(NotaInformativa ni) throws Exception {
		// TODO Auto-generated method stub
		try {
			sesion = UtilidadHibernate.getSessionFactory().openSession();
			tx = sesion.beginTransaction();
			sesion.delete(ni);
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
	public ArrayList getListaNotaInformativasDAO() throws Exception {		
		ArrayList ListaNotaInformativas = new ArrayList();    
		try{        
            sesion = UtilidadHibernate.getSessionFactory().openSession();
            tx = sesion.beginTransaction();            
            ListaNotaInformativas = (ArrayList) sesion.createQuery("from NotaInformativa").list();            
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
        return ListaNotaInformativas;
    }
}