package accesoAdatos._controladores;

import java.util.ArrayList;
import java.util.Iterator;

import accesoAdatos._ORM.PropietarioDAOHibernateImp;
import accesoAdatos._interfaces.InterfaceControladorPropietario;

import negocio.Propietario;

import excepciones.DAOExcepcion;

// Clase parcialmente implementada.
public class ControladorPropietario implements InterfaceControladorPropietario  {
// Parcialmente immplementada
	
	protected PropietarioDAOHibernateImp	 miDaoPropietario = new PropietarioDAOHibernateImp();
	protected ArrayList<Propietario> ListaPropietarios = new ArrayList<Propietario>();
	static private ControladorPropietario ref_controladorPropietario = new ControladorPropietario();

	
	private ControladorPropietario() {
	}
	
	static public ControladorPropietario getControladorPropietario()
	  {
		  return ref_controladorPropietario;
	  }

	@Override
	public void ActualizarPropietario(Propietario p) throws DAOExcepcion {
		// TODO Auto-generated method stub	
	}


	@Override
	public void BorrarPropietario(int clave) throws DAOExcepcion {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Propietario GetActual(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int GetNumPropietario() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void GetPropietarios() throws DAOExcepcion {
		// TODO Auto-generated method stub
		
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Propietario> GetListaPropietarios() {
		try {			
			this.ListaPropietarios = miDaoPropietario.getListaPropietariosDAO();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return ListaPropietarios;
	}
	@SuppressWarnings("unchecked")
	public ArrayList<String> GetListaNombresPropietarios() {
		ArrayList<String> nombres=new ArrayList<String>();
		try {	
			if(ListaPropietarios.isEmpty())
				ListaPropietarios = miDaoPropietario.getListaPropietariosDAO();
			Iterator<Propietario> it= ListaPropietarios.iterator();
				while(it.hasNext()){
					Propietario paux=it.next();
					nombres.add(paux.getNombre());
				}		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return nombres;
	}
	@Override
	public void NuevoPropietario(Propietario p) throws Exception {
		// TODO Auto-generated method stub
		miDaoPropietario = new PropietarioDAOHibernateImp();
		try {
			miDaoPropietario.crearPropietario(p);	
			ListaPropietarios.add(p);
		} catch (DAOExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
	}
	 public void actualizarPropietario(Propietario p) throws DAOExcepcion {
         // TODO Auto-generated method stub
         this.miDaoPropietario = new PropietarioDAOHibernateImp();
         try {
                 miDaoPropietario.actualizarPropietario(p);
                 int indexP = this.ListaPropietarios.indexOf(p);
     			 this.ListaPropietarios.set(indexP, p);
         } catch (Exception e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
         }
	 }
	public void borrarPropietario(Propietario p) throws DAOExcepcion {
		// TODO Auto-generated method stub
		this.miDaoPropietario = new PropietarioDAOHibernateImp();
		try {
			miDaoPropietario.borrarPropietario(p);
			this.ListaPropietarios.remove(p);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Propietario getPropietarioPorId(int id){				
		Iterator<Propietario> it= ListaPropietarios.iterator();
		while(it.hasNext()){
			Propietario paux=it.next();
			if(paux.getIdPropietario()==id)
				return paux;
		}
		System.out.println("Propietario no encontrado");
		return null ;
	}

	public Propietario getPropietarioPorPos(int row) {
		Propietario p = new Propietario();
		p = this.ListaPropietarios.get(row);
		return p;
	}

    public Propietario getPropietarioPorNIF(String nif) {
        Iterator<Propietario> it= ListaPropietarios.iterator();
        while(it.hasNext()){
                Propietario p=it.next();
                if(p.getNif()==nif)		return p;
        }
        System.out.println("No se pudo recuperar el propietario");
        return null;
    }

	public boolean datosBancariosCorrectos(String entidad, String sucursal,
			String digitoControl, String numcuenta) {
		if(digitoControl.toCharArray().length!=2 ||entidad.toCharArray().length!=4
			||sucursal.toCharArray().length!=4 ||numcuenta.toCharArray().length!=10)return false;
		else return true;
	}

}
