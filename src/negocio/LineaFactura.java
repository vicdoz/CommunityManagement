package negocio;

import java.util.HashSet;
import java.util.Set;

public class LineaFactura {
	private int idLineaFactura;
	private float importeLinea;
	private String observacion;
	private  Concepto concepto;
	public LineaFactura(){}
	public LineaFactura(int idLineaFactura, float importeLinea,
			String observacion) {
		super();
		this.idLineaFactura = idLineaFactura;
		this.importeLinea = importeLinea;
		this.observacion = observacion;
	}
	public int getIdLineaFactura() {
		return idLineaFactura;
	}
	private void setIdLineaFactura(int idLineaFactura) {
		this.idLineaFactura = idLineaFactura;
	}
	public Concepto getConcepto() {
		return concepto;
	}
	public void setConcepto(Concepto concepto) {
		this.concepto = concepto;
	}
	public float getImporteLinea() {
		return importeLinea;
	}
	public void setImporteLinea(float importeLinea) {
		this.importeLinea = importeLinea;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
}
