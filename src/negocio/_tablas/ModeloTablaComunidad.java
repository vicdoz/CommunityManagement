
package negocio._tablas;
import negocio.*;

import java.util.*;
import excepciones.*;
import javax.swing.table.DefaultTableModel;


import accesoAdatos._controladores.ControladorComunidad;

@SuppressWarnings("serial")
public class ModeloTablaComunidad extends DefaultTableModel {
		
		public  int numComunidades;
		public ModeloTablaComunidad (){//example:new String[][]{{"1","Patio A","1","A"},{"2","Patio B","B","2"}} 
			super(null,
					new String[] {"ID","Nombre", "Contacto", "Direccion", "Poblacion","Recibos Pend.", "Estado"});		
			numComunidades=0;
			ArrayList<Comunidad> listaComunidades = ControladorComunidad.getControladorComunidad().GetListaComunidades();
			System.out.println("Tamaño lista"+listaComunidades.size());
			for(Comunidad c:listaComunidades){						
				this.addToTabla(c);
			}
		}
		@Override
	    public boolean isCellEditable(int row, int column) { //De esta forma no se pueden editar las celdas.
		       //all cells false
		       return false;
		    }
		public void addComunidad (Comunidad c) throws InmuebleYaExiste{									
			this.addToTabla(c);
		}
		public int getNumComunidades(){
			return numComunidades;
		}
		public void borraComunidadPorPosicion(int row){
			//Integer id=(Integer)getValueAt(row, 0);
			try {
				int id = Integer.parseInt(this.getValueAt(row, 0).toString());				
				ControladorComunidad.getControladorComunidad().borrarComunidad(getComunidadPorId(id));
				deleteFromTabla(row);
			} catch (DAOExcepcion e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		public void deleteFromTabla(int row){ //Borra la factura solo de la TABLA no de la BD		
			int id = Integer.parseInt(this.getValueAt(row, 0).toString());
			System.out.println("Fila: "+row+" ID:"+id);	
			numComunidades--;
			this.removeRow(row);
		}
		
		public Comunidad getComunidadPorId(int id) {
			Comunidad c=new Comunidad();
			c = ControladorComunidad.getControladorComunidad().getComunidadPorId(id);
			System.out.println("Inmueble con id: "+c.getIdComunidad()+" recuperado con exito");
			return c ;
	
		}
		public Comunidad getComunidadPorPos(int row) {
			Comunidad c=new Comunidad();
			c = ControladorComunidad.getControladorComunidad().getComunidadPorPos(row);
			System.out.println("Inmueble con id: "+c.getIdComunidad()+" recuperado con exito");
			return c ;
	
		}
		
		public void updateRow(int row,Comunidad c){			
			this.setValueAt(c.getNombre(), row, 1);			
			this.setValueAt(c.getIdPresidente(), row, 2);			
			this.setValueAt(c.getCalle(), row, 3);			
			this.setValueAt(c.getPoblacion(), row, 4);			
			this.setValueAt("RECIBOS PENDIENTES", row, 5);			
			this.setValueAt(c.getEstadoToString(), row, 6);
			
		}	
		@SuppressWarnings("unchecked")
		public void addToTabla(Comunidad c){
			Vector v=new Vector();
			//"ID","Nombre", "Contacto", "Direccion", "Poblacion","Recibos Pend.", "Estado"});
			v.add(c.getIdComunidad());			v.add(c.getNombre());	v.add(c.getIdPresidente());
			v.add(c.getCalle());    v.add(c.getPoblacion());
			v.add("RECIBOS PENDIENTES");			v.add(c.getEstadoToString());			
			
			System.out.println("Comunidad:"+c.getIdComunidad());
			numComunidades++;
			System.out.println("Fila nueva: "+v);
			this.addRow(v);
			/*
			System.out.println("Filas: "+VentanaComunidad.modeloCom.getRowCount());
			VentanaComunidad.modeloCom.fireTableRowsUpdated(0, VentanaComunidad.modeloCom.getRowCount());*/
		}

}

