package gui;
import negocio.*;
import accesoAdatos._controladores.*;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
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
public class VentanaConcepto extends javax.swing.JFrame {
	private JPanel jContentPane;
	private JPanel jPanel1;
	private JLabel jLabel;
	private JLabel descLabel;
	private JTextField codTextField;

	private JEditorPane descEditorPane;
	private JLabel codLabel;
	private JButton volverButton;
	private JButton guardarButton;
	private JPanel formularioPanel;
	private int rowAux;
	
	private int editMode=0;
	public static Concepto cAux = null;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				VentanaConcepto inst = new VentanaConcepto();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	public VentanaConcepto() {
		super();
		initGUI();

	}
	@SuppressWarnings("static-access")
	public VentanaConcepto(Concepto c, int row){
		super();
		this.cAux=c;
		this.rowAux=row;
		editMode=1;
		initGUI();		
		codTextField.setText(c.getCodigo());		
		descEditorPane.setText(c.getDescipcion());
		
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("Nuevo Concepto");
			{
				jContentPane = new JPanel();
				BorderLayout jPanelLayout = new BorderLayout();
				jContentPane.setLayout(jPanelLayout);
				getContentPane().add(jContentPane, BorderLayout.CENTER);
				jContentPane.setPreferredSize(new java.awt.Dimension(258, 182));
				{
					formularioPanel = new JPanel();
					GridBagLayout jPanel1Layout = new GridBagLayout();					
					
					jPanel1Layout.columnWidths = new int[] {7, 7, 7};
					jPanel1Layout.rowHeights = new int[] {7, 20, 20};
					jPanel1Layout.columnWeights = new double[] {0.005, 0.1, 0.1};
					jPanel1Layout.rowWeights = new double[] {0.1, 0.1, 0.1};
					jContentPane.add(formularioPanel, BorderLayout.CENTER);
					formularioPanel.setLayout(jPanel1Layout);
					formularioPanel.setPreferredSize(new java.awt.Dimension(369, 213));
					{
						codLabel = new JLabel();
						formularioPanel.add(codLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 10, 0, 10), 0, 0));
						codLabel.setName("codLabel");
						codLabel.setText("Código");
					}
					{
						codTextField = new JTextField();
						formularioPanel.add(codTextField, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 10), 0, 0));
						if(cAux==null) codTextField.setText("");
					}
					{
						descLabel = new JLabel();
						formularioPanel.add(descLabel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 10, 0, 10), 0, 0));
						descLabel.setText("Descripción");
					}
					{
						descEditorPane = new JEditorPane();
						formularioPanel.add(descEditorPane, new GridBagConstraints(1, 1, 1, 2, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(10, 0, 10, 10), 0, 0));
						descEditorPane.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
						descEditorPane.setSize(362, 40);
						descEditorPane.setMaximumSize(new java.awt.Dimension(362, 50));
						if(cAux==null) descEditorPane.setText("");
						
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
			this.setSize(440, 221);
			//Application.getInstance().getContext().getResourceMap(getClass()).injectComponents(getContentPane());
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	public boolean isInteger( String input ){
		   try{
		      Integer.parseInt( input );
		      return true;
		   }catch( Exception e){
		      return false;
		   }
		}
	private void guardarDatos() throws InmuebleYaExiste{
		String codigo=codTextField.getText();	String descripcion =descEditorPane.getText();
		
		if(codigo.isEmpty() || descripcion.isEmpty()){
		
			javax.swing.JOptionPane.showMessageDialog(null, "Los dos campos son obligatorios");
			
		}else{		
			if(editMode==1){
				cAux.setCodigo(codigo);
				cAux.setDescripcion(descripcion); 				
				try {
					ControladorConcepto.getControladorConcepto().actualizarConcepto(cAux);
				} catch (DAOExcepcion e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				VentanaFacturas.modeloConc.updateRow(rowAux,cAux);				
				VentanaFacturas.tablaConc.setModel(VentanaFacturas.modeloConc);
				VentanaFacturas.tablaConc.repaint();
			}else{				
				Concepto c = new Concepto();
				c.setDescripcion(descripcion);	 c.setCodigo(codigo);
				try {					
					ControladorConcepto.getControladorConcepto().nuevoConcepto(c);
					VentanaFacturas.modeloConc.addConcepto(c);
					
				} catch (Exception e) {	
					System.out.println("Error guardando el concepto");
					e.printStackTrace();
				}	
			}		
			dispose();
		}
	}		
}