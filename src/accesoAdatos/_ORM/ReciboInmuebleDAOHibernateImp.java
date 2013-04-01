package accesoAdatos._ORM;

import java.util.ArrayList;

import negocio.Propietario;
import negocio.ReciboInmueble;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.JDBCConnectionException;

import accesoAdatos._interfaces.IPropietarioDao;
import accesoAdatos._interfaces.IReciboInmuebleDao;




public  class ReciboInmuebleDAOHibernateImp implements IReciboInmuebleDao {
	private Session sesion = null; // Hibernate Session
	private Transaction tx = null; // Hibernate Transaction
	
	public void crearReciboInmueble(ReciboInmueble ri) throws Exception {
		try {
			sesion = UtilidadHibernate.getSessionFactory().openSession();
			tx = sesion.beginTransaction();
			sesion.save(ri);
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

		public void actualizarReciboInmueble(ReciboInmueble ri) throws Exception {
			// TODO Auto-generated method stub
			try {
				sesion = UtilidadHibernate.getSessionFactory().openSession();
				tx = sesion.beginTransaction();
				sesion.update(ri);
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

		public void borrarReciboInmueble(ReciboInmueble ri) throws Exception {
			// TODO Auto-generated method stub
			try {
				sesion = UtilidadHibernate.getSessionFactory().openSession();
				tx = sesion.beginTransaction();
				sesion.delete(ri);
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
		public ArrayList getListaReciboInmueblesDAO() {
			ArrayList ListaReciboInmuebles = new ArrayList();    
			try{        
	            sesion = UtilidadHibernate.getSessionFactory().openSession();
	            tx = sesion.beginTransaction();            
	            ListaReciboInmuebles = (ArrayList) sesion.createQuery("from ReciboInmueble").list();            
	            tx.commit();
	            sesion.close();
	        }
	        catch(JDBCConnectionException e){
	            System.out.println("No se puede conectar con las bd, error grave.");

	        }
	        catch(HibernateException e){
	            rollback();

	        }
	        return ListaReciboInmuebles;
		}
	}