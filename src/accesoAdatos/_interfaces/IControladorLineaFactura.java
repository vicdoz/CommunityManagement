package accesoAdatos._interfaces;

import negocio.Concepto;



public interface IControladorLineaFactura {

	public void nuevoConcepto(Concepto c);
	public void actualizarConcepto(Concepto c);
	public void borrarConcepto(Concepto c);
}
