package negocio._tablas;
import negocio.*;

import java.util.*;

import excepciones.*;

import javax.swing.table.DefaultTableModel;

import accesoAdatos._controladores.ControladorInmueble;


@SuppressWarnings("serial")
public class ModeloTablaInmueble extends DefaultTableModel {

		public  int numInmuebles;
		public Comunidad comunidad;
		public ModeloTablaInmueble (){
			super(null,
					new String[] {"ID","Comunidad", "Escalera", "Piso", " Puerta", "Propietario"});			
			numInmuebles=0;
			/*ArrayList<Inmueble> listaInmuebles = ControladorInmueble.getControladorInmueble().GetListaInmuebles();
			System.out.println("Tamaño lista Inmuebles: "+listaInmuebles.size());
			for(Inmueble i:listaInmuebles){						
				this.addToTabla(i);
			}*/
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
				deleteFromTabla(row);
			} catch (DAOExcepcion e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		public void deleteFromTabla(int row){ //Borra la factura solo de la TABLA no de la BD		
			int id = Integer.parseInt(this.getValueAt(row, 0).toString());
			System.out.println("Fila: "+row+" ID:"+id);	
			numInmuebles--;
			this.removeRow(row);
		}
		
		public Inmueble getInmueblePorPos(int row) {
			Inmueble i = new Inmueble();
			int id = Integer.parseInt(this.getValueAt(row, 0).toString());
			i = ControladorInmueble.getControladorInmueble().getInmueblePorId(id);
			return i ;
	
		}
		public void cargaInmueblesComunidad(Comunidad c){
			limpiaTabla();
			ArrayList<Inmueble> listaInmuebles = ControladorInmueble.getControladorInmueble().GetListaInmuebles();
			this.comunidad = c;
			System.out.println("Tamaño lista Inmuebles: "+listaInmuebles.size());
			for(Inmueble i:listaInmuebles){						
				if(i.getComunidad().getIdComunidad()==c.getIdComunidad()){
					this.addToTabla(i);
				}
			}
		}
		public void cargaInmueblesTodos(){
			limpiaTabla();
			ArrayList<Inmueble> listaInmuebles = ControladorInmueble.getControladorInmueble().GetListaInmuebles();
			System.out.println("Tamaño lista Inmuebles: "+listaInmuebles.size());
			for(Inmueble i:listaInmuebles){						
				this.addToTabla(i);
			}
		}
		public void limpiaTabla() {
			// TODO Auto-generated method stub			
			while(numInmuebles>0){
				this.removeRow(numInmuebles-1);
				numInmuebles--;				
			}			
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
		public void cargaInmueblesPropietario(Propietario pAux) {
			// TODO Auto-generated method stub
			limpiaTabla();
			ArrayList<Inmueble> listaInmuebles = ControladorInmueble.getControladorInmueble().GetListaInmuebles();
			System.out.println("Tamaño lista Inmuebles: "+listaInmuebles.size());
			for(Inmueble i:listaInmuebles){						
				if(i.getPropietario().getIdPropietario()==pAux.getIdPropietario()){
					this.addToTabla(i);
				}
			}
			
		}
}

