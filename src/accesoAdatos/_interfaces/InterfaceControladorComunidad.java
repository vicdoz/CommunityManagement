package accesoAdatos._interfaces;

import negocio.Comunidad;
import excepciones.DAOExcepcion;

public interface InterfaceControladorComunidad {

	void nuevaComunidad(Comunidad c) throws DAOExcepcion;
	void actualizarComunidad(Comunidad c) throws DAOExcepcion;
	void borrarComunidad (Comunidad c)throws DAOExcepcion;
	
}
