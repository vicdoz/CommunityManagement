package PruebasUnitarias;

import negocio.Carta;
import negocio.Inmueble;
import negocio.ReciboInmueble;
import accesoAdatos._controladores.ControladorCarta;
import accesoAdatos._controladores.ControladorComunidad;
import accesoAdatos._controladores.ControladorInmueble;
import accesoAdatos._controladores.ControladorPropietario;
import accesoAdatos._controladores.ControladorReciboInmueble;



public class Recibo {
	public static void main(String[] args) throws Throwable {
		ControladorReciboInmueble cri=ControladorReciboInmueble.getControladorReciboInmueble();
		ControladorCarta cc=ControladorCarta.getControladorCarta();
		ControladorInmueble ci=ControladorInmueble.getControladorInmueble();
		
		
		Carta c=new Carta();
		c.setCuerpo("A Carles:");
		c.setFecha("1-1-2013");
		
		ReciboInmueble ri=new ReciboInmueble();
		ri.setCarta(c);
		ri.setFechaPago("12-12-12");
		ri.setImporte((float) 12.234);
		
	
		
		Inmueble i=new Inmueble();
		i.setIdInmueble(24);
		i.setPuerta("XXX");
		i.setPiso("1");
		
		ri.setInmueble(i);
		
		ci.nuevoInmueble(i);
		cri.NuevoReciboInmueble(ri);
		
		System.out.println("Guardado correctamente");
		
		
		
	}
}
