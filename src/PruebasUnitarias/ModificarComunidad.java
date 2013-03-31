package PruebasUnitarias;
import excepciones.DAOExcepcion;
import accesoAdatos._controladores.ControladorComunidad;
import negocio.Comunidad;


public class ModificarComunidad {

	/**
	 * @param args
	 * @throws Throwable 
	 */
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
	
		Comunidad c=new Comunidad();	
		ControladorComunidad controladorcomunidad=ControladorComunidad.getControladorComunidad();
		
		c.setCalle("Calle de al lado");
		c.setEstado("BIEN");
		c.setMaxRecibosPendientes(2);
		c.setIdComunidad(1);//ID A MODIFICAR
		try {
			controladorcomunidad.actualizarComunidad(c);
			System.out.println("modificado correctamente");
			} catch (DAOExcepcion e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			}
			
		
	}

}

