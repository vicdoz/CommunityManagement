package accesoAdatos._controladores;

import java.util.ArrayList;
import java.util.Iterator;

import accesoAdatos._ORM.ReciboInmuebleDAOHibernateImp;
import accesoAdatos._interfaces.InterfaceControladorReciboInmueble;



import negocio.ReciboInmueble;

import excepciones.DAOExcepcion;

// Clase parcialmente implementada.
public class ControladorReciboInmueble implements InterfaceControladorReciboInmueble  {
// Parcialmente immplementada
	
	protected ReciboInmuebleDAOHibernateImp	 miDaoReciboInmueble = new ReciboInmuebleDAOHibernateImp();
	protected ArrayList<ReciboInmueble> ListaReciboInmuebles = new ArrayList<ReciboInmueble>();
	static private ControladorReciboInmueble ref_controladorReciboInmueble = new ControladorReciboInmueble();

	
	private ControladorReciboInmueble() {
	}
	
	static public ControladorReciboInmueble getControladorReciboInmueble()
	  {
		  return ref_controladorReciboInmueble;
	  }

	public void ActualizarReciboInmueble(ReciboInmueble p) throws DAOExcepcion {
		// TODO Auto-generated method stub	
	}


	
	public void BorrarReciboInmueble(int clave) throws DAOExcepcion {
		// TODO Auto-generated method stub
		
	}


	public ReciboInmueble GetActual(int i) {
		// TODO Auto-generated method stub
		return null;
	}


	public int GetNumReciboInmueble() {
		// TODO Auto-generated method stub
		return 0;
	}


	public void GetReciboInmuebles() throws DAOExcepcion {
		// TODO Auto-generated method stub
		
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<ReciboInmueble> GetListaReciboInmuebles() {
		try {			
			this.ListaReciboInmuebles = miDaoReciboInmueble.getListaReciboInmueblesDAO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return ListaReciboInmuebles;
	}
	public void NuevoReciboInmueble(ReciboInmueble p) throws Exception {
		// TODO Auto-generated method stub
		miDaoReciboInmueble = new ReciboInmuebleDAOHibernateImp();
		try {
			miDaoReciboInmueble.crearReciboInmueble(p);	
			ListaReciboInmuebles.add(p);
		} catch (DAOExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
	 public void actualizarReciboInmueble(ReciboInmueble p) throws DAOExcepcion {
         // TODO Auto-generated method stub
         this.miDaoReciboInmueble = new ReciboInmuebleDAOHibernateImp();
         try {
                 miDaoReciboInmueble.actualizarReciboInmueble(p);
                 int indexP = this.ListaReciboInmuebles.indexOf(p);
     			 this.ListaReciboInmuebles.set(indexP, p);
         } catch (Exception e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
         }
	 }
	public void borrarReciboInmueble(ReciboInmueble p) throws DAOExcepcion {
		// TODO Auto-generated method stub
		this.miDaoReciboInmueble = new ReciboInmuebleDAOHibernateImp();
		try {
			miDaoReciboInmueble.borrarReciboInmueble(p);
			this.ListaReciboInmuebles.remove(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ReciboInmueble getReciboInmueblePorId(int id){				
		Iterator<ReciboInmueble> it= ListaReciboInmuebles.iterator();
		while(it.hasNext()){
			ReciboInmueble paux=it.next();
			if(paux.getIdRecibo()==id)
				return paux;
		}
		System.out.println("ReciboInmueble no encontrado");
		return null ;
	}

	public ReciboInmueble getReciboInmueblePorPos(int row) {
		ReciboInmueble p = new ReciboInmueble();
		p = this.ListaReciboInmuebles.get(row);
		return p;
	}

  

}
