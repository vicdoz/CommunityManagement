package PruebasUnitarias;

import excepciones.DAOExcepcion;
import accesoAdatos._controladores.ControladorComunidad;
import negocio.Comunidad;

public class InmuebleCompletoBorrar {

	/**
	 * 
	 * @param args
	 * @throws Throwable 
	 */
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
	
		Comunidad c=new Comunidad();
		ControladorComunidad controladorcomunidad=ControladorComunidad.getControladorComunidad();
		
		c.setIdComunidad(1);//ID A BORRAR
		try {
			controladorcomunidad.borrarComunidad(c);
			System.out.println("borrado correctamente");
			} catch (DAOExcepcion e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			}
		
	}

}

