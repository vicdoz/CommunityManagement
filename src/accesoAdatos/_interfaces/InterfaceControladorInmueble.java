package accesoAdatos._interfaces;

import negocio.Inmueble;
import excepciones.DAOExcepcion;

// Definici�n parcial no contiene la signatura de todos los m�todos.

public interface InterfaceControladorInmueble {

	
	void nuevoInmueble(Inmueble c) throws DAOExcepcion;
	void actualizarInmueble(Inmueble c) throws DAOExcepcion;
	void borrarInmueble(Inmueble c) throws DAOExcepcion;

}