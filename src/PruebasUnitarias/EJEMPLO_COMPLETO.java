package PruebasUnitarias;

import accesoAdatos._controladores.*;
import negocio.*;

public class EJEMPLO_COMPLETO {
	public static void main(String[] args) throws Throwable {
		//Declaracion controladores
			ControladorConcepto cc=ControladorConcepto.getControladorConcepto();
			ControladorPropietario cp=ControladorPropietario.getControladorPropietario();
			ControladorLineaFactura cl=ControladorLineaFactura.getControladorLineaFactura();
			ControladorFactura cf=ControladorFactura.getControladorFactura();
			ControladorComunidad cm=ControladorComunidad.getControladorComunidad();
			ControladorNotaInformativa cni=ControladorNotaInformativa.getControladorNotaInformativa();
			ControladorReciboInmueble cri=ControladorReciboInmueble.getControladorReciboInmueble();
			ControladorCarta cc1=ControladorCarta.getControladorCarta();
			ControladorInmueble ci=ControladorInmueble.getControladorInmueble();
		//Declaracion objetos	
			Propietario p=new Propietario();
			Concepto c=new Concepto();
			LineaFactura l=new LineaFactura();	
			Factura f=new Factura();
			Comunidad com=new Comunidad();
			NotaInformativa ni=new NotaInformativa();
			ReciboInmueble ri=new ReciboInmueble();
			Carta c1=new Carta();
			Inmueble i=new Inmueble();
		
	    //Propietario
			p.setDireccion("Musico Magenti 1");
			p.setEntidad(2037);
			p.setFechaalta("14-45-34");
			p.setNif("1234324S");
			p.setNombre("victor ahuir");
			p.setEmail("v.ahuir@gmail.com");
			p.setNumerocuenta(0000000);
			p.setObservaciones("nada");
			p.setPoblacion("valencia");
			p.setTelefono("6666");
		//Concepto
			c.setCodigo("1");
			c.setDescripcion("prueba2");
			c.setIdConcepto(1);
		//LineaFactura
			
			l.setObservacion("nada");
			l.setImporteLinea((float)1.5);	
			//l.setConcepto(c);
			l.setFactura(f);	
		//Factura
			f.setFechaFactura("1-1-2013");
			f.setComunidad(com);
			f.setNotainformativa(ni);
		//Comunidad
			com.setCalle("Nueva calle");
			com.setNombre("Aqui no hay quien viva");
			com.setEstado(0);
			 //com.setIdPresidente(i);
			com.setMaxRecibosPendientes(12);
			com.setPoblacion("Valencia");
		//NotaInformativa
			ni.setComunidad(com);
			ni.setFechaCalculo("12-34-123");
			ni.setImporteNota((float) 55.34);
			
		//Carta
			c1.setCuerpo("A Carles:");
			c1.setFecha("1-1-2013");
		//ReciboInmueble
			ri.setCarta(c1);
			ri.setFechaPago("12-12-12");
			ri.setImporte((float) 12.234);
			ri.setInmueble(i);
			ri.setNotaInformativa(ni);	
			ri.setInmueble(i);
		//Inmueble
			i.setEscalera("1A");
			i.setPiso("Segundo");
			i.setPuerta("2");
			i.setPorcentaje(15);
			i.setComunidad(com);
			i.setPropietario(p);

		
		//Guardamos cambios en BD
			cp.NuevoPropietario(p);
			cc1.nuevaCarta(c1);
			cm.nuevaComunidad(com);
			ci.nuevoInmueble(i);
			cc.nuevoConcepto(c);
			cni.nuevaNotaInformativa(ni);
			cf.nuevaFactura(f);
			cri.NuevoReciboInmueble(ri);
			cl.nuevoLineaFactura(l);
		System.out.println("Insertado correctamente");		
	}
}
