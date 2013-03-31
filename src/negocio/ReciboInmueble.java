package negocio;

import java.sql.Date;

public class ReciboInmueble {
	private int idRecibo; 
	private Date FechaPago;
	private float Importe;
    private NotaInformativa notaInformativa;
    public ReciboInmueble(){}
	public ReciboInmueble(int idRecibo, Date fechaPago, float importe) {
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
	public Date getFechaPago() {
		return FechaPago;
	}
	
	public NotaInformativa getNotaInformativa() {
		return notaInformativa;
	}
	public void setNotaInformativa(NotaInformativa notaInformativa) {
		this.notaInformativa = notaInformativa;
	}
	public void setFechaPago(Date fechaPago) {
		FechaPago = fechaPago;
	}
	public float getImporte() {
		return Importe;
	}
	public void setImporte(float importe) {
		Importe = importe;
	}
}
