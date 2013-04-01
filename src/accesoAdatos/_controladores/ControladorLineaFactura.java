package accesoAdatos._controladores;

import java.util.ArrayList;
import java.util.Iterator;

import accesoAdatos._ORM.ConceptoDAOHibernateImp;
import accesoAdatos._ORM.LineaFacturaDAOHibernateImp;
import accesoAdatos._interfaces.InterfaceControladorConcepto;
import negocio.Concepto;
import negocio.LineaFactura;
import excepciones.DAOExcepcion;

public class ControladorLineaFactura   {
	protected LineaFacturaDAOHibernateImp miDaoLineaFactura  = new LineaFacturaDAOHibernateImp();
	protected ArrayList<LineaFactura> ListaLineaFacturas = new ArrayList<LineaFactura >();
	
	static private ControladorLineaFactura ref_controladorLineaFactura  = new ControladorLineaFactura();
	  
	private ControladorLineaFactura() {		
	}
	
	static public ControladorLineaFactura getControladorLineaFactura ()
	  {
		  return ref_controladorLineaFactura ;
	  }

	public void nuevoLineaFactura (LineaFactura  l) throws DAOExcepcion {		
		this.miDaoLineaFactura  = new LineaFacturaDAOHibernateImp();
		try {
			miDaoLineaFactura.crearLineaFactura (l);
			ListaLineaFacturas.add(l);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void actualizarLineaFactura (LineaFactura  l) throws DAOExcepcion {
		this.miDaoLineaFactura  = new LineaFacturaDAOHibernateImp();
		try {
			miDaoLineaFactura.actualizarLineaFactura (l);
			int indexC = this.ListaLineaFacturas.indexOf(l);
			this.ListaLineaFacturas.set(indexC, l);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void borrarLineaFactura (LineaFactura  l) throws DAOExcepcion {
		this.miDaoLineaFactura  = new LineaFacturaDAOHibernateImp();
		try {
			miDaoLineaFactura.borrarLineaFactura (l);
			this.ListaLineaFacturas.remove(l);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<LineaFactura > GetListaLineaFactura() {
		try {			
			this.ListaLineaFacturas = miDaoLineaFactura.getListaLineaFacturaDAO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return ListaLineaFacturas;
	}
	public LineaFactura  getLineaFacturaPorPos(int row) {
		LineaFactura  l = new LineaFactura ();
		l = this.ListaLineaFacturas.get(row);
		return l;
	}

	public LineaFactura  getLineaFacturaPorId(int id) {
		// TODO Auto-generated method stub
		Iterator<LineaFactura > it= ListaLineaFacturas.iterator();
		while(it.hasNext()){
			System.out.println("Buscando");
			LineaFactura  cAux=it.next();
			System.out.println("ID encontrado:"+cAux.getIdLineaFactura ());
			if(cAux.getIdLineaFactura ()==id)
				return cAux;
		}
		System.out.println("LineaFactura  no encontrado");
		return null;		
	}	
}
