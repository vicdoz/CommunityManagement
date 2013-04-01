package accesoAdatos._controladores;

import java.util.ArrayList;
import java.util.Iterator;

import accesoAdatos._ORM.ComunidadDAOHibernateImp;
import accesoAdatos._ORM.FacturaDAOHibernateImp;
import accesoAdatos._interfaces.InterfaceControladorComunidad;
import accesoAdatos._interfaces.InterfaceControladorFactura;
import negocio.Comunidad;
import negocio.Factura;
import excepciones.DAOExcepcion;

public class ControladorFactura implements InterfaceControladorFactura  {
	protected FacturaDAOHibernateImp miDaoFactura = new FacturaDAOHibernateImp();
	protected ArrayList<Factura> ListaFacturas = new ArrayList<Factura>();
	
	static private ControladorFactura ref_controladorFactura = new ControladorFactura();
	  
	private ControladorFactura() {		
	}
	
	static public ControladorFactura getControladorFactura()
	  {
		  return ref_controladorFactura;
	  }

	public void nuevaFactura(Factura f) throws DAOExcepcion {		
		this.miDaoFactura = new FacturaDAOHibernateImp();
		try {
			miDaoFactura.crearFactura(f);
			ListaFacturas.add(f);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void actualizarFactura(Factura f) throws DAOExcepcion {
		this.miDaoFactura = new FacturaDAOHibernateImp();
		try {
			miDaoFactura.actualizarFactura(f);
			int indexC = this.ListaFacturas.indexOf(f);
			this.ListaFacturas.set(indexC, f);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void borrarFactura(Factura c) throws DAOExcepcion {
		this.miDaoFactura = new FacturaDAOHibernateImp();
		try {
			miDaoFactura.borrarFactura(c);
			this.ListaFacturas.remove(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Factura> GetListaFacturas() {
		try {			
			this.ListaFacturas = miDaoFactura.getListaFacturasDAO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return ListaFacturas;
	}
	public Factura getFacturaPorPos(int row) {
		Factura c = new Factura();
		c = this.ListaFacturas.get(row);
		return c;
	}

	public Factura getFacturaPorId(int id) {
		// TODO Auto-generated method stub
		Iterator<Factura> it= ListaFacturas.iterator();
		while(it.hasNext()){
			System.out.println("Buscando");
			Factura cAux=it.next();
			System.out.println("ID encontrado:"+cAux.getidFactura());
			if(cAux.getidFactura()==id)
				return cAux;
		}
		System.out.println("Factura no encontrada");
		return null;		
	}




}
