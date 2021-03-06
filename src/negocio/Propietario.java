package negocio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import negocio.*;

import accesoAdatos._controladores.ControladorInmueble;
import accesoAdatos._controladores.ControladorComunidad;
import accesoAdatos._controladores.ControladorReciboInmueble;

public class Propietario {
	private int idPropietario;
	private String nif;
	private String nombre;
	private String poblacion;
	private String direccion;
	private String telefono;
	private String observaciones;
	private String fechaalta;
	private String email;
	private int entidad;
	private int digitocontrol;
	private int sucursal;
	private int numerocuenta;
	private Set<Inmueble> listaInmuebles = new HashSet<Inmueble>();
	

	public Propietario(){}
	public Propietario(String nif, String nombre, String poblacion,
			String direccion, String telefono, String observaciones,
			String fechaalta, int entidad, int numerocuenta,String email) {
		super();
		this.nif = nif;
		this.nombre = nombre;
		this.poblacion = poblacion;
		this.direccion = direccion;
		this.telefono = telefono;
		this.observaciones = observaciones;
		this.fechaalta = fechaalta;
		this.entidad = entidad;
		this.numerocuenta = numerocuenta;
	}
	public Propietario(String nif, String nombre, String poblacion,
			String direccion, String telefono, String observaciones,
			 int entidad, int numerocuenta,String email, int sucursal, int dc,String fechaalta) {
		super();
		this.nif = nif;
		this.nombre = nombre;
		this.poblacion = poblacion;
		this.direccion = direccion;
		this.telefono = telefono;
		this.observaciones = observaciones;
		this.email=email;
		this.entidad = entidad;
		this.numerocuenta = numerocuenta;
		this.sucursal=sucursal;
		this.digitocontrol=dc;
		this.fechaalta=fechaalta;
	}
	public int getIdPropietario() {
		return idPropietario;
	}
	public void setIdPropietario(int idPropietario) {
		this.idPropietario = idPropietario;
	}
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public String getNombre() {
		return nombre;
	}
	public void addInmuebleToList(Inmueble i){
		listaInmuebles.add(i);
	}
	public void delInmuebleFromList(Inmueble i){
		 listaInmuebles.remove(i);
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public String getFechaalta() {
		return fechaalta;
	}
	public void setFechaalta(String fechaalta2) {
		this.fechaalta = fechaalta2;
	}
	public int getEntidad() {
		return entidad;
	}
	public void setEntidad(int entidad) {
		this.entidad = entidad;
	}
	public int getNumerocuenta() {
		return numerocuenta;
	}
	public void setNumerocuenta(int numerocuenta) {
		this.numerocuenta = numerocuenta;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set getListaInmuebles() {
		return listaInmuebles;
	}
	public void setListaInmuebles(Set<Inmueble> listaInmuebles) {
		this.listaInmuebles = listaInmuebles;
	}
	public int getdigitocontrol() {
		return digitocontrol;
	}
	public void setdigitocontrol(int digitocontrol) {
		this.digitocontrol = digitocontrol;
	}
	public int getSucursal() {
		return sucursal;
	}
	public void setSucursal(int sucursal) {
		this.sucursal = sucursal;
	}
	public boolean datosBancariosDomiciliados(){
		if(String.valueOf(sucursal).isEmpty()||sucursal==0)return false;
		else return true;
	}
	
	public int calculaPendientes(int pi)
	{						
		ArrayList<ReciboInmueble> listaRecibos = ControladorReciboInmueble.getControladorReciboInmueble().GetListaReciboInmuebles();
		System.out.println("Tama�o lista"+listaRecibos.size());
		int pagados = 0, impagados = 0;			
		for(ReciboInmueble r:listaRecibos){						
			if(r.getInmueble().getPropietario().getIdPropietario()==this.getIdPropietario())
			{
				if(r.getFechaPago()=="")	impagados += 1;
				else	pagados += 1;
			}
		}
		if(pi==0)	return pagados;
		return impagados;
	}
	public int enviarCarta()
	{
		ArrayList<Inmueble> listaInmuebles = ControladorInmueble.getControladorInmueble().GetListaInmuebles();
		for(Inmueble i: listaInmuebles){			
			int max = ControladorComunidad.getControladorComunidad().getComunidadPorId(i.getComunidad().getIdComunidad()).getMaxRecibosPendientes();
			System.out.println("Maximos recibos para la comunidad: "+max);
			if(calculaCartaInmueble(i) >= max){
				System.out.println("Se han superado el m�ximo de recibos pendientes permitidos");
				return 1;
			}
		}
		System.out.println("Maximo de recibos pendientes no superado");
		return 0;
	}
	public int calculaCartaInmueble(Inmueble i)
	{						
		ArrayList<ReciboInmueble> listaRecibos = ControladorReciboInmueble.getControladorReciboInmueble().GetListaReciboInmuebles();
		System.out.println("Tama�o lista"+listaRecibos.size());
		int impagados = 0;			
		for(ReciboInmueble r:listaRecibos){
			if(r.getInmueble()== i){
				if(r.getInmueble().getPropietario().getIdPropietario()==this.getIdPropietario())
				{
					if(r.getFechaPago()=="")	impagados += 1;					
				}	
			}
		}
		return impagados;
	}
	
	public float calculaAdeudado()
	{						
		ArrayList<ReciboInmueble> listaRecibos = ControladorReciboInmueble.getControladorReciboInmueble().GetListaReciboInmuebles();
		float total=0;			
		for(ReciboInmueble r:listaRecibos){						
			if(r.getInmueble().getPropietario().getIdPropietario()==this.getIdPropietario())
			{
				if(r.getFechaPago()=="")	total += r.getImporte();					
			}
		}
		return total;
	}
}
