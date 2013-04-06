package negocio;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class Factura {
	private int idFactura;
	private String fechaFactura;
	private String CIF;
	private float tipoIva;	
	private float importeIva;
	private float importeSinIva;
	private float importeConIva;
	
	private Set<LineaFactura> listaLineas = new HashSet<LineaFactura>();
	private Comunidad comunidad;
	private NotaInformativa notainformativa;
	
	public Factura(){}
	public Factura(String cif, int numFactura, String fechaFactura) {
		super();
		this.CIF = cif;
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
	public String getFechaFactura() {
		return fechaFactura;
	}
	public void setFechaFactura(String fechaFactura) {
		this.fechaFactura = fechaFactura;
	}
	public void setCIF(String cIF) {
		CIF = cIF;
	}
	public String getCIF() {
		return CIF;
	}

	public void acumulaImporteLinea(LineaFactura l){
		importeSinIva+=l.getImporteLinea();
	}
	public float getTipoIva() {
		return tipoIva;
	}
	public void setTipoIva(float tipoIva) {
		this.tipoIva = tipoIva;
	}
	public float getImporteIva() {
		return importeIva;
	}
	public void setImporteIva(float importeIva) {
		this.importeIva = importeIva;
	}
	public float getImporteSinIva() {
		return importeSinIva;
	}
	public void setImporteSinIva(float importeSinIva) {
		this.importeSinIva = importeSinIva;
	}
	public float getImporteConIva() {
		return importeConIva;
	}
	public void setImporteConIva(float importeConIva) {
		this.importeConIva = importeConIva;
	}
}
