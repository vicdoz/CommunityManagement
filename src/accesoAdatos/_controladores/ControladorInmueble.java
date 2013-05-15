package accesoAdatos._controladores;

import java.util.ArrayList;
import java.util.Iterator;

import accesoAdatos._ORM.InmuebleDAOHibernateImp;
import accesoAdatos._interfaces.InterfaceControladorInmueble;

import negocio.Comunidad;
import negocio.Inmueble;
import negocio.Propietario;
import negocio.ReciboInmueble;

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
	public Inmueble getInmueblePorId(int id) {
		// TODO Auto-generated method stub
		Iterator<Inmueble> it= ListaInmuebles.iterator();
		while(it.hasNext()){
			System.out.println("Buscando");
			Inmueble iAux=it.next();
			System.out.println("ID encontrado:"+iAux.getIdInmueble());
			if(iAux.getIdInmueble()==id)
				return iAux;
		}
		System.out.println("Inmueble no encontrada");
		return null;		
	}

	public boolean comprobarRecibosPendientes(Inmueble i) {
		// TODO Auto-generated method stub
		ArrayList<ReciboInmueble>ri=ControladorReciboInmueble.getControladorReciboInmueble().GetListaReciboInmuebles();
		Iterator<ReciboInmueble> it= ri.iterator();
		while(it.hasNext()){
			System.out.println("Buscando recibos pendientes");
			ReciboInmueble riAux=it.next();
			if(riAux.getInmueble().getIdInmueble()==i.getIdInmueble())
				return true;
		}
		return false;	
	}

	public ArrayList<Inmueble> getInmueblePorPropietario(Propietario p) {
		
		ArrayList<Inmueble> lista=new ArrayList<Inmueble>();
		Iterator<Inmueble> it=this.GetListaInmuebles().iterator();
		while(it.hasNext()){
			System.out.println("Buscando propietario");
			Inmueble iAux=it.next();

			if(iAux.getPropietario().getIdPropietario()==(p.getIdPropietario())){
				System.out.println("Inmueble con este propietario");
				lista.add(iAux);}
		}
		return lista;
	}

	public boolean existeInmueble(String escalera, String piso, String puerta,
			Comunidad com) {
		ArrayList<Inmueble> lista=new ArrayList<Inmueble>();
		Iterator<Inmueble> it=this.GetListaInmuebles().iterator();
		System.out.println(".--->"+escalera+","+piso+","+puerta);
		while(it.hasNext()){
			Inmueble iAux=it.next();System.out.println("Inmueble buscando");
			System.out.println(iAux.getEscalera().trim()+","+iAux.getPiso()+iAux.getPuerta());
			if(iAux.getEscalera().toString().trim().equals(escalera.trim())&&iAux.getPiso().toString().trim().equals(piso.trim())&&iAux.getPuerta().toString().trim().equals(puerta.trim()) &&iAux.getComunidad().getIdComunidad()==com.getIdComunidad()){
				return true;
				}
		}
		return false;
	

	}



}
