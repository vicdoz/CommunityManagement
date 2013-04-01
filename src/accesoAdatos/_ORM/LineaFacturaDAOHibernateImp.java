package accesoAdatos._ORM;

import java.util.ArrayList;


import negocio.LineaFactura;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.JDBCConnectionException;
import accesoAdatos._interfaces.IInmuebleDao;





public  class LineaFacturaDAOHibernateImp implements IInmuebleDao {
	private Session sesion = null; // Hibernate Session
	private Transaction tx = null; // Hibernate Transaction
	
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
	public void crearLineaFactura(LineaFactura l) throws Exception {
		try {
			sesion = UtilidadHibernate.getSessionFactory().openSession();
			tx = sesion.beginTransaction();
			sesion.save(l);
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
	


		public void actualizarLineaFactura(LineaFactura i) throws Exception {
			try {			
				sesion = UtilidadHibernate.getSessionFactory().openSession();
				tx = sesion.beginTransaction();
				sesion.update(i);
				tx.commit();
				System.out.println("Actualizando 4 LineaFactura en Hibernate");
				sesion.close();
				System.out.println("Inmueble ActuLineaFacturaalizado en Hibernate");
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
		
		public void borrarLineaFactura(LineaFactura i) throws Exception {
			try {
				sesion = UtilidadHibernate.getSessionFactory().openSession();
				tx = sesion.beginTransaction();
				sesion.delete(i);
				tx.commit();
				sesion.close();
			}
			catch (JDBCConnectionException e)
			{ 
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
		public ArrayList getListaLineaFacturaDAO() {
			ArrayList ListaLineaFacturas = new ArrayList();    
			try{        
	            sesion = UtilidadHibernate.getSessionFactory().openSession();
	            tx = sesion.beginTransaction();            
	            ListaLineaFacturas = (ArrayList) sesion.createQuery("from LineaFactura").list();            
	            tx.commit();
	            sesion.close();
	        }
	        catch(JDBCConnectionException e){
	            System.out.println("No se puede conectar con las bd, error grave.");

	        }
	        catch(HibernateException e){
	            rollback();

	        }
	        return ListaLineaFacturas;
		}
	}