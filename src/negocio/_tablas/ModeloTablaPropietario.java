
package negocio._tablas;
import negocio.*;

import java.util.*;

import excepciones.*;

import javax.swing.table.DefaultTableModel;
import accesoAdatos._controladores.ControladorPropietario;

@SuppressWarnings("serial")
public class ModeloTablaPropietario extends DefaultTableModel {
		
		public  int numPropietarios;
		public ModeloTablaPropietario (){//example:new String[][]{{"1","Patio A","1","A"},{"2","Patio B","B","2"}} 
			super(null,
					new String[] {"ID","NIF","Nombre","E-Mail", "Direcc.","Poblacion","Telf.","Entidad","D. Banc.","Observaciones"});		
			numPropietarios=0;
			ArrayList<Propietario> listaPropietarios = ControladorPropietario.getControladorPropietario().GetListaPropietarios();
			System.out.println("Tamaño lista Propietarios: "+listaPropietarios.size());
			for(Propietario p:listaPropietarios){						
				this.addToTabla(p);
			}
		}
		public void limpiaTabla() {
			// TODO Auto-generated method stub			
			while(numPropietarios>0){
				this.removeRow(numPropietarios-1);
				numPropietarios--;				
			}		
			
		}
		@Override
	    public boolean isCellEditable(int row, int column) { 
		       return false;
	    }
		public void addPropietario (Propietario p) throws InmuebleYaExiste{									
			this.addToTabla(p);
		}
		public int getNumPropietarios(){
			return numPropietarios;
		}
		public void borraPropietarioPorPosicion(int row){
			try {
				ControladorPropietario.getControladorPropietario().borrarPropietario(getPropietarioPorPosicion(row));
				deleteFromTabla(row);
			} catch (DAOExcepcion e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		public void deleteFromTabla(int row){ //Borra la factura solo de la TABLA no de la BD		
			int id = Integer.parseInt(this.getValueAt(row, 0).toString());
			System.out.println("Fila: "+row+" ID:"+id);	
			numPropietarios--;
			this.removeRow(row);
		}
		public Propietario getPropietarioPorPosicion(int row){
			Propietario p=new Propietario();
			p = ControladorPropietario.getControladorPropietario().getPropietarioPorPos(row);				
			System.out.println("Inmueble con id: "+p.getIdPropietario()+" recuperado con exito");
			return p ;
		}
		public Propietario getPropietarioPorNIF(String nif){
			Propietario p=new Propietario();
			p = ControladorPropietario.getControladorPropietario().getPropietarioPorNIF(nif);
			return p ;
		}
		
		public void updateRow(int row, Propietario p){
			this.setValueAt(p.getNif(), row, 1);			this.setValueAt(p.getNombre(), row, 2);
			this.setValueAt(p.getEmail(), row, 3);		this.setValueAt(p.getDireccion(), row, 4);		
			this.setValueAt(p.getPoblacion(), row, 5);		this.setValueAt(p.getTelefono(), row, 6);		
			this.setValueAt(p.getEntidad(), row, 7);		this.setValueAt(p.getNumerocuenta(), row, 8);	
			this.setValueAt(p.getObservaciones(), row, 9);							
		}
		@SuppressWarnings("unchecked")
		public void addToTabla(Propietario p){
			Vector v=new Vector();
			v.add(p.getIdPropietario());
			v.add(p.getNif());			v.add(p.getNombre()); 		v.add(p.getEmail());	
			v.add(p.getDireccion());	v.add(p.getPoblacion());	v.add(p.getTelefono());			
			v.add(p.getEntidad());		v.add(p.getNumerocuenta());	v.add(p.getObservaciones());
			
			numPropietarios++;
			System.out.println("Fila nueva: "+v);
			this.addRow(v);
			
		}
}

