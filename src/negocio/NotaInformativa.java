package negocio;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class NotaInformativa {
	private int idNotaInformativa ;
	private Date fechaCalculo;
	private float importeNota ;
	private int idRecibo ;
	private Set listaFacturas = new HashSet();
	private Set listarecibos=new HashSet();	
	private Comunidad comunidad;
    public Comunidad getComunidad() {
		return comunidad;
	}
	public void setComunidad(Comunidad comunidad) {
		this.comunidad = comunidad;
	}
	public NotaInformativa(){}
	public NotaInformativa(int idNotaInformativa, Date fechaCalculo,
			float importeNota, int idRecibo) {
		super();
		this.idNotaInformativa = idNotaInformativa;
		this.fechaCalculo = fechaCalculo;
		this.importeNota = importeNota;
		this.idRecibo = idRecibo;
	}
	public int getIdNotaInformativa() {
		return idNotaInformativa;
	}
	
	public Set getListaFacturas() {
		return listaFacturas;
	}
	public void setListaFacturas(Set listaFacturas) {
		this.listaFacturas = listaFacturas;
	}
	public Set getListarecibos() {
		return listarecibos;
	}
	public void setListarecibos(Set listarecibos) {
		this.listarecibos = listarecibos;
	}
	private void setIdNotaInformativa(int idNotaInformativa) {
		this.idNotaInformativa = idNotaInformativa;
	}
	public Date getFechaCalculo() {
		return fechaCalculo;
	}
	public void setFechaCalculo(Date fechaCalculo) {
		this.fechaCalculo = fechaCalculo;
	}
	public float getImporteNota() {
		return importeNota;
	}
	public void setImporteNota(float importeNota) {
		this.importeNota = importeNota;
	}
	public int getIdRecibo() {
		return idRecibo;
	}
	public void setIdRecibo(int idRecibo) {
		this.idRecibo = idRecibo;
	}
}
