package accesoAdatos._ORM;

import java.util.ArrayList;

import negocio.Propietario;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.JDBCConnectionException;

import accesoAdatos._interfaces.IPropietarioDao;




public  class PropietarioDAOHibernateImp implements IPropietarioDao {
	private Session sesion = null; // Hibernate Session
	private Transaction tx = null; // Hibernate Transaction
	
	public void crearPropietario(Propietario p) throws Exception {
		try {
			sesion = UtilidadHibernate.getSessionFactory().openSession();
			tx = sesion.beginTransaction();
			sesion.save(p);
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

		public void actualizarPropietario(Propietario p) throws Exception {
			// TODO Auto-generated method stub
			try {
				sesion = UtilidadHibernate.getSessionFactory().openSession();
				tx = sesion.beginTransaction();
				sesion.update(p);
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

		public void borrarPropietario(Propietario p) throws Exception {
			// TODO Auto-generated method stub
			try {
				sesion = UtilidadHibernate.getSessionFactory().openSession();
				tx = sesion.beginTransaction();
				sesion.delete(p);
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
		public ArrayList getListaPropietariosDAO() {
			ArrayList ListaPropietarios = new ArrayList();    
			try{        
	            sesion = UtilidadHibernate.getSessionFactory().openSession();
	            tx = sesion.beginTransaction();            
	            ListaPropietarios = (ArrayList) sesion.createQuery("from Propietario").list();            
	            tx.commit();
	            sesion.close();
	        }
	        catch(JDBCConnectionException e){
	            System.out.println("No se puede conectar con las bd, error grave.");

	        }
	        catch(HibernateException e){
	            rollback();

	        }
	        return ListaPropietarios;
		}
	}