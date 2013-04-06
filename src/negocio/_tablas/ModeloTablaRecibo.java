package negocio._tablas;

import negocio.*;
import accesoAdatos._controladores.ControladorReciboInmueble;
import excepciones.*;

import java.util.*;

import javax.swing.table.DefaultTableModel;


@SuppressWarnings("serial")
public class ModeloTablaRecibo extends DefaultTableModel {
		
		public  int numRecibos;
		public ModeloTablaRecibo (){//example:new String[][]{{"1","Patio A","1","A"},{"2","Patio B","B","2"}} 
			super(null,
					new String[] {"ID","Id Nota", "Fecha", "Total a Pagar"});		
			numRecibos=0;
			/*ArrayList<Factura> listaFacturas = ControladorFactura.getControladorFactura().GetListaFacturas();
			System.out.println("Tamaño lista"+listaFacturas.size());
			for(Factura f:listaFacturas){						
				this.addToTabla(f);
			}*/
		}
		@Override
	    public boolean isCellEditable(int row, int column) { //De esta forma no se pueden editar las celdas.
		       //all cells false
		       return false;
		    }
		public void addRecibo (ReciboInmueble r) throws InmuebleYaExiste{									
			this.addToTabla(r);
		}
		public int getNumRecibos(){
			return numRecibos;
		}
		public void borraReciboPorPos(int row){
			try {
				int id = Integer.parseInt(this.getValueAt(row, 0).toString());								
				ControladorReciboInmueble.getControladorReciboInmueble().borrarReciboInmueble(getReciboPorId(id));
				deleteFromTabla(row);
			} catch (DAOExcepcion e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void deleteFromTabla(int row){ 		
			int id = Integer.parseInt(this.getValueAt(row, 0).toString());
			System.out.println("Fila: "+row+" ID:"+id);	
			numRecibos--;
			this.removeRow(row);
		}

		public ReciboInmueble getReciboPorId(int id) {
			ReciboInmueble r = new ReciboInmueble();
			r = ControladorReciboInmueble.getControladorReciboInmueble().getReciboInmueblePorId(id);
			System.out.println("Recibo con id: "+r.getIdRecibo()+" recuperada con exito");
			return r ;	
		}
		public ReciboInmueble getReciboPorPos(int row) {
			//Factura f=new Factura();
			int id = Integer.parseInt(this.getValueAt(row, 0).toString());
			//f = ControladorFactura.getControladorFactura().getFacturaPorPos(row);
			//System.out.println("Factura con id: "+f.getidFactura()+" recuperada con exito");
			return getReciboPorId(id) ;
		}
		
		public void updateRow(int row,ReciboInmueble r){							
			this.setValueAt(r.getFechaPago(), row, 2);							
		}
		
		@SuppressWarnings("unchecked")
		public void addToTabla(ReciboInmueble r){
			Vector v=new Vector();			
			//"ID","Id Nota", "Fecha", "Total a Pagar"
			v.add(r.getIdRecibo());		v.add(r.getNotaInformativa().getIdNotaInformativa());
			v.add(r.getFechaPago());	v.add(r.getImporte());
			System.out.println("Recibo:"+r.getIdRecibo());
			numRecibos++;
			System.out.println("Fila nueva: "+v);
			this.addRow(v);			
		}
			
		public void cargaRecibosInmueble(Inmueble i){
			limpiaTabla();
			ArrayList<ReciboInmueble> listaRecibos = ControladorReciboInmueble.getControladorReciboInmueble().GetListaReciboInmuebles();
			System.out.println("Tamaño lista"+listaRecibos.size());
			for(ReciboInmueble r:listaRecibos){						
				if(r.getInmueble().getIdInmueble()==i.getIdInmueble()) this.addToTabla(r);
			}
		}
		public void cargaRecibosPropietario(Propietario p){
			limpiaTabla();
			ArrayList<ReciboInmueble> listaRecibos = ControladorReciboInmueble.getControladorReciboInmueble().GetListaReciboInmuebles();
			System.out.println("Tamaño lista"+listaRecibos.size());
			for(ReciboInmueble r:listaRecibos){						
				if(r.getInmueble().getPropietario().equals(p)){
					this.addToTabla(r);
				}
			}
		}
		private void limpiaTabla() {
			// TODO Auto-generated method stub			
			while(numRecibos>0){
				this.removeRow(numRecibos-1);
				numRecibos--;				
			}		
		}			
}

