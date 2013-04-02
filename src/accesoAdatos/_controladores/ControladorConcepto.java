package accesoAdatos._controladores;

import java.util.ArrayList;
import java.util.Iterator;

import accesoAdatos._ORM.ConceptoDAOHibernateImp;
import negocio.Concepto;
import excepciones.DAOExcepcion;

public class ControladorConcepto   {
	protected ConceptoDAOHibernateImp miDaoConcepto = new ConceptoDAOHibernateImp();
	protected ArrayList<Concepto> ListaConceptos = new ArrayList<Concepto>();
	
	static private ControladorConcepto ref_controladorConcepto = new ControladorConcepto();
	  
	private ControladorConcepto() {		
	}
	
	static public ControladorConcepto getControladorConcepto()
	  {
		  return ref_controladorConcepto;
	  }

	public void nuevoConcepto(Concepto c) throws DAOExcepcion {		
		this.miDaoConcepto = new ConceptoDAOHibernateImp();
		try {
			miDaoConcepto.crearConcepto(c);
			ListaConceptos.add(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void actualizarConcepto(Concepto c) throws DAOExcepcion {
		this.miDaoConcepto = new ConceptoDAOHibernateImp();
		try {
			miDaoConcepto.actualizarConcepto(c);
			int indexC = this.ListaConceptos.indexOf(c);
			this.ListaConceptos.set(indexC, c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void borrarConcepto(Concepto c) throws DAOExcepcion {
		this.miDaoConcepto = new ConceptoDAOHibernateImp();
		try {
			miDaoConcepto.borrarConcepto(c);
			this.ListaConceptos.remove(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Concepto> GetListaConceptos() {
		try {			
			this.ListaConceptos = miDaoConcepto.getListaConceptoDAO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return ListaConceptos;
	}
	public Concepto getConceptoPorPos(int row) {
		Concepto c = new Concepto();
		c = this.ListaConceptos.get(row);
		return c;
	}

	public Concepto getConceptoPorId(int id) {
		// TODO Auto-generated method stub
		Iterator<Concepto> it= ListaConceptos.iterator();		
		while(it.hasNext()){
			System.out.println("Buscando");
			Concepto cAux=it.next();
			System.out.println("ID encontrado:"+cAux.getIdConcepto());
			if(cAux.getIdConcepto()==id)
				return cAux;
		}
		System.out.println("Concepto no encontrado");
		return null;		
	}

	public Concepto getConceptoPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		Iterator<Concepto> it= ListaConceptos.iterator();
		while(it.hasNext()){
			System.out.println("Buscando");
			Concepto cAux=it.next();
			String cad = cAux.getCodigo().trim();
			System.out.println("Codigo encontrado: "+cad+".");
			if(cad.equals(codigo))	return cAux;
		}
		System.out.println("Concepto no encontrado");
		return null;
	}	
}
