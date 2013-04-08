package negocio._tablas;

import negocio.*;
import accesoAdatos._controladores.ControladorFactura;
import accesoAdatos._controladores.ControladorInmueble;
import accesoAdatos._controladores.ControladorNotaInformativa;
import accesoAdatos._controladores.ControladorReciboInmueble;
import excepciones.*;

import java.util.*;

import javax.swing.table.DefaultTableModel;


@SuppressWarnings("serial")
public class ModeloTablaNotas extends DefaultTableModel {
		
		public  int numNotas;
		public ModeloTablaNotas (){	//"ID","Fecha Calculo", "Importe", "idRecibo", "Id Comunidad" 
			super(null,
					new String[] {"ID","Fecha Calculo", "Importe", "idComunidad"});		
			numNotas=0;			
		}
		@Override
	    public boolean isCellEditable(int row, int column) { //De esta forma no se pueden editar las celdas.
		       //all cells false
		       return false;
		    }
		public void addNotaInformativa (NotaInformativa nI) throws InmuebleYaExiste{
			nI.getComunidad().addNotaInformativaToList(nI);
			this.addToTabla(nI);
		}
		public int getNumNotas(){
			return numNotas;
		}
		public void borraNotaPorPos(int row){
			try {
				int id = Integer.parseInt(this.getValueAt(row, 0).toString());
				NotaInformativa ni = getNotaPorId(id);
				ni.getComunidad().delNotaInformativaFromList(ni);
				
				ControladorNotaInformativa.getControladorNotaInformativa().borrarNotaInformativa(ni);
				deleteFromTabla(row);
			} catch (DAOExcepcion e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void deleteFromTabla(int row){ //Borra la factura solo de la TABLA no de la BD		
			int id = Integer.parseInt(this.getValueAt(row, 0).toString());
			System.out.println("Fila: "+row+" ID:"+id);	
			numNotas--;
			this.removeRow(row);
		}
		public NotaInformativa getNotaPorId(int id) {
			NotaInformativa nI=new NotaInformativa();
			nI = ControladorNotaInformativa.getControladorNotaInformativa().getNotaInformativaPorId(id);
			System.out.println("Nota Informativa con id: "+nI.getIdNotaInformativa()+" recuperada con exito");
			return nI ;	
		}
		public NotaInformativa getNotaInformativaPorPos(int row) {			
			int id = Integer.parseInt(this.getValueAt(row, 0).toString());
			return getNotaPorId(id) ;
		}
		
		public void updateRow(int row,NotaInformativa nI){				
			this.setValueAt(nI.getFechaCalculo(), row, 1);			
			this.setValueAt(nI.getImporteNota(), row, 2);			
			this.setValueAt(nI.getIdRecibo(), row, 3);			
			this.setValueAt(nI.getComunidad().getIdComunidad(), row, 4);						
		}
		
		@SuppressWarnings("unchecked")
		public void addToTabla(NotaInformativa ln){
			Vector v=new Vector();			
			//"ID","Fecha Calculo", "Importe", "idRecibo", "Id Comunidad"
			v.add(ln.getIdNotaInformativa());	v.add(ln.getFechaCalculo());
			v.add(ln.getImporteNota());			v.add(ln.getIdRecibo());
			v.add(ln.getComunidad().getIdComunidad());
		
			System.out.println("Nota Informativa:"+ln.getIdNotaInformativa());
			numNotas++;
			System.out.println("Fila nueva: "+v);
			this.addRow(v);			
		}
		public void cargaNotasComunidad(Comunidad c){
			limpiaTabla();
			ArrayList<NotaInformativa> listaNotas = ControladorNotaInformativa.getControladorNotaInformativa().GetListaNotaInformativas();
			System.out.println("Tamaño lista"+listaNotas.size());
			for(NotaInformativa lN:listaNotas){						
				if(c.getIdComunidad()==lN.getComunidad().getIdComunidad()){
					this.addToTabla(lN);
				}
			}
		}
		
		private void limpiaTabla() {
			// TODO Auto-generated method stub			
			while(numNotas>0){
				this.removeRow(numNotas-1);
				numNotas--;				
			}		
		}
		
		public void calcularImporte(Comunidad cAux,NotaInformativa niAux) {
			// TODO Auto-generated method stub
			/*Calcular importe total de la nota*/
			float importe=0;
			ArrayList<Factura> listaFacturas = ControladorFactura.getControladorFactura().GetListaFacturas();
			System.out.println("Tamaño lista"+listaFacturas.size());
			for(Factura f:listaFacturas){						
				if(f.getComunidad().getIdComunidad()==cAux.getIdComunidad() && f.getNotainformativa().getIdNotaInformativa() ==niAux.getIdNotaInformativa()){
				importe+=f.getImporteConIva();
				}
			}
			niAux.setImporteNota(importe);
			System.out.println("Importe:"+importe);
			try {
				ControladorNotaInformativa.getControladorNotaInformativa().actualizarNotaInformativa(niAux);
			} catch (DAOExcepcion e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		public void generarRecibos(Comunidad cAux, NotaInformativa niAux) {
			// TODO Auto-generated method stub
			//genera y actualiza a la vez.
			/* Calculo por inmueble */
			ArrayList<Inmueble> listaInmuebles = ControladorInmueble.getControladorInmueble().GetListaInmuebles();		
			for(Inmueble f:listaInmuebles){						
				if(f.getComunidad().getIdComunidad()==cAux.getIdComunidad()){
					try {
						Inmueble iAux=f;
						ReciboInmueble ri= new ReciboInmueble();
						ri.setInmueble(iAux);
						ri.setFechaPago("");
						ri.setNotaInformativa(niAux);
						ri.setImporte(niAux.getImporteNota()*(iAux.getPorcentaje()/100));
						//ri.setFechaPago();	
						ControladorReciboInmueble.getControladorReciboInmueble().NuevoReciboInmueble(ri);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
}

