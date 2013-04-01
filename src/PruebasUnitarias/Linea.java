package PruebasUnitarias;

import accesoAdatos._controladores.ControladorConcepto;
import accesoAdatos._controladores.ControladorLineaFactura;
import negocio.Concepto;
import negocio.LineaFactura;

public class Linea {
	public static void main(String[] args) throws Throwable {
		ControladorConcepto cc=ControladorConcepto.getControladorConcepto();
		ControladorLineaFactura cl=ControladorLineaFactura.getControladorLineaFactura();
		
		Concepto c=new Concepto();
		c.setCodigo("1");
		c.setDescripcion("prueba2");
		c.setIdConcepto(1);
		
		
		LineaFactura l=new LineaFactura();
		
		l.setObservacion("nada");	
		l.setImporteLinea((float)1.5);
		l.setConcepto(c);
		
		cc.nuevoConcepto(c);
		cl.nuevoLineaFactura(l);
		
		
		
		
	}
}
