package accesoAdatos._interfaces;

import negocio.Propietario;

public interface IControladorPropietario {
		public void GetPropietario();
		public Propietario GetActual(int i);
		public int GetNumPropietarios();
		public void borrarPropietario(Propietario d);
		public void BorrarPropietario(int id);
		public void ActualizarPropietario(Propietario d);
		public void NuevoPropietario(Propietario d);
	
}
