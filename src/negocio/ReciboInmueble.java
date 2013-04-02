package negocio;

import java.sql.Date;

public class ReciboInmueble {
	private int idRecibo; 
	private String FechaPago;
	private float Importe;
	private Carta carta;
	private NotaInformativa notaInformativa;
	private Inmueble inmueble;
    public ReciboInmueble(){}
	public ReciboInmueble(int idRecibo, String fechaPago, float importe) {
		super();
		this.idRecibo = idRecibo;
		FechaPago = fechaPago;
		Importe = importe;
	}
	public int getIdRecibo() {
		return idRecibo;
	}
	private void setIdRecibo(int idRecibo) {
		this.idRecibo = idRecibo;
	}
	public String getFechaPago() {
		return FechaPago;
	}
	
	public NotaInformativa getNotaInformativa() {
		return notaInformativa;
	}
	public void setNotaInformativa(NotaInformativa notaInformativa) {
		this.notaInformativa = notaInformativa;
	}
	public void setFechaPago(String fechaPago) {
		FechaPago = fechaPago;
	}
	public float getImporte() {
		return Importe;
	}
	public void setImporte(float importe) {
		Importe = importe;
	}
    public Carta getCarta() {
		return carta;
	}
	public void setCarta(Carta carta) {
		this.carta = carta;
	}
	public Inmueble getInmueble() {
		return inmueble;
	}
	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}
	
}
