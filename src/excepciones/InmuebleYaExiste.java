package excepciones;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class InmuebleYaExiste extends Exception {
	public InmuebleYaExiste(){
	}	
	public String GetMessage(){
		return("Este inmueble ya existe");
	}
	public void MuestraPantalla(){
		JOptionPane.showMessageDialog(null, "El ID ya existe. \n Pruebe con otro.");
	}
}
