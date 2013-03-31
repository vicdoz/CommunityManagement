package negocio;

import java.util.Set;

public class Concepto {

	private int idConcepto;
	private String descripcion;
	private Set<LineaFactura> lineas;
	public Concepto(){}
	
	public Concepto(int claveConcepto, String descripcion) {
		super();
		this.idConcepto = claveConcepto;
		this.descripcion = descripcion;
	}
	public int getIdConcepto() {
		return idConcepto;
	}

	public void setIdConcepto(int idConcepto) {
		this.idConcepto = idConcepto;
	}

	public Set<LineaFactura> getLineas() {
		return lineas;
	}

	public void setLineas(Set<LineaFactura> lineas) {
		this.lineas = lineas;
	}

	public int getidConcepto() {
		return idConcepto;
	}
	private void setidConcepto(int claveConcepto) {
		this.idConcepto = claveConcepto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
