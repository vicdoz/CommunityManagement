package gui;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import excepciones.*;
import negocio.*;
import negocio._tablas.*;
import accesoAdatos._controladores.*;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
@SuppressWarnings("serial")
public class VentanaFacturaNueva extends javax.swing.JFrame {
	private JPanel jContentPane;
	private JPanel jPanel1;
	private JLabel jLabel;
	private JTextField tipoIvaTextField;
	private JLabel tipoIvaLabel;
	private JTextField ComTextField;
	private JLabel ComLab;
	private JLabel cifLabel;
	private JTextField cifTextField;
	private JButton volverButton;
	private JButton guardarButton;
	private JPanel formularioPanel;
	private int editMode=0;
	private int rowAux;
	public static ModeloTablaFactura modelo = null;
	public static Factura FactAux=new Factura();
	private Comunidad comunidad;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VentanaFacturaNueva inst = new VentanaFacturaNueva();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);				
			}
		});
	}

	public VentanaFacturaNueva() {
		super();
		initGUI();
	}
	public VentanaFacturaNueva(Comunidad c) {
		super();
		this.comunidad = c;
		initGUI();
	}
	
	public VentanaFacturaNueva(int row, Factura f) {
		super();
		editMode=1;
		this.comunidad = f.getComunidad();
		initGUI();
		cifTextField.setText(f.getCIF());
		tipoIvaTextField.setText(""+f.getTipoIva());
		FactAux=f;
		
		this.rowAux=row;
	}

	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Datos Inmueble");
			{
				jContentPane = new JPanel();
				BorderLayout jPanelLayout = new BorderLayout();
				jContentPane.setLayout(jPanelLayout);
				getContentPane().add(jContentPane, BorderLayout.CENTER);
				{
					formularioPanel = new JPanel();
					GridBagLayout jPanel1Layout = new GridBagLayout();
										
					jPanel1Layout.columnWidths = new int[] {7, 7, 7};
					jPanel1Layout.rowHeights = new int[] {7, 20, 20};
					jPanel1Layout.columnWeights = new double[] {0.005, 0.1, 0.1};
					jPanel1Layout.rowWeights = new double[] {0.1, 0.1, 0.1};
					jContentPane.add(formularioPanel, BorderLayout.CENTER);
					formularioPanel.setLayout(jPanel1Layout);
					formularioPanel.setPreferredSize(new java.awt.Dimension(384, 183));
					{
						cifLabel = new JLabel();
						cifLabel.setLayout(null);
						formularioPanel.add(cifLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 10, 0, 0), 0, 0));
						cifLabel.setText("CIF");
					}
					{
						cifTextField = new JTextField();
						formularioPanel.add(cifTextField, new GridBagConstraints(1, 0, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));
						if(FactAux==null)	cifTextField.setText("");
						
					}
					{
						tipoIvaLabel = new JLabel();
						formularioPanel.add(tipoIvaLabel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 10, 0, 0), 0, 0));
						tipoIvaLabel.setText("Tipo Iva");
					}
					{
						tipoIvaTextField = new JTextField();
						formularioPanel.add(tipoIvaTextField, new GridBagConstraints(-2, 1, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));
						if(FactAux==null)	tipoIvaTextField.setText("");
					}
					{
						ComLab = new JLabel();
						formularioPanel.add(ComLab, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 10, 0, 0), 0, 0));
						ComLab.setText("Comunidad");
					}
					{
						ComTextField = new JTextField();
						formularioPanel.add(ComTextField, new GridBagConstraints(1, 2, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));
						ComTextField.setText(""+comunidad.getIdComunidad());
						ComTextField.setEnabled(false);		
					}
				}
				{
					jPanel1 = new JPanel();
					jContentPane.add(jPanel1, BorderLayout.SOUTH);
					jPanel1.setPreferredSize(new java.awt.Dimension(384, 33));
					{
						guardarButton = new JButton();
						jPanel1.add(guardarButton);
						guardarButton.setText("Guardar");
						
						guardarButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
									try {
										System.out.println("guardando");
										guardarDatos();
									} catch (InmuebleYaExiste e) {
										System.out.println("Inmueble ya existe, Exception in handler");
									}
							}
						});
					}
					{
						volverButton = new JButton();
						jPanel1.add(volverButton);
						volverButton.setText("Volver");
						volverButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent evt) {
								FactAux=null;
								dispose();
							}
						});
					}
				}
				{
					jLabel = new JLabel();
					jContentPane.add(jLabel, BorderLayout.NORTH);
					jLabel.setText(" ");
				}
			}
			pack();
			this.setSize(281, 197);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	public boolean isFloat( String input ){
		   try{
		      Float.parseFloat( input );
		      return true;
		   }catch( Exception e){
		      return false;
		   }
		}
	private void guardarDatos() throws InmuebleYaExiste{		
		if(ComTextField.getText().isEmpty()	||cifTextField.getText().isEmpty() || tipoIvaTextField.getText().isEmpty()){
			javax.swing.JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
		}else if(!isFloat(tipoIvaTextField.getText())) {
			javax.swing.JOptionPane.showMessageDialog(null, "El tipo debe ser un float");
		}else{
		
			String cif = cifTextField.getText();
			int idCom = Integer.parseInt(ComTextField.getText());
			float tipoIva = Float.parseFloat(tipoIvaTextField.getText());
			
			if(ControladorComunidad.getControladorComunidad().getComunidadPorId(idCom)==null){
				javax.swing.JOptionPane.showMessageDialog(null, "Por favor introduzca un ID de Comunidad correcto");
			}else{
			
				if(editMode==1){	
					FactAux.setCIF(cif);	FactAux.setTipoIva(tipoIva);
					FactAux.setComunidad(ControladorComunidad.getControladorComunidad().getComunidadPorId(idCom));
					FactAux.setImporteConIva(FactAux.getImporteSinIva()*((tipoIva/100)+1));
					FactAux.setImporteIva(FactAux.getImporteSinIva()*(tipoIva/100));
					
					try {			
						ControladorFactura.getControladorFactura().actualizarFactura(FactAux);					
						VentanaFacturas.modeloFact.updateRow(rowAux,FactAux);		
						VentanaFacturas.modeloFact.fireTableDataChanged();
						VentanaFacturas.tablaFact.setModel(VentanaFacturas.modeloFact);									
						dispose();
						
					} catch (DAOExcepcion e) {
						e.printStackTrace();
					}
					
				}
				else{
					Factura f = new Factura();
					f.setImporteConIva((float) 0.0);
					f.setImporteSinIva((float) 0.0);
					f.setImporteIva((float)0.0);
					f.setCIF(cif);	f.setTipoIva(tipoIva);	
					
					Calendar DiaSemana= Calendar.getInstance();
					String fechaAlta=DiaSemana.get(Calendar.YEAR)+"-"+DiaSemana.get(Calendar.MONTH)+"-"+DiaSemana.get(Calendar.DAY_OF_MONTH);
					f.setFechaFactura(fechaAlta);													
					f.setComunidad(ControladorComunidad.getControladorComunidad().getComunidadPorId(
							Integer.parseInt(ComTextField.getText())));
					
					System.out.println(f.getidFactura());
					try {		
						ControladorFactura.getControladorFactura().nuevaFactura(f);
						VentanaFacturas.modeloFact.addFactura(f);
						VentanaFacturas.tablaFact.setModel(VentanaFacturas.modeloFact);
						//Abrimos la ventana de nueva linea
						VentanaFacturas.modeloFactDet.cargaLineasFactura(f);
						VentanaFacturas.jTabbedPane1.setSelectedIndex(2);
						VentanaFacturas.addLineaButton.setEnabled(true);
						VentanaLinea v=new VentanaLinea(f); 
						v.setVisible(true);	
						//Cerramos esta ventana
						dispose();
					} catch (DAOExcepcion e) {
						e.printStackTrace();
					}
				}
			}
		}
	}			
}
