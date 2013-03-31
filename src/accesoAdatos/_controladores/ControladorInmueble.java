package accesoAdatos._controladores;

import java.util.ArrayList;

import accesoAdatos._ORM.InmuebleDAOHibernateImp;
import accesoAdatos._interfaces.InterfaceControladorInmueble;

import negocio.Inmueble;

import excepciones.DAOExcepcion;

// Clase parcialmente implementada.
public class ControladorInmueble implements InterfaceControladorInmueble  {
	protected InmuebleDAOHibernateImp miDaoInmueble = new InmuebleDAOHibernateImp();
	protected ArrayList<Inmueble> ListaInmuebles = new ArrayList<Inmueble>();
	
	static private ControladorInmueble ref_controladorInmueble = new ControladorInmueble();
	  
	private ControladorInmueble() {
		
	}
	
	static public ControladorInmueble getControladorInmueble()
	  {
		  return ref_controladorInmueble;
	  }
	
	@SuppressWarnings("unchecked")
	public ArrayList<Inmueble> GetListaInmuebles() {
		try {			
			this.ListaInmuebles = miDaoInmueble.getListaInmueblesDAO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return ListaInmuebles;
	}
	
	@Override
	public void nuevoInmueble(Inmueble c) throws DAOExcepcion {
		// TODO Auto-generated method stub
		this.miDaoInmueble = new InmuebleDAOHibernateImp();
		ListaInmuebles.add(c);
		try {
			miDaoInmueble.crearInmueble(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void actualizarInmueble(Inmueble i) throws DAOExcepcion {
		this.miDaoInmueble = new InmuebleDAOHibernateImp();
		try {
			miDaoInmueble.actualizarInmueble(i);
			int indexI = this.ListaInmuebles.indexOf(i);
			this.ListaInmuebles.set(indexI, i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void borrarInmueble(Inmueble i) throws DAOExcepcion {
		this.miDaoInmueble = new InmuebleDAOHibernateImp();		
		try {
			miDaoInmueble.borrarInmueble(i);
			this.ListaInmuebles.remove(i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Inmueble getInmueblePorPos(int row) {
		Inmueble i = new Inmueble();
		i = this.ListaInmuebles.get(row);
		return i;
	}



}
