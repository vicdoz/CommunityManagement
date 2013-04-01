package accesoAdatos._controladores;

import java.util.ArrayList;
import java.util.Iterator;

import accesoAdatos._ORM.CartaDAOHibernateImp;
import accesoAdatos._interfaces.InterfaceControladorCarta;

import negocio.Carta;
import excepciones.DAOExcepcion;

public class ControladorCarta implements InterfaceControladorCarta  {
	protected CartaDAOHibernateImp miDaoCarta = new CartaDAOHibernateImp();
	protected ArrayList<Carta> ListaCartas = new ArrayList<Carta>();
	
	static private ControladorCarta ref_controladorCarta = new ControladorCarta();
	  
	private ControladorCarta() {		
	}
	
	static public ControladorCarta getControladorCarta()
	  {
		  return ref_controladorCarta;
	  }

	@Override
	public void nuevaCarta(Carta c) throws DAOExcepcion {		
		this.miDaoCarta = new CartaDAOHibernateImp();
		try {
			miDaoCarta.crearCarta(c);
			ListaCartas.add(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void actualizarCarta(Carta c) throws DAOExcepcion {
		this.miDaoCarta = new CartaDAOHibernateImp();
		try {
			miDaoCarta.actualizarCarta(c);
			int indexC = this.ListaCartas.indexOf(c);
			this.ListaCartas.set(indexC, c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void borrarCarta(Carta c) throws DAOExcepcion {
		this.miDaoCarta = new CartaDAOHibernateImp();
		try {
			miDaoCarta.borrarCarta(c);
			this.ListaCartas.remove(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Carta> GetListaCartas() {
		try {			
			this.ListaCartas = miDaoCarta.getListaCartasDAO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return ListaCartas;
	}
	public Carta getCartaPorPos(int row) {
		Carta c = new Carta();
		c = this.ListaCartas.get(row);
		return c;
	}

	public Carta getCartaPorId(int id) {
		// TODO Auto-generated method stub
		Iterator<Carta> it= ListaCartas.iterator();
		while(it.hasNext()){
			System.out.println("Buscando");
			Carta cAux=it.next();
			System.out.println("ID encontrado:"+cAux.getIdCarta());
			if(cAux.getIdCarta()==id)
				return cAux;
		}
		System.out.println("Carta no encontrada");
		return null;		
	}	
}
