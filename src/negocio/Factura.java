package negocio;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class Factura {
	private int idFactura;
	private Date fechaFactura;
	
	private Set listaLineas = new HashSet();
	private Comunidad comunidad;
	private NotaInformativa notainformativa;
	
	public Factura(){}
	public Factura(int numFactura, Date fechaFactura) {
		super();
		this.idFactura = numFactura;
		this.fechaFactura = fechaFactura;
	}
	public Set getListaLineas() {
		return listaLineas;
	}
	public void setListaLineas(Set listaLineas) {
		this.listaLineas = listaLineas;
	}
	public Comunidad getComunidad() {
		return comunidad;
	}
	public void setComunidad(Comunidad comunidad) {
		this.comunidad = comunidad;
	}
	public NotaInformativa getNotainformativa() {
		return notainformativa;
	}
	public void setNotainformativa(NotaInformativa notainformativa) {
		this.notainformativa = notainformativa;
	}
	public int getidFactura() {
		return idFactura;
	}
	private void setidFactura(int numFactura) {
		this.idFactura = numFactura;
	}
	public Date getFechaFactura() {
		return fechaFactura;
	}
	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}
}
