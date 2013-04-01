package PruebasUnitarias;

import excepciones.DAOExcepcion;
import accesoAdatos._controladores.ControladorComunidad;
import accesoAdatos._controladores.ControladorInmueble;
import accesoAdatos._controladores.ControladorPropietario;
import negocio.Comunidad;
import negocio.Inmueble;
import negocio.Propietario;


public class InmuebleCompleto {

	/**
	 * @param args
	 * @throws Throwable 
	 */
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		Propietario p=new Propietario();
		Inmueble i=new Inmueble();
		Comunidad c=new Comunidad();
		ControladorPropietario controladorpropietario=ControladorPropietario.getControladorPropietario();
		ControladorInmueble controladorinmueble=ControladorInmueble.getControladorInmueble();
		ControladorComunidad controladorcomunidad=ControladorComunidad.getControladorComunidad();
		
		c.setCalle("MUSICO MAGENTI");
		c.setEstado("BIEN");
		c.setMaxRecibosPendientes(2);
		c.setIdComunidad(23);
		
		
		p.setNombre("Victor Ahuir");
		p.setDireccion("C/Musico Magenti 7");
		p.setEntidad(2037);
		p.setIdPropietario(45);
		p.setNumerocuenta(1234);
		p.setObservaciones("Sin observaciones");
		p.setPoblacion("alicante");
		p.setTelefono("687224490");
		i.setEscalera("A");

		i.setComunidad(c);
		i.setIdInmueble(24);
		i.setPuerta("XXX");
		i.setPiso("1");
		
		
		i.setPropietario(p);

		
		
		try {
			controladorcomunidad.nuevaComunidad(c);
			controladorpropietario.NuevoPropietario(p);
			controladorinmueble.nuevoInmueble(i);
			System.out.println("Insertado correctamente");
			} catch (DAOExcepcion e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			}
			
		
	}

}
