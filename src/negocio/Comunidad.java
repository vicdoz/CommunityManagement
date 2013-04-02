package negocio;

import java.util.HashSet;
import java.util.Set;

public class Comunidad {

	private int idComunidad;
	private String nombre;
	private String calle;
	private String poblacion;
	private int maxRecibosPendientes;
	private String estado;
	private int idPresidente;/*A falta de solucionar las 2 relaciones aqui sera el id del presidente de la comunidad*/

	private Set<Inmueble> listaInmuebles = new HashSet<Inmueble>();
	private Set<NotaInformativa> listaNotasInformativas = new HashSet<NotaInformativa>();
	private Set<Factura> listaFacturas = new HashSet<Factura>();

	
	
	/*Constructor*/
	public Comunidad(){}
	
	public Set getListaInmuebles() {
		return listaInmuebles;
	}
	public Set<NotaInformativa> getListaNotasInformativas() {
		return listaNotasInformativas;
	}

	public Set getListaFacturas() {
		return listaFacturas;
	}

	public Comunidad(int idComunidad, String calle, int maxRecibosPendientes,
			String estado, int idPresidente) {
		super();
		this.idComunidad = idComunidad;
		this.calle = calle;
		this.maxRecibosPendientes = maxRecibosPendientes;
		this.estado = estado;
		this.idPresidente = idPresidente;
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
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
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
	}
