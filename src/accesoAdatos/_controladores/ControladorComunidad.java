package accesoAdatos._controladores;

import java.util.ArrayList;
import java.util.Iterator;

import accesoAdatos._ORM.ComunidadDAOHibernateImp;
import accesoAdatos._interfaces.InterfaceControladorComunidad;
import negocio.Comunidad;
import excepciones.DAOExcepcion;

public class ControladorComunidad implements InterfaceControladorComunidad  {
	protected ComunidadDAOHibernateImp miDaoComunidad = new ComunidadDAOHibernateImp();
	protected ArrayList<Comunidad> ListaComunidades = new ArrayList<Comunidad>();
	
	static private ControladorComunidad ref_controladorComunidad = new ControladorComunidad();
	  
	private ControladorComunidad() {		
	}
	
	static public ControladorComunidad getControladorComunidad()
	  {
		  return ref_controladorComunidad;
	  }

	@Override
	public void nuevaComunidad(Comunidad c) throws DAOExcepcion {		
		this.miDaoComunidad = new ComunidadDAOHibernateImp();
		try {
			miDaoComunidad.crearComunidad(c);
			ListaComunidades.add(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void actualizarComunidad(Comunidad c) throws DAOExcepcion {
		this.miDaoComunidad = new ComunidadDAOHibernateImp();
		try {
			miDaoComunidad.actualizarComunidad(c);
			int indexC = this.ListaComunidades.indexOf(c);
			this.ListaComunidades.set(indexC, c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void borrarComunidad(Comunidad c) throws DAOExcepcion {
		this.miDaoComunidad = new ComunidadDAOHibernateImp();
		try {
			miDaoComunidad.borrarComunidad(c);
			this.ListaComunidades.remove(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Comunidad> GetListaComunidades() {
		try {			
			this.ListaComunidades = miDaoComunidad.getListaComunidadesDAO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return ListaComunidades;
	}
	public Comunidad getComunidadPorPos(int row) {
		Comunidad c = new Comunidad();
		c = this.ListaComunidades.get(row);
		return c;
	}

	public Comunidad getComunidadPorId(int id) {
		// TODO Auto-generated method stub
		Iterator<Comunidad> it= ListaComunidades.iterator();
		while(it.hasNext()){
			System.out.println("Buscando");
			Comunidad cAux=it.next();
			System.out.println("ID encontrado:"+cAux.getIdComunidad());
			if(cAux.getIdComunidad()==id)
				return cAux;
		}
		System.out.println("Comunidad no encontrada");
		return null;		
	}	
}
