package PruebasUnitarias;

import excepciones.DAOExcepcion;
import accesoAdatos._controladores.ControladorPropietario;
import negocio.Propietario;


public class ModificarPropietario {

	/**
	 * @param args
	 * @throws Throwable 
	 */
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
	
		Propietario p=new Propietario();
		ControladorPropietario controladorpropietario=ControladorPropietario.getControladorPropietario();
				
		p.setIdPropietario(1);
		p.setNombre("Carles Perez");
		
		try {
			controladorpropietario.ActualizarPropietario(p);
			System.out.println("modificado correctamente");
			} catch (DAOExcepcion e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			}
			
		
	}

}

