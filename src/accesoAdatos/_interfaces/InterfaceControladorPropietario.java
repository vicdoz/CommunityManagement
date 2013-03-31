package accesoAdatos._interfaces;

import negocio.Propietario;
import excepciones.DAOExcepcion;

public interface InterfaceControladorPropietario {

	public void ActualizarPropietario(Propietario i) throws DAOExcepcion;

	public void borrarPropietario(Propietario i) throws DAOExcepcion;

	public void BorrarPropietario(int clave) throws DAOExcepcion;

	public Propietario GetActual(int i);

	public void GetPropietarios() throws DAOExcepcion;

	public int GetNumPropietario();

	public void NuevoPropietario(Propietario p) throws DAOExcepcion, Exception;
	
}