package negocio._tablas;
import negocio.*;

import java.util.*;

import excepciones.*;
import javax.swing.table.DefaultTableModel;

import accesoAdatos._controladores.ControladorConcepto;
import accesoAdatos._controladores.ControladorLineaFactura;

@SuppressWarnings("serial")
public class ModeloTablaFacturaDetalle extends DefaultTableModel {
		
		public  int numLineas;
		public Factura factura;
		public ModeloTablaFacturaDetalle (){//example:new String[][]{{"1","Patio A","1","A"},{"2","Patio B","B","2"}} 
			super(null,
					new String[] {"L�nea","C�digo Concepto", "Importe"});		
			numLineas=0;
		}
		@Override
	    public boolean isCellEditable(int row, int column) { //De esta forma no se pueden editar las celdas.
		       //all cells false
		       return false;
		    }
		public void addFactura (LineaFactura lF) throws InmuebleYaExiste{	
			//lF.getFactura().addLineaToList(lF);
			this.addToTabla(lF);
		}
		public int getNumFacturas(){
			return numLineas;
		}
		public void borraFacturaPorPos(int row){
			try {
				int id = Integer.parseInt(this.getValueAt(row, 0).toString());	
				LineaFactura lfAux = getLineaFacturaPorId(id);
				lfAux.getFactura().delLineaFromList(lfAux);
				ControladorLineaFactura.getControladorLineaFactura().borrarLineaFactura(lfAux);
				deleteFromTabla(row);
			} catch (DAOExcepcion e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void deleteFromTabla(int row){ //Borra la factura solo de la TABLA no de la BD		
			int id = Integer.parseInt(this.getValueAt(row, 0).toString());
			System.out.println("Fila: "+row+" ID:"+id);	
			numLineas--;
			this.removeRow(row);
		}
		public LineaFactura getLineaFacturaPorId(int id) {
			LineaFactura lF=new LineaFactura();
			lF = ControladorLineaFactura.getControladorLineaFactura().getLineaFacturaPorId(id);																		
			//System.out.println("Inmueble con id: "+c.getIdComunidad()+" recuperado con exito");
			return lF ;	
		}
		public LineaFactura getLineaFacturaPorPos(int row) {			
			int id = Integer.parseInt(this.getValueAt(row, 0).toString());			
			//c = ControladorComunidad.getControladorComunidad().getComunidadPorPos(row);
			//System.out.println("Inmueble con id: "+c.getIdComunidad()+" recuperado con exito");
			return getLineaFacturaPorId(id) ;
	
		}
		
		public void updateRow(int row,LineaFactura lF){			
			this.setValueAt(lF.getIdLineaFactura(), row, 0);			
			this.setValueAt(lF.getConcepto().getCodigo(), row, 1);			
			this.setValueAt(lF.getImporteLinea(), row, 2);							
		}
		@SuppressWarnings("unchecked")
		public void addToTabla(LineaFactura lF){
			Vector v=new Vector();		
			//"L�nea","C�digo Concepto", "Importe"
			v.add(lF.getIdLineaFactura());
			Concepto conc = ControladorConcepto.getControladorConcepto().getConceptoPorId(lF.getConcepto().getIdConcepto());
			v.add(conc.getCodigo());
			v.add(lF.getImporteLinea());
			System.out.println("Factura:"+lF.getIdLineaFactura());
			numLineas++;
			System.out.println("Fila nueva: "+v);
			this.addRow(v);			
		}
		public void limpiaTabla() {
			// TODO Auto-generated method stub			
			while(numLineas>0){
				this.removeRow(numLineas-1);
				numLineas--;				
			}
			
		}
		public void cargaLineasFactura(Factura f) {
			// TODO Auto-generated method stub
			limpiaTabla();
			this.factura = f;
			ArrayList<LineaFactura> listaLineas = ControladorLineaFactura.getControladorLineaFactura().GetListaLineaFactura();
			System.out.println("Tama�o lista"+listaLineas.size());
			for(LineaFactura lF:listaLineas){
				System.out.println(lF.getFactura().getidFactura());
				System.out.println(factura.getidFactura());
				if(lF.getFactura().getidFactura()==factura.getidFactura())	this.addToTabla(lF);
			}
			
		}

}

