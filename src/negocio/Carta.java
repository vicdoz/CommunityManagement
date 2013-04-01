package negocio;

public class Carta {
	
	
	private int idCarta;
	private String fecha;
	private String cuerpo;
	
	public Carta(int idCarta, String fecha, String cuerpo) {
		super();
		this.idCarta = idCarta;
		this.fecha = fecha;
		this.cuerpo = cuerpo;
	}
	public Carta() {
		super();
	
	}
	public int getIdCarta() {
		return idCarta;
	}
	public void setIdCarta(int idCarta) {
		this.idCarta = idCarta;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getCuerpo() {
		return cuerpo;
	}
	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}
}
