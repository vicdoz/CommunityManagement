package accesoAdatos._interfaces;

import negocio.Inmueble;
import excepciones.DAOExcepcion;

// Definición parcial no contiene la signatura de todos los métodos.

public interface InterfaceControladorInmueble {

	
	void nuevoInmueble(Inmueble c) throws DAOExcepcion;
	void actualizarInmueble(Inmueble c) throws DAOExcepcion;
	void borrarInmueble(Inmueble c) throws DAOExcepcion;

}