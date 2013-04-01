package PruebasUnitarias;

import negocio.Carta;
import accesoAdatos._controladores.ControladorCarta;



public class CartaPrueba {
	public static void main(String[] args) throws Throwable {
		ControladorCarta cc=ControladorCarta.getControladorCarta();
		
		
		Carta c=new Carta();
		c.setCuerpo("A Carles:");
		c.setFecha("1-1-2013");
		
		cc.nuevaCarta(c);
		System.out.println("Nueva Carta insertada correctamente");
	
		
		
		
		
	}
}
