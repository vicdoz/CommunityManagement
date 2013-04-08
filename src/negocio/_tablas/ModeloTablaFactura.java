package negocio._tablas;

import negocio.*;
import accesoAdatos._controladores.ControladorFactura;
import excepciones.*;

import java.util.*;

import javax.swing.table.DefaultTableModel;


@SuppressWarnings("serial")
public class ModeloTablaFactura extends DefaultTableModel {
		
		public  int numFacturas;
		public ModeloTablaFactura (){//example:new String[][]{{"1","Patio A","1","A"},{"2","Patio B","B","2"}} 
			super(null,
					new String[] {"ID","CIF","Fecha", "Importe","%IVA", "Total"});		
			numFacturas=0;
		}
		@Override
	    public boolean isCellEditable(int row, int column) { //De esta forma no se pueden editar las celdas.
		       //all cells false
		       return false;
		    }
		public void addFactura (Factura f) throws InmuebleYaExiste{
			//System.out.println("Comunidad factura"+f.getComunidad().getIdComunidad());
			//f.getComunidad().addFacturaToList(f);			
			//this.addToTabla(f);
		}
		public int getNumFacturas(){
			return numFacturas;
		}
		public void borraFacturaPorPos(int row){
			try {
				int id = Integer.parseInt(this.getValueAt(row, 0).toString());	
				Factura f = getFacturaPorId(id);
				//Borrem relacions
				f.getComunidad().delFacturaFromList(f);
				f.getNotainformativa().delFacturaFromList(f);
				//Borrem de la BD
				ControladorFactura.getControladorFactura().borrarFactura(f);
				deleteFromTabla(row);
			} catch (DAOExcepcion e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void deleteFromTabla(int row){ //Borra la factura solo de la TABLA no de la BD		
			int id = Integer.parseInt(this.getValueAt(row, 0).toString());
			System.out.println("Fila: "+row+" ID:"+id);	
			numFacturas--;
			this.removeRow(row);
		}

		public Factura getFacturaPorId(int id) {
			Factura f=new Factura();
			f = ControladorFactura.getControladorFactura().getFacturaPorId(id);
			System.out.println("Factura con id: "+f.getidFactura()+" recuperada con exito");
			return f ;	
		}
		public Factura getFacturaPorPos(int row) {
			//Factura f=new Factura();
			int id = Integer.parseInt(this.getValueAt(row, 0).toString());
			//f = ControladorFactura.getControladorFactura().getFacturaPorPos(row);
			//System.out.println("Factura con id: "+f.getidFactura()+" recuperada con exito");
			return getFacturaPorId(id) ;
		}
		
		public void updateRow(int row,Factura f){			
			this.setValueAt(f.getCIF(), row, 1);					
			this.setValueAt(f.getFechaFactura(), row, 2);			
			this.setValueAt(f.getImporteSinIva(), row, 3);			
			this.setValueAt(f.getTipoIva(), row, 4);			
			this.setValueAt(f.getImporteConIva(), row, 5);			
		}
		
		@SuppressWarnings("unchecked")
		public void addToTabla(Factura f){
			Vector v=new Vector();			
			//"ID","CIF", "Num Factura", "Fecha", "Importe","%IVA", "Total"
			
			v.add(f.getidFactura());			v.add(f.getCIF());
			v.add(f.getFechaFactura());			v.add(f.getImporteSinIva());		
			v.add(f.getTipoIva());				v.add(f.getImporteConIva());				
		
			System.out.println("Factura:"+f.getidFactura());
			numFacturas++;
			System.out.println("Fila nueva: "+v);
			this.addRow(v);			
		}
			
		public void cargaFacturasComunidad(Comunidad c){
			limpiaTabla();
			ArrayList<Factura> listaFacturas = ControladorFactura.getControladorFactura().GetListaFacturas();
			System.out.println("Tamaño lista"+listaFacturas.size());
			for(Factura f:listaFacturas){						
				if(f.getComunidad().getIdComunidad()==c.getIdComunidad()) this.addToTabla(f);
			}
		}
		public void cargaFacturasComunidadPendientes(Comunidad c){
			limpiaTabla();
			ArrayList<Factura> listaFacturas = ControladorFactura.getControladorFactura().GetListaFacturas();
			System.out.println("Tamaño lista"+listaFacturas.size());
			for(Factura f:listaFacturas){						
				if(f.getComunidad().getIdComunidad()==c.getIdComunidad()){
					if(f.getNotainformativa()==null)	this.addToTabla(f);
				}
			}
		}
		public void cargaFacturasComunidadAsignadas(NotaInformativa nI){
			limpiaTabla();
			ArrayList<Factura> listaFacturas = ControladorFactura.getControladorFactura().GetListaFacturas();
			System.out.println("Tamaño lista"+listaFacturas.size());
			for(Factura f:listaFacturas){						
				if(f.getNotainformativa()!=null && f.getNotainformativa().getIdNotaInformativa()==nI.getIdNotaInformativa()){
						this.addToTabla(f);					
				}
			}
		}
		public void limpiaTabla() {
			// TODO Auto-generated method stub			
			while(numFacturas>0){
				this.removeRow(numFacturas-1);
				numFacturas--;				
			}		
		}
		
		public void setDeNotaInformativa(Factura f, NotaInformativa niAux) {
			// TODO Auto-generated method stub
			if(niAux==null){
				niAux.delFacturaFromList(f);
			}else{
				System.out.println("id nota:"+niAux.getIdNotaInformativa());
				System.out.println("importe factura"+f.getImporteConIva());
				niAux.addFacturaToList(f);
			}
			f.setNotainformativa(niAux);
			try {
				ControladorFactura.getControladorFactura().actualizarFactura(f);
			} catch (DAOExcepcion e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		public void actualizaImporteFactura(LineaFactura lfAux) {
			// TODO Auto-generated method stub
			
			float importe=lfAux.getFactura().getImporteSinIva();
			importe+=lfAux.getImporteLinea();
			lfAux.getFactura().setImporteSinIva(importe);
			lfAux.getFactura().setImporteConIva(importe*((lfAux.getFactura().getTipoIva()/100)+1));
			lfAux.getFactura().setImporteIva(importe*((lfAux.getFactura().getTipoIva()/100)));	
			try {
				ControladorFactura.getControladorFactura().actualizarFactura(lfAux.getFactura());
			} catch (DAOExcepcion e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
}

