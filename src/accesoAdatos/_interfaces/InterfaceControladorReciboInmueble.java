package accesoAdatos._interfaces;

import negocio.ReciboInmueble;
import excepciones.DAOExcepcion;

public interface InterfaceControladorReciboInmueble {

	void ActualizarReciboInmueble(ReciboInmueble p) throws DAOExcepcion;

}
