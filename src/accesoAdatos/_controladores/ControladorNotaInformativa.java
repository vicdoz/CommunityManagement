package accesoAdatos._controladores;

import java.util.ArrayList;
import java.util.Iterator;

import accesoAdatos._ORM.CartaDAOHibernateImp;
import accesoAdatos._ORM.NotaInformativaDAOHibernateImp;
import accesoAdatos._interfaces.InterfaceControladorCarta;
import accesoAdatos._interfaces.InterfaceControladorNotaInformativa;

import negocio.Carta;
import negocio.NotaInformativa;
import excepciones.DAOExcepcion;

public class ControladorNotaInformativa implements InterfaceControladorNotaInformativa  {
	protected NotaInformativaDAOHibernateImp miDaoNota = new NotaInformativaDAOHibernateImp();
	protected ArrayList<NotaInformativa> ListaNotas = new ArrayList<NotaInformativa>();
	
	static private ControladorNotaInformativa ref_controladorCarta = new ControladorNotaInformativa();
	  
	private ControladorNotaInformativa() {		
	}
	
	static public ControladorNotaInformativa getControladorNotaInformativa()
	  {
		  return ref_controladorCarta;
	  }

	public void nuevaNotaInformativa(NotaInformativa c) throws DAOExcepcion {		
		this.miDaoNota = new NotaInformativaDAOHibernateImp();
		try {
			miDaoNota.crearNotaInformativa(c);
			ListaNotas.add(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void actualizarNotaInformativa(NotaInformativa c) throws DAOExcepcion {
		this.miDaoNota = new NotaInformativaDAOHibernateImp();
		try {
			miDaoNota.actualizarNotaInformativa(c);
			int indexC = this.ListaNotas.indexOf(c);
			this.ListaNotas.set(indexC, c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void borrarNotaInformativa(NotaInformativa c) throws DAOExcepcion {
		this.miDaoNota = new NotaInformativaDAOHibernateImp();
		try {
			miDaoNota.borrarNotaInformativa(c);
			this.ListaNotas.remove(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<NotaInformativa> GetListaNotaInformativas() {
		try {			
			this.ListaNotas = miDaoNota.getListaNotaInformativasDAO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return ListaNotas;
	}
	public NotaInformativa getNotaInformativaPorPos(int row) {
		NotaInformativa c = new NotaInformativa();
		c = this.ListaNotas.get(row);
		return c;
	}

	public NotaInformativa getNotaInformativaPorId(int id) {
		// TODO Auto-generated method stub
		Iterator<NotaInformativa> it= ListaNotas.iterator();
		while(it.hasNext()){
			System.out.println("Buscando");
			NotaInformativa cAux=it.next();
			System.out.println("ID encontrado:"+cAux.getIdNotaInformativa());
			if(cAux.getIdNotaInformativa()==id)
				return cAux;
		}
		System.out.println("NotaInformativa no encontrada");
		return null;		
	}	
}
