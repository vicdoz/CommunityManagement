package negocio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import accesoAdatos._controladores.ControladorReciboInmueble;

public class Inmueble {
	private int idInmueble;
	private String escalera;
	private String piso;
	private String puerta;
	private float porcentaje;
	private Set<ReciboInmueble> listaRecibos = new HashSet<ReciboInmueble>();
	private Propietario propietario ;
	private Comunidad comunidad;

	public Inmueble(){}
	public Inmueble(int idInmueble, String escalera, String piso,
			String puerta, float porcentaje) {
		super();
		this.idInmueble = idInmueble;
		this.escalera = escalera;
		this.piso = piso;
		this.puerta = puerta;
		this.porcentaje = porcentaje;
	}
	public void addReciboToList(ReciboInmueble r){
		listaRecibos.add(r);
	}
	public void delReciboFromList(ReciboInmueble r){
		listaRecibos.remove(r);
	}
	public int getIdInmueble() {
		return idInmueble;
	}
	public void setIdInmueble(int idInmueble) {
		this.idInmueble = idInmueble;
	}

	public Set<ReciboInmueble> getListaRecibos() {
		return listaRecibos;
	}
	public void setListaRecibos(Set<ReciboInmueble> listaRecibos) {
		this.listaRecibos = listaRecibos;
	}
	public Propietario getPropietario() {
		return propietario;
	}
	public void setPropietario(Propietario p) {
		propietario=p;
	}
	public Comunidad getComunidad() {
		return comunidad;
	}
	public void setComunidad(Comunidad comunidad) {
		this.comunidad = comunidad;
	}
	public String getEscalera() {
		return escalera;
	}
	public void setEscalera(String escalera) {
		this.escalera = escalera;
	}
	public String getPiso() {
		return piso;
	}
	public void setPiso(String piso) {
		this.piso = piso;
	}
	public String getPuerta() {
		return puerta;
	}
	public void setPuerta(String puerta) {
		this.puerta = puerta;
	}
	public float getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(float porcentaje) {
		this.porcentaje = porcentaje;
	}

	public int calculaPendientes(int pi)
	{						
		ArrayList<ReciboInmueble> listaRecibos = ControladorReciboInmueble.getControladorReciboInmueble().GetListaReciboInmuebles();
		System.out.println("Tamaño lista"+listaRecibos.size());
		int pagados = 0, impagados = 0;			
		for(ReciboInmueble r:listaRecibos){						
			if(r.getInmueble().getIdInmueble()==this.idInmueble)
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
			if(r.getInmueble().getIdInmueble()==this.idInmueble)
			{
				if(r.getFechaPago()=="")	total += r.getImporte();					
			}
		}
		return total;
	}

}
