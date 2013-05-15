package accesoAdatos._controladores;

import java.util.ArrayList;
import java.util.Iterator;

import accesoAdatos._ORM.ComunidadDAOHibernateImp;
import accesoAdatos._interfaces.InterfaceControladorComunidad;
import negocio.Comunidad;
import negocio.Factura;
import negocio.ReciboInmueble;
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

	public boolean existeComunidad(String nombre, String direccion,
			String poblacion) {
		Iterator<Comunidad> it= ListaComunidades.iterator();
		while(it.hasNext()){
			System.out.println("Buscando");
			Comunidad cAux=it.next();
			if(cAux.getCalle().trim().equals(direccion.trim())&& cAux.getNombre().trim().equals(nombre.trim())&&cAux.getPoblacion().trim().equals(poblacion.trim()))	
				return true;
		}
	
	return false;
	}

	public  ArrayList<Factura>  getListaFacturas(Comunidad c) {
		ArrayList<Factura>f=ControladorFactura.getControladorFactura().GetListaFacturas();
		ArrayList<Factura>lista=new ArrayList<Factura>();
		Iterator<Factura> it= f.iterator();
		while(it.hasNext()){
			System.out.println("Buscando facturas");
			Factura fAux=it.next();
			if(fAux.getComunidad()==c )
				lista.add(fAux);
		}
		return lista;
	}
}