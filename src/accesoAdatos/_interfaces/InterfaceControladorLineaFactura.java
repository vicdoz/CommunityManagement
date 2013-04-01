package accesoAdatos._interfaces;

import negocio.Comunidad;
import excepciones.DAOExcepcion;

public interface InterfaceControladorLineaFactura {

	void nuevaComunidad(Comunidad c) throws DAOExcepcion;
	void actualizarComunidad(Comunidad c) throws DAOExcepcion;
	void borrarComunidad (Comunidad c)throws DAOExcepcion;
	
}
