package negocio;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class NotaInformativa {
	private int idNotaInformativa ;
	private String fechaCalculo;
	private float importeNota ;
	private int idRecibo ;
	private Set<Factura> listaFacturas = new HashSet<Factura>();
	private Set<ReciboInmueble> listarecibos=new HashSet<ReciboInmueble>();	
	private Comunidad comunidad;
    public Comunidad getComunidad() {
		return comunidad;
	}
	public void setComunidad(Comunidad comunidad) {
		this.comunidad = comunidad;
	}
	public NotaInformativa(){}
	public NotaInformativa(int idNotaInformativa, String fechaCalculo,
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
	public void addReciboToList(ReciboInmueble r){
		listarecibos.add(r);
	}
	public void delReciboToList(ReciboInmueble r){
		listarecibos.remove(r);
	}
	public void addFacturaToList(Factura f){
		listaFacturas.add(f);
	}
	public void delFacturaToList(Factura f){
		listaFacturas.remove(f);
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
	public String getFechaCalculo() {
		return fechaCalculo;
	}
	public void setFechaCalculo(String fecha) {
		this.fechaCalculo = fecha;
	}
	public float getImporteNota() {
		return importeNota;
	}
	public void setImporteNota(float importeNota) {
		if(importeNota==0.0)
			importeNota=Float.parseFloat("0.0");
		this.importeNota = importeNota;
	}
	public int getIdRecibo() {
		return idRecibo;
	}
	public void setIdRecibo(int idRecibo) {
		this.idRecibo = idRecibo;
	}
}
