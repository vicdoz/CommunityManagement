package negocio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import accesoAdatos._controladores.ControladorInmueble;
import accesoAdatos._controladores.ControladorReciboInmueble;

public class Comunidad {

	private int idComunidad;
	private String nombre;
	private String calle;
	private String poblacion;
	private int maxRecibosPendientes;
	private int estado;
	private int idPresidente;/*A falta de solucionar las 2 relaciones aqui sera el id del presidente de la comunidad*/

	private Set<Inmueble> listaInmuebles = new HashSet<Inmueble>();
	private Set<NotaInformativa> listaNotasInformativas = new HashSet<NotaInformativa>();
	private Set<Factura> listaFacturas = new HashSet<Factura>();

	
	
	/*Constructor*/
	public Comunidad(){}
	
	public Set<Inmueble> getListaInmuebles() {
		return listaInmuebles;
	}
	public Set<NotaInformativa> getListaNotasInformativas() {
		return listaNotasInformativas;
	}

	public Set<Factura> getListaFacturas() {
		return listaFacturas;
	}
	
	public void addInmuebleToList(Inmueble i){
		listaInmuebles.add(i);
	}
	public void addNotaInformativaToList(NotaInformativa i){
		listaNotasInformativas.add(i);
	}
	public void delFacturaFromList(Factura i){
		 listaFacturas.add(i);
	}
	public void delInmuebleFromList(Inmueble i){
		 listaInmuebles.remove(i);
	}
	public void delNotaInformativaFromList(NotaInformativa i){
		 listaNotasInformativas.remove(i);
	}
	public void addFacturaToList(Factura i){
		listaFacturas.add(i);
	}

	public Comunidad(int idComunidad, String calle, int maxRecibosPendientes,
			int estado, int idPresidente) {
		super();
		this.idComunidad = idComunidad;
		this.calle = calle;
		this.maxRecibosPendientes = maxRecibosPendientes;
		this.estado = estado;
		this.idPresidente = idPresidente;
		this.estado=-1;
	}
	/*Getters and setters*/
	public int getIdComunidad() {
		return idComunidad;
	}
	public void setIdComunidad(int idComunidad) {
		this.idComunidad = idComunidad;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public int getMaxRecibosPendientes() {
		return maxRecibosPendientes;
	}
	public void setMaxRecibosPendientes(int maxRecibosPendientes) {
		this.maxRecibosPendientes = maxRecibosPendientes;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public int getIdPresidente() {
		return idPresidente;
	}
	public void setIdPresidente(int idPresidente) {
		this.idPresidente = idPresidente;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public void setListaInmuebles(Set<Inmueble> listaInmuebles) {
		this.listaInmuebles = listaInmuebles;
	}

	public void setListaNotasInformativas(
			Set<NotaInformativa> listaNotasInformativas) {
		this.listaNotasInformativas = listaNotasInformativas;
	}

	public void setListaFacturas(Set<Factura> listaFacturas) {
		this.listaFacturas = listaFacturas;
	}
	public int convertirEstado(String estado){
		estado=estado.toLowerCase().trim();
		if(estado.equals("sincuadrar")){ this.estado=0;return 0;}
		else if(estado.equals("cuadrado")){this.estado=1; return 1;}
						else if(estado.equals("baja")){ this.estado=2;return 2;}
								else if(estado.equals("moroso")){ this.estado=3;return 3;}
										else return -1;

	}
	public int calcularEstado(){
		int totalPercentaje=0;
		ArrayList<Inmueble> listaInmueble= ControladorInmueble.getControladorInmueble().GetListaInmuebles();
	
			for(Inmueble it:listaInmueble){
				System.out.println("Buscando");
				System.out.println(it.getPorcentaje());
				totalPercentaje+=it.getPorcentaje();
			}
			
			if(totalPercentaje>=99.99 &&totalPercentaje <=100  ){//cuadrado
				System.out.println(totalPercentaje);
					estado=1;
					return 1;
			}else{ //sin cuadrar
				System.out.println(totalPercentaje);
				if(estado<=1){
					estado=0;
					return 0;
				}
				else if(estado==2)estado=0;
			
		}
		return 0;
	}
	public String getEstadoToString(){
		if (estado==0) return "Sin cuadrar";
		else if (estado==1) return "Cuadrado";
		else if(estado==2) return "Baja";
		else if(estado==3) return "Moroso";
		return "Estado";
	}
	
	public int calculaPendientes(int pi)
	{						
		ArrayList<ReciboInmueble> listaRecibos = ControladorReciboInmueble.getControladorReciboInmueble().GetListaReciboInmuebles();
		System.out.println("Tama�o lista"+listaRecibos.size());
		int pagados = 0, impagados = 0;			
		for(ReciboInmueble r:listaRecibos){						
			if(r.getInmueble().getComunidad().getIdComunidad()==this.getIdComunidad())
			{
				if(r.getFechaPago()=="")	impagados += 1;
				else	pagados += 1;
			}
		}
		if(pi==0)	return pagados;
		return impagados;
	}
	public float calculaAdeudado()
	{						
		ArrayList<ReciboInmueble> listaRecibos = ControladorReciboInmueble.getControladorReciboInmueble().GetListaReciboInmuebles();
		float total=0;			
		for(ReciboInmueble r:listaRecibos){						
			if(r.getInmueble().getComunidad().getIdComunidad()==this.getIdComunidad())
			{
				if(r.getFechaPago()=="")	total += r.getImporte();					
			}
		}
		return total;
	}
	
	
}
