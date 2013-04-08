package gui;
import negocio.*;
import accesoAdatos._controladores.*;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import excepciones.*;


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
public class VentanaLinea extends javax.swing.JFrame {
	private JPanel jContentPane;
	private JPanel jPanel1;
	private JLabel jLabel;
	private JTextField importeTextField;
	private JLabel importeLabel;
	private JTextField codTextField;

	private JLabel codLabel;
	private JButton volverButton;
	private JButton guardarButton;
	private JPanel formularioPanel;
	private int rowAux;
	
	private int editMode=0;
	public static LineaFactura lfAux = null;
	public static Factura factura = new Factura();
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VentanaLinea inst = new VentanaLinea();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	public VentanaLinea() {
		super();
		initGUI();		
	}
	@SuppressWarnings("static-access")
	public VentanaLinea(Factura fact) {
		super();
		this.factura = fact;
		initGUI();		

	}
	@SuppressWarnings("static-access")
	public VentanaLinea(LineaFactura lF, int row){
		super();
		this.lfAux=lF;
		this.rowAux=row;
		editMode=1;
		initGUI();
		
		codTextField.setText(ControladorConcepto.getControladorConcepto().getConceptoPorId(lF.getConcepto().getIdConcepto()).getCodigo());		
		importeTextField.setText(""+lF.getImporteLinea());
		
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Nueva Linea");
			{
				jContentPane = new JPanel();
				BorderLayout jPanelLayout = new BorderLayout();
				jContentPane.setLayout(jPanelLayout);
				getContentPane().add(jContentPane, BorderLayout.CENTER);
				jContentPane.setPreferredSize(new java.awt.Dimension(419, 115));
				{
					formularioPanel = new JPanel();
					GridBagLayout jPanel1Layout = new GridBagLayout();			
					
					jPanel1Layout.columnWidths = new int[] {68, 158, 68, 20};
					jPanel1Layout.rowHeights = new int[] {20};
					jPanel1Layout.columnWeights = new double[] {0.0, 0.0, 0.0, 0.1};
					jPanel1Layout.rowWeights = new double[] {0.1};
					jContentPane.add(formularioPanel, BorderLayout.CENTER);
					formularioPanel.setLayout(jPanel1Layout);
					formularioPanel.setPreferredSize(new java.awt.Dimension(419, 53));
					{
						codLabel = new JLabel();
						formularioPanel.add(codLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 10, 0, 10), 0, 0));
						codLabel.setName("codLabel");
						codLabel.setText("Código");
					}
					{
						codTextField = new JTextField();
						formularioPanel.add(codTextField, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));
						if(lfAux==null) codTextField.setText("");
					}
					{
						importeLabel = new JLabel();
						formularioPanel.add(importeLabel, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 10, 0, 10), 0, 0));
						importeLabel.setText("Importe");
					}
					{
						importeTextField = new JTextField();
						formularioPanel.add(importeTextField, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));
						if(lfAux==null) importeTextField.setText("");
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
										guardarDatos();
									} catch (InmuebleYaExiste e) {
										System.out.println("Concepto ya existe, Exception in handler");
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
								/*InAux=null;
								modelo=null;*/
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
			this.setSize(435, 140);
			//Application.getInstance().getContext().getResourceMap(getClass()).injectComponents(getContentPane());
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
		String codigo=codTextField.getText().trim();	
		Float importe = Float.parseFloat(importeTextField.getText());
		
		if(codigo.isEmpty() || importeTextField.getText().isEmpty()){		
			javax.swing.JOptionPane.showMessageDialog(null, "Los dos campos son obligatorios.");
		}else if(ControladorConcepto.getControladorConcepto().getConceptoPorCodigo(codigo)==null){
			javax.swing.JOptionPane.showMessageDialog(null, "El concepto no es correcto.");
		}else if(!isFloat(importeTextField.getText())){
			javax.swing.JOptionPane.showMessageDialog(null, "El importe debe ser un número (decimales separados por '.' )");
		}else{	
			Concepto conc = new Concepto();
			conc = ControladorConcepto.getControladorConcepto().getConceptoPorCodigo(codigo);
			if(editMode==1){
				lfAux.setConcepto(conc);
				lfAux.setImporteLinea(importe);	
				VentanaFacturas.modeloFact.actualizaImporteFactura(lfAux);
				try {
					ControladorLineaFactura.getControladorLineaFactura().actualizarLineaFactura(lfAux);
				} catch (DAOExcepcion e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				VentanaFacturas.modeloFactDet.updateRow(rowAux,lfAux);				
				VentanaFacturas.tablaFactDet.setModel(VentanaFacturas.modeloFactDet);	
				VentanaFacturas.tablaFactDet.repaint();
				VentanaFacturas.modeloFact.cargaFacturasComunidad(lfAux.getFactura().getComunidad());
			}else{				
				LineaFactura lf = new LineaFactura();
				lf.setConcepto(conc);
				lf.setImporteLinea(importe); lf.setFactura(factura);
				VentanaFacturas.modeloFact.actualizaImporteFactura(lf);
				try {	
					ControladorLineaFactura.getControladorLineaFactura().nuevoLineaFactura(lf);
					VentanaFacturas.modeloFactDet.addFactura(lf);	
					VentanaFacturas.modeloFact.cargaFacturasComunidad(lf.getFactura().getComunidad());
				} catch (Exception e) {	
					System.out.println("Error guardando la línea");
					e.printStackTrace();
				}	
			}		
			dispose();
		}
	}		
}