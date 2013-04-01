package PruebasUnitarias;

import accesoAdatos._controladores.ControladorComunidad;
import accesoAdatos._controladores.ControladorConcepto;
import accesoAdatos._controladores.ControladorFactura;
import accesoAdatos._controladores.ControladorLineaFactura;
import negocio.Comunidad;
import negocio.Concepto;
import negocio.Factura;
import negocio.LineaFactura;

public class FacturaCompleta {
	public static void main(String[] args) throws Throwable {
		ControladorConcepto cc=ControladorConcepto.getControladorConcepto();
		ControladorLineaFactura cl=ControladorLineaFactura.getControladorLineaFactura();
		ControladorFactura cf=ControladorFactura.getControladorFactura();
		ControladorComunidad cm=ControladorComunidad.getControladorComunidad();
		
		//Insertamos un concepto
		Concepto c=new Concepto();
		c.setCodigo("1");
		c.setDescripcion("prueba2");
		c.setIdConcepto(1);
		
		//Insertamos el concepto en una linea
		LineaFactura l=new LineaFactura();
		l.setObservacion("nada");	
		l.setImporteLinea((float)1.5);
		l.setConcepto(c);
		
		//Insertamos una linea en una factura
		Factura f=new Factura();
		f.setFechaFactura("1-1-2013");
		l.setFactura(f);
		
		//La factura tendra una comunidad
		Comunidad com=new Comunidad();
		com.setCalle("Nueva calle");
		com.setNombre("Aqui no hay quien viva");
		f.setComunidad(com);
		//Guardamos cambios
		cm.nuevaComunidad(com);
		cc.nuevoConcepto(c);
		cl.nuevoLineaFactura(l);
		cf.nuevaFactura(f);
		System.out.println("Insertado correctamente");
		
		
		
	}
}
