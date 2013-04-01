package accesoAdatos._interfaces;

import negocio.Carta;
import excepciones.DAOExcepcion;

public interface InterfaceControladorCarta {

	void nuevaCarta(Carta c) throws DAOExcepcion;

}
