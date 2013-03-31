package excepciones;

@SuppressWarnings("serial")
public class InmuebleNoExiste extends Exception {
	public InmuebleNoExiste(){
		
	}
	public String GetMessage(){
		return("Este inmueble No existe");
	}
}
