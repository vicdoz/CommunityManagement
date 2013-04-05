
package negocio._tablas;

import negocio.*;
import accesoAdatos._controladores.ControladorConcepto;
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
		
			ArrayList<Concepto> listaConceptos = ControladorConcepto.getControladorConcepto().GetListaConceptos();
			
			for(Concepto c:listaConceptos){						
				this.addToTabla(c);
			}
			
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
			try {
				int id = Integer.parseInt(this.getValueAt(row, 0).toString());				
				ControladorConcepto.getControladorConcepto().borrarConcepto(getConceptoPorId(id));
				deleteFromTabla(row);
			} catch (DAOExcepcion e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}						
		}
		public void deleteFromTabla(int row){ //Borra la factura solo de la TABLA no de la BD		
			int id = Integer.parseInt(this.getValueAt(row, 0).toString());
			System.out.println("Fila: "+row+" ID:"+id);	
			numConceptos--;
			this.removeRow(row);
		}
		public Concepto getConceptoPorId(int id) {
			Concepto c=new Concepto();
			c = ControladorConcepto.getControladorConcepto().getConceptoPorId(id);			
			return c ;
	
		}
		public Concepto getConceptoPorPos(int row) {
			Concepto c=new Concepto();
			c = ControladorConcepto.getControladorConcepto().getConceptoPorPos(row);
			System.out.println("Inmueble con id: "+c.getIdConcepto()+" recuperado con exito");
			return c ;
	
		}
		
		public void updateRow(int row,Concepto c){			
			this.setValueAt(c.getIdConcepto(), row, 0);
			this.setValueAt(c.getCodigo(),row,1);
			this.setValueAt(c.getDescipcion(), row, 2);						
			
		}
		@SuppressWarnings("unchecked")
		public void addToTabla(Concepto c){
			Vector v=new Vector();
			v.add(c.getIdConcepto());
			v.add(c.getCodigo());			v.add(c.getDescipcion());			
						
			System.out.println("Concepto:"+c.getIdConcepto());
			numConceptos++;
			System.out.println("Fila nueva: "+v);
			this.addRow(v);			
		}

}

