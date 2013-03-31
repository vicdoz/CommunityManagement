package negocio._tablas;
import negocio.*;

import java.util.*;

import excepciones.*;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class ModeloTablaFacturaDetalle extends DefaultTableModel {
		
		public  int numLineas;
		public ModeloTablaFacturaDetalle (){//example:new String[][]{{"1","Patio A","1","A"},{"2","Patio B","B","2"}} 
			super(null,
					new String[] {"Línea","Código Concepto", "Importe"});		
			numLineas=0;
			/*ArrayList<Comunidad> listaComunidades = ControladorComunidad.getControladorComunidad().GetListaComunidades();
			System.out.println("Tamaño lista"+listaComunidades.size());
			for(Comunidad c:listaComunidades){						
				this.addToTabla(c);
			}*/
		}
		@Override
	    public boolean isCellEditable(int row, int column) { //De esta forma no se pueden editar las celdas.
		       //all cells false
		       return false;
		    }
		public void addFactura (Factura f) throws InmuebleYaExiste{									
			this.addToTabla(f);
		}
		public int getNumFacturas(){
			return numLineas;
		}
		public void borraFacturaPorPos(int row){
			/*
			try {
				int id = Integer.parseInt(this.getValueAt(row, 0).toString());
				System.out.println("Fila: "+row+" ID:"+id);
				ControladorComunidad.getControladorComunidad().borrarComunidad(getComunidadPorId(id));
			} catch (DAOExcepcion e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			this.removeRow(row);
		}
		public Factura getFacturaPorId(int id) {
			Factura f=new Factura();
			//c = ControladorComunidad.getControladorComunidad().getComunidadPorId(id);
			//System.out.println("Inmueble con id: "+c.getIdComunidad()+" recuperado con exito");
			return f ;
	
		}
		public Factura getFacturaPorPos(int row) {
			Factura f=new Factura();
			//c = ControladorComunidad.getControladorComunidad().getComunidadPorPos(row);
			//System.out.println("Inmueble con id: "+c.getIdComunidad()+" recuperado con exito");
			return f ;
	
		}
		
		public void updateRow(int row,Factura f){			
			this.setValueAt(row, row, 0);			
			this.setValueAt("Cod. Concepto", row, 1);			
			this.setValueAt("Importe", row, 2);							
		}
		@SuppressWarnings("unchecked")
		public void addToTabla(Factura f){
			Vector v=new Vector();
			//"ID","CIF", "Num Factura", "Fecha", "Importe","%IVA", "Total"
			v.add(f.getidFactura());			v.add("CIF");			v.add("Num. Factura");
			v.add(f.getFechaFactura());			v.add("Importe");		v.add("%IVA");	v.add("Total");				
			
			System.out.println("Factura:"+f.getidFactura());
			numLineas++;
			System.out.println("Fila nueva: "+v);
			this.addRow(v);			
		}

}

