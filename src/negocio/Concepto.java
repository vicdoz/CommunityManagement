package negocio;

import java.util.Set;

public class Concepto {

	private int idConcepto;
	private String codigo;
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}
	private String descripcion;
	
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


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDescipcion() {
	  return descripcion ;
	}


}
