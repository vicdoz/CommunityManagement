package PruebasUnitarias;
import excepciones.DAOExcepcion;
import accesoAdatos._controladores.ControladorInmueble;
import negocio.Inmueble;


public class ModificarInmueble {

	/**
	 * @param args
	 * @throws Throwable 
	 */
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		Inmueble i=new Inmueble();
		ControladorInmueble controladorinmueble=ControladorInmueble.getControladorInmueble();
	
		i.setIdInmueble(2);
		i.setPuerta("YYYY");

		try {

			controladorinmueble.actualizarInmueble(i);
			System.out.println("actualizado correctamente");
			} catch (DAOExcepcion e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			}
			
		
	}

}
