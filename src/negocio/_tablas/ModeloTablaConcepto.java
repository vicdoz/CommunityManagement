
package negocio._tablas;
import negocio.*;

import java.util.*;

import excepciones.*;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class ModeloTablaConcepto extends DefaultTableModel {
		
		public  int numConceptos;
		public ModeloTablaConcepto (){//example:new String[][]{{"1","Patio A","1","A"},{"2","Patio B","B","2"}} 
			super(null,
					new String[] {"ID","Codigo", "Descripcion"});		
			numConceptos=0;
		
			/*
			ArrayList<Concepto> listaConceptos = ControladorConcepto.getControladorConcepto().GetListaConceptos();
			
			for(Comunidad c:listaComunidades){						
				this.addToTabla(c);
			}
			*/
		}
		@Override
	    public boolean isCellEditable(int row, int column) { //De esta forma no se pueden editar las celdas.
		       //all cells false
		       return false;
		    }
		public void addConcepto (Concepto c) throws InmuebleYaExiste{									
			this.addToTabla(c);
		}
		public int getNumConceptos(){
			return numConceptos;
		}
		public void borraConceptoPorPos(int row){
			/*
			try {
				int id = Integer.parseInt(this.getValueAt(row, 0).toString());
				System.out.println("Fila: "+row+" ID:"+id);
				ControladorConceptos.getControladorConceptos().borrarConceptos(getConceptosPorId(id));
			} catch (DAOExcepcion e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.removeRow(row);
			*/
		}
		public Concepto getConceptoPorId(int id) {
			Concepto c=new Concepto();
			//c = ControladorConcepto.getControladorConcepto().getConceptoPorId(id);			
			return c ;
	
		}
		public Concepto getConceptoPorPos(int row) {
			Concepto c=new Concepto();
			//c = ControladorConcepto.getControladorConcepto().getConceptoPorPos(row);
			System.out.println("Inmueble con id: "+c.getIdConcepto()+" recuperado con exito");
			return c ;
	
		}
		
		public void updateRow(int row,Concepto c){			
			this.setValueAt(c.getidConcepto(), row, 1);			
			this.setValueAt(c.getDescripcion(), row, 2);						
			
		}
		@SuppressWarnings("unchecked")
		public void addToTabla(Concepto c){
			Vector v=new Vector();
			v.add(c.getidConcepto());			v.add(c.getDescripcion());			
						
			System.out.println("Concepto:"+c.getidConcepto());
			numConceptos++;
			System.out.println("Fila nueva: "+v);
			this.addRow(v);			
		}

}

