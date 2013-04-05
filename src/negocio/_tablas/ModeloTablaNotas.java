package negocio._tablas;

import negocio.*;
import accesoAdatos._controladores.ControladorNotaInformativa;
import excepciones.*;

import java.util.*;

import javax.swing.table.DefaultTableModel;


@SuppressWarnings("serial")
public class ModeloTablaNotas extends DefaultTableModel {
		
		public  int numNotas;
		public ModeloTablaNotas (){	//"ID","Fecha Calculo", "Importe", "idRecibo", "Id Comunidad" 
			super(null,
					new String[] {"ID","Fecha Calculo", "Importe", "idRecibo", "idComunidad"});		
			numNotas=0;
			/*ArrayList<NotaInformativa> listaNotas = ControladorNotaInformativa.getControladorNotaInformativa().GetListaNotaInformativas();
			System.out.println("Tamaño lista"+listaNotas.size());
			for(NotaInformativa lN:listaNotas){						
				this.addToTabla(lN);
			}*/
		}
		@Override
	    public boolean isCellEditable(int row, int column) { //De esta forma no se pueden editar las celdas.
		       //all cells false
		       return false;
		    }
		public void addNotaInformativa (NotaInformativa nI) throws InmuebleYaExiste{									
			this.addToTabla(nI);
		}
		public int getNumNotas(){
			return numNotas;
		}
		public void borraNotaPorPos(int row){
			try {
				int id = Integer.parseInt(this.getValueAt(row, 0).toString());
				System.out.println("Fila: "+row+" ID:"+id);
				NotaInformativa nI = getNotaPorId(id);
				ControladorNotaInformativa.getControladorNotaInformativa().borrarNotaInformativa(nI);
			} catch (DAOExcepcion e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		
		
}

