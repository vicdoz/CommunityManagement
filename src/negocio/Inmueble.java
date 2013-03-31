package negocio;

import java.util.HashSet;
import java.util.Set;

public class Inmueble {
	private int idInmueble;
	private String escalera;
	private String piso;
	private String puerta;
	private float porcentaje;
	@SuppressWarnings("unchecked")
	private Set listaRecibos = new HashSet();
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
	public int getIdInmueble() {
		return idInmueble;
	}
	public void setIdInmueble(int idInmueble) {
		this.idInmueble = idInmueble;
	}
	@SuppressWarnings("unchecked")
	public Set getListaRecibos() {
		return listaRecibos;
	}
	@SuppressWarnings("unchecked")
	public void setListaRecibos(Set listaRecibos) {
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

}
