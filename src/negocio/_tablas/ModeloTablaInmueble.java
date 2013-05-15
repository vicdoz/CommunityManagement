package negocio._tablas;
import negocio.*;

import java.util.*;

import excepciones.*;

import javax.swing.table.DefaultTableModel;

import accesoAdatos._controladores.ControladorComunidad;
import accesoAdatos._controladores.ControladorInmueble;
import accesoAdatos._controladores.ControladorPropietario;


@SuppressWarnings("serial")
public class ModeloTablaInmueble extends DefaultTableModel {

		public  int numInmuebles;
		public Comunidad comunidad;
		public ModeloTablaInmueble (){
			super(null,
					new String[] {"ID","Comunidad", "Escalera", "Piso", " Puerta","Participacion", "Propietario"});			
			numInmuebles=0;
		}
		@Override
	    public boolean isCellEditable(int row, int column) {
		       //all cells false
		       return false;
		    }
		public void addInmueble (Inmueble i) throws InmuebleYaExiste{	
			
			try {
				Propietario p =i.getPropietario();
				p.addInmuebleToList(i);
				ControladorPropietario.getControladorPropietario().actualizarPropietario(p);
				comunidad.addInmuebleToList(i);  
				ControladorComunidad.getControladorComunidad().actualizarComunidad(comunidad);

				this.addToTabla(i);	
			} catch (DAOExcepcion e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
		}
		public int getNumInmuebles(){
			return numInmuebles;
		}
		
		public void borraInmueblePorPos(int row){			
			try {
				Inmueble i = getInmueblePorPos(row);
				//OJO!.
				//i.getPropietario().delInmuebleFromList(i);
				//i.getComunidad().delInmuebleFromList(i);				
				ControladorInmueble.getControladorInmueble().borrarInmueble(i);
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
			
			if(!i.getComunidad().getListaInmuebles().contains(i))
				i.getComunidad().addInmuebleToList(i);  		
			if(!i.getPropietario().getListaInmuebles().contains(i))
				i.getPropietario().addInmuebleToList(i);
			
			this.setValueAt(i.getComunidad().getIdComunidad(),row,1);
			this.setValueAt(i.getEscalera(),row,2);
			this.setValueAt(i.getPiso(),row,3);
			this.setValueAt(i.getPuerta(),row,4);
			this.setValueAt(i.getPorcentaje(),row,5);
			this.setValueAt(i.getPropietario().getIdPropietario(),row,6);
		}
		@SuppressWarnings("unchecked")
		public void addToTabla(Inmueble i){
			Vector v=new Vector();
			//"ID","Comunidad", "Escalera", "Piso", " Puerta","%Participacion", "Propietario"
			v.add(i.getIdInmueble());	v.add(i.getComunidad().getIdComunidad());	
			v.add(i.getEscalera());		v.add(i.getPiso());			v.add(i.getPuerta());
			v.add(i.getPorcentaje());	v.add(i.getPropietario().getIdPropietario());
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

