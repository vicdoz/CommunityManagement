package negocio._tablas;
import negocio.*;

import java.util.*;

import excepciones.*;

import javax.swing.table.DefaultTableModel;

import accesoAdatos._controladores.ControladorInmueble;


@SuppressWarnings("serial")
public class ModeloTablaInmueble extends DefaultTableModel {

		public  int numInmuebles;
		public ModeloTablaInmueble (){
			super(null,
					new String[] {"ID","Comunidad", "Escalera", "Piso", " Puerta", "Propietario"});			
			numInmuebles=0;
			ArrayList<Inmueble> listaInmuebles = ControladorInmueble.getControladorInmueble().GetListaInmuebles();
			System.out.println("Tama�o lista Inmuebles: "+listaInmuebles.size());
			for(Inmueble i:listaInmuebles){						
				this.addToTabla(i);
			}
		}
		@Override
	    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		public void addInmueble (Inmueble i) throws InmuebleYaExiste{									
			this.addToTabla(i);
		}
		public int getNumInmuebles(){
			return numInmuebles;
		}
		
		public void borraInmueblePorPos(int row){			
			try {
				ControladorInmueble.getControladorInmueble().borrarInmueble(getInmueblePorPos(row));
			} catch (DAOExcepcion e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
			this.removeRow(row);
		}		
		public Inmueble getInmueblePorPos(int row) {
			Inmueble i = new Inmueble();
			i = ControladorInmueble.getControladorInmueble().getInmueblePorPos(row);
			return i ;
	
		}
		
		public void updateRow(int row, Inmueble i){
			this.setValueAt(i.getComunidad().getIdComunidad(),row,1);
			this.setValueAt(i.getEscalera(),row,2);
			this.setValueAt(i.getPiso(),row,3);
			this.setValueAt(i.getPuerta(),row,4);
			this.setValueAt(i.getPropietario().getIdPropietario(),row,5);
		}
		@SuppressWarnings("unchecked")
		public void addToTabla(Inmueble i){
			Vector v=new Vector();
			v.add(i.getIdInmueble());	v.add(i.getComunidad().getIdComunidad());	
			v.add(i.getEscalera());		v.add(i.getPiso());			v.add(i.getPuerta());
			v.add(i.getPropietario().getIdPropietario());
			numInmuebles++;			
			this.addRow(v); 			
		}
}
